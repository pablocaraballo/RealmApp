package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonaRealmProxy extends com.pcaraballo.realmapp.Persona
    implements RealmObjectProxy, PersonaRealmProxyInterface {

    static final class PersonaColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long nomIndex;
        public long genereIndex;
        public long dataNaixamentIndex;
        public long numSuerteIndex;

        PersonaColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.idIndex = getValidColumnIndex(path, table, "Persona", "id");
            indicesMap.put("id", this.idIndex);
            this.nomIndex = getValidColumnIndex(path, table, "Persona", "nom");
            indicesMap.put("nom", this.nomIndex);
            this.genereIndex = getValidColumnIndex(path, table, "Persona", "genere");
            indicesMap.put("genere", this.genereIndex);
            this.dataNaixamentIndex = getValidColumnIndex(path, table, "Persona", "dataNaixament");
            indicesMap.put("dataNaixament", this.dataNaixamentIndex);
            this.numSuerteIndex = getValidColumnIndex(path, table, "Persona", "numSuerte");
            indicesMap.put("numSuerte", this.numSuerteIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final PersonaColumnInfo otherInfo = (PersonaColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.nomIndex = otherInfo.nomIndex;
            this.genereIndex = otherInfo.genereIndex;
            this.dataNaixamentIndex = otherInfo.dataNaixamentIndex;
            this.numSuerteIndex = otherInfo.numSuerteIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final PersonaColumnInfo clone() {
            return (PersonaColumnInfo) super.clone();
        }

    }
    private PersonaColumnInfo columnInfo;
    private ProxyState<com.pcaraballo.realmapp.Persona> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("nom");
        fieldNames.add("genere");
        fieldNames.add("dataNaixament");
        fieldNames.add("numSuerte");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PersonaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PersonaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.pcaraballo.realmapp.Persona>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$nom() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nomIndex);
    }

    public void realmSet$nom(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nomIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nomIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nomIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nomIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$genere() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genereIndex);
    }

    public void realmSet$genere(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genereIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genereIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genereIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genereIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$dataNaixament() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dataNaixamentIndex);
    }

    public void realmSet$dataNaixament(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dataNaixamentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dataNaixamentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dataNaixamentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dataNaixamentIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$numSuerte() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numSuerteIndex);
    }

    public void realmSet$numSuerte(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numSuerteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numSuerteIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Persona")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Persona");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("nom", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("genere", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("dataNaixament", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("numSuerte", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Persona");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Persona")) {
            Table table = sharedRealm.getTable("class_Persona");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "nom", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "genere", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "dataNaixament", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "numSuerte", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_Persona");
    }

    public static PersonaColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Persona")) {
            Table table = sharedRealm.getTable("class_Persona");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final PersonaColumnInfo columnInfo = new PersonaColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
            }

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != Table.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("nom")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nom' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nom") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nom' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nomIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nom' is required. Either set @Required to field 'nom' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("genere")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'genere' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("genere") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'genere' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.genereIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'genere' is required. Either set @Required to field 'genere' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("dataNaixament")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dataNaixament' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("dataNaixament") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dataNaixament' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.dataNaixamentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dataNaixament' is required. Either set @Required to field 'dataNaixament' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("numSuerte")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numSuerte' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("numSuerte") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'numSuerte' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.numSuerteIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numSuerte' does support null values in the existing Realm file. Use corresponding boxed type for field 'numSuerte' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Persona' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Persona";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.pcaraballo.realmapp.Persona createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.pcaraballo.realmapp.Persona obj = null;
        if (update) {
            Table table = realm.getTable(com.pcaraballo.realmapp.Persona.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.pcaraballo.realmapp.Persona.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PersonaRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.PersonaRealmProxy) realm.createObjectInternal(com.pcaraballo.realmapp.Persona.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PersonaRealmProxy) realm.createObjectInternal(com.pcaraballo.realmapp.Persona.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("nom")) {
            if (json.isNull("nom")) {
                ((PersonaRealmProxyInterface) obj).realmSet$nom(null);
            } else {
                ((PersonaRealmProxyInterface) obj).realmSet$nom((String) json.getString("nom"));
            }
        }
        if (json.has("genere")) {
            if (json.isNull("genere")) {
                ((PersonaRealmProxyInterface) obj).realmSet$genere(null);
            } else {
                ((PersonaRealmProxyInterface) obj).realmSet$genere((String) json.getString("genere"));
            }
        }
        if (json.has("dataNaixament")) {
            if (json.isNull("dataNaixament")) {
                ((PersonaRealmProxyInterface) obj).realmSet$dataNaixament(null);
            } else {
                ((PersonaRealmProxyInterface) obj).realmSet$dataNaixament((String) json.getString("dataNaixament"));
            }
        }
        if (json.has("numSuerte")) {
            if (json.isNull("numSuerte")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numSuerte' to null.");
            } else {
                ((PersonaRealmProxyInterface) obj).realmSet$numSuerte((int) json.getInt("numSuerte"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.pcaraballo.realmapp.Persona createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.pcaraballo.realmapp.Persona obj = new com.pcaraballo.realmapp.Persona();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((PersonaRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("nom")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PersonaRealmProxyInterface) obj).realmSet$nom(null);
                } else {
                    ((PersonaRealmProxyInterface) obj).realmSet$nom((String) reader.nextString());
                }
            } else if (name.equals("genere")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PersonaRealmProxyInterface) obj).realmSet$genere(null);
                } else {
                    ((PersonaRealmProxyInterface) obj).realmSet$genere((String) reader.nextString());
                }
            } else if (name.equals("dataNaixament")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PersonaRealmProxyInterface) obj).realmSet$dataNaixament(null);
                } else {
                    ((PersonaRealmProxyInterface) obj).realmSet$dataNaixament((String) reader.nextString());
                }
            } else if (name.equals("numSuerte")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numSuerte' to null.");
                } else {
                    ((PersonaRealmProxyInterface) obj).realmSet$numSuerte((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.pcaraballo.realmapp.Persona copyOrUpdate(Realm realm, com.pcaraballo.realmapp.Persona object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.pcaraballo.realmapp.Persona) cachedRealmObject;
        } else {
            com.pcaraballo.realmapp.Persona realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.pcaraballo.realmapp.Persona.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((PersonaRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.pcaraballo.realmapp.Persona.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PersonaRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.pcaraballo.realmapp.Persona copy(Realm realm, com.pcaraballo.realmapp.Persona newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.pcaraballo.realmapp.Persona) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.pcaraballo.realmapp.Persona realmObject = realm.createObjectInternal(com.pcaraballo.realmapp.Persona.class, ((PersonaRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PersonaRealmProxyInterface) realmObject).realmSet$nom(((PersonaRealmProxyInterface) newObject).realmGet$nom());
            ((PersonaRealmProxyInterface) realmObject).realmSet$genere(((PersonaRealmProxyInterface) newObject).realmGet$genere());
            ((PersonaRealmProxyInterface) realmObject).realmSet$dataNaixament(((PersonaRealmProxyInterface) newObject).realmGet$dataNaixament());
            ((PersonaRealmProxyInterface) realmObject).realmSet$numSuerte(((PersonaRealmProxyInterface) newObject).realmGet$numSuerte());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.pcaraballo.realmapp.Persona object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.pcaraballo.realmapp.Persona.class);
        long tableNativePtr = table.getNativeTablePointer();
        PersonaColumnInfo columnInfo = (PersonaColumnInfo) realm.schema.getColumnInfo(com.pcaraballo.realmapp.Persona.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((PersonaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PersonaRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((PersonaRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$nom = ((PersonaRealmProxyInterface)object).realmGet$nom();
        if (realmGet$nom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nomIndex, rowIndex, realmGet$nom, false);
        }
        String realmGet$genere = ((PersonaRealmProxyInterface)object).realmGet$genere();
        if (realmGet$genere != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genereIndex, rowIndex, realmGet$genere, false);
        }
        String realmGet$dataNaixament = ((PersonaRealmProxyInterface)object).realmGet$dataNaixament();
        if (realmGet$dataNaixament != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dataNaixamentIndex, rowIndex, realmGet$dataNaixament, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.numSuerteIndex, rowIndex, ((PersonaRealmProxyInterface)object).realmGet$numSuerte(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pcaraballo.realmapp.Persona.class);
        long tableNativePtr = table.getNativeTablePointer();
        PersonaColumnInfo columnInfo = (PersonaColumnInfo) realm.schema.getColumnInfo(com.pcaraballo.realmapp.Persona.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.pcaraballo.realmapp.Persona object = null;
        while (objects.hasNext()) {
            object = (com.pcaraballo.realmapp.Persona) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((PersonaRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PersonaRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((PersonaRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$nom = ((PersonaRealmProxyInterface)object).realmGet$nom();
                if (realmGet$nom != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nomIndex, rowIndex, realmGet$nom, false);
                }
                String realmGet$genere = ((PersonaRealmProxyInterface)object).realmGet$genere();
                if (realmGet$genere != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genereIndex, rowIndex, realmGet$genere, false);
                }
                String realmGet$dataNaixament = ((PersonaRealmProxyInterface)object).realmGet$dataNaixament();
                if (realmGet$dataNaixament != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dataNaixamentIndex, rowIndex, realmGet$dataNaixament, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.numSuerteIndex, rowIndex, ((PersonaRealmProxyInterface)object).realmGet$numSuerte(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.pcaraballo.realmapp.Persona object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.pcaraballo.realmapp.Persona.class);
        long tableNativePtr = table.getNativeTablePointer();
        PersonaColumnInfo columnInfo = (PersonaColumnInfo) realm.schema.getColumnInfo(com.pcaraballo.realmapp.Persona.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((PersonaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PersonaRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((PersonaRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$nom = ((PersonaRealmProxyInterface)object).realmGet$nom();
        if (realmGet$nom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nomIndex, rowIndex, realmGet$nom, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nomIndex, rowIndex, false);
        }
        String realmGet$genere = ((PersonaRealmProxyInterface)object).realmGet$genere();
        if (realmGet$genere != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genereIndex, rowIndex, realmGet$genere, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genereIndex, rowIndex, false);
        }
        String realmGet$dataNaixament = ((PersonaRealmProxyInterface)object).realmGet$dataNaixament();
        if (realmGet$dataNaixament != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dataNaixamentIndex, rowIndex, realmGet$dataNaixament, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dataNaixamentIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.numSuerteIndex, rowIndex, ((PersonaRealmProxyInterface)object).realmGet$numSuerte(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pcaraballo.realmapp.Persona.class);
        long tableNativePtr = table.getNativeTablePointer();
        PersonaColumnInfo columnInfo = (PersonaColumnInfo) realm.schema.getColumnInfo(com.pcaraballo.realmapp.Persona.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.pcaraballo.realmapp.Persona object = null;
        while (objects.hasNext()) {
            object = (com.pcaraballo.realmapp.Persona) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((PersonaRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PersonaRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((PersonaRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$nom = ((PersonaRealmProxyInterface)object).realmGet$nom();
                if (realmGet$nom != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nomIndex, rowIndex, realmGet$nom, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nomIndex, rowIndex, false);
                }
                String realmGet$genere = ((PersonaRealmProxyInterface)object).realmGet$genere();
                if (realmGet$genere != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genereIndex, rowIndex, realmGet$genere, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.genereIndex, rowIndex, false);
                }
                String realmGet$dataNaixament = ((PersonaRealmProxyInterface)object).realmGet$dataNaixament();
                if (realmGet$dataNaixament != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dataNaixamentIndex, rowIndex, realmGet$dataNaixament, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dataNaixamentIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.numSuerteIndex, rowIndex, ((PersonaRealmProxyInterface)object).realmGet$numSuerte(), false);
            }
        }
    }

    public static com.pcaraballo.realmapp.Persona createDetachedCopy(com.pcaraballo.realmapp.Persona realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.pcaraballo.realmapp.Persona unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.pcaraballo.realmapp.Persona)cachedObject.object;
            } else {
                unmanagedObject = (com.pcaraballo.realmapp.Persona)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.pcaraballo.realmapp.Persona();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PersonaRealmProxyInterface) unmanagedObject).realmSet$id(((PersonaRealmProxyInterface) realmObject).realmGet$id());
        ((PersonaRealmProxyInterface) unmanagedObject).realmSet$nom(((PersonaRealmProxyInterface) realmObject).realmGet$nom());
        ((PersonaRealmProxyInterface) unmanagedObject).realmSet$genere(((PersonaRealmProxyInterface) realmObject).realmGet$genere());
        ((PersonaRealmProxyInterface) unmanagedObject).realmSet$dataNaixament(((PersonaRealmProxyInterface) realmObject).realmGet$dataNaixament());
        ((PersonaRealmProxyInterface) unmanagedObject).realmSet$numSuerte(((PersonaRealmProxyInterface) realmObject).realmGet$numSuerte());
        return unmanagedObject;
    }

    static com.pcaraballo.realmapp.Persona update(Realm realm, com.pcaraballo.realmapp.Persona realmObject, com.pcaraballo.realmapp.Persona newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PersonaRealmProxyInterface) realmObject).realmSet$nom(((PersonaRealmProxyInterface) newObject).realmGet$nom());
        ((PersonaRealmProxyInterface) realmObject).realmSet$genere(((PersonaRealmProxyInterface) newObject).realmGet$genere());
        ((PersonaRealmProxyInterface) realmObject).realmSet$dataNaixament(((PersonaRealmProxyInterface) newObject).realmGet$dataNaixament());
        ((PersonaRealmProxyInterface) realmObject).realmSet$numSuerte(((PersonaRealmProxyInterface) newObject).realmGet$numSuerte());
        return realmObject;
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaRealmProxy aPersona = (PersonaRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPersona.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPersona.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPersona.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
