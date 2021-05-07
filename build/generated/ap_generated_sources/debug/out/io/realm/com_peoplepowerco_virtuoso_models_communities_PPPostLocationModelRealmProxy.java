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
public class com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface {

    static final class PPPostLocationModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long nameIndex;
        long latitudeIndex;
        long longitudeIndex;
        long timezoneIndex;

        PPPostLocationModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostLocationModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.latitudeIndex = addColumnDetails("latitude", "latitude", objectSchemaInfo);
            this.longitudeIndex = addColumnDetails("longitude", "longitude", objectSchemaInfo);
            this.timezoneIndex = addColumnDetails("timezone", "timezone", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostLocationModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostLocationModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostLocationModelColumnInfo src = (PPPostLocationModelColumnInfo) rawSrc;
            final PPPostLocationModelColumnInfo dst = (PPPostLocationModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.latitudeIndex = src.latitudeIndex;
            dst.longitudeIndex = src.longitudeIndex;
            dst.timezoneIndex = src.timezoneIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostLocationModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostLocationModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$latitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.latitudeIndex);
    }

    @Override
    public void realmSet$latitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.latitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.latitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.latitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.latitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$longitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.longitudeIndex);
    }

    @Override
    public void realmSet$longitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.longitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.longitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.longitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.longitudeIndex, value);
    }

    @Override
    public com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel realmGet$timezone() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.timezoneIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class, proxyState.getRow$realm().getLink(columnInfo.timezoneIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$timezone(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("timezone")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.timezoneIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.timezoneIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.timezoneIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.timezoneIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostLocationModel", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("latitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("longitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("timezone", RealmFieldType.OBJECT, "PPPostTimezoneModel");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostLocationModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostLocationModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostLocationModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostLocationModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
            PPPostLocationModelColumnInfo columnInfo = (PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("timezone")) {
                excludeFields.add("timezone");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                objProxy.realmSet$latitude(null);
            } else {
                objProxy.realmSet$latitude((String) json.getString("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                objProxy.realmSet$longitude(null);
            } else {
                objProxy.realmSet$longitude((String) json.getString("longitude"));
            }
        }
        if (json.has("timezone")) {
            if (json.isNull("timezone")) {
                objProxy.realmSet$timezone(null);
            } else {
                com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("timezone"), update);
                objProxy.realmSet$timezone(timezoneObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitude((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$latitude(null);
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitude((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$longitude(null);
                }
            } else if (name.equals("timezone")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$timezone(null);
                } else {
                    com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$timezone(timezoneObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel copyOrUpdate(Realm realm, PPPostLocationModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel copy(Realm realm, PPPostLocationModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.latitudeIndex, realmObjectSource.realmGet$latitude());
        builder.addString(columnInfo.longitudeIndex, realmObjectSource.realmGet$longitude());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = realmObjectSource.realmGet$timezone();
        if (timezoneObj == null) {
            realmObjectCopy.realmSet$timezone(null);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel cachetimezone = (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) cache.get(timezoneObj);
            if (cachetimezone != null) {
                realmObjectCopy.realmSet$timezone(cachetimezone);
            } else {
                realmObjectCopy.realmSet$timezone(com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class), timezoneObj, update, cache, flags));
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostLocationModelColumnInfo columnInfo = (PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$latitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        }
        String realmGet$longitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$timezone();
        if (timezoneObj != null) {
            Long cachetimezone = cache.get(timezoneObj);
            if (cachetimezone == null) {
                cachetimezone = com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insert(realm, timezoneObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.timezoneIndex, rowIndex, cachetimezone, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostLocationModelColumnInfo columnInfo = (PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$latitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$latitude();
            if (realmGet$latitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
            }
            String realmGet$longitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$longitude();
            if (realmGet$longitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$timezone();
            if (timezoneObj != null) {
                Long cachetimezone = cache.get(timezoneObj);
                if (cachetimezone == null) {
                    cachetimezone = com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insert(realm, timezoneObj, cache);
                }
                table.setLink(columnInfo.timezoneIndex, rowIndex, cachetimezone, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostLocationModelColumnInfo columnInfo = (PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$latitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
        }
        String realmGet$longitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$timezone();
        if (timezoneObj != null) {
            Long cachetimezone = cache.get(timezoneObj);
            if (cachetimezone == null) {
                cachetimezone = com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insertOrUpdate(realm, timezoneObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.timezoneIndex, rowIndex, cachetimezone, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.timezoneIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostLocationModelColumnInfo columnInfo = (PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$latitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$latitude();
            if (realmGet$latitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
            }
            String realmGet$longitude = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$longitude();
            if (realmGet$longitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) object).realmGet$timezone();
            if (timezoneObj != null) {
                Long cachetimezone = cache.get(timezoneObj);
                if (cachetimezone == null) {
                    cachetimezone = com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insertOrUpdate(realm, timezoneObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.timezoneIndex, rowIndex, cachetimezone, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.timezoneIndex, rowIndex);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$latitude(realmSource.realmGet$latitude());
        unmanagedCopy.realmSet$longitude(realmSource.realmGet$longitude());

        // Deep copy of timezone
        unmanagedCopy.realmSet$timezone(com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createDetachedCopy(realmSource.realmGet$timezone(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel update(Realm realm, PPPostLocationModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel realmObject, com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.latitudeIndex, realmObjectSource.realmGet$latitude());
        builder.addString(columnInfo.longitudeIndex, realmObjectSource.realmGet$longitude());

        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel timezoneObj = realmObjectSource.realmGet$timezone();
        if (timezoneObj == null) {
            builder.addNull(columnInfo.timezoneIndex);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel cachetimezone = (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) cache.get(timezoneObj);
            if (cachetimezone != null) {
                builder.addObject(columnInfo.timezoneIndex, cachetimezone);
            } else {
                builder.addObject(columnInfo.timezoneIndex, com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class), timezoneObj, true, cache, flags));
            }
        }

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostLocationModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude() != null ? realmGet$latitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude() != null ? realmGet$longitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timezone:");
        stringBuilder.append(realmGet$timezone() != null ? "PPPostTimezoneModel" : "null");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy aPPPostLocationModel = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostLocationModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostLocationModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostLocationModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
