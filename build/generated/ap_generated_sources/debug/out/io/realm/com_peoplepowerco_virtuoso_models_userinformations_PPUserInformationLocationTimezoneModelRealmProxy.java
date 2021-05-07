package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface {

    static final class PPUserInformationLocationTimezoneModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long locationIdIndex;
        long idIndex;
        long nOffsetIndex;
        long bDstIndex;
        long sNameIndex;

        PPUserInformationLocationTimezoneModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationLocationTimezoneModel");
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nOffsetIndex = addColumnDetails("nOffset", "nOffset", objectSchemaInfo);
            this.bDstIndex = addColumnDetails("bDst", "bDst", objectSchemaInfo);
            this.sNameIndex = addColumnDetails("sName", "sName", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationLocationTimezoneModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationLocationTimezoneModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationLocationTimezoneModelColumnInfo src = (PPUserInformationLocationTimezoneModelColumnInfo) rawSrc;
            final PPUserInformationLocationTimezoneModelColumnInfo dst = (PPUserInformationLocationTimezoneModelColumnInfo) rawDst;
            dst.locationIdIndex = src.locationIdIndex;
            dst.idIndex = src.idIndex;
            dst.nOffsetIndex = src.nOffsetIndex;
            dst.bDstIndex = src.bDstIndex;
            dst.sNameIndex = src.sNameIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationLocationTimezoneModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel> proxyState;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationLocationTimezoneModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$locationId() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.locationIdIndex);
    }

    @Override
    public void realmSet$locationId(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'locationId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nOffset() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nOffsetIndex);
    }

    @Override
    public void realmSet$nOffset(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nOffsetIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nOffsetIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$bDst() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.bDstIndex);
    }

    @Override
    public void realmSet$bDst(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.bDstIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.bDstIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sNameIndex);
    }

    @Override
    public void realmSet$sName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sNameIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationLocationTimezoneModel", 5, 0);
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nOffset", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("bDst", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationLocationTimezoneModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationLocationTimezoneModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationLocationTimezoneModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationLocationTimezoneModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
            PPUserInformationLocationTimezoneModelColumnInfo columnInfo = (PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
            long pkColumnIndex = columnInfo.locationIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("locationId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("locationId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("locationId")) {
                if (json.isNull("locationId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class, json.getLong("locationId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'locationId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("nOffset")) {
            if (json.isNull("nOffset")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nOffset' to null.");
            } else {
                objProxy.realmSet$nOffset((int) json.getInt("nOffset"));
            }
        }
        if (json.has("bDst")) {
            if (json.isNull("bDst")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bDst' to null.");
            } else {
                objProxy.realmSet$bDst((boolean) json.getBoolean("bDst"));
            }
        }
        if (json.has("sName")) {
            if (json.isNull("sName")) {
                objProxy.realmSet$sName(null);
            } else {
                objProxy.realmSet$sName((String) json.getString("sName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("locationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationId((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("nOffset")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nOffset((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nOffset' to null.");
                }
            } else if (name.equals("bDst")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bDst((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bDst' to null.");
                }
            } else if (name.equals("sName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sName(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'locationId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel copyOrUpdate(Realm realm, PPUserInformationLocationTimezoneModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
            long pkColumnIndex = columnInfo.locationIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel copy(Realm realm, PPUserInformationLocationTimezoneModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.nOffsetIndex, realmObjectSource.realmGet$nOffset());
        builder.addBoolean(columnInfo.bDstIndex, realmObjectSource.realmGet$bDst());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationTimezoneModelColumnInfo columnInfo = (PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nOffsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$nOffset(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bDstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$bDst(), false);
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationTimezoneModelColumnInfo columnInfo = (PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nOffsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$nOffset(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bDstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$bDst(), false);
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationTimezoneModelColumnInfo columnInfo = (PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nOffsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$nOffset(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bDstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$bDst(), false);
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationTimezoneModelColumnInfo columnInfo = (PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$locationId());
            }
            cache.put(object, rowIndex);
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nOffsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$nOffset(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bDstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$bDst(), false);
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nOffset(realmSource.realmGet$nOffset());
        unmanagedCopy.realmSet$bDst(realmSource.realmGet$bDst());
        unmanagedCopy.realmSet$sName(realmSource.realmGet$sName());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel update(Realm realm, PPUserInformationLocationTimezoneModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel realmObject, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.nOffsetIndex, realmObjectSource.realmGet$nOffset());
        builder.addBoolean(columnInfo.bDstIndex, realmObjectSource.realmGet$bDst());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationLocationTimezoneModel = proxy[");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nOffset:");
        stringBuilder.append(realmGet$nOffset());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bDst:");
        stringBuilder.append(realmGet$bDst());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sName:");
        stringBuilder.append(realmGet$sName() != null ? realmGet$sName() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy aPPUserInformationLocationTimezoneModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationLocationTimezoneModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationLocationTimezoneModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationLocationTimezoneModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
