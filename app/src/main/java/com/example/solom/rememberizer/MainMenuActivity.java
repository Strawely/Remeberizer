package com.example.solom.rememberizer;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

//    okay...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onBtnStartClick(View view) {
        DialogFragment dialog = new NewGameDialogFragment();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");

    }
}
