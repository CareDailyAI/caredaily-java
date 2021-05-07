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
public class com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostUserModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface {

    static final class PPPostUserModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long firstNameIndex;
        long lastNameIndex;
        long communityNameIndex;
        long avatarFileIdIndex;

        PPPostUserModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostUserModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.firstNameIndex = addColumnDetails("firstName", "firstName", objectSchemaInfo);
            this.lastNameIndex = addColumnDetails("lastName", "lastName", objectSchemaInfo);
            this.communityNameIndex = addColumnDetails("communityName", "communityName", objectSchemaInfo);
            this.avatarFileIdIndex = addColumnDetails("avatarFileId", "avatarFileId", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostUserModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostUserModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostUserModelColumnInfo src = (PPPostUserModelColumnInfo) rawSrc;
            final PPPostUserModelColumnInfo dst = (PPPostUserModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.firstNameIndex = src.firstNameIndex;
            dst.lastNameIndex = src.lastNameIndex;
            dst.communityNameIndex = src.communityNameIndex;
            dst.avatarFileIdIndex = src.avatarFileIdIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostUserModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostUserModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostUserModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostUserModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$firstName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstNameIndex);
    }

    @Override
    public void realmSet$firstName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.firstNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lastName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastNameIndex);
    }

    @Override
    public void realmSet$lastName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lastNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastNameIndex, value);
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

    @Override
    @SuppressWarnings("cast")
    public String realmGet$avatarFileId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.avatarFileIdIndex);
    }

    @Override
    public void realmSet$avatarFileId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.avatarFileIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.avatarFileIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.avatarFileIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.avatarFileIdIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostUserModel", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("firstName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lastName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("communityName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("avatarFileId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostUserModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostUserModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostUserModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostUserModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostUserModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
            PPPostUserModelColumnInfo columnInfo = (PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) obj;
        if (json.has("firstName")) {
            if (json.isNull("firstName")) {
                objProxy.realmSet$firstName(null);
            } else {
                objProxy.realmSet$firstName((String) json.getString("firstName"));
            }
        }
        if (json.has("lastName")) {
            if (json.isNull("lastName")) {
                objProxy.realmSet$lastName(null);
            } else {
                objProxy.realmSet$lastName((String) json.getString("lastName"));
            }
        }
        if (json.has("communityName")) {
            if (json.isNull("communityName")) {
                objProxy.realmSet$communityName(null);
            } else {
                objProxy.realmSet$communityName((String) json.getString("communityName"));
            }
        }
        if (json.has("avatarFileId")) {
            if (json.isNull("avatarFileId")) {
                objProxy.realmSet$avatarFileId(null);
            } else {
                objProxy.realmSet$avatarFileId((String) json.getString("avatarFileId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostUserModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.communities.PPPostUserModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostUserModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("firstName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$firstName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$firstName(null);
                }
            } else if (name.equals("lastName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lastName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lastName(null);
                }
            } else if (name.equals("communityName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$communityName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$communityName(null);
                }
            } else if (name.equals("avatarFileId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$avatarFileId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$avatarFileId(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostUserModel copyOrUpdate(Realm realm, PPPostUserModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostUserModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$id();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostUserModel copy(Realm realm, PPPostUserModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostUserModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.firstNameIndex, realmObjectSource.realmGet$firstName());
        builder.addString(columnInfo.lastNameIndex, realmObjectSource.realmGet$lastName());
        builder.addString(columnInfo.communityNameIndex, realmObjectSource.realmGet$communityName());
        builder.addString(columnInfo.avatarFileIdIndex, realmObjectSource.realmGet$avatarFileId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostUserModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostUserModelColumnInfo columnInfo = (PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$id();
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
        String realmGet$firstName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
        }
        String realmGet$lastName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
        }
        String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$communityName();
        if (realmGet$communityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
        }
        String realmGet$avatarFileId = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$avatarFileId();
        if (realmGet$avatarFileId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarFileIdIndex, rowIndex, realmGet$avatarFileId, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostUserModelColumnInfo columnInfo = (PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$id();
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
            String realmGet$firstName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$firstName();
            if (realmGet$firstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
            }
            String realmGet$lastName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$lastName();
            if (realmGet$lastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
            }
            String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$communityName();
            if (realmGet$communityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
            }
            String realmGet$avatarFileId = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$avatarFileId();
            if (realmGet$avatarFileId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarFileIdIndex, rowIndex, realmGet$avatarFileId, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostUserModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostUserModelColumnInfo columnInfo = (PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$id();
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
        String realmGet$firstName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstNameIndex, rowIndex, false);
        }
        String realmGet$lastName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastNameIndex, rowIndex, false);
        }
        String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$communityName();
        if (realmGet$communityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.communityNameIndex, rowIndex, false);
        }
        String realmGet$avatarFileId = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$avatarFileId();
        if (realmGet$avatarFileId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarFileIdIndex, rowIndex, realmGet$avatarFileId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatarFileIdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostUserModelColumnInfo columnInfo = (PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$id();
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
            String realmGet$firstName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$firstName();
            if (realmGet$firstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.firstNameIndex, rowIndex, false);
            }
            String realmGet$lastName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$lastName();
            if (realmGet$lastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lastNameIndex, rowIndex, false);
            }
            String realmGet$communityName = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$communityName();
            if (realmGet$communityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.communityNameIndex, rowIndex, realmGet$communityName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.communityNameIndex, rowIndex, false);
            }
            String realmGet$avatarFileId = ((com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) object).realmGet$avatarFileId();
            if (realmGet$avatarFileId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarFileIdIndex, rowIndex, realmGet$avatarFileId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.avatarFileIdIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostUserModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostUserModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$firstName(realmSource.realmGet$firstName());
        unmanagedCopy.realmSet$lastName(realmSource.realmGet$lastName());
        unmanagedCopy.realmSet$communityName(realmSource.realmGet$communityName());
        unmanagedCopy.realmSet$avatarFileId(realmSource.realmGet$avatarFileId());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.communities.PPPostUserModel update(Realm realm, PPPostUserModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostUserModel realmObject, com.peoplepowerco.virtuoso.models.communities.PPPostUserModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.firstNameIndex, realmObjectSource.realmGet$firstName());
        builder.addString(columnInfo.lastNameIndex, realmObjectSource.realmGet$lastName());
        builder.addString(columnInfo.communityNameIndex, realmObjectSource.realmGet$communityName());
        builder.addString(columnInfo.avatarFileIdIndex, realmObjectSource.realmGet$avatarFileId());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostUserModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstName:");
        stringBuilder.append(realmGet$firstName() != null ? realmGet$firstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastName:");
        stringBuilder.append(realmGet$lastName() != null ? realmGet$lastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{communityName:");
        stringBuilder.append(realmGet$communityName() != null ? realmGet$communityName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avatarFileId:");
        stringBuilder.append(realmGet$avatarFileId() != null ? realmGet$avatarFileId() : "null");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy aPPPostUserModel = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostUserModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostUserModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostUserModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
