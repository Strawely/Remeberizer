package com.example.solom.rememberizer;

import android.content.Context;
import com.example.solom.rememberizer.CustomImageButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class GameField {

    private int width;
    private int height;
    private int leftCardsCount;
    private ArrayList<CustomImageButton> openedBtns = new ArrayList<>();
    private CustomImageButton[][] cards;
    private Context context;

    public GameField(int width, int height, Context context){
        this.width = width;
        this.height = height;
        leftCardsCount = width*height/2;
        cards = new CustomImageButton[height][width];
        this.context = context;
        ContentGenerator contentGenerator = new ContentGenerator(width,height);
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
        Toast.makeText(context, "Gongrats!!", Toast.LENGTH_LONG);
    }

    private void onCardOpening(CustomImageButton button){
        if(openedBtns.size() == 2) {
            int size = openedBtns.size()-1;
            if (compareBtns(openedBtns.get(0), openedBtns.get(1))) {
                for (int i = size; i >= 0; i--) {
                    openedBtns.get(i).setOnClickListener(null);
                    openedBtns.remove(i);
                    leftCardsCount--;
                }
            }
            else {
                for (int i = size; i >= 0; i--) {
                    openedBtns.get(i).setShown();
                    openedBtns.remove(i);
                }
            }
        }
        openedBtns.add(button);
    }

    public ImageButton[][] getCards() {
        return cards;
    }
}
