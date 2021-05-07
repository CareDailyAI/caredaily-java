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
public class com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface {

    static final class PPPostReminderModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long notificationTextIndex;
        long notificationIntervalIndex;
        long notificationDateIndex;

        PPPostReminderModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostReminderModel");
            this.notificationTextIndex = addColumnDetails("notificationText", "notificationText", objectSchemaInfo);
            this.notificationIntervalIndex = addColumnDetails("notificationInterval", "notificationInterval", objectSchemaInfo);
            this.notificationDateIndex = addColumnDetails("notificationDate", "notificationDate", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostReminderModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostReminderModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostReminderModelColumnInfo src = (PPPostReminderModelColumnInfo) rawSrc;
            final PPPostReminderModelColumnInfo dst = (PPPostReminderModelColumnInfo) rawDst;
            dst.notificationTextIndex = src.notificationTextIndex;
            dst.notificationIntervalIndex = src.notificationIntervalIndex;
            dst.notificationDateIndex = src.notificationDateIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostReminderModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostReminderModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$notificationText() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.notificationTextIndex);
    }

    @Override
    public void realmSet$notificationText(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.notificationTextIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.notificationTextIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.notificationTextIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.notificationTextIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$notificationInterval() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.notificationIntervalIndex);
    }

    @Override
    public void realmSet$notificationInterval(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.notificationIntervalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.notificationIntervalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$notificationDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.notificationDateIndex);
    }

    @Override
    public void realmSet$notificationDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.notificationDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.notificationDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.notificationDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.notificationDateIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostReminderModel", 3, 0);
        builder.addPersistedProperty("notificationText", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("notificationInterval", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("notificationDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostReminderModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostReminderModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostReminderModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostReminderModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) obj;
        if (json.has("notificationText")) {
            if (json.isNull("notificationText")) {
                objProxy.realmSet$notificationText(null);
            } else {
                objProxy.realmSet$notificationText((String) json.getString("notificationText"));
            }
        }
        if (json.has("notificationInterval")) {
            if (json.isNull("notificationInterval")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'notificationInterval' to null.");
            } else {
                objProxy.realmSet$notificationInterval((long) json.getLong("notificationInterval"));
            }
        }
        if (json.has("notificationDate")) {
            if (json.isNull("notificationDate")) {
                objProxy.realmSet$notificationDate(null);
            } else {
                objProxy.realmSet$notificationDate((String) json.getString("notificationDate"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("notificationText")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$notificationText((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$notificationText(null);
                }
            } else if (name.equals("notificationInterval")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$notificationInterval((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'notificationInterval' to null.");
                }
            } else if (name.equals("notificationDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$notificationDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$notificationDate(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel copyOrUpdate(Realm realm, PPPostReminderModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel copy(Realm realm, PPPostReminderModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.notificationTextIndex, realmObjectSource.realmGet$notificationText());
        builder.addInteger(columnInfo.notificationIntervalIndex, realmObjectSource.realmGet$notificationInterval());
        builder.addString(columnInfo.notificationDateIndex, realmObjectSource.realmGet$notificationDate());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReminderModelColumnInfo columnInfo = (PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$notificationText = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationText();
        if (realmGet$notificationText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.notificationTextIndex, rowIndex, realmGet$notificationText, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.notificationIntervalIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationInterval(), false);
        String realmGet$notificationDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationDate();
        if (realmGet$notificationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.notificationDateIndex, rowIndex, realmGet$notificationDate, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReminderModelColumnInfo columnInfo = (PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$notificationText = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationText();
            if (realmGet$notificationText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.notificationTextIndex, rowIndex, realmGet$notificationText, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.notificationIntervalIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationInterval(), false);
            String realmGet$notificationDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationDate();
            if (realmGet$notificationDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.notificationDateIndex, rowIndex, realmGet$notificationDate, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReminderModelColumnInfo columnInfo = (PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$notificationText = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationText();
        if (realmGet$notificationText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.notificationTextIndex, rowIndex, realmGet$notificationText, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.notificationTextIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.notificationIntervalIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationInterval(), false);
        String realmGet$notificationDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationDate();
        if (realmGet$notificationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.notificationDateIndex, rowIndex, realmGet$notificationDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.notificationDateIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReminderModelColumnInfo columnInfo = (PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$notificationText = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationText();
            if (realmGet$notificationText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.notificationTextIndex, rowIndex, realmGet$notificationText, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.notificationTextIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.notificationIntervalIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationInterval(), false);
            String realmGet$notificationDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) object).realmGet$notificationDate();
            if (realmGet$notificationDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.notificationDateIndex, rowIndex, realmGet$notificationDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.notificationDateIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$notificationText(realmSource.realmGet$notificationText());
        unmanagedCopy.realmSet$notificationInterval(realmSource.realmGet$notificationInterval());
        unmanagedCopy.realmSet$notificationDate(realmSource.realmGet$notificationDate());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostReminderModel = proxy[");
        stringBuilder.append("{notificationText:");
        stringBuilder.append(realmGet$notificationText() != null ? realmGet$notificationText() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{notificationInterval:");
        stringBuilder.append(realmGet$notificationInterval());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{notificationDate:");
        stringBuilder.append(realmGet$notificationDate() != null ? realmGet$notificationDate() : "null");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy aPPPostReminderModel = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostReminderModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostReminderModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostReminderModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
