package com.example.solom.rememberizer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class NewGameDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstnceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_new_game, null);

        builder.setView(view);

        Button btnDefault = (Button) view.findViewById(R.id.btnDefault);
        Button btnStart = (Button) view.findViewById(R.id.btnStart);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);

        final Context context = this.getContext();
        final DialogFragment thisDialog = this;

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameplayActivity.class);
                EditText editTextWidth = (EditText) view.findViewById(R.id.widthEditText);
                EditText editTextHeight = (EditText) view.findViewById(R.id.heightEditText);

                String width = editTextWidth.getText().toString();
                String height = editTextHeight.getText().toString();


                intent.putExtra("width", Integer.valueOf(width));
                intent.putExtra("height", Integer.valueOf(height));
                thisDialog.dismiss();
                startActivity(intent);
            }
        });

        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextWidth = (EditText)view.findViewById(R.id.widthEditText);
                EditText editTextHeight = (EditText)view.findViewById(R.id.heightEditText);
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.radioBtnSet1);

                editTextWidth.setText("2");
                editTextHeight.setText("3");
                radioButton.setChecked(true);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisDialog.dismiss();
            }
        });

        return builder.create();
    }
}

