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
public class com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface {

    static final class PPPostTimezoneModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long nameIndex;
        long offsetIndex;
        long dstIndex;

        PPPostTimezoneModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostTimezoneModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.offsetIndex = addColumnDetails("offset", "offset", objectSchemaInfo);
            this.dstIndex = addColumnDetails("dst", "dst", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostTimezoneModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostTimezoneModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostTimezoneModelColumnInfo src = (PPPostTimezoneModelColumnInfo) rawSrc;
            final PPPostTimezoneModelColumnInfo dst = (PPPostTimezoneModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.offsetIndex = src.offsetIndex;
            dst.dstIndex = src.dstIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostTimezoneModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostTimezoneModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel>(this);
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
    public int realmGet$offset() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.offsetIndex);
    }

    @Override
    public void realmSet$offset(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.offsetIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.offsetIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$dst() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.dstIndex);
    }

    @Override
    public void realmSet$dst(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.dstIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.dstIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostTimezoneModel", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("offset", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("dst", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostTimezoneModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostTimezoneModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostTimezoneModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostTimezoneModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
            PPPostTimezoneModelColumnInfo columnInfo = (PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("offset")) {
            if (json.isNull("offset")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'offset' to null.");
            } else {
                objProxy.realmSet$offset((int) json.getInt("offset"));
            }
        }
        if (json.has("dst")) {
            if (json.isNull("dst")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'dst' to null.");
            } else {
                objProxy.realmSet$dst((boolean) json.getBoolean("dst"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) obj;
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
            } else if (name.equals("offset")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$offset((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'offset' to null.");
                }
            } else if (name.equals("dst")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dst((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dst' to null.");
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

    private static com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel copyOrUpdate(Realm realm, PPPostTimezoneModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$id();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel copy(Realm realm, PPPostTimezoneModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addInteger(columnInfo.offsetIndex, realmObjectSource.realmGet$offset());
        builder.addBoolean(columnInfo.dstIndex, realmObjectSource.realmGet$dst());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostTimezoneModelColumnInfo columnInfo = (PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.offsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$offset(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.dstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$dst(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostTimezoneModelColumnInfo columnInfo = (PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.offsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$offset(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.dstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$dst(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostTimezoneModelColumnInfo columnInfo = (PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.offsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$offset(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.dstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$dst(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostTimezoneModelColumnInfo columnInfo = (PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.offsetIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$offset(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.dstIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) object).realmGet$dst(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$offset(realmSource.realmGet$offset());
        unmanagedCopy.realmSet$dst(realmSource.realmGet$dst());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel update(Realm realm, PPPostTimezoneModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel realmObject, com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addInteger(columnInfo.offsetIndex, realmObjectSource.realmGet$offset());
        builder.addBoolean(columnInfo.dstIndex, realmObjectSource.realmGet$dst());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostTimezoneModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{offset:");
        stringBuilder.append(realmGet$offset());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dst:");
        stringBuilder.append(realmGet$dst());
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
        com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy aPPPostTimezoneModel = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostTimezoneModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostTimezoneModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostTimezoneModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
