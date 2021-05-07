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
public class com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy extends com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface {

    static final class PPUserInformationLocationModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long userIdIndex;
        long sNameIndex;
        long locationAccessIndex;
        long userCategoryIndex;
        long fileUploadPolicyIndex;
        long smsPhoneIndex;
        long nTypeIndex;
        long sZipIndex;
        long sLatitudeIndex;
        long slongitudeIndex;
        long dLatitudeIndex;
        long dLongitudeIndex;
        long salesTaxRateIndex;
        long sEventIndex;
        long nStoriesNumberIndex;
        long nRoomsNumberIndex;
        long nBathRoomNumberIndex;
        long nOccupantsNumberIndex;
        long nUsagePeriodIndex;
        long nHeatingTypeIndex;
        long nCoolingTypeIndex;
        long nWaterHeaterTypeIndex;
        long nThermostatTypeIndex;
        long nCodeTypeIndex;
        long sStartDateIndex;
        long sAccessEndDateIndex;
        long lAccessEndDateMsIndex;
        long sAddress1Index;
        long sAddress2Index;
        long sAddCityIndex;
        long sAddStateIndex;
        long iTemporaryIndex;
        long sOrganizationIdIndex;
        long userInformationLocationTimezoneModelIndex;
        long userInformationLocationStateModelIndex;
        long userInformationLocationCountryModelIndex;
        long userInformationLocationOrgModelIndex;
        long userInformationLocationServiceArrayListIndex;

        PPUserInformationLocationModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(39);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInformationLocationModel");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.sNameIndex = addColumnDetails("sName", "sName", objectSchemaInfo);
            this.locationAccessIndex = addColumnDetails("locationAccess", "locationAccess", objectSchemaInfo);
            this.userCategoryIndex = addColumnDetails("userCategory", "userCategory", objectSchemaInfo);
            this.fileUploadPolicyIndex = addColumnDetails("fileUploadPolicy", "fileUploadPolicy", objectSchemaInfo);
            this.smsPhoneIndex = addColumnDetails("smsPhone", "smsPhone", objectSchemaInfo);
            this.nTypeIndex = addColumnDetails("nType", "nType", objectSchemaInfo);
            this.sZipIndex = addColumnDetails("sZip", "sZip", objectSchemaInfo);
            this.sLatitudeIndex = addColumnDetails("sLatitude", "sLatitude", objectSchemaInfo);
            this.slongitudeIndex = addColumnDetails("slongitude", "slongitude", objectSchemaInfo);
            this.dLatitudeIndex = addColumnDetails("dLatitude", "dLatitude", objectSchemaInfo);
            this.dLongitudeIndex = addColumnDetails("dLongitude", "dLongitude", objectSchemaInfo);
            this.salesTaxRateIndex = addColumnDetails("salesTaxRate", "salesTaxRate", objectSchemaInfo);
            this.sEventIndex = addColumnDetails("sEvent", "sEvent", objectSchemaInfo);
            this.nStoriesNumberIndex = addColumnDetails("nStoriesNumber", "nStoriesNumber", objectSchemaInfo);
            this.nRoomsNumberIndex = addColumnDetails("nRoomsNumber", "nRoomsNumber", objectSchemaInfo);
            this.nBathRoomNumberIndex = addColumnDetails("nBathRoomNumber", "nBathRoomNumber", objectSchemaInfo);
            this.nOccupantsNumberIndex = addColumnDetails("nOccupantsNumber", "nOccupantsNumber", objectSchemaInfo);
            this.nUsagePeriodIndex = addColumnDetails("nUsagePeriod", "nUsagePeriod", objectSchemaInfo);
            this.nHeatingTypeIndex = addColumnDetails("nHeatingType", "nHeatingType", objectSchemaInfo);
            this.nCoolingTypeIndex = addColumnDetails("nCoolingType", "nCoolingType", objectSchemaInfo);
            this.nWaterHeaterTypeIndex = addColumnDetails("nWaterHeaterType", "nWaterHeaterType", objectSchemaInfo);
            this.nThermostatTypeIndex = addColumnDetails("nThermostatType", "nThermostatType", objectSchemaInfo);
            this.nCodeTypeIndex = addColumnDetails("nCodeType", "nCodeType", objectSchemaInfo);
            this.sStartDateIndex = addColumnDetails("sStartDate", "sStartDate", objectSchemaInfo);
            this.sAccessEndDateIndex = addColumnDetails("sAccessEndDate", "sAccessEndDate", objectSchemaInfo);
            this.lAccessEndDateMsIndex = addColumnDetails("lAccessEndDateMs", "lAccessEndDateMs", objectSchemaInfo);
            this.sAddress1Index = addColumnDetails("sAddress1", "sAddress1", objectSchemaInfo);
            this.sAddress2Index = addColumnDetails("sAddress2", "sAddress2", objectSchemaInfo);
            this.sAddCityIndex = addColumnDetails("sAddCity", "sAddCity", objectSchemaInfo);
            this.sAddStateIndex = addColumnDetails("sAddState", "sAddState", objectSchemaInfo);
            this.iTemporaryIndex = addColumnDetails("iTemporary", "iTemporary", objectSchemaInfo);
            this.sOrganizationIdIndex = addColumnDetails("sOrganizationId", "sOrganizationId", objectSchemaInfo);
            this.userInformationLocationTimezoneModelIndex = addColumnDetails("userInformationLocationTimezoneModel", "userInformationLocationTimezoneModel", objectSchemaInfo);
            this.userInformationLocationStateModelIndex = addColumnDetails("userInformationLocationStateModel", "userInformationLocationStateModel", objectSchemaInfo);
            this.userInformationLocationCountryModelIndex = addColumnDetails("userInformationLocationCountryModel", "userInformationLocationCountryModel", objectSchemaInfo);
            this.userInformationLocationOrgModelIndex = addColumnDetails("userInformationLocationOrgModel", "userInformationLocationOrgModel", objectSchemaInfo);
            this.userInformationLocationServiceArrayListIndex = addColumnDetails("userInformationLocationServiceArrayList", "userInformationLocationServiceArrayList", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInformationLocationModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInformationLocationModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInformationLocationModelColumnInfo src = (PPUserInformationLocationModelColumnInfo) rawSrc;
            final PPUserInformationLocationModelColumnInfo dst = (PPUserInformationLocationModelColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.userIdIndex = src.userIdIndex;
            dst.sNameIndex = src.sNameIndex;
            dst.locationAccessIndex = src.locationAccessIndex;
            dst.userCategoryIndex = src.userCategoryIndex;
            dst.fileUploadPolicyIndex = src.fileUploadPolicyIndex;
            dst.smsPhoneIndex = src.smsPhoneIndex;
            dst.nTypeIndex = src.nTypeIndex;
            dst.sZipIndex = src.sZipIndex;
            dst.sLatitudeIndex = src.sLatitudeIndex;
            dst.slongitudeIndex = src.slongitudeIndex;
            dst.dLatitudeIndex = src.dLatitudeIndex;
            dst.dLongitudeIndex = src.dLongitudeIndex;
            dst.salesTaxRateIndex = src.salesTaxRateIndex;
            dst.sEventIndex = src.sEventIndex;
            dst.nStoriesNumberIndex = src.nStoriesNumberIndex;
            dst.nRoomsNumberIndex = src.nRoomsNumberIndex;
            dst.nBathRoomNumberIndex = src.nBathRoomNumberIndex;
            dst.nOccupantsNumberIndex = src.nOccupantsNumberIndex;
            dst.nUsagePeriodIndex = src.nUsagePeriodIndex;
            dst.nHeatingTypeIndex = src.nHeatingTypeIndex;
            dst.nCoolingTypeIndex = src.nCoolingTypeIndex;
            dst.nWaterHeaterTypeIndex = src.nWaterHeaterTypeIndex;
            dst.nThermostatTypeIndex = src.nThermostatTypeIndex;
            dst.nCodeTypeIndex = src.nCodeTypeIndex;
            dst.sStartDateIndex = src.sStartDateIndex;
            dst.sAccessEndDateIndex = src.sAccessEndDateIndex;
            dst.lAccessEndDateMsIndex = src.lAccessEndDateMsIndex;
            dst.sAddress1Index = src.sAddress1Index;
            dst.sAddress2Index = src.sAddress2Index;
            dst.sAddCityIndex = src.sAddCityIndex;
            dst.sAddStateIndex = src.sAddStateIndex;
            dst.iTemporaryIndex = src.iTemporaryIndex;
            dst.sOrganizationIdIndex = src.sOrganizationIdIndex;
            dst.userInformationLocationTimezoneModelIndex = src.userInformationLocationTimezoneModelIndex;
            dst.userInformationLocationStateModelIndex = src.userInformationLocationStateModelIndex;
            dst.userInformationLocationCountryModelIndex = src.userInformationLocationCountryModelIndex;
            dst.userInformationLocationOrgModelIndex = src.userInformationLocationOrgModelIndex;
            dst.userInformationLocationServiceArrayListIndex = src.userInformationLocationServiceArrayListIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInformationLocationModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel> proxyState;
    private RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListRealmList;

    com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInformationLocationModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel>(this);
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
    public String realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIdIndex);
    }

