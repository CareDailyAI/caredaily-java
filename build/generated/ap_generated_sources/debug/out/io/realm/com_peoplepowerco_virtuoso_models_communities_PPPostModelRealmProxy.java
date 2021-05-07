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
public class com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy extends com.peoplepowerco.virtuoso.models.communities.PPPostModel
    implements RealmObjectProxy, com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface {

    static final class PPPostModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long postIdIndex;
        long postTypeIndex;
        long statusIndex;
        long userIndex;
        long locationIndex;
        long addressIndex;
        long locationIdIndex;
        long communityIdIndex;
        long creationDateMsIndex;
        long eventDateMsIndex;
        long eventEndDateMsIndex;
        long nextEventDateMsIndex;
        long allDayIndex;
        long titleIndex;
        long topicIndex;
        long driveUrlIndex;
        long eventDateIndex;
        long eventEndDateIndex;
        long nextEventDateIndex;
        long durationIndex;
        long postTextIndex;
        long latitudeIndex;
        long longitudeIndex;
        long itemTypeIndex;
        long distanceIndex;
        long repeatIndex;
        long repeatEndDateIndex;
        long localFilePathIndex;
        long repeatEndDateMsIndex;
        long remindersIndex;
        long reactionsIndex;
        long commentsIndex;
        long filesIndex;

        PPPostModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(33);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PPPostModel");
            this.postIdIndex = addColumnDetails("postId", "postId", objectSchemaInfo);
            this.postTypeIndex = addColumnDetails("postType", "postType", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.locationIndex = addColumnDetails("location", "location", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", "address", objectSchemaInfo);
            this.locationIdIndex = addColumnDetails("locationId", "locationId", objectSchemaInfo);
            this.communityIdIndex = addColumnDetails("communityId", "communityId", objectSchemaInfo);
            this.creationDateMsIndex = addColumnDetails("creationDateMs", "creationDateMs", objectSchemaInfo);
            this.eventDateMsIndex = addColumnDetails("eventDateMs", "eventDateMs", objectSchemaInfo);
            this.eventEndDateMsIndex = addColumnDetails("eventEndDateMs", "eventEndDateMs", objectSchemaInfo);
            this.nextEventDateMsIndex = addColumnDetails("nextEventDateMs", "nextEventDateMs", objectSchemaInfo);
            this.allDayIndex = addColumnDetails("allDay", "allDay", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.topicIndex = addColumnDetails("topic", "topic", objectSchemaInfo);
            this.driveUrlIndex = addColumnDetails("driveUrl", "driveUrl", objectSchemaInfo);
            this.eventDateIndex = addColumnDetails("eventDate", "eventDate", objectSchemaInfo);
            this.eventEndDateIndex = addColumnDetails("eventEndDate", "eventEndDate", objectSchemaInfo);
            this.nextEventDateIndex = addColumnDetails("nextEventDate", "nextEventDate", objectSchemaInfo);
            this.durationIndex = addColumnDetails("duration", "duration", objectSchemaInfo);
            this.postTextIndex = addColumnDetails("postText", "postText", objectSchemaInfo);
            this.latitudeIndex = addColumnDetails("latitude", "latitude", objectSchemaInfo);
            this.longitudeIndex = addColumnDetails("longitude", "longitude", objectSchemaInfo);
            this.itemTypeIndex = addColumnDetails("itemType", "itemType", objectSchemaInfo);
            this.distanceIndex = addColumnDetails("distance", "distance", objectSchemaInfo);
            this.repeatIndex = addColumnDetails("repeat", "repeat", objectSchemaInfo);
            this.repeatEndDateIndex = addColumnDetails("repeatEndDate", "repeatEndDate", objectSchemaInfo);
            this.localFilePathIndex = addColumnDetails("localFilePath", "localFilePath", objectSchemaInfo);
            this.repeatEndDateMsIndex = addColumnDetails("repeatEndDateMs", "repeatEndDateMs", objectSchemaInfo);
            this.remindersIndex = addColumnDetails("reminders", "reminders", objectSchemaInfo);
            this.reactionsIndex = addColumnDetails("reactions", "reactions", objectSchemaInfo);
            this.commentsIndex = addColumnDetails("comments", "comments", objectSchemaInfo);
            this.filesIndex = addColumnDetails("files", "files", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PPPostModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PPPostModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PPPostModelColumnInfo src = (PPPostModelColumnInfo) rawSrc;
            final PPPostModelColumnInfo dst = (PPPostModelColumnInfo) rawDst;
            dst.postIdIndex = src.postIdIndex;
            dst.postTypeIndex = src.postTypeIndex;
            dst.statusIndex = src.statusIndex;
            dst.userIndex = src.userIndex;
            dst.locationIndex = src.locationIndex;
            dst.addressIndex = src.addressIndex;
            dst.locationIdIndex = src.locationIdIndex;
            dst.communityIdIndex = src.communityIdIndex;
            dst.creationDateMsIndex = src.creationDateMsIndex;
            dst.eventDateMsIndex = src.eventDateMsIndex;
            dst.eventEndDateMsIndex = src.eventEndDateMsIndex;
            dst.nextEventDateMsIndex = src.nextEventDateMsIndex;
            dst.allDayIndex = src.allDayIndex;
            dst.titleIndex = src.titleIndex;
            dst.topicIndex = src.topicIndex;
            dst.driveUrlIndex = src.driveUrlIndex;
            dst.eventDateIndex = src.eventDateIndex;
            dst.eventEndDateIndex = src.eventEndDateIndex;
            dst.nextEventDateIndex = src.nextEventDateIndex;
            dst.durationIndex = src.durationIndex;
            dst.postTextIndex = src.postTextIndex;
            dst.latitudeIndex = src.latitudeIndex;
            dst.longitudeIndex = src.longitudeIndex;
            dst.itemTypeIndex = src.itemTypeIndex;
            dst.distanceIndex = src.distanceIndex;
            dst.repeatIndex = src.repeatIndex;
            dst.repeatEndDateIndex = src.repeatEndDateIndex;
            dst.localFilePathIndex = src.localFilePathIndex;
            dst.repeatEndDateMsIndex = src.repeatEndDateMsIndex;
            dst.remindersIndex = src.remindersIndex;
            dst.reactionsIndex = src.reactionsIndex;
            dst.commentsIndex = src.commentsIndex;
            dst.filesIndex = src.filesIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PPPostModelColumnInfo columnInfo;
    private ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostModel> proxyState;
    private RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersRealmList;
    private RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsRealmList;
    private RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsRealmList;
    private RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesRealmList;

    com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PPPostModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.peoplepowerco.virtuoso.models.communities.PPPostModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'postId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$postType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.postTypeIndex);
    }

    @Override
    public void realmSet$postType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.postTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.postTypeIndex, value);
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
    public com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel realmGet$location() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.locationIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class, proxyState.getRow$realm().getLink(columnInfo.locationIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$location(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("location")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.locationIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.locationIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.locationIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.locationIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.addressIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class, proxyState.getRow$realm().getLink(columnInfo.addressIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$address(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("address")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.addressIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.addressIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.addressIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.addressIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
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
    public long realmGet$communityId() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.communityIdIndex);
    }

    @Override
    public void realmSet$communityId(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.communityIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.communityIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$creationDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.creationDateMsIndex);
    }

    @Override
    public void realmSet$creationDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.creationDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.creationDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$eventDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.eventDateMsIndex);
    }

    @Override
    public void realmSet$eventDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.eventDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.eventDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$eventEndDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.eventEndDateMsIndex);
    }

    @Override
    public void realmSet$eventEndDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.eventEndDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.eventEndDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$nextEventDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.nextEventDateMsIndex);
    }

    @Override
    public void realmSet$nextEventDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.nextEventDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.nextEventDateMsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$allDay() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.allDayIndex);
    }

    @Override
    public void realmSet$allDay(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.allDayIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.allDayIndex, value);
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
    public String realmGet$topic() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.topicIndex);
    }

    @Override
    public void realmSet$topic(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.topicIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.topicIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.topicIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.topicIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$driveUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.driveUrlIndex);
    }

    @Override
    public void realmSet$driveUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.driveUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.driveUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.driveUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.driveUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$eventDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.eventDateIndex);
    }

    @Override
    public void realmSet$eventDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.eventDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.eventDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.eventDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.eventDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$eventEndDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.eventEndDateIndex);
    }

    @Override
    public void realmSet$eventEndDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.eventEndDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.eventEndDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.eventEndDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.eventEndDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nextEventDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nextEventDateIndex);
    }

    @Override
    public void realmSet$nextEventDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nextEventDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nextEventDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nextEventDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nextEventDateIndex, value);
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
    public String realmGet$postText() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.postTextIndex);
    }

    @Override
    public void realmSet$postText(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.postTextIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.postTextIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.postTextIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.postTextIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$latitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitudeIndex);
    }

    @Override
    public void realmSet$latitude(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$longitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitudeIndex);
    }

    @Override
    public void realmSet$longitude(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$itemType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.itemTypeIndex);
    }

    @Override
    public void realmSet$itemType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.itemTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.itemTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$distance() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.distanceIndex);
    }

    @Override
    public void realmSet$distance(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.distanceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.distanceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.distanceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.distanceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$repeat() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.repeatIndex);
    }

    @Override
    public void realmSet$repeat(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.repeatIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.repeatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.repeatIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.repeatIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$repeatEndDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.repeatEndDateIndex);
    }

    @Override
    public void realmSet$repeatEndDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.repeatEndDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.repeatEndDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.repeatEndDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.repeatEndDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$localFilePath() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.localFilePathIndex);
    }

    @Override
    public void realmSet$localFilePath(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.localFilePathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.localFilePathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.localFilePathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.localFilePathIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$repeatEndDateMs() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.repeatEndDateMsIndex);
    }

    @Override
    public void realmSet$repeatEndDateMs(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.repeatEndDateMsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.repeatEndDateMsIndex, value);
    }

    @Override
    public RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> realmGet$reminders() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (remindersRealmList != null) {
            return remindersRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.remindersIndex);
            remindersRealmList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class, osList, proxyState.getRealm$realm());
            return remindersRealmList;
        }
    }

    @Override
    public void realmSet$reminders(RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("reminders")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> original = value;
                value = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>();
                for (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.remindersIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel linkedObject = value.get(i);
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
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
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

    @Override
    public RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> realmGet$comments() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (commentsRealmList != null) {
            return commentsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.commentsIndex);
            commentsRealmList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class, osList, proxyState.getRealm$realm());
            return commentsRealmList;
        }
    }

    @Override
    public void realmSet$comments(RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("comments")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> original = value;
                value = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>();
                for (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.commentsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel linkedObject = value.get(i);
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
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> realmGet$files() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (filesRealmList != null) {
            return filesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.filesIndex);
            filesRealmList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class, osList, proxyState.getRealm$realm());
            return filesRealmList;
        }
    }

    @Override
    public void realmSet$files(RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("files")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> original = value;
                value = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>();
                for (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.filesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel linkedObject = value.get(i);
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
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PPPostModel", 33, 0);
        builder.addPersistedProperty("postId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("postType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "PPPostUserModel");
        builder.addPersistedLinkProperty("location", RealmFieldType.OBJECT, "PPPostLocationModel");
        builder.addPersistedLinkProperty("address", RealmFieldType.OBJECT, "PPPostAddressModel");
        builder.addPersistedProperty("locationId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("communityId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("creationDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("eventDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("eventEndDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nextEventDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("allDay", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("topic", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("driveUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("eventDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("eventEndDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nextEventDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("duration", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("postText", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("latitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("longitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("itemType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("distance", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("repeat", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("repeatEndDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("localFilePath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("repeatEndDateMs", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("reminders", RealmFieldType.LIST, "PPPostReminderModel");
        builder.addPersistedLinkProperty("reactions", RealmFieldType.LIST, "PPPostReactionModel");
        builder.addPersistedLinkProperty("comments", RealmFieldType.LIST, "PPPostCommentModel");
        builder.addPersistedLinkProperty("files", RealmFieldType.LIST, "PPPostFileModel");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PPPostModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PPPostModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PPPostModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PPPostModel";
    }

    @SuppressWarnings("cast")
    public static com.peoplepowerco.virtuoso.models.communities.PPPostModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(7);
        com.peoplepowerco.virtuoso.models.communities.PPPostModel obj = null;
        if (update) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
            PPPostModelColumnInfo columnInfo = (PPPostModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
            long pkColumnIndex = columnInfo.postIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("postId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("postId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("user")) {
                excludeFields.add("user");
            }
            if (json.has("location")) {
                excludeFields.add("location");
            }
            if (json.has("address")) {
                excludeFields.add("address");
            }
            if (json.has("reminders")) {
                excludeFields.add("reminders");
            }
            if (json.has("reactions")) {
                excludeFields.add("reactions");
            }
            if (json.has("comments")) {
                excludeFields.add("comments");
            }
            if (json.has("files")) {
                excludeFields.add("files");
            }
            if (json.has("postId")) {
                if (json.isNull("postId")) {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy) realm.createObjectInternal(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class, json.getString("postId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'postId'.");
            }
        }

        final com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) obj;
        if (json.has("postType")) {
            if (json.isNull("postType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'postType' to null.");
            } else {
                objProxy.realmSet$postType((int) json.getInt("postType"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
            } else {
                objProxy.realmSet$status((int) json.getInt("status"));
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
        if (json.has("location")) {
            if (json.isNull("location")) {
                objProxy.realmSet$location(null);
            } else {
                com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("location"), update);
                objProxy.realmSet$location(locationObj);
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                objProxy.realmSet$address(null);
            } else {
                com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("address"), update);
                objProxy.realmSet$address(addressObj);
            }
        }
        if (json.has("locationId")) {
            if (json.isNull("locationId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
            } else {
                objProxy.realmSet$locationId((long) json.getLong("locationId"));
            }
        }
        if (json.has("communityId")) {
            if (json.isNull("communityId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'communityId' to null.");
            } else {
                objProxy.realmSet$communityId((long) json.getLong("communityId"));
            }
        }
        if (json.has("creationDateMs")) {
            if (json.isNull("creationDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'creationDateMs' to null.");
            } else {
                objProxy.realmSet$creationDateMs((long) json.getLong("creationDateMs"));
            }
        }
        if (json.has("eventDateMs")) {
            if (json.isNull("eventDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'eventDateMs' to null.");
            } else {
                objProxy.realmSet$eventDateMs((long) json.getLong("eventDateMs"));
            }
        }
        if (json.has("eventEndDateMs")) {
            if (json.isNull("eventEndDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'eventEndDateMs' to null.");
            } else {
                objProxy.realmSet$eventEndDateMs((long) json.getLong("eventEndDateMs"));
            }
        }
        if (json.has("nextEventDateMs")) {
            if (json.isNull("nextEventDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nextEventDateMs' to null.");
            } else {
                objProxy.realmSet$nextEventDateMs((long) json.getLong("nextEventDateMs"));
            }
        }
        if (json.has("allDay")) {
            if (json.isNull("allDay")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'allDay' to null.");
            } else {
                objProxy.realmSet$allDay((boolean) json.getBoolean("allDay"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("topic")) {
            if (json.isNull("topic")) {
                objProxy.realmSet$topic(null);
            } else {
                objProxy.realmSet$topic((String) json.getString("topic"));
            }
        }
        if (json.has("driveUrl")) {
            if (json.isNull("driveUrl")) {
                objProxy.realmSet$driveUrl(null);
            } else {
                objProxy.realmSet$driveUrl((String) json.getString("driveUrl"));
            }
        }
        if (json.has("eventDate")) {
            if (json.isNull("eventDate")) {
                objProxy.realmSet$eventDate(null);
            } else {
                objProxy.realmSet$eventDate((String) json.getString("eventDate"));
            }
        }
        if (json.has("eventEndDate")) {
            if (json.isNull("eventEndDate")) {
                objProxy.realmSet$eventEndDate(null);
            } else {
                objProxy.realmSet$eventEndDate((String) json.getString("eventEndDate"));
            }
        }
        if (json.has("nextEventDate")) {
            if (json.isNull("nextEventDate")) {
                objProxy.realmSet$nextEventDate(null);
            } else {
                objProxy.realmSet$nextEventDate((String) json.getString("nextEventDate"));
            }
        }
        if (json.has("duration")) {
            if (json.isNull("duration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'duration' to null.");
            } else {
                objProxy.realmSet$duration((long) json.getLong("duration"));
            }
        }
        if (json.has("postText")) {
            if (json.isNull("postText")) {
                objProxy.realmSet$postText(null);
            } else {
                objProxy.realmSet$postText((String) json.getString("postText"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
            } else {
                objProxy.realmSet$latitude((double) json.getDouble("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
            } else {
                objProxy.realmSet$longitude((double) json.getDouble("longitude"));
            }
        }
        if (json.has("itemType")) {
            if (json.isNull("itemType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'itemType' to null.");
            } else {
                objProxy.realmSet$itemType((int) json.getInt("itemType"));
            }
        }
        if (json.has("distance")) {
            if (json.isNull("distance")) {
                objProxy.realmSet$distance(null);
            } else {
                objProxy.realmSet$distance((String) json.getString("distance"));
            }
        }
        if (json.has("repeat")) {
            if (json.isNull("repeat")) {
                objProxy.realmSet$repeat(null);
            } else {
                objProxy.realmSet$repeat((String) json.getString("repeat"));
            }
        }
        if (json.has("repeatEndDate")) {
            if (json.isNull("repeatEndDate")) {
                objProxy.realmSet$repeatEndDate(null);
            } else {
                objProxy.realmSet$repeatEndDate((String) json.getString("repeatEndDate"));
            }
        }
        if (json.has("localFilePath")) {
            if (json.isNull("localFilePath")) {
                objProxy.realmSet$localFilePath(null);
            } else {
                objProxy.realmSet$localFilePath((String) json.getString("localFilePath"));
            }
        }
        if (json.has("repeatEndDateMs")) {
            if (json.isNull("repeatEndDateMs")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'repeatEndDateMs' to null.");
            } else {
                objProxy.realmSet$repeatEndDateMs((long) json.getLong("repeatEndDateMs"));
            }
        }
        if (json.has("reminders")) {
            if (json.isNull("reminders")) {
                objProxy.realmSet$reminders(null);
            } else {
                objProxy.realmGet$reminders().clear();
                JSONArray array = json.getJSONArray("reminders");
                for (int i = 0; i < array.length(); i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel item = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$reminders().add(item);
                }
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
        if (json.has("comments")) {
            if (json.isNull("comments")) {
                objProxy.realmSet$comments(null);
            } else {
                objProxy.realmGet$comments().clear();
                JSONArray array = json.getJSONArray("comments");
                for (int i = 0; i < array.length(); i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel item = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$comments().add(item);
                }
            }
        }
        if (json.has("files")) {
            if (json.isNull("files")) {
                objProxy.realmSet$files(null);
            } else {
                objProxy.realmGet$files().clear();
                JSONArray array = json.getJSONArray("files");
                for (int i = 0; i < array.length(); i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostFileModel item = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$files().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.peoplepowerco.virtuoso.models.communities.PPPostModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.peoplepowerco.virtuoso.models.communities.PPPostModel obj = new com.peoplepowerco.virtuoso.models.communities.PPPostModel();
        final com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface objProxy = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("postId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$postId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$postId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("postType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$postType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'postType' to null.");
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("location")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$location(null);
                } else {
                    com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$location(locationObj);
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                } else {
                    com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$address(addressObj);
                }
            } else if (name.equals("locationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$locationId((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'locationId' to null.");
                }
            } else if (name.equals("communityId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$communityId((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'communityId' to null.");
                }
            } else if (name.equals("creationDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$creationDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'creationDateMs' to null.");
                }
            } else if (name.equals("eventDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'eventDateMs' to null.");
                }
            } else if (name.equals("eventEndDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventEndDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'eventEndDateMs' to null.");
                }
            } else if (name.equals("nextEventDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nextEventDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'nextEventDateMs' to null.");
                }
            } else if (name.equals("allDay")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$allDay((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'allDay' to null.");
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("topic")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$topic((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$topic(null);
                }
            } else if (name.equals("driveUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$driveUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$driveUrl(null);
                }
            } else if (name.equals("eventDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$eventDate(null);
                }
            } else if (name.equals("eventEndDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventEndDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$eventEndDate(null);
                }
            } else if (name.equals("nextEventDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nextEventDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nextEventDate(null);
                }
            } else if (name.equals("duration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$duration((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'duration' to null.");
                }
            } else if (name.equals("postText")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$postText((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$postText(null);
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
                }
            } else if (name.equals("itemType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'itemType' to null.");
                }
            } else if (name.equals("distance")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$distance((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$distance(null);
                }
            } else if (name.equals("repeat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$repeat((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$repeat(null);
                }
            } else if (name.equals("repeatEndDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$repeatEndDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$repeatEndDate(null);
                }
            } else if (name.equals("localFilePath")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$localFilePath((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$localFilePath(null);
                }
            } else if (name.equals("repeatEndDateMs")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$repeatEndDateMs((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'repeatEndDateMs' to null.");
                }
            } else if (name.equals("reminders")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$reminders(null);
                } else {
                    objProxy.realmSet$reminders(new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel item = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$reminders().add(item);
                    }
                    reader.endArray();
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
            } else if (name.equals("comments")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$comments(null);
                } else {
                    objProxy.realmSet$comments(new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel item = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$comments().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("files")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$files(null);
                } else {
                    objProxy.realmSet$files(new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.peoplepowerco.virtuoso.models.communities.PPPostFileModel item = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$files().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'postId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class), false, Collections.<String>emptyList());
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy obj = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostModel copyOrUpdate(Realm realm, PPPostModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.peoplepowerco.virtuoso.models.communities.PPPostModel) cachedRealmObject;
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
            long pkColumnIndex = columnInfo.postIdIndex;
            String value = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postId();
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
                    realmObject = new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostModel copy(Realm realm, PPPostModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.peoplepowerco.virtuoso.models.communities.PPPostModel) cachedRealmObject;
        }

        com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.postIdIndex, realmObjectSource.realmGet$postId());
        builder.addInteger(columnInfo.postTypeIndex, realmObjectSource.realmGet$postType());
        builder.addInteger(columnInfo.statusIndex, realmObjectSource.realmGet$status());
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addInteger(columnInfo.communityIdIndex, realmObjectSource.realmGet$communityId());
        builder.addInteger(columnInfo.creationDateMsIndex, realmObjectSource.realmGet$creationDateMs());
        builder.addInteger(columnInfo.eventDateMsIndex, realmObjectSource.realmGet$eventDateMs());
        builder.addInteger(columnInfo.eventEndDateMsIndex, realmObjectSource.realmGet$eventEndDateMs());
        builder.addInteger(columnInfo.nextEventDateMsIndex, realmObjectSource.realmGet$nextEventDateMs());
        builder.addBoolean(columnInfo.allDayIndex, realmObjectSource.realmGet$allDay());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.topicIndex, realmObjectSource.realmGet$topic());
        builder.addString(columnInfo.driveUrlIndex, realmObjectSource.realmGet$driveUrl());
        builder.addString(columnInfo.eventDateIndex, realmObjectSource.realmGet$eventDate());
        builder.addString(columnInfo.eventEndDateIndex, realmObjectSource.realmGet$eventEndDate());
        builder.addString(columnInfo.nextEventDateIndex, realmObjectSource.realmGet$nextEventDate());
        builder.addInteger(columnInfo.durationIndex, realmObjectSource.realmGet$duration());
        builder.addString(columnInfo.postTextIndex, realmObjectSource.realmGet$postText());
        builder.addDouble(columnInfo.latitudeIndex, realmObjectSource.realmGet$latitude());
        builder.addDouble(columnInfo.longitudeIndex, realmObjectSource.realmGet$longitude());
        builder.addInteger(columnInfo.itemTypeIndex, realmObjectSource.realmGet$itemType());
        builder.addString(columnInfo.distanceIndex, realmObjectSource.realmGet$distance());
        builder.addString(columnInfo.repeatIndex, realmObjectSource.realmGet$repeat());
        builder.addString(columnInfo.repeatEndDateIndex, realmObjectSource.realmGet$repeatEndDate());
        builder.addString(columnInfo.localFilePathIndex, realmObjectSource.realmGet$localFilePath());
        builder.addInteger(columnInfo.repeatEndDateMsIndex, realmObjectSource.realmGet$repeatEndDateMs());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
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

        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = realmObjectSource.realmGet$location();
        if (locationObj == null) {
            realmObjectCopy.realmSet$location(null);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel cachelocation = (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) cache.get(locationObj);
            if (cachelocation != null) {
                realmObjectCopy.realmSet$location(cachelocation);
            } else {
                realmObjectCopy.realmSet$location(com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class), locationObj, update, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = realmObjectSource.realmGet$address();
        if (addressObj == null) {
            realmObjectCopy.realmSet$address(null);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel cacheaddress = (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) cache.get(addressObj);
            if (cacheaddress != null) {
                realmObjectCopy.realmSet$address(cacheaddress);
            } else {
                realmObjectCopy.realmSet$address(com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class), addressObj, update, cache, flags));
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersList = realmObjectSource.realmGet$reminders();
        if (remindersList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersRealmList = realmObjectCopy.realmGet$reminders();
            remindersRealmList.clear();
            for (int i = 0; i < remindersList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem = remindersList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel cachereminders = (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) cache.get(remindersItem);
                if (cachereminders != null) {
                    remindersRealmList.add(cachereminders);
                } else {
                    remindersRealmList.add(com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class), remindersItem, update, cache, flags));
                }
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

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsList = realmObjectSource.realmGet$comments();
        if (commentsList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsRealmList = realmObjectCopy.realmGet$comments();
            commentsRealmList.clear();
            for (int i = 0; i < commentsList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem = commentsList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel cachecomments = (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) cache.get(commentsItem);
                if (cachecomments != null) {
                    commentsRealmList.add(cachecomments);
                } else {
                    commentsRealmList.add(com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class), commentsItem, update, cache, flags));
                }
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesList = realmObjectSource.realmGet$files();
        if (filesList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesRealmList = realmObjectCopy.realmGet$files();
            filesRealmList.clear();
            for (int i = 0; i < filesList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem = filesList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel cachefiles = (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) cache.get(filesItem);
                if (cachefiles != null) {
                    filesRealmList.add(cachefiles);
                } else {
                    filesRealmList.add(com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class), filesItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostModelColumnInfo columnInfo = (PPPostModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long pkColumnIndex = columnInfo.postIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.postTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$status(), false);

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$location();
        if (locationObj != null) {
            Long cachelocation = cache.get(locationObj);
            if (cachelocation == null) {
                cachelocation = com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insert(realm, locationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$address();
        if (addressObj != null) {
            Long cacheaddress = cache.get(addressObj);
            if (cacheaddress == null) {
                cacheaddress = com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insert(realm, addressObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.addressIndex, rowIndex, cacheaddress, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$locationId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.communityIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$communityId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.creationDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$creationDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.eventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.eventEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nextEventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDateMs(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.allDayIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$allDay(), false);
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$topic = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$topic();
        if (realmGet$topic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.topicIndex, rowIndex, realmGet$topic, false);
        }
        String realmGet$driveUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$driveUrl();
        if (realmGet$driveUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.driveUrlIndex, rowIndex, realmGet$driveUrl, false);
        }
        String realmGet$eventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDate();
        if (realmGet$eventDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventDateIndex, rowIndex, realmGet$eventDate, false);
        }
        String realmGet$eventEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDate();
        if (realmGet$eventEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventEndDateIndex, rowIndex, realmGet$eventEndDate, false);
        }
        String realmGet$nextEventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDate();
        if (realmGet$nextEventDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nextEventDateIndex, rowIndex, realmGet$nextEventDate, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$duration(), false);
        String realmGet$postText = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postText();
        if (realmGet$postText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postTextIndex, rowIndex, realmGet$postText, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$latitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$longitude(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.itemTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$itemType(), false);
        String realmGet$distance = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$distance();
        if (realmGet$distance != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.distanceIndex, rowIndex, realmGet$distance, false);
        }
        String realmGet$repeat = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeat();
        if (realmGet$repeat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.repeatIndex, rowIndex, realmGet$repeat, false);
        }
        String realmGet$repeatEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDate();
        if (realmGet$repeatEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.repeatEndDateIndex, rowIndex, realmGet$repeatEndDate, false);
        }
        String realmGet$localFilePath = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$localFilePath();
        if (realmGet$localFilePath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localFilePathIndex, rowIndex, realmGet$localFilePath, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.repeatEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDateMs(), false);

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reminders();
        if (remindersList != null) {
            OsList remindersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.remindersIndex);
            for (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem : remindersList) {
                Long cacheItemIndexreminders = cache.get(remindersItem);
                if (cacheItemIndexreminders == null) {
                    cacheItemIndexreminders = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insert(realm, remindersItem, cache);
                }
                remindersOsList.addRow(cacheItemIndexreminders);
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reactions();
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

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$comments();
        if (commentsList != null) {
            OsList commentsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.commentsIndex);
            for (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem : commentsList) {
                Long cacheItemIndexcomments = cache.get(commentsItem);
                if (cacheItemIndexcomments == null) {
                    cacheItemIndexcomments = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insert(realm, commentsItem, cache);
                }
                commentsOsList.addRow(cacheItemIndexcomments);
            }
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$files();
        if (filesList != null) {
            OsList filesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.filesIndex);
            for (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem : filesList) {
                Long cacheItemIndexfiles = cache.get(filesItem);
                if (cacheItemIndexfiles == null) {
                    cacheItemIndexfiles = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insert(realm, filesItem, cache);
                }
                filesOsList.addRow(cacheItemIndexfiles);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostModelColumnInfo columnInfo = (PPPostModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long pkColumnIndex = columnInfo.postIdIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.postTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$status(), false);

            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$location();
            if (locationObj != null) {
                Long cachelocation = cache.get(locationObj);
                if (cachelocation == null) {
                    cachelocation = com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insert(realm, locationObj, cache);
                }
                table.setLink(columnInfo.locationIndex, rowIndex, cachelocation, false);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$address();
            if (addressObj != null) {
                Long cacheaddress = cache.get(addressObj);
                if (cacheaddress == null) {
                    cacheaddress = com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insert(realm, addressObj, cache);
                }
                table.setLink(columnInfo.addressIndex, rowIndex, cacheaddress, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$locationId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.communityIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$communityId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.creationDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$creationDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.eventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.eventEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nextEventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDateMs(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.allDayIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$allDay(), false);
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$topic = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$topic();
            if (realmGet$topic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.topicIndex, rowIndex, realmGet$topic, false);
            }
            String realmGet$driveUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$driveUrl();
            if (realmGet$driveUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.driveUrlIndex, rowIndex, realmGet$driveUrl, false);
            }
            String realmGet$eventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDate();
            if (realmGet$eventDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventDateIndex, rowIndex, realmGet$eventDate, false);
            }
            String realmGet$eventEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDate();
            if (realmGet$eventEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventEndDateIndex, rowIndex, realmGet$eventEndDate, false);
            }
            String realmGet$nextEventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDate();
            if (realmGet$nextEventDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nextEventDateIndex, rowIndex, realmGet$nextEventDate, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$duration(), false);
            String realmGet$postText = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postText();
            if (realmGet$postText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postTextIndex, rowIndex, realmGet$postText, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$latitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$longitude(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.itemTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$itemType(), false);
            String realmGet$distance = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$distance();
            if (realmGet$distance != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.distanceIndex, rowIndex, realmGet$distance, false);
            }
            String realmGet$repeat = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeat();
            if (realmGet$repeat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.repeatIndex, rowIndex, realmGet$repeat, false);
            }
            String realmGet$repeatEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDate();
            if (realmGet$repeatEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.repeatEndDateIndex, rowIndex, realmGet$repeatEndDate, false);
            }
            String realmGet$localFilePath = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$localFilePath();
            if (realmGet$localFilePath != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localFilePathIndex, rowIndex, realmGet$localFilePath, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.repeatEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDateMs(), false);

            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reminders();
            if (remindersList != null) {
                OsList remindersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.remindersIndex);
                for (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem : remindersList) {
                    Long cacheItemIndexreminders = cache.get(remindersItem);
                    if (cacheItemIndexreminders == null) {
                        cacheItemIndexreminders = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insert(realm, remindersItem, cache);
                    }
                    remindersOsList.addRow(cacheItemIndexreminders);
                }
            }

            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reactions();
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

            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$comments();
            if (commentsList != null) {
                OsList commentsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.commentsIndex);
                for (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem : commentsList) {
                    Long cacheItemIndexcomments = cache.get(commentsItem);
                    if (cacheItemIndexcomments == null) {
                        cacheItemIndexcomments = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insert(realm, commentsItem, cache);
                    }
                    commentsOsList.addRow(cacheItemIndexcomments);
                }
            }

            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$files();
            if (filesList != null) {
                OsList filesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.filesIndex);
                for (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem : filesList) {
                    Long cacheItemIndexfiles = cache.get(filesItem);
                    if (cacheItemIndexfiles == null) {
                        cacheItemIndexfiles = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insert(realm, filesItem, cache);
                    }
                    filesOsList.addRow(cacheItemIndexfiles);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.peoplepowerco.virtuoso.models.communities.PPPostModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostModelColumnInfo columnInfo = (PPPostModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long pkColumnIndex = columnInfo.postIdIndex;
        String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.postTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$status(), false);

        com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$location();
        if (locationObj != null) {
            Long cachelocation = cache.get(locationObj);
            if (cachelocation == null) {
                cachelocation = com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insertOrUpdate(realm, locationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.locationIndex, rowIndex);
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$address();
        if (addressObj != null) {
            Long cacheaddress = cache.get(addressObj);
            if (cacheaddress == null) {
                cacheaddress = com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insertOrUpdate(realm, addressObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.addressIndex, rowIndex, cacheaddress, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.addressIndex, rowIndex);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$locationId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.communityIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$communityId(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.creationDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$creationDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.eventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.eventEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDateMs(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.nextEventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDateMs(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.allDayIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$allDay(), false);
        String realmGet$title = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$topic = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$topic();
        if (realmGet$topic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.topicIndex, rowIndex, realmGet$topic, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.topicIndex, rowIndex, false);
        }
        String realmGet$driveUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$driveUrl();
        if (realmGet$driveUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.driveUrlIndex, rowIndex, realmGet$driveUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.driveUrlIndex, rowIndex, false);
        }
        String realmGet$eventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDate();
        if (realmGet$eventDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventDateIndex, rowIndex, realmGet$eventDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.eventDateIndex, rowIndex, false);
        }
        String realmGet$eventEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDate();
        if (realmGet$eventEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventEndDateIndex, rowIndex, realmGet$eventEndDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.eventEndDateIndex, rowIndex, false);
        }
        String realmGet$nextEventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDate();
        if (realmGet$nextEventDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nextEventDateIndex, rowIndex, realmGet$nextEventDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nextEventDateIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$duration(), false);
        String realmGet$postText = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postText();
        if (realmGet$postText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postTextIndex, rowIndex, realmGet$postText, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.postTextIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$latitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$longitude(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.itemTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$itemType(), false);
        String realmGet$distance = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$distance();
        if (realmGet$distance != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.distanceIndex, rowIndex, realmGet$distance, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.distanceIndex, rowIndex, false);
        }
        String realmGet$repeat = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeat();
        if (realmGet$repeat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.repeatIndex, rowIndex, realmGet$repeat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.repeatIndex, rowIndex, false);
        }
        String realmGet$repeatEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDate();
        if (realmGet$repeatEndDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.repeatEndDateIndex, rowIndex, realmGet$repeatEndDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.repeatEndDateIndex, rowIndex, false);
        }
        String realmGet$localFilePath = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$localFilePath();
        if (realmGet$localFilePath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localFilePathIndex, rowIndex, realmGet$localFilePath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.localFilePathIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.repeatEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDateMs(), false);

        OsList remindersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.remindersIndex);
        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reminders();
        if (remindersList != null && remindersList.size() == remindersOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = remindersList.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem = remindersList.get(i);
                Long cacheItemIndexreminders = cache.get(remindersItem);
                if (cacheItemIndexreminders == null) {
                    cacheItemIndexreminders = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, remindersItem, cache);
                }
                remindersOsList.setRow(i, cacheItemIndexreminders);
            }
        } else {
            remindersOsList.removeAll();
            if (remindersList != null) {
                for (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem : remindersList) {
                    Long cacheItemIndexreminders = cache.get(remindersItem);
                    if (cacheItemIndexreminders == null) {
                        cacheItemIndexreminders = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, remindersItem, cache);
                    }
                    remindersOsList.addRow(cacheItemIndexreminders);
                }
            }
        }


        OsList reactionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.reactionsIndex);
        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reactions();
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


        OsList commentsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.commentsIndex);
        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$comments();
        if (commentsList != null && commentsList.size() == commentsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = commentsList.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem = commentsList.get(i);
                Long cacheItemIndexcomments = cache.get(commentsItem);
                if (cacheItemIndexcomments == null) {
                    cacheItemIndexcomments = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, commentsItem, cache);
                }
                commentsOsList.setRow(i, cacheItemIndexcomments);
            }
        } else {
            commentsOsList.removeAll();
            if (commentsList != null) {
                for (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem : commentsList) {
                    Long cacheItemIndexcomments = cache.get(commentsItem);
                    if (cacheItemIndexcomments == null) {
                        cacheItemIndexcomments = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, commentsItem, cache);
                    }
                    commentsOsList.addRow(cacheItemIndexcomments);
                }
            }
        }


        OsList filesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.filesIndex);
        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$files();
        if (filesList != null && filesList.size() == filesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = filesList.size();
            for (int i = 0; i < objects; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem = filesList.get(i);
                Long cacheItemIndexfiles = cache.get(filesItem);
                if (cacheItemIndexfiles == null) {
                    cacheItemIndexfiles = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, filesItem, cache);
                }
                filesOsList.setRow(i, cacheItemIndexfiles);
            }
        } else {
            filesOsList.removeAll();
            if (filesList != null) {
                for (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem : filesList) {
                    Long cacheItemIndexfiles = cache.get(filesItem);
                    if (cacheItemIndexfiles == null) {
                        cacheItemIndexfiles = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, filesItem, cache);
                    }
                    filesOsList.addRow(cacheItemIndexfiles);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long tableNativePtr = table.getNativePtr();
        PPPostModelColumnInfo columnInfo = (PPPostModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        long pkColumnIndex = columnInfo.postIdIndex;
        com.peoplepowerco.virtuoso.models.communities.PPPostModel object = null;
        while (objects.hasNext()) {
            object = (com.peoplepowerco.virtuoso.models.communities.PPPostModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.postTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postType(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$status(), false);

            com.peoplepowerco.virtuoso.models.communities.PPPostUserModel userObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$location();
            if (locationObj != null) {
                Long cachelocation = cache.get(locationObj);
                if (cachelocation == null) {
                    cachelocation = com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insertOrUpdate(realm, locationObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.locationIndex, rowIndex);
            }

            com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$address();
            if (addressObj != null) {
                Long cacheaddress = cache.get(addressObj);
                if (cacheaddress == null) {
                    cacheaddress = com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insertOrUpdate(realm, addressObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.addressIndex, rowIndex, cacheaddress, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.addressIndex, rowIndex);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.locationIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$locationId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.communityIdIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$communityId(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.creationDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$creationDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.eventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.eventEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDateMs(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.nextEventDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDateMs(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.allDayIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$allDay(), false);
            String realmGet$title = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$topic = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$topic();
            if (realmGet$topic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.topicIndex, rowIndex, realmGet$topic, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.topicIndex, rowIndex, false);
            }
            String realmGet$driveUrl = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$driveUrl();
            if (realmGet$driveUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.driveUrlIndex, rowIndex, realmGet$driveUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.driveUrlIndex, rowIndex, false);
            }
            String realmGet$eventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventDate();
            if (realmGet$eventDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventDateIndex, rowIndex, realmGet$eventDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.eventDateIndex, rowIndex, false);
            }
            String realmGet$eventEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$eventEndDate();
            if (realmGet$eventEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventEndDateIndex, rowIndex, realmGet$eventEndDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.eventEndDateIndex, rowIndex, false);
            }
            String realmGet$nextEventDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$nextEventDate();
            if (realmGet$nextEventDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nextEventDateIndex, rowIndex, realmGet$nextEventDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nextEventDateIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$duration(), false);
            String realmGet$postText = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$postText();
            if (realmGet$postText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postTextIndex, rowIndex, realmGet$postText, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.postTextIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$latitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$longitude(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.itemTypeIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$itemType(), false);
            String realmGet$distance = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$distance();
            if (realmGet$distance != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.distanceIndex, rowIndex, realmGet$distance, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.distanceIndex, rowIndex, false);
            }
            String realmGet$repeat = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeat();
            if (realmGet$repeat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.repeatIndex, rowIndex, realmGet$repeat, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.repeatIndex, rowIndex, false);
            }
            String realmGet$repeatEndDate = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDate();
            if (realmGet$repeatEndDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.repeatEndDateIndex, rowIndex, realmGet$repeatEndDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.repeatEndDateIndex, rowIndex, false);
            }
            String realmGet$localFilePath = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$localFilePath();
            if (realmGet$localFilePath != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localFilePathIndex, rowIndex, realmGet$localFilePath, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.localFilePathIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.repeatEndDateMsIndex, rowIndex, ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$repeatEndDateMs(), false);

            OsList remindersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.remindersIndex);
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reminders();
            if (remindersList != null && remindersList.size() == remindersOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = remindersList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem = remindersList.get(i);
                    Long cacheItemIndexreminders = cache.get(remindersItem);
                    if (cacheItemIndexreminders == null) {
                        cacheItemIndexreminders = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, remindersItem, cache);
                    }
                    remindersOsList.setRow(i, cacheItemIndexreminders);
                }
            } else {
                remindersOsList.removeAll();
                if (remindersList != null) {
                    for (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem : remindersList) {
                        Long cacheItemIndexreminders = cache.get(remindersItem);
                        if (cacheItemIndexreminders == null) {
                            cacheItemIndexreminders = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, remindersItem, cache);
                        }
                        remindersOsList.addRow(cacheItemIndexreminders);
                    }
                }
            }


            OsList reactionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.reactionsIndex);
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> reactionsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$reactions();
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


            OsList commentsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.commentsIndex);
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$comments();
            if (commentsList != null && commentsList.size() == commentsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = commentsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem = commentsList.get(i);
                    Long cacheItemIndexcomments = cache.get(commentsItem);
                    if (cacheItemIndexcomments == null) {
                        cacheItemIndexcomments = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, commentsItem, cache);
                    }
                    commentsOsList.setRow(i, cacheItemIndexcomments);
                }
            } else {
                commentsOsList.removeAll();
                if (commentsList != null) {
                    for (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem : commentsList) {
                        Long cacheItemIndexcomments = cache.get(commentsItem);
                        if (cacheItemIndexcomments == null) {
                            cacheItemIndexcomments = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, commentsItem, cache);
                        }
                        commentsOsList.addRow(cacheItemIndexcomments);
                    }
                }
            }


            OsList filesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.filesIndex);
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesList = ((com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) object).realmGet$files();
            if (filesList != null && filesList.size() == filesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = filesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem = filesList.get(i);
                    Long cacheItemIndexfiles = cache.get(filesItem);
                    if (cacheItemIndexfiles == null) {
                        cacheItemIndexfiles = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, filesItem, cache);
                    }
                    filesOsList.setRow(i, cacheItemIndexfiles);
                }
            } else {
                filesOsList.removeAll();
                if (filesList != null) {
                    for (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem : filesList) {
                        Long cacheItemIndexfiles = cache.get(filesItem);
                        if (cacheItemIndexfiles == null) {
                            cacheItemIndexfiles = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, filesItem, cache);
                        }
                        filesOsList.addRow(cacheItemIndexfiles);
                    }
                }
            }

        }
    }

    public static com.peoplepowerco.virtuoso.models.communities.PPPostModel createDetachedCopy(com.peoplepowerco.virtuoso.models.communities.PPPostModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.peoplepowerco.virtuoso.models.communities.PPPostModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.peoplepowerco.virtuoso.models.communities.PPPostModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.peoplepowerco.virtuoso.models.communities.PPPostModel) cachedObject.object;
            }
            unmanagedObject = (com.peoplepowerco.virtuoso.models.communities.PPPostModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface unmanagedCopy = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) unmanagedObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface realmSource = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$postId(realmSource.realmGet$postId());
        unmanagedCopy.realmSet$postType(realmSource.realmGet$postType());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));

        // Deep copy of location
        unmanagedCopy.realmSet$location(com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createDetachedCopy(realmSource.realmGet$location(), currentDepth + 1, maxDepth, cache));

        // Deep copy of address
        unmanagedCopy.realmSet$address(com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createDetachedCopy(realmSource.realmGet$address(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$locationId(realmSource.realmGet$locationId());
        unmanagedCopy.realmSet$communityId(realmSource.realmGet$communityId());
        unmanagedCopy.realmSet$creationDateMs(realmSource.realmGet$creationDateMs());
        unmanagedCopy.realmSet$eventDateMs(realmSource.realmGet$eventDateMs());
        unmanagedCopy.realmSet$eventEndDateMs(realmSource.realmGet$eventEndDateMs());
        unmanagedCopy.realmSet$nextEventDateMs(realmSource.realmGet$nextEventDateMs());
        unmanagedCopy.realmSet$allDay(realmSource.realmGet$allDay());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$topic(realmSource.realmGet$topic());
        unmanagedCopy.realmSet$driveUrl(realmSource.realmGet$driveUrl());
        unmanagedCopy.realmSet$eventDate(realmSource.realmGet$eventDate());
        unmanagedCopy.realmSet$eventEndDate(realmSource.realmGet$eventEndDate());
        unmanagedCopy.realmSet$nextEventDate(realmSource.realmGet$nextEventDate());
        unmanagedCopy.realmSet$duration(realmSource.realmGet$duration());
        unmanagedCopy.realmSet$postText(realmSource.realmGet$postText());
        unmanagedCopy.realmSet$latitude(realmSource.realmGet$latitude());
        unmanagedCopy.realmSet$longitude(realmSource.realmGet$longitude());
        unmanagedCopy.realmSet$itemType(realmSource.realmGet$itemType());
        unmanagedCopy.realmSet$distance(realmSource.realmGet$distance());
        unmanagedCopy.realmSet$repeat(realmSource.realmGet$repeat());
        unmanagedCopy.realmSet$repeatEndDate(realmSource.realmGet$repeatEndDate());
        unmanagedCopy.realmSet$localFilePath(realmSource.realmGet$localFilePath());
        unmanagedCopy.realmSet$repeatEndDateMs(realmSource.realmGet$repeatEndDateMs());

        // Deep copy of reminders
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$reminders(null);
        } else {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> managedremindersList = realmSource.realmGet$reminders();
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> unmanagedremindersList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>();
            unmanagedCopy.realmSet$reminders(unmanagedremindersList);
            int nextDepth = currentDepth + 1;
            int size = managedremindersList.size();
            for (int i = 0; i < size; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel item = com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createDetachedCopy(managedremindersList.get(i), nextDepth, maxDepth, cache);
                unmanagedremindersList.add(item);
            }
        }

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

        // Deep copy of comments
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$comments(null);
        } else {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> managedcommentsList = realmSource.realmGet$comments();
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> unmanagedcommentsList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>();
            unmanagedCopy.realmSet$comments(unmanagedcommentsList);
            int nextDepth = currentDepth + 1;
            int size = managedcommentsList.size();
            for (int i = 0; i < size; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel item = com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createDetachedCopy(managedcommentsList.get(i), nextDepth, maxDepth, cache);
                unmanagedcommentsList.add(item);
            }
        }

        // Deep copy of files
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$files(null);
        } else {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> managedfilesList = realmSource.realmGet$files();
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> unmanagedfilesList = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>();
            unmanagedCopy.realmSet$files(unmanagedfilesList);
            int nextDepth = currentDepth + 1;
            int size = managedfilesList.size();
            for (int i = 0; i < size; i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel item = com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createDetachedCopy(managedfilesList.get(i), nextDepth, maxDepth, cache);
                unmanagedfilesList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.peoplepowerco.virtuoso.models.communities.PPPostModel update(Realm realm, PPPostModelColumnInfo columnInfo, com.peoplepowerco.virtuoso.models.communities.PPPostModel realmObject, com.peoplepowerco.virtuoso.models.communities.PPPostModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface realmObjectTarget = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) realmObject;
        com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface realmObjectSource = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.postIdIndex, realmObjectSource.realmGet$postId());
        builder.addInteger(columnInfo.postTypeIndex, realmObjectSource.realmGet$postType());
        builder.addInteger(columnInfo.statusIndex, realmObjectSource.realmGet$status());

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

        com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel locationObj = realmObjectSource.realmGet$location();
        if (locationObj == null) {
            builder.addNull(columnInfo.locationIndex);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel cachelocation = (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) cache.get(locationObj);
            if (cachelocation != null) {
                builder.addObject(columnInfo.locationIndex, cachelocation);
            } else {
                builder.addObject(columnInfo.locationIndex, com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class), locationObj, true, cache, flags));
            }
        }

        com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel addressObj = realmObjectSource.realmGet$address();
        if (addressObj == null) {
            builder.addNull(columnInfo.addressIndex);
        } else {
            com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel cacheaddress = (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) cache.get(addressObj);
            if (cacheaddress != null) {
                builder.addObject(columnInfo.addressIndex, cacheaddress);
            } else {
                builder.addObject(columnInfo.addressIndex, com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class), addressObj, true, cache, flags));
            }
        }
        builder.addInteger(columnInfo.locationIdIndex, realmObjectSource.realmGet$locationId());
        builder.addInteger(columnInfo.communityIdIndex, realmObjectSource.realmGet$communityId());
        builder.addInteger(columnInfo.creationDateMsIndex, realmObjectSource.realmGet$creationDateMs());
        builder.addInteger(columnInfo.eventDateMsIndex, realmObjectSource.realmGet$eventDateMs());
        builder.addInteger(columnInfo.eventEndDateMsIndex, realmObjectSource.realmGet$eventEndDateMs());
        builder.addInteger(columnInfo.nextEventDateMsIndex, realmObjectSource.realmGet$nextEventDateMs());
        builder.addBoolean(columnInfo.allDayIndex, realmObjectSource.realmGet$allDay());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.topicIndex, realmObjectSource.realmGet$topic());
        builder.addString(columnInfo.driveUrlIndex, realmObjectSource.realmGet$driveUrl());
        builder.addString(columnInfo.eventDateIndex, realmObjectSource.realmGet$eventDate());
        builder.addString(columnInfo.eventEndDateIndex, realmObjectSource.realmGet$eventEndDate());
        builder.addString(columnInfo.nextEventDateIndex, realmObjectSource.realmGet$nextEventDate());
        builder.addInteger(columnInfo.durationIndex, realmObjectSource.realmGet$duration());
        builder.addString(columnInfo.postTextIndex, realmObjectSource.realmGet$postText());
        builder.addDouble(columnInfo.latitudeIndex, realmObjectSource.realmGet$latitude());
        builder.addDouble(columnInfo.longitudeIndex, realmObjectSource.realmGet$longitude());
        builder.addInteger(columnInfo.itemTypeIndex, realmObjectSource.realmGet$itemType());
        builder.addString(columnInfo.distanceIndex, realmObjectSource.realmGet$distance());
        builder.addString(columnInfo.repeatIndex, realmObjectSource.realmGet$repeat());
        builder.addString(columnInfo.repeatEndDateIndex, realmObjectSource.realmGet$repeatEndDate());
        builder.addString(columnInfo.localFilePathIndex, realmObjectSource.realmGet$localFilePath());
        builder.addInteger(columnInfo.repeatEndDateMsIndex, realmObjectSource.realmGet$repeatEndDateMs());

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersList = realmObjectSource.realmGet$reminders();
        if (remindersList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel> remindersManagedCopy = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>();
            for (int i = 0; i < remindersList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel remindersItem = remindersList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel cachereminders = (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) cache.get(remindersItem);
                if (cachereminders != null) {
                    remindersManagedCopy.add(cachereminders);
                } else {
                    remindersManagedCopy.add(com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class), remindersItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.remindersIndex, remindersManagedCopy);
        } else {
            builder.addObjectList(columnInfo.remindersIndex, new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel>());
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

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsList = realmObjectSource.realmGet$comments();
        if (commentsList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel> commentsManagedCopy = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>();
            for (int i = 0; i < commentsList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel commentsItem = commentsList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel cachecomments = (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) cache.get(commentsItem);
                if (cachecomments != null) {
                    commentsManagedCopy.add(cachecomments);
                } else {
                    commentsManagedCopy.add(com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class), commentsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.commentsIndex, commentsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.commentsIndex, new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel>());
        }

        RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesList = realmObjectSource.realmGet$files();
        if (filesList != null) {
            RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel> filesManagedCopy = new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>();
            for (int i = 0; i < filesList.size(); i++) {
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel filesItem = filesList.get(i);
                com.peoplepowerco.virtuoso.models.communities.PPPostFileModel cachefiles = (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) cache.get(filesItem);
                if (cachefiles != null) {
                    filesManagedCopy.add(cachefiles);
                } else {
                    filesManagedCopy.add(com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.copyOrUpdate(realm, (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class), filesItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.filesIndex, filesManagedCopy);
        } else {
            builder.addObjectList(columnInfo.filesIndex, new RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostFileModel>());
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
        StringBuilder stringBuilder = new StringBuilder("PPPostModel = proxy[");
        stringBuilder.append("{postId:");
        stringBuilder.append(realmGet$postId() != null ? realmGet$postId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{postType:");
        stringBuilder.append(realmGet$postType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "PPPostUserModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{location:");
        stringBuilder.append(realmGet$location() != null ? "PPPostLocationModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? "PPPostAddressModel" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locationId:");
        stringBuilder.append(realmGet$locationId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{communityId:");
        stringBuilder.append(realmGet$communityId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{creationDateMs:");
        stringBuilder.append(realmGet$creationDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eventDateMs:");
        stringBuilder.append(realmGet$eventDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eventEndDateMs:");
        stringBuilder.append(realmGet$eventEndDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nextEventDateMs:");
        stringBuilder.append(realmGet$nextEventDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{allDay:");
        stringBuilder.append(realmGet$allDay());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{topic:");
        stringBuilder.append(realmGet$topic() != null ? realmGet$topic() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{driveUrl:");
        stringBuilder.append(realmGet$driveUrl() != null ? realmGet$driveUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eventDate:");
        stringBuilder.append(realmGet$eventDate() != null ? realmGet$eventDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eventEndDate:");
        stringBuilder.append(realmGet$eventEndDate() != null ? realmGet$eventEndDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nextEventDate:");
        stringBuilder.append(realmGet$nextEventDate() != null ? realmGet$nextEventDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{duration:");
        stringBuilder.append(realmGet$duration());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{postText:");
        stringBuilder.append(realmGet$postText() != null ? realmGet$postText() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemType:");
        stringBuilder.append(realmGet$itemType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{distance:");
        stringBuilder.append(realmGet$distance() != null ? realmGet$distance() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{repeat:");
        stringBuilder.append(realmGet$repeat() != null ? realmGet$repeat() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{repeatEndDate:");
        stringBuilder.append(realmGet$repeatEndDate() != null ? realmGet$repeatEndDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{localFilePath:");
        stringBuilder.append(realmGet$localFilePath() != null ? realmGet$localFilePath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{repeatEndDateMs:");
        stringBuilder.append(realmGet$repeatEndDateMs());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reminders:");
        stringBuilder.append("RealmList<PPPostReminderModel>[").append(realmGet$reminders().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reactions:");
        stringBuilder.append("RealmList<PPPostReactionModel>[").append(realmGet$reactions().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comments:");
        stringBuilder.append("RealmList<PPPostCommentModel>[").append(realmGet$comments().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{files:");
        stringBuilder.append("RealmList<PPPostFileModel>[").append(realmGet$files().size()).append("]");
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
        com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy aPPPostModel = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPPPostModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPPPostModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPPPostModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
