package com.pcaraballo.realmapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pablo on 20/03/17.
 */

public class Adapter extends ArrayAdapter<Persona> {

    ArrayList<Persona>personas;



    public Adapter(Context mContext, ArrayList<Persona>listaPersonas) {
        super(mContext,0,listaPersonas);
       personas=listaPersonas;
    }

    @Override
    public Persona getItem(int position) {
        return super.getItem(position);
    }

    //PLANTILLA
    private static class holder{
        TextView idPersona;
        TextView nomPersona;
        TextView edad;
        TextView sex;
        TextView numSuerte;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Persona p=personas.get(position);
        holder h=new holder();

        //SI NO HAY CONVERTVIEW COGE ESTA PLANTILLA
        if(convertView==null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.persona_layout, parent, false);
            h.idPersona= (TextView) convertView.findViewById(R.id.id_tag);
            h.nomPersona= (TextView) convertView.findViewById(R.id.name_tag);
            h.edad= (TextView) convertView.findViewById(R.id.age_tag);
            h.sex=(TextView) convertView.findViewById(R.id.sex_tag);
            h.numSuerte=(TextView) convertView.findViewById(R.id.numSuert_tag);

            convertView.setTag(h);
        }
        else{
            h= (holder) convertView.getTag();
        }

        h.idPersona.setText("ID: "+Integer.toString(p.getId()));
        h.nomPersona.setText("Nombre: "+p.getNom());
        h.edad.setText("Edad: "+String.valueOf(p.getAge()));
        h.sex.setText("Sexo: "+p.getGenere());
        h.numSuerte.setText("Numero de la suerte: "+String.valueOf(p.getNumSuerte()));

        return convertView;
    }
}
