package com.pcaraballo.realmapp;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * Created by Pablo on 14/03/17.
 */

public class DialogAddPersona extends DialogFragment {

    public EditText ide;
    public EditText nom;
    public EditText edad;
    public RadioButton home;
    public RadioButton dona;
    public String gen;
    public Persona p;

    public interface NewDialogListener {
        void onDialogPositiveClick(int id,String nom,String edad, String sexo);
    }

    NewDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialogaddpersona, null);
        //ENLAZAMMOS LAS VARIABLES CON EL XML
        ide=(EditText) view.findViewById(R.id.id);
        nom=(EditText) view.findViewById(R.id.nom);
        edad= (EditText) view.findViewById(R.id.fecha);
        home=(RadioButton) view.findViewById(R.id.hombre);
        dona=(RadioButton) view.findViewById(R.id.mujer);

        //SI LA PERSONA NO ES NULA RELLENA LOS CAMPOS CON LOS DATOS DE LA PERSONA
        if(p!=null) {
            ide.setText(Integer.toString(p.getId()));
            nom.setText(p.getNom());
            edad.setText(p.getDataNaixament());
            if(p.getGenere().contains("Hombre"))
                home.setChecked(true);
            if(p.getGenere().contains("Mujer"))
                dona.setChecked(true);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                   builder.setTitle(R.string.DialogPerson)
                    .setView(view)
                    .setPositiveButton((p==null ? "Crear" : "Editar"), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            if(home.isChecked())
                                gen="Hombre";
                            else if(dona.isChecked())
                                gen="Mujer";

                            mListener.onDialogPositiveClick(Integer.parseInt(ide.getText().toString()),nom.getText().toString(),edad.getText().toString(),gen);
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
            mListener = (NewDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NewTodoDialogListener");
        }
    }

    public void setPersona(Persona p){
        this.p=p;
    }
}
