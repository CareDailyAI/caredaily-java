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
public class com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface {

    static final class PPPostCommentModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long commentIdIndex;
        long postIdIndex;
        long replyCommentIdIndex;
        long commentDateMsIndex;
        long commentTextIndex;
        long userIndex;
        long reactionsIndex;

        PPPostCommentModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostCommentModel");
            this.commentIdIndex = addColumnDetails("commentId", "commentId", objectSchemaInfo);
            this.postIdIndex = addColumnDetails("postId", "postId", objectSchemaInfo);
            this.replyCommentIdIndex = addColumnDetails("replyCommentId", "replyCommentId", objectSchemaInfo);
            this.commentDateMsIndex = addColumnDetails("commentDateMs", "commentDateMs", objectSchemaInfo);
            this.commentTextIndex = addColumnDetails("commentText", "commentText", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.reactionsIndex = addColumnDetails("reactions", "reactions", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostCommentModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostCommentModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostCommentModelColumnInfo src = (PPPostCommentModelColumnInfo) rawSrc;
            final PPPostCommentModelColumnInfo dst = (PPPostCommentModelColumnInfo) rawDst;
            dst.commentIdIndex = src.commentIdIndex;
            dst.postIdIndex = src.postIdIndex;
            dst.replyCommentIdIndex = src.replyCommentIdIndex;
            dst.commentDateMsIndex = src.commentDateMsIndex;
            dst.commentTextIndex = src.commentTextIndex;
            dst.userIndex = src.userIndex;
            dst.reactionsIndex = src.reactionsIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostCommentModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> proxyState;
    private RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsRealmList;

    com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostCommentModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'commentId' cannot be changed after object was created.");
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
    public String realmGet$replyCommentId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.replyCommentIdIndex);
    }

