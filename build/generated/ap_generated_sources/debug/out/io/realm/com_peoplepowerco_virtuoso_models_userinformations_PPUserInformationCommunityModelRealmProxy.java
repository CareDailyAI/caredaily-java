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
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface {

    static final class PPUserInformationCommunityModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long locationIdIndex;
        long communityIdIndex;
        long communityNameIndex;

        PPUserInformationCommunityModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationCommunityModel");
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.communityIdIndex = addColumnDetails("communityId", "communityId", objectSchemaInfo);
            this.communityNameIndex = addColumnDetails("communityName", "communityName", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationCommunityModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationCommunityModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationCommunityModelColumnInfo src = (PPUserInformationCommunityModelColumnInfo) rawSrc;
            final PPUserInformationCommunityModelColumnInfo dst = (PPUserInformationCommunityModelColumnInfo) rawDst;
            dst.locationIdIndex = src.locationIdIndex;
            dst.communityIdIndex = src.communityIdIndex;
            dst.communityNameIndex = src.communityNameIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationCommunityModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel> proxyState;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationCommunityModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$locationId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.locationIdIndex);
    }

    @Override
    public void realmSet$locationId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.locationIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.locationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.locationIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.locationIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$communityId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.communityIdIndex);
    }

    @Override
    public void realmSet$communityId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.communityIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.communityIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.communityIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.communityIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$communityName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.communityNameIndex);
    }

    @Override
    public void realmSet$communityName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.communityNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.communityNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.communityNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.communityNameIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationCommunityModel", 3, 0);
        builder.addPersistedProperty("locationId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("communityId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("communityName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationCommunityModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationCommunityModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationCommunityModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationCommunityModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) obj;
        if (json.has("locationId")) {
            if (json.isNull("locationId")) {
                objProxy.realmSet$locationId(null);
            } else {
                objProxy.realmSet$locationId((String) json.getString("locationId"));
            }
        }
        if (json.has("communityId")) {
            if (json.isNull("communityId")) {
                objProxy.realmSet$communityId(null);
            } else {
                objProxy.realmSet$communityId((String) json.getString("communityId"));
            }
        }
        if (json.has("communityName")) {
            if (json.isNull("communityName")) {
                objProxy.realmSet$communityName(null);
            } else {
                objProxy.realmSet$communityName((String) json.getString("communityName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("locationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$locationId(null);
                }
            } else if (name.equals("communityId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$communityId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$communityId(null);
                }
            } else if (name.equals("communityName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$communityName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$communityName(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel copyOrUpdate(Realm realm, PPUserInformationCommunityModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel copy(Realm realm, PPUserInformationCommunityModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.communityIdIndex, realmObjectSource.realmGet$communityId());
        builder.addString(columnInfo.communityNameIndex, realmObjectSource.realmGet$communityName());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationCommunityModelColumnInfo columnInfo = (PPUserInformationCommunityModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$locationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$locationId();
        if (realmGet$locationId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIdIndex, rowIndex, realmGet$locationId, false);
        }
        String realmGet$communityId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityId();
        if (realmGet$communityId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.communityIdIndex, rowIndex, realmGet$communityId, false);
        }
        String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityName();
        if (realmGet$communityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationCommunityModelColumnInfo columnInfo = (PPUserInformationCommunityModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$locationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$locationId();
            if (realmGet$locationId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.locationIdIndex, rowIndex, realmGet$locationId, false);
            }
            String realmGet$communityId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityId();
            if (realmGet$communityId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.communityIdIndex, rowIndex, realmGet$communityId, false);
            }
            String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityName();
            if (realmGet$communityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationCommunityModelColumnInfo columnInfo = (PPUserInformationCommunityModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$locationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$locationId();
        if (realmGet$locationId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.locationIdIndex, rowIndex, realmGet$locationId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.locationIdIndex, rowIndex, false);
        }
        String realmGet$communityId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityId();
        if (realmGet$communityId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.communityIdIndex, rowIndex, realmGet$communityId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.communityIdIndex, rowIndex, false);
        }
        String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityName();
        if (realmGet$communityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.communityNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationCommunityModelColumnInfo columnInfo = (PPUserInformationCommunityModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$locationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$locationId();
            if (realmGet$locationId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.locationIdIndex, rowIndex, realmGet$locationId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.locationIdIndex, rowIndex, false);
            }
            String realmGet$communityId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityId();
            if (realmGet$communityId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.communityIdIndex, rowIndex, realmGet$communityId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.communityIdIndex, rowIndex, false);
            }
            String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) object).realmGet$communityName();
            if (realmGet$communityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.communityNameIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$communityId(realmSource.realmGet$communityId());
        unmanagedCopy.realmSet$communityName(realmSource.realmGet$communityName());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationCommunityModel = proxy[");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId() != null ? realmGet$locationId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{communityId:");
        stringBuilder.append(realmGet$communityId() != null ? realmGet$communityId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{communityName:");
        stringBuilder.append(realmGet$communityName() != null ? realmGet$communityName() : "null");
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy aPPUserInformationCommunityModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationCommunityModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationCommunityModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationCommunityModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
