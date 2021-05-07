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
public class com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface {

    static final class PPPostReactionModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long reactionIndex;
        long postIdIndex;
        long commentIdIndex;
        long userIndex;

        PPPostReactionModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostReactionModel");
            this.reactionIndex = addColumnDetails("reaction", "reaction", objectSchemaInfo);
            this.postIdIndex = addColumnDetails("postId", "postId", objectSchemaInfo);
            this.commentIdIndex = addColumnDetails("commentId", "commentId", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostReactionModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostReactionModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostReactionModelColumnInfo src = (PPPostReactionModelColumnInfo) rawSrc;
            final PPPostReactionModelColumnInfo dst = (PPPostReactionModelColumnInfo) rawDst;
            dst.reactionIndex = src.reactionIndex;
            dst.postIdIndex = src.postIdIndex;
            dst.commentIdIndex = src.commentIdIndex;
            dst.userIndex = src.userIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostReactionModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostReactionModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$reaction() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.reactionIndex);
    }

    @Override
    public void realmSet$reaction(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.reactionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.reactionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$postId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.postIdIndex);
    }

    @Override
    public void realmSet$postId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.postIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.postIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.postIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.postIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$commentId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.commentIdIndex);
    }

    @Override
    public void realmSet$commentId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.commentIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.commentIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.commentIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.commentIdIndex, value);
    }

    @Override
    public com.peoplepowerco.virtuoso.models.communities.PPPostUserModel realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class, proxyState.getRow$realm().getLink(columnInfo.userIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$user(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("user")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostReactionModel", 4, 0);
        builder.addPersistedProperty("reaction", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("postId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("commentId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "PPPostUserModel");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostReactionModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostReactionModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostReactionModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostReactionModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("user")) {
            excludeFields.add("user");
        }
        com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) obj;
        if (json.has("reaction")) {
            if (json.isNull("reaction")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'reaction' to null.");
            } else {
                objProxy.realmSet$reaction((int) json.getInt("reaction"));
            }
        }
        if (json.has("postId")) {
            if (json.isNull("postId")) {
                objProxy.realmSet$postId(null);
            } else {
                objProxy.realmSet$postId((String) json.getString("postId"));
            }
        }
        if (json.has("commentId")) {
            if (json.isNull("commentId")) {
                objProxy.realmSet$commentId(null);
            } else {
                objProxy.realmSet$commentId((String) json.getString("commentId"));
            }
        }
        if (json.has("user")) {
            if (json.isNull("user")) {
                objProxy.realmSet$user(null);
            } else {
                com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("user"), update);
                objProxy.realmSet$user(userObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("reaction")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$reaction((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'reaction' to null.");
                }
            } else if (name.equals("postId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$postId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$postId(null);
                }
            } else if (name.equals("commentId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$commentId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$commentId(null);
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel copyOrUpdate(Realm realm, PPPostReactionModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel copy(Realm realm, PPPostReactionModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.reactionIndex, realmObjectSource.realmGet$reaction());
        builder.addString(columnInfo.postIdIndex, realmObjectSource.realmGet$postId());
        builder.addString(columnInfo.commentIdIndex, realmObjectSource.realmGet$commentId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            realmObjectCopy.realmSet$user(null);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel cacheuser = (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) cache.get(userObj);
            if (cacheuser != null) {
                realmObjectCopy.realmSet$user(cacheuser);
            } else {
                realmObjectCopy.realmSet$user(com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class), userObj, update, cache, flags));
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReactionModelColumnInfo columnInfo = (PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.reactionIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$reaction(), false);
        String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$postId();
        if (realmGet$postId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
        }
        String realmGet$commentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$commentId();
        if (realmGet$commentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentIdIndex, rowIndex, realmGet$commentId, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReactionModelColumnInfo columnInfo = (PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.reactionIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$reaction(), false);
            String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$postId();
            if (realmGet$postId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
            }
            String realmGet$commentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$commentId();
            if (realmGet$commentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentIdIndex, rowIndex, realmGet$commentId, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReactionModelColumnInfo columnInfo = (PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.reactionIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$reaction(), false);
        String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$postId();
        if (realmGet$postId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.postIdIndex, rowIndex, false);
        }
        String realmGet$commentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$commentId();
        if (realmGet$commentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentIdIndex, rowIndex, realmGet$commentId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.commentIdIndex, rowIndex, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostReactionModelColumnInfo columnInfo = (PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.reactionIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$reaction(), false);
            String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$postId();
            if (realmGet$postId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.postIdIndex, rowIndex, false);
            }
            String realmGet$commentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$commentId();
            if (realmGet$commentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentIdIndex, rowIndex, realmGet$commentId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.commentIdIndex, rowIndex, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$reaction(realmSource.realmGet$reaction());
        unmanagedCopy.realmSet$postId(realmSource.realmGet$postId());
        unmanagedCopy.realmSet$commentId(realmSource.realmGet$commentId());

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostReactionModel = proxy[");
        stringBuilder.append("{reaction:");
        stringBuilder.append(realmGet$reaction());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{postId:");
        stringBuilder.append(realmGet$postId() != null ? realmGet$postId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{commentId:");
        stringBuilder.append(realmGet$commentId() != null ? realmGet$commentId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "PPPostUserModel" : "null");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy aPPPostReactionModel = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostReactionModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostReactionModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostReactionModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
