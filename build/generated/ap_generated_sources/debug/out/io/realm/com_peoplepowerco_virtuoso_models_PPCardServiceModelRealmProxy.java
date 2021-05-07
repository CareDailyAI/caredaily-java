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
public class com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy extends com.peoplepowerco.virtuoso.models.PPCardServiceModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface {

    static final class PPCardServiceModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long iconIndex;
        long titleIndex;
        long commentIndex;
        long descriptionIndex;
        long statusTextIndex;
        long statusIndex;
        long percentIndex;
        long activeIndex;
        long questionIdIndex;
        long collectionIdIndex;
        long sectionIdIndex;
        long updatedMsIndex;
        long weightIndex;
        long displayTypeIndex;

        PPCardServiceModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(15);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPCardServiceModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.iconIndex = addColumnDetails("icon", "icon", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.commentIndex = addColumnDetails("comment", "comment", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.statusTextIndex = addColumnDetails("statusText", "statusText", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.percentIndex = addColumnDetails("percent", "percent", objectSchemaInfo);
            this.activeIndex = addColumnDetails("active", "active", objectSchemaInfo);
            this.questionIdIndex = addColumnDetails("questionId", "questionId", objectSchemaInfo);
            this.collectionIdIndex = addColumnDetails("collectionId", "collectionId", objectSchemaInfo);
            this.sectionIdIndex = addColumnDetails("sectionId", "sectionId", objectSchemaInfo);
            this.updatedMsIndex = addColumnDetails("updatedMs", "updatedMs", objectSchemaInfo);
            this.weightIndex = addColumnDetails("weight", "weight", objectSchemaInfo);
            this.displayTypeIndex = addColumnDetails("displayType", "displayType", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPCardServiceModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPCardServiceModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPCardServiceModelColumnInfo src = (PPCardServiceModelColumnInfo) rawSrc;
            final PPCardServiceModelColumnInfo dst = (PPCardServiceModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.iconIndex = src.iconIndex;
            dst.titleIndex = src.titleIndex;
            dst.commentIndex = src.commentIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.statusTextIndex = src.statusTextIndex;
            dst.statusIndex = src.statusIndex;
            dst.percentIndex = src.percentIndex;
            dst.activeIndex = src.activeIndex;
            dst.questionIdIndex = src.questionIdIndex;
            dst.collectionIdIndex = src.collectionIdIndex;
            dst.sectionIdIndex = src.sectionIdIndex;
            dst.updatedMsIndex = src.updatedMsIndex;
            dst.weightIndex = src.weightIndex;
            dst.displayTypeIndex = src.displayTypeIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPCardServiceModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.PPCardServiceModel> proxyState;

    com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPCardServiceModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.PPCardServiceModel>(this);
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
    public String realmGet$comment() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.commentIndex);
    }

    @Override
    public void realmSet$comment(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.commentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.commentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.commentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.commentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$statusText() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusTextIndex);
    }

    @Override
    public void realmSet$statusText(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusTextIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusTextIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusTextIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusTextIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$percent() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.percentIndex);
    }

    @Override
    public void realmSet$percent(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.percentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.percentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$active() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.activeIndex);
    }

