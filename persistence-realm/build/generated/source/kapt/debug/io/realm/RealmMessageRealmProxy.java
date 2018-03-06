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
public class RealmMessageRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmMessage
    implements RealmObjectProxy, RealmMessageRealmProxyInterface {

    static final class RealmMessageColumnInfo extends ColumnInfo {
        long _idIndex;
        long tIndex;
        long ridIndex;
        long syncstateIndex;
        long tsIndex;
        long msgIndex;
        long uIndex;
        long groupableIndex;
        long aliasIndex;
        long avatarIndex;
        long attachmentsIndex;
        long urlsIndex;
        long editedAtIndex;

        RealmMessageColumnInfo(OsSchemaInfo schemaInfo) {
            super(13);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmMessage");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.tIndex = addColumnDetails("t", objectSchemaInfo);
            this.ridIndex = addColumnDetails("rid", objectSchemaInfo);
            this.syncstateIndex = addColumnDetails("syncstate", objectSchemaInfo);
            this.tsIndex = addColumnDetails("ts", objectSchemaInfo);
            this.msgIndex = addColumnDetails("msg", objectSchemaInfo);
            this.uIndex = addColumnDetails("u", objectSchemaInfo);
            this.groupableIndex = addColumnDetails("groupable", objectSchemaInfo);
            this.aliasIndex = addColumnDetails("alias", objectSchemaInfo);
            this.avatarIndex = addColumnDetails("avatar", objectSchemaInfo);
            this.attachmentsIndex = addColumnDetails("attachments", objectSchemaInfo);
            this.urlsIndex = addColumnDetails("urls", objectSchemaInfo);
            this.editedAtIndex = addColumnDetails("editedAt", objectSchemaInfo);
        }

        RealmMessageColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmMessageColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmMessageColumnInfo src = (RealmMessageColumnInfo) rawSrc;
            final RealmMessageColumnInfo dst = (RealmMessageColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.tIndex = src.tIndex;
            dst.ridIndex = src.ridIndex;
            dst.syncstateIndex = src.syncstateIndex;
            dst.tsIndex = src.tsIndex;
            dst.msgIndex = src.msgIndex;
            dst.uIndex = src.uIndex;
            dst.groupableIndex = src.groupableIndex;
            dst.aliasIndex = src.aliasIndex;
            dst.avatarIndex = src.avatarIndex;
            dst.attachmentsIndex = src.attachmentsIndex;
            dst.urlsIndex = src.urlsIndex;
            dst.editedAtIndex = src.editedAtIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(13);
        fieldNames.add("_id");
        fieldNames.add("t");
        fieldNames.add("rid");
        fieldNames.add("syncstate");
        fieldNames.add("ts");
        fieldNames.add("msg");
        fieldNames.add("u");
        fieldNames.add("groupable");
        fieldNames.add("alias");
        fieldNames.add("avatar");
        fieldNames.add("attachments");
        fieldNames.add("urls");
        fieldNames.add("editedAt");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmMessageColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmMessage> proxyState;

    RealmMessageRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmMessageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmMessage>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo._idIndex);
    }

    @Override
    public void realmSet$_id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field '_id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$t() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tIndex);
    }

    @Override
    public void realmSet$t(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ridIndex);
    }

    @Override
    public void realmSet$rid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ridIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ridIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ridIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ridIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$syncstate() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.syncstateIndex);
    }

    @Override
    public void realmSet$syncstate(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.syncstateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.syncstateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$ts() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.tsIndex);
    }

    @Override
    public void realmSet$ts(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.tsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.tsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$msg() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.msgIndex);
    }

    @Override
    public void realmSet$msg(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.msgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.msgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.msgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.msgIndex, value);
    }

    @Override
    public chat.rocket.persistence.realm.models.ddp.RealmUser realmGet$u() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.uIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(chat.rocket.persistence.realm.models.ddp.RealmUser.class, proxyState.getRow$realm().getLink(columnInfo.uIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$u(chat.rocket.persistence.realm.models.ddp.RealmUser value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("u")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.uIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.uIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.uIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.uIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$groupable() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.groupableIndex);
    }

    @Override
    public void realmSet$groupable(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.groupableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.groupableIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$alias() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aliasIndex);
    }

    @Override
    public void realmSet$alias(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aliasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aliasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aliasIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aliasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$avatar() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.avatarIndex);
    }

    @Override
    public void realmSet$avatar(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.avatarIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.avatarIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.avatarIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.avatarIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$attachments() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.attachmentsIndex);
    }

    @Override
    public void realmSet$attachments(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.attachmentsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.attachmentsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.attachmentsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.attachmentsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$urls() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlsIndex);
    }

    @Override
    public void realmSet$urls(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$editedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.editedAtIndex);
    }

    @Override
    public void realmSet$editedAt(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.editedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.editedAtIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmMessage", 13, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("t", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("syncstate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ts", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("msg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("u", RealmFieldType.OBJECT, "RealmUser");
        builder.addPersistedProperty("groupable", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("alias", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("avatar", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("attachments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("urls", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("editedAt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmMessageColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmMessageColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmMessage";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmMessage createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        chat.rocket.persistence.realm.models.ddp.RealmMessage obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
            RealmMessageColumnInfo columnInfo = (RealmMessageColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
            long pkColumnIndex = columnInfo._idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("_id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("_id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmMessageRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("u")) {
                excludeFields.add("u");
            }
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.RealmMessageRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmMessage.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmMessageRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmMessage.class, json.getString("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final RealmMessageRealmProxyInterface objProxy = (RealmMessageRealmProxyInterface) obj;
        if (json.has("t")) {
            if (json.isNull("t")) {
                objProxy.realmSet$t(null);
            } else {
                objProxy.realmSet$t((String) json.getString("t"));
            }
        }
        if (json.has("rid")) {
            if (json.isNull("rid")) {
                objProxy.realmSet$rid(null);
            } else {
                objProxy.realmSet$rid((String) json.getString("rid"));
            }
        }
        if (json.has("syncstate")) {
            if (json.isNull("syncstate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
            } else {
                objProxy.realmSet$syncstate((int) json.getInt("syncstate"));
            }
        }
        if (json.has("ts")) {
            if (json.isNull("ts")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ts' to null.");
            } else {
                objProxy.realmSet$ts((long) json.getLong("ts"));
            }
        }
        if (json.has("msg")) {
            if (json.isNull("msg")) {
                objProxy.realmSet$msg(null);
            } else {
                objProxy.realmSet$msg((String) json.getString("msg"));
            }
        }
        if (json.has("u")) {
            if (json.isNull("u")) {
                objProxy.realmSet$u(null);
            } else {
                chat.rocket.persistence.realm.models.ddp.RealmUser uObj = RealmUserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("u"), update);
                objProxy.realmSet$u(uObj);
            }
        }
        if (json.has("groupable")) {
            if (json.isNull("groupable")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'groupable' to null.");
            } else {
                objProxy.realmSet$groupable((boolean) json.getBoolean("groupable"));
            }
        }
        if (json.has("alias")) {
            if (json.isNull("alias")) {
                objProxy.realmSet$alias(null);
            } else {
                objProxy.realmSet$alias((String) json.getString("alias"));
            }
        }
        if (json.has("avatar")) {
            if (json.isNull("avatar")) {
                objProxy.realmSet$avatar(null);
            } else {
                objProxy.realmSet$avatar((String) json.getString("avatar"));
            }
        }
        if (json.has("attachments")) {
            if (json.isNull("attachments")) {
                objProxy.realmSet$attachments(null);
            } else {
                objProxy.realmSet$attachments((String) json.getString("attachments"));
            }
        }
        if (json.has("urls")) {
            if (json.isNull("urls")) {
                objProxy.realmSet$urls(null);
            } else {
                objProxy.realmSet$urls((String) json.getString("urls"));
            }
        }
        if (json.has("editedAt")) {
            if (json.isNull("editedAt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'editedAt' to null.");
            } else {
                objProxy.realmSet$editedAt((long) json.getLong("editedAt"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmMessage createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmMessage obj = new chat.rocket.persistence.realm.models.ddp.RealmMessage();
        final RealmMessageRealmProxyInterface objProxy = (RealmMessageRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$_id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("t")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$t((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$t(null);
                }
            } else if (name.equals("rid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rid(null);
                }
            } else if (name.equals("syncstate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$syncstate((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
                }
            } else if (name.equals("ts")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ts((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ts' to null.");
                }
            } else if (name.equals("msg")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$msg((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$msg(null);
                }
            } else if (name.equals("u")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$u(null);
                } else {
                    chat.rocket.persistence.realm.models.ddp.RealmUser uObj = RealmUserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$u(uObj);
                }
            } else if (name.equals("groupable")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$groupable((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'groupable' to null.");
                }
            } else if (name.equals("alias")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$alias((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$alias(null);
                }
            } else if (name.equals("avatar")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$avatar((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$avatar(null);
                }
            } else if (name.equals("attachments")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$attachments((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$attachments(null);
                }
            } else if (name.equals("urls")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$urls((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$urls(null);
                }
            } else if (name.equals("editedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$editedAt((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'editedAt' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmMessage copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMessage object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmMessage) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmMessage realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
            RealmMessageColumnInfo columnInfo = (RealmMessageColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
            long pkColumnIndex = columnInfo._idIndex;
            String value = ((RealmMessageRealmProxyInterface) object).realmGet$_id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmMessageRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmMessage copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMessage newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmMessage) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmMessage realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmMessage.class, ((RealmMessageRealmProxyInterface) newObject).realmGet$_id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmMessageRealmProxyInterface realmObjectSource = (RealmMessageRealmProxyInterface) newObject;
        RealmMessageRealmProxyInterface realmObjectCopy = (RealmMessageRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$t(realmObjectSource.realmGet$t());
        realmObjectCopy.realmSet$rid(realmObjectSource.realmGet$rid());
        realmObjectCopy.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectCopy.realmSet$ts(realmObjectSource.realmGet$ts());
        realmObjectCopy.realmSet$msg(realmObjectSource.realmGet$msg());

        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = realmObjectSource.realmGet$u();
        if (uObj == null) {
            realmObjectCopy.realmSet$u(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmUser cacheu = (chat.rocket.persistence.realm.models.ddp.RealmUser) cache.get(uObj);
            if (cacheu != null) {
                realmObjectCopy.realmSet$u(cacheu);
            } else {
                realmObjectCopy.realmSet$u(RealmUserRealmProxy.copyOrUpdate(realm, uObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$groupable(realmObjectSource.realmGet$groupable());
        realmObjectCopy.realmSet$alias(realmObjectSource.realmGet$alias());
        realmObjectCopy.realmSet$avatar(realmObjectSource.realmGet$avatar());
        realmObjectCopy.realmSet$attachments(realmObjectSource.realmGet$attachments());
        realmObjectCopy.realmSet$urls(realmObjectSource.realmGet$urls());
        realmObjectCopy.realmSet$editedAt(realmObjectSource.realmGet$editedAt());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMessage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long tableNativePtr = table.getNativePtr();
        RealmMessageColumnInfo columnInfo = (RealmMessageColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmMessageRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$t = ((RealmMessageRealmProxyInterface) object).realmGet$t();
        if (realmGet$t != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
        }
        String realmGet$rid = ((RealmMessageRealmProxyInterface) object).realmGet$rid();
        if (realmGet$rid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$syncstate(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.tsIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$ts(), false);
        String realmGet$msg = ((RealmMessageRealmProxyInterface) object).realmGet$msg();
        if (realmGet$msg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.msgIndex, rowIndex, realmGet$msg, false);
        }

        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmMessageRealmProxyInterface) object).realmGet$u();
        if (uObj != null) {
            Long cacheu = cache.get(uObj);
            if (cacheu == null) {
                cacheu = RealmUserRealmProxy.insert(realm, uObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.uIndex, rowIndex, cacheu, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.groupableIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$groupable(), false);
        String realmGet$alias = ((RealmMessageRealmProxyInterface) object).realmGet$alias();
        if (realmGet$alias != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aliasIndex, rowIndex, realmGet$alias, false);
        }
        String realmGet$avatar = ((RealmMessageRealmProxyInterface) object).realmGet$avatar();
        if (realmGet$avatar != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarIndex, rowIndex, realmGet$avatar, false);
        }
        String realmGet$attachments = ((RealmMessageRealmProxyInterface) object).realmGet$attachments();
        if (realmGet$attachments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.attachmentsIndex, rowIndex, realmGet$attachments, false);
        }
        String realmGet$urls = ((RealmMessageRealmProxyInterface) object).realmGet$urls();
        if (realmGet$urls != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlsIndex, rowIndex, realmGet$urls, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.editedAtIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$editedAt(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long tableNativePtr = table.getNativePtr();
        RealmMessageColumnInfo columnInfo = (RealmMessageColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmMessage object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmMessage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmMessageRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$t = ((RealmMessageRealmProxyInterface) object).realmGet$t();
            if (realmGet$t != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
            }
            String realmGet$rid = ((RealmMessageRealmProxyInterface) object).realmGet$rid();
            if (realmGet$rid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$syncstate(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.tsIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$ts(), false);
            String realmGet$msg = ((RealmMessageRealmProxyInterface) object).realmGet$msg();
            if (realmGet$msg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.msgIndex, rowIndex, realmGet$msg, false);
            }

            chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmMessageRealmProxyInterface) object).realmGet$u();
            if (uObj != null) {
                Long cacheu = cache.get(uObj);
                if (cacheu == null) {
                    cacheu = RealmUserRealmProxy.insert(realm, uObj, cache);
                }
                table.setLink(columnInfo.uIndex, rowIndex, cacheu, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.groupableIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$groupable(), false);
            String realmGet$alias = ((RealmMessageRealmProxyInterface) object).realmGet$alias();
            if (realmGet$alias != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.aliasIndex, rowIndex, realmGet$alias, false);
            }
            String realmGet$avatar = ((RealmMessageRealmProxyInterface) object).realmGet$avatar();
            if (realmGet$avatar != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarIndex, rowIndex, realmGet$avatar, false);
            }
            String realmGet$attachments = ((RealmMessageRealmProxyInterface) object).realmGet$attachments();
            if (realmGet$attachments != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.attachmentsIndex, rowIndex, realmGet$attachments, false);
            }
            String realmGet$urls = ((RealmMessageRealmProxyInterface) object).realmGet$urls();
            if (realmGet$urls != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlsIndex, rowIndex, realmGet$urls, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.editedAtIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$editedAt(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMessage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long tableNativePtr = table.getNativePtr();
        RealmMessageColumnInfo columnInfo = (RealmMessageColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmMessageRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$t = ((RealmMessageRealmProxyInterface) object).realmGet$t();
        if (realmGet$t != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tIndex, rowIndex, false);
        }
        String realmGet$rid = ((RealmMessageRealmProxyInterface) object).realmGet$rid();
        if (realmGet$rid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ridIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$syncstate(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.tsIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$ts(), false);
        String realmGet$msg = ((RealmMessageRealmProxyInterface) object).realmGet$msg();
        if (realmGet$msg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.msgIndex, rowIndex, realmGet$msg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.msgIndex, rowIndex, false);
        }

        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmMessageRealmProxyInterface) object).realmGet$u();
        if (uObj != null) {
            Long cacheu = cache.get(uObj);
            if (cacheu == null) {
                cacheu = RealmUserRealmProxy.insertOrUpdate(realm, uObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.uIndex, rowIndex, cacheu, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.uIndex, rowIndex);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.groupableIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$groupable(), false);
        String realmGet$alias = ((RealmMessageRealmProxyInterface) object).realmGet$alias();
        if (realmGet$alias != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aliasIndex, rowIndex, realmGet$alias, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aliasIndex, rowIndex, false);
        }
        String realmGet$avatar = ((RealmMessageRealmProxyInterface) object).realmGet$avatar();
        if (realmGet$avatar != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarIndex, rowIndex, realmGet$avatar, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatarIndex, rowIndex, false);
        }
        String realmGet$attachments = ((RealmMessageRealmProxyInterface) object).realmGet$attachments();
        if (realmGet$attachments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.attachmentsIndex, rowIndex, realmGet$attachments, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.attachmentsIndex, rowIndex, false);
        }
        String realmGet$urls = ((RealmMessageRealmProxyInterface) object).realmGet$urls();
        if (realmGet$urls != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlsIndex, rowIndex, realmGet$urls, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlsIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.editedAtIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$editedAt(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long tableNativePtr = table.getNativePtr();
        RealmMessageColumnInfo columnInfo = (RealmMessageColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmMessage object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmMessage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmMessageRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$t = ((RealmMessageRealmProxyInterface) object).realmGet$t();
            if (realmGet$t != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tIndex, rowIndex, false);
            }
            String realmGet$rid = ((RealmMessageRealmProxyInterface) object).realmGet$rid();
            if (realmGet$rid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ridIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$syncstate(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.tsIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$ts(), false);
            String realmGet$msg = ((RealmMessageRealmProxyInterface) object).realmGet$msg();
            if (realmGet$msg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.msgIndex, rowIndex, realmGet$msg, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.msgIndex, rowIndex, false);
            }

            chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmMessageRealmProxyInterface) object).realmGet$u();
            if (uObj != null) {
                Long cacheu = cache.get(uObj);
                if (cacheu == null) {
                    cacheu = RealmUserRealmProxy.insertOrUpdate(realm, uObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.uIndex, rowIndex, cacheu, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.uIndex, rowIndex);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.groupableIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$groupable(), false);
            String realmGet$alias = ((RealmMessageRealmProxyInterface) object).realmGet$alias();
            if (realmGet$alias != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.aliasIndex, rowIndex, realmGet$alias, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.aliasIndex, rowIndex, false);
            }
            String realmGet$avatar = ((RealmMessageRealmProxyInterface) object).realmGet$avatar();
            if (realmGet$avatar != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.avatarIndex, rowIndex, realmGet$avatar, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.avatarIndex, rowIndex, false);
            }
            String realmGet$attachments = ((RealmMessageRealmProxyInterface) object).realmGet$attachments();
            if (realmGet$attachments != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.attachmentsIndex, rowIndex, realmGet$attachments, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.attachmentsIndex, rowIndex, false);
            }
            String realmGet$urls = ((RealmMessageRealmProxyInterface) object).realmGet$urls();
            if (realmGet$urls != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlsIndex, rowIndex, realmGet$urls, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlsIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.editedAtIndex, rowIndex, ((RealmMessageRealmProxyInterface) object).realmGet$editedAt(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmMessage createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmMessage realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmMessage unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmMessage();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmMessage) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmMessage) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmMessageRealmProxyInterface unmanagedCopy = (RealmMessageRealmProxyInterface) unmanagedObject;
        RealmMessageRealmProxyInterface realmSource = (RealmMessageRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$t(realmSource.realmGet$t());
        unmanagedCopy.realmSet$rid(realmSource.realmGet$rid());
        unmanagedCopy.realmSet$syncstate(realmSource.realmGet$syncstate());
        unmanagedCopy.realmSet$ts(realmSource.realmGet$ts());
        unmanagedCopy.realmSet$msg(realmSource.realmGet$msg());

        // Deep copy of u
        unmanagedCopy.realmSet$u(RealmUserRealmProxy.createDetachedCopy(realmSource.realmGet$u(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$groupable(realmSource.realmGet$groupable());
        unmanagedCopy.realmSet$alias(realmSource.realmGet$alias());
        unmanagedCopy.realmSet$avatar(realmSource.realmGet$avatar());
        unmanagedCopy.realmSet$attachments(realmSource.realmGet$attachments());
        unmanagedCopy.realmSet$urls(realmSource.realmGet$urls());
        unmanagedCopy.realmSet$editedAt(realmSource.realmGet$editedAt());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmMessage update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMessage realmObject, chat.rocket.persistence.realm.models.ddp.RealmMessage newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmMessageRealmProxyInterface realmObjectTarget = (RealmMessageRealmProxyInterface) realmObject;
        RealmMessageRealmProxyInterface realmObjectSource = (RealmMessageRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$t(realmObjectSource.realmGet$t());
        realmObjectTarget.realmSet$rid(realmObjectSource.realmGet$rid());
        realmObjectTarget.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectTarget.realmSet$ts(realmObjectSource.realmGet$ts());
        realmObjectTarget.realmSet$msg(realmObjectSource.realmGet$msg());
        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = realmObjectSource.realmGet$u();
        if (uObj == null) {
            realmObjectTarget.realmSet$u(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmUser cacheu = (chat.rocket.persistence.realm.models.ddp.RealmUser) cache.get(uObj);
            if (cacheu != null) {
                realmObjectTarget.realmSet$u(cacheu);
            } else {
                realmObjectTarget.realmSet$u(RealmUserRealmProxy.copyOrUpdate(realm, uObj, true, cache));
            }
        }
        realmObjectTarget.realmSet$groupable(realmObjectSource.realmGet$groupable());
        realmObjectTarget.realmSet$alias(realmObjectSource.realmGet$alias());
        realmObjectTarget.realmSet$avatar(realmObjectSource.realmGet$avatar());
        realmObjectTarget.realmSet$attachments(realmObjectSource.realmGet$attachments());
        realmObjectTarget.realmSet$urls(realmObjectSource.realmGet$urls());
        realmObjectTarget.realmSet$editedAt(realmObjectSource.realmGet$editedAt());
        return realmObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
