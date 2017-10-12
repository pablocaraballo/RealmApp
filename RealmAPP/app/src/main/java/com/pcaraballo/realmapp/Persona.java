package com.pcaraballo.realmapp;

/**
 * Created by Pablo on 06/03/17.
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;


public class Persona extends RealmObject {

    @PrimaryKey
    private int id;
    private String nom;
    private String genere;
    private String dataNaixament;
    private int numSuerte;

    public Persona(){

    }
    public Persona(int id,String nom, String genere, String dataNaixament) {
        this.id=id;
        this.nom = nom;
        this.genere = genere;
        this.dataNaixament = dataNaixament;
        this.numSuerte= (int) (Math.random()*100);

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getGenere() {
        return genere;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
    public String getDataNaixament() {
        return dataNaixament;
    }
    public void setDataNaixament(String dataNaixament) {
        this.dataNaixament = dataNaixament;
    }

    public int getNumSuerte() {
        return numSuerte;
    }


    public int getAge() {

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dob.setTime(mdformat.parse(dataNaixament));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);

        return ageInt;

    }
    @Override
    public String toString() {
        return nom + '\t' + genere + '\t' + getAge();
    }
}
