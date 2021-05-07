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
public class com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy extends com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface {

    static final class PPDeviceGoalsModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long deviceTypeIndex;
        long nWeightIndex;
        long sNameIndex;
        long sIconIndex;
        long sIconFontIndex;
        long sDescIndex;
        long suggestionListIndex;
        long spaceListIndex;

        PPDeviceGoalsModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPDeviceGoalsModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.deviceTypeIndex = addColumnDetails("deviceType", "deviceType", objectSchemaInfo);
            this.nWeightIndex = addColumnDetails("nWeight", "nWeight", objectSchemaInfo);
            this.sNameIndex = addColumnDetails("sName", "sName", objectSchemaInfo);
            this.sIconIndex = addColumnDetails("sIcon", "sIcon", objectSchemaInfo);
            this.sIconFontIndex = addColumnDetails("sIconFont", "sIconFont", objectSchemaInfo);
            this.sDescIndex = addColumnDetails("sDesc", "sDesc", objectSchemaInfo);
            this.suggestionListIndex = addColumnDetails("suggestionList", "suggestionList", objectSchemaInfo);
            this.spaceListIndex = addColumnDetails("spaceList", "spaceList", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPDeviceGoalsModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPDeviceGoalsModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPDeviceGoalsModelColumnInfo src = (PPDeviceGoalsModelColumnInfo) rawSrc;
            final PPDeviceGoalsModelColumnInfo dst = (PPDeviceGoalsModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.deviceTypeIndex = src.deviceTypeIndex;
            dst.nWeightIndex = src.nWeightIndex;
            dst.sNameIndex = src.sNameIndex;
            dst.sIconIndex = src.sIconIndex;
            dst.sIconFontIndex = src.sIconFontIndex;
            dst.sDescIndex = src.sDescIndex;
            dst.suggestionListIndex = src.suggestionListIndex;
            dst.spaceListIndex = src.spaceListIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPDeviceGoalsModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel> proxyState;
    private RealmList<String> suggestionListRealmList;
    private RealmList<String> spaceListRealmList;

    com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPDeviceGoalsModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$deviceType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.deviceTypeIndex);
    }