    @Override
    public void realmSet$userId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userIdIndex, value);
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
    public int realmGet$locationAccess() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.locationAccessIndex);
    }

    @Override
    public void realmSet$locationAccess(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.locationAccessIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.locationAccessIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$userCategory() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.userCategoryIndex);
    }

    @Override
    public void realmSet$userCategory(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.userCategoryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.userCategoryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$fileUploadPolicy() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.fileUploadPolicyIndex);
    }

    @Override
    public void realmSet$fileUploadPolicy(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.fileUploadPolicyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.fileUploadPolicyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$smsPhone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.smsPhoneIndex);
    }

    @Override
    public void realmSet$smsPhone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.smsPhoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.smsPhoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.smsPhoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.smsPhoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nTypeIndex);
    }

    @Override
    public void realmSet$nType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sZip() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sZipIndex);
    }

    @Override
    public void realmSet$sZip(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sZipIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sZipIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sZipIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sZipIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sLatitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sLatitudeIndex);
    }

    @Override
    public void realmSet$sLatitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sLatitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sLatitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sLatitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sLatitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$slongitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.slongitudeIndex);
    }

    @Override
    public void realmSet$slongitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.slongitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.slongitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.slongitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.slongitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$dLatitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.dLatitudeIndex);
    }

    @Override
    public void realmSet$dLatitude(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.dLatitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.dLatitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$dLongitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.dLongitudeIndex);
    }

    @Override
    public void realmSet$dLongitude(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.dLongitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.dLongitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$salesTaxRate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.salesTaxRateIndex);
    }

    @Override
    public void realmSet$salesTaxRate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.salesTaxRateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.salesTaxRateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.salesTaxRateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.salesTaxRateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sEvent() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sEventIndex);
    }

    @Override
    public void realmSet$sEvent(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sEventIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sEventIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sEventIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sEventIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nStoriesNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nStoriesNumberIndex);
    }

    @Override
    public void realmSet$nStoriesNumber(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nStoriesNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nStoriesNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nRoomsNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nRoomsNumberIndex);
    }

    @Override
    public void realmSet$nRoomsNumber(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nRoomsNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nRoomsNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nBathRoomNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nBathRoomNumberIndex);
    }

    @Override
    public void realmSet$nBathRoomNumber(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nBathRoomNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nBathRoomNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nOccupantsNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nOccupantsNumberIndex);
    }

    @Override
    public void realmSet$nOccupantsNumber(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nOccupantsNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nOccupantsNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nUsagePeriod() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nUsagePeriodIndex);
    }

    @Override
    public void realmSet$nUsagePeriod(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nUsagePeriodIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nUsagePeriodIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nHeatingType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nHeatingTypeIndex);
    }

    @Override
    public void realmSet$nHeatingType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nHeatingTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nHeatingTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nCoolingType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nCoolingTypeIndex);
    }

    @Override
    public void realmSet$nCoolingType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nCoolingTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nCoolingTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nWaterHeaterType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nWaterHeaterTypeIndex);
    }

    @Override
    public void realmSet$nWaterHeaterType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nWaterHeaterTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nWaterHeaterTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nThermostatType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nThermostatTypeIndex);
    }

    @Override
    public void realmSet$nThermostatType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nThermostatTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nThermostatTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nCodeType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nCodeTypeIndex);
    }

    @Override
    public void realmSet$nCodeType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nCodeTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nCodeTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sStartDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sStartDateIndex);
    }

    @Override
    public void realmSet$sStartDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sStartDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sStartDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sStartDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sStartDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAccessEndDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAccessEndDateIndex);
    }

    @Override
    public void realmSet$sAccessEndDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAccessEndDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAccessEndDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAccessEndDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAccessEndDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$lAccessEndDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.lAccessEndDateMsIndex);
    }

    @Override
    public void realmSet$lAccessEndDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.lAccessEndDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.lAccessEndDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAddress1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAddress1Index);
    }

    @Override
    public void realmSet$sAddress1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAddress1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAddress1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAddress1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAddress1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAddress2() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAddress2Index);
    }

    @Override
    public void realmSet$sAddress2(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAddress2Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAddress2Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAddress2Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAddress2Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAddCity() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAddCityIndex);
    }

    @Override
    public void realmSet$sAddCity(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAddCityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAddCityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAddCityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAddCityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sAddState() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sAddStateIndex);
    }

    @Override
    public void realmSet$sAddState(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sAddStateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sAddStateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sAddStateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sAddStateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$iTemporary() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iTemporaryIndex);
    }

    @Override
    public void realmSet$iTemporary(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iTemporaryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iTemporaryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sOrganizationId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sOrganizationIdIndex);
    }

    @Override
    public void realmSet$sOrganizationId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sOrganizationIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sOrganizationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sOrganizationIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sOrganizationIdIndex, value);
    }

    @Override
    public com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel realmGet$userInformationLocationTimezoneModel() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userInformationLocationTimezoneModelIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class, proxyState.getRow$realm().getLink(columnInfo.userInformationLocationTimezoneModelIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$userInformationLocationTimezoneModel(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userInformationLocationTimezoneModel")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userInformationLocationTimezoneModelIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userInformationLocationTimezoneModelIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userInformationLocationTimezoneModelIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userInformationLocationTimezoneModelIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel realmGet$userInformationLocationStateModel() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userInformationLocationStateModelIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class, proxyState.getRow$realm().getLink(columnInfo.userInformationLocationStateModelIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$userInformationLocationStateModel(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userInformationLocationStateModel")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userInformationLocationStateModelIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userInformationLocationStateModelIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userInformationLocationStateModelIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userInformationLocationStateModelIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel realmGet$userInformationLocationCountryModel() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userInformationLocationCountryModelIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class, proxyState.getRow$realm().getLink(columnInfo.userInformationLocationCountryModelIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$userInformationLocationCountryModel(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userInformationLocationCountryModel")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userInformationLocationCountryModelIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userInformationLocationCountryModelIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userInformationLocationCountryModelIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userInformationLocationCountryModelIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel realmGet$userInformationLocationOrgModel() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userInformationLocationOrgModelIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class, proxyState.getRow$realm().getLink(columnInfo.userInformationLocationOrgModelIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$userInformationLocationOrgModel(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userInformationLocationOrgModel")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userInformationLocationOrgModelIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userInformationLocationOrgModelIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userInformationLocationOrgModelIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userInformationLocationOrgModelIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> realmGet$userInformationLocationServiceArrayList() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (userInformationLocationServiceArrayListRealmList != null) {
            return userInformationLocationServiceArrayListRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.userInformationLocationServiceArrayListIndex);
            userInformationLocationServiceArrayListRealmList = new RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class, osList, proxyState.getRealm$realm());
            return userInformationLocationServiceArrayListRealmList;
        }
    }

    @Override
    public void realmSet$userInformationLocationServiceArrayList(RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userInformationLocationServiceArrayList")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> original = value;
                value = new RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>();
                for (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.userInformationLocationServiceArrayListIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel linkedObject = value.get(i);
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
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInformationLocationModel", 39, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("userId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("locationAccess", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("userCategory", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fileUploadPolicy", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("smsPhone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sZip", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sLatitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("slongitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("dLatitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("dLongitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("salesTaxRate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sEvent", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nStoriesNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nRoomsNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nBathRoomNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nOccupantsNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nUsagePeriod", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nHeatingType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nCoolingType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nWaterHeaterType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nThermostatType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nCodeType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sStartDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sAccessEndDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lAccessEndDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sAddress1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sAddress2", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sAddCity", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sAddState", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("iTemporary", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sOrganizationId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("userInformationLocationTimezoneModel", RealmFieldType.OBJECT, "PPUserInformationLocationTimezoneModel");
        builder.addPersistedLinkProperty("userInformationLocationStateModel", RealmFieldType.OBJECT, "PPUserInformationLocationStateModel");
        builder.addPersistedLinkProperty("userInformationLocationCountryModel", RealmFieldType.OBJECT, "PPUserInformationLocationCountryModel");
        builder.addPersistedLinkProperty("userInformationLocationOrgModel", RealmFieldType.OBJECT, "PPUserInformationLocationOrgModel");
        builder.addPersistedLinkProperty("userInformationLocationServiceArrayList", RealmFieldType.LIST, "PPUserInformationServiceModel");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInformationLocationModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInformationLocationModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInformationLocationModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInformationLocationModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(5);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
            PPUserInformationLocationModelColumnInfo columnInfo = (PPUserInformationLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userInformationLocationTimezoneModel")) {
                excludeFields.add("userInformationLocationTimezoneModel");
            }
            if (json.has("userInformationLocationStateModel")) {
                excludeFields.add("userInformationLocationStateModel");
            }
            if (json.has("userInformationLocationCountryModel")) {
                excludeFields.add("userInformationLocationCountryModel");
            }
            if (json.has("userInformationLocationOrgModel")) {
                excludeFields.add("userInformationLocationOrgModel");
            }
            if (json.has("userInformationLocationServiceArrayList")) {
                excludeFields.add("userInformationLocationServiceArrayList");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) obj;
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                objProxy.realmSet$userId(null);
            } else {
                objProxy.realmSet$userId((String) json.getString("userId"));
            }
        }
        if (json.has("sName")) {
            if (json.isNull("sName")) {
                objProxy.realmSet$sName(null);
            } else {
                objProxy.realmSet$sName((String) json.getString("sName"));
            }
        }
        if (json.has("locationAccess")) {
            if (json.isNull("locationAccess")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'locationAccess' to null.");
            } else {
                objProxy.realmSet$locationAccess((int) json.getInt("locationAccess"));
            }
        }
        if (json.has("userCategory")) {
            if (json.isNull("userCategory")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'userCategory' to null.");
            } else {
                objProxy.realmSet$userCategory((int) json.getInt("userCategory"));
            }
        }
        if (json.has("fileUploadPolicy")) {
            if (json.isNull("fileUploadPolicy")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fileUploadPolicy' to null.");
            } else {
                objProxy.realmSet$fileUploadPolicy((int) json.getInt("fileUploadPolicy"));
            }
        }
        if (json.has("smsPhone")) {
            if (json.isNull("smsPhone")) {
                objProxy.realmSet$smsPhone(null);
            } else {
                objProxy.realmSet$smsPhone((String) json.getString("smsPhone"));
            }
        }
        if (json.has("nType")) {
            if (json.isNull("nType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nType' to null.");
            } else {
                objProxy.realmSet$nType((int) json.getInt("nType"));
            }
        }
        if (json.has("sZip")) {
            if (json.isNull("sZip")) {
                objProxy.realmSet$sZip(null);
            } else {
                objProxy.realmSet$sZip((String) json.getString("sZip"));
            }
        }
        if (json.has("sLatitude")) {
            if (json.isNull("sLatitude")) {
                objProxy.realmSet$sLatitude(null);
            } else {
                objProxy.realmSet$sLatitude((String) json.getString("sLatitude"));
            }
        }
        if (json.has("slongitude")) {
            if (json.isNull("slongitude")) {
                objProxy.realmSet$slongitude(null);
            } else {
                objProxy.realmSet$slongitude((String) json.getString("slongitude"));
            }
        }
        if (json.has("dLatitude")) {
            if (json.isNull("dLatitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'dLatitude' to null.");
            } else {
                objProxy.realmSet$dLatitude((double) json.getDouble("dLatitude"));
            }
        }
        if (json.has("dLongitude")) {
            if (json.isNull("dLongitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'dLongitude' to null.");
            } else {
                objProxy.realmSet$dLongitude((double) json.getDouble("dLongitude"));
            }
        }
        if (json.has("salesTaxRate")) {
            if (json.isNull("salesTaxRate")) {
                objProxy.realmSet$salesTaxRate(null);
            } else {
                objProxy.realmSet$salesTaxRate((String) json.getString("salesTaxRate"));
            }
        }
        if (json.has("sEvent")) {
            if (json.isNull("sEvent")) {
                objProxy.realmSet$sEvent(null);
            } else {
                objProxy.realmSet$sEvent((String) json.getString("sEvent"));
            }
        }
        if (json.has("nStoriesNumber")) {
            if (json.isNull("nStoriesNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nStoriesNumber' to null.");
            } else {
                objProxy.realmSet$nStoriesNumber((int) json.getInt("nStoriesNumber"));
            }
        }
        if (json.has("nRoomsNumber")) {
            if (json.isNull("nRoomsNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nRoomsNumber' to null.");
            } else {
                objProxy.realmSet$nRoomsNumber((int) json.getInt("nRoomsNumber"));
            }
        }
        if (json.has("nBathRoomNumber")) {
            if (json.isNull("nBathRoomNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nBathRoomNumber' to null.");
            } else {
                objProxy.realmSet$nBathRoomNumber((int) json.getInt("nBathRoomNumber"));
            }
        }
        if (json.has("nOccupantsNumber")) {
            if (json.isNull("nOccupantsNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nOccupantsNumber' to null.");
            } else {
                objProxy.realmSet$nOccupantsNumber((int) json.getInt("nOccupantsNumber"));
            }
        }
        if (json.has("nUsagePeriod")) {
            if (json.isNull("nUsagePeriod")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nUsagePeriod' to null.");
            } else {
                objProxy.realmSet$nUsagePeriod((int) json.getInt("nUsagePeriod"));
            }
        }
        if (json.has("nHeatingType")) {
            if (json.isNull("nHeatingType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nHeatingType' to null.");
            } else {
                objProxy.realmSet$nHeatingType((int) json.getInt("nHeatingType"));
            }
        }
        if (json.has("nCoolingType")) {
            if (json.isNull("nCoolingType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nCoolingType' to null.");
            } else {
                objProxy.realmSet$nCoolingType((int) json.getInt("nCoolingType"));
            }
        }
        if (json.has("nWaterHeaterType")) {
            if (json.isNull("nWaterHeaterType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nWaterHeaterType' to null.");
            } else {
                objProxy.realmSet$nWaterHeaterType((int) json.getInt("nWaterHeaterType"));
            }
        }
        if (json.has("nThermostatType")) {
            if (json.isNull("nThermostatType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nThermostatType' to null.");
            } else {
                objProxy.realmSet$nThermostatType((int) json.getInt("nThermostatType"));
            }
        }
        if (json.has("nCodeType")) {
            if (json.isNull("nCodeType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nCodeType' to null.");
            } else {
                objProxy.realmSet$nCodeType((int) json.getInt("nCodeType"));
            }
        }
        if (json.has("sStartDate")) {
            if (json.isNull("sStartDate")) {
                objProxy.realmSet$sStartDate(null);
            } else {
                objProxy.realmSet$sStartDate((String) json.getString("sStartDate"));
            }
        }
        if (json.has("sAccessEndDate")) {
            if (json.isNull("sAccessEndDate")) {
                objProxy.realmSet$sAccessEndDate(null);
            } else {
                objProxy.realmSet$sAccessEndDate((String) json.getString("sAccessEndDate"));
            }
        }
        if (json.has("lAccessEndDateMs")) {
            if (json.isNull("lAccessEndDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lAccessEndDateMs' to null.");
            } else {
                objProxy.realmSet$lAccessEndDateMs((long) json.getLong("lAccessEndDateMs"));
            }
        }
        if (json.has("sAddress1")) {
            if (json.isNull("sAddress1")) {
                objProxy.realmSet$sAddress1(null);
            } else {
                objProxy.realmSet$sAddress1((String) json.getString("sAddress1"));
            }
        }
        if (json.has("sAddress2")) {
            if (json.isNull("sAddress2")) {
                objProxy.realmSet$sAddress2(null);
            } else {
                objProxy.realmSet$sAddress2((String) json.getString("sAddress2"));
            }
        }
        if (json.has("sAddCity")) {
            if (json.isNull("sAddCity")) {
                objProxy.realmSet$sAddCity(null);
            } else {
                objProxy.realmSet$sAddCity((String) json.getString("sAddCity"));
            }
        }
        if (json.has("sAddState")) {
            if (json.isNull("sAddState")) {
                objProxy.realmSet$sAddState(null);
            } else {
                objProxy.realmSet$sAddState((String) json.getString("sAddState"));
            }
        }
        if (json.has("iTemporary")) {
            if (json.isNull("iTemporary")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iTemporary' to null.");
            } else {
                objProxy.realmSet$iTemporary((int) json.getInt("iTemporary"));
            }
        }
        if (json.has("sOrganizationId")) {
            if (json.isNull("sOrganizationId")) {
                objProxy.realmSet$sOrganizationId(null);
            } else {
                objProxy.realmSet$sOrganizationId((String) json.getString("sOrganizationId"));
            }
        }
        if (json.has("userInformationLocationTimezoneModel")) {
            if (json.isNull("userInformationLocationTimezoneModel")) {
                objProxy.realmSet$userInformationLocationTimezoneModel(null);
            } else {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("userInformationLocationTimezoneModel"), update);
                objProxy.realmSet$userInformationLocationTimezoneModel(userInformationLocationTimezoneModelObj);
            }
        }
        if (json.has("userInformationLocationStateModel")) {
            if (json.isNull("userInformationLocationStateModel")) {
                objProxy.realmSet$userInformationLocationStateModel(null);
            } else {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("userInformationLocationStateModel"), update);
                objProxy.realmSet$userInformationLocationStateModel(userInformationLocationStateModelObj);
            }
        }
        if (json.has("userInformationLocationCountryModel")) {
            if (json.isNull("userInformationLocationCountryModel")) {
                objProxy.realmSet$userInformationLocationCountryModel(null);
            } else {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("userInformationLocationCountryModel"), update);
                objProxy.realmSet$userInformationLocationCountryModel(userInformationLocationCountryModelObj);
            }
        }
        if (json.has("userInformationLocationOrgModel")) {
            if (json.isNull("userInformationLocationOrgModel")) {
                objProxy.realmSet$userInformationLocationOrgModel(null);
            } else {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("userInformationLocationOrgModel"), update);
                objProxy.realmSet$userInformationLocationOrgModel(userInformationLocationOrgModelObj);
            }
        }
        if (json.has("userInformationLocationServiceArrayList")) {
            if (json.isNull("userInformationLocationServiceArrayList")) {
                objProxy.realmSet$userInformationLocationServiceArrayList(null);
            } else {
                objProxy.realmGet$userInformationLocationServiceArrayList().clear();
                JSONArray array = json.getJSONArray("userInformationLocationServiceArrayList");
                for (int i = 0; i < array.length(); i++) {
                    com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel item = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$userInformationLocationServiceArrayList().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel obj = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel();
        final com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) obj;
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
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
            } else if (name.equals("sName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sName(null);
                }
            } else if (name.equals("locationAccess")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationAccess((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'locationAccess' to null.");
                }
            } else if (name.equals("userCategory")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userCategory((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'userCategory' to null.");
                }
            } else if (name.equals("fileUploadPolicy")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fileUploadPolicy((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'fileUploadPolicy' to null.");
                }
            } else if (name.equals("smsPhone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$smsPhone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$smsPhone(null);
                }
            } else if (name.equals("nType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nType' to null.");
                }
            } else if (name.equals("sZip")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sZip((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sZip(null);
                }
            } else if (name.equals("sLatitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sLatitude((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sLatitude(null);
                }
            } else if (name.equals("slongitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$slongitude((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$slongitude(null);
                }
            } else if (name.equals("dLatitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dLatitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dLatitude' to null.");
                }
            } else if (name.equals("dLongitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dLongitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dLongitude' to null.");
                }
            } else if (name.equals("salesTaxRate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$salesTaxRate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$salesTaxRate(null);
                }
            } else if (name.equals("sEvent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sEvent((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sEvent(null);
                }
            } else if (name.equals("nStoriesNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nStoriesNumber((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nStoriesNumber' to null.");
                }
            } else if (name.equals("nRoomsNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nRoomsNumber((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nRoomsNumber' to null.");
                }
            } else if (name.equals("nBathRoomNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nBathRoomNumber((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nBathRoomNumber' to null.");
                }
            } else if (name.equals("nOccupantsNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nOccupantsNumber((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nOccupantsNumber' to null.");
                }
            } else if (name.equals("nUsagePeriod")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nUsagePeriod((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nUsagePeriod' to null.");
                }
            } else if (name.equals("nHeatingType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nHeatingType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nHeatingType' to null.");
                }
            } else if (name.equals("nCoolingType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nCoolingType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nCoolingType' to null.");
                }
            } else if (name.equals("nWaterHeaterType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nWaterHeaterType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nWaterHeaterType' to null.");
                }
            } else if (name.equals("nThermostatType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nThermostatType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nThermostatType' to null.");
                }
            } else if (name.equals("nCodeType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nCodeType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nCodeType' to null.");
                }
            } else if (name.equals("sStartDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sStartDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sStartDate(null);
                }
            } else if (name.equals("sAccessEndDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAccessEndDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAccessEndDate(null);
                }
            } else if (name.equals("lAccessEndDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lAccessEndDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lAccessEndDateMs' to null.");
                }
            } else if (name.equals("sAddress1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAddress1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAddress1(null);
                }
            } else if (name.equals("sAddress2")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAddress2((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAddress2(null);
                }
            } else if (name.equals("sAddCity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAddCity((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAddCity(null);
                }
            } else if (name.equals("sAddState")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sAddState((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sAddState(null);
                }
            } else if (name.equals("iTemporary")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$iTemporary((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iTemporary' to null.");
                }
            } else if (name.equals("sOrganizationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sOrganizationId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sOrganizationId(null);
                }
            } else if (name.equals("userInformationLocationTimezoneModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userInformationLocationTimezoneModel(null);
                } else {
                    com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$userInformationLocationTimezoneModel(userInformationLocationTimezoneModelObj);
                }
            } else if (name.equals("userInformationLocationStateModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userInformationLocationStateModel(null);
                } else {
                    com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$userInformationLocationStateModel(userInformationLocationStateModelObj);
                }
            } else if (name.equals("userInformationLocationCountryModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userInformationLocationCountryModel(null);
                } else {
                    com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$userInformationLocationCountryModel(userInformationLocationCountryModelObj);
                }
            } else if (name.equals("userInformationLocationOrgModel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userInformationLocationOrgModel(null);
                } else {
                    com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$userInformationLocationOrgModel(userInformationLocationOrgModelObj);
                }
            } else if (name.equals("userInformationLocationServiceArrayList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userInformationLocationServiceArrayList(null);
                } else {
                    objProxy.realmSet$userInformationLocationServiceArrayList(new RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel item = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$userInformationLocationServiceArrayList().add(item);
                    }
                    reader.endArray();
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

    private static com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel copyOrUpdate(Realm realm, PPUserInformationLocationModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel copy(Realm realm, PPUserInformationLocationModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.userIdIndex, realmObjectSource.realmGet$userId());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addInteger(columnInfo.locationAccessIndex, realmObjectSource.realmGet$locationAccess());
        builder.addInteger(columnInfo.userCategoryIndex, realmObjectSource.realmGet$userCategory());
        builder.addInteger(columnInfo.fileUploadPolicyIndex, realmObjectSource.realmGet$fileUploadPolicy());
        builder.addString(columnInfo.smsPhoneIndex, realmObjectSource.realmGet$smsPhone());
        builder.addInteger(columnInfo.nTypeIndex, realmObjectSource.realmGet$nType());
        builder.addString(columnInfo.sZipIndex, realmObjectSource.realmGet$sZip());
        builder.addString(columnInfo.sLatitudeIndex, realmObjectSource.realmGet$sLatitude());
        builder.addString(columnInfo.slongitudeIndex, realmObjectSource.realmGet$slongitude());
        builder.addDouble(columnInfo.dLatitudeIndex, realmObjectSource.realmGet$dLatitude());
        builder.addDouble(columnInfo.dLongitudeIndex, realmObjectSource.realmGet$dLongitude());
        builder.addString(columnInfo.salesTaxRateIndex, realmObjectSource.realmGet$salesTaxRate());
        builder.addString(columnInfo.sEventIndex, realmObjectSource.realmGet$sEvent());
        builder.addInteger(columnInfo.nStoriesNumberIndex, realmObjectSource.realmGet$nStoriesNumber());
        builder.addInteger(columnInfo.nRoomsNumberIndex, realmObjectSource.realmGet$nRoomsNumber());
        builder.addInteger(columnInfo.nBathRoomNumberIndex, realmObjectSource.realmGet$nBathRoomNumber());
        builder.addInteger(columnInfo.nOccupantsNumberIndex, realmObjectSource.realmGet$nOccupantsNumber());
        builder.addInteger(columnInfo.nUsagePeriodIndex, realmObjectSource.realmGet$nUsagePeriod());
        builder.addInteger(columnInfo.nHeatingTypeIndex, realmObjectSource.realmGet$nHeatingType());
        builder.addInteger(columnInfo.nCoolingTypeIndex, realmObjectSource.realmGet$nCoolingType());
        builder.addInteger(columnInfo.nWaterHeaterTypeIndex, realmObjectSource.realmGet$nWaterHeaterType());
        builder.addInteger(columnInfo.nThermostatTypeIndex, realmObjectSource.realmGet$nThermostatType());
        builder.addInteger(columnInfo.nCodeTypeIndex, realmObjectSource.realmGet$nCodeType());
        builder.addString(columnInfo.sStartDateIndex, realmObjectSource.realmGet$sStartDate());
        builder.addString(columnInfo.sAccessEndDateIndex, realmObjectSource.realmGet$sAccessEndDate());
        builder.addInteger(columnInfo.lAccessEndDateMsIndex, realmObjectSource.realmGet$lAccessEndDateMs());
        builder.addString(columnInfo.sAddress1Index, realmObjectSource.realmGet$sAddress1());
        builder.addString(columnInfo.sAddress2Index, realmObjectSource.realmGet$sAddress2());
        builder.addString(columnInfo.sAddCityIndex, realmObjectSource.realmGet$sAddCity());
        builder.addString(columnInfo.sAddStateIndex, realmObjectSource.realmGet$sAddState());
        builder.addInteger(columnInfo.iTemporaryIndex, realmObjectSource.realmGet$iTemporary());
        builder.addString(columnInfo.sOrganizationIdIndex, realmObjectSource.realmGet$sOrganizationId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = realmObjectSource.realmGet$userInformationLocationTimezoneModel();
        if (userInformationLocationTimezoneModelObj == null) {
            realmObjectCopy.realmSet$userInformationLocationTimezoneModel(null);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel cacheuserInformationLocationTimezoneModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) cache.get(userInformationLocationTimezoneModelObj);
            if (cacheuserInformationLocationTimezoneModel != null) {
                realmObjectCopy.realmSet$userInformationLocationTimezoneModel(cacheuserInformationLocationTimezoneModel);
            } else {
                realmObjectCopy.realmSet$userInformationLocationTimezoneModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class), userInformationLocationTimezoneModelObj, update, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = realmObjectSource.realmGet$userInformationLocationStateModel();
        if (userInformationLocationStateModelObj == null) {
            realmObjectCopy.realmSet$userInformationLocationStateModel(null);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel cacheuserInformationLocationStateModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) cache.get(userInformationLocationStateModelObj);
            if (cacheuserInformationLocationStateModel != null) {
                realmObjectCopy.realmSet$userInformationLocationStateModel(cacheuserInformationLocationStateModel);
            } else {
                realmObjectCopy.realmSet$userInformationLocationStateModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.PPUserInformationLocationStateModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class), userInformationLocationStateModelObj, update, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = realmObjectSource.realmGet$userInformationLocationCountryModel();
        if (userInformationLocationCountryModelObj == null) {
            realmObjectCopy.realmSet$userInformationLocationCountryModel(null);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel cacheuserInformationLocationCountryModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) cache.get(userInformationLocationCountryModelObj);
            if (cacheuserInformationLocationCountryModel != null) {
                realmObjectCopy.realmSet$userInformationLocationCountryModel(cacheuserInformationLocationCountryModel);
            } else {
                realmObjectCopy.realmSet$userInformationLocationCountryModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class), userInformationLocationCountryModelObj, update, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = realmObjectSource.realmGet$userInformationLocationOrgModel();
        if (userInformationLocationOrgModelObj == null) {
            realmObjectCopy.realmSet$userInformationLocationOrgModel(null);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel cacheuserInformationLocationOrgModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) cache.get(userInformationLocationOrgModelObj);
            if (cacheuserInformationLocationOrgModel != null) {
                realmObjectCopy.realmSet$userInformationLocationOrgModel(cacheuserInformationLocationOrgModel);
            } else {
                realmObjectCopy.realmSet$userInformationLocationOrgModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class), userInformationLocationOrgModelObj, update, cache, flags));
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListList = realmObjectSource.realmGet$userInformationLocationServiceArrayList();
        if (userInformationLocationServiceArrayListList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListRealmList = realmObjectCopy.realmGet$userInformationLocationServiceArrayList();
            userInformationLocationServiceArrayListRealmList.clear();
            for (int i = 0; i < userInformationLocationServiceArrayListList.size(); i++) {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem = userInformationLocationServiceArrayListList.get(i);
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel cacheuserInformationLocationServiceArrayList = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) cache.get(userInformationLocationServiceArrayListItem);
                if (cacheuserInformationLocationServiceArrayList != null) {
                    userInformationLocationServiceArrayListRealmList.add(cacheuserInformationLocationServiceArrayList);
                } else {
                    userInformationLocationServiceArrayListRealmList.add(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class), userInformationLocationServiceArrayListItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationModelColumnInfo columnInfo = (PPUserInformationLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$userId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
        }
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.locationAccessIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$locationAccess(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.userCategoryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userCategory(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.fileUploadPolicyIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$fileUploadPolicy(), false);
        String realmGet$smsPhone = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$smsPhone();
        if (realmGet$smsPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.smsPhoneIndex, rowIndex, realmGet$smsPhone, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nType(), false);
        String realmGet$sZip = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sZip();
        if (realmGet$sZip != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sZipIndex, rowIndex, realmGet$sZip, false);
        }
        String realmGet$sLatitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sLatitude();
        if (realmGet$sLatitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sLatitudeIndex, rowIndex, realmGet$sLatitude, false);
        }
        String realmGet$slongitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$slongitude();
        if (realmGet$slongitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.slongitudeIndex, rowIndex, realmGet$slongitude, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLatitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLongitude(), false);
        String realmGet$salesTaxRate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$salesTaxRate();
        if (realmGet$salesTaxRate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.salesTaxRateIndex, rowIndex, realmGet$salesTaxRate, false);
        }
        String realmGet$sEvent = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sEvent();
        if (realmGet$sEvent != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sEventIndex, rowIndex, realmGet$sEvent, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nStoriesNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nStoriesNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nRoomsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nRoomsNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nBathRoomNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nBathRoomNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nOccupantsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nOccupantsNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nUsagePeriodIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nUsagePeriod(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nHeatingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nHeatingType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nCoolingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCoolingType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nWaterHeaterTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nWaterHeaterType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nThermostatTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nThermostatType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nCodeTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCodeType(), false);
        String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sStartDate();
        if (realmGet$sStartDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
        }
        String realmGet$sAccessEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAccessEndDate();
        if (realmGet$sAccessEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAccessEndDateIndex, rowIndex, realmGet$sAccessEndDate, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.lAccessEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$lAccessEndDateMs(), false);
        String realmGet$sAddress1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress1();
        if (realmGet$sAddress1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddress1Index, rowIndex, realmGet$sAddress1, false);
        }
        String realmGet$sAddress2 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress2();
        if (realmGet$sAddress2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddress2Index, rowIndex, realmGet$sAddress2, false);
        }
        String realmGet$sAddCity = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddCity();
        if (realmGet$sAddCity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddCityIndex, rowIndex, realmGet$sAddCity, false);
        }
        String realmGet$sAddState = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddState();
        if (realmGet$sAddState != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddStateIndex, rowIndex, realmGet$sAddState, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iTemporaryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$iTemporary(), false);
        String realmGet$sOrganizationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sOrganizationId();
        if (realmGet$sOrganizationId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sOrganizationIdIndex, rowIndex, realmGet$sOrganizationId, false);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationTimezoneModel();
        if (userInformationLocationTimezoneModelObj != null) {
            Long cacheuserInformationLocationTimezoneModel = cache.get(userInformationLocationTimezoneModelObj);
            if (cacheuserInformationLocationTimezoneModel == null) {
                cacheuserInformationLocationTimezoneModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insert(realm, userInformationLocationTimezoneModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationTimezoneModelIndex, rowIndex, cacheuserInformationLocationTimezoneModel, false);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationStateModel();
        if (userInformationLocationStateModelObj != null) {
            Long cacheuserInformationLocationStateModel = cache.get(userInformationLocationStateModelObj);
            if (cacheuserInformationLocationStateModel == null) {
                cacheuserInformationLocationStateModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insert(realm, userInformationLocationStateModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationStateModelIndex, rowIndex, cacheuserInformationLocationStateModel, false);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationCountryModel();
        if (userInformationLocationCountryModelObj != null) {
            Long cacheuserInformationLocationCountryModel = cache.get(userInformationLocationCountryModelObj);
            if (cacheuserInformationLocationCountryModel == null) {
                cacheuserInformationLocationCountryModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insert(realm, userInformationLocationCountryModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationCountryModelIndex, rowIndex, cacheuserInformationLocationCountryModel, false);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationOrgModel();
        if (userInformationLocationOrgModelObj != null) {
            Long cacheuserInformationLocationOrgModel = cache.get(userInformationLocationOrgModelObj);
            if (cacheuserInformationLocationOrgModel == null) {
                cacheuserInformationLocationOrgModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insert(realm, userInformationLocationOrgModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationOrgModelIndex, rowIndex, cacheuserInformationLocationOrgModel, false);
        }

        RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListList = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationServiceArrayList();
        if (userInformationLocationServiceArrayListList != null) {
            OsList userInformationLocationServiceArrayListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.userInformationLocationServiceArrayListIndex);
            for (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem : userInformationLocationServiceArrayListList) {
                Long cacheItemIndexuserInformationLocationServiceArrayList = cache.get(userInformationLocationServiceArrayListItem);
                if (cacheItemIndexuserInformationLocationServiceArrayList == null) {
                    cacheItemIndexuserInformationLocationServiceArrayList = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insert(realm, userInformationLocationServiceArrayListItem, cache);
                }
                userInformationLocationServiceArrayListOsList.addRow(cacheItemIndexuserInformationLocationServiceArrayList);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationModelColumnInfo columnInfo = (PPUserInformationLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$userId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
            }
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.locationAccessIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$locationAccess(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.userCategoryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userCategory(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.fileUploadPolicyIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$fileUploadPolicy(), false);
            String realmGet$smsPhone = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$smsPhone();
            if (realmGet$smsPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.smsPhoneIndex, rowIndex, realmGet$smsPhone, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nType(), false);
            String realmGet$sZip = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sZip();
            if (realmGet$sZip != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sZipIndex, rowIndex, realmGet$sZip, false);
            }
            String realmGet$sLatitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sLatitude();
            if (realmGet$sLatitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sLatitudeIndex, rowIndex, realmGet$sLatitude, false);
            }
            String realmGet$slongitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$slongitude();
            if (realmGet$slongitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.slongitudeIndex, rowIndex, realmGet$slongitude, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLatitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLongitude(), false);
            String realmGet$salesTaxRate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$salesTaxRate();
            if (realmGet$salesTaxRate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.salesTaxRateIndex, rowIndex, realmGet$salesTaxRate, false);
            }
            String realmGet$sEvent = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sEvent();
            if (realmGet$sEvent != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sEventIndex, rowIndex, realmGet$sEvent, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nStoriesNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nStoriesNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nRoomsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nRoomsNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nBathRoomNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nBathRoomNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nOccupantsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nOccupantsNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nUsagePeriodIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nUsagePeriod(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nHeatingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nHeatingType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nCoolingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCoolingType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nWaterHeaterTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nWaterHeaterType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nThermostatTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nThermostatType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nCodeTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCodeType(), false);
            String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sStartDate();
            if (realmGet$sStartDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
            }
            String realmGet$sAccessEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAccessEndDate();
            if (realmGet$sAccessEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAccessEndDateIndex, rowIndex, realmGet$sAccessEndDate, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.lAccessEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$lAccessEndDateMs(), false);
            String realmGet$sAddress1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress1();
            if (realmGet$sAddress1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddress1Index, rowIndex, realmGet$sAddress1, false);
            }
            String realmGet$sAddress2 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress2();
            if (realmGet$sAddress2 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddress2Index, rowIndex, realmGet$sAddress2, false);
            }
            String realmGet$sAddCity = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddCity();
            if (realmGet$sAddCity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddCityIndex, rowIndex, realmGet$sAddCity, false);
            }
            String realmGet$sAddState = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddState();
            if (realmGet$sAddState != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddStateIndex, rowIndex, realmGet$sAddState, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iTemporaryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$iTemporary(), false);
            String realmGet$sOrganizationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sOrganizationId();
            if (realmGet$sOrganizationId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sOrganizationIdIndex, rowIndex, realmGet$sOrganizationId, false);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationTimezoneModel();
            if (userInformationLocationTimezoneModelObj != null) {
                Long cacheuserInformationLocationTimezoneModel = cache.get(userInformationLocationTimezoneModelObj);
                if (cacheuserInformationLocationTimezoneModel == null) {
                    cacheuserInformationLocationTimezoneModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insert(realm, userInformationLocationTimezoneModelObj, cache);
                }
                table.setLink(columnInfo.userInformationLocationTimezoneModelIndex, rowIndex, cacheuserInformationLocationTimezoneModel, false);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationStateModel();
            if (userInformationLocationStateModelObj != null) {
                Long cacheuserInformationLocationStateModel = cache.get(userInformationLocationStateModelObj);
                if (cacheuserInformationLocationStateModel == null) {
                    cacheuserInformationLocationStateModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insert(realm, userInformationLocationStateModelObj, cache);
                }
                table.setLink(columnInfo.userInformationLocationStateModelIndex, rowIndex, cacheuserInformationLocationStateModel, false);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationCountryModel();
            if (userInformationLocationCountryModelObj != null) {
                Long cacheuserInformationLocationCountryModel = cache.get(userInformationLocationCountryModelObj);
                if (cacheuserInformationLocationCountryModel == null) {
                    cacheuserInformationLocationCountryModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insert(realm, userInformationLocationCountryModelObj, cache);
                }
                table.setLink(columnInfo.userInformationLocationCountryModelIndex, rowIndex, cacheuserInformationLocationCountryModel, false);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationOrgModel();
            if (userInformationLocationOrgModelObj != null) {
                Long cacheuserInformationLocationOrgModel = cache.get(userInformationLocationOrgModelObj);
                if (cacheuserInformationLocationOrgModel == null) {
                    cacheuserInformationLocationOrgModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insert(realm, userInformationLocationOrgModelObj, cache);
                }
                table.setLink(columnInfo.userInformationLocationOrgModelIndex, rowIndex, cacheuserInformationLocationOrgModel, false);
            }

            RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListList = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationServiceArrayList();
            if (userInformationLocationServiceArrayListList != null) {
                OsList userInformationLocationServiceArrayListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.userInformationLocationServiceArrayListIndex);
                for (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem : userInformationLocationServiceArrayListList) {
                    Long cacheItemIndexuserInformationLocationServiceArrayList = cache.get(userInformationLocationServiceArrayListItem);
                    if (cacheItemIndexuserInformationLocationServiceArrayList == null) {
                        cacheItemIndexuserInformationLocationServiceArrayList = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insert(realm, userInformationLocationServiceArrayListItem, cache);
                    }
                    userInformationLocationServiceArrayListOsList.addRow(cacheItemIndexuserInformationLocationServiceArrayList);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationModelColumnInfo columnInfo = (PPUserInformationLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$userId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
        }
        String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sName();
        if (realmGet$sName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.locationAccessIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$locationAccess(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.userCategoryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userCategory(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.fileUploadPolicyIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$fileUploadPolicy(), false);
        String realmGet$smsPhone = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$smsPhone();
        if (realmGet$smsPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.smsPhoneIndex, rowIndex, realmGet$smsPhone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.smsPhoneIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nType(), false);
        String realmGet$sZip = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sZip();
        if (realmGet$sZip != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sZipIndex, rowIndex, realmGet$sZip, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sZipIndex, rowIndex, false);
        }
        String realmGet$sLatitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sLatitude();
        if (realmGet$sLatitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sLatitudeIndex, rowIndex, realmGet$sLatitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sLatitudeIndex, rowIndex, false);
        }
        String realmGet$slongitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$slongitude();
        if (realmGet$slongitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.slongitudeIndex, rowIndex, realmGet$slongitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.slongitudeIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLatitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLongitude(), false);
        String realmGet$salesTaxRate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$salesTaxRate();
        if (realmGet$salesTaxRate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.salesTaxRateIndex, rowIndex, realmGet$salesTaxRate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.salesTaxRateIndex, rowIndex, false);
        }
        String realmGet$sEvent = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sEvent();
        if (realmGet$sEvent != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sEventIndex, rowIndex, realmGet$sEvent, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sEventIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.nStoriesNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nStoriesNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nRoomsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nRoomsNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nBathRoomNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nBathRoomNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nOccupantsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nOccupantsNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nUsagePeriodIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nUsagePeriod(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nHeatingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nHeatingType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nCoolingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCoolingType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nWaterHeaterTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nWaterHeaterType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nThermostatTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nThermostatType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nCodeTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCodeType(), false);
        String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sStartDate();
        if (realmGet$sStartDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, false);
        }
        String realmGet$sAccessEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAccessEndDate();
        if (realmGet$sAccessEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAccessEndDateIndex, rowIndex, realmGet$sAccessEndDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAccessEndDateIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.lAccessEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$lAccessEndDateMs(), false);
        String realmGet$sAddress1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress1();
        if (realmGet$sAddress1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddress1Index, rowIndex, realmGet$sAddress1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAddress1Index, rowIndex, false);
        }
        String realmGet$sAddress2 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress2();
        if (realmGet$sAddress2 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddress2Index, rowIndex, realmGet$sAddress2, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAddress2Index, rowIndex, false);
        }
        String realmGet$sAddCity = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddCity();
        if (realmGet$sAddCity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddCityIndex, rowIndex, realmGet$sAddCity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAddCityIndex, rowIndex, false);
        }
        String realmGet$sAddState = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddState();
        if (realmGet$sAddState != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sAddStateIndex, rowIndex, realmGet$sAddState, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sAddStateIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iTemporaryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$iTemporary(), false);
        String realmGet$sOrganizationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sOrganizationId();
        if (realmGet$sOrganizationId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sOrganizationIdIndex, rowIndex, realmGet$sOrganizationId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sOrganizationIdIndex, rowIndex, false);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationTimezoneModel();
        if (userInformationLocationTimezoneModelObj != null) {
            Long cacheuserInformationLocationTimezoneModel = cache.get(userInformationLocationTimezoneModelObj);
            if (cacheuserInformationLocationTimezoneModel == null) {
                cacheuserInformationLocationTimezoneModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insertOrUpdate(realm, userInformationLocationTimezoneModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationTimezoneModelIndex, rowIndex, cacheuserInformationLocationTimezoneModel, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationTimezoneModelIndex, rowIndex);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationStateModel();
        if (userInformationLocationStateModelObj != null) {
            Long cacheuserInformationLocationStateModel = cache.get(userInformationLocationStateModelObj);
            if (cacheuserInformationLocationStateModel == null) {
                cacheuserInformationLocationStateModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insertOrUpdate(realm, userInformationLocationStateModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationStateModelIndex, rowIndex, cacheuserInformationLocationStateModel, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationStateModelIndex, rowIndex);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationCountryModel();
        if (userInformationLocationCountryModelObj != null) {
            Long cacheuserInformationLocationCountryModel = cache.get(userInformationLocationCountryModelObj);
            if (cacheuserInformationLocationCountryModel == null) {
                cacheuserInformationLocationCountryModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insertOrUpdate(realm, userInformationLocationCountryModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationCountryModelIndex, rowIndex, cacheuserInformationLocationCountryModel, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationCountryModelIndex, rowIndex);
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationOrgModel();
        if (userInformationLocationOrgModelObj != null) {
            Long cacheuserInformationLocationOrgModel = cache.get(userInformationLocationOrgModelObj);
            if (cacheuserInformationLocationOrgModel == null) {
                cacheuserInformationLocationOrgModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insertOrUpdate(realm, userInformationLocationOrgModelObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationOrgModelIndex, rowIndex, cacheuserInformationLocationOrgModel, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationOrgModelIndex, rowIndex);
        }

        OsList userInformationLocationServiceArrayListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.userInformationLocationServiceArrayListIndex);
        RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListList = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationServiceArrayList();
        if (userInformationLocationServiceArrayListList != null && userInformationLocationServiceArrayListList.size() == userInformationLocationServiceArrayListOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = userInformationLocationServiceArrayListList.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem = userInformationLocationServiceArrayListList.get(i);
                Long cacheItemIndexuserInformationLocationServiceArrayList = cache.get(userInformationLocationServiceArrayListItem);
                if (cacheItemIndexuserInformationLocationServiceArrayList == null) {
                    cacheItemIndexuserInformationLocationServiceArrayList = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, userInformationLocationServiceArrayListItem, cache);
                }
                userInformationLocationServiceArrayListOsList.setRow(i, cacheItemIndexuserInformationLocationServiceArrayList);
            }
        } else {
            userInformationLocationServiceArrayListOsList.removeAll();
            if (userInformationLocationServiceArrayListList != null) {
                for (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem : userInformationLocationServiceArrayListList) {
                    Long cacheItemIndexuserInformationLocationServiceArrayList = cache.get(userInformationLocationServiceArrayListItem);
                    if (cacheItemIndexuserInformationLocationServiceArrayList == null) {
                        cacheItemIndexuserInformationLocationServiceArrayList = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, userInformationLocationServiceArrayListItem, cache);
                    }
                    userInformationLocationServiceArrayListOsList.addRow(cacheItemIndexuserInformationLocationServiceArrayList);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInformationLocationModelColumnInfo columnInfo = (PPUserInformationLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$userId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
            }
            String realmGet$sName = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sName();
            if (realmGet$sName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sNameIndex, rowIndex, realmGet$sName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sNameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.locationAccessIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$locationAccess(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.userCategoryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userCategory(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.fileUploadPolicyIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$fileUploadPolicy(), false);
            String realmGet$smsPhone = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$smsPhone();
            if (realmGet$smsPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.smsPhoneIndex, rowIndex, realmGet$smsPhone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.smsPhoneIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nType(), false);
            String realmGet$sZip = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sZip();
            if (realmGet$sZip != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sZipIndex, rowIndex, realmGet$sZip, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sZipIndex, rowIndex, false);
            }
            String realmGet$sLatitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sLatitude();
            if (realmGet$sLatitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sLatitudeIndex, rowIndex, realmGet$sLatitude, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sLatitudeIndex, rowIndex, false);
            }
            String realmGet$slongitude = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$slongitude();
            if (realmGet$slongitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.slongitudeIndex, rowIndex, realmGet$slongitude, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.slongitudeIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLatitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$dLongitude(), false);
            String realmGet$salesTaxRate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$salesTaxRate();
            if (realmGet$salesTaxRate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.salesTaxRateIndex, rowIndex, realmGet$salesTaxRate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.salesTaxRateIndex, rowIndex, false);
            }
            String realmGet$sEvent = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sEvent();
            if (realmGet$sEvent != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sEventIndex, rowIndex, realmGet$sEvent, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sEventIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.nStoriesNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nStoriesNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nRoomsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nRoomsNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nBathRoomNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nBathRoomNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nOccupantsNumberIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nOccupantsNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nUsagePeriodIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nUsagePeriod(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nHeatingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nHeatingType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nCoolingTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCoolingType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nWaterHeaterTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nWaterHeaterType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nThermostatTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nThermostatType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nCodeTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$nCodeType(), false);
            String realmGet$sStartDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sStartDate();
            if (realmGet$sStartDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, realmGet$sStartDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sStartDateIndex, rowIndex, false);
            }
            String realmGet$sAccessEndDate = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAccessEndDate();
            if (realmGet$sAccessEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAccessEndDateIndex, rowIndex, realmGet$sAccessEndDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAccessEndDateIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.lAccessEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$lAccessEndDateMs(), false);
            String realmGet$sAddress1 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress1();
            if (realmGet$sAddress1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddress1Index, rowIndex, realmGet$sAddress1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAddress1Index, rowIndex, false);
            }
            String realmGet$sAddress2 = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddress2();
            if (realmGet$sAddress2 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddress2Index, rowIndex, realmGet$sAddress2, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAddress2Index, rowIndex, false);
            }
            String realmGet$sAddCity = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddCity();
            if (realmGet$sAddCity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddCityIndex, rowIndex, realmGet$sAddCity, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAddCityIndex, rowIndex, false);
            }
            String realmGet$sAddState = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sAddState();
            if (realmGet$sAddState != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sAddStateIndex, rowIndex, realmGet$sAddState, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sAddStateIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iTemporaryIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$iTemporary(), false);
            String realmGet$sOrganizationId = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$sOrganizationId();
            if (realmGet$sOrganizationId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sOrganizationIdIndex, rowIndex, realmGet$sOrganizationId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sOrganizationIdIndex, rowIndex, false);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationTimezoneModel();
            if (userInformationLocationTimezoneModelObj != null) {
                Long cacheuserInformationLocationTimezoneModel = cache.get(userInformationLocationTimezoneModelObj);
                if (cacheuserInformationLocationTimezoneModel == null) {
                    cacheuserInformationLocationTimezoneModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insertOrUpdate(realm, userInformationLocationTimezoneModelObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationTimezoneModelIndex, rowIndex, cacheuserInformationLocationTimezoneModel, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationTimezoneModelIndex, rowIndex);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationStateModel();
            if (userInformationLocationStateModelObj != null) {
                Long cacheuserInformationLocationStateModel = cache.get(userInformationLocationStateModelObj);
                if (cacheuserInformationLocationStateModel == null) {
                    cacheuserInformationLocationStateModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insertOrUpdate(realm, userInformationLocationStateModelObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationStateModelIndex, rowIndex, cacheuserInformationLocationStateModel, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationStateModelIndex, rowIndex);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationCountryModel();
            if (userInformationLocationCountryModelObj != null) {
                Long cacheuserInformationLocationCountryModel = cache.get(userInformationLocationCountryModelObj);
                if (cacheuserInformationLocationCountryModel == null) {
                    cacheuserInformationLocationCountryModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insertOrUpdate(realm, userInformationLocationCountryModelObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationCountryModelIndex, rowIndex, cacheuserInformationLocationCountryModel, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationCountryModelIndex, rowIndex);
            }

            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationOrgModel();
            if (userInformationLocationOrgModelObj != null) {
                Long cacheuserInformationLocationOrgModel = cache.get(userInformationLocationOrgModelObj);
                if (cacheuserInformationLocationOrgModel == null) {
                    cacheuserInformationLocationOrgModel = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insertOrUpdate(realm, userInformationLocationOrgModelObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userInformationLocationOrgModelIndex, rowIndex, cacheuserInformationLocationOrgModel, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userInformationLocationOrgModelIndex, rowIndex);
            }

            OsList userInformationLocationServiceArrayListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.userInformationLocationServiceArrayListIndex);
            RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListList = ((com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) object).realmGet$userInformationLocationServiceArrayList();
            if (userInformationLocationServiceArrayListList != null && userInformationLocationServiceArrayListList.size() == userInformationLocationServiceArrayListOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = userInformationLocationServiceArrayListList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem = userInformationLocationServiceArrayListList.get(i);
                    Long cacheItemIndexuserInformationLocationServiceArrayList = cache.get(userInformationLocationServiceArrayListItem);
                    if (cacheItemIndexuserInformationLocationServiceArrayList == null) {
                        cacheItemIndexuserInformationLocationServiceArrayList = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, userInformationLocationServiceArrayListItem, cache);
                    }
                    userInformationLocationServiceArrayListOsList.setRow(i, cacheItemIndexuserInformationLocationServiceArrayList);
                }
            } else {
                userInformationLocationServiceArrayListOsList.removeAll();
                if (userInformationLocationServiceArrayListList != null) {
                    for (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem : userInformationLocationServiceArrayListList) {
                        Long cacheItemIndexuserInformationLocationServiceArrayList = cache.get(userInformationLocationServiceArrayListItem);
                        if (cacheItemIndexuserInformationLocationServiceArrayList == null) {
                            cacheItemIndexuserInformationLocationServiceArrayList = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, userInformationLocationServiceArrayListItem, cache);
                        }
                        userInformationLocationServiceArrayListOsList.addRow(cacheItemIndexuserInformationLocationServiceArrayList);
                    }
                }
            }

        }
    }

    public static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel createDetachedCopy(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$sName(realmSource.realmGet$sName());
        unmanagedCopy.realmSet$locationAccess(realmSource.realmGet$locationAccess());
        unmanagedCopy.realmSet$userCategory(realmSource.realmGet$userCategory());
        unmanagedCopy.realmSet$fileUploadPolicy(realmSource.realmGet$fileUploadPolicy());
        unmanagedCopy.realmSet$smsPhone(realmSource.realmGet$smsPhone());
        unmanagedCopy.realmSet$nType(realmSource.realmGet$nType());
        unmanagedCopy.realmSet$sZip(realmSource.realmGet$sZip());
        unmanagedCopy.realmSet$sLatitude(realmSource.realmGet$sLatitude());
        unmanagedCopy.realmSet$slongitude(realmSource.realmGet$slongitude());
        unmanagedCopy.realmSet$dLatitude(realmSource.realmGet$dLatitude());
        unmanagedCopy.realmSet$dLongitude(realmSource.realmGet$dLongitude());
        unmanagedCopy.realmSet$salesTaxRate(realmSource.realmGet$salesTaxRate());
        unmanagedCopy.realmSet$sEvent(realmSource.realmGet$sEvent());
        unmanagedCopy.realmSet$nStoriesNumber(realmSource.realmGet$nStoriesNumber());
        unmanagedCopy.realmSet$nRoomsNumber(realmSource.realmGet$nRoomsNumber());
        unmanagedCopy.realmSet$nBathRoomNumber(realmSource.realmGet$nBathRoomNumber());
        unmanagedCopy.realmSet$nOccupantsNumber(realmSource.realmGet$nOccupantsNumber());
        unmanagedCopy.realmSet$nUsagePeriod(realmSource.realmGet$nUsagePeriod());
        unmanagedCopy.realmSet$nHeatingType(realmSource.realmGet$nHeatingType());
        unmanagedCopy.realmSet$nCoolingType(realmSource.realmGet$nCoolingType());
        unmanagedCopy.realmSet$nWaterHeaterType(realmSource.realmGet$nWaterHeaterType());
        unmanagedCopy.realmSet$nThermostatType(realmSource.realmGet$nThermostatType());
        unmanagedCopy.realmSet$nCodeType(realmSource.realmGet$nCodeType());
        unmanagedCopy.realmSet$sStartDate(realmSource.realmGet$sStartDate());
        unmanagedCopy.realmSet$sAccessEndDate(realmSource.realmGet$sAccessEndDate());
        unmanagedCopy.realmSet$lAccessEndDateMs(realmSource.realmGet$lAccessEndDateMs());
        unmanagedCopy.realmSet$sAddress1(realmSource.realmGet$sAddress1());
        unmanagedCopy.realmSet$sAddress2(realmSource.realmGet$sAddress2());
        unmanagedCopy.realmSet$sAddCity(realmSource.realmGet$sAddCity());
        unmanagedCopy.realmSet$sAddState(realmSource.realmGet$sAddState());
        unmanagedCopy.realmSet$iTemporary(realmSource.realmGet$iTemporary());
        unmanagedCopy.realmSet$sOrganizationId(realmSource.realmGet$sOrganizationId());

        // Deep copy of userInformationLocationTimezoneModel
        unmanagedCopy.realmSet$userInformationLocationTimezoneModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createDetachedCopy(realmSource.realmGet$userInformationLocationTimezoneModel(), currentDepth + 1, maxDepth, cache));

        // Deep copy of userInformationLocationStateModel
        unmanagedCopy.realmSet$userInformationLocationStateModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createDetachedCopy(realmSource.realmGet$userInformationLocationStateModel(), currentDepth + 1, maxDepth, cache));

        // Deep copy of userInformationLocationCountryModel
        unmanagedCopy.realmSet$userInformationLocationCountryModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createDetachedCopy(realmSource.realmGet$userInformationLocationCountryModel(), currentDepth + 1, maxDepth, cache));

        // Deep copy of userInformationLocationOrgModel
        unmanagedCopy.realmSet$userInformationLocationOrgModel(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createDetachedCopy(realmSource.realmGet$userInformationLocationOrgModel(), currentDepth + 1, maxDepth, cache));

        // Deep copy of userInformationLocationServiceArrayList
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$userInformationLocationServiceArrayList(null);
        } else {
            RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> manageduserInformationLocationServiceArrayListList = realmSource.realmGet$userInformationLocationServiceArrayList();
            RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> unmanageduserInformationLocationServiceArrayListList = new RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>();
            unmanagedCopy.realmSet$userInformationLocationServiceArrayList(unmanageduserInformationLocationServiceArrayListList);
            int nextDepth = currentDepth + 1;
            int size = manageduserInformationLocationServiceArrayListList.size();
            for (int i = 0; i < size; i++) {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel item = com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createDetachedCopy(manageduserInformationLocationServiceArrayListList.get(i), nextDepth, maxDepth, cache);
                unmanageduserInformationLocationServiceArrayListList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel update(Realm realm, PPUserInformationLocationModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel realmObject, com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.userIdIndex, realmObjectSource.realmGet$userId());
        builder.addString(columnInfo.sNameIndex, realmObjectSource.realmGet$sName());
        builder.addInteger(columnInfo.locationAccessIndex, realmObjectSource.realmGet$locationAccess());
        builder.addInteger(columnInfo.userCategoryIndex, realmObjectSource.realmGet$userCategory());
        builder.addInteger(columnInfo.fileUploadPolicyIndex, realmObjectSource.realmGet$fileUploadPolicy());
        builder.addString(columnInfo.smsPhoneIndex, realmObjectSource.realmGet$smsPhone());
        builder.addInteger(columnInfo.nTypeIndex, realmObjectSource.realmGet$nType());
        builder.addString(columnInfo.sZipIndex, realmObjectSource.realmGet$sZip());
        builder.addString(columnInfo.sLatitudeIndex, realmObjectSource.realmGet$sLatitude());
        builder.addString(columnInfo.slongitudeIndex, realmObjectSource.realmGet$slongitude());
        builder.addDouble(columnInfo.dLatitudeIndex, realmObjectSource.realmGet$dLatitude());
        builder.addDouble(columnInfo.dLongitudeIndex, realmObjectSource.realmGet$dLongitude());
        builder.addString(columnInfo.salesTaxRateIndex, realmObjectSource.realmGet$salesTaxRate());
        builder.addString(columnInfo.sEventIndex, realmObjectSource.realmGet$sEvent());
        builder.addInteger(columnInfo.nStoriesNumberIndex, realmObjectSource.realmGet$nStoriesNumber());
        builder.addInteger(columnInfo.nRoomsNumberIndex, realmObjectSource.realmGet$nRoomsNumber());
        builder.addInteger(columnInfo.nBathRoomNumberIndex, realmObjectSource.realmGet$nBathRoomNumber());
        builder.addInteger(columnInfo.nOccupantsNumberIndex, realmObjectSource.realmGet$nOccupantsNumber());
        builder.addInteger(columnInfo.nUsagePeriodIndex, realmObjectSource.realmGet$nUsagePeriod());
        builder.addInteger(columnInfo.nHeatingTypeIndex, realmObjectSource.realmGet$nHeatingType());
        builder.addInteger(columnInfo.nCoolingTypeIndex, realmObjectSource.realmGet$nCoolingType());
        builder.addInteger(columnInfo.nWaterHeaterTypeIndex, realmObjectSource.realmGet$nWaterHeaterType());
        builder.addInteger(columnInfo.nThermostatTypeIndex, realmObjectSource.realmGet$nThermostatType());
        builder.addInteger(columnInfo.nCodeTypeIndex, realmObjectSource.realmGet$nCodeType());
        builder.addString(columnInfo.sStartDateIndex, realmObjectSource.realmGet$sStartDate());
        builder.addString(columnInfo.sAccessEndDateIndex, realmObjectSource.realmGet$sAccessEndDate());
        builder.addInteger(columnInfo.lAccessEndDateMsIndex, realmObjectSource.realmGet$lAccessEndDateMs());
        builder.addString(columnInfo.sAddress1Index, realmObjectSource.realmGet$sAddress1());
        builder.addString(columnInfo.sAddress2Index, realmObjectSource.realmGet$sAddress2());
        builder.addString(columnInfo.sAddCityIndex, realmObjectSource.realmGet$sAddCity());
        builder.addString(columnInfo.sAddStateIndex, realmObjectSource.realmGet$sAddState());
        builder.addInteger(columnInfo.iTemporaryIndex, realmObjectSource.realmGet$iTemporary());
        builder.addString(columnInfo.sOrganizationIdIndex, realmObjectSource.realmGet$sOrganizationId());

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModelObj = realmObjectSource.realmGet$userInformationLocationTimezoneModel();
        if (userInformationLocationTimezoneModelObj == null) {
            builder.addNull(columnInfo.userInformationLocationTimezoneModelIndex);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel cacheuserInformationLocationTimezoneModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) cache.get(userInformationLocationTimezoneModelObj);
            if (cacheuserInformationLocationTimezoneModel != null) {
                builder.addObject(columnInfo.userInformationLocationTimezoneModelIndex, cacheuserInformationLocationTimezoneModel);
            } else {
                builder.addObject(columnInfo.userInformationLocationTimezoneModelIndex, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class), userInformationLocationTimezoneModelObj, true, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel userInformationLocationStateModelObj = realmObjectSource.realmGet$userInformationLocationStateModel();
        if (userInformationLocationStateModelObj == null) {
            builder.addNull(columnInfo.userInformationLocationStateModelIndex);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel cacheuserInformationLocationStateModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) cache.get(userInformationLocationStateModelObj);
            if (cacheuserInformationLocationStateModel != null) {
                builder.addObject(columnInfo.userInformationLocationStateModelIndex, cacheuserInformationLocationStateModel);
            } else {
                builder.addObject(columnInfo.userInformationLocationStateModelIndex, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.PPUserInformationLocationStateModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class), userInformationLocationStateModelObj, true, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel userInformationLocationCountryModelObj = realmObjectSource.realmGet$userInformationLocationCountryModel();
        if (userInformationLocationCountryModelObj == null) {
            builder.addNull(columnInfo.userInformationLocationCountryModelIndex);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel cacheuserInformationLocationCountryModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) cache.get(userInformationLocationCountryModelObj);
            if (cacheuserInformationLocationCountryModel != null) {
                builder.addObject(columnInfo.userInformationLocationCountryModelIndex, cacheuserInformationLocationCountryModel);
            } else {
                builder.addObject(columnInfo.userInformationLocationCountryModelIndex, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class), userInformationLocationCountryModelObj, true, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel userInformationLocationOrgModelObj = realmObjectSource.realmGet$userInformationLocationOrgModel();
        if (userInformationLocationOrgModelObj == null) {
            builder.addNull(columnInfo.userInformationLocationOrgModelIndex);
        } else {
            com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel cacheuserInformationLocationOrgModel = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) cache.get(userInformationLocationOrgModelObj);
            if (cacheuserInformationLocationOrgModel != null) {
                builder.addObject(columnInfo.userInformationLocationOrgModelIndex, cacheuserInformationLocationOrgModel);
            } else {
                builder.addObject(columnInfo.userInformationLocationOrgModelIndex, com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class), userInformationLocationOrgModelObj, true, cache, flags));
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListList = realmObjectSource.realmGet$userInformationLocationServiceArrayList();
        if (userInformationLocationServiceArrayListList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel> userInformationLocationServiceArrayListManagedCopy = new RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>();
            for (int i = 0; i < userInformationLocationServiceArrayListList.size(); i++) {
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel userInformationLocationServiceArrayListItem = userInformationLocationServiceArrayListList.get(i);
                com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel cacheuserInformationLocationServiceArrayList = (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) cache.get(userInformationLocationServiceArrayListItem);
                if (cacheuserInformationLocationServiceArrayList != null) {
                    userInformationLocationServiceArrayListManagedCopy.add(cacheuserInformationLocationServiceArrayList);
                } else {
                    userInformationLocationServiceArrayListManagedCopy.add(com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class), userInformationLocationServiceArrayListItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.userInformationLocationServiceArrayListIndex, userInformationLocationServiceArrayListManagedCopy);
        } else {
            builder.addObjectList(columnInfo.userInformationLocationServiceArrayListIndex, new RealmList<com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel>());
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
        StringBuilder stringBuilder = new StringBuilder("PPUserInformationLocationModel = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sName:");
        stringBuilder.append(realmGet$sName() != null ? realmGet$sName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locationAccess:");
        stringBuilder.append(realmGet$locationAccess());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userCategory:");
        stringBuilder.append(realmGet$userCategory());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fileUploadPolicy:");
        stringBuilder.append(realmGet$fileUploadPolicy());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{smsPhone:");
        stringBuilder.append(realmGet$smsPhone() != null ? realmGet$smsPhone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nType:");
        stringBuilder.append(realmGet$nType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sZip:");
        stringBuilder.append(realmGet$sZip() != null ? realmGet$sZip() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sLatitude:");
        stringBuilder.append(realmGet$sLatitude() != null ? realmGet$sLatitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{slongitude:");
        stringBuilder.append(realmGet$slongitude() != null ? realmGet$slongitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dLatitude:");
        stringBuilder.append(realmGet$dLatitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dLongitude:");
        stringBuilder.append(realmGet$dLongitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{salesTaxRate:");
        stringBuilder.append(realmGet$salesTaxRate() != null ? realmGet$salesTaxRate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sEvent:");
        stringBuilder.append(realmGet$sEvent() != null ? realmGet$sEvent() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nStoriesNumber:");
        stringBuilder.append(realmGet$nStoriesNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nRoomsNumber:");
        stringBuilder.append(realmGet$nRoomsNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nBathRoomNumber:");
        stringBuilder.append(realmGet$nBathRoomNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nOccupantsNumber:");
        stringBuilder.append(realmGet$nOccupantsNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nUsagePeriod:");
        stringBuilder.append(realmGet$nUsagePeriod());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nHeatingType:");
        stringBuilder.append(realmGet$nHeatingType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nCoolingType:");
        stringBuilder.append(realmGet$nCoolingType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nWaterHeaterType:");
        stringBuilder.append(realmGet$nWaterHeaterType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nThermostatType:");
        stringBuilder.append(realmGet$nThermostatType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nCodeType:");
        stringBuilder.append(realmGet$nCodeType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sStartDate:");
        stringBuilder.append(realmGet$sStartDate() != null ? realmGet$sStartDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sAccessEndDate:");
        stringBuilder.append(realmGet$sAccessEndDate() != null ? realmGet$sAccessEndDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lAccessEndDateMs:");
        stringBuilder.append(realmGet$lAccessEndDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sAddress1:");
        stringBuilder.append(realmGet$sAddress1() != null ? realmGet$sAddress1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sAddress2:");
        stringBuilder.append(realmGet$sAddress2() != null ? realmGet$sAddress2() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sAddCity:");
        stringBuilder.append(realmGet$sAddCity() != null ? realmGet$sAddCity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sAddState:");
        stringBuilder.append(realmGet$sAddState() != null ? realmGet$sAddState() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iTemporary:");
        stringBuilder.append(realmGet$iTemporary());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sOrganizationId:");
        stringBuilder.append(realmGet$sOrganizationId() != null ? realmGet$sOrganizationId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userInformationLocationTimezoneModel:");
        stringBuilder.append(realmGet$userInformationLocationTimezoneModel() != null ? "PPUserInformationLocationTimezoneModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userInformationLocationStateModel:");
        stringBuilder.append(realmGet$userInformationLocationStateModel() != null ? "PPUserInformationLocationStateModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userInformationLocationCountryModel:");
        stringBuilder.append(realmGet$userInformationLocationCountryModel() != null ? "PPUserInformationLocationCountryModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userInformationLocationOrgModel:");
        stringBuilder.append(realmGet$userInformationLocationOrgModel() != null ? "PPUserInformationLocationOrgModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userInformationLocationServiceArrayList:");
        stringBuilder.append("RealmList<PPUserInformationServiceModel>[").append(realmGet$userInformationLocationServiceArrayList().size()).append("]");
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
        com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy aPPUserInformationLocationModel = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInformationLocationModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInformationLocationModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInformationLocationModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
