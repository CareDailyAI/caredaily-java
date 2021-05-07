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
public class com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostFileModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface {

    static final class PPPostFileModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long fileIdIndex;
        long typeIndex;
        long contentTypeIndex;
        long extIndex;
        long durationIndex;
        long rotateIndex;
        long sizeIndex;
        long thumbnailIndex;
        long m3u8Index;
        long contentUrlIndex;
        long thumbnailUrlIndex;
        long m3u8UrlIndex;

        PPPostFileModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(12);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostFileModel");
            this.fileIdIndex = addColumnDetails("fileId", "fileId", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.contentTypeIndex = addColumnDetails("contentType", "contentType", objectSchemaInfo);
            this.extIndex = addColumnDetails("ext", "ext", objectSchemaInfo);
            this.durationIndex = addColumnDetails("duration", "duration", objectSchemaInfo);
            this.rotateIndex = addColumnDetails("rotate", "rotate", objectSchemaInfo);
            this.sizeIndex = addColumnDetails("size", "size", objectSchemaInfo);
            this.thumbnailIndex = addColumnDetails("thumbnail", "thumbnail", objectSchemaInfo);
            this.m3u8Index = addColumnDetails("m3u8", "m3u8", objectSchemaInfo);
            this.contentUrlIndex = addColumnDetails("contentUrl", "contentUrl", objectSchemaInfo);
            this.thumbnailUrlIndex = addColumnDetails("thumbnailUrl", "thumbnailUrl", objectSchemaInfo);
            this.m3u8UrlIndex = addColumnDetails("m3u8Url", "m3u8Url", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostFileModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostFileModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostFileModelColumnInfo src = (PPPostFileModelColumnInfo) rawSrc;
            final PPPostFileModelColumnInfo dst = (PPPostFileModelColumnInfo) rawDst;
            dst.fileIdIndex = src.fileIdIndex;
            dst.typeIndex = src.typeIndex;
            dst.contentTypeIndex = src.contentTypeIndex;
            dst.extIndex = src.extIndex;
            dst.durationIndex = src.durationIndex;
            dst.rotateIndex = src.rotateIndex;
            dst.sizeIndex = src.sizeIndex;
            dst.thumbnailIndex = src.thumbnailIndex;
            dst.m3u8Index = src.m3u8Index;
            dst.contentUrlIndex = src.contentUrlIndex;
            dst.thumbnailUrlIndex = src.thumbnailUrlIndex;
            dst.m3u8UrlIndex = src.m3u8UrlIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostFileModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> proxyState;

    com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostFileModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fileId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fileIdIndex);
    }

