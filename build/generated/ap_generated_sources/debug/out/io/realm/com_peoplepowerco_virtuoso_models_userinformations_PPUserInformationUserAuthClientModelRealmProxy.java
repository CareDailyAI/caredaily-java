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
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface {

    static final class PPUserInformationUserAuthClientModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long sAppIdIndex;
        long sAppNameIndex;
        long sExpiryIndex;
        long bAutoRefreshIndex;

        PPUserInformationUserAuthClientModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationUserAuthClientModel");
            this.sAppIdIndex = addColumnDetails("sAppId", "sAppId", objectSchemaInfo);
            this.sAppNameIndex = addColumnDetails("sAppName", "sAppName", objectSchemaInfo);
            this.sExpiryIndex = addColumnDetails("sExpiry", "sExpiry", objectSchemaInfo);
            this.bAutoRefreshIndex = addColumnDetails("bAutoRefresh", "bAutoRefresh", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationUserAuthClientModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationUserAuthClientModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationUserAuthClientModelColumnInfo src = (PPUserInformationUserAuthClientModelColumnInfo) rawSrc;
            final PPUserInformationUserAuthClientModelColumnInfo dst = (PPUserInformationUserAuthClientModelColumnInfo) rawDst;
            dst.sAppIdIndex = src.sAppIdIndex;
            dst.sAppNameIndex = src.sAppNameIndex;
            dst.sExpiryIndex = src.sExpiryIndex;
            dst.bAutoRefreshIndex = src.bAutoRefreshIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationUserAuthClientModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel> proxyState;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationUserAuthClientModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAppId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAppIdIndex);
    }

    @Override
    public void realmSet$sAppId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAppIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAppIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAppIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAppIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAppName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAppNameIndex);
    }

    @Override
    public void realmSet$sAppName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAppNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAppNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAppNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAppNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sExpiry() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sExpiryIndex);
    }

    @Override
    public void realmSet$sExpiry(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sExpiryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sExpiryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sExpiryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sExpiryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$bAutoRefresh() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.bAutoRefreshIndex);
    }

    @Override
    public void realmSet$bAutoRefresh(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.bAutoRefreshIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.bAutoRefreshIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationUserAuthClientModel", 4, 0);
        builder.addPersistedProperty("sAppId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sAppName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sExpiry", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("bAutoRefresh", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationUserAuthClientModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationUserAuthClientModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationUserAuthClientModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationUserAuthClientModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) obj;
        if (json.has("sAppId")) {
            if (json.isNull("sAppId")) {
                objProxy.realmSet$sAppId(null);
            } else {
                objProxy.realmSet$sAppId((String) json.getString("sAppId"));
            }
        }
        if (json.has("sAppName")) {
            if (json.isNull("sAppName")) {
                objProxy.realmSet$sAppName(null);
            } else {
                objProxy.realmSet$sAppName((String) json.getString("sAppName"));
            }
        }
        if (json.has("sExpiry")) {
            if (json.isNull("sExpiry")) {
                objProxy.realmSet$sExpiry(null);
            } else {
                objProxy.realmSet$sExpiry((String) json.getString("sExpiry"));
            }
        }
        if (json.has("bAutoRefresh")) {
            if (json.isNull("bAutoRefresh")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bAutoRefresh' to null.");
            } else {
                objProxy.realmSet$bAutoRefresh((boolean) json.getBoolean("bAutoRefresh"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("sAppId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAppId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAppId(null);
                }
            } else if (name.equals("sAppName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAppName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAppName(null);
                }
            } else if (name.equals("sExpiry")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sExpiry((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sExpiry(null);
                }
            } else if (name.equals("bAutoRefresh")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bAutoRefresh((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bAutoRefresh' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel copyOrUpdate(Realm realm, PPUserInformationUserAuthClientModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel copy(Realm realm, PPUserInformationUserAuthClientModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.sAppIdIndex, realmObjectSource.realmGet$sAppId());
        builder.addString(columnInfo.sAppNameIndex, realmObjectSource.realmGet$sAppName());
        builder.addString(columnInfo.sExpiryIndex, realmObjectSource.realmGet$sExpiry());
        builder.addBoolean(columnInfo.bAutoRefreshIndex, realmObjectSource.realmGet$bAutoRefresh());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationUserAuthClientModelColumnInfo columnInfo = (PPUserInformationUserAuthClientModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$sAppId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppId();
        if (realmGet$sAppId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAppIdIndex, rowIndex, realmGet$sAppId, false);
        }
        String realmGet$sAppName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppName();
        if (realmGet$sAppName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAppNameIndex, rowIndex, realmGet$sAppName, false);
        }
        String realmGet$sExpiry = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sExpiry();
        if (realmGet$sExpiry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sExpiryIndex, rowIndex, realmGet$sExpiry, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bAutoRefreshIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$bAutoRefresh(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationUserAuthClientModelColumnInfo columnInfo = (PPUserInformationUserAuthClientModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$sAppId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppId();
            if (realmGet$sAppId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAppIdIndex, rowIndex, realmGet$sAppId, false);
            }
            String realmGet$sAppName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppName();
            if (realmGet$sAppName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAppNameIndex, rowIndex, realmGet$sAppName, false);
            }
            String realmGet$sExpiry = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sExpiry();
            if (realmGet$sExpiry != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sExpiryIndex, rowIndex, realmGet$sExpiry, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bAutoRefreshIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$bAutoRefresh(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationUserAuthClientModelColumnInfo columnInfo = (PPUserInformationUserAuthClientModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$sAppId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppId();
        if (realmGet$sAppId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAppIdIndex, rowIndex, realmGet$sAppId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAppIdIndex, rowIndex, false);
        }
        String realmGet$sAppName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppName();
        if (realmGet$sAppName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAppNameIndex, rowIndex, realmGet$sAppName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAppNameIndex, rowIndex, false);
        }
        String realmGet$sExpiry = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sExpiry();
        if (realmGet$sExpiry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sExpiryIndex, rowIndex, realmGet$sExpiry, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sExpiryIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bAutoRefreshIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$bAutoRefresh(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationUserAuthClientModelColumnInfo columnInfo = (PPUserInformationUserAuthClientModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$sAppId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppId();
            if (realmGet$sAppId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAppIdIndex, rowIndex, realmGet$sAppId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAppIdIndex, rowIndex, false);
            }
            String realmGet$sAppName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sAppName();
            if (realmGet$sAppName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAppNameIndex, rowIndex, realmGet$sAppName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAppNameIndex, rowIndex, false);
            }
            String realmGet$sExpiry = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$sExpiry();
            if (realmGet$sExpiry != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sExpiryIndex, rowIndex, realmGet$sExpiry, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sExpiryIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bAutoRefreshIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) object).realmGet$bAutoRefresh(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$sAppId(realmSource.realmGet$sAppId());
        unmanagedCopy.realmSet$sAppName(realmSource.realmGet$sAppName());
        unmanagedCopy.realmSet$sExpiry(realmSource.realmGet$sExpiry());
        unmanagedCopy.realmSet$bAutoRefresh(realmSource.realmGet$bAutoRefresh());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationUserAuthClientModel = proxy[");
        stringBuilder.append("{sAppId:");
        stringBuilder.append(realmGet$sAppId() != null ? realmGet$sAppId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sAppName:");
        stringBuilder.append(realmGet$sAppName() != null ? realmGet$sAppName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sExpiry:");
        stringBuilder.append(realmGet$sExpiry() != null ? realmGet$sExpiry() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bAutoRefresh:");
        stringBuilder.append(realmGet$bAutoRefresh());
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy aPPUserInformationUserAuthClientModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationUserAuthClientModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationUserAuthClientModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationUserAuthClientModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
