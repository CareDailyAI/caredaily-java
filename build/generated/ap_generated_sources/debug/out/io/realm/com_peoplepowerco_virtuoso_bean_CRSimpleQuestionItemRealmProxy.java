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
public class com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy extends com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface {

    static final class CRSimpleQuestionItemColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long answerStatusIndex;
        long defaultAnswerIndex;
        long answerIndex;
        long keyIndex;
        long editableIndex;

        CRSimpleQuestionItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("CRSimpleQuestionItem");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.answerStatusIndex = addColumnDetails("answerStatus", "answerStatus", objectSchemaInfo);
            this.defaultAnswerIndex = addColumnDetails("defaultAnswer", "defaultAnswer", objectSchemaInfo);
            this.answerIndex = addColumnDetails("answer", "answer", objectSchemaInfo);
            this.keyIndex = addColumnDetails("key", "key", objectSchemaInfo);
            this.editableIndex = addColumnDetails("editable", "editable", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        CRSimpleQuestionItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CRSimpleQuestionItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CRSimpleQuestionItemColumnInfo src = (CRSimpleQuestionItemColumnInfo) rawSrc;
            final CRSimpleQuestionItemColumnInfo dst = (CRSimpleQuestionItemColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.answerStatusIndex = src.answerStatusIndex;
            dst.defaultAnswerIndex = src.defaultAnswerIndex;
            dst.answerIndex = src.answerIndex;
            dst.keyIndex = src.keyIndex;
            dst.editableIndex = src.editableIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CRSimpleQuestionItemColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem> proxyState;

    com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CRSimpleQuestionItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
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
    public int realmGet$answerStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.answerStatusIndex);
    }

