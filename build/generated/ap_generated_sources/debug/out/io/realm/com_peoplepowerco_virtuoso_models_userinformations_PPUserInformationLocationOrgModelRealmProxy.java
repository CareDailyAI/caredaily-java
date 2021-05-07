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
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface {

    static final class PPUserInformationLocationOrgModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long locationIdIndex;
        long idIndex;
        long sNameIndex;
        long sContactName1Index;
        long sContactEmail1Index;
        long sContactPhone1Index;

        PPUserInformationLocationOrgModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationLocationOrgModel");
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.sNameIndex = addColumnDetails("sName", "sName", objectSchemaInfo);
            this.sContactName1Index = addColumnDetails("sContactName1", "sContactName1", objectSchemaInfo);
            this.sContactEmail1Index = addColumnDetails("sContactEmail1", "sContactEmail1", objectSchemaInfo);
            this.sContactPhone1Index = addColumnDetails("sContactPhone1", "sContactPhone1", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationLocationOrgModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationLocationOrgModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationLocationOrgModelColumnInfo src = (PPUserInformationLocationOrgModelColumnInfo) rawSrc;
            final PPUserInformationLocationOrgModelColumnInfo dst = (PPUserInformationLocationOrgModelColumnInfo) rawDst;
            dst.locationIdIndex = src.locationIdIndex;
            dst.idIndex = src.idIndex;
            dst.sNameIndex = src.sNameIndex;
            dst.sContactName1Index = src.sContactName1Index;
            dst.sContactEmail1Index = src.sContactEmail1Index;
            dst.sContactPhone1Index = src.sContactPhone1Index;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationLocationOrgModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel> proxyState;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationLocationOrgModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel>(this);
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
    public String realmGet$sContactName1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sContactName1Index);
    }

    @Override
    public void realmSet$sContactName1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sContactName1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sContactName1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sContactName1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sContactName1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sContactEmail1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sContactEmail1Index);
    }

    @Override
    public void realmSet$sContactEmail1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sContactEmail1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sContactEmail1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sContactEmail1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sContactEmail1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sContactPhone1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sContactPhone1Index);
    }

    @Override
    public void realmSet$sContactPhone1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sContactPhone1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sContactPhone1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sContactPhone1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sContactPhone1Index, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationLocationOrgModel", 6, 0);
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sContactName1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sContactEmail1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sContactPhone1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationLocationOrgModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationLocationOrgModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationLocationOrgModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationLocationOrgModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
            PPUserInformationLocationOrgModelColumnInfo columnInfo = (PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
            long pkColumnIndex = columnInfo.locationIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("locationId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("locationId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("locationId")) {
                if (json.isNull("locationId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class, json.getLong("locationId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'locationId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("sName")) {
            if (json.isNull("sName")) {
                objProxy.realmSet$sName(null);
            } else {
                objProxy.realmSet$sName((String) json.getString("sName"));
            }
        }
        if (json.has("sContactName1")) {
            if (json.isNull("sContactName1")) {
                objProxy.realmSet$sContactName1(null);
            } else {
                objProxy.realmSet$sContactName1((String) json.getString("sContactName1"));
            }
        }
        if (json.has("sContactEmail1")) {
            if (json.isNull("sContactEmail1")) {
                objProxy.realmSet$sContactEmail1(null);
            } else {
                objProxy.realmSet$sContactEmail1((String) json.getString("sContactEmail1"));
            }
        }
        if (json.has("sContactPhone1")) {
            if (json.isNull("sContactPhone1")) {
                objProxy.realmSet$sContactPhone1(null);
            } else {
                objProxy.realmSet$sContactPhone1((String) json.getString("sContactPhone1"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) obj;
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
            } else if (name.equals("sName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sName(null);
                }
            } else if (name.equals("sContactName1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sContactName1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sContactName1(null);
                }
            } else if (name.equals("sContactEmail1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sContactEmail1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sContactEmail1(null);
                }
            } else if (name.equals("sContactPhone1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sContactPhone1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sContactPhone1(null);
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

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel copyOrUpdate(Realm realm, PPUserInformationLocationOrgModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
            long pkColumnIndex = columnInfo.locationIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel copy(Realm realm, PPUserInformationLocationOrgModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addString(columnInfo.sContactName1Index, realmObjectSource.realmGet$sContactName1());
        builder.addString(columnInfo.sContactEmail1Index, realmObjectSource.realmGet$sContactEmail1());
        builder.addString(columnInfo.sContactPhone1Index, realmObjectSource.realmGet$sContactPhone1());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationOrgModelColumnInfo columnInfo = (PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        }
        String realmGet$sContactName1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactName1();
        if (realmGet$sContactName1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sContactName1Index, rowIndex, realmGet$sContactName1, false);
        }
        String realmGet$sContactEmail1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactEmail1();
        if (realmGet$sContactEmail1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sContactEmail1Index, rowIndex, realmGet$sContactEmail1, false);
        }
        String realmGet$sContactPhone1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactPhone1();
        if (realmGet$sContactPhone1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sContactPhone1Index, rowIndex, realmGet$sContactPhone1, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationOrgModelColumnInfo columnInfo = (PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            }
            String realmGet$sContactName1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactName1();
            if (realmGet$sContactName1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sContactName1Index, rowIndex, realmGet$sContactName1, false);
            }
            String realmGet$sContactEmail1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactEmail1();
            if (realmGet$sContactEmail1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sContactEmail1Index, rowIndex, realmGet$sContactEmail1, false);
            }
            String realmGet$sContactPhone1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactPhone1();
            if (realmGet$sContactPhone1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sContactPhone1Index, rowIndex, realmGet$sContactPhone1, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationOrgModelColumnInfo columnInfo = (PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
        }
        String realmGet$sContactName1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactName1();
        if (realmGet$sContactName1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sContactName1Index, rowIndex, realmGet$sContactName1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sContactName1Index, rowIndex, false);
        }
        String realmGet$sContactEmail1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactEmail1();
        if (realmGet$sContactEmail1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sContactEmail1Index, rowIndex, realmGet$sContactEmail1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sContactEmail1Index, rowIndex, false);
        }
        String realmGet$sContactPhone1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactPhone1();
        if (realmGet$sContactPhone1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sContactPhone1Index, rowIndex, realmGet$sContactPhone1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sContactPhone1Index, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationOrgModelColumnInfo columnInfo = (PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$locationId());
            }
            cache.put(object, rowIndex);
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
            }
            String realmGet$sContactName1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactName1();
            if (realmGet$sContactName1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sContactName1Index, rowIndex, realmGet$sContactName1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sContactName1Index, rowIndex, false);
            }
            String realmGet$sContactEmail1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactEmail1();
            if (realmGet$sContactEmail1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sContactEmail1Index, rowIndex, realmGet$sContactEmail1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sContactEmail1Index, rowIndex, false);
            }
            String realmGet$sContactPhone1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) object).realmGet$sContactPhone1();
            if (realmGet$sContactPhone1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sContactPhone1Index, rowIndex, realmGet$sContactPhone1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sContactPhone1Index, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$sName(realmSource.realmGet$sName());
        unmanagedCopy.realmSet$sContactName1(realmSource.realmGet$sContactName1());
        unmanagedCopy.realmSet$sContactEmail1(realmSource.realmGet$sContactEmail1());
        unmanagedCopy.realmSet$sContactPhone1(realmSource.realmGet$sContactPhone1());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel update(Realm realm, PPUserInformationLocationOrgModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel realmObject, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addString(columnInfo.sContactName1Index, realmObjectSource.realmGet$sContactName1());
        builder.addString(columnInfo.sContactEmail1Index, realmObjectSource.realmGet$sContactEmail1());
        builder.addString(columnInfo.sContactPhone1Index, realmObjectSource.realmGet$sContactPhone1());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationLocationOrgModel = proxy[");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sName:");
        stringBuilder.append(realmGet$sName() != null ? realmGet$sName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sContactName1:");
        stringBuilder.append(realmGet$sContactName1() != null ? realmGet$sContactName1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sContactEmail1:");
        stringBuilder.append(realmGet$sContactEmail1() != null ? realmGet$sContactEmail1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sContactPhone1:");
        stringBuilder.append(realmGet$sContactPhone1() != null ? realmGet$sContactPhone1() : "null");
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy aPPUserInformationLocationOrgModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationLocationOrgModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationLocationOrgModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationLocationOrgModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
