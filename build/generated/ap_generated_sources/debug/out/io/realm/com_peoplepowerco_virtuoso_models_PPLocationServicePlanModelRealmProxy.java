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
public class com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy extends com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface {

    static final class PPLocationServicePlanModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long userPlanIdIndex;
        long locationIdIndex;
        long typeIndex;
        long paymentTypeIndex;
        long statusIndex;
        long startDateMsIndex;
        long endDateMsIndex;
        long freeIndex;
        long isPaidIndex;
        long gatewayIdIndex;
        long subscriptionIdIndex;
        long servicesIndex;

        PPLocationServicePlanModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(12);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPLocationServicePlanModel");
            this.userPlanIdIndex = addColumnDetails("userPlanId", "userPlanId", objectSchemaInfo);
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.paymentTypeIndex = addColumnDetails("paymentType", "paymentType", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.startDateMsIndex = addColumnDetails("startDateMs", "startDateMs", objectSchemaInfo);
            this.endDateMsIndex = addColumnDetails("endDateMs", "endDateMs", objectSchemaInfo);
            this.freeIndex = addColumnDetails("free", "free", objectSchemaInfo);
            this.isPaidIndex = addColumnDetails("isPaid", "isPaid", objectSchemaInfo);
            this.gatewayIdIndex = addColumnDetails("gatewayId", "gatewayId", objectSchemaInfo);
            this.subscriptionIdIndex = addColumnDetails("subscriptionId", "subscriptionId", objectSchemaInfo);
            this.servicesIndex = addColumnDetails("services", "services", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPLocationServicePlanModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPLocationServicePlanModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPLocationServicePlanModelColumnInfo src = (PPLocationServicePlanModelColumnInfo) rawSrc;
            final PPLocationServicePlanModelColumnInfo dst = (PPLocationServicePlanModelColumnInfo) rawDst;
            dst.userPlanIdIndex = src.userPlanIdIndex;
            dst.locationIdIndex = src.locationIdIndex;
            dst.typeIndex = src.typeIndex;
            dst.paymentTypeIndex = src.paymentTypeIndex;
            dst.statusIndex = src.statusIndex;
            dst.startDateMsIndex = src.startDateMsIndex;
            dst.endDateMsIndex = src.endDateMsIndex;
            dst.freeIndex = src.freeIndex;
            dst.isPaidIndex = src.isPaidIndex;
            dst.gatewayIdIndex = src.gatewayIdIndex;
            dst.subscriptionIdIndex = src.subscriptionIdIndex;
            dst.servicesIndex = src.servicesIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPLocationServicePlanModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel> proxyState;

    com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPLocationServicePlanModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$userPlanId() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.userPlanIdIndex);
    }