    @Override
    public void realmSet$answerStatus(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.answerStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.answerStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$defaultAnswer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.defaultAnswerIndex);
    }

    @Override
    public void realmSet$defaultAnswer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.defaultAnswerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.defaultAnswerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.defaultAnswerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.defaultAnswerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$answer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.answerIndex);
    }

    @Override
    public void realmSet$answer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.answerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.answerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.answerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.answerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$key() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.keyIndex);
    }

    @Override
    public void realmSet$key(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.keyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.keyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.keyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.keyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$editable() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.editableIndex);
    }

    @Override
    public void realmSet$editable(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.editableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.editableIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("CRSimpleQuestionItem", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("answerStatus", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("defaultAnswer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("answer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("key", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("editable", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CRSimpleQuestionItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CRSimpleQuestionItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "CRSimpleQuestionItem";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "CRSimpleQuestionItem";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem obj = realm.createObjectInternal(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class, true, excludeFields);

        final com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((long) json.getLong("id"));
            }
        }
        if (json.has("answerStatus")) {
            if (json.isNull("answerStatus")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'answerStatus' to null.");
            } else {
                objProxy.realmSet$answerStatus((int) json.getInt("answerStatus"));
            }
        }
        if (json.has("defaultAnswer")) {
            if (json.isNull("defaultAnswer")) {
                objProxy.realmSet$defaultAnswer(null);
            } else {
                objProxy.realmSet$defaultAnswer((String) json.getString("defaultAnswer"));
            }
        }
        if (json.has("answer")) {
            if (json.isNull("answer")) {
                objProxy.realmSet$answer(null);
            } else {
                objProxy.realmSet$answer((String) json.getString("answer"));
            }
        }
        if (json.has("key")) {
            if (json.isNull("key")) {
                objProxy.realmSet$key(null);
            } else {
                objProxy.realmSet$key((String) json.getString("key"));
            }
        }
        if (json.has("editable")) {
            if (json.isNull("editable")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'editable' to null.");
            } else {
                objProxy.realmSet$editable((int) json.getInt("editable"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem obj = new com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem();
        final com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
            } else if (name.equals("answerStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$answerStatus((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'answerStatus' to null.");
                }
            } else if (name.equals("defaultAnswer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$defaultAnswer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$defaultAnswer(null);
                }
            } else if (name.equals("answer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$answer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$answer(null);
                }
            } else if (name.equals("key")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$key((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$key(null);
                }
            } else if (name.equals("editable")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$editable((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'editable' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem copyOrUpdate(Realm realm, CRSimpleQuestionItemColumnInfo columnInfo, com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem copy(Realm realm, CRSimpleQuestionItemColumnInfo columnInfo, com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.answerStatusIndex, realmObjectSource.realmGet$answerStatus());
        builder.addString(columnInfo.defaultAnswerIndex, realmObjectSource.realmGet$defaultAnswer());
        builder.addString(columnInfo.answerIndex, realmObjectSource.realmGet$answer());
        builder.addString(columnInfo.keyIndex, realmObjectSource.realmGet$key());
        builder.addInteger(columnInfo.editableIndex, realmObjectSource.realmGet$editable());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        long tableNativePtr = table.getNativePtr();
        CRSimpleQuestionItemColumnInfo columnInfo = (CRSimpleQuestionItemColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.answerStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answerStatus(), false);
        String realmGet$defaultAnswer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$defaultAnswer();
        if (realmGet$defaultAnswer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.defaultAnswerIndex, rowIndex, realmGet$defaultAnswer, false);
        }
        String realmGet$answer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answer();
        if (realmGet$answer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
        }
        String realmGet$key = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$key();
        if (realmGet$key != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.keyIndex, rowIndex, realmGet$key, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.editableIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$editable(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        long tableNativePtr = table.getNativePtr();
        CRSimpleQuestionItemColumnInfo columnInfo = (CRSimpleQuestionItemColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.answerStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answerStatus(), false);
            String realmGet$defaultAnswer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$defaultAnswer();
            if (realmGet$defaultAnswer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.defaultAnswerIndex, rowIndex, realmGet$defaultAnswer, false);
            }
            String realmGet$answer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answer();
            if (realmGet$answer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
            }
            String realmGet$key = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$key();
            if (realmGet$key != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.keyIndex, rowIndex, realmGet$key, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.editableIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$editable(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        long tableNativePtr = table.getNativePtr();
        CRSimpleQuestionItemColumnInfo columnInfo = (CRSimpleQuestionItemColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.answerStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answerStatus(), false);
        String realmGet$defaultAnswer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$defaultAnswer();
        if (realmGet$defaultAnswer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.defaultAnswerIndex, rowIndex, realmGet$defaultAnswer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.defaultAnswerIndex, rowIndex, false);
        }
        String realmGet$answer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answer();
        if (realmGet$answer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.answerIndex, rowIndex, false);
        }
        String realmGet$key = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$key();
        if (realmGet$key != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.keyIndex, rowIndex, realmGet$key, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.keyIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.editableIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$editable(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        long tableNativePtr = table.getNativePtr();
        CRSimpleQuestionItemColumnInfo columnInfo = (CRSimpleQuestionItemColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.answerStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answerStatus(), false);
            String realmGet$defaultAnswer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$defaultAnswer();
            if (realmGet$defaultAnswer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.defaultAnswerIndex, rowIndex, realmGet$defaultAnswer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.defaultAnswerIndex, rowIndex, false);
            }
            String realmGet$answer = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$answer();
            if (realmGet$answer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.answerIndex, rowIndex, false);
            }
            String realmGet$key = ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$key();
            if (realmGet$key != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.keyIndex, rowIndex, realmGet$key, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.keyIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.editableIndex, rowIndex, ((com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) object).realmGet$editable(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem createDetachedCopy(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$answerStatus(realmSource.realmGet$answerStatus());
        unmanagedCopy.realmSet$defaultAnswer(realmSource.realmGet$defaultAnswer());
        unmanagedCopy.realmSet$answer(realmSource.realmGet$answer());
        unmanagedCopy.realmSet$key(realmSource.realmGet$key());
        unmanagedCopy.realmSet$editable(realmSource.realmGet$editable());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CRSimpleQuestionItem = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{answerStatus:");
        stringBuilder.append(realmGet$answerStatus());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{defaultAnswer:");
        stringBuilder.append(realmGet$defaultAnswer() != null ? realmGet$defaultAnswer() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{answer:");
        stringBuilder.append(realmGet$answer() != null ? realmGet$answer() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{key:");
        stringBuilder.append(realmGet$key() != null ? realmGet$key() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{editable:");
        stringBuilder.append(realmGet$editable());
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
        com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy aCRSimpleQuestionItem = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCRSimpleQuestionItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCRSimpleQuestionItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCRSimpleQuestionItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