    @Override
    public void realmSet$active(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.activeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.activeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$questionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.questionIdIndex);
    }

    @Override
    public void realmSet$questionId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.questionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.questionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.questionIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.questionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$collectionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.collectionIdIndex);
    }

    @Override
    public void realmSet$collectionId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.collectionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.collectionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.collectionIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.collectionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sectionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sectionIdIndex);
    }

    @Override
    public void realmSet$sectionId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sectionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sectionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sectionIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sectionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$updatedMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.updatedMsIndex);
    }

    @Override
    public void realmSet$updatedMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.updatedMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.updatedMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$weight() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.weightIndex);
    }

    @Override
    public void realmSet$weight(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.weightIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.weightIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$displayType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.displayTypeIndex);
    }

    @Override
    public void realmSet$displayType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.displayTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.displayTypeIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPCardServiceModel", 15, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("icon", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("comment", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("statusText", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("percent", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("active", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("questionId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("collectionId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sectionId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updatedMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("weight", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("displayType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPCardServiceModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPCardServiceModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPCardServiceModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPCardServiceModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.PPCardServiceModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.PPCardServiceModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
            PPCardServiceModelColumnInfo columnInfo = (PPCardServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) obj;
        if (json.has("icon")) {
            if (json.isNull("icon")) {
                objProxy.realmSet$icon(null);
            } else {
                objProxy.realmSet$icon((String) json.getString("icon"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("comment")) {
            if (json.isNull("comment")) {
                objProxy.realmSet$comment(null);
            } else {
                objProxy.realmSet$comment((String) json.getString("comment"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("statusText")) {
            if (json.isNull("statusText")) {
                objProxy.realmSet$statusText(null);
            } else {
                objProxy.realmSet$statusText((String) json.getString("statusText"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
            } else {
                objProxy.realmSet$status((int) json.getInt("status"));
            }
        }
        if (json.has("percent")) {
            if (json.isNull("percent")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'percent' to null.");
            } else {
                objProxy.realmSet$percent((float) json.getDouble("percent"));
            }
        }
        if (json.has("active")) {
            if (json.isNull("active")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'active' to null.");
            } else {
                objProxy.realmSet$active((boolean) json.getBoolean("active"));
            }
        }
        if (json.has("questionId")) {
            if (json.isNull("questionId")) {
                objProxy.realmSet$questionId(null);
            } else {
                objProxy.realmSet$questionId((String) json.getString("questionId"));
            }
        }
        if (json.has("collectionId")) {
            if (json.isNull("collectionId")) {
                objProxy.realmSet$collectionId(null);
            } else {
                objProxy.realmSet$collectionId((String) json.getString("collectionId"));
            }
        }
        if (json.has("sectionId")) {
            if (json.isNull("sectionId")) {
                objProxy.realmSet$sectionId(null);
            } else {
                objProxy.realmSet$sectionId((String) json.getString("sectionId"));
            }
        }
        if (json.has("updatedMs")) {
            if (json.isNull("updatedMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'updatedMs' to null.");
            } else {
                objProxy.realmSet$updatedMs((long) json.getLong("updatedMs"));
            }
        }
        if (json.has("weight")) {
            if (json.isNull("weight")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'weight' to null.");
            } else {
                objProxy.realmSet$weight((int) json.getInt("weight"));
            }
        }
        if (json.has("displayType")) {
            if (json.isNull("displayType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'displayType' to null.");
            } else {
                objProxy.realmSet$displayType((int) json.getInt("displayType"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.PPCardServiceModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.PPCardServiceModel obj = new com.peoplepowerco.virtuoso.models.PPCardServiceModel();
        final com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) obj;
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
            } else if (name.equals("icon")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$icon((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$icon(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("comment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$comment((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$comment(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("statusText")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$statusText((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$statusText(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
                }
            } else if (name.equals("percent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$percent((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'percent' to null.");
                }
            } else if (name.equals("active")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$active((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'active' to null.");
                }
            } else if (name.equals("questionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$questionId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$questionId(null);
                }
            } else if (name.equals("collectionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$collectionId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$collectionId(null);
                }
            } else if (name.equals("sectionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sectionId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sectionId(null);
                }
            } else if (name.equals("updatedMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updatedMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'updatedMs' to null.");
                }
            } else if (name.equals("weight")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$weight((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'weight' to null.");
                }
            } else if (name.equals("displayType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$displayType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'displayType' to null.");
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

    private static com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.PPCardServiceModel copyOrUpdate(Realm realm, PPCardServiceModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPCardServiceModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.PPCardServiceModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.PPCardServiceModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$id();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.PPCardServiceModel copy(Realm realm, PPCardServiceModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPCardServiceModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.PPCardServiceModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.iconIndex, realmObjectSource.realmGet$icon());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.commentIndex, realmObjectSource.realmGet$comment());
        builder.addString(columnInfo.descriptionIndex, realmObjectSource.realmGet$description());
        builder.addString(columnInfo.statusTextIndex, realmObjectSource.realmGet$statusText());
        builder.addInteger(columnInfo.statusIndex, realmObjectSource.realmGet$status());
        builder.addFloat(columnInfo.percentIndex, realmObjectSource.realmGet$percent());
        builder.addBoolean(columnInfo.activeIndex, realmObjectSource.realmGet$active());
        builder.addString(columnInfo.questionIdIndex, realmObjectSource.realmGet$questionId());
        builder.addString(columnInfo.collectionIdIndex, realmObjectSource.realmGet$collectionId());
        builder.addString(columnInfo.sectionIdIndex, realmObjectSource.realmGet$sectionId());
        builder.addInteger(columnInfo.updatedMsIndex, realmObjectSource.realmGet$updatedMs());
        builder.addInteger(columnInfo.weightIndex, realmObjectSource.realmGet$weight());
        builder.addInteger(columnInfo.displayTypeIndex, realmObjectSource.realmGet$displayType());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.PPCardServiceModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPCardServiceModelColumnInfo columnInfo = (PPCardServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$id();
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
        String realmGet$icon = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$icon();
        if (realmGet$icon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
        }
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$comment = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$comment();
        if (realmGet$comment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
        }
        String realmGet$description = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$statusText = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$statusText();
        if (realmGet$statusText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusTextIndex, rowIndex, realmGet$statusText, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$status(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.percentIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$percent(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$active(), false);
        String realmGet$questionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$questionId();
        if (realmGet$questionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId, false);
        }
        String realmGet$collectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$collectionId();
        if (realmGet$collectionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.collectionIdIndex, rowIndex, realmGet$collectionId, false);
        }
        String realmGet$sectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$sectionId();
        if (realmGet$sectionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sectionIdIndex, rowIndex, realmGet$sectionId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.updatedMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$updatedMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.weightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$weight(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.displayTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$displayType(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPCardServiceModelColumnInfo columnInfo = (PPCardServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.PPCardServiceModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPCardServiceModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$id();
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
            String realmGet$icon = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$icon();
            if (realmGet$icon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
            }
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$comment = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$comment();
            if (realmGet$comment != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
            }
            String realmGet$description = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$statusText = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$statusText();
            if (realmGet$statusText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusTextIndex, rowIndex, realmGet$statusText, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$status(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.percentIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$percent(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$active(), false);
            String realmGet$questionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$questionId();
            if (realmGet$questionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId, false);
            }
            String realmGet$collectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$collectionId();
            if (realmGet$collectionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.collectionIdIndex, rowIndex, realmGet$collectionId, false);
            }
            String realmGet$sectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$sectionId();
            if (realmGet$sectionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sectionIdIndex, rowIndex, realmGet$sectionId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.updatedMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$updatedMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.weightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$weight(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.displayTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$displayType(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.PPCardServiceModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPCardServiceModelColumnInfo columnInfo = (PPCardServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$id();
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
        String realmGet$icon = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$icon();
        if (realmGet$icon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.iconIndex, rowIndex, false);
        }
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$comment = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$comment();
        if (realmGet$comment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.commentIndex, rowIndex, false);
        }
        String realmGet$description = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$statusText = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$statusText();
        if (realmGet$statusText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusTextIndex, rowIndex, realmGet$statusText, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusTextIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$status(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.percentIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$percent(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$active(), false);
        String realmGet$questionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$questionId();
        if (realmGet$questionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.questionIdIndex, rowIndex, false);
        }
        String realmGet$collectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$collectionId();
        if (realmGet$collectionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.collectionIdIndex, rowIndex, realmGet$collectionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.collectionIdIndex, rowIndex, false);
        }
        String realmGet$sectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$sectionId();
        if (realmGet$sectionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sectionIdIndex, rowIndex, realmGet$sectionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sectionIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.updatedMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$updatedMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.weightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$weight(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.displayTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$displayType(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long tableNativePtr = table.getNativePtr();
        PPCardServiceModelColumnInfo columnInfo = (PPCardServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.PPCardServiceModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPCardServiceModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$id();
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
            String realmGet$icon = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$icon();
            if (realmGet$icon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.iconIndex, rowIndex, realmGet$icon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.iconIndex, rowIndex, false);
            }
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$comment = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$comment();
            if (realmGet$comment != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.commentIndex, rowIndex, false);
            }
            String realmGet$description = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$statusText = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$statusText();
            if (realmGet$statusText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusTextIndex, rowIndex, realmGet$statusText, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusTextIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$status(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.percentIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$percent(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$active(), false);
            String realmGet$questionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$questionId();
            if (realmGet$questionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.questionIdIndex, rowIndex, false);
            }
            String realmGet$collectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$collectionId();
            if (realmGet$collectionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.collectionIdIndex, rowIndex, realmGet$collectionId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.collectionIdIndex, rowIndex, false);
            }
            String realmGet$sectionId = ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$sectionId();
            if (realmGet$sectionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sectionIdIndex, rowIndex, realmGet$sectionId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sectionIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.updatedMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$updatedMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.weightIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$weight(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.displayTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) object).realmGet$displayType(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.models.PPCardServiceModel createDetachedCopy(com.peoplepowerco.virtuoso.models.PPCardServiceModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.PPCardServiceModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.PPCardServiceModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.PPCardServiceModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.PPCardServiceModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$icon(realmSource.realmGet$icon());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$comment(realmSource.realmGet$comment());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$statusText(realmSource.realmGet$statusText());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$percent(realmSource.realmGet$percent());
        unmanagedCopy.realmSet$active(realmSource.realmGet$active());
        unmanagedCopy.realmSet$questionId(realmSource.realmGet$questionId());
        unmanagedCopy.realmSet$collectionId(realmSource.realmGet$collectionId());
        unmanagedCopy.realmSet$sectionId(realmSource.realmGet$sectionId());
        unmanagedCopy.realmSet$updatedMs(realmSource.realmGet$updatedMs());
        unmanagedCopy.realmSet$weight(realmSource.realmGet$weight());
        unmanagedCopy.realmSet$displayType(realmSource.realmGet$displayType());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.PPCardServiceModel update(Realm realm, PPCardServiceModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPCardServiceModel realmObject, com.peoplepowerco.virtuoso.models.PPCardServiceModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.iconIndex, realmObjectSource.realmGet$icon());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.commentIndex, realmObjectSource.realmGet$comment());
        builder.addString(columnInfo.descriptionIndex, realmObjectSource.realmGet$description());
        builder.addString(columnInfo.statusTextIndex, realmObjectSource.realmGet$statusText());
        builder.addInteger(columnInfo.statusIndex, realmObjectSource.realmGet$status());
        builder.addFloat(columnInfo.percentIndex, realmObjectSource.realmGet$percent());
        builder.addBoolean(columnInfo.activeIndex, realmObjectSource.realmGet$active());
        builder.addString(columnInfo.questionIdIndex, realmObjectSource.realmGet$questionId());
        builder.addString(columnInfo.collectionIdIndex, realmObjectSource.realmGet$collectionId());
        builder.addString(columnInfo.sectionIdIndex, realmObjectSource.realmGet$sectionId());
        builder.addInteger(columnInfo.updatedMsIndex, realmObjectSource.realmGet$updatedMs());
        builder.addInteger(columnInfo.weightIndex, realmObjectSource.realmGet$weight());
        builder.addInteger(columnInfo.displayTypeIndex, realmObjectSource.realmGet$displayType());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPCardServiceModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{icon:");
        stringBuilder.append(realmGet$icon() != null ? realmGet$icon() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comment:");
        stringBuilder.append(realmGet$comment() != null ? realmGet$comment() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{statusText:");
        stringBuilder.append(realmGet$statusText() != null ? realmGet$statusText() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{percent:");
        stringBuilder.append(realmGet$percent());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{active:");
        stringBuilder.append(realmGet$active());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{questionId:");
        stringBuilder.append(realmGet$questionId() != null ? realmGet$questionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{collectionId:");
        stringBuilder.append(realmGet$collectionId() != null ? realmGet$collectionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sectionId:");
        stringBuilder.append(realmGet$sectionId() != null ? realmGet$sectionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updatedMs:");
        stringBuilder.append(realmGet$updatedMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{weight:");
        stringBuilder.append(realmGet$weight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{displayType:");
        stringBuilder.append(realmGet$displayType());
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
        com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy aPPCardServiceModel = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPCardServiceModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPCardServiceModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPCardServiceModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
