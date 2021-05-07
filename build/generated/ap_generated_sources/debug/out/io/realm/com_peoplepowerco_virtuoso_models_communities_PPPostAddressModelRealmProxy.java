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
public class com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface {

    static final class PPPostAddressModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long addrStreet1Index;
        long addrStreet2Index;
        long addrCityIndex;
        long stateIdIndex;
        long countryIdIndex;
        long zipIndex;

        PPPostAddressModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostAddressModel");
            this.addrStreet1Index = addColumnDetails("addrStreet1", "addrStreet1", objectSchemaInfo);
            this.addrStreet2Index = addColumnDetails("addrStreet2", "addrStreet2", objectSchemaInfo);
            this.addrCityIndex = addColumnDetails("addrCity", "addrCity", objectSchemaInfo);
            this.stateIdIndex = addColumnDetails("stateId", "stateId", objectSchemaInfo);
            this.countryIdIndex = addColumnDetails("countryId", "countryId", objectSchemaInfo);
            this.zipIndex = addColumnDetails("zip", "zip", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostAddressModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostAddressModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostAddressModelColumnInfo src = (PPPostAddressModelColumnInfo) rawSrc;
            final PPPostAddressModelColumnInfo dst = (PPPostAddressModelColumnInfo) rawDst;
            dst.addrStreet1Index = src.addrStreet1Index;
            dst.addrStreet2Index = src.addrStreet2Index;
            dst.addrCityIndex = src.addrCityIndex;
            dst.stateIdIndex = src.stateIdIndex;
            dst.countryIdIndex = src.countryIdIndex;
            dst.zipIndex = src.zipIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostAddressModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostAddressModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$addrStreet1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addrStreet1Index);
    }

    @Override
    public void realmSet$addrStreet1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addrStreet1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addrStreet1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addrStreet1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addrStreet1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$addrStreet2() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addrStreet2Index);
    }

    @Override
    public void realmSet$addrStreet2(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addrStreet2Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addrStreet2Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addrStreet2Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addrStreet2Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$addrCity() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addrCityIndex);
    }

    @Override
    public void realmSet$addrCity(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addrCityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addrCityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addrCityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addrCityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$stateId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stateIdIndex);
    }

    @Override
    public void realmSet$stateId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stateIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stateIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stateIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stateIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$countryId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.countryIdIndex);
    }

    @Override
    public void realmSet$countryId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.countryIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.countryIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.countryIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.countryIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$zip() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.zipIndex);
    }

    @Override
    public void realmSet$zip(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.zipIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.zipIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.zipIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.zipIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostAddressModel", 6, 0);
        builder.addPersistedProperty("addrStreet1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("addrStreet2", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("addrCity", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("stateId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("countryId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("zip", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostAddressModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostAddressModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostAddressModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostAddressModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) obj;
        if (json.has("addrStreet1")) {
            if (json.isNull("addrStreet1")) {
                objProxy.realmSet$addrStreet1(null);
            } else {
                objProxy.realmSet$addrStreet1((String) json.getString("addrStreet1"));
            }
        }
        if (json.has("addrStreet2")) {
            if (json.isNull("addrStreet2")) {
                objProxy.realmSet$addrStreet2(null);
            } else {
                objProxy.realmSet$addrStreet2((String) json.getString("addrStreet2"));
            }
        }
        if (json.has("addrCity")) {
            if (json.isNull("addrCity")) {
                objProxy.realmSet$addrCity(null);
            } else {
                objProxy.realmSet$addrCity((String) json.getString("addrCity"));
            }
        }
        if (json.has("stateId")) {
            if (json.isNull("stateId")) {
                objProxy.realmSet$stateId(null);
            } else {
                objProxy.realmSet$stateId((String) json.getString("stateId"));
            }
        }
        if (json.has("countryId")) {
            if (json.isNull("countryId")) {
                objProxy.realmSet$countryId(null);
            } else {
                objProxy.realmSet$countryId((String) json.getString("countryId"));
            }
        }
        if (json.has("zip")) {
            if (json.isNull("zip")) {
                objProxy.realmSet$zip(null);
            } else {
                objProxy.realmSet$zip((String) json.getString("zip"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("addrStreet1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$addrStreet1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$addrStreet1(null);
                }
            } else if (name.equals("addrStreet2")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$addrStreet2((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$addrStreet2(null);
                }
            } else if (name.equals("addrCity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$addrCity((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$addrCity(null);
                }
            } else if (name.equals("stateId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$stateId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$stateId(null);
                }
            } else if (name.equals("countryId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$countryId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$countryId(null);
                }
            } else if (name.equals("zip")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$zip((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$zip(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel copyOrUpdate(Realm realm, PPPostAddressModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel copy(Realm realm, PPPostAddressModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.addrStreet1Index, realmObjectSource.realmGet$addrStreet1());
        builder.addString(columnInfo.addrStreet2Index, realmObjectSource.realmGet$addrStreet2());
        builder.addString(columnInfo.addrCityIndex, realmObjectSource.realmGet$addrCity());
        builder.addString(columnInfo.stateIdIndex, realmObjectSource.realmGet$stateId());
        builder.addString(columnInfo.countryIdIndex, realmObjectSource.realmGet$countryId());
        builder.addString(columnInfo.zipIndex, realmObjectSource.realmGet$zip());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostAddressModelColumnInfo columnInfo = (PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$addrStreet1 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet1();
        if (realmGet$addrStreet1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addrStreet1Index, rowIndex, realmGet$addrStreet1, false);
        }
        String realmGet$addrStreet2 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet2();
        if (realmGet$addrStreet2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addrStreet2Index, rowIndex, realmGet$addrStreet2, false);
        }
        String realmGet$addrCity = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrCity();
        if (realmGet$addrCity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addrCityIndex, rowIndex, realmGet$addrCity, false);
        }
        String realmGet$stateId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$stateId();
        if (realmGet$stateId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
        }
        String realmGet$countryId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$countryId();
        if (realmGet$countryId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countryIdIndex, rowIndex, realmGet$countryId, false);
        }
        String realmGet$zip = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$zip();
        if (realmGet$zip != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.zipIndex, rowIndex, realmGet$zip, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostAddressModelColumnInfo columnInfo = (PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$addrStreet1 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet1();
            if (realmGet$addrStreet1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addrStreet1Index, rowIndex, realmGet$addrStreet1, false);
            }
            String realmGet$addrStreet2 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet2();
            if (realmGet$addrStreet2 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addrStreet2Index, rowIndex, realmGet$addrStreet2, false);
            }
            String realmGet$addrCity = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrCity();
            if (realmGet$addrCity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addrCityIndex, rowIndex, realmGet$addrCity, false);
            }
            String realmGet$stateId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$stateId();
            if (realmGet$stateId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
            }
            String realmGet$countryId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$countryId();
            if (realmGet$countryId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.countryIdIndex, rowIndex, realmGet$countryId, false);
            }
            String realmGet$zip = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$zip();
            if (realmGet$zip != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.zipIndex, rowIndex, realmGet$zip, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostAddressModelColumnInfo columnInfo = (PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$addrStreet1 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet1();
        if (realmGet$addrStreet1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addrStreet1Index, rowIndex, realmGet$addrStreet1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addrStreet1Index, rowIndex, false);
        }
        String realmGet$addrStreet2 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet2();
        if (realmGet$addrStreet2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addrStreet2Index, rowIndex, realmGet$addrStreet2, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addrStreet2Index, rowIndex, false);
        }
        String realmGet$addrCity = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrCity();
        if (realmGet$addrCity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addrCityIndex, rowIndex, realmGet$addrCity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addrCityIndex, rowIndex, false);
        }
        String realmGet$stateId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$stateId();
        if (realmGet$stateId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stateIdIndex, rowIndex, false);
        }
        String realmGet$countryId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$countryId();
        if (realmGet$countryId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countryIdIndex, rowIndex, realmGet$countryId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.countryIdIndex, rowIndex, false);
        }
        String realmGet$zip = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$zip();
        if (realmGet$zip != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.zipIndex, rowIndex, realmGet$zip, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.zipIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostAddressModelColumnInfo columnInfo = (PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$addrStreet1 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet1();
            if (realmGet$addrStreet1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addrStreet1Index, rowIndex, realmGet$addrStreet1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addrStreet1Index, rowIndex, false);
            }
            String realmGet$addrStreet2 = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrStreet2();
            if (realmGet$addrStreet2 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addrStreet2Index, rowIndex, realmGet$addrStreet2, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addrStreet2Index, rowIndex, false);
            }
            String realmGet$addrCity = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$addrCity();
            if (realmGet$addrCity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addrCityIndex, rowIndex, realmGet$addrCity, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addrCityIndex, rowIndex, false);
            }
            String realmGet$stateId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$stateId();
            if (realmGet$stateId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stateIdIndex, rowIndex, realmGet$stateId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.stateIdIndex, rowIndex, false);
            }
            String realmGet$countryId = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$countryId();
            if (realmGet$countryId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.countryIdIndex, rowIndex, realmGet$countryId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.countryIdIndex, rowIndex, false);
            }
            String realmGet$zip = ((com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) object).realmGet$zip();
            if (realmGet$zip != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.zipIndex, rowIndex, realmGet$zip, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.zipIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$addrStreet1(realmSource.realmGet$addrStreet1());
        unmanagedCopy.realmSet$addrStreet2(realmSource.realmGet$addrStreet2());
        unmanagedCopy.realmSet$addrCity(realmSource.realmGet$addrCity());
        unmanagedCopy.realmSet$stateId(realmSource.realmGet$stateId());
        unmanagedCopy.realmSet$countryId(realmSource.realmGet$countryId());
        unmanagedCopy.realmSet$zip(realmSource.realmGet$zip());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostAddressModel = proxy[");
        stringBuilder.append("{addrStreet1:");
        stringBuilder.append(realmGet$addrStreet1() != null ? realmGet$addrStreet1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addrStreet2:");
        stringBuilder.append(realmGet$addrStreet2() != null ? realmGet$addrStreet2() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{addrCity:");
        stringBuilder.append(realmGet$addrCity() != null ? realmGet$addrCity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stateId:");
        stringBuilder.append(realmGet$stateId() != null ? realmGet$stateId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{countryId:");
        stringBuilder.append(realmGet$countryId() != null ? realmGet$countryId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{zip:");
        stringBuilder.append(realmGet$zip() != null ? realmGet$zip() : "null");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy aPPPostAddressModel = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostAddressModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostAddressModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostAddressModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
