package com.example.solom.rememberizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class GameplayActivity extends AppCompatActivity {

    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        width = intent.getIntExtra("width", 2);
        height = intent.getIntExtra("height", 2);
        setContentView(R.layout.activity_gameplay);
        GameField gameField = new GameField(height, width, this);
        showCards(gameField);
    }

    private void showCards(GameField gameField){
        ImageButton[][] cards = gameField.getCards();
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_gameplay_layout);
        LinearLayout[] linearLayouts = new LinearLayout[height];
        for (int i = 0; i < height; i++) {
            linearLayouts[i] = new LinearLayout(this);
            createLinearLayout(linearLayouts[i]);
            for (int j = 0; j < width; j++) {
                linearLayouts[i].addView(cards[j][i]);
            }
            layout.addView(linearLayouts[i]);
        }


    }

    private void createLinearLayout(LinearLayout linearLayout){
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(layoutParams);
    }
}
