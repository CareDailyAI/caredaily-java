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
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface {

    static final class PPUserInformationServiceModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long locationIdIndex;
        long sNameIndex;
        long nAmountIndex;
        long sStartDateIndex;
        long lStartDateMsIndex;
        long sEndDateIndex;
        long lEndDateMsIndex;

        PPUserInformationServiceModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationServiceModel");
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.sNameIndex = addColumnDetails("sName", "sName", objectSchemaInfo);
            this.nAmountIndex = addColumnDetails("nAmount", "nAmount", objectSchemaInfo);
            this.sStartDateIndex = addColumnDetails("sStartDate", "sStartDate", objectSchemaInfo);
            this.lStartDateMsIndex = addColumnDetails("lStartDateMs", "lStartDateMs", objectSchemaInfo);
            this.sEndDateIndex = addColumnDetails("sEndDate", "sEndDate", objectSchemaInfo);
            this.lEndDateMsIndex = addColumnDetails("lEndDateMs", "lEndDateMs", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationServiceModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationServiceModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationServiceModelColumnInfo src = (PPUserInformationServiceModelColumnInfo) rawSrc;
            final PPUserInformationServiceModelColumnInfo dst = (PPUserInformationServiceModelColumnInfo) rawDst;
            dst.locationIdIndex = src.locationIdIndex;
            dst.sNameIndex = src.sNameIndex;
            dst.nAmountIndex = src.nAmountIndex;
            dst.sStartDateIndex = src.sStartDateIndex;
            dst.lStartDateMsIndex = src.lStartDateMsIndex;
            dst.sEndDateIndex = src.sEndDateIndex;
            dst.lEndDateMsIndex = src.lEndDateMsIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationServiceModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> proxyState;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationServiceModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>(this);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.locationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.locationIdIndex, value);
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

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nAmount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nAmountIndex);
    }

    @Override
    public void realmSet$nAmount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nAmountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nAmountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sStartDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sStartDateIndex);
    }

    @Override
    public void realmSet$sStartDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sStartDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sStartDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sStartDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sStartDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$lStartDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.lStartDateMsIndex);
    }

    @Override
    public void realmSet$lStartDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.lStartDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.lStartDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sEndDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sEndDateIndex);
    }

    @Override
    public void realmSet$sEndDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sEndDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sEndDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sEndDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sEndDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$lEndDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.lEndDateMsIndex);
    }

    @Override
    public void realmSet$lEndDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.lEndDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.lEndDateMsIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationServiceModel", 7, 0);
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nAmount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sStartDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lStartDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sEndDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lEndDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationServiceModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationServiceModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationServiceModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationServiceModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) obj;
        if (json.has("locationId")) {
            if (json.isNull("locationId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
            } else {
                objProxy.realmSet$locationId((long) json.getLong("locationId"));
            }
        }
        if (json.has("sName")) {
            if (json.isNull("sName")) {
                objProxy.realmSet$sName(null);
            } else {
                objProxy.realmSet$sName((String) json.getString("sName"));
            }
        }
        if (json.has("nAmount")) {
            if (json.isNull("nAmount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nAmount' to null.");
            } else {
                objProxy.realmSet$nAmount((int) json.getInt("nAmount"));
            }
        }
        if (json.has("sStartDate")) {
            if (json.isNull("sStartDate")) {
                objProxy.realmSet$sStartDate(null);
            } else {
                objProxy.realmSet$sStartDate((String) json.getString("sStartDate"));
            }
        }
        if (json.has("lStartDateMs")) {
            if (json.isNull("lStartDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lStartDateMs' to null.");
            } else {
                objProxy.realmSet$lStartDateMs((long) json.getLong("lStartDateMs"));
            }
        }
        if (json.has("sEndDate")) {
            if (json.isNull("sEndDate")) {
                objProxy.realmSet$sEndDate(null);
            } else {
                objProxy.realmSet$sEndDate((String) json.getString("sEndDate"));
            }
        }
        if (json.has("lEndDateMs")) {
            if (json.isNull("lEndDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lEndDateMs' to null.");
            } else {
                objProxy.realmSet$lEndDateMs((long) json.getLong("lEndDateMs"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) obj;
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
            } else if (name.equals("sName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sName(null);
                }
            } else if (name.equals("nAmount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nAmount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nAmount' to null.");
                }
            } else if (name.equals("sStartDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sStartDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sStartDate(null);
                }
            } else if (name.equals("lStartDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lStartDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lStartDateMs' to null.");
                }
            } else if (name.equals("sEndDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sEndDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sEndDate(null);
                }
            } else if (name.equals("lEndDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lEndDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lEndDateMs' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel copyOrUpdate(Realm realm, PPUserInformationServiceModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel copy(Realm realm, PPUserInformationServiceModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addInteger(columnInfo.nAmountIndex, realmObjectSource.realmGet$nAmount());
        builder.addString(columnInfo.sStartDateIndex, realmObjectSource.realmGet$sStartDate());
        builder.addInteger(columnInfo.lStartDateMsIndex, realmObjectSource.realmGet$lStartDateMs());
        builder.addString(columnInfo.sEndDateIndex, realmObjectSource.realmGet$sEndDate());
        builder.addInteger(columnInfo.lEndDateMsIndex, realmObjectSource.realmGet$lEndDateMs());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationServiceModelColumnInfo columnInfo = (PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$locationId(), false);
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nAmountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$nAmount(), false);
        String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sStartDate();
        if (realmGet$sStartDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.lStartDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lStartDateMs(), false);
        String realmGet$sEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sEndDate();
        if (realmGet$sEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sEndDateIndex, rowIndex, realmGet$sEndDate, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.lEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lEndDateMs(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationServiceModelColumnInfo columnInfo = (PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$locationId(), false);
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nAmountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$nAmount(), false);
            String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sStartDate();
            if (realmGet$sStartDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.lStartDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lStartDateMs(), false);
            String realmGet$sEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sEndDate();
            if (realmGet$sEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sEndDateIndex, rowIndex, realmGet$sEndDate, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.lEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lEndDateMs(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationServiceModelColumnInfo columnInfo = (PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$locationId(), false);
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nAmountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$nAmount(), false);
        String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sStartDate();
        if (realmGet$sStartDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.lStartDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lStartDateMs(), false);
        String realmGet$sEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sEndDate();
        if (realmGet$sEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sEndDateIndex, rowIndex, realmGet$sEndDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sEndDateIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.lEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lEndDateMs(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationServiceModelColumnInfo columnInfo = (PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$locationId(), false);
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nAmountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$nAmount(), false);
            String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sStartDate();
            if (realmGet$sStartDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.lStartDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lStartDateMs(), false);
            String realmGet$sEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$sEndDate();
            if (realmGet$sEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sEndDateIndex, rowIndex, realmGet$sEndDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sEndDateIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.lEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) object).realmGet$lEndDateMs(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$sName(realmSource.realmGet$sName());
        unmanagedCopy.realmSet$nAmount(realmSource.realmGet$nAmount());
        unmanagedCopy.realmSet$sStartDate(realmSource.realmGet$sStartDate());
        unmanagedCopy.realmSet$lStartDateMs(realmSource.realmGet$lStartDateMs());
        unmanagedCopy.realmSet$sEndDate(realmSource.realmGet$sEndDate());
        unmanagedCopy.realmSet$lEndDateMs(realmSource.realmGet$lEndDateMs());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationServiceModel = proxy[");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sName:");
        stringBuilder.append(realmGet$sName() != null ? realmGet$sName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nAmount:");
        stringBuilder.append(realmGet$nAmount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sStartDate:");
        stringBuilder.append(realmGet$sStartDate() != null ? realmGet$sStartDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lStartDateMs:");
        stringBuilder.append(realmGet$lStartDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sEndDate:");
        stringBuilder.append(realmGet$sEndDate() != null ? realmGet$sEndDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lEndDateMs:");
        stringBuilder.append(realmGet$lEndDateMs());
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy aPPUserInformationServiceModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationServiceModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationServiceModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationServiceModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