    @Override
    public void realmSet$userPlanId(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'userPlanId' cannot be changed after object was created.");
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.locationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.locationIdIndex, value);
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
    public int realmGet$paymentType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.paymentTypeIndex);
    }

    @Override
    public void realmSet$paymentType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.paymentTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.paymentTypeIndex, value);
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
    public long realmGet$startDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.startDateMsIndex);
    }

    @Override
    public void realmSet$startDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.startDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.startDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$endDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.endDateMsIndex);
    }

    @Override
    public void realmSet$endDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.endDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.endDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$free() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.freeIndex);
    }

    @Override
    public void realmSet$free(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.freeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.freeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isPaid() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isPaidIndex);
    }

    @Override
    public void realmSet$isPaid(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isPaidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isPaidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$gatewayId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.gatewayIdIndex);
    }

    @Override
    public void realmSet$gatewayId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.gatewayIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.gatewayIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.gatewayIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.gatewayIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$subscriptionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.subscriptionIdIndex);
    }

    @Override
    public void realmSet$subscriptionId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.subscriptionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.subscriptionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.subscriptionIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.subscriptionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$services() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.servicesIndex);
    }

    @Override
    public void realmSet$services(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.servicesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.servicesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.servicesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.servicesIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPLocationServicePlanModel", 12, 0);
        builder.addPersistedProperty("userPlanId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("paymentType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("startDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("endDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("free", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isPaid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("gatewayId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("subscriptionId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("services", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPLocationServicePlanModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPLocationServicePlanModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPLocationServicePlanModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPLocationServicePlanModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
            PPLocationServicePlanModelColumnInfo columnInfo = (PPLocationServicePlanModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
            long pkColumnIndex = columnInfo.userPlanIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("userPlanId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("userPlanId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userPlanId")) {
                if (json.isNull("userPlanId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class, json.getLong("userPlanId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userPlanId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) obj;
        if (json.has("locationId")) {
            if (json.isNull("locationId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
            } else {
                objProxy.realmSet$locationId((long) json.getLong("locationId"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                objProxy.realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("paymentType")) {
            if (json.isNull("paymentType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'paymentType' to null.");
            } else {
                objProxy.realmSet$paymentType((int) json.getInt("paymentType"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
            } else {
                objProxy.realmSet$status((int) json.getInt("status"));
            }
        }
        if (json.has("startDateMs")) {
            if (json.isNull("startDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'startDateMs' to null.");
            } else {
                objProxy.realmSet$startDateMs((long) json.getLong("startDateMs"));
            }
        }
        if (json.has("endDateMs")) {
            if (json.isNull("endDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'endDateMs' to null.");
            } else {
                objProxy.realmSet$endDateMs((long) json.getLong("endDateMs"));
            }
        }
        if (json.has("free")) {
            if (json.isNull("free")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'free' to null.");
            } else {
                objProxy.realmSet$free((boolean) json.getBoolean("free"));
            }
        }
        if (json.has("isPaid")) {
            if (json.isNull("isPaid")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isPaid' to null.");
            } else {
                objProxy.realmSet$isPaid((boolean) json.getBoolean("isPaid"));
            }
        }
        if (json.has("gatewayId")) {
            if (json.isNull("gatewayId")) {
                objProxy.realmSet$gatewayId(null);
            } else {
                objProxy.realmSet$gatewayId((String) json.getString("gatewayId"));
            }
        }
        if (json.has("subscriptionId")) {
            if (json.isNull("subscriptionId")) {
                objProxy.realmSet$subscriptionId(null);
            } else {
                objProxy.realmSet$subscriptionId((String) json.getString("subscriptionId"));
            }
        }
        if (json.has("services")) {
            if (json.isNull("services")) {
                objProxy.realmSet$services(null);
            } else {
                objProxy.realmSet$services((String) json.getString("services"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel obj = new com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel();
        final com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userPlanId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userPlanId((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'userPlanId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("locationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationId((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                }
            } else if (name.equals("paymentType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$paymentType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'paymentType' to null.");
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
                }
            } else if (name.equals("startDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$startDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'startDateMs' to null.");
                }
            } else if (name.equals("endDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$endDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'endDateMs' to null.");
                }
            } else if (name.equals("free")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$free((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'free' to null.");
                }
            } else if (name.equals("isPaid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isPaid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isPaid' to null.");
                }
            } else if (name.equals("gatewayId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$gatewayId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$gatewayId(null);
                }
            } else if (name.equals("subscriptionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$subscriptionId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$subscriptionId(null);
                }
            } else if (name.equals("services")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$services((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$services(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userPlanId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel copyOrUpdate(Realm realm, PPLocationServicePlanModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
            long pkColumnIndex = columnInfo.userPlanIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel copy(Realm realm, PPLocationServicePlanModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.userPlanIdIndex, realmObjectSource.realmGet$userPlanId());
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addInteger(columnInfo.typeIndex, realmObjectSource.realmGet$type());
        builder.addInteger(columnInfo.paymentTypeIndex, realmObjectSource.realmGet$paymentType());
        builder.addInteger(columnInfo.statusIndex, realmObjectSource.realmGet$status());
        builder.addInteger(columnInfo.startDateMsIndex, realmObjectSource.realmGet$startDateMs());
        builder.addInteger(columnInfo.endDateMsIndex, realmObjectSource.realmGet$endDateMs());
        builder.addBoolean(columnInfo.freeIndex, realmObjectSource.realmGet$free());
        builder.addBoolean(columnInfo.isPaidIndex, realmObjectSource.realmGet$isPaid());
        builder.addString(columnInfo.gatewayIdIndex, realmObjectSource.realmGet$gatewayId());
        builder.addString(columnInfo.subscriptionIdIndex, realmObjectSource.realmGet$subscriptionId());
        builder.addString(columnInfo.servicesIndex, realmObjectSource.realmGet$services());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long tableNativePtr = table.getNativePtr();
        PPLocationServicePlanModelColumnInfo columnInfo = (PPLocationServicePlanModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long pkColumnIndex = columnInfo.userPlanIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$locationId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$type(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$paymentType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$status(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.startDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$startDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.endDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$endDateMs(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.freeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$free(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaidIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$isPaid(), false);
        String realmGet$gatewayId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$gatewayId();
        if (realmGet$gatewayId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.gatewayIdIndex, rowIndex, realmGet$gatewayId, false);
        }
        String realmGet$subscriptionId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$subscriptionId();
        if (realmGet$subscriptionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subscriptionIdIndex, rowIndex, realmGet$subscriptionId, false);
        }
        String realmGet$services = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$services();
        if (realmGet$services != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.servicesIndex, rowIndex, realmGet$services, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long tableNativePtr = table.getNativePtr();
        PPLocationServicePlanModelColumnInfo columnInfo = (PPLocationServicePlanModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long pkColumnIndex = columnInfo.userPlanIdIndex;
        com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$locationId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$type(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$paymentType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$status(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.startDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$startDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.endDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$endDateMs(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.freeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$free(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaidIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$isPaid(), false);
            String realmGet$gatewayId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$gatewayId();
            if (realmGet$gatewayId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.gatewayIdIndex, rowIndex, realmGet$gatewayId, false);
            }
            String realmGet$subscriptionId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$subscriptionId();
            if (realmGet$subscriptionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subscriptionIdIndex, rowIndex, realmGet$subscriptionId, false);
            }
            String realmGet$services = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$services();
            if (realmGet$services != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.servicesIndex, rowIndex, realmGet$services, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long tableNativePtr = table.getNativePtr();
        PPLocationServicePlanModelColumnInfo columnInfo = (PPLocationServicePlanModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long pkColumnIndex = columnInfo.userPlanIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$locationId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$type(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$paymentType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$status(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.startDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$startDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.endDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$endDateMs(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.freeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$free(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaidIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$isPaid(), false);
        String realmGet$gatewayId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$gatewayId();
        if (realmGet$gatewayId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.gatewayIdIndex, rowIndex, realmGet$gatewayId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.gatewayIdIndex, rowIndex, false);
        }
        String realmGet$subscriptionId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$subscriptionId();
        if (realmGet$subscriptionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subscriptionIdIndex, rowIndex, realmGet$subscriptionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.subscriptionIdIndex, rowIndex, false);
        }
        String realmGet$services = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$services();
        if (realmGet$services != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.servicesIndex, rowIndex, realmGet$services, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.servicesIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long tableNativePtr = table.getNativePtr();
        PPLocationServicePlanModelColumnInfo columnInfo = (PPLocationServicePlanModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        long pkColumnIndex = columnInfo.userPlanIdIndex;
        com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$userPlanId());
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$locationId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$type(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$paymentType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$status(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.startDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$startDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.endDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$endDateMs(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.freeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$free(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isPaidIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$isPaid(), false);
            String realmGet$gatewayId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$gatewayId();
            if (realmGet$gatewayId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.gatewayIdIndex, rowIndex, realmGet$gatewayId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.gatewayIdIndex, rowIndex, false);
            }
            String realmGet$subscriptionId = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$subscriptionId();
            if (realmGet$subscriptionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subscriptionIdIndex, rowIndex, realmGet$subscriptionId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.subscriptionIdIndex, rowIndex, false);
            }
            String realmGet$services = ((com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) object).realmGet$services();
            if (realmGet$services != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.servicesIndex, rowIndex, realmGet$services, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.servicesIndex, rowIndex, false);
            }
        }
    }

    public static com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel createDetachedCopy(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$userPlanId(realmSource.realmGet$userPlanId());
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$paymentType(realmSource.realmGet$paymentType());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$startDateMs(realmSource.realmGet$startDateMs());
        unmanagedCopy.realmSet$endDateMs(realmSource.realmGet$endDateMs());
        unmanagedCopy.realmSet$free(realmSource.realmGet$free());
        unmanagedCopy.realmSet$isPaid(realmSource.realmGet$isPaid());
        unmanagedCopy.realmSet$gatewayId(realmSource.realmGet$gatewayId());
        unmanagedCopy.realmSet$subscriptionId(realmSource.realmGet$subscriptionId());
        unmanagedCopy.realmSet$services(realmSource.realmGet$services());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel update(Realm realm, PPLocationServicePlanModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel realmObject, com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.userPlanIdIndex, realmObjectSource.realmGet$userPlanId());
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addInteger(columnInfo.typeIndex, realmObjectSource.realmGet$type());
        builder.addInteger(columnInfo.paymentTypeIndex, realmObjectSource.realmGet$paymentType());
        builder.addInteger(columnInfo.statusIndex, realmObjectSource.realmGet$status());
        builder.addInteger(columnInfo.startDateMsIndex, realmObjectSource.realmGet$startDateMs());
        builder.addInteger(columnInfo.endDateMsIndex, realmObjectSource.realmGet$endDateMs());
        builder.addBoolean(columnInfo.freeIndex, realmObjectSource.realmGet$free());
        builder.addBoolean(columnInfo.isPaidIndex, realmObjectSource.realmGet$isPaid());
        builder.addString(columnInfo.gatewayIdIndex, realmObjectSource.realmGet$gatewayId());
        builder.addString(columnInfo.subscriptionIdIndex, realmObjectSource.realmGet$subscriptionId());
        builder.addString(columnInfo.servicesIndex, realmObjectSource.realmGet$services());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPLocationServicePlanModel = proxy[");
        stringBuilder.append("{userPlanId:");
        stringBuilder.append(realmGet$userPlanId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paymentType:");
        stringBuilder.append(realmGet$paymentType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startDateMs:");
        stringBuilder.append(realmGet$startDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{endDateMs:");
        stringBuilder.append(realmGet$endDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{free:");
        stringBuilder.append(realmGet$free());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isPaid:");
        stringBuilder.append(realmGet$isPaid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gatewayId:");
        stringBuilder.append(realmGet$gatewayId() != null ? realmGet$gatewayId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subscriptionId:");
        stringBuilder.append(realmGet$subscriptionId() != null ? realmGet$subscriptionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{services:");
        stringBuilder.append(realmGet$services() != null ? realmGet$services() : "null");
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
        com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy aPPLocationServicePlanModel = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPLocationServicePlanModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPLocationServicePlanModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPLocationServicePlanModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
