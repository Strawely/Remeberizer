package com.example.solom.rememberizer;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;

public class GameField implements Subject {

    private int leftCardsCount;

    private ArrayList<CustomImageButton> openedBtns = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private CustomImageButton[][] cards;
    private Context context;

    private Timer timer = new Timer();

    public GameField(int width, int height, Context context){
        leftCardsCount = width*height/2;
        cards = new CustomImageButton[height][width];
        this.context = context;
        ContentGenerator contentGenerator = new ContentGenerator(width, height);

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                cards[i][j] = InitializeButton(contentGenerator);
            }
        }
    }

    private CustomImageButton InitializeButton(ContentGenerator contentGenerator){

        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        CustomImageButton button = new CustomImageButton(context);
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getClass().equals(CustomImageButton.class)){

                    CustomImageButton view = ((CustomImageButton) v);
                    if (!view.isShown()){
                        view.setShown();
                        onCardOpening(view);
                    }
                }
                if(checkWinner()){
                    onWinAction();
                }
            }
        });
        button.setContent(contentGenerator.getRandomizedContent());
        return button;
    }



    private boolean compareBtns(CustomImageButton btn1, CustomImageButton btn2){
        return btn1.getContent() == btn2.getContent();
    }

    private boolean checkWinner(){
        return leftCardsCount==0;
    }

    private void onWinAction(){
        Toast.makeText(context, "Gongrats!!", Toast.LENGTH_LONG).show();
        notifyObservers();
    }

    private void onCardOpening(CustomImageButton button){
        openedBtns.add(button);
        if(openedBtns.size() == 2) {
            if (compareBtns(openedBtns.get(0), openedBtns.get(1))) {
                for (int i = openedBtns.size()-1; i >= 0; i--) {
                    openedBtns.get(i).setOnClickListener(null);
                    openedBtns.remove(i);
                }
                leftCardsCount--;
            }
            else {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = openedBtns.size() - 1; i >= 0; i--) {
                            openedBtns.get(i).setShown();
                            openedBtns.remove(i);
                        }
                    }
                }, 500);


            }

        }
    }

    public ImageButton[][] getCards() {
        return cards;
    }

    @Override
    public void registerObserver(Observer observer) {
        if(observers != null) {
            observers.add(observer);
        }
        else {
            observers = new ArrayList<>();
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        if(observers != null) {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).update();
            }
        }
    }
}