    @Override
    public void realmSet$fileId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'fileId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$contentType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentTypeIndex);
    }

    @Override
    public void realmSet$contentType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ext() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.extIndex);
    }

    @Override
    public void realmSet$ext(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.extIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.extIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.extIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.extIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$duration() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.durationIndex);
    }

    @Override
    public void realmSet$duration(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.durationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.durationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$rotate() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rotateIndex);
    }

    @Override
    public void realmSet$rotate(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rotateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rotateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$size() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.sizeIndex);
    }

    @Override
    public void realmSet$size(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sizeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$thumbnail() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.thumbnailIndex);
    }

    @Override
    public void realmSet$thumbnail(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.thumbnailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.thumbnailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$m3u8() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.m3u8Index);
    }

    @Override
    public void realmSet$m3u8(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.m3u8Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.m3u8Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$contentUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentUrlIndex);
    }

    @Override
    public void realmSet$contentUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbnailUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbnailUrlIndex);
    }

    @Override
    public void realmSet$thumbnailUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbnailUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbnailUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbnailUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbnailUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$m3u8Url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.m3u8UrlIndex);
    }

    @Override
    public void realmSet$m3u8Url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.m3u8UrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.m3u8UrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.m3u8UrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.m3u8UrlIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostFileModel", 12, 0);
        builder.addPersistedProperty("fileId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("contentType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ext", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("duration", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("rotate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("size", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("thumbnail", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("m3u8", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("contentUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumbnailUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("m3u8Url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostFileModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostFileModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostFileModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostFileModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostFileModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.communities.PPPostFileModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
            PPPostFileModelColumnInfo columnInfo = (PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
            long pkColumnIndex = columnInfo.fileIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("fileId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("fileId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("fileId")) {
                if (json.isNull("fileId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class, json.getString("fileId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'fileId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) obj;
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                objProxy.realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("contentType")) {
            if (json.isNull("contentType")) {
                objProxy.realmSet$contentType(null);
            } else {
                objProxy.realmSet$contentType((String) json.getString("contentType"));
            }
        }
        if (json.has("ext")) {
            if (json.isNull("ext")) {
                objProxy.realmSet$ext(null);
            } else {
                objProxy.realmSet$ext((String) json.getString("ext"));
            }
        }
        if (json.has("duration")) {
            if (json.isNull("duration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'duration' to null.");
            } else {
                objProxy.realmSet$duration((long) json.getLong("duration"));
            }
        }
        if (json.has("rotate")) {
            if (json.isNull("rotate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rotate' to null.");
            } else {
                objProxy.realmSet$rotate((int) json.getInt("rotate"));
            }
        }
        if (json.has("size")) {
            if (json.isNull("size")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'size' to null.");
            } else {
                objProxy.realmSet$size((long) json.getLong("size"));
            }
        }
        if (json.has("thumbnail")) {
            if (json.isNull("thumbnail")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'thumbnail' to null.");
            } else {
                objProxy.realmSet$thumbnail((boolean) json.getBoolean("thumbnail"));
            }
        }
        if (json.has("m3u8")) {
            if (json.isNull("m3u8")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'm3u8' to null.");
            } else {
                objProxy.realmSet$m3u8((boolean) json.getBoolean("m3u8"));
            }
        }
        if (json.has("contentUrl")) {
            if (json.isNull("contentUrl")) {
                objProxy.realmSet$contentUrl(null);
            } else {
                objProxy.realmSet$contentUrl((String) json.getString("contentUrl"));
            }
        }
        if (json.has("thumbnailUrl")) {
            if (json.isNull("thumbnailUrl")) {
                objProxy.realmSet$thumbnailUrl(null);
            } else {
                objProxy.realmSet$thumbnailUrl((String) json.getString("thumbnailUrl"));
            }
        }
        if (json.has("m3u8Url")) {
            if (json.isNull("m3u8Url")) {
                objProxy.realmSet$m3u8Url(null);
            } else {
                objProxy.realmSet$m3u8Url((String) json.getString("m3u8Url"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostFileModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.communities.PPPostFileModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostFileModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("fileId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fileId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fileId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                }
            } else if (name.equals("contentType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$contentType((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$contentType(null);
                }
            } else if (name.equals("ext")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ext((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ext(null);
                }
            } else if (name.equals("duration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$duration((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'duration' to null.");
                }
            } else if (name.equals("rotate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rotate((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rotate' to null.");
                }
            } else if (name.equals("size")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$size((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'size' to null.");
                }
            } else if (name.equals("thumbnail")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbnail((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'thumbnail' to null.");
                }
            } else if (name.equals("m3u8")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$m3u8((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'm3u8' to null.");
                }
            } else if (name.equals("contentUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$contentUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$contentUrl(null);
                }
            } else if (name.equals("thumbnailUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbnailUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbnailUrl(null);
                }
            } else if (name.equals("m3u8Url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$m3u8Url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$m3u8Url(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'fileId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostFileModel copyOrUpdate(Realm realm, PPPostFileModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostFileModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostFileModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
            long pkColumnIndex = columnInfo.fileIdIndex;
            String value = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$fileId();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostFileModel copy(Realm realm, PPPostFileModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostFileModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.fileIdIndex, realmObjectSource.realmGet$fileId());
        builder.addInteger(columnInfo.typeIndex, realmObjectSource.realmGet$type());
        builder.addString(columnInfo.contentTypeIndex, realmObjectSource.realmGet$contentType());
        builder.addString(columnInfo.extIndex, realmObjectSource.realmGet$ext());
        builder.addInteger(columnInfo.durationIndex, realmObjectSource.realmGet$duration());
        builder.addInteger(columnInfo.rotateIndex, realmObjectSource.realmGet$rotate());
        builder.addInteger(columnInfo.sizeIndex, realmObjectSource.realmGet$size());
        builder.addBoolean(columnInfo.thumbnailIndex, realmObjectSource.realmGet$thumbnail());
        builder.addBoolean(columnInfo.m3u8Index, realmObjectSource.realmGet$m3u8());
        builder.addString(columnInfo.contentUrlIndex, realmObjectSource.realmGet$contentUrl());
        builder.addString(columnInfo.thumbnailUrlIndex, realmObjectSource.realmGet$thumbnailUrl());
        builder.addString(columnInfo.m3u8UrlIndex, realmObjectSource.realmGet$m3u8Url());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostFileModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostFileModelColumnInfo columnInfo = (PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long pkColumnIndex = columnInfo.fileIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$fileId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$type(), false);
        String realmGet$contentType = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentType();
        if (realmGet$contentType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentTypeIndex, rowIndex, realmGet$contentType, false);
        }
        String realmGet$ext = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$ext();
        if (realmGet$ext != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.extIndex, rowIndex, realmGet$ext, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$duration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rotateIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$rotate(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$size(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnail(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.m3u8Index, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8(), false);
        String realmGet$contentUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentUrl();
        if (realmGet$contentUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentUrlIndex, rowIndex, realmGet$contentUrl, false);
        }
        String realmGet$thumbnailUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnailUrl();
        if (realmGet$thumbnailUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailUrlIndex, rowIndex, realmGet$thumbnailUrl, false);
        }
        String realmGet$m3u8Url = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8Url();
        if (realmGet$m3u8Url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.m3u8UrlIndex, rowIndex, realmGet$m3u8Url, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostFileModelColumnInfo columnInfo = (PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long pkColumnIndex = columnInfo.fileIdIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostFileModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$fileId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$type(), false);
            String realmGet$contentType = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentType();
            if (realmGet$contentType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentTypeIndex, rowIndex, realmGet$contentType, false);
            }
            String realmGet$ext = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$ext();
            if (realmGet$ext != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.extIndex, rowIndex, realmGet$ext, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$duration(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rotateIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$rotate(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$size(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnail(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.m3u8Index, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8(), false);
            String realmGet$contentUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentUrl();
            if (realmGet$contentUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentUrlIndex, rowIndex, realmGet$contentUrl, false);
            }
            String realmGet$thumbnailUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnailUrl();
            if (realmGet$thumbnailUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailUrlIndex, rowIndex, realmGet$thumbnailUrl, false);
            }
            String realmGet$m3u8Url = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8Url();
            if (realmGet$m3u8Url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.m3u8UrlIndex, rowIndex, realmGet$m3u8Url, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostFileModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostFileModelColumnInfo columnInfo = (PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long pkColumnIndex = columnInfo.fileIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$fileId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$type(), false);
        String realmGet$contentType = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentType();
        if (realmGet$contentType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentTypeIndex, rowIndex, realmGet$contentType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentTypeIndex, rowIndex, false);
        }
        String realmGet$ext = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$ext();
        if (realmGet$ext != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.extIndex, rowIndex, realmGet$ext, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.extIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$duration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rotateIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$rotate(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$size(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnail(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.m3u8Index, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8(), false);
        String realmGet$contentUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentUrl();
        if (realmGet$contentUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentUrlIndex, rowIndex, realmGet$contentUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentUrlIndex, rowIndex, false);
        }
        String realmGet$thumbnailUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnailUrl();
        if (realmGet$thumbnailUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailUrlIndex, rowIndex, realmGet$thumbnailUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailUrlIndex, rowIndex, false);
        }
        String realmGet$m3u8Url = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8Url();
        if (realmGet$m3u8Url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.m3u8UrlIndex, rowIndex, realmGet$m3u8Url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.m3u8UrlIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostFileModelColumnInfo columnInfo = (PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        long pkColumnIndex = columnInfo.fileIdIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostFileModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$fileId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$type(), false);
            String realmGet$contentType = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentType();
            if (realmGet$contentType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentTypeIndex, rowIndex, realmGet$contentType, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentTypeIndex, rowIndex, false);
            }
            String realmGet$ext = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$ext();
            if (realmGet$ext != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.extIndex, rowIndex, realmGet$ext, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.extIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$duration(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rotateIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$rotate(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sizeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$size(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnail(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.m3u8Index, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8(), false);
            String realmGet$contentUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$contentUrl();
            if (realmGet$contentUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentUrlIndex, rowIndex, realmGet$contentUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentUrlIndex, rowIndex, false);
            }
            String realmGet$thumbnailUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$thumbnailUrl();
            if (realmGet$thumbnailUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailUrlIndex, rowIndex, realmGet$thumbnailUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailUrlIndex, rowIndex, false);
            }
            String realmGet$m3u8Url = ((com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) object).realmGet$m3u8Url();
            if (realmGet$m3u8Url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.m3u8UrlIndex, rowIndex, realmGet$m3u8Url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.m3u8UrlIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostFileModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostFileModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostFileModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$fileId(realmSource.realmGet$fileId());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$contentType(realmSource.realmGet$contentType());
        unmanagedCopy.realmSet$ext(realmSource.realmGet$ext());
        unmanagedCopy.realmSet$duration(realmSource.realmGet$duration());
        unmanagedCopy.realmSet$rotate(realmSource.realmGet$rotate());
        unmanagedCopy.realmSet$size(realmSource.realmGet$size());
        unmanagedCopy.realmSet$thumbnail(realmSource.realmGet$thumbnail());
        unmanagedCopy.realmSet$m3u8(realmSource.realmGet$m3u8());
        unmanagedCopy.realmSet$contentUrl(realmSource.realmGet$contentUrl());
        unmanagedCopy.realmSet$thumbnailUrl(realmSource.realmGet$thumbnailUrl());
        unmanagedCopy.realmSet$m3u8Url(realmSource.realmGet$m3u8Url());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.communities.PPPostFileModel update(Realm realm, PPPostFileModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostFileModel realmObject, com.peoplepowerco.virtuoso.models.communities.PPPostFileModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.fileIdIndex, realmObjectSource.realmGet$fileId());
        builder.addInteger(columnInfo.typeIndex, realmObjectSource.realmGet$type());
        builder.addString(columnInfo.contentTypeIndex, realmObjectSource.realmGet$contentType());
        builder.addString(columnInfo.extIndex, realmObjectSource.realmGet$ext());
        builder.addInteger(columnInfo.durationIndex, realmObjectSource.realmGet$duration());
        builder.addInteger(columnInfo.rotateIndex, realmObjectSource.realmGet$rotate());
        builder.addInteger(columnInfo.sizeIndex, realmObjectSource.realmGet$size());
        builder.addBoolean(columnInfo.thumbnailIndex, realmObjectSource.realmGet$thumbnail());
        builder.addBoolean(columnInfo.m3u8Index, realmObjectSource.realmGet$m3u8());
        builder.addString(columnInfo.contentUrlIndex, realmObjectSource.realmGet$contentUrl());
        builder.addString(columnInfo.thumbnailUrlIndex, realmObjectSource.realmGet$thumbnailUrl());
        builder.addString(columnInfo.m3u8UrlIndex, realmObjectSource.realmGet$m3u8Url());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPPostFileModel = proxy[");
        stringBuilder.append("{fileId:");
        stringBuilder.append(realmGet$fileId() != null ? realmGet$fileId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contentType:");
        stringBuilder.append(realmGet$contentType() != null ? realmGet$contentType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ext:");
        stringBuilder.append(realmGet$ext() != null ? realmGet$ext() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{duration:");
        stringBuilder.append(realmGet$duration());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rotate:");
        stringBuilder.append(realmGet$rotate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{size:");
        stringBuilder.append(realmGet$size());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbnail:");
        stringBuilder.append(realmGet$thumbnail());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{m3u8:");
        stringBuilder.append(realmGet$m3u8());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contentUrl:");
        stringBuilder.append(realmGet$contentUrl() != null ? realmGet$contentUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbnailUrl:");
        stringBuilder.append(realmGet$thumbnailUrl() != null ? realmGet$thumbnailUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{m3u8Url:");
        stringBuilder.append(realmGet$m3u8Url() != null ? realmGet$m3u8Url() : "null");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy aPPPostFileModel = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostFileModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostFileModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostFileModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
