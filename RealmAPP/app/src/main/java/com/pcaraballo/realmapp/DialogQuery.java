package com.pcaraballo.realmapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by tarda on 28/03/17.
 */

public class DialogQuery extends DialogFragment {

    public EditText nom;
    public EditText MaxMinage;
    public EditText beetwenAges;
    public RadioButton home;
    public RadioButton dona;
    public String gen;

    public interface QueryDialogListener {
        void onDialogPositiveClick(String nom,String sexo);
    }

    QueryDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_query, null);
        //ENLAZAMMOS LAS VARIABLES CON EL XML
        nom=(EditText) view.findViewById(R.id.querynom);
        home=(RadioButton) view.findViewById(R.id.queryhombre);
        dona=(RadioButton) view.findViewById(R.id.querymujer);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.QueryPerson)
                .setView(view)
                .setPositiveButton("Consultar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        if(home.isChecked())
                            gen="Hombre";
                        else if(dona.isChecked())
                            gen="Mujer";

                       mListener.onDialogPositiveClick(nom.getText().toString(),gen);
                    }
                });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        try {
            mListener = (QueryDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NewTodoDialogListener");
        }
    }
}
