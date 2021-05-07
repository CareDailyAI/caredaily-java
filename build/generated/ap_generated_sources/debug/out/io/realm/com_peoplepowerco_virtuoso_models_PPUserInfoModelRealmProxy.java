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
public class com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy extends com.peoplepowerco.virtuoso.models.PPUserInfoModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface {

    static final class PPUserInfoModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long sUserInfoIdIndex;
        long sUserInfoNameIndex;
        long sUserInfoLoIdIndex;
        long sUserInfoLoNameIndex;
        long sUserFirstNameIndex;
        long sUserLastNameIndex;
        long sCommunityNameIndex;
        long sUserInfoLoEventIndex;
        long sUserInfoStartDayIndex;
        long sUserEmailIndex;
        long sUserVerifiedIndex;
        long nMailStatusIndex;
        long nSmsStatusIndex;
        long nPhoneTypeIndex;
        long sUserStatusIndex;
        long sFileUploadPolicyIndex;
        long sPhoneNumberIndex;
        long stimezoneIdIndex;
        long stimezoneNameIndex;
        long sLanguageIndex;
        long iLocationCountIndex;
        long bAnonymousIndex;
        long dLongitudeIndex;
        long dLatitudeIndex;

        PPUserInfoModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(24);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPUserInfoModel");
            this.sUserInfoIdIndex = addColumnDetails("sUserInfoId", "sUserInfoId", objectSchemaInfo);
            this.sUserInfoNameIndex = addColumnDetails("sUserInfoName", "sUserInfoName", objectSchemaInfo);
            this.sUserInfoLoIdIndex = addColumnDetails("sUserInfoLoId", "sUserInfoLoId", objectSchemaInfo);
            this.sUserInfoLoNameIndex = addColumnDetails("sUserInfoLoName", "sUserInfoLoName", objectSchemaInfo);
            this.sUserFirstNameIndex = addColumnDetails("sUserFirstName", "sUserFirstName", objectSchemaInfo);
            this.sUserLastNameIndex = addColumnDetails("sUserLastName", "sUserLastName", objectSchemaInfo);
            this.sCommunityNameIndex = addColumnDetails("sCommunityName", "sCommunityName", objectSchemaInfo);
            this.sUserInfoLoEventIndex = addColumnDetails("sUserInfoLoEvent", "sUserInfoLoEvent", objectSchemaInfo);
            this.sUserInfoStartDayIndex = addColumnDetails("sUserInfoStartDay", "sUserInfoStartDay", objectSchemaInfo);
            this.sUserEmailIndex = addColumnDetails("sUserEmail", "sUserEmail", objectSchemaInfo);
            this.sUserVerifiedIndex = addColumnDetails("sUserVerified", "sUserVerified", objectSchemaInfo);
            this.nMailStatusIndex = addColumnDetails("nMailStatus", "nMailStatus", objectSchemaInfo);
            this.nSmsStatusIndex = addColumnDetails("nSmsStatus", "nSmsStatus", objectSchemaInfo);
            this.nPhoneTypeIndex = addColumnDetails("nPhoneType", "nPhoneType", objectSchemaInfo);
            this.sUserStatusIndex = addColumnDetails("sUserStatus", "sUserStatus", objectSchemaInfo);
            this.sFileUploadPolicyIndex = addColumnDetails("sFileUploadPolicy", "sFileUploadPolicy", objectSchemaInfo);
            this.sPhoneNumberIndex = addColumnDetails("sPhoneNumber", "sPhoneNumber", objectSchemaInfo);
            this.stimezoneIdIndex = addColumnDetails("stimezoneId", "stimezoneId", objectSchemaInfo);
            this.stimezoneNameIndex = addColumnDetails("stimezoneName", "stimezoneName", objectSchemaInfo);
            this.sLanguageIndex = addColumnDetails("sLanguage", "sLanguage", objectSchemaInfo);
            this.iLocationCountIndex = addColumnDetails("iLocationCount", "iLocationCount", objectSchemaInfo);
            this.bAnonymousIndex = addColumnDetails("bAnonymous", "bAnonymous", objectSchemaInfo);
            this.dLongitudeIndex = addColumnDetails("dLongitude", "dLongitude", objectSchemaInfo);
            this.dLatitudeIndex = addColumnDetails("dLatitude", "dLatitude", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPUserInfoModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPUserInfoModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPUserInfoModelColumnInfo src = (PPUserInfoModelColumnInfo) rawSrc;
            final PPUserInfoModelColumnInfo dst = (PPUserInfoModelColumnInfo) rawDst;
            dst.sUserInfoIdIndex = src.sUserInfoIdIndex;
            dst.sUserInfoNameIndex = src.sUserInfoNameIndex;
            dst.sUserInfoLoIdIndex = src.sUserInfoLoIdIndex;
            dst.sUserInfoLoNameIndex = src.sUserInfoLoNameIndex;
            dst.sUserFirstNameIndex = src.sUserFirstNameIndex;
            dst.sUserLastNameIndex = src.sUserLastNameIndex;
            dst.sCommunityNameIndex = src.sCommunityNameIndex;
            dst.sUserInfoLoEventIndex = src.sUserInfoLoEventIndex;
            dst.sUserInfoStartDayIndex = src.sUserInfoStartDayIndex;
            dst.sUserEmailIndex = src.sUserEmailIndex;
            dst.sUserVerifiedIndex = src.sUserVerifiedIndex;
            dst.nMailStatusIndex = src.nMailStatusIndex;
            dst.nSmsStatusIndex = src.nSmsStatusIndex;
            dst.nPhoneTypeIndex = src.nPhoneTypeIndex;
            dst.sUserStatusIndex = src.sUserStatusIndex;
            dst.sFileUploadPolicyIndex = src.sFileUploadPolicyIndex;
            dst.sPhoneNumberIndex = src.sPhoneNumberIndex;
            dst.stimezoneIdIndex = src.stimezoneIdIndex;
            dst.stimezoneNameIndex = src.stimezoneNameIndex;
            dst.sLanguageIndex = src.sLanguageIndex;
            dst.iLocationCountIndex = src.iLocationCountIndex;
            dst.bAnonymousIndex = src.bAnonymousIndex;
            dst.dLongitudeIndex = src.dLongitudeIndex;
            dst.dLatitudeIndex = src.dLatitudeIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPUserInfoModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.PPUserInfoModel> proxyState;

    com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPUserInfoModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.PPUserInfoModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserInfoId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserInfoIdIndex);
    }

    @Override
    public void realmSet$sUserInfoId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'sUserInfoId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserInfoName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserInfoNameIndex);
    }

    @Override
    public void realmSet$sUserInfoName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserInfoNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserInfoNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserInfoNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserInfoNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserInfoLoId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserInfoLoIdIndex);
    }

    @Override
    public void realmSet$sUserInfoLoId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserInfoLoIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserInfoLoIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserInfoLoIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserInfoLoIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserInfoLoName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserInfoLoNameIndex);
    }

    @Override
    public void realmSet$sUserInfoLoName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserInfoLoNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserInfoLoNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserInfoLoNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserInfoLoNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserFirstName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserFirstNameIndex);
    }

    @Override
    public void realmSet$sUserFirstName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserFirstNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserFirstNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserFirstNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserFirstNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserLastName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserLastNameIndex);
    }

    @Override
    public void realmSet$sUserLastName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserLastNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserLastNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserLastNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserLastNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sCommunityName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sCommunityNameIndex);
    }

    @Override
    public void realmSet$sCommunityName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sCommunityNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sCommunityNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sCommunityNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sCommunityNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserInfoLoEvent() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserInfoLoEventIndex);
    }

    @Override
    public void realmSet$sUserInfoLoEvent(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserInfoLoEventIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserInfoLoEventIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserInfoLoEventIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserInfoLoEventIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserInfoStartDay() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserInfoStartDayIndex);
    }

    @Override
    public void realmSet$sUserInfoStartDay(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserInfoStartDayIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserInfoStartDayIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserInfoStartDayIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserInfoStartDayIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserEmail() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserEmailIndex);
    }

    @Override
    public void realmSet$sUserEmail(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserEmailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserEmailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserEmailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserEmailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$sUserVerified() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.sUserVerifiedIndex);
    }

    @Override
    public void realmSet$sUserVerified(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.sUserVerifiedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.sUserVerifiedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nMailStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nMailStatusIndex);
    }

    @Override
    public void realmSet$nMailStatus(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nMailStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nMailStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nSmsStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nSmsStatusIndex);
    }

    @Override
    public void realmSet$nSmsStatus(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nSmsStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nSmsStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$nPhoneType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.nPhoneTypeIndex);
    }

    @Override
    public void realmSet$nPhoneType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nPhoneTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nPhoneTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sUserStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sUserStatusIndex);
    }

    @Override
    public void realmSet$sUserStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sUserStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sUserStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sUserStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sUserStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sFileUploadPolicy() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sFileUploadPolicyIndex);
    }

    @Override
    public void realmSet$sFileUploadPolicy(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sFileUploadPolicyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sFileUploadPolicyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sFileUploadPolicyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sFileUploadPolicyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sPhoneNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sPhoneNumberIndex);
    }

    @Override
    public void realmSet$sPhoneNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sPhoneNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sPhoneNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sPhoneNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sPhoneNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$stimezoneId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stimezoneIdIndex);
    }

    @Override
    public void realmSet$stimezoneId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stimezoneIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stimezoneIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stimezoneIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stimezoneIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$stimezoneName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stimezoneNameIndex);
    }

    @Override
    public void realmSet$stimezoneName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stimezoneNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stimezoneNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stimezoneNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stimezoneNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sLanguage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sLanguageIndex);
    }

    @Override
    public void realmSet$sLanguage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sLanguageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sLanguageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sLanguageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sLanguageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$iLocationCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iLocationCountIndex);
    }

    @Override
    public void realmSet$iLocationCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iLocationCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iLocationCountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$bAnonymous() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.bAnonymousIndex);
    }

    @Override
    public void realmSet$bAnonymous(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.bAnonymousIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.bAnonymousIndex, value);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPUserInfoModel", 24, 0);
        builder.addPersistedProperty("sUserInfoId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserInfoName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserInfoLoId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserInfoLoName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserFirstName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserLastName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sCommunityName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserInfoLoEvent", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserInfoStartDay", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserEmail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sUserVerified", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nMailStatus", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nSmsStatus", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nPhoneType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sUserStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sFileUploadPolicy", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sPhoneNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("stimezoneId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("stimezoneName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("iLocationCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("bAnonymous", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("dLongitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("dLatitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPUserInfoModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPUserInfoModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPUserInfoModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPUserInfoModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.PPUserInfoModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.peoplepowerco.virtuoso.models.PPUserInfoModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
            PPUserInfoModelColumnInfo columnInfo = (PPUserInfoModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
            long pkColumnIndex = columnInfo.sUserInfoIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("sUserInfoId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("sUserInfoId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("sUserInfoId")) {
                if (json.isNull("sUserInfoId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class, json.getString("sUserInfoId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'sUserInfoId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) obj;
        if (json.has("sUserInfoName")) {
            if (json.isNull("sUserInfoName")) {
                objProxy.realmSet$sUserInfoName(null);
            } else {
                objProxy.realmSet$sUserInfoName((String) json.getString("sUserInfoName"));
            }
        }
        if (json.has("sUserInfoLoId")) {
            if (json.isNull("sUserInfoLoId")) {
                objProxy.realmSet$sUserInfoLoId(null);
            } else {
                objProxy.realmSet$sUserInfoLoId((String) json.getString("sUserInfoLoId"));
            }
        }
        if (json.has("sUserInfoLoName")) {
            if (json.isNull("sUserInfoLoName")) {
                objProxy.realmSet$sUserInfoLoName(null);
            } else {
                objProxy.realmSet$sUserInfoLoName((String) json.getString("sUserInfoLoName"));
            }
        }
        if (json.has("sUserFirstName")) {
            if (json.isNull("sUserFirstName")) {
                objProxy.realmSet$sUserFirstName(null);
            } else {
                objProxy.realmSet$sUserFirstName((String) json.getString("sUserFirstName"));
            }
        }
        if (json.has("sUserLastName")) {
            if (json.isNull("sUserLastName")) {
                objProxy.realmSet$sUserLastName(null);
            } else {
                objProxy.realmSet$sUserLastName((String) json.getString("sUserLastName"));
            }
        }
        if (json.has("sCommunityName")) {
            if (json.isNull("sCommunityName")) {
                objProxy.realmSet$sCommunityName(null);
            } else {
                objProxy.realmSet$sCommunityName((String) json.getString("sCommunityName"));
            }
        }
        if (json.has("sUserInfoLoEvent")) {
            if (json.isNull("sUserInfoLoEvent")) {
                objProxy.realmSet$sUserInfoLoEvent(null);
            } else {
                objProxy.realmSet$sUserInfoLoEvent((String) json.getString("sUserInfoLoEvent"));
            }
        }
        if (json.has("sUserInfoStartDay")) {
            if (json.isNull("sUserInfoStartDay")) {
                objProxy.realmSet$sUserInfoStartDay(null);
            } else {
                objProxy.realmSet$sUserInfoStartDay((String) json.getString("sUserInfoStartDay"));
            }
        }
        if (json.has("sUserEmail")) {
            if (json.isNull("sUserEmail")) {
                objProxy.realmSet$sUserEmail(null);
            } else {
                objProxy.realmSet$sUserEmail((String) json.getString("sUserEmail"));
            }
        }
        if (json.has("sUserVerified")) {
            if (json.isNull("sUserVerified")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sUserVerified' to null.");
            } else {
                objProxy.realmSet$sUserVerified((boolean) json.getBoolean("sUserVerified"));
            }
        }
        if (json.has("nMailStatus")) {
            if (json.isNull("nMailStatus")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nMailStatus' to null.");
            } else {
                objProxy.realmSet$nMailStatus((int) json.getInt("nMailStatus"));
            }
        }
        if (json.has("nSmsStatus")) {
            if (json.isNull("nSmsStatus")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nSmsStatus' to null.");
            } else {
                objProxy.realmSet$nSmsStatus((int) json.getInt("nSmsStatus"));
            }
        }
        if (json.has("nPhoneType")) {
            if (json.isNull("nPhoneType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nPhoneType' to null.");
            } else {
                objProxy.realmSet$nPhoneType((int) json.getInt("nPhoneType"));
            }
        }
        if (json.has("sUserStatus")) {
            if (json.isNull("sUserStatus")) {
                objProxy.realmSet$sUserStatus(null);
            } else {
                objProxy.realmSet$sUserStatus((String) json.getString("sUserStatus"));
            }
        }
        if (json.has("sFileUploadPolicy")) {
            if (json.isNull("sFileUploadPolicy")) {
                objProxy.realmSet$sFileUploadPolicy(null);
            } else {
                objProxy.realmSet$sFileUploadPolicy((String) json.getString("sFileUploadPolicy"));
            }
        }
        if (json.has("sPhoneNumber")) {
            if (json.isNull("sPhoneNumber")) {
                objProxy.realmSet$sPhoneNumber(null);
            } else {
                objProxy.realmSet$sPhoneNumber((String) json.getString("sPhoneNumber"));
            }
        }
        if (json.has("stimezoneId")) {
            if (json.isNull("stimezoneId")) {
                objProxy.realmSet$stimezoneId(null);
            } else {
                objProxy.realmSet$stimezoneId((String) json.getString("stimezoneId"));
            }
        }
        if (json.has("stimezoneName")) {
            if (json.isNull("stimezoneName")) {
                objProxy.realmSet$stimezoneName(null);
            } else {
                objProxy.realmSet$stimezoneName((String) json.getString("stimezoneName"));
            }
        }
        if (json.has("sLanguage")) {
            if (json.isNull("sLanguage")) {
                objProxy.realmSet$sLanguage(null);
            } else {
                objProxy.realmSet$sLanguage((String) json.getString("sLanguage"));
            }
        }
        if (json.has("iLocationCount")) {
            if (json.isNull("iLocationCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iLocationCount' to null.");
            } else {
                objProxy.realmSet$iLocationCount((int) json.getInt("iLocationCount"));
            }
        }
        if (json.has("bAnonymous")) {
            if (json.isNull("bAnonymous")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bAnonymous' to null.");
            } else {
                objProxy.realmSet$bAnonymous((boolean) json.getBoolean("bAnonymous"));
            }
        }
        if (json.has("dLongitude")) {
            if (json.isNull("dLongitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'dLongitude' to null.");
            } else {
                objProxy.realmSet$dLongitude((double) json.getDouble("dLongitude"));
            }
        }
        if (json.has("dLatitude")) {
            if (json.isNull("dLatitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'dLatitude' to null.");
            } else {
                objProxy.realmSet$dLatitude((double) json.getDouble("dLatitude"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.PPUserInfoModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.PPUserInfoModel obj = new com.peoplepowerco.virtuoso.models.PPUserInfoModel();
        final com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("sUserInfoId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserInfoId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserInfoId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("sUserInfoName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserInfoName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserInfoName(null);
                }
            } else if (name.equals("sUserInfoLoId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserInfoLoId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserInfoLoId(null);
                }
            } else if (name.equals("sUserInfoLoName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserInfoLoName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserInfoLoName(null);
                }
            } else if (name.equals("sUserFirstName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserFirstName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserFirstName(null);
                }
            } else if (name.equals("sUserLastName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserLastName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserLastName(null);
                }
            } else if (name.equals("sCommunityName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sCommunityName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sCommunityName(null);
                }
            } else if (name.equals("sUserInfoLoEvent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserInfoLoEvent((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserInfoLoEvent(null);
                }
            } else if (name.equals("sUserInfoStartDay")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserInfoStartDay((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserInfoStartDay(null);
                }
            } else if (name.equals("sUserEmail")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserEmail((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserEmail(null);
                }
            } else if (name.equals("sUserVerified")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserVerified((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sUserVerified' to null.");
                }
            } else if (name.equals("nMailStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nMailStatus((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nMailStatus' to null.");
                }
            } else if (name.equals("nSmsStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nSmsStatus((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nSmsStatus' to null.");
                }
            } else if (name.equals("nPhoneType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nPhoneType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nPhoneType' to null.");
                }
            } else if (name.equals("sUserStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sUserStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sUserStatus(null);
                }
            } else if (name.equals("sFileUploadPolicy")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sFileUploadPolicy((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sFileUploadPolicy(null);
                }
            } else if (name.equals("sPhoneNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sPhoneNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sPhoneNumber(null);
                }
            } else if (name.equals("stimezoneId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$stimezoneId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$stimezoneId(null);
                }
            } else if (name.equals("stimezoneName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$stimezoneName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$stimezoneName(null);
                }
            } else if (name.equals("sLanguage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sLanguage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sLanguage(null);
                }
            } else if (name.equals("iLocationCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$iLocationCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iLocationCount' to null.");
                }
            } else if (name.equals("bAnonymous")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bAnonymous((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bAnonymous' to null.");
                }
            } else if (name.equals("dLongitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dLongitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dLongitude' to null.");
                }
            } else if (name.equals("dLatitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dLatitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dLatitude' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'sUserInfoId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.PPUserInfoModel copyOrUpdate(Realm realm, PPUserInfoModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPUserInfoModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.PPUserInfoModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.PPUserInfoModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
            long pkColumnIndex = columnInfo.sUserInfoIdIndex;
            String value = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoId();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.PPUserInfoModel copy(Realm realm, PPUserInfoModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPUserInfoModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.PPUserInfoModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.sUserInfoIdIndex, realmObjectSource.realmGet$sUserInfoId());
        builder.addString(columnInfo.sUserInfoNameIndex, realmObjectSource.realmGet$sUserInfoName());
        builder.addString(columnInfo.sUserInfoLoIdIndex, realmObjectSource.realmGet$sUserInfoLoId());
        builder.addString(columnInfo.sUserInfoLoNameIndex, realmObjectSource.realmGet$sUserInfoLoName());
        builder.addString(columnInfo.sUserFirstNameIndex, realmObjectSource.realmGet$sUserFirstName());
        builder.addString(columnInfo.sUserLastNameIndex, realmObjectSource.realmGet$sUserLastName());
        builder.addString(columnInfo.sCommunityNameIndex, realmObjectSource.realmGet$sCommunityName());
        builder.addString(columnInfo.sUserInfoLoEventIndex, realmObjectSource.realmGet$sUserInfoLoEvent());
        builder.addString(columnInfo.sUserInfoStartDayIndex, realmObjectSource.realmGet$sUserInfoStartDay());
        builder.addString(columnInfo.sUserEmailIndex, realmObjectSource.realmGet$sUserEmail());
        builder.addBoolean(columnInfo.sUserVerifiedIndex, realmObjectSource.realmGet$sUserVerified());
        builder.addInteger(columnInfo.nMailStatusIndex, realmObjectSource.realmGet$nMailStatus());
        builder.addInteger(columnInfo.nSmsStatusIndex, realmObjectSource.realmGet$nSmsStatus());
        builder.addInteger(columnInfo.nPhoneTypeIndex, realmObjectSource.realmGet$nPhoneType());
        builder.addString(columnInfo.sUserStatusIndex, realmObjectSource.realmGet$sUserStatus());
        builder.addString(columnInfo.sFileUploadPolicyIndex, realmObjectSource.realmGet$sFileUploadPolicy());
        builder.addString(columnInfo.sPhoneNumberIndex, realmObjectSource.realmGet$sPhoneNumber());
        builder.addString(columnInfo.stimezoneIdIndex, realmObjectSource.realmGet$stimezoneId());
        builder.addString(columnInfo.stimezoneNameIndex, realmObjectSource.realmGet$stimezoneName());
        builder.addString(columnInfo.sLanguageIndex, realmObjectSource.realmGet$sLanguage());
        builder.addInteger(columnInfo.iLocationCountIndex, realmObjectSource.realmGet$iLocationCount());
        builder.addBoolean(columnInfo.bAnonymousIndex, realmObjectSource.realmGet$bAnonymous());
        builder.addDouble(columnInfo.dLongitudeIndex, realmObjectSource.realmGet$dLongitude());
        builder.addDouble(columnInfo.dLatitudeIndex, realmObjectSource.realmGet$dLatitude());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.PPUserInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInfoModelColumnInfo columnInfo = (PPUserInfoModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long pkColumnIndex = columnInfo.sUserInfoIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoId();
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
        String realmGet$sUserInfoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoName();
        if (realmGet$sUserInfoName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoNameIndex, rowIndex, realmGet$sUserInfoName, false);
        }
        String realmGet$sUserInfoLoId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoId();
        if (realmGet$sUserInfoLoId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoIdIndex, rowIndex, realmGet$sUserInfoLoId, false);
        }
        String realmGet$sUserInfoLoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoName();
        if (realmGet$sUserInfoLoName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoNameIndex, rowIndex, realmGet$sUserInfoLoName, false);
        }
        String realmGet$sUserFirstName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserFirstName();
        if (realmGet$sUserFirstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserFirstNameIndex, rowIndex, realmGet$sUserFirstName, false);
        }
        String realmGet$sUserLastName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserLastName();
        if (realmGet$sUserLastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserLastNameIndex, rowIndex, realmGet$sUserLastName, false);
        }
        String realmGet$sCommunityName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sCommunityName();
        if (realmGet$sCommunityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCommunityNameIndex, rowIndex, realmGet$sCommunityName, false);
        }
        String realmGet$sUserInfoLoEvent = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoEvent();
        if (realmGet$sUserInfoLoEvent != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoEventIndex, rowIndex, realmGet$sUserInfoLoEvent, false);
        }
        String realmGet$sUserInfoStartDay = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoStartDay();
        if (realmGet$sUserInfoStartDay != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoStartDayIndex, rowIndex, realmGet$sUserInfoStartDay, false);
        }
        String realmGet$sUserEmail = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserEmail();
        if (realmGet$sUserEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserEmailIndex, rowIndex, realmGet$sUserEmail, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.sUserVerifiedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserVerified(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nMailStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nMailStatus(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nSmsStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nSmsStatus(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nPhoneTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nPhoneType(), false);
        String realmGet$sUserStatus = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserStatus();
        if (realmGet$sUserStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserStatusIndex, rowIndex, realmGet$sUserStatus, false);
        }
        String realmGet$sFileUploadPolicy = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sFileUploadPolicy();
        if (realmGet$sFileUploadPolicy != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sFileUploadPolicyIndex, rowIndex, realmGet$sFileUploadPolicy, false);
        }
        String realmGet$sPhoneNumber = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sPhoneNumber();
        if (realmGet$sPhoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sPhoneNumberIndex, rowIndex, realmGet$sPhoneNumber, false);
        }
        String realmGet$stimezoneId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneId();
        if (realmGet$stimezoneId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stimezoneIdIndex, rowIndex, realmGet$stimezoneId, false);
        }
        String realmGet$stimezoneName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneName();
        if (realmGet$stimezoneName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stimezoneNameIndex, rowIndex, realmGet$stimezoneName, false);
        }
        String realmGet$sLanguage = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sLanguage();
        if (realmGet$sLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sLanguageIndex, rowIndex, realmGet$sLanguage, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iLocationCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$iLocationCount(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bAnonymousIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$bAnonymous(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLongitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLatitude(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInfoModelColumnInfo columnInfo = (PPUserInfoModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long pkColumnIndex = columnInfo.sUserInfoIdIndex;
        com.peoplepowerco.virtuoso.models.PPUserInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPUserInfoModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoId();
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
            String realmGet$sUserInfoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoName();
            if (realmGet$sUserInfoName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoNameIndex, rowIndex, realmGet$sUserInfoName, false);
            }
            String realmGet$sUserInfoLoId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoId();
            if (realmGet$sUserInfoLoId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoIdIndex, rowIndex, realmGet$sUserInfoLoId, false);
            }
            String realmGet$sUserInfoLoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoName();
            if (realmGet$sUserInfoLoName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoNameIndex, rowIndex, realmGet$sUserInfoLoName, false);
            }
            String realmGet$sUserFirstName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserFirstName();
            if (realmGet$sUserFirstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserFirstNameIndex, rowIndex, realmGet$sUserFirstName, false);
            }
            String realmGet$sUserLastName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserLastName();
            if (realmGet$sUserLastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserLastNameIndex, rowIndex, realmGet$sUserLastName, false);
            }
            String realmGet$sCommunityName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sCommunityName();
            if (realmGet$sCommunityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCommunityNameIndex, rowIndex, realmGet$sCommunityName, false);
            }
            String realmGet$sUserInfoLoEvent = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoEvent();
            if (realmGet$sUserInfoLoEvent != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoEventIndex, rowIndex, realmGet$sUserInfoLoEvent, false);
            }
            String realmGet$sUserInfoStartDay = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoStartDay();
            if (realmGet$sUserInfoStartDay != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoStartDayIndex, rowIndex, realmGet$sUserInfoStartDay, false);
            }
            String realmGet$sUserEmail = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserEmail();
            if (realmGet$sUserEmail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserEmailIndex, rowIndex, realmGet$sUserEmail, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.sUserVerifiedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserVerified(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nMailStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nMailStatus(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nSmsStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nSmsStatus(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nPhoneTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nPhoneType(), false);
            String realmGet$sUserStatus = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserStatus();
            if (realmGet$sUserStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserStatusIndex, rowIndex, realmGet$sUserStatus, false);
            }
            String realmGet$sFileUploadPolicy = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sFileUploadPolicy();
            if (realmGet$sFileUploadPolicy != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sFileUploadPolicyIndex, rowIndex, realmGet$sFileUploadPolicy, false);
            }
            String realmGet$sPhoneNumber = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sPhoneNumber();
            if (realmGet$sPhoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sPhoneNumberIndex, rowIndex, realmGet$sPhoneNumber, false);
            }
            String realmGet$stimezoneId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneId();
            if (realmGet$stimezoneId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stimezoneIdIndex, rowIndex, realmGet$stimezoneId, false);
            }
            String realmGet$stimezoneName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneName();
            if (realmGet$stimezoneName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stimezoneNameIndex, rowIndex, realmGet$stimezoneName, false);
            }
            String realmGet$sLanguage = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sLanguage();
            if (realmGet$sLanguage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sLanguageIndex, rowIndex, realmGet$sLanguage, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iLocationCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$iLocationCount(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bAnonymousIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$bAnonymous(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLongitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLatitude(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.PPUserInfoModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInfoModelColumnInfo columnInfo = (PPUserInfoModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long pkColumnIndex = columnInfo.sUserInfoIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoId();
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
        String realmGet$sUserInfoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoName();
        if (realmGet$sUserInfoName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoNameIndex, rowIndex, realmGet$sUserInfoName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoNameIndex, rowIndex, false);
        }
        String realmGet$sUserInfoLoId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoId();
        if (realmGet$sUserInfoLoId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoIdIndex, rowIndex, realmGet$sUserInfoLoId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoLoIdIndex, rowIndex, false);
        }
        String realmGet$sUserInfoLoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoName();
        if (realmGet$sUserInfoLoName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoNameIndex, rowIndex, realmGet$sUserInfoLoName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoLoNameIndex, rowIndex, false);
        }
        String realmGet$sUserFirstName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserFirstName();
        if (realmGet$sUserFirstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserFirstNameIndex, rowIndex, realmGet$sUserFirstName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserFirstNameIndex, rowIndex, false);
        }
        String realmGet$sUserLastName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserLastName();
        if (realmGet$sUserLastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserLastNameIndex, rowIndex, realmGet$sUserLastName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserLastNameIndex, rowIndex, false);
        }
        String realmGet$sCommunityName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sCommunityName();
        if (realmGet$sCommunityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sCommunityNameIndex, rowIndex, realmGet$sCommunityName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sCommunityNameIndex, rowIndex, false);
        }
        String realmGet$sUserInfoLoEvent = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoEvent();
        if (realmGet$sUserInfoLoEvent != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoEventIndex, rowIndex, realmGet$sUserInfoLoEvent, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoLoEventIndex, rowIndex, false);
        }
        String realmGet$sUserInfoStartDay = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoStartDay();
        if (realmGet$sUserInfoStartDay != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoStartDayIndex, rowIndex, realmGet$sUserInfoStartDay, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoStartDayIndex, rowIndex, false);
        }
        String realmGet$sUserEmail = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserEmail();
        if (realmGet$sUserEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserEmailIndex, rowIndex, realmGet$sUserEmail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserEmailIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.sUserVerifiedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserVerified(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nMailStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nMailStatus(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nSmsStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nSmsStatus(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nPhoneTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nPhoneType(), false);
        String realmGet$sUserStatus = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserStatus();
        if (realmGet$sUserStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sUserStatusIndex, rowIndex, realmGet$sUserStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sUserStatusIndex, rowIndex, false);
        }
        String realmGet$sFileUploadPolicy = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sFileUploadPolicy();
        if (realmGet$sFileUploadPolicy != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sFileUploadPolicyIndex, rowIndex, realmGet$sFileUploadPolicy, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sFileUploadPolicyIndex, rowIndex, false);
        }
        String realmGet$sPhoneNumber = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sPhoneNumber();
        if (realmGet$sPhoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sPhoneNumberIndex, rowIndex, realmGet$sPhoneNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sPhoneNumberIndex, rowIndex, false);
        }
        String realmGet$stimezoneId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneId();
        if (realmGet$stimezoneId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stimezoneIdIndex, rowIndex, realmGet$stimezoneId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stimezoneIdIndex, rowIndex, false);
        }
        String realmGet$stimezoneName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneName();
        if (realmGet$stimezoneName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stimezoneNameIndex, rowIndex, realmGet$stimezoneName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stimezoneNameIndex, rowIndex, false);
        }
        String realmGet$sLanguage = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sLanguage();
        if (realmGet$sLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sLanguageIndex, rowIndex, realmGet$sLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sLanguageIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iLocationCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$iLocationCount(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bAnonymousIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$bAnonymous(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLongitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLatitude(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long tableNativePtr = table.getNativePtr();
        PPUserInfoModelColumnInfo columnInfo = (PPUserInfoModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        long pkColumnIndex = columnInfo.sUserInfoIdIndex;
        com.peoplepowerco.virtuoso.models.PPUserInfoModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.PPUserInfoModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoId();
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
            String realmGet$sUserInfoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoName();
            if (realmGet$sUserInfoName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoNameIndex, rowIndex, realmGet$sUserInfoName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoNameIndex, rowIndex, false);
            }
            String realmGet$sUserInfoLoId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoId();
            if (realmGet$sUserInfoLoId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoIdIndex, rowIndex, realmGet$sUserInfoLoId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoLoIdIndex, rowIndex, false);
            }
            String realmGet$sUserInfoLoName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoName();
            if (realmGet$sUserInfoLoName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoNameIndex, rowIndex, realmGet$sUserInfoLoName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoLoNameIndex, rowIndex, false);
            }
            String realmGet$sUserFirstName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserFirstName();
            if (realmGet$sUserFirstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserFirstNameIndex, rowIndex, realmGet$sUserFirstName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserFirstNameIndex, rowIndex, false);
            }
            String realmGet$sUserLastName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserLastName();
            if (realmGet$sUserLastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserLastNameIndex, rowIndex, realmGet$sUserLastName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserLastNameIndex, rowIndex, false);
            }
            String realmGet$sCommunityName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sCommunityName();
            if (realmGet$sCommunityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sCommunityNameIndex, rowIndex, realmGet$sCommunityName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sCommunityNameIndex, rowIndex, false);
            }
            String realmGet$sUserInfoLoEvent = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoLoEvent();
            if (realmGet$sUserInfoLoEvent != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoLoEventIndex, rowIndex, realmGet$sUserInfoLoEvent, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoLoEventIndex, rowIndex, false);
            }
            String realmGet$sUserInfoStartDay = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserInfoStartDay();
            if (realmGet$sUserInfoStartDay != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserInfoStartDayIndex, rowIndex, realmGet$sUserInfoStartDay, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserInfoStartDayIndex, rowIndex, false);
            }
            String realmGet$sUserEmail = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserEmail();
            if (realmGet$sUserEmail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserEmailIndex, rowIndex, realmGet$sUserEmail, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserEmailIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.sUserVerifiedIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserVerified(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nMailStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nMailStatus(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nSmsStatusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nSmsStatus(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nPhoneTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$nPhoneType(), false);
            String realmGet$sUserStatus = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sUserStatus();
            if (realmGet$sUserStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sUserStatusIndex, rowIndex, realmGet$sUserStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sUserStatusIndex, rowIndex, false);
            }
            String realmGet$sFileUploadPolicy = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sFileUploadPolicy();
            if (realmGet$sFileUploadPolicy != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sFileUploadPolicyIndex, rowIndex, realmGet$sFileUploadPolicy, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sFileUploadPolicyIndex, rowIndex, false);
            }
            String realmGet$sPhoneNumber = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sPhoneNumber();
            if (realmGet$sPhoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sPhoneNumberIndex, rowIndex, realmGet$sPhoneNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sPhoneNumberIndex, rowIndex, false);
            }
            String realmGet$stimezoneId = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneId();
            if (realmGet$stimezoneId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stimezoneIdIndex, rowIndex, realmGet$stimezoneId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.stimezoneIdIndex, rowIndex, false);
            }
            String realmGet$stimezoneName = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$stimezoneName();
            if (realmGet$stimezoneName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stimezoneNameIndex, rowIndex, realmGet$stimezoneName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.stimezoneNameIndex, rowIndex, false);
            }
            String realmGet$sLanguage = ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$sLanguage();
            if (realmGet$sLanguage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sLanguageIndex, rowIndex, realmGet$sLanguage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sLanguageIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iLocationCountIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$iLocationCount(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bAnonymousIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$bAnonymous(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLongitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLongitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.dLatitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) object).realmGet$dLatitude(), false);
        }
    }

    public static com.peoplepowerco.virtuoso.models.PPUserInfoModel createDetachedCopy(com.peoplepowerco.virtuoso.models.PPUserInfoModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.PPUserInfoModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.PPUserInfoModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.PPUserInfoModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.PPUserInfoModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$sUserInfoId(realmSource.realmGet$sUserInfoId());
        unmanagedCopy.realmSet$sUserInfoName(realmSource.realmGet$sUserInfoName());
        unmanagedCopy.realmSet$sUserInfoLoId(realmSource.realmGet$sUserInfoLoId());
        unmanagedCopy.realmSet$sUserInfoLoName(realmSource.realmGet$sUserInfoLoName());
        unmanagedCopy.realmSet$sUserFirstName(realmSource.realmGet$sUserFirstName());
        unmanagedCopy.realmSet$sUserLastName(realmSource.realmGet$sUserLastName());
        unmanagedCopy.realmSet$sCommunityName(realmSource.realmGet$sCommunityName());
        unmanagedCopy.realmSet$sUserInfoLoEvent(realmSource.realmGet$sUserInfoLoEvent());
        unmanagedCopy.realmSet$sUserInfoStartDay(realmSource.realmGet$sUserInfoStartDay());
        unmanagedCopy.realmSet$sUserEmail(realmSource.realmGet$sUserEmail());
        unmanagedCopy.realmSet$sUserVerified(realmSource.realmGet$sUserVerified());
        unmanagedCopy.realmSet$nMailStatus(realmSource.realmGet$nMailStatus());
        unmanagedCopy.realmSet$nSmsStatus(realmSource.realmGet$nSmsStatus());
        unmanagedCopy.realmSet$nPhoneType(realmSource.realmGet$nPhoneType());
        unmanagedCopy.realmSet$sUserStatus(realmSource.realmGet$sUserStatus());
        unmanagedCopy.realmSet$sFileUploadPolicy(realmSource.realmGet$sFileUploadPolicy());
        unmanagedCopy.realmSet$sPhoneNumber(realmSource.realmGet$sPhoneNumber());
        unmanagedCopy.realmSet$stimezoneId(realmSource.realmGet$stimezoneId());
        unmanagedCopy.realmSet$stimezoneName(realmSource.realmGet$stimezoneName());
        unmanagedCopy.realmSet$sLanguage(realmSource.realmGet$sLanguage());
        unmanagedCopy.realmSet$iLocationCount(realmSource.realmGet$iLocationCount());
        unmanagedCopy.realmSet$bAnonymous(realmSource.realmGet$bAnonymous());
        unmanagedCopy.realmSet$dLongitude(realmSource.realmGet$dLongitude());
        unmanagedCopy.realmSet$dLatitude(realmSource.realmGet$dLatitude());

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.PPUserInfoModel update(Realm realm, PPUserInfoModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.PPUserInfoModel realmObject, com.peoplepowerco.virtuoso.models.PPUserInfoModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.sUserInfoIdIndex, realmObjectSource.realmGet$sUserInfoId());
        builder.addString(columnInfo.sUserInfoNameIndex, realmObjectSource.realmGet$sUserInfoName());
        builder.addString(columnInfo.sUserInfoLoIdIndex, realmObjectSource.realmGet$sUserInfoLoId());
        builder.addString(columnInfo.sUserInfoLoNameIndex, realmObjectSource.realmGet$sUserInfoLoName());
        builder.addString(columnInfo.sUserFirstNameIndex, realmObjectSource.realmGet$sUserFirstName());
        builder.addString(columnInfo.sUserLastNameIndex, realmObjectSource.realmGet$sUserLastName());
        builder.addString(columnInfo.sCommunityNameIndex, realmObjectSource.realmGet$sCommunityName());
        builder.addString(columnInfo.sUserInfoLoEventIndex, realmObjectSource.realmGet$sUserInfoLoEvent());
        builder.addString(columnInfo.sUserInfoStartDayIndex, realmObjectSource.realmGet$sUserInfoStartDay());
        builder.addString(columnInfo.sUserEmailIndex, realmObjectSource.realmGet$sUserEmail());
        builder.addBoolean(columnInfo.sUserVerifiedIndex, realmObjectSource.realmGet$sUserVerified());
        builder.addInteger(columnInfo.nMailStatusIndex, realmObjectSource.realmGet$nMailStatus());
        builder.addInteger(columnInfo.nSmsStatusIndex, realmObjectSource.realmGet$nSmsStatus());
        builder.addInteger(columnInfo.nPhoneTypeIndex, realmObjectSource.realmGet$nPhoneType());
        builder.addString(columnInfo.sUserStatusIndex, realmObjectSource.realmGet$sUserStatus());
        builder.addString(columnInfo.sFileUploadPolicyIndex, realmObjectSource.realmGet$sFileUploadPolicy());
        builder.addString(columnInfo.sPhoneNumberIndex, realmObjectSource.realmGet$sPhoneNumber());
        builder.addString(columnInfo.stimezoneIdIndex, realmObjectSource.realmGet$stimezoneId());
        builder.addString(columnInfo.stimezoneNameIndex, realmObjectSource.realmGet$stimezoneName());
        builder.addString(columnInfo.sLanguageIndex, realmObjectSource.realmGet$sLanguage());
        builder.addInteger(columnInfo.iLocationCountIndex, realmObjectSource.realmGet$iLocationCount());
        builder.addBoolean(columnInfo.bAnonymousIndex, realmObjectSource.realmGet$bAnonymous());
        builder.addDouble(columnInfo.dLongitudeIndex, realmObjectSource.realmGet$dLongitude());
        builder.addDouble(columnInfo.dLatitudeIndex, realmObjectSource.realmGet$dLatitude());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PPUserInfoModel = proxy[");
        stringBuilder.append("{sUserInfoId:");
        stringBuilder.append(realmGet$sUserInfoId() != null ? realmGet$sUserInfoId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserInfoName:");
        stringBuilder.append(realmGet$sUserInfoName() != null ? realmGet$sUserInfoName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserInfoLoId:");
        stringBuilder.append(realmGet$sUserInfoLoId() != null ? realmGet$sUserInfoLoId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserInfoLoName:");
        stringBuilder.append(realmGet$sUserInfoLoName() != null ? realmGet$sUserInfoLoName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserFirstName:");
        stringBuilder.append(realmGet$sUserFirstName() != null ? realmGet$sUserFirstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserLastName:");
        stringBuilder.append(realmGet$sUserLastName() != null ? realmGet$sUserLastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sCommunityName:");
        stringBuilder.append(realmGet$sCommunityName() != null ? realmGet$sCommunityName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserInfoLoEvent:");
        stringBuilder.append(realmGet$sUserInfoLoEvent() != null ? realmGet$sUserInfoLoEvent() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserInfoStartDay:");
        stringBuilder.append(realmGet$sUserInfoStartDay() != null ? realmGet$sUserInfoStartDay() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserEmail:");
        stringBuilder.append(realmGet$sUserEmail() != null ? realmGet$sUserEmail() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserVerified:");
        stringBuilder.append(realmGet$sUserVerified());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nMailStatus:");
        stringBuilder.append(realmGet$nMailStatus());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nSmsStatus:");
        stringBuilder.append(realmGet$nSmsStatus());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nPhoneType:");
        stringBuilder.append(realmGet$nPhoneType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sUserStatus:");
        stringBuilder.append(realmGet$sUserStatus() != null ? realmGet$sUserStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sFileUploadPolicy:");
        stringBuilder.append(realmGet$sFileUploadPolicy() != null ? realmGet$sFileUploadPolicy() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sPhoneNumber:");
        stringBuilder.append(realmGet$sPhoneNumber() != null ? realmGet$sPhoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stimezoneId:");
        stringBuilder.append(realmGet$stimezoneId() != null ? realmGet$stimezoneId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stimezoneName:");
        stringBuilder.append(realmGet$stimezoneName() != null ? realmGet$stimezoneName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sLanguage:");
        stringBuilder.append(realmGet$sLanguage() != null ? realmGet$sLanguage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iLocationCount:");
        stringBuilder.append(realmGet$iLocationCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bAnonymous:");
        stringBuilder.append(realmGet$bAnonymous());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dLongitude:");
        stringBuilder.append(realmGet$dLongitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dLatitude:");
        stringBuilder.append(realmGet$dLatitude());
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
        com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy aPPUserInfoModel = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPUserInfoModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPUserInfoModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPUserInfoModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
