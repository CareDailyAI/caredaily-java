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
public class com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy extends com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface {

    static final class DeviceBundleColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long storyIdIndex;
        long idIndex;
        long titleIndex;
        long descIndex;
        long bundlePageIndexIndex;
        long bundlePageSizeIndex;
        long hasEnoughDeviceIndex;
        long iconIndexesIndex;
        long accessoriesIndex;
        long modelsIndex;

        DeviceBundleColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DeviceBundle");
            this.storyIdIndex = addColumnDetails("storyId", "storyId", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.descIndex = addColumnDetails("desc", "desc", objectSchemaInfo);
            this.bundlePageIndexIndex = addColumnDetails("bundlePageIndex", "bundlePageIndex", objectSchemaInfo);
            this.bundlePageSizeIndex = addColumnDetails("bundlePageSize", "bundlePageSize", objectSchemaInfo);
            this.hasEnoughDeviceIndex = addColumnDetails("hasEnoughDevice", "hasEnoughDevice", objectSchemaInfo);
            this.iconIndexesIndex = addColumnDetails("iconIndexes", "iconIndexes", objectSchemaInfo);
            this.accessoriesIndex = addColumnDetails("accessories", "accessories", objectSchemaInfo);
            this.modelsIndex = addColumnDetails("models", "models", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        DeviceBundleColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DeviceBundleColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DeviceBundleColumnInfo src = (DeviceBundleColumnInfo) rawSrc;
            final DeviceBundleColumnInfo dst = (DeviceBundleColumnInfo) rawDst;
            dst.storyIdIndex = src.storyIdIndex;
            dst.idIndex = src.idIndex;
            dst.titleIndex = src.titleIndex;
            dst.descIndex = src.descIndex;
            dst.bundlePageIndexIndex = src.bundlePageIndexIndex;
            dst.bundlePageSizeIndex = src.bundlePageSizeIndex;
            dst.hasEnoughDeviceIndex = src.hasEnoughDeviceIndex;
            dst.iconIndexesIndex = src.iconIndexesIndex;
            dst.accessoriesIndex = src.accessoriesIndex;
            dst.modelsIndex = src.modelsIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DeviceBundleColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle> proxyState;
    private RealmList<Integer> iconIndexesRealmList;
    private RealmList<String> accessoriesRealmList;
    private RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsRealmList;

    com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DeviceBundleColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$storyId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.storyIdIndex);
    }

