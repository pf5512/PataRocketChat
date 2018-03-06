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
public class RealmUserRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmUser
    implements RealmObjectProxy, RealmUserRealmProxyInterface {

    static final class RealmUserColumnInfo extends ColumnInfo {
        long _idIndex;
        long nameIndex;
        long usernameIndex;
        long statusIndex;
        long utcOffsetIndex;
        long emailsIndex;
        long settingsIndex;

        RealmUserColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmUser");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.usernameIndex = addColumnDetails("username", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", objectSchemaInfo);
            this.utcOffsetIndex = addColumnDetails("utcOffset", objectSchemaInfo);
            this.emailsIndex = addColumnDetails("emails", objectSchemaInfo);
            this.settingsIndex = addColumnDetails("settings", objectSchemaInfo);
        }

        RealmUserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmUserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmUserColumnInfo src = (RealmUserColumnInfo) rawSrc;
            final RealmUserColumnInfo dst = (RealmUserColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.nameIndex = src.nameIndex;
            dst.usernameIndex = src.usernameIndex;
            dst.statusIndex = src.statusIndex;
            dst.utcOffsetIndex = src.utcOffsetIndex;
            dst.emailsIndex = src.emailsIndex;
            dst.settingsIndex = src.settingsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(7);
        fieldNames.add("_id");
        fieldNames.add("name");
        fieldNames.add("username");
        fieldNames.add("status");
        fieldNames.add("utcOffset");
        fieldNames.add("emails");
        fieldNames.add("settings");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmUserColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmUser> proxyState;
    private RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsRealmList;

    RealmUserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmUserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmUser>(this);
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
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameIndex);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.usernameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.usernameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.usernameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.usernameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$utcOffset() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.utcOffsetIndex);
    }

    @Override
    public void realmSet$utcOffset(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.utcOffsetIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.utcOffsetIndex, value);
    }

    @Override
    public RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> realmGet$emails() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (emailsRealmList != null) {
            return emailsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.emailsIndex);
            emailsRealmList = new RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail>(chat.rocket.persistence.realm.models.ddp.RealmEmail.class, osList, proxyState.getRealm$realm());
            return emailsRealmList;
        }
    }

    @Override
    public void realmSet$emails(RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("emails")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> original = value;
                value = new RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail>();
                for (chat.rocket.persistence.realm.models.ddp.RealmEmail item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.emailsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmEmail linkedObject = value.get(i);
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
                chat.rocket.persistence.realm.models.ddp.RealmEmail linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public chat.rocket.persistence.realm.models.ddp.RealmSettings realmGet$settings() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.settingsIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(chat.rocket.persistence.realm.models.ddp.RealmSettings.class, proxyState.getRow$realm().getLink(columnInfo.settingsIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$settings(chat.rocket.persistence.realm.models.ddp.RealmSettings value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("settings")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.settingsIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.settingsIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.settingsIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.settingsIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmUser", 7, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("utcOffset", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("emails", RealmFieldType.LIST, "RealmEmail");
        builder.addPersistedLinkProperty("settings", RealmFieldType.OBJECT, "RealmSettings");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmUserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmUserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmUser";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmUser createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        chat.rocket.persistence.realm.models.ddp.RealmUser obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
            RealmUserColumnInfo columnInfo = (RealmUserColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmUserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("emails")) {
                excludeFields.add("emails");
            }
            if (json.has("settings")) {
                excludeFields.add("settings");
            }
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.RealmUserRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmUser.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmUserRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmUser.class, json.getString("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final RealmUserRealmProxyInterface objProxy = (RealmUserRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("utcOffset")) {
            if (json.isNull("utcOffset")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'utcOffset' to null.");
            } else {
                objProxy.realmSet$utcOffset((double) json.getDouble("utcOffset"));
            }
        }
        if (json.has("emails")) {
            if (json.isNull("emails")) {
                objProxy.realmSet$emails(null);
            } else {
                objProxy.realmGet$emails().clear();
                JSONArray array = json.getJSONArray("emails");
                for (int i = 0; i < array.length(); i++) {
                    chat.rocket.persistence.realm.models.ddp.RealmEmail item = RealmEmailRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$emails().add(item);
                }
            }
        }
        if (json.has("settings")) {
            if (json.isNull("settings")) {
                objProxy.realmSet$settings(null);
            } else {
                chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = RealmSettingsRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("settings"), update);
                objProxy.realmSet$settings(settingsObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmUser createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmUser obj = new chat.rocket.persistence.realm.models.ddp.RealmUser();
        final RealmUserRealmProxyInterface objProxy = (RealmUserRealmProxyInterface) obj;
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
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("utcOffset")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$utcOffset((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'utcOffset' to null.");
                }
            } else if (name.equals("emails")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$emails(null);
                } else {
                    objProxy.realmSet$emails(new RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        chat.rocket.persistence.realm.models.ddp.RealmEmail item = RealmEmailRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$emails().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("settings")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$settings(null);
                } else {
                    chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = RealmSettingsRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$settings(settingsObj);
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

    public static chat.rocket.persistence.realm.models.ddp.RealmUser copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmUser object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmUser) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmUser realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
            RealmUserColumnInfo columnInfo = (RealmUserColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
            long pkColumnIndex = columnInfo._idIndex;
            String value = ((RealmUserRealmProxyInterface) object).realmGet$_id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmUserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmUser copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmUser newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmUser) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmUser realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmUser.class, ((RealmUserRealmProxyInterface) newObject).realmGet$_id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmUserRealmProxyInterface realmObjectSource = (RealmUserRealmProxyInterface) newObject;
        RealmUserRealmProxyInterface realmObjectCopy = (RealmUserRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$username(realmObjectSource.realmGet$username());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$utcOffset(realmObjectSource.realmGet$utcOffset());

        RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsList = realmObjectSource.realmGet$emails();
        if (emailsList != null) {
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsRealmList = realmObjectCopy.realmGet$emails();
            emailsRealmList.clear();
            for (int i = 0; i < emailsList.size(); i++) {
                chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem = emailsList.get(i);
                chat.rocket.persistence.realm.models.ddp.RealmEmail cacheemails = (chat.rocket.persistence.realm.models.ddp.RealmEmail) cache.get(emailsItem);
                if (cacheemails != null) {
                    emailsRealmList.add(cacheemails);
                } else {
                    emailsRealmList.add(RealmEmailRealmProxy.copyOrUpdate(realm, emailsItem, update, cache));
                }
            }
        }


        chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = realmObjectSource.realmGet$settings();
        if (settingsObj == null) {
            realmObjectCopy.realmSet$settings(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmSettings cachesettings = (chat.rocket.persistence.realm.models.ddp.RealmSettings) cache.get(settingsObj);
            if (cachesettings != null) {
                realmObjectCopy.realmSet$settings(cachesettings);
            } else {
                realmObjectCopy.realmSet$settings(RealmSettingsRealmProxy.copyOrUpdate(realm, settingsObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmUser object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long tableNativePtr = table.getNativePtr();
        RealmUserColumnInfo columnInfo = (RealmUserColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmUserRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$name = ((RealmUserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$username = ((RealmUserRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$status = ((RealmUserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.utcOffsetIndex, rowIndex, ((RealmUserRealmProxyInterface) object).realmGet$utcOffset(), false);

        RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsList = ((RealmUserRealmProxyInterface) object).realmGet$emails();
        if (emailsList != null) {
            OsList emailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.emailsIndex);
            for (chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem : emailsList) {
                Long cacheItemIndexemails = cache.get(emailsItem);
                if (cacheItemIndexemails == null) {
                    cacheItemIndexemails = RealmEmailRealmProxy.insert(realm, emailsItem, cache);
                }
                emailsOsList.addRow(cacheItemIndexemails);
            }
        }

        chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = ((RealmUserRealmProxyInterface) object).realmGet$settings();
        if (settingsObj != null) {
            Long cachesettings = cache.get(settingsObj);
            if (cachesettings == null) {
                cachesettings = RealmSettingsRealmProxy.insert(realm, settingsObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.settingsIndex, rowIndex, cachesettings, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long tableNativePtr = table.getNativePtr();
        RealmUserColumnInfo columnInfo = (RealmUserColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmUser object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmUser) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmUserRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$name = ((RealmUserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$username = ((RealmUserRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            }
            String realmGet$status = ((RealmUserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.utcOffsetIndex, rowIndex, ((RealmUserRealmProxyInterface) object).realmGet$utcOffset(), false);

            RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsList = ((RealmUserRealmProxyInterface) object).realmGet$emails();
            if (emailsList != null) {
                OsList emailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.emailsIndex);
                for (chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem : emailsList) {
                    Long cacheItemIndexemails = cache.get(emailsItem);
                    if (cacheItemIndexemails == null) {
                        cacheItemIndexemails = RealmEmailRealmProxy.insert(realm, emailsItem, cache);
                    }
                    emailsOsList.addRow(cacheItemIndexemails);
                }
            }

            chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = ((RealmUserRealmProxyInterface) object).realmGet$settings();
            if (settingsObj != null) {
                Long cachesettings = cache.get(settingsObj);
                if (cachesettings == null) {
                    cachesettings = RealmSettingsRealmProxy.insert(realm, settingsObj, cache);
                }
                table.setLink(columnInfo.settingsIndex, rowIndex, cachesettings, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmUser object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long tableNativePtr = table.getNativePtr();
        RealmUserColumnInfo columnInfo = (RealmUserColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmUserRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$name = ((RealmUserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$username = ((RealmUserRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$status = ((RealmUserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.utcOffsetIndex, rowIndex, ((RealmUserRealmProxyInterface) object).realmGet$utcOffset(), false);

        OsList emailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.emailsIndex);
        RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsList = ((RealmUserRealmProxyInterface) object).realmGet$emails();
        if (emailsList != null && emailsList.size() == emailsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = emailsList.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem = emailsList.get(i);
                Long cacheItemIndexemails = cache.get(emailsItem);
                if (cacheItemIndexemails == null) {
                    cacheItemIndexemails = RealmEmailRealmProxy.insertOrUpdate(realm, emailsItem, cache);
                }
                emailsOsList.setRow(i, cacheItemIndexemails);
            }
        } else {
            emailsOsList.removeAll();
            if (emailsList != null) {
                for (chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem : emailsList) {
                    Long cacheItemIndexemails = cache.get(emailsItem);
                    if (cacheItemIndexemails == null) {
                        cacheItemIndexemails = RealmEmailRealmProxy.insertOrUpdate(realm, emailsItem, cache);
                    }
                    emailsOsList.addRow(cacheItemIndexemails);
                }
            }
        }


        chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = ((RealmUserRealmProxyInterface) object).realmGet$settings();
        if (settingsObj != null) {
            Long cachesettings = cache.get(settingsObj);
            if (cachesettings == null) {
                cachesettings = RealmSettingsRealmProxy.insertOrUpdate(realm, settingsObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.settingsIndex, rowIndex, cachesettings, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.settingsIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long tableNativePtr = table.getNativePtr();
        RealmUserColumnInfo columnInfo = (RealmUserColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmUser object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmUser) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmUserRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$name = ((RealmUserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$username = ((RealmUserRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
            }
            String realmGet$status = ((RealmUserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.utcOffsetIndex, rowIndex, ((RealmUserRealmProxyInterface) object).realmGet$utcOffset(), false);

            OsList emailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.emailsIndex);
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsList = ((RealmUserRealmProxyInterface) object).realmGet$emails();
            if (emailsList != null && emailsList.size() == emailsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = emailsList.size();
                for (int i = 0; i < objectCount; i++) {
                    chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem = emailsList.get(i);
                    Long cacheItemIndexemails = cache.get(emailsItem);
                    if (cacheItemIndexemails == null) {
                        cacheItemIndexemails = RealmEmailRealmProxy.insertOrUpdate(realm, emailsItem, cache);
                    }
                    emailsOsList.setRow(i, cacheItemIndexemails);
                }
            } else {
                emailsOsList.removeAll();
                if (emailsList != null) {
                    for (chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem : emailsList) {
                        Long cacheItemIndexemails = cache.get(emailsItem);
                        if (cacheItemIndexemails == null) {
                            cacheItemIndexemails = RealmEmailRealmProxy.insertOrUpdate(realm, emailsItem, cache);
                        }
                        emailsOsList.addRow(cacheItemIndexemails);
                    }
                }
            }


            chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = ((RealmUserRealmProxyInterface) object).realmGet$settings();
            if (settingsObj != null) {
                Long cachesettings = cache.get(settingsObj);
                if (cachesettings == null) {
                    cachesettings = RealmSettingsRealmProxy.insertOrUpdate(realm, settingsObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.settingsIndex, rowIndex, cachesettings, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.settingsIndex, rowIndex);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmUser createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmUser realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmUser unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmUser();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmUser) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmUser) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmUserRealmProxyInterface unmanagedCopy = (RealmUserRealmProxyInterface) unmanagedObject;
        RealmUserRealmProxyInterface realmSource = (RealmUserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$utcOffset(realmSource.realmGet$utcOffset());

        // Deep copy of emails
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$emails(null);
        } else {
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> managedemailsList = realmSource.realmGet$emails();
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> unmanagedemailsList = new RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail>();
            unmanagedCopy.realmSet$emails(unmanagedemailsList);
            int nextDepth = currentDepth + 1;
            int size = managedemailsList.size();
            for (int i = 0; i < size; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmEmail item = RealmEmailRealmProxy.createDetachedCopy(managedemailsList.get(i), nextDepth, maxDepth, cache);
                unmanagedemailsList.add(item);
            }
        }

        // Deep copy of settings
        unmanagedCopy.realmSet$settings(RealmSettingsRealmProxy.createDetachedCopy(realmSource.realmGet$settings(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmUser update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmUser realmObject, chat.rocket.persistence.realm.models.ddp.RealmUser newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmUserRealmProxyInterface realmObjectTarget = (RealmUserRealmProxyInterface) realmObject;
        RealmUserRealmProxyInterface realmObjectSource = (RealmUserRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$username(realmObjectSource.realmGet$username());
        realmObjectTarget.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectTarget.realmSet$utcOffset(realmObjectSource.realmGet$utcOffset());
        RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsList = realmObjectSource.realmGet$emails();
        RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> emailsRealmList = realmObjectTarget.realmGet$emails();
        if (emailsList != null && emailsList.size() == emailsRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = emailsList.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem = emailsList.get(i);
                chat.rocket.persistence.realm.models.ddp.RealmEmail cacheemails = (chat.rocket.persistence.realm.models.ddp.RealmEmail) cache.get(emailsItem);
                if (cacheemails != null) {
                    emailsRealmList.set(i, cacheemails);
                } else {
                    emailsRealmList.set(i, RealmEmailRealmProxy.copyOrUpdate(realm, emailsItem, true, cache));
                }
            }
        } else {
            emailsRealmList.clear();
            if (emailsList != null) {
                for (int i = 0; i < emailsList.size(); i++) {
                    chat.rocket.persistence.realm.models.ddp.RealmEmail emailsItem = emailsList.get(i);
                    chat.rocket.persistence.realm.models.ddp.RealmEmail cacheemails = (chat.rocket.persistence.realm.models.ddp.RealmEmail) cache.get(emailsItem);
                    if (cacheemails != null) {
                        emailsRealmList.add(cacheemails);
                    } else {
                        emailsRealmList.add(RealmEmailRealmProxy.copyOrUpdate(realm, emailsItem, true, cache));
                    }
                }
            }
        }
        chat.rocket.persistence.realm.models.ddp.RealmSettings settingsObj = realmObjectSource.realmGet$settings();
        if (settingsObj == null) {
            realmObjectTarget.realmSet$settings(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmSettings cachesettings = (chat.rocket.persistence.realm.models.ddp.RealmSettings) cache.get(settingsObj);
            if (cachesettings != null) {
                realmObjectTarget.realmSet$settings(cachesettings);
            } else {
                realmObjectTarget.realmSet$settings(RealmSettingsRealmProxy.copyOrUpdate(realm, settingsObj, true, cache));
            }
        }
        return realmObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
