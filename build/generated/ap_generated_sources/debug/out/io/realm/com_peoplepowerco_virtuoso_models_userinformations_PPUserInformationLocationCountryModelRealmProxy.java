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
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface {

    static final class PPUserInformationLocationCountryModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long locationIdIndex;
        long idIndex;
        long sNameIndex;
        long sCountryCodeIndex;
        long sCurrencyCodeIndex;
        long sCurrencySymbolIndex;
        long sZipFormatIndex;
        long sStateNameIndex;
        long sZipNameIndex;

        PPUserInformationLocationCountryModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationLocationCountryModel");
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.sNameIndex = addColumnDetails("sName", "sName", objectSchemaInfo);
            this.sCountryCodeIndex = addColumnDetails("sCountryCode", "sCountryCode", objectSchemaInfo);
            this.sCurrencyCodeIndex = addColumnDetails("sCurrencyCode", "sCurrencyCode", objectSchemaInfo);
            this.sCurrencySymbolIndex = addColumnDetails("sCurrencySymbol", "sCurrencySymbol", objectSchemaInfo);
            this.sZipFormatIndex = addColumnDetails("sZipFormat", "sZipFormat", objectSchemaInfo);
            this.sStateNameIndex = addColumnDetails("sStateName", "sStateName", objectSchemaInfo);
            this.sZipNameIndex = addColumnDetails("sZipName", "sZipName", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationLocationCountryModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationLocationCountryModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationLocationCountryModelColumnInfo src = (PPUserInformationLocationCountryModelColumnInfo) rawSrc;
            final PPUserInformationLocationCountryModelColumnInfo dst = (PPUserInformationLocationCountryModelColumnInfo) rawDst;
            dst.locationIdIndex = src.locationIdIndex;
            dst.idIndex = src.idIndex;
            dst.sNameIndex = src.sNameIndex;
            dst.sCountryCodeIndex = src.sCountryCodeIndex;
            dst.sCurrencyCodeIndex = src.sCurrencyCodeIndex;
            dst.sCurrencySymbolIndex = src.sCurrencySymbolIndex;
            dst.sZipFormatIndex = src.sZipFormatIndex;
            dst.sStateNameIndex = src.sStateNameIndex;
            dst.sZipNameIndex = src.sZipNameIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationLocationCountryModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel> proxyState;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationLocationCountryModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$locationId() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.locationIdIndex);
    }

    @Override
    public void realmSet$locationId(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'locationId' cannot be changed after object was created.");
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
    public String realmGet$sCountryCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sCountryCodeIndex);
    }

    @Override
    public void realmSet$sCountryCode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sCountryCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sCountryCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sCountryCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sCountryCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sCurrencyCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sCurrencyCodeIndex);
    }

    @Override
    public void realmSet$sCurrencyCode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sCurrencyCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sCurrencyCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sCurrencyCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sCurrencyCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sCurrencySymbol() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sCurrencySymbolIndex);
    }

    @Override
    public void realmSet$sCurrencySymbol(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sCurrencySymbolIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sCurrencySymbolIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sCurrencySymbolIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sCurrencySymbolIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sZipFormat() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sZipFormatIndex);
    }

    @Override
    public void realmSet$sZipFormat(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sZipFormatIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sZipFormatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sZipFormatIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sZipFormatIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sStateName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sStateNameIndex);
    }

    @Override
    public void realmSet$sStateName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sStateNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sStateNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sStateNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sStateNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sZipName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sZipNameIndex);
    }

    @Override
    public void realmSet$sZipName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sZipNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sZipNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sZipNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sZipNameIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationLocationCountryModel", 9, 0);
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sCountryCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sCurrencyCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sCurrencySymbol", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sZipFormat", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sStateName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sZipName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationLocationCountryModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationLocationCountryModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationLocationCountryModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationLocationCountryModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
            PPUserInformationLocationCountryModelColumnInfo columnInfo = (PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
            long pkColumnIndex = columnInfo.locationIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("locationId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("locationId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("locationId")) {
                if (json.isNull("locationId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class, json.getLong("locationId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'locationId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("sName")) {
            if (json.isNull("sName")) {
                objProxy.realmSet$sName(null);
            } else {
                objProxy.realmSet$sName((String) json.getString("sName"));
            }
        }
        if (json.has("sCountryCode")) {
            if (json.isNull("sCountryCode")) {
                objProxy.realmSet$sCountryCode(null);
            } else {
                objProxy.realmSet$sCountryCode((String) json.getString("sCountryCode"));
            }
        }
        if (json.has("sCurrencyCode")) {
            if (json.isNull("sCurrencyCode")) {
                objProxy.realmSet$sCurrencyCode(null);
            } else {
                objProxy.realmSet$sCurrencyCode((String) json.getString("sCurrencyCode"));
            }
        }
        if (json.has("sCurrencySymbol")) {
            if (json.isNull("sCurrencySymbol")) {
                objProxy.realmSet$sCurrencySymbol(null);
            } else {
                objProxy.realmSet$sCurrencySymbol((String) json.getString("sCurrencySymbol"));
            }
        }
        if (json.has("sZipFormat")) {
            if (json.isNull("sZipFormat")) {
                objProxy.realmSet$sZipFormat(null);
            } else {
                objProxy.realmSet$sZipFormat((String) json.getString("sZipFormat"));
            }
        }
        if (json.has("sStateName")) {
            if (json.isNull("sStateName")) {
                objProxy.realmSet$sStateName(null);
            } else {
                objProxy.realmSet$sStateName((String) json.getString("sStateName"));
            }
        }
        if (json.has("sZipName")) {
            if (json.isNull("sZipName")) {
                objProxy.realmSet$sZipName(null);
            } else {
                objProxy.realmSet$sZipName((String) json.getString("sZipName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("locationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationId((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("sName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sName(null);
                }
            } else if (name.equals("sCountryCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sCountryCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sCountryCode(null);
                }
            } else if (name.equals("sCurrencyCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sCurrencyCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sCurrencyCode(null);
                }
            } else if (name.equals("sCurrencySymbol")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sCurrencySymbol((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sCurrencySymbol(null);
                }
            } else if (name.equals("sZipFormat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sZipFormat((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sZipFormat(null);
                }
            } else if (name.equals("sStateName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sStateName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sStateName(null);
                }
            } else if (name.equals("sZipName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sZipName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sZipName(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'locationId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel copyOrUpdate(Realm realm, PPUserInformationLocationCountryModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
            long pkColumnIndex = columnInfo.locationIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel copy(Realm realm, PPUserInformationLocationCountryModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addString(columnInfo.sCountryCodeIndex, realmObjectSource.realmGet$sCountryCode());
        builder.addString(columnInfo.sCurrencyCodeIndex, realmObjectSource.realmGet$sCurrencyCode());
        builder.addString(columnInfo.sCurrencySymbolIndex, realmObjectSource.realmGet$sCurrencySymbol());
        builder.addString(columnInfo.sZipFormatIndex, realmObjectSource.realmGet$sZipFormat());
        builder.addString(columnInfo.sStateNameIndex, realmObjectSource.realmGet$sStateName());
        builder.addString(columnInfo.sZipNameIndex, realmObjectSource.realmGet$sZipName());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationCountryModelColumnInfo columnInfo = (PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        }
        String realmGet$sCountryCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCountryCode();
        if (realmGet$sCountryCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCountryCodeIndex, rowIndex, realmGet$sCountryCode, false);
        }
        String realmGet$sCurrencyCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencyCode();
        if (realmGet$sCurrencyCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCurrencyCodeIndex, rowIndex, realmGet$sCurrencyCode, false);
        }
        String realmGet$sCurrencySymbol = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencySymbol();
        if (realmGet$sCurrencySymbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCurrencySymbolIndex, rowIndex, realmGet$sCurrencySymbol, false);
        }
        String realmGet$sZipFormat = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipFormat();
        if (realmGet$sZipFormat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sZipFormatIndex, rowIndex, realmGet$sZipFormat, false);
        }
        String realmGet$sStateName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sStateName();
        if (realmGet$sStateName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sStateNameIndex, rowIndex, realmGet$sStateName, false);
        }
        String realmGet$sZipName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipName();
        if (realmGet$sZipName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sZipNameIndex, rowIndex, realmGet$sZipName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationCountryModelColumnInfo columnInfo = (PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            }
            String realmGet$sCountryCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCountryCode();
            if (realmGet$sCountryCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCountryCodeIndex, rowIndex, realmGet$sCountryCode, false);
            }
            String realmGet$sCurrencyCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencyCode();
            if (realmGet$sCurrencyCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCurrencyCodeIndex, rowIndex, realmGet$sCurrencyCode, false);
            }
            String realmGet$sCurrencySymbol = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencySymbol();
            if (realmGet$sCurrencySymbol != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCurrencySymbolIndex, rowIndex, realmGet$sCurrencySymbol, false);
            }
            String realmGet$sZipFormat = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipFormat();
            if (realmGet$sZipFormat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sZipFormatIndex, rowIndex, realmGet$sZipFormat, false);
            }
            String realmGet$sStateName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sStateName();
            if (realmGet$sStateName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sStateNameIndex, rowIndex, realmGet$sStateName, false);
            }
            String realmGet$sZipName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipName();
            if (realmGet$sZipName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sZipNameIndex, rowIndex, realmGet$sZipName, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationCountryModelColumnInfo columnInfo = (PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
        }
        cache.put(object, rowIndex);
        String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
        }
        String realmGet$sCountryCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCountryCode();
        if (realmGet$sCountryCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCountryCodeIndex, rowIndex, realmGet$sCountryCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sCountryCodeIndex, rowIndex, false);
        }
        String realmGet$sCurrencyCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencyCode();
        if (realmGet$sCurrencyCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCurrencyCodeIndex, rowIndex, realmGet$sCurrencyCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sCurrencyCodeIndex, rowIndex, false);
        }
        String realmGet$sCurrencySymbol = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencySymbol();
        if (realmGet$sCurrencySymbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCurrencySymbolIndex, rowIndex, realmGet$sCurrencySymbol, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sCurrencySymbolIndex, rowIndex, false);
        }
        String realmGet$sZipFormat = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipFormat();
        if (realmGet$sZipFormat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sZipFormatIndex, rowIndex, realmGet$sZipFormat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sZipFormatIndex, rowIndex, false);
        }
        String realmGet$sStateName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sStateName();
        if (realmGet$sStateName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sStateNameIndex, rowIndex, realmGet$sStateName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sStateNameIndex, rowIndex, false);
        }
        String realmGet$sZipName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipName();
        if (realmGet$sZipName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sZipNameIndex, rowIndex, realmGet$sZipName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sZipNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationCountryModelColumnInfo columnInfo = (PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        long pkColumnIndex = columnInfo.locationIdIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$locationId());
            }
            cache.put(object, rowIndex);
            String realmGet$id = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
            }
            String realmGet$sCountryCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCountryCode();
            if (realmGet$sCountryCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCountryCodeIndex, rowIndex, realmGet$sCountryCode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sCountryCodeIndex, rowIndex, false);
            }
            String realmGet$sCurrencyCode = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencyCode();
            if (realmGet$sCurrencyCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCurrencyCodeIndex, rowIndex, realmGet$sCurrencyCode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sCurrencyCodeIndex, rowIndex, false);
            }
            String realmGet$sCurrencySymbol = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sCurrencySymbol();
            if (realmGet$sCurrencySymbol != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCurrencySymbolIndex, rowIndex, realmGet$sCurrencySymbol, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sCurrencySymbolIndex, rowIndex, false);
            }
            String realmGet$sZipFormat = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipFormat();
            if (realmGet$sZipFormat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sZipFormatIndex, rowIndex, realmGet$sZipFormat, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sZipFormatIndex, rowIndex, false);
            }
            String realmGet$sStateName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sStateName();
            if (realmGet$sStateName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sStateNameIndex, rowIndex, realmGet$sStateName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sStateNameIndex, rowIndex, false);
            }
            String realmGet$sZipName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) object).realmGet$sZipName();
            if (realmGet$sZipName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sZipNameIndex, rowIndex, realmGet$sZipName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sZipNameIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$sName(realmSource.realmGet$sName());
        unmanagedCopy.realmSet$sCountryCode(realmSource.realmGet$sCountryCode());
        unmanagedCopy.realmSet$sCurrencyCode(realmSource.realmGet$sCurrencyCode());
        unmanagedCopy.realmSet$sCurrencySymbol(realmSource.realmGet$sCurrencySymbol());
        unmanagedCopy.realmSet$sZipFormat(realmSource.realmGet$sZipFormat());
        unmanagedCopy.realmSet$sStateName(realmSource.realmGet$sStateName());
        unmanagedCopy.realmSet$sZipName(realmSource.realmGet$sZipName());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel update(Realm realm, PPUserInformationLocationCountryModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel realmObject, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addString(columnInfo.sCountryCodeIndex, realmObjectSource.realmGet$sCountryCode());
        builder.addString(columnInfo.sCurrencyCodeIndex, realmObjectSource.realmGet$sCurrencyCode());
        builder.addString(columnInfo.sCurrencySymbolIndex, realmObjectSource.realmGet$sCurrencySymbol());
        builder.addString(columnInfo.sZipFormatIndex, realmObjectSource.realmGet$sZipFormat());
        builder.addString(columnInfo.sStateNameIndex, realmObjectSource.realmGet$sStateName());
        builder.addString(columnInfo.sZipNameIndex, realmObjectSource.realmGet$sZipName());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationLocationCountryModel = proxy[");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sName:");
        stringBuilder.append(realmGet$sName() != null ? realmGet$sName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sCountryCode:");
        stringBuilder.append(realmGet$sCountryCode() != null ? realmGet$sCountryCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sCurrencyCode:");
        stringBuilder.append(realmGet$sCurrencyCode() != null ? realmGet$sCurrencyCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sCurrencySymbol:");
        stringBuilder.append(realmGet$sCurrencySymbol() != null ? realmGet$sCurrencySymbol() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sZipFormat:");
        stringBuilder.append(realmGet$sZipFormat() != null ? realmGet$sZipFormat() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sStateName:");
        stringBuilder.append(realmGet$sStateName() != null ? realmGet$sStateName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sZipName:");
        stringBuilder.append(realmGet$sZipName() != null ? realmGet$sZipName() : "null");
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy aPPUserInformationLocationCountryModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationLocationCountryModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationLocationCountryModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationLocationCountryModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
