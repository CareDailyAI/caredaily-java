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
public class com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy extends com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface {

    static final class BundleModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long countIndex;
        long iconIndex;
        long ownedCountIndex;
        long compressedIndex;
        long indexesIndex;
        long modelIdsIndex;
        long mediaTypeIndex;
        long mediaUrlIndex;

        BundleModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("BundleModel");
            this.countIndex = addColumnDetails("count", "count", objectSchemaInfo);
            this.iconIndex = addColumnDetails("icon", "icon", objectSchemaInfo);
            this.ownedCountIndex = addColumnDetails("ownedCount", "ownedCount", objectSchemaInfo);
            this.compressedIndex = addColumnDetails("compressed", "compressed", objectSchemaInfo);
            this.indexesIndex = addColumnDetails("indexes", "indexes", objectSchemaInfo);
            this.modelIdsIndex = addColumnDetails("modelIds", "modelIds", objectSchemaInfo);
            this.mediaTypeIndex = addColumnDetails("mediaType", "mediaType", objectSchemaInfo);
            this.mediaUrlIndex = addColumnDetails("mediaUrl", "mediaUrl", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        BundleModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BundleModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BundleModelColumnInfo src = (BundleModelColumnInfo) rawSrc;
            final BundleModelColumnInfo dst = (BundleModelColumnInfo) rawDst;
            dst.countIndex = src.countIndex;
            dst.iconIndex = src.iconIndex;
            dst.ownedCountIndex = src.ownedCountIndex;
            dst.compressedIndex = src.compressedIndex;
            dst.indexesIndex = src.indexesIndex;
            dst.modelIdsIndex = src.modelIdsIndex;
            dst.mediaTypeIndex = src.mediaTypeIndex;
            dst.mediaUrlIndex = src.mediaUrlIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private BundleModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> proxyState;
    private RealmList<Integer> indexesRealmList;
    private RealmList<String> modelIdsRealmList;

    com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BundleModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$count() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.countIndex);
    }

    @Override
    public void realmSet$count(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.countIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.countIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$icon() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.iconIndex);
    }

    @Override
    public void realmSet$icon(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.iconIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.iconIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.iconIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.iconIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ownedCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ownedCountIndex);
    }

    @Override
    public void realmSet$ownedCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ownedCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ownedCountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$compressed() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.compressedIndex);
    }

    @Override
    public void realmSet$compressed(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.compressedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.compressedIndex, value);
    }

    @Override
    public RealmList<Integer> realmGet$indexes() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (indexesRealmList != null) {
            return indexesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getValueList(columnInfo.indexesIndex, RealmFieldType.INTEGER_LIST);
            indexesRealmList = new RealmList<java.lang.Integer>(java.lang.Integer.class, osList, proxyState.getRealm$realm());
            return indexesRealmList;
        }
    }

    @Override
    public void realmSet$indexes(RealmList<Integer> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("indexes")) {
                return;
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getValueList(columnInfo.indexesIndex, RealmFieldType.INTEGER_LIST);
        osList.removeAll();
        if (value == null) {
            return;
        }
        for (java.lang.Integer item : value) {
            if (item == null) {
                osList.addNull();
            } else {
                osList.addLong(item.longValue());
            }
        }
    }

    @Override
    public RealmList<String> realmGet$modelIds() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (modelIdsRealmList != null) {
            return modelIdsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getValueList(columnInfo.modelIdsIndex, RealmFieldType.STRING_LIST);
            modelIdsRealmList = new RealmList<java.lang.String>(java.lang.String.class, osList, proxyState.getRealm$realm());
            return modelIdsRealmList;
        }
    }

    @Override
    public void realmSet$modelIds(RealmList<String> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("modelIds")) {
                return;
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getValueList(columnInfo.modelIdsIndex, RealmFieldType.STRING_LIST);
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
    @SuppressWarnings("cast")
    public int realmGet$mediaType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mediaTypeIndex);
    }

    @Override
    public void realmSet$mediaType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.mediaTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.mediaTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mediaUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mediaUrlIndex);
    }

    @Override
    public void realmSet$mediaUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mediaUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mediaUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mediaUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mediaUrlIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("BundleModel", 8, 0);
        builder.addPersistedProperty("count", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("icon", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ownedCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("compressed", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedValueListProperty("indexes", RealmFieldType.INTEGER_LIST, !Property.REQUIRED);
        builder.addPersistedValueListProperty("modelIds", RealmFieldType.STRING_LIST, !Property.REQUIRED);
        builder.addPersistedProperty("mediaType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("mediaUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BundleModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BundleModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "BundleModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "BundleModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        if (json.has("indexes")) {
            excludeFields.add("indexes");
        }
        if (json.has("modelIds")) {
            excludeFields.add("modelIds");
        }
        com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) obj;
        if (json.has("count")) {
            if (json.isNull("count")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'count' to null.");
            } else {
                objProxy.realmSet$count((int) json.getInt("count"));
            }
        }
        if (json.has("icon")) {
            if (json.isNull("icon")) {
                objProxy.realmSet$icon(null);
            } else {
                objProxy.realmSet$icon((String) json.getString("icon"));
            }
        }
        if (json.has("ownedCount")) {
            if (json.isNull("ownedCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ownedCount' to null.");
            } else {
                objProxy.realmSet$ownedCount((int) json.getInt("ownedCount"));
            }
        }
        if (json.has("compressed")) {
            if (json.isNull("compressed")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'compressed' to null.");
            } else {
                objProxy.realmSet$compressed((boolean) json.getBoolean("compressed"));
            }
        }
        ProxyUtils.setRealmListWithJsonObject(objProxy.realmGet$indexes(), json, "indexes");
        ProxyUtils.setRealmListWithJsonObject(objProxy.realmGet$modelIds(), json, "modelIds");
        if (json.has("mediaType")) {
            if (json.isNull("mediaType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mediaType' to null.");
            } else {
                objProxy.realmSet$mediaType((int) json.getInt("mediaType"));
            }
        }
        if (json.has("mediaUrl")) {
            if (json.isNull("mediaUrl")) {
                objProxy.realmSet$mediaUrl(null);
            } else {
                objProxy.realmSet$mediaUrl((String) json.getString("mediaUrl"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel obj = new com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel();
        final com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("count")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$count((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'count' to null.");
                }
            } else if (name.equals("icon")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$icon((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$icon(null);
                }
            } else if (name.equals("ownedCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ownedCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ownedCount' to null.");
                }
            } else if (name.equals("compressed")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$compressed((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'compressed' to null.");
                }
            } else if (name.equals("indexes")) {
                objProxy.realmSet$indexes(ProxyUtils.createRealmListWithJsonStream(java.lang.Integer.class, reader));
            } else if (name.equals("modelIds")) {
                objProxy.realmSet$modelIds(ProxyUtils.createRealmListWithJsonStream(java.lang.String.class, reader));
            } else if (name.equals("mediaType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mediaType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mediaType' to null.");
                }
            } else if (name.equals("mediaUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mediaUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mediaUrl(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel copyOrUpdate(Realm realm, BundleModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel copy(Realm realm, BundleModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.countIndex, realmObjectSource.realmGet$count());
        builder.addString(columnInfo.iconIndex, realmObjectSource.realmGet$icon());
        builder.addInteger(columnInfo.ownedCountIndex, realmObjectSource.realmGet$ownedCount());
        builder.addBoolean(columnInfo.compressedIndex, realmObjectSource.realmGet$compressed());
        builder.addIntegerList(columnInfo.indexesIndex, realmObjectSource.realmGet$indexes());
        builder.addStringList(columnInfo.modelIdsIndex, realmObjectSource.realmGet$modelIds());
        builder.addInteger(columnInfo.mediaTypeIndex, realmObjectSource.realmGet$mediaType());
        builder.addString(columnInfo.mediaUrlIndex, realmObjectSource.realmGet$mediaUrl());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        long tableNativePtr = table.getNativePtr();
        BundleModelColumnInfo columnInfo = (BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$count(), false);
        String realmGet$icon = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$icon();
        if (realmGet$icon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ownedCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$ownedCount(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.compressedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$compressed(), false);

        RealmList<java.lang.Integer> indexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$indexes();
        if (indexesList != null) {
            OsList indexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.indexesIndex);
            for (java.lang.Integer indexesItem : indexesList) {
                if (indexesItem == null) {
                    indexesOsList.addNull();
                } else {
                    indexesOsList.addLong(indexesItem.longValue());
                }
            }
        }

        RealmList<java.lang.String> modelIdsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$modelIds();
        if (modelIdsList != null) {
            OsList modelIdsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelIdsIndex);
            for (java.lang.String modelIdsItem : modelIdsList) {
                if (modelIdsItem == null) {
                    modelIdsOsList.addNull();
                } else {
                    modelIdsOsList.addString(modelIdsItem);
                }
            }
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.mediaTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaType(), false);
        String realmGet$mediaUrl = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaUrl();
        if (realmGet$mediaUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mediaUrlIndex, rowIndex, realmGet$mediaUrl, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        long tableNativePtr = table.getNativePtr();
        BundleModelColumnInfo columnInfo = (BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$count(), false);
            String realmGet$icon = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$icon();
            if (realmGet$icon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ownedCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$ownedCount(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.compressedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$compressed(), false);

            RealmList<java.lang.Integer> indexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$indexes();
            if (indexesList != null) {
                OsList indexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.indexesIndex);
                for (java.lang.Integer indexesItem : indexesList) {
                    if (indexesItem == null) {
                        indexesOsList.addNull();
                    } else {
                        indexesOsList.addLong(indexesItem.longValue());
                    }
                }
            }

            RealmList<java.lang.String> modelIdsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$modelIds();
            if (modelIdsList != null) {
                OsList modelIdsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelIdsIndex);
                for (java.lang.String modelIdsItem : modelIdsList) {
                    if (modelIdsItem == null) {
                        modelIdsOsList.addNull();
                    } else {
                        modelIdsOsList.addString(modelIdsItem);
                    }
                }
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.mediaTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaType(), false);
            String realmGet$mediaUrl = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaUrl();
            if (realmGet$mediaUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mediaUrlIndex, rowIndex, realmGet$mediaUrl, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        long tableNativePtr = table.getNativePtr();
        BundleModelColumnInfo columnInfo = (BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$count(), false);
        String realmGet$icon = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$icon();
        if (realmGet$icon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iconIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ownedCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$ownedCount(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.compressedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$compressed(), false);

        OsList indexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.indexesIndex);
        indexesOsList.removeAll();
        RealmList<java.lang.Integer> indexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$indexes();
        if (indexesList != null) {
            for (java.lang.Integer indexesItem : indexesList) {
                if (indexesItem == null) {
                    indexesOsList.addNull();
                } else {
                    indexesOsList.addLong(indexesItem.longValue());
                }
            }
        }


        OsList modelIdsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelIdsIndex);
        modelIdsOsList.removeAll();
        RealmList<java.lang.String> modelIdsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$modelIds();
        if (modelIdsList != null) {
            for (java.lang.String modelIdsItem : modelIdsList) {
                if (modelIdsItem == null) {
                    modelIdsOsList.addNull();
                } else {
                    modelIdsOsList.addString(modelIdsItem);
                }
            }
        }

        Table.nativeSetLong(tableNativePtr, columnInfo.mediaTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaType(), false);
        String realmGet$mediaUrl = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaUrl();
        if (realmGet$mediaUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mediaUrlIndex, rowIndex, realmGet$mediaUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mediaUrlIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        long tableNativePtr = table.getNativePtr();
        BundleModelColumnInfo columnInfo = (BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$count(), false);
            String realmGet$icon = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$icon();
            if (realmGet$icon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.iconIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ownedCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$ownedCount(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.compressedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$compressed(), false);

            OsList indexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.indexesIndex);
            indexesOsList.removeAll();
            RealmList<java.lang.Integer> indexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$indexes();
            if (indexesList != null) {
                for (java.lang.Integer indexesItem : indexesList) {
                    if (indexesItem == null) {
                        indexesOsList.addNull();
                    } else {
                        indexesOsList.addLong(indexesItem.longValue());
                    }
                }
            }


            OsList modelIdsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelIdsIndex);
            modelIdsOsList.removeAll();
            RealmList<java.lang.String> modelIdsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$modelIds();
            if (modelIdsList != null) {
                for (java.lang.String modelIdsItem : modelIdsList) {
                    if (modelIdsItem == null) {
                        modelIdsOsList.addNull();
                    } else {
                        modelIdsOsList.addString(modelIdsItem);
                    }
                }
            }

            Table.nativeSetLong(tableNativePtr, columnInfo.mediaTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaType(), false);
            String realmGet$mediaUrl = ((com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) object).realmGet$mediaUrl();
            if (realmGet$mediaUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mediaUrlIndex, rowIndex, realmGet$mediaUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mediaUrlIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel createDetachedCopy(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$count(realmSource.realmGet$count());
        unmanagedCopy.realmSet$icon(realmSource.realmGet$icon());
        unmanagedCopy.realmSet$ownedCount(realmSource.realmGet$ownedCount());
        unmanagedCopy.realmSet$compressed(realmSource.realmGet$compressed());

        unmanagedCopy.realmSet$indexes(new RealmList<java.lang.Integer>());
        unmanagedCopy.realmGet$indexes().addAll(realmSource.realmGet$indexes());

        unmanagedCopy.realmSet$modelIds(new RealmList<java.lang.String>());
        unmanagedCopy.realmGet$modelIds().addAll(realmSource.realmGet$modelIds());
        unmanagedCopy.realmSet$mediaType(realmSource.realmGet$mediaType());
        unmanagedCopy.realmSet$mediaUrl(realmSource.realmGet$mediaUrl());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BundleModel = proxy[");
        stringBuilder.append("{count:");
        stringBuilder.append(realmGet$count());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{icon:");
        stringBuilder.append(realmGet$icon() != null ? realmGet$icon() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ownedCount:");
        stringBuilder.append(realmGet$ownedCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{compressed:");
        stringBuilder.append(realmGet$compressed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{indexes:");
        stringBuilder.append("RealmList<Integer>[").append(realmGet$indexes().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modelIds:");
        stringBuilder.append("RealmList<String>[").append(realmGet$modelIds().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mediaType:");
        stringBuilder.append(realmGet$mediaType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mediaUrl:");
        stringBuilder.append(realmGet$mediaUrl() != null ? realmGet$mediaUrl() : "null");
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
        com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy aBundleModel = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBundleModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBundleModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBundleModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
