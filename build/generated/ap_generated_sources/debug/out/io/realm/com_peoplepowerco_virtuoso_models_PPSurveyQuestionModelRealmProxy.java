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
public class com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy extends com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface {

    static final class PPSurveyQuestionModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long titleIndex;
        long questionIndex;
        long sliderMinIndex;
        long sliderMaxIndex;
        long answerTimeIndex;

        PPSurveyQuestionModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPSurveyQuestionModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.questionIndex = addColumnDetails("question", "question", objectSchemaInfo);
            this.sliderMinIndex = addColumnDetails("sliderMin", "sliderMin", objectSchemaInfo);
            this.sliderMaxIndex = addColumnDetails("sliderMax", "sliderMax", objectSchemaInfo);
            this.answerTimeIndex = addColumnDetails("answerTime", "answerTime", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPSurveyQuestionModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPSurveyQuestionModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPSurveyQuestionModelColumnInfo src = (PPSurveyQuestionModelColumnInfo) rawSrc;
            final PPSurveyQuestionModelColumnInfo dst = (PPSurveyQuestionModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.titleIndex = src.titleIndex;
            dst.questionIndex = src.questionIndex;
            dst.sliderMinIndex = src.sliderMinIndex;
            dst.sliderMaxIndex = src.sliderMaxIndex;
            dst.answerTimeIndex = src.answerTimeIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPSurveyQuestionModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel> proxyState;

    com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPSurveyQuestionModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel>(this);
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
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
    public String realmGet$question() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.questionIndex);
    }

    @Override
    public void realmSet$question(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.questionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.questionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.questionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.questionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sliderMin() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sliderMinIndex);
    }

    @Override
    public void realmSet$sliderMin(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sliderMinIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sliderMinIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sliderMax() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sliderMaxIndex);
    }

    @Override
    public void realmSet$sliderMax(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sliderMaxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sliderMaxIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$answerTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.answerTimeIndex);
    }

    @Override
    public void realmSet$answerTime(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.answerTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.answerTimeIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPSurveyQuestionModel", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("question", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sliderMin", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sliderMax", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("answerTime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPSurveyQuestionModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPSurveyQuestionModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPSurveyQuestionModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPSurveyQuestionModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
            PPSurveyQuestionModelColumnInfo columnInfo = (PPSurveyQuestionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) obj;
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("question")) {
            if (json.isNull("question")) {
                objProxy.realmSet$question(null);
            } else {
                objProxy.realmSet$question((String) json.getString("question"));
            }
        }
        if (json.has("sliderMin")) {
            if (json.isNull("sliderMin")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sliderMin' to null.");
            } else {
                objProxy.realmSet$sliderMin((int) json.getInt("sliderMin"));
            }
        }
        if (json.has("sliderMax")) {
            if (json.isNull("sliderMax")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sliderMax' to null.");
            } else {
                objProxy.realmSet$sliderMax((int) json.getInt("sliderMax"));
            }
        }
        if (json.has("answerTime")) {
            if (json.isNull("answerTime")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'answerTime' to null.");
            } else {
                objProxy.realmSet$answerTime((long) json.getLong("answerTime"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel obj = new com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel();
        final com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) obj;
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
                jsonHasPrimaryKey = true;
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("question")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$question((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$question(null);
                }
            } else if (name.equals("sliderMin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sliderMin((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sliderMin' to null.");
                }
            } else if (name.equals("sliderMax")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sliderMax((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sliderMax' to null.");
                }
            } else if (name.equals("answerTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$answerTime((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'answerTime' to null.");
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

    private static com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel copyOrUpdate(Realm realm, PPSurveyQuestionModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel copy(Realm realm, PPSurveyQuestionModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.questionIndex, realmObjectSource.realmGet$question());
        builder.addInteger(columnInfo.sliderMinIndex, realmObjectSource.realmGet$sliderMin());
        builder.addInteger(columnInfo.sliderMaxIndex, realmObjectSource.realmGet$sliderMax());
        builder.addInteger(columnInfo.answerTimeIndex, realmObjectSource.realmGet$answerTime());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPSurveyQuestionModelColumnInfo columnInfo = (PPSurveyQuestionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$question = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$question();
        if (realmGet$question != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sliderMinIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMin(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sliderMaxIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMax(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.answerTimeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$answerTime(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPSurveyQuestionModelColumnInfo columnInfo = (PPSurveyQuestionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$question = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$question();
            if (realmGet$question != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sliderMinIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMin(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sliderMaxIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMax(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.answerTimeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$answerTime(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPSurveyQuestionModelColumnInfo columnInfo = (PPSurveyQuestionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$question = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$question();
        if (realmGet$question != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.questionIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sliderMinIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMin(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sliderMaxIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMax(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.answerTimeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$answerTime(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long tableNativePtr = table.getNativePtr();
        PPSurveyQuestionModelColumnInfo columnInfo = (PPSurveyQuestionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$question = ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$question();
            if (realmGet$question != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.questionIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sliderMinIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMin(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sliderMaxIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$sliderMax(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.answerTimeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) object).realmGet$answerTime(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel createDetachedCopy(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$question(realmSource.realmGet$question());
        unmanagedCopy.realmSet$sliderMin(realmSource.realmGet$sliderMin());
        unmanagedCopy.realmSet$sliderMax(realmSource.realmGet$sliderMax());
        unmanagedCopy.realmSet$answerTime(realmSource.realmGet$answerTime());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel update(Realm realm, PPSurveyQuestionModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel realmObject, com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.questionIndex, realmObjectSource.realmGet$question());
        builder.addInteger(columnInfo.sliderMinIndex, realmObjectSource.realmGet$sliderMin());
        builder.addInteger(columnInfo.sliderMaxIndex, realmObjectSource.realmGet$sliderMax());
        builder.addInteger(columnInfo.answerTimeIndex, realmObjectSource.realmGet$answerTime());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPSurveyQuestionModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{question:");
        stringBuilder.append(realmGet$question() != null ? realmGet$question() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sliderMin:");
        stringBuilder.append(realmGet$sliderMin());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sliderMax:");
        stringBuilder.append(realmGet$sliderMax());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{answerTime:");
        stringBuilder.append(realmGet$answerTime());
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
        com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy aPPSurveyQuestionModel = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPSurveyQuestionModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPSurveyQuestionModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPSurveyQuestionModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
