package com.example.solom.rememberizer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.solom.rememberizer.list.Node;
import com.example.solom.rememberizer.list.ScoreList;
import com.example.solom.rememberizer.list.ScoreNode;

public class WinnerDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_winner, null);
        builder.setView(view);

        return builder.create();
    }

}