    @Override
    public void realmSet$deviceType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.deviceTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.deviceTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nWeight() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nWeightIndex);
    }

    @Override
    public void realmSet$nWeight(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nWeightIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nWeightIndex, value);
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
    public String realmGet$sIcon() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sIconIndex);
    }

    @Override
    public void realmSet$sIcon(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sIconIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sIconIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sIconIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sIconIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sIconFont() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sIconFontIndex);
    }

    @Override
    public void realmSet$sIconFont(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sIconFontIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sIconFontIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sIconFontIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sIconFontIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sDesc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sDescIndex);
    }

    @Override
    public void realmSet$sDesc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sDescIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sDescIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sDescIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sDescIndex, value);
    }

    @Override
    public RealmList<String> realmGet$suggestionList() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (suggestionListRealmList != null) {
            return suggestionListRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getValueList(columnInfo.suggestionListIndex, RealmFieldType.STRING_LIST);
            suggestionListRealmList = new RealmList<java.lang.String>(java.lang.String.class, osList, proxyState.getRealm$realm());
            return suggestionListRealmList;
        }
    }

    @Override
    public void realmSet$suggestionList(RealmList<String> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("suggestionList")) {
                return;
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getValueList(columnInfo.suggestionListIndex, RealmFieldType.STRING_LIST);
        osList.removeAll();
        if (value == null) {
            return;
        }
        for (java.lang.String item : value) {
            if (item == null) {
                osList.addNull();
            } else {
                osList.addString(item);
            }
        }
    }

    @Override
    public RealmList<String> realmGet$spaceList() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (spaceListRealmList != null) {
            return spaceListRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getValueList(columnInfo.spaceListIndex, RealmFieldType.STRING_LIST);
            spaceListRealmList = new RealmList<java.lang.String>(java.lang.String.class, osList, proxyState.getRealm$realm());
            return spaceListRealmList;
        }
    }

    @Override
    public void realmSet$spaceList(RealmList<String> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("spaceList")) {
                return;
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getValueList(columnInfo.spaceListIndex, RealmFieldType.STRING_LIST);
        osList.removeAll();
        if (value == null) {
            return;
        }
        for (java.lang.String item : value) {
            if (item == null) {
                osList.addNull();
            } else {
                osList.addString(item);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPDeviceGoalsModel", 9, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("deviceType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nWeight", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sIcon", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sIconFont", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sDesc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedValueListProperty("suggestionList", RealmFieldType.STRING_LIST, !Property.REQUIRED);
        builder.addPersistedValueListProperty("spaceList", RealmFieldType.STRING_LIST, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPDeviceGoalsModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPDeviceGoalsModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPDeviceGoalsModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPDeviceGoalsModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        if (json.has("suggestionList")) {
            excludeFields.add("suggestionList");
        }
        if (json.has("spaceList")) {
            excludeFields.add("spaceList");
        }
        com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("deviceType")) {
            if (json.isNull("deviceType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'deviceType' to null.");
            } else {
                objProxy.realmSet$deviceType((int) json.getInt("deviceType"));
            }
        }
        if (json.has("nWeight")) {
            if (json.isNull("nWeight")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nWeight' to null.");
            } else {
                objProxy.realmSet$nWeight((int) json.getInt("nWeight"));
            }
        }
        if (json.has("sName")) {
            if (json.isNull("sName")) {
                objProxy.realmSet$sName(null);
            } else {
                objProxy.realmSet$sName((String) json.getString("sName"));
            }
        }
        if (json.has("sIcon")) {
            if (json.isNull("sIcon")) {
                objProxy.realmSet$sIcon(null);
            } else {
                objProxy.realmSet$sIcon((String) json.getString("sIcon"));
            }
        }
        if (json.has("sIconFont")) {
            if (json.isNull("sIconFont")) {
                objProxy.realmSet$sIconFont(null);
            } else {
                objProxy.realmSet$sIconFont((String) json.getString("sIconFont"));
            }
        }
        if (json.has("sDesc")) {
            if (json.isNull("sDesc")) {
                objProxy.realmSet$sDesc(null);
            } else {
                objProxy.realmSet$sDesc((String) json.getString("sDesc"));
            }
        }
        ProxyUtils.setRealmListWithJsonObject(objProxy.realmGet$suggestionList(), json, "suggestionList");
        ProxyUtils.setRealmListWithJsonObject(objProxy.realmGet$spaceList(), json, "spaceList");
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel obj = new com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel();
        final com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
            } else if (name.equals("deviceType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$deviceType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'deviceType' to null.");
                }
            } else if (name.equals("nWeight")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nWeight((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nWeight' to null.");
                }
            } else if (name.equals("sName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sName(null);
                }
            } else if (name.equals("sIcon")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sIcon((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sIcon(null);
                }
            } else if (name.equals("sIconFont")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sIconFont((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sIconFont(null);
                }
            } else if (name.equals("sDesc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sDesc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sDesc(null);
                }
            } else if (name.equals("suggestionList")) {
                objProxy.realmSet$suggestionList(ProxyUtils.createRealmListWithJsonStream(java.lang.String.class, reader));
            } else if (name.equals("spaceList")) {
                objProxy.realmSet$spaceList(ProxyUtils.createRealmListWithJsonStream(java.lang.String.class, reader));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel copyOrUpdate(Realm realm, PPDeviceGoalsModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel copy(Realm realm, PPDeviceGoalsModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.deviceTypeIndex, realmObjectSource.realmGet$deviceType());
        builder.addInteger(columnInfo.nWeightIndex, realmObjectSource.realmGet$nWeight());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addString(columnInfo.sIconIndex, realmObjectSource.realmGet$sIcon());
        builder.addString(columnInfo.sIconFontIndex, realmObjectSource.realmGet$sIconFont());
        builder.addString(columnInfo.sDescIndex, realmObjectSource.realmGet$sDesc());
        builder.addStringList(columnInfo.suggestionListIndex, realmObjectSource.realmGet$suggestionList());
        builder.addStringList(columnInfo.spaceListIndex, realmObjectSource.realmGet$spaceList());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        long tableNativePtr = table.getNativePtr();
        PPDeviceGoalsModelColumnInfo columnInfo = (PPDeviceGoalsModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.deviceTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$deviceType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nWeightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$nWeight(), false);
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        }
        String realmGet$sIcon = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIcon();
        if (realmGet$sIcon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sIconIndex, rowIndex, realmGet$sIcon, false);
        }
        String realmGet$sIconFont = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIconFont();
        if (realmGet$sIconFont != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sIconFontIndex, rowIndex, realmGet$sIconFont, false);
        }
        String realmGet$sDesc = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sDesc();
        if (realmGet$sDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sDescIndex, rowIndex, realmGet$sDesc, false);
        }

        RealmList<java.lang.String> suggestionListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$suggestionList();
        if (suggestionListList != null) {
            OsList suggestionListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionListIndex);
            for (java.lang.String suggestionListItem : suggestionListList) {
                if (suggestionListItem == null) {
                    suggestionListOsList.addNull();
                } else {
                    suggestionListOsList.addString(suggestionListItem);
                }
            }
        }

        RealmList<java.lang.String> spaceListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$spaceList();
        if (spaceListList != null) {
            OsList spaceListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.spaceListIndex);
            for (java.lang.String spaceListItem : spaceListList) {
                if (spaceListItem == null) {
                    spaceListOsList.addNull();
                } else {
                    spaceListOsList.addString(spaceListItem);
                }
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        long tableNativePtr = table.getNativePtr();
        PPDeviceGoalsModelColumnInfo columnInfo = (PPDeviceGoalsModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.deviceTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$deviceType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nWeightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$nWeight(), false);
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            }
            String realmGet$sIcon = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIcon();
            if (realmGet$sIcon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sIconIndex, rowIndex, realmGet$sIcon, false);
            }
            String realmGet$sIconFont = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIconFont();
            if (realmGet$sIconFont != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sIconFontIndex, rowIndex, realmGet$sIconFont, false);
            }
            String realmGet$sDesc = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sDesc();
            if (realmGet$sDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sDescIndex, rowIndex, realmGet$sDesc, false);
            }

            RealmList<java.lang.String> suggestionListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$suggestionList();
            if (suggestionListList != null) {
                OsList suggestionListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionListIndex);
                for (java.lang.String suggestionListItem : suggestionListList) {
                    if (suggestionListItem == null) {
                        suggestionListOsList.addNull();
                    } else {
                        suggestionListOsList.addString(suggestionListItem);
                    }
                }
            }

            RealmList<java.lang.String> spaceListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$spaceList();
            if (spaceListList != null) {
                OsList spaceListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.spaceListIndex);
                for (java.lang.String spaceListItem : spaceListList) {
                    if (spaceListItem == null) {
                        spaceListOsList.addNull();
                    } else {
                        spaceListOsList.addString(spaceListItem);
                    }
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        long tableNativePtr = table.getNativePtr();
        PPDeviceGoalsModelColumnInfo columnInfo = (PPDeviceGoalsModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.deviceTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$deviceType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nWeightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$nWeight(), false);
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
        }
        String realmGet$sIcon = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIcon();
        if (realmGet$sIcon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sIconIndex, rowIndex, realmGet$sIcon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sIconIndex, rowIndex, false);
        }
        String realmGet$sIconFont = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIconFont();
        if (realmGet$sIconFont != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sIconFontIndex, rowIndex, realmGet$sIconFont, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sIconFontIndex, rowIndex, false);
        }
        String realmGet$sDesc = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sDesc();
        if (realmGet$sDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sDescIndex, rowIndex, realmGet$sDesc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sDescIndex, rowIndex, false);
        }

        OsList suggestionListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionListIndex);
        suggestionListOsList.removeAll();
        RealmList<java.lang.String> suggestionListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$suggestionList();
        if (suggestionListList != null) {
            for (java.lang.String suggestionListItem : suggestionListList) {
                if (suggestionListItem == null) {
                    suggestionListOsList.addNull();
                } else {
                    suggestionListOsList.addString(suggestionListItem);
                }
            }
        }


        OsList spaceListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.spaceListIndex);
        spaceListOsList.removeAll();
        RealmList<java.lang.String> spaceListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$spaceList();
        if (spaceListList != null) {
            for (java.lang.String spaceListItem : spaceListList) {
                if (spaceListItem == null) {
                    spaceListOsList.addNull();
                } else {
                    spaceListOsList.addString(spaceListItem);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        long tableNativePtr = table.getNativePtr();
        PPDeviceGoalsModelColumnInfo columnInfo = (PPDeviceGoalsModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.deviceTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$deviceType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nWeightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$nWeight(), false);
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
            }
            String realmGet$sIcon = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIcon();
            if (realmGet$sIcon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sIconIndex, rowIndex, realmGet$sIcon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sIconIndex, rowIndex, false);
            }
            String realmGet$sIconFont = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sIconFont();
            if (realmGet$sIconFont != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sIconFontIndex, rowIndex, realmGet$sIconFont, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sIconFontIndex, rowIndex, false);
            }
            String realmGet$sDesc = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$sDesc();
            if (realmGet$sDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sDescIndex, rowIndex, realmGet$sDesc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sDescIndex, rowIndex, false);
            }

            OsList suggestionListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionListIndex);
            suggestionListOsList.removeAll();
            RealmList<java.lang.String> suggestionListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$suggestionList();
            if (suggestionListList != null) {
                for (java.lang.String suggestionListItem : suggestionListList) {
                    if (suggestionListItem == null) {
                        suggestionListOsList.addNull();
                    } else {
                        suggestionListOsList.addString(suggestionListItem);
                    }
                }
            }


            OsList spaceListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.spaceListIndex);
            spaceListOsList.removeAll();
            RealmList<java.lang.String> spaceListList = ((com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) object).realmGet$spaceList();
            if (spaceListList != null) {
                for (java.lang.String spaceListItem : spaceListList) {
                    if (spaceListItem == null) {
                        spaceListOsList.addNull();
                    } else {
                        spaceListOsList.addString(spaceListItem);
                    }
                }
            }

        }
    }

    public static com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel createDetachedCopy(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$deviceType(realmSource.realmGet$deviceType());
        unmanagedCopy.realmSet$nWeight(realmSource.realmGet$nWeight());
        unmanagedCopy.realmSet$sName(realmSource.realmGet$sName());
        unmanagedCopy.realmSet$sIcon(realmSource.realmGet$sIcon());
        unmanagedCopy.realmSet$sIconFont(realmSource.realmGet$sIconFont());
        unmanagedCopy.realmSet$sDesc(realmSource.realmGet$sDesc());

        unmanagedCopy.realmSet$suggestionList(new RealmList<java.lang.String>());
        unmanagedCopy.realmGet$suggestionList().addAll(realmSource.realmGet$suggestionList());

        unmanagedCopy.realmSet$spaceList(new RealmList<java.lang.String>());
        unmanagedCopy.realmGet$spaceList().addAll(realmSource.realmGet$spaceList());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPDeviceGoalsModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deviceType:");
        stringBuilder.append(realmGet$deviceType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nWeight:");
        stringBuilder.append(realmGet$nWeight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sName:");
        stringBuilder.append(realmGet$sName() != null ? realmGet$sName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sIcon:");
        stringBuilder.append(realmGet$sIcon() != null ? realmGet$sIcon() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sIconFont:");
        stringBuilder.append(realmGet$sIconFont() != null ? realmGet$sIconFont() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sDesc:");
        stringBuilder.append(realmGet$sDesc() != null ? realmGet$sDesc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{suggestionList:");
        stringBuilder.append("RealmList<String>[").append(realmGet$suggestionList().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{spaceList:");
        stringBuilder.append("RealmList<String>[").append(realmGet$spaceList().size()).append("]");
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
        com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy aPPDeviceGoalsModel = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPDeviceGoalsModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPDeviceGoalsModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPDeviceGoalsModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