    @Override
    public void realmSet$storyId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'storyId' cannot be changed after object was created.");
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
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$desc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descIndex);
    }

    @Override
    public void realmSet$desc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$bundlePageIndex() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.bundlePageIndexIndex);
    }

    @Override
    public void realmSet$bundlePageIndex(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.bundlePageIndexIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.bundlePageIndexIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$bundlePageSize() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.bundlePageSizeIndex);
    }

    @Override
    public void realmSet$bundlePageSize(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.bundlePageSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.bundlePageSizeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$hasEnoughDevice() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.hasEnoughDeviceIndex);
    }

    @Override
    public void realmSet$hasEnoughDevice(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.hasEnoughDeviceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.hasEnoughDeviceIndex, value);
    }

    @Override
    public RealmList<Integer> realmGet$iconIndexes() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (iconIndexesRealmList != null) {
            return iconIndexesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getValueList(columnInfo.iconIndexesIndex, RealmFieldType.INTEGER_LIST);
            iconIndexesRealmList = new RealmList<java.lang.Integer>(java.lang.Integer.class, osList, proxyState.getRealm$realm());
            return iconIndexesRealmList;
        }
    }

    @Override
    public void realmSet$iconIndexes(RealmList<Integer> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("iconIndexes")) {
                return;
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getValueList(columnInfo.iconIndexesIndex, RealmFieldType.INTEGER_LIST);
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
    public RealmList<String> realmGet$accessories() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (accessoriesRealmList != null) {
            return accessoriesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getValueList(columnInfo.accessoriesIndex, RealmFieldType.STRING_LIST);
            accessoriesRealmList = new RealmList<java.lang.String>(java.lang.String.class, osList, proxyState.getRealm$realm());
            return accessoriesRealmList;
        }
    }

    @Override
    public void realmSet$accessories(RealmList<String> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("accessories")) {
                return;
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getValueList(columnInfo.accessoriesIndex, RealmFieldType.STRING_LIST);
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
    public RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> realmGet$models() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (modelsRealmList != null) {
            return modelsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.modelsIndex);
            modelsRealmList = new RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class, osList, proxyState.getRealm$realm());
            return modelsRealmList;
        }
    }

    @Override
    public void realmSet$models(RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("models")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> original = value;
                value = new RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>();
                for (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.modelsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DeviceBundle", 10, 0);
        builder.addPersistedProperty("storyId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("desc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("bundlePageIndex", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("bundlePageSize", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("hasEnoughDevice", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedValueListProperty("iconIndexes", RealmFieldType.INTEGER_LIST, !Property.REQUIRED);
        builder.addPersistedValueListProperty("accessories", RealmFieldType.STRING_LIST, !Property.REQUIRED);
        builder.addPersistedLinkProperty("models", RealmFieldType.LIST, "BundleModel");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DeviceBundleColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DeviceBundleColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DeviceBundle";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "DeviceBundle";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
            DeviceBundleColumnInfo columnInfo = (DeviceBundleColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
            long pkColumnIndex = columnInfo.storyIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("storyId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("storyId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("iconIndexes")) {
                excludeFields.add("iconIndexes");
            }
            if (json.has("accessories")) {
                excludeFields.add("accessories");
            }
            if (json.has("models")) {
                excludeFields.add("models");
            }
            if (json.has("storyId")) {
                if (json.isNull("storyId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class, json.getString("storyId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'storyId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("desc")) {
            if (json.isNull("desc")) {
                objProxy.realmSet$desc(null);
            } else {
                objProxy.realmSet$desc((String) json.getString("desc"));
            }
        }
        if (json.has("bundlePageIndex")) {
            if (json.isNull("bundlePageIndex")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bundlePageIndex' to null.");
            } else {
                objProxy.realmSet$bundlePageIndex((int) json.getInt("bundlePageIndex"));
            }
        }
        if (json.has("bundlePageSize")) {
            if (json.isNull("bundlePageSize")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bundlePageSize' to null.");
            } else {
                objProxy.realmSet$bundlePageSize((int) json.getInt("bundlePageSize"));
            }
        }
        if (json.has("hasEnoughDevice")) {
            if (json.isNull("hasEnoughDevice")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hasEnoughDevice' to null.");
            } else {
                objProxy.realmSet$hasEnoughDevice((boolean) json.getBoolean("hasEnoughDevice"));
            }
        }
        ProxyUtils.setRealmListWithJsonObject(objProxy.realmGet$iconIndexes(), json, "iconIndexes");
        ProxyUtils.setRealmListWithJsonObject(objProxy.realmGet$accessories(), json, "accessories");
        if (json.has("models")) {
            if (json.isNull("models")) {
                objProxy.realmSet$models(null);
            } else {
                objProxy.realmGet$models().clear();
                JSONArray array = json.getJSONArray("models");
                for (int i = 0; i < array.length(); i++) {
                    com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel item = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$models().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle obj = new com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle();
        final com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("storyId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$storyId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$storyId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("desc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$desc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$desc(null);
                }
            } else if (name.equals("bundlePageIndex")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bundlePageIndex((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bundlePageIndex' to null.");
                }
            } else if (name.equals("bundlePageSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bundlePageSize((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bundlePageSize' to null.");
                }
            } else if (name.equals("hasEnoughDevice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hasEnoughDevice((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hasEnoughDevice' to null.");
                }
            } else if (name.equals("iconIndexes")) {
                objProxy.realmSet$iconIndexes(ProxyUtils.createRealmListWithJsonStream(java.lang.Integer.class, reader));
            } else if (name.equals("accessories")) {
                objProxy.realmSet$accessories(ProxyUtils.createRealmListWithJsonStream(java.lang.String.class, reader));
            } else if (name.equals("models")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$models(null);
                } else {
                    objProxy.realmSet$models(new RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel item = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$models().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'storyId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle copyOrUpdate(Realm realm, DeviceBundleColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
            long pkColumnIndex = columnInfo.storyIdIndex;
            String value = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$storyId();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle copy(Realm realm, DeviceBundleColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.storyIdIndex, realmObjectSource.realmGet$storyId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.descIndex, realmObjectSource.realmGet$desc());
        builder.addInteger(columnInfo.bundlePageIndexIndex, realmObjectSource.realmGet$bundlePageIndex());
        builder.addInteger(columnInfo.bundlePageSizeIndex, realmObjectSource.realmGet$bundlePageSize());
        builder.addBoolean(columnInfo.hasEnoughDeviceIndex, realmObjectSource.realmGet$hasEnoughDevice());
        builder.addIntegerList(columnInfo.iconIndexesIndex, realmObjectSource.realmGet$iconIndexes());
        builder.addStringList(columnInfo.accessoriesIndex, realmObjectSource.realmGet$accessories());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsList = realmObjectSource.realmGet$models();
        if (modelsList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsRealmList = realmObjectCopy.realmGet$models();
            modelsRealmList.clear();
            for (int i = 0; i < modelsList.size(); i++) {
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem = modelsList.get(i);
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel cachemodels = (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) cache.get(modelsItem);
                if (cachemodels != null) {
                    modelsRealmList.add(cachemodels);
                } else {
                    modelsRealmList.add(com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class), modelsItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long tableNativePtr = table.getNativePtr();
        DeviceBundleColumnInfo columnInfo = (DeviceBundleColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long pkColumnIndex = columnInfo.storyIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$storyId();
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
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$desc = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$desc();
        if (realmGet$desc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descIndex, rowIndex, realmGet$desc, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageIndexIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageIndex(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageSizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageSize(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hasEnoughDeviceIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$hasEnoughDevice(), false);

        RealmList<java.lang.Integer> iconIndexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$iconIndexes();
        if (iconIndexesList != null) {
            OsList iconIndexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.iconIndexesIndex);
            for (java.lang.Integer iconIndexesItem : iconIndexesList) {
                if (iconIndexesItem == null) {
                    iconIndexesOsList.addNull();
                } else {
                    iconIndexesOsList.addLong(iconIndexesItem.longValue());
                }
            }
        }

        RealmList<java.lang.String> accessoriesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$accessories();
        if (accessoriesList != null) {
            OsList accessoriesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.accessoriesIndex);
            for (java.lang.String accessoriesItem : accessoriesList) {
                if (accessoriesItem == null) {
                    accessoriesOsList.addNull();
                } else {
                    accessoriesOsList.addString(accessoriesItem);
                }
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$models();
        if (modelsList != null) {
            OsList modelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelsIndex);
            for (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem : modelsList) {
                Long cacheItemIndexmodels = cache.get(modelsItem);
                if (cacheItemIndexmodels == null) {
                    cacheItemIndexmodels = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insert(realm, modelsItem, cache);
                }
                modelsOsList.addRow(cacheItemIndexmodels);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long tableNativePtr = table.getNativePtr();
        DeviceBundleColumnInfo columnInfo = (DeviceBundleColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long pkColumnIndex = columnInfo.storyIdIndex;
        com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$storyId();
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
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$desc = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$desc();
            if (realmGet$desc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descIndex, rowIndex, realmGet$desc, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageIndexIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageIndex(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageSizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageSize(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hasEnoughDeviceIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$hasEnoughDevice(), false);

            RealmList<java.lang.Integer> iconIndexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$iconIndexes();
            if (iconIndexesList != null) {
                OsList iconIndexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.iconIndexesIndex);
                for (java.lang.Integer iconIndexesItem : iconIndexesList) {
                    if (iconIndexesItem == null) {
                        iconIndexesOsList.addNull();
                    } else {
                        iconIndexesOsList.addLong(iconIndexesItem.longValue());
                    }
                }
            }

            RealmList<java.lang.String> accessoriesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$accessories();
            if (accessoriesList != null) {
                OsList accessoriesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.accessoriesIndex);
                for (java.lang.String accessoriesItem : accessoriesList) {
                    if (accessoriesItem == null) {
                        accessoriesOsList.addNull();
                    } else {
                        accessoriesOsList.addString(accessoriesItem);
                    }
                }
            }

            RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$models();
            if (modelsList != null) {
                OsList modelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelsIndex);
                for (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem : modelsList) {
                    Long cacheItemIndexmodels = cache.get(modelsItem);
                    if (cacheItemIndexmodels == null) {
                        cacheItemIndexmodels = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insert(realm, modelsItem, cache);
                    }
                    modelsOsList.addRow(cacheItemIndexmodels);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long tableNativePtr = table.getNativePtr();
        DeviceBundleColumnInfo columnInfo = (DeviceBundleColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long pkColumnIndex = columnInfo.storyIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$storyId();
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
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$desc = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$desc();
        if (realmGet$desc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descIndex, rowIndex, realmGet$desc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageIndexIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageIndex(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageSizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageSize(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hasEnoughDeviceIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$hasEnoughDevice(), false);

        OsList iconIndexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.iconIndexesIndex);
        iconIndexesOsList.removeAll();
        RealmList<java.lang.Integer> iconIndexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$iconIndexes();
        if (iconIndexesList != null) {
            for (java.lang.Integer iconIndexesItem : iconIndexesList) {
                if (iconIndexesItem == null) {
                    iconIndexesOsList.addNull();
                } else {
                    iconIndexesOsList.addLong(iconIndexesItem.longValue());
                }
            }
        }


        OsList accessoriesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.accessoriesIndex);
        accessoriesOsList.removeAll();
        RealmList<java.lang.String> accessoriesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$accessories();
        if (accessoriesList != null) {
            for (java.lang.String accessoriesItem : accessoriesList) {
                if (accessoriesItem == null) {
                    accessoriesOsList.addNull();
                } else {
                    accessoriesOsList.addString(accessoriesItem);
                }
            }
        }


        OsList modelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelsIndex);
        RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$models();
        if (modelsList != null && modelsList.size() == modelsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = modelsList.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem = modelsList.get(i);
                Long cacheItemIndexmodels = cache.get(modelsItem);
                if (cacheItemIndexmodels == null) {
                    cacheItemIndexmodels = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, modelsItem, cache);
                }
                modelsOsList.setRow(i, cacheItemIndexmodels);
            }
        } else {
            modelsOsList.removeAll();
            if (modelsList != null) {
                for (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem : modelsList) {
                    Long cacheItemIndexmodels = cache.get(modelsItem);
                    if (cacheItemIndexmodels == null) {
                        cacheItemIndexmodels = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, modelsItem, cache);
                    }
                    modelsOsList.addRow(cacheItemIndexmodels);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long tableNativePtr = table.getNativePtr();
        DeviceBundleColumnInfo columnInfo = (DeviceBundleColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        long pkColumnIndex = columnInfo.storyIdIndex;
        com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$storyId();
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
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$desc = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$desc();
            if (realmGet$desc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descIndex, rowIndex, realmGet$desc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageIndexIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageIndex(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.bundlePageSizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$bundlePageSize(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hasEnoughDeviceIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$hasEnoughDevice(), false);

            OsList iconIndexesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.iconIndexesIndex);
            iconIndexesOsList.removeAll();
            RealmList<java.lang.Integer> iconIndexesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$iconIndexes();
            if (iconIndexesList != null) {
                for (java.lang.Integer iconIndexesItem : iconIndexesList) {
                    if (iconIndexesItem == null) {
                        iconIndexesOsList.addNull();
                    } else {
                        iconIndexesOsList.addLong(iconIndexesItem.longValue());
                    }
                }
            }


            OsList accessoriesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.accessoriesIndex);
            accessoriesOsList.removeAll();
            RealmList<java.lang.String> accessoriesList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$accessories();
            if (accessoriesList != null) {
                for (java.lang.String accessoriesItem : accessoriesList) {
                    if (accessoriesItem == null) {
                        accessoriesOsList.addNull();
                    } else {
                        accessoriesOsList.addString(accessoriesItem);
                    }
                }
            }


            OsList modelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.modelsIndex);
            RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsList = ((com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) object).realmGet$models();
            if (modelsList != null && modelsList.size() == modelsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = modelsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem = modelsList.get(i);
                    Long cacheItemIndexmodels = cache.get(modelsItem);
                    if (cacheItemIndexmodels == null) {
                        cacheItemIndexmodels = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, modelsItem, cache);
                    }
                    modelsOsList.setRow(i, cacheItemIndexmodels);
                }
            } else {
                modelsOsList.removeAll();
                if (modelsList != null) {
                    for (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem : modelsList) {
                        Long cacheItemIndexmodels = cache.get(modelsItem);
                        if (cacheItemIndexmodels == null) {
                            cacheItemIndexmodels = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, modelsItem, cache);
                        }
                        modelsOsList.addRow(cacheItemIndexmodels);
                    }
                }
            }

        }
    }

    public static com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle createDetachedCopy(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$storyId(realmSource.realmGet$storyId());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$desc(realmSource.realmGet$desc());
        unmanagedCopy.realmSet$bundlePageIndex(realmSource.realmGet$bundlePageIndex());
        unmanagedCopy.realmSet$bundlePageSize(realmSource.realmGet$bundlePageSize());
        unmanagedCopy.realmSet$hasEnoughDevice(realmSource.realmGet$hasEnoughDevice());

        unmanagedCopy.realmSet$iconIndexes(new RealmList<java.lang.Integer>());
        unmanagedCopy.realmGet$iconIndexes().addAll(realmSource.realmGet$iconIndexes());

        unmanagedCopy.realmSet$accessories(new RealmList<java.lang.String>());
        unmanagedCopy.realmGet$accessories().addAll(realmSource.realmGet$accessories());

        // Deep copy of models
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$models(null);
        } else {
            RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> managedmodelsList = realmSource.realmGet$models();
            RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> unmanagedmodelsList = new RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>();
            unmanagedCopy.realmSet$models(unmanagedmodelsList);
            int nextDepth = currentDepth + 1;
            int size = managedmodelsList.size();
            for (int i = 0; i < size; i++) {
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel item = com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createDetachedCopy(managedmodelsList.get(i), nextDepth, maxDepth, cache);
                unmanagedmodelsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle update(Realm realm, DeviceBundleColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle realmObject, com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.storyIdIndex, realmObjectSource.realmGet$storyId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.descIndex, realmObjectSource.realmGet$desc());
        builder.addInteger(columnInfo.bundlePageIndexIndex, realmObjectSource.realmGet$bundlePageIndex());
        builder.addInteger(columnInfo.bundlePageSizeIndex, realmObjectSource.realmGet$bundlePageSize());
        builder.addBoolean(columnInfo.hasEnoughDeviceIndex, realmObjectSource.realmGet$hasEnoughDevice());
        builder.addIntegerList(columnInfo.iconIndexesIndex, realmObjectSource.realmGet$iconIndexes());
        builder.addStringList(columnInfo.accessoriesIndex, realmObjectSource.realmGet$accessories());

        RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsList = realmObjectSource.realmGet$models();
        if (modelsList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> modelsManagedCopy = new RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>();
            for (int i = 0; i < modelsList.size(); i++) {
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel modelsItem = modelsList.get(i);
                com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel cachemodels = (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) cache.get(modelsItem);
                if (cachemodels != null) {
                    modelsManagedCopy.add(cachemodels);
                } else {
                    modelsManagedCopy.add(com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class), modelsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.modelsIndex, modelsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.modelsIndex, new RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel>());
        }

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DeviceBundle = proxy[");
        stringBuilder.append("{storyId:");
        stringBuilder.append(realmGet$storyId() != null ? realmGet$storyId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{desc:");
        stringBuilder.append(realmGet$desc() != null ? realmGet$desc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bundlePageIndex:");
        stringBuilder.append(realmGet$bundlePageIndex());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bundlePageSize:");
        stringBuilder.append(realmGet$bundlePageSize());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hasEnoughDevice:");
        stringBuilder.append(realmGet$hasEnoughDevice());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iconIndexes:");
        stringBuilder.append("RealmList<Integer>[").append(realmGet$iconIndexes().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{accessories:");
        stringBuilder.append("RealmList<String>[").append(realmGet$accessories().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{models:");
        stringBuilder.append("RealmList<BundleModel>[").append(realmGet$models().size()).append("]");
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
        com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy aDeviceBundle = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDeviceBundle.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDeviceBundle.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDeviceBundle.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
