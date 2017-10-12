package com.pcaraballo.realmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;

public class MainActivity extends AppCompatActivity implements DialogAddPersona.NewDialogListener, DialogQuery.QueryDialogListener {

    ArrayList<Persona> personas=new ArrayList<Persona>();
    ListView list;
    Adapter adapter;
    DialogAddPersona dialog=new DialogAddPersona();
    Realm realm;

    //CONTEXTMENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    //MENU DEL CONTEXTMENU
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo contextMenuInfo=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int idMenu=contextMenuInfo.position;
        switch(item.getItemId())
        {
            case R.id.editPerson:
                    updatePerson(idMenu);
                break;
            case R.id.deletePerson:
                    deletePerson(idMenu); //BORRAR PERSONA SELECCIONADA
                break;
        }

        return super.onContextItemSelected(item);
    }

    //MENU DE OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    //QUE HACER EN CADA OPCION ESCOGIDA
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addPerson:
                new DialogAddPersona().show(getSupportFragmentManager(),"DialogPersona");
            break;
            case R.id.queryPerson:
                new DialogQuery().show(getSupportFragmentManager(),"DialogQuery");
                break;
            case R.id.inicio:
                updateDB();
                break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        list=(ListView) findViewById(R.id.listview);
        adapter=new Adapter(this,personas);
        list.setAdapter(adapter);

        registerForContextMenu(list); //LINEA NECESARIA PARA EL CONTEXTMENU, LE INDICAS CON QUÉ ITEM INTERACTUA

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("person.realm")
                .schemaVersion(0)
                .build();
        try {
            Realm.migrateRealm(config, new Migration());
        } catch (FileNotFoundException ignored) {

        }
        realm = Realm.getInstance(config);

        updateDB();

    }
    //LISTENER CORRESPONDIENTE AL DIALOG DE LAS CONSULTAS
    @Override
    public void onDialogPositiveClick(String nom, String sexo) {
        Persona p= new Persona();
        p.setNom(nom);
        p.setGenere(sexo);

        if(p.getGenere()=="Hombre" || p.getGenere()=="Mujer")
            querySex(p.getGenere());
        else if(p.getGenere()==null)
            queryName(p.getNom());
    }

    //LISTENER CORRESPONDIENTE AL DIALOG DE CREACION DE PERSONAS
    @Override
    public void onDialogPositiveClick(int id, String nom, String edad, String sexo) {
        Persona p=new Persona(id,nom,sexo,edad);
        createPerson(p);
        updateDB();
    }

    //AÑADE PERSONA A LA DB Y A LA LISTA DE PERSONAS
    public void createPerson(Persona p){
        //Realm realm= Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(p);
        realm.commitTransaction();
    }

    //DESCARGA LA LISTA DE PERSONAS DE LA DB Y LA METE EN EL ARRAYLIST
    public void updateDB(){
        //Realm realm= Realm.getDefaultInstance();
        realm.beginTransaction();
        personas.removeAll(personas);
        RealmResults<Persona> query=realm.where(Persona.class).findAll();
        for(Persona p: query){
           personas.add(p);
           adapter.notifyDataSetChanged();
        }
        realm.commitTransaction();
    }

    //BORRA UNA PERSONA SELECCIONADA ATRAVES DE UN CONTEXT MENU
    public void deletePerson(int idMenu){
        Persona p=personas.get(idMenu);
        boolean borrado;
        //Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Persona> query=realm.where(Persona.class).equalTo("id", p.getId()).findAll();
        query.deleteFromRealm(0);
        realm.commitTransaction();
       Toast.makeText(getApplicationContext(),"Persona borrada", Toast.LENGTH_SHORT).show();

        borrado=true;
        if(borrado){
            personas.remove(idMenu);
            adapter.notifyDataSetChanged();
        }
    }

    //ACTUALIZA LA LISTA DE PERSONAS
    public void updatePerson(int idMenu){

        Persona p=personas.get(idMenu);
        dialog.setPersona(p);
        dialog.show(getSupportFragmentManager(),"DialogPersona");
        //Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(p);
        realm.commitTransaction();
    }

    //MUESTRA TODAS LAS PERSONAS DE UN GENERO
    public void querySex(String sexo){
        personas.removeAll(personas);
        //Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Persona> query=realm.where(Persona.class).equalTo("genere", sexo).findAll();
        for(Persona p: query){
            personas.add(p);
            adapter.notifyDataSetChanged();
        }
        realm.commitTransaction();
    }

    //MUESTRA TODAS LAS PERSONAS CON UN NOMBRE
    public void queryName(String name){
        personas.removeAll(personas);
        //Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Persona> query=realm.where(Persona.class).contains("nom", name).findAll();
        for(Persona p: query){
            personas.add(p);
            adapter.notifyDataSetChanged();
        }
        realm.commitTransaction();
    }

}
