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
public class com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy extends com.peoplepowerco.virtuoso.bean.CRSwitchDevice
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface {

    static final class CRSwitchDeviceColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long deviceIdIndex;
        long paramNameIndex;
        long updateTimeMsIndex;
        long isCheckedIndex;

        CRSwitchDeviceColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("CRSwitchDevice");
            this.deviceIdIndex = addColumnDetails("deviceId", "deviceId", objectSchemaInfo);
            this.paramNameIndex = addColumnDetails("paramName", "paramName", objectSchemaInfo);
            this.updateTimeMsIndex = addColumnDetails("updateTimeMs", "updateTimeMs", objectSchemaInfo);
            this.isCheckedIndex = addColumnDetails("isChecked", "isChecked", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        CRSwitchDeviceColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CRSwitchDeviceColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CRSwitchDeviceColumnInfo src = (CRSwitchDeviceColumnInfo) rawSrc;
            final CRSwitchDeviceColumnInfo dst = (CRSwitchDeviceColumnInfo) rawDst;
            dst.deviceIdIndex = src.deviceIdIndex;
            dst.paramNameIndex = src.paramNameIndex;
            dst.updateTimeMsIndex = src.updateTimeMsIndex;
            dst.isCheckedIndex = src.isCheckedIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CRSwitchDeviceColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.bean.CRSwitchDevice> proxyState;

    com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CRSwitchDeviceColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.bean.CRSwitchDevice>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$deviceId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.deviceIdIndex);
    }

    @Override
    public void realmSet$deviceId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'deviceId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$paramName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paramNameIndex);
    }

    @Override
    public void realmSet$paramName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.paramNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paramNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paramNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paramNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$updateTimeMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.updateTimeMsIndex);
    }

    @Override
    public void realmSet$updateTimeMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.updateTimeMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.updateTimeMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isChecked() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isCheckedIndex);
    }

    @Override
    public void realmSet$isChecked(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isCheckedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isCheckedIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("CRSwitchDevice", 4, 0);
        builder.addPersistedProperty("deviceId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("paramName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updateTimeMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isChecked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CRSwitchDeviceColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CRSwitchDeviceColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "CRSwitchDevice";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "CRSwitchDevice";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.bean.CRSwitchDevice createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.bean.CRSwitchDevice obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
            CRSwitchDeviceColumnInfo columnInfo = (CRSwitchDeviceColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
            long pkColumnIndex = columnInfo.deviceIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("deviceId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("deviceId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("deviceId")) {
                if (json.isNull("deviceId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class, json.getString("deviceId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'deviceId'.");
            }
        }

        final com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) obj;
        if (json.has("paramName")) {
            if (json.isNull("paramName")) {
                objProxy.realmSet$paramName(null);
            } else {
                objProxy.realmSet$paramName((String) json.getString("paramName"));
            }
        }
        if (json.has("updateTimeMs")) {
            if (json.isNull("updateTimeMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'updateTimeMs' to null.");
            } else {
                objProxy.realmSet$updateTimeMs((long) json.getLong("updateTimeMs"));
            }
        }
        if (json.has("isChecked")) {
            if (json.isNull("isChecked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isChecked' to null.");
            } else {
                objProxy.realmSet$isChecked((boolean) json.getBoolean("isChecked"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.bean.CRSwitchDevice createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.bean.CRSwitchDevice obj = new com.peoplepowerco.virtuoso.bean.CRSwitchDevice();
        final com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("deviceId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$deviceId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$deviceId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("paramName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$paramName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$paramName(null);
                }
            } else if (name.equals("updateTimeMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updateTimeMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'updateTimeMs' to null.");
                }
            } else if (name.equals("isChecked")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isChecked((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isChecked' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'deviceId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.bean.CRSwitchDevice copyOrUpdate(Realm realm, CRSwitchDeviceColumnInfo columnInfo, com.peoplepowerco.virtuoso.bean.CRSwitchDevice object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.bean.CRSwitchDevice realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
            long pkColumnIndex = columnInfo.deviceIdIndex;
            String value = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$deviceId();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.bean.CRSwitchDevice copy(Realm realm, CRSwitchDeviceColumnInfo columnInfo, com.peoplepowerco.virtuoso.bean.CRSwitchDevice newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.deviceIdIndex, realmObjectSource.realmGet$deviceId());
        builder.addString(columnInfo.paramNameIndex, realmObjectSource.realmGet$paramName());
        builder.addInteger(columnInfo.updateTimeMsIndex, realmObjectSource.realmGet$updateTimeMs());
        builder.addBoolean(columnInfo.isCheckedIndex, realmObjectSource.realmGet$isChecked());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.bean.CRSwitchDevice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long tableNativePtr = table.getNativePtr();
        CRSwitchDeviceColumnInfo columnInfo = (CRSwitchDeviceColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long pkColumnIndex = columnInfo.deviceIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$deviceId();
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
        String realmGet$paramName = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$paramName();
        if (realmGet$paramName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.updateTimeMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$updateTimeMs(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCheckedIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$isChecked(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long tableNativePtr = table.getNativePtr();
        CRSwitchDeviceColumnInfo columnInfo = (CRSwitchDeviceColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long pkColumnIndex = columnInfo.deviceIdIndex;
        com.peoplepowerco.virtuoso.bean.CRSwitchDevice object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$deviceId();
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
            String realmGet$paramName = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$paramName();
            if (realmGet$paramName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.updateTimeMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$updateTimeMs(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isCheckedIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$isChecked(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.bean.CRSwitchDevice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long tableNativePtr = table.getNativePtr();
        CRSwitchDeviceColumnInfo columnInfo = (CRSwitchDeviceColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long pkColumnIndex = columnInfo.deviceIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$deviceId();
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
        String realmGet$paramName = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$paramName();
        if (realmGet$paramName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paramNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.updateTimeMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$updateTimeMs(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCheckedIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$isChecked(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long tableNativePtr = table.getNativePtr();
        CRSwitchDeviceColumnInfo columnInfo = (CRSwitchDeviceColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        long pkColumnIndex = columnInfo.deviceIdIndex;
        com.peoplepowerco.virtuoso.bean.CRSwitchDevice object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$deviceId();
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
            String realmGet$paramName = ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$paramName();
            if (realmGet$paramName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.paramNameIndex, rowIndex, realmGet$paramName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.paramNameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.updateTimeMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$updateTimeMs(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isCheckedIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) object).realmGet$isChecked(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.bean.CRSwitchDevice createDetachedCopy(com.peoplepowerco.virtuoso.bean.CRSwitchDevice realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.bean.CRSwitchDevice unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.bean.CRSwitchDevice();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$deviceId(realmSource.realmGet$deviceId());
        unmanagedCopy.realmSet$paramName(realmSource.realmGet$paramName());
        unmanagedCopy.realmSet$updateTimeMs(realmSource.realmGet$updateTimeMs());
        unmanagedCopy.realmSet$isChecked(realmSource.realmGet$isChecked());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.bean.CRSwitchDevice update(Realm realm, CRSwitchDeviceColumnInfo columnInfo, com.peoplepowerco.virtuoso.bean.CRSwitchDevice realmObject, com.peoplepowerco.virtuoso.bean.CRSwitchDevice newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.deviceIdIndex, realmObjectSource.realmGet$deviceId());
        builder.addString(columnInfo.paramNameIndex, realmObjectSource.realmGet$paramName());
        builder.addInteger(columnInfo.updateTimeMsIndex, realmObjectSource.realmGet$updateTimeMs());
        builder.addBoolean(columnInfo.isCheckedIndex, realmObjectSource.realmGet$isChecked());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CRSwitchDevice = proxy[");
        stringBuilder.append("{deviceId:");
        stringBuilder.append(realmGet$deviceId() != null ? realmGet$deviceId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paramName:");
        stringBuilder.append(realmGet$paramName() != null ? realmGet$paramName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updateTimeMs:");
        stringBuilder.append(realmGet$updateTimeMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isChecked:");
        stringBuilder.append(realmGet$isChecked());
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
        com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy aCRSwitchDevice = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCRSwitchDevice.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCRSwitchDevice.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCRSwitchDevice.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
