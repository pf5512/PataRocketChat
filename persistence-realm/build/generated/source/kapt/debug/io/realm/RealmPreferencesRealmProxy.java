package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
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
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class RealmPreferencesRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmPreferences
    implements RealmObjectProxy, RealmPreferencesRealmProxyInterface {

    static final class RealmPreferencesColumnInfo extends ColumnInfo {
        long idIndex;
        long newRoomNotificationIndex;
        long newMessageNotificationIndex;
        long useEmojisIndex;
        long convertAsciiEmojiIndex;
        long saveMobileBandwidthIndex;
        long collapseMediaByDefaultIndex;
        long unreadRoomsModeIndex;
        long autoImageLoadIndex;
        long emailNotificationModeIndex;
        long unreadAlertIndex;
        long desktopNotificationDurationIndex;
        long viewModeIndex;
        long hideUsernamesIndex;
        long hideAvatarsIndex;
        long hideFlexTabIndex;

        RealmPreferencesColumnInfo(OsSchemaInfo schemaInfo) {
            super(16);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmPreferences");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.newRoomNotificationIndex = addColumnDetails("newRoomNotification", objectSchemaInfo);
            this.newMessageNotificationIndex = addColumnDetails("newMessageNotification", objectSchemaInfo);
            this.useEmojisIndex = addColumnDetails("useEmojis", objectSchemaInfo);
            this.convertAsciiEmojiIndex = addColumnDetails("convertAsciiEmoji", objectSchemaInfo);
            this.saveMobileBandwidthIndex = addColumnDetails("saveMobileBandwidth", objectSchemaInfo);
            this.collapseMediaByDefaultIndex = addColumnDetails("collapseMediaByDefault", objectSchemaInfo);
            this.unreadRoomsModeIndex = addColumnDetails("unreadRoomsMode", objectSchemaInfo);
            this.autoImageLoadIndex = addColumnDetails("autoImageLoad", objectSchemaInfo);
            this.emailNotificationModeIndex = addColumnDetails("emailNotificationMode", objectSchemaInfo);
            this.unreadAlertIndex = addColumnDetails("unreadAlert", objectSchemaInfo);
            this.desktopNotificationDurationIndex = addColumnDetails("desktopNotificationDuration", objectSchemaInfo);
            this.viewModeIndex = addColumnDetails("viewMode", objectSchemaInfo);
            this.hideUsernamesIndex = addColumnDetails("hideUsernames", objectSchemaInfo);
            this.hideAvatarsIndex = addColumnDetails("hideAvatars", objectSchemaInfo);
            this.hideFlexTabIndex = addColumnDetails("hideFlexTab", objectSchemaInfo);
        }

        RealmPreferencesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmPreferencesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmPreferencesColumnInfo src = (RealmPreferencesColumnInfo) rawSrc;
            final RealmPreferencesColumnInfo dst = (RealmPreferencesColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.newRoomNotificationIndex = src.newRoomNotificationIndex;
            dst.newMessageNotificationIndex = src.newMessageNotificationIndex;
            dst.useEmojisIndex = src.useEmojisIndex;
            dst.convertAsciiEmojiIndex = src.convertAsciiEmojiIndex;
            dst.saveMobileBandwidthIndex = src.saveMobileBandwidthIndex;
            dst.collapseMediaByDefaultIndex = src.collapseMediaByDefaultIndex;
            dst.unreadRoomsModeIndex = src.unreadRoomsModeIndex;
            dst.autoImageLoadIndex = src.autoImageLoadIndex;
            dst.emailNotificationModeIndex = src.emailNotificationModeIndex;
            dst.unreadAlertIndex = src.unreadAlertIndex;
            dst.desktopNotificationDurationIndex = src.desktopNotificationDurationIndex;
            dst.viewModeIndex = src.viewModeIndex;
            dst.hideUsernamesIndex = src.hideUsernamesIndex;
            dst.hideAvatarsIndex = src.hideAvatarsIndex;
            dst.hideFlexTabIndex = src.hideFlexTabIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(16);
        fieldNames.add("id");
        fieldNames.add("newRoomNotification");
        fieldNames.add("newMessageNotification");
        fieldNames.add("useEmojis");
        fieldNames.add("convertAsciiEmoji");
        fieldNames.add("saveMobileBandwidth");
        fieldNames.add("collapseMediaByDefault");
        fieldNames.add("unreadRoomsMode");
        fieldNames.add("autoImageLoad");
        fieldNames.add("emailNotificationMode");
        fieldNames.add("unreadAlert");
        fieldNames.add("desktopNotificationDuration");
        fieldNames.add("viewMode");
        fieldNames.add("hideUsernames");
        fieldNames.add("hideAvatars");
        fieldNames.add("hideFlexTab");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmPreferencesColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmPreferences> proxyState;

    RealmPreferencesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmPreferencesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmPreferences>(this);
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
    public String realmGet$newRoomNotification() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.newRoomNotificationIndex);
    }

    @Override
    public void realmSet$newRoomNotification(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.newRoomNotificationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.newRoomNotificationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.newRoomNotificationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.newRoomNotificationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$newMessageNotification() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.newMessageNotificationIndex);
    }

    @Override
    public void realmSet$newMessageNotification(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.newMessageNotificationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.newMessageNotificationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.newMessageNotificationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.newMessageNotificationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$useEmojis() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.useEmojisIndex);
    }

    @Override
    public void realmSet$useEmojis(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.useEmojisIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.useEmojisIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$convertAsciiEmoji() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.convertAsciiEmojiIndex);
    }

    @Override
    public void realmSet$convertAsciiEmoji(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.convertAsciiEmojiIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.convertAsciiEmojiIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$saveMobileBandwidth() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.saveMobileBandwidthIndex);
    }

    @Override
    public void realmSet$saveMobileBandwidth(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.saveMobileBandwidthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.saveMobileBandwidthIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$collapseMediaByDefault() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.collapseMediaByDefaultIndex);
    }

    @Override
    public void realmSet$collapseMediaByDefault(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.collapseMediaByDefaultIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.collapseMediaByDefaultIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$unreadRoomsMode() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.unreadRoomsModeIndex);
    }

    @Override
    public void realmSet$unreadRoomsMode(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.unreadRoomsModeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.unreadRoomsModeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$autoImageLoad() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.autoImageLoadIndex);
    }

    @Override
    public void realmSet$autoImageLoad(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.autoImageLoadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.autoImageLoadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$emailNotificationMode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailNotificationModeIndex);
    }

    @Override
    public void realmSet$emailNotificationMode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailNotificationModeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailNotificationModeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailNotificationModeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailNotificationModeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$unreadAlert() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.unreadAlertIndex);
    }

    @Override
    public void realmSet$unreadAlert(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.unreadAlertIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.unreadAlertIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$desktopNotificationDuration() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.desktopNotificationDurationIndex);
    }

    @Override
    public void realmSet$desktopNotificationDuration(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.desktopNotificationDurationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.desktopNotificationDurationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$viewMode() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.viewModeIndex);
    }

    @Override
    public void realmSet$viewMode(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.viewModeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.viewModeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$hideUsernames() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.hideUsernamesIndex);
    }

    @Override
    public void realmSet$hideUsernames(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.hideUsernamesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.hideUsernamesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$hideAvatars() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.hideAvatarsIndex);
    }

    @Override
    public void realmSet$hideAvatars(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.hideAvatarsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.hideAvatarsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$hideFlexTab() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.hideFlexTabIndex);
    }

    @Override
    public void realmSet$hideFlexTab(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.hideFlexTabIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.hideFlexTabIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmPreferences", 16, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("newRoomNotification", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("newMessageNotification", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("useEmojis", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("convertAsciiEmoji", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("saveMobileBandwidth", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("collapseMediaByDefault", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("unreadRoomsMode", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("autoImageLoad", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("emailNotificationMode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("unreadAlert", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("desktopNotificationDuration", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("viewMode", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("hideUsernames", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("hideAvatars", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("hideFlexTab", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmPreferencesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmPreferencesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmPreferences";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmPreferences createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.ddp.RealmPreferences obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
            RealmPreferencesColumnInfo columnInfo = (RealmPreferencesColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmPreferencesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.RealmPreferencesRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmPreferencesRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final RealmPreferencesRealmProxyInterface objProxy = (RealmPreferencesRealmProxyInterface) obj;
        if (json.has("newRoomNotification")) {
            if (json.isNull("newRoomNotification")) {
                objProxy.realmSet$newRoomNotification(null);
            } else {
                objProxy.realmSet$newRoomNotification((String) json.getString("newRoomNotification"));
            }
        }
        if (json.has("newMessageNotification")) {
            if (json.isNull("newMessageNotification")) {
                objProxy.realmSet$newMessageNotification(null);
            } else {
                objProxy.realmSet$newMessageNotification((String) json.getString("newMessageNotification"));
            }
        }
        if (json.has("useEmojis")) {
            if (json.isNull("useEmojis")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'useEmojis' to null.");
            } else {
                objProxy.realmSet$useEmojis((boolean) json.getBoolean("useEmojis"));
            }
        }
        if (json.has("convertAsciiEmoji")) {
            if (json.isNull("convertAsciiEmoji")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'convertAsciiEmoji' to null.");
            } else {
                objProxy.realmSet$convertAsciiEmoji((boolean) json.getBoolean("convertAsciiEmoji"));
            }
        }
        if (json.has("saveMobileBandwidth")) {
            if (json.isNull("saveMobileBandwidth")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'saveMobileBandwidth' to null.");
            } else {
                objProxy.realmSet$saveMobileBandwidth((boolean) json.getBoolean("saveMobileBandwidth"));
            }
        }
        if (json.has("collapseMediaByDefault")) {
            if (json.isNull("collapseMediaByDefault")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'collapseMediaByDefault' to null.");
            } else {
                objProxy.realmSet$collapseMediaByDefault((boolean) json.getBoolean("collapseMediaByDefault"));
            }
        }
        if (json.has("unreadRoomsMode")) {
            if (json.isNull("unreadRoomsMode")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unreadRoomsMode' to null.");
            } else {
                objProxy.realmSet$unreadRoomsMode((boolean) json.getBoolean("unreadRoomsMode"));
            }
        }
        if (json.has("autoImageLoad")) {
            if (json.isNull("autoImageLoad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'autoImageLoad' to null.");
            } else {
                objProxy.realmSet$autoImageLoad((boolean) json.getBoolean("autoImageLoad"));
            }
        }
        if (json.has("emailNotificationMode")) {
            if (json.isNull("emailNotificationMode")) {
                objProxy.realmSet$emailNotificationMode(null);
            } else {
                objProxy.realmSet$emailNotificationMode((String) json.getString("emailNotificationMode"));
            }
        }
        if (json.has("unreadAlert")) {
            if (json.isNull("unreadAlert")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unreadAlert' to null.");
            } else {
                objProxy.realmSet$unreadAlert((boolean) json.getBoolean("unreadAlert"));
            }
        }
        if (json.has("desktopNotificationDuration")) {
            if (json.isNull("desktopNotificationDuration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'desktopNotificationDuration' to null.");
            } else {
                objProxy.realmSet$desktopNotificationDuration((int) json.getInt("desktopNotificationDuration"));
            }
        }
        if (json.has("viewMode")) {
            if (json.isNull("viewMode")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'viewMode' to null.");
            } else {
                objProxy.realmSet$viewMode((int) json.getInt("viewMode"));
            }
        }
        if (json.has("hideUsernames")) {
            if (json.isNull("hideUsernames")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hideUsernames' to null.");
            } else {
                objProxy.realmSet$hideUsernames((boolean) json.getBoolean("hideUsernames"));
            }
        }
        if (json.has("hideAvatars")) {
            if (json.isNull("hideAvatars")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hideAvatars' to null.");
            } else {
                objProxy.realmSet$hideAvatars((boolean) json.getBoolean("hideAvatars"));
            }
        }
        if (json.has("hideFlexTab")) {
            if (json.isNull("hideFlexTab")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hideFlexTab' to null.");
            } else {
                objProxy.realmSet$hideFlexTab((boolean) json.getBoolean("hideFlexTab"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmPreferences createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmPreferences obj = new chat.rocket.persistence.realm.models.ddp.RealmPreferences();
        final RealmPreferencesRealmProxyInterface objProxy = (RealmPreferencesRealmProxyInterface) obj;
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
            } else if (name.equals("newRoomNotification")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$newRoomNotification((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$newRoomNotification(null);
                }
            } else if (name.equals("newMessageNotification")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$newMessageNotification((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$newMessageNotification(null);
                }
            } else if (name.equals("useEmojis")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$useEmojis((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'useEmojis' to null.");
                }
            } else if (name.equals("convertAsciiEmoji")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$convertAsciiEmoji((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'convertAsciiEmoji' to null.");
                }
            } else if (name.equals("saveMobileBandwidth")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$saveMobileBandwidth((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'saveMobileBandwidth' to null.");
                }
            } else if (name.equals("collapseMediaByDefault")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$collapseMediaByDefault((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'collapseMediaByDefault' to null.");
                }
            } else if (name.equals("unreadRoomsMode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unreadRoomsMode((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unreadRoomsMode' to null.");
                }
            } else if (name.equals("autoImageLoad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$autoImageLoad((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'autoImageLoad' to null.");
                }
            } else if (name.equals("emailNotificationMode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$emailNotificationMode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$emailNotificationMode(null);
                }
            } else if (name.equals("unreadAlert")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unreadAlert((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unreadAlert' to null.");
                }
            } else if (name.equals("desktopNotificationDuration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$desktopNotificationDuration((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'desktopNotificationDuration' to null.");
                }
            } else if (name.equals("viewMode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$viewMode((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'viewMode' to null.");
                }
            } else if (name.equals("hideUsernames")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hideUsernames((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hideUsernames' to null.");
                }
            } else if (name.equals("hideAvatars")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hideAvatars((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hideAvatars' to null.");
                }
            } else if (name.equals("hideFlexTab")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hideFlexTab((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hideFlexTab' to null.");
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

    public static chat.rocket.persistence.realm.models.ddp.RealmPreferences copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPreferences object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmPreferences) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmPreferences realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
            RealmPreferencesColumnInfo columnInfo = (RealmPreferencesColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((RealmPreferencesRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmPreferencesRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmPreferences copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPreferences newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmPreferences) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmPreferences realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class, ((RealmPreferencesRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmPreferencesRealmProxyInterface realmObjectSource = (RealmPreferencesRealmProxyInterface) newObject;
        RealmPreferencesRealmProxyInterface realmObjectCopy = (RealmPreferencesRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$newRoomNotification(realmObjectSource.realmGet$newRoomNotification());
        realmObjectCopy.realmSet$newMessageNotification(realmObjectSource.realmGet$newMessageNotification());
        realmObjectCopy.realmSet$useEmojis(realmObjectSource.realmGet$useEmojis());
        realmObjectCopy.realmSet$convertAsciiEmoji(realmObjectSource.realmGet$convertAsciiEmoji());
        realmObjectCopy.realmSet$saveMobileBandwidth(realmObjectSource.realmGet$saveMobileBandwidth());
        realmObjectCopy.realmSet$collapseMediaByDefault(realmObjectSource.realmGet$collapseMediaByDefault());
        realmObjectCopy.realmSet$unreadRoomsMode(realmObjectSource.realmGet$unreadRoomsMode());
        realmObjectCopy.realmSet$autoImageLoad(realmObjectSource.realmGet$autoImageLoad());
        realmObjectCopy.realmSet$emailNotificationMode(realmObjectSource.realmGet$emailNotificationMode());
        realmObjectCopy.realmSet$unreadAlert(realmObjectSource.realmGet$unreadAlert());
        realmObjectCopy.realmSet$desktopNotificationDuration(realmObjectSource.realmGet$desktopNotificationDuration());
        realmObjectCopy.realmSet$viewMode(realmObjectSource.realmGet$viewMode());
        realmObjectCopy.realmSet$hideUsernames(realmObjectSource.realmGet$hideUsernames());
        realmObjectCopy.realmSet$hideAvatars(realmObjectSource.realmGet$hideAvatars());
        realmObjectCopy.realmSet$hideFlexTab(realmObjectSource.realmGet$hideFlexTab());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPreferences object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long tableNativePtr = table.getNativePtr();
        RealmPreferencesColumnInfo columnInfo = (RealmPreferencesColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((RealmPreferencesRealmProxyInterface) object).realmGet$id();
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
        String realmGet$newRoomNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newRoomNotification();
        if (realmGet$newRoomNotification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.newRoomNotificationIndex, rowIndex, realmGet$newRoomNotification, false);
        }
        String realmGet$newMessageNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newMessageNotification();
        if (realmGet$newMessageNotification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.newMessageNotificationIndex, rowIndex, realmGet$newMessageNotification, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.useEmojisIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$useEmojis(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.convertAsciiEmojiIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$convertAsciiEmoji(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.saveMobileBandwidthIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$saveMobileBandwidth(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.collapseMediaByDefaultIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$collapseMediaByDefault(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadRoomsModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadRoomsMode(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.autoImageLoadIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$autoImageLoad(), false);
        String realmGet$emailNotificationMode = ((RealmPreferencesRealmProxyInterface) object).realmGet$emailNotificationMode();
        if (realmGet$emailNotificationMode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailNotificationModeIndex, rowIndex, realmGet$emailNotificationMode, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadAlertIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadAlert(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.desktopNotificationDurationIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$desktopNotificationDuration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.viewModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$viewMode(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hideUsernamesIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideUsernames(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hideAvatarsIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideAvatars(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hideFlexTabIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideFlexTab(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long tableNativePtr = table.getNativePtr();
        RealmPreferencesColumnInfo columnInfo = (RealmPreferencesColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long pkColumnIndex = columnInfo.idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmPreferences object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmPreferences) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmPreferencesRealmProxyInterface) object).realmGet$id();
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
            String realmGet$newRoomNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newRoomNotification();
            if (realmGet$newRoomNotification != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.newRoomNotificationIndex, rowIndex, realmGet$newRoomNotification, false);
            }
            String realmGet$newMessageNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newMessageNotification();
            if (realmGet$newMessageNotification != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.newMessageNotificationIndex, rowIndex, realmGet$newMessageNotification, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.useEmojisIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$useEmojis(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.convertAsciiEmojiIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$convertAsciiEmoji(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.saveMobileBandwidthIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$saveMobileBandwidth(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.collapseMediaByDefaultIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$collapseMediaByDefault(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadRoomsModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadRoomsMode(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.autoImageLoadIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$autoImageLoad(), false);
            String realmGet$emailNotificationMode = ((RealmPreferencesRealmProxyInterface) object).realmGet$emailNotificationMode();
            if (realmGet$emailNotificationMode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailNotificationModeIndex, rowIndex, realmGet$emailNotificationMode, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadAlertIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadAlert(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.desktopNotificationDurationIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$desktopNotificationDuration(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.viewModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$viewMode(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hideUsernamesIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideUsernames(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hideAvatarsIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideAvatars(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hideFlexTabIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideFlexTab(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPreferences object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long tableNativePtr = table.getNativePtr();
        RealmPreferencesColumnInfo columnInfo = (RealmPreferencesColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((RealmPreferencesRealmProxyInterface) object).realmGet$id();
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
        String realmGet$newRoomNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newRoomNotification();
        if (realmGet$newRoomNotification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.newRoomNotificationIndex, rowIndex, realmGet$newRoomNotification, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.newRoomNotificationIndex, rowIndex, false);
        }
        String realmGet$newMessageNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newMessageNotification();
        if (realmGet$newMessageNotification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.newMessageNotificationIndex, rowIndex, realmGet$newMessageNotification, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.newMessageNotificationIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.useEmojisIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$useEmojis(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.convertAsciiEmojiIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$convertAsciiEmoji(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.saveMobileBandwidthIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$saveMobileBandwidth(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.collapseMediaByDefaultIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$collapseMediaByDefault(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadRoomsModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadRoomsMode(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.autoImageLoadIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$autoImageLoad(), false);
        String realmGet$emailNotificationMode = ((RealmPreferencesRealmProxyInterface) object).realmGet$emailNotificationMode();
        if (realmGet$emailNotificationMode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailNotificationModeIndex, rowIndex, realmGet$emailNotificationMode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailNotificationModeIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadAlertIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadAlert(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.desktopNotificationDurationIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$desktopNotificationDuration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.viewModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$viewMode(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hideUsernamesIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideUsernames(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hideAvatarsIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideAvatars(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hideFlexTabIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideFlexTab(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long tableNativePtr = table.getNativePtr();
        RealmPreferencesColumnInfo columnInfo = (RealmPreferencesColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        long pkColumnIndex = columnInfo.idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmPreferences object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmPreferences) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmPreferencesRealmProxyInterface) object).realmGet$id();
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
            String realmGet$newRoomNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newRoomNotification();
            if (realmGet$newRoomNotification != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.newRoomNotificationIndex, rowIndex, realmGet$newRoomNotification, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.newRoomNotificationIndex, rowIndex, false);
            }
            String realmGet$newMessageNotification = ((RealmPreferencesRealmProxyInterface) object).realmGet$newMessageNotification();
            if (realmGet$newMessageNotification != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.newMessageNotificationIndex, rowIndex, realmGet$newMessageNotification, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.newMessageNotificationIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.useEmojisIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$useEmojis(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.convertAsciiEmojiIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$convertAsciiEmoji(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.saveMobileBandwidthIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$saveMobileBandwidth(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.collapseMediaByDefaultIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$collapseMediaByDefault(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadRoomsModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadRoomsMode(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.autoImageLoadIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$autoImageLoad(), false);
            String realmGet$emailNotificationMode = ((RealmPreferencesRealmProxyInterface) object).realmGet$emailNotificationMode();
            if (realmGet$emailNotificationMode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailNotificationModeIndex, rowIndex, realmGet$emailNotificationMode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailNotificationModeIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.unreadAlertIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$unreadAlert(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.desktopNotificationDurationIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$desktopNotificationDuration(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.viewModeIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$viewMode(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hideUsernamesIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideUsernames(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hideAvatarsIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideAvatars(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hideFlexTabIndex, rowIndex, ((RealmPreferencesRealmProxyInterface) object).realmGet$hideFlexTab(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmPreferences createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmPreferences realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmPreferences unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmPreferences();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmPreferences) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmPreferences) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmPreferencesRealmProxyInterface unmanagedCopy = (RealmPreferencesRealmProxyInterface) unmanagedObject;
        RealmPreferencesRealmProxyInterface realmSource = (RealmPreferencesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$newRoomNotification(realmSource.realmGet$newRoomNotification());
        unmanagedCopy.realmSet$newMessageNotification(realmSource.realmGet$newMessageNotification());
        unmanagedCopy.realmSet$useEmojis(realmSource.realmGet$useEmojis());
        unmanagedCopy.realmSet$convertAsciiEmoji(realmSource.realmGet$convertAsciiEmoji());
        unmanagedCopy.realmSet$saveMobileBandwidth(realmSource.realmGet$saveMobileBandwidth());
        unmanagedCopy.realmSet$collapseMediaByDefault(realmSource.realmGet$collapseMediaByDefault());
        unmanagedCopy.realmSet$unreadRoomsMode(realmSource.realmGet$unreadRoomsMode());
        unmanagedCopy.realmSet$autoImageLoad(realmSource.realmGet$autoImageLoad());
        unmanagedCopy.realmSet$emailNotificationMode(realmSource.realmGet$emailNotificationMode());
        unmanagedCopy.realmSet$unreadAlert(realmSource.realmGet$unreadAlert());
        unmanagedCopy.realmSet$desktopNotificationDuration(realmSource.realmGet$desktopNotificationDuration());
        unmanagedCopy.realmSet$viewMode(realmSource.realmGet$viewMode());
        unmanagedCopy.realmSet$hideUsernames(realmSource.realmGet$hideUsernames());
        unmanagedCopy.realmSet$hideAvatars(realmSource.realmGet$hideAvatars());
        unmanagedCopy.realmSet$hideFlexTab(realmSource.realmGet$hideFlexTab());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmPreferences update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPreferences realmObject, chat.rocket.persistence.realm.models.ddp.RealmPreferences newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmPreferencesRealmProxyInterface realmObjectTarget = (RealmPreferencesRealmProxyInterface) realmObject;
        RealmPreferencesRealmProxyInterface realmObjectSource = (RealmPreferencesRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$newRoomNotification(realmObjectSource.realmGet$newRoomNotification());
        realmObjectTarget.realmSet$newMessageNotification(realmObjectSource.realmGet$newMessageNotification());
        realmObjectTarget.realmSet$useEmojis(realmObjectSource.realmGet$useEmojis());
        realmObjectTarget.realmSet$convertAsciiEmoji(realmObjectSource.realmGet$convertAsciiEmoji());
        realmObjectTarget.realmSet$saveMobileBandwidth(realmObjectSource.realmGet$saveMobileBandwidth());
        realmObjectTarget.realmSet$collapseMediaByDefault(realmObjectSource.realmGet$collapseMediaByDefault());
        realmObjectTarget.realmSet$unreadRoomsMode(realmObjectSource.realmGet$unreadRoomsMode());
        realmObjectTarget.realmSet$autoImageLoad(realmObjectSource.realmGet$autoImageLoad());
        realmObjectTarget.realmSet$emailNotificationMode(realmObjectSource.realmGet$emailNotificationMode());
        realmObjectTarget.realmSet$unreadAlert(realmObjectSource.realmGet$unreadAlert());
        realmObjectTarget.realmSet$desktopNotificationDuration(realmObjectSource.realmGet$desktopNotificationDuration());
        realmObjectTarget.realmSet$viewMode(realmObjectSource.realmGet$viewMode());
        realmObjectTarget.realmSet$hideUsernames(realmObjectSource.realmGet$hideUsernames());
        realmObjectTarget.realmSet$hideAvatars(realmObjectSource.realmGet$hideAvatars());
        realmObjectTarget.realmSet$hideFlexTab(realmObjectSource.realmGet$hideFlexTab());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmPreferences = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{newRoomNotification:");
        stringBuilder.append(realmGet$newRoomNotification() != null ? realmGet$newRoomNotification() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{newMessageNotification:");
        stringBuilder.append(realmGet$newMessageNotification() != null ? realmGet$newMessageNotification() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{useEmojis:");
        stringBuilder.append(realmGet$useEmojis());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{convertAsciiEmoji:");
        stringBuilder.append(realmGet$convertAsciiEmoji());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{saveMobileBandwidth:");
        stringBuilder.append(realmGet$saveMobileBandwidth());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{collapseMediaByDefault:");
        stringBuilder.append(realmGet$collapseMediaByDefault());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unreadRoomsMode:");
        stringBuilder.append(realmGet$unreadRoomsMode());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{autoImageLoad:");
        stringBuilder.append(realmGet$autoImageLoad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{emailNotificationMode:");
        stringBuilder.append(realmGet$emailNotificationMode() != null ? realmGet$emailNotificationMode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unreadAlert:");
        stringBuilder.append(realmGet$unreadAlert());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{desktopNotificationDuration:");
        stringBuilder.append(realmGet$desktopNotificationDuration());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{viewMode:");
        stringBuilder.append(realmGet$viewMode());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hideUsernames:");
        stringBuilder.append(realmGet$hideUsernames());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hideAvatars:");
        stringBuilder.append(realmGet$hideAvatars());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hideFlexTab:");
        stringBuilder.append(realmGet$hideFlexTab());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