    @Override
    public void realmSet$replyCommentId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.replyCommentIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.replyCommentIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.replyCommentIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.replyCommentIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$commentDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.commentDateMsIndex);
    }

    @Override
    public void realmSet$commentDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.commentDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.commentDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$commentText() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.commentTextIndex);
    }

    @Override
    public void realmSet$commentText(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.commentTextIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.commentTextIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.commentTextIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.commentTextIndex, value);
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

    @Override
    public RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> realmGet$reactions() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (reactionsRealmList != null) {
            return reactionsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.reactionsIndex);
            reactionsRealmList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class, osList, proxyState.getRealm$realm());
            return reactionsRealmList;
        }
    }

    @Override
    public void realmSet$reactions(RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("reactions")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> original = value;
                value = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>();
                for (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.reactionsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel linkedObject = value.get(i);
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
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostCommentModel", 7, 0);
        builder.addPersistedProperty("commentId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("postId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("replyCommentId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("commentDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("commentText", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "PPPostUserModel");
        builder.addPersistedLinkProperty("reactions", RealmFieldType.LIST, "PPPostReactionModel");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostCommentModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostCommentModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostCommentModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostCommentModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
            PPPostCommentModelColumnInfo columnInfo = (PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
            long pkColumnIndex = columnInfo.commentIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("commentId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("commentId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("user")) {
                excludeFields.add("user");
            }
            if (json.has("reactions")) {
                excludeFields.add("reactions");
            }
            if (json.has("commentId")) {
                if (json.isNull("commentId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class, json.getString("commentId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'commentId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) obj;
        if (json.has("postId")) {
            if (json.isNull("postId")) {
                objProxy.realmSet$postId(null);
            } else {
                objProxy.realmSet$postId((String) json.getString("postId"));
            }
        }
        if (json.has("replyCommentId")) {
            if (json.isNull("replyCommentId")) {
                objProxy.realmSet$replyCommentId(null);
            } else {
                objProxy.realmSet$replyCommentId((String) json.getString("replyCommentId"));
            }
        }
        if (json.has("commentDateMs")) {
            if (json.isNull("commentDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'commentDateMs' to null.");
            } else {
                objProxy.realmSet$commentDateMs((long) json.getLong("commentDateMs"));
            }
        }
        if (json.has("commentText")) {
            if (json.isNull("commentText")) {
                objProxy.realmSet$commentText(null);
            } else {
                objProxy.realmSet$commentText((String) json.getString("commentText"));
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
        if (json.has("reactions")) {
            if (json.isNull("reactions")) {
                objProxy.realmSet$reactions(null);
            } else {
                objProxy.realmGet$reactions().clear();
                JSONArray array = json.getJSONArray("reactions");
                for (int i = 0; i < array.length(); i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel item = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$reactions().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("commentId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$commentId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$commentId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("postId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$postId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$postId(null);
                }
            } else if (name.equals("replyCommentId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$replyCommentId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$replyCommentId(null);
                }
            } else if (name.equals("commentDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$commentDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'commentDateMs' to null.");
                }
            } else if (name.equals("commentText")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$commentText((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$commentText(null);
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("reactions")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$reactions(null);
                } else {
                    objProxy.realmSet$reactions(new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel item = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$reactions().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'commentId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel copyOrUpdate(Realm realm, PPPostCommentModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
            long pkColumnIndex = columnInfo.commentIdIndex;
            String value = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentId();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel copy(Realm realm, PPPostCommentModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.commentIdIndex, realmObjectSource.realmGet$commentId());
        builder.addString(columnInfo.postIdIndex, realmObjectSource.realmGet$postId());
        builder.addString(columnInfo.replyCommentIdIndex, realmObjectSource.realmGet$replyCommentId());
        builder.addInteger(columnInfo.commentDateMsIndex, realmObjectSource.realmGet$commentDateMs());
        builder.addString(columnInfo.commentTextIndex, realmObjectSource.realmGet$commentText());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
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

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = realmObjectSource.realmGet$reactions();
        if (reactionsList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsRealmList = realmObjectCopy.realmGet$reactions();
            reactionsRealmList.clear();
            for (int i = 0; i < reactionsList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem = reactionsList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel cachereactions = (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) cache.get(reactionsItem);
                if (cachereactions != null) {
                    reactionsRealmList.add(cachereactions);
                } else {
                    reactionsRealmList.add(com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class), reactionsItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostCommentModelColumnInfo columnInfo = (PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long pkColumnIndex = columnInfo.commentIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentId();
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
        String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$postId();
        if (realmGet$postId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
        }
        String realmGet$replyCommentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$replyCommentId();
        if (realmGet$replyCommentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.replyCommentIdIndex, rowIndex, realmGet$replyCommentId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.commentDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentDateMs(), false);
        String realmGet$commentText = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentText();
        if (realmGet$commentText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentTextIndex, rowIndex, realmGet$commentText, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$reactions();
        if (reactionsList != null) {
            OsList reactionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.reactionsIndex);
            for (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem : reactionsList) {
                Long cacheItemIndexreactions = cache.get(reactionsItem);
                if (cacheItemIndexreactions == null) {
                    cacheItemIndexreactions = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insert(realm, reactionsItem, cache);
                }
                reactionsOsList.addRow(cacheItemIndexreactions);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostCommentModelColumnInfo columnInfo = (PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long pkColumnIndex = columnInfo.commentIdIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentId();
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
            String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$postId();
            if (realmGet$postId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
            }
            String realmGet$replyCommentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$replyCommentId();
            if (realmGet$replyCommentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.replyCommentIdIndex, rowIndex, realmGet$replyCommentId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.commentDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentDateMs(), false);
            String realmGet$commentText = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentText();
            if (realmGet$commentText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentTextIndex, rowIndex, realmGet$commentText, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }

            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$reactions();
            if (reactionsList != null) {
                OsList reactionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.reactionsIndex);
                for (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem : reactionsList) {
                    Long cacheItemIndexreactions = cache.get(reactionsItem);
                    if (cacheItemIndexreactions == null) {
                        cacheItemIndexreactions = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insert(realm, reactionsItem, cache);
                    }
                    reactionsOsList.addRow(cacheItemIndexreactions);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostCommentModelColumnInfo columnInfo = (PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long pkColumnIndex = columnInfo.commentIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentId();
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
        String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$postId();
        if (realmGet$postId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.postIdIndex, rowIndex, false);
        }
        String realmGet$replyCommentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$replyCommentId();
        if (realmGet$replyCommentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.replyCommentIdIndex, rowIndex, realmGet$replyCommentId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.replyCommentIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.commentDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentDateMs(), false);
        String realmGet$commentText = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentText();
        if (realmGet$commentText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentTextIndex, rowIndex, realmGet$commentText, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.commentTextIndex, rowIndex, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }

        OsList reactionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.reactionsIndex);
        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$reactions();
        if (reactionsList != null && reactionsList.size() == reactionsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = reactionsList.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem = reactionsList.get(i);
                Long cacheItemIndexreactions = cache.get(reactionsItem);
                if (cacheItemIndexreactions == null) {
                    cacheItemIndexreactions = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, reactionsItem, cache);
                }
                reactionsOsList.setRow(i, cacheItemIndexreactions);
            }
        } else {
            reactionsOsList.removeAll();
            if (reactionsList != null) {
                for (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem : reactionsList) {
                    Long cacheItemIndexreactions = cache.get(reactionsItem);
                    if (cacheItemIndexreactions == null) {
                        cacheItemIndexreactions = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, reactionsItem, cache);
                    }
                    reactionsOsList.addRow(cacheItemIndexreactions);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostCommentModelColumnInfo columnInfo = (PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        long pkColumnIndex = columnInfo.commentIdIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentId();
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
            String realmGet$postId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$postId();
            if (realmGet$postId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postIdIndex, rowIndex, realmGet$postId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.postIdIndex, rowIndex, false);
            }
            String realmGet$replyCommentId = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$replyCommentId();
            if (realmGet$replyCommentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.replyCommentIdIndex, rowIndex, realmGet$replyCommentId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.replyCommentIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.commentDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentDateMs(), false);
            String realmGet$commentText = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$commentText();
            if (realmGet$commentText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentTextIndex, rowIndex, realmGet$commentText, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.commentTextIndex, rowIndex, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }

            OsList reactionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.reactionsIndex);
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) object).realmGet$reactions();
            if (reactionsList != null && reactionsList.size() == reactionsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = reactionsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem = reactionsList.get(i);
                    Long cacheItemIndexreactions = cache.get(reactionsItem);
                    if (cacheItemIndexreactions == null) {
                        cacheItemIndexreactions = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, reactionsItem, cache);
                    }
                    reactionsOsList.setRow(i, cacheItemIndexreactions);
                }
            } else {
                reactionsOsList.removeAll();
                if (reactionsList != null) {
                    for (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem : reactionsList) {
                        Long cacheItemIndexreactions = cache.get(reactionsItem);
                        if (cacheItemIndexreactions == null) {
                            cacheItemIndexreactions = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, reactionsItem, cache);
                        }
                        reactionsOsList.addRow(cacheItemIndexreactions);
                    }
                }
            }

        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$commentId(realmSource.realmGet$commentId());
        unmanagedCopy.realmSet$postId(realmSource.realmGet$postId());
        unmanagedCopy.realmSet$replyCommentId(realmSource.realmGet$replyCommentId());
        unmanagedCopy.realmSet$commentDateMs(realmSource.realmGet$commentDateMs());
        unmanagedCopy.realmSet$commentText(realmSource.realmGet$commentText());

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));

        // Deep copy of reactions
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$reactions(null);
        } else {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> managedreactionsList = realmSource.realmGet$reactions();
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> unmanagedreactionsList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>();
            unmanagedCopy.realmSet$reactions(unmanagedreactionsList);
            int nextDepth = currentDepth + 1;
            int size = managedreactionsList.size();
            for (int i = 0; i < size; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel item = com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createDetachedCopy(managedreactionsList.get(i), nextDepth, maxDepth, cache);
                unmanagedreactionsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel update(Realm realm, PPPostCommentModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel realmObject, com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.commentIdIndex, realmObjectSource.realmGet$commentId());
        builder.addString(columnInfo.postIdIndex, realmObjectSource.realmGet$postId());
        builder.addString(columnInfo.replyCommentIdIndex, realmObjectSource.realmGet$replyCommentId());
        builder.addInteger(columnInfo.commentDateMsIndex, realmObjectSource.realmGet$commentDateMs());
        builder.addString(columnInfo.commentTextIndex, realmObjectSource.realmGet$commentText());

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            builder.addNull(columnInfo.userIndex);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel cacheuser = (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) cache.get(userObj);
            if (cacheuser != null) {
                builder.addObject(columnInfo.userIndex, cacheuser);
            } else {
                builder.addObject(columnInfo.userIndex, com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class), userObj, true, cache, flags));
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = realmObjectSource.realmGet$reactions();
        if (reactionsList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsManagedCopy = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>();
            for (int i = 0; i < reactionsList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel reactionsItem = reactionsList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel cachereactions = (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) cache.get(reactionsItem);
                if (cachereactions != null) {
                    reactionsManagedCopy.add(cachereactions);
                } else {
                    reactionsManagedCopy.add(com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class), reactionsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.reactionsIndex, reactionsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.reactionsIndex, new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel>());
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
        StringBuilder stringBuilder = new StringBuilder("PPPostCommentModel = proxy[");
        stringBuilder.append("{commentId:");
        stringBuilder.append(realmGet$commentId() != null ? realmGet$commentId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{postId:");
        stringBuilder.append(realmGet$postId() != null ? realmGet$postId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{replyCommentId:");
        stringBuilder.append(realmGet$replyCommentId() != null ? realmGet$replyCommentId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{commentDateMs:");
        stringBuilder.append(realmGet$commentDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{commentText:");
        stringBuilder.append(realmGet$commentText() != null ? realmGet$commentText() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "PPPostUserModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reactions:");
        stringBuilder.append("RealmList<PPPostReactionModel>[").append(realmGet$reactions().size()).append("]");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy aPPPostCommentModel = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostCommentModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostCommentModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostCommentModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
