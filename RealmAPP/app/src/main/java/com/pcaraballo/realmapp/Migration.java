package com.pcaraballo.realmapp;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by Pablo Caraballo on 31/03/17.
 */

public class Migration implements RealmMigration {


    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema=realm.getSchema();
        Log.v("MIGRATION:",oldVersion+"");

        if (oldVersion == 0) {
            Log.v("MIGRATION:","VERSION1");
            RealmObjectSchema personaSchema = schema.get("Persona");
            personaSchema
                    .addField("numSuerte", int.class)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set("numSuerte", (int)(Math.random()*100));
                        }
                    }).addIndex("numSuerte");
            oldVersion++;
        }
    }
}
