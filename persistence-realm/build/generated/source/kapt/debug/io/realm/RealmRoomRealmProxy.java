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
public class RealmRoomRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmRoom
    implements RealmObjectProxy, RealmRoomRealmProxyInterface {

    static final class RealmRoomColumnInfo extends ColumnInfo {
        long _idIndex;
        long ridIndex;
        long nameIndex;
        long tIndex;
        long openIndex;
        long alertIndex;
        long unreadIndex;
        long _updatedAtIndex;
        long lsIndex;
        long fIndex;

        RealmRoomColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmRoom");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.ridIndex = addColumnDetails("rid", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.tIndex = addColumnDetails("t", objectSchemaInfo);
            this.openIndex = addColumnDetails("open", objectSchemaInfo);
            this.alertIndex = addColumnDetails("alert", objectSchemaInfo);
            this.unreadIndex = addColumnDetails("unread", objectSchemaInfo);
            this._updatedAtIndex = addColumnDetails("_updatedAt", objectSchemaInfo);
            this.lsIndex = addColumnDetails("ls", objectSchemaInfo);
            this.fIndex = addColumnDetails("f", objectSchemaInfo);
        }

        RealmRoomColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmRoomColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmRoomColumnInfo src = (RealmRoomColumnInfo) rawSrc;
            final RealmRoomColumnInfo dst = (RealmRoomColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.ridIndex = src.ridIndex;
            dst.nameIndex = src.nameIndex;
            dst.tIndex = src.tIndex;
            dst.openIndex = src.openIndex;
            dst.alertIndex = src.alertIndex;
            dst.unreadIndex = src.unreadIndex;
            dst._updatedAtIndex = src._updatedAtIndex;
            dst.lsIndex = src.lsIndex;
            dst.fIndex = src.fIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(10);
        fieldNames.add("_id");
        fieldNames.add("rid");
        fieldNames.add("name");
        fieldNames.add("t");
        fieldNames.add("open");
        fieldNames.add("alert");
        fieldNames.add("unread");
        fieldNames.add("_updatedAt");
        fieldNames.add("ls");
        fieldNames.add("f");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmRoomColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmRoom> proxyState;

    RealmRoomRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmRoomColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmRoom>(this);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo._idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo._idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo._idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo._idIndex, value);
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'rid' cannot be changed after object was created.");
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
    public boolean realmGet$open() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.openIndex);
    }

    @Override
    public void realmSet$open(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.openIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.openIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$alert() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.alertIndex);
    }

    @Override
    public void realmSet$alert(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.alertIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.alertIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$unread() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.unreadIndex);
    }

    @Override
    public void realmSet$unread(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.unreadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.unreadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$_updatedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo._updatedAtIndex);
    }

    @Override
    public void realmSet$_updatedAt(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo._updatedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo._updatedAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$ls() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.lsIndex);
    }

    @Override
    public void realmSet$ls(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.lsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.lsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$f() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.fIndex);
    }

    @Override
    public void realmSet$f(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.fIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.fIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmRoom", 10, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rid", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("t", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("open", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("alert", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("unread", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("_updatedAt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ls", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("f", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmRoomColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmRoomColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmRoom";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmRoom createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.ddp.RealmRoom obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
            RealmRoomColumnInfo columnInfo = (RealmRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
            long pkColumnIndex = columnInfo.ridIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("rid")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("rid"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmRoomRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("rid")) {
                if (json.isNull("rid")) {
                    obj = (io.realm.RealmRoomRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmRoom.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmRoomRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmRoom.class, json.getString("rid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'rid'.");
            }
        }

        final RealmRoomRealmProxyInterface objProxy = (RealmRoomRealmProxyInterface) obj;
        if (json.has("_id")) {
            if (json.isNull("_id")) {
                objProxy.realmSet$_id(null);
            } else {
                objProxy.realmSet$_id((String) json.getString("_id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("t")) {
            if (json.isNull("t")) {
                objProxy.realmSet$t(null);
            } else {
                objProxy.realmSet$t((String) json.getString("t"));
            }
        }
        if (json.has("open")) {
            if (json.isNull("open")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'open' to null.");
            } else {
                objProxy.realmSet$open((boolean) json.getBoolean("open"));
            }
        }
        if (json.has("alert")) {
            if (json.isNull("alert")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'alert' to null.");
            } else {
                objProxy.realmSet$alert((boolean) json.getBoolean("alert"));
            }
        }
        if (json.has("unread")) {
            if (json.isNull("unread")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unread' to null.");
            } else {
                objProxy.realmSet$unread((int) json.getInt("unread"));
            }
        }
        if (json.has("_updatedAt")) {
            if (json.isNull("_updatedAt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field '_updatedAt' to null.");
            } else {
                objProxy.realmSet$_updatedAt((long) json.getLong("_updatedAt"));
            }
        }
        if (json.has("ls")) {
            if (json.isNull("ls")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ls' to null.");
            } else {
                objProxy.realmSet$ls((long) json.getLong("ls"));
            }
        }
        if (json.has("f")) {
            if (json.isNull("f")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'f' to null.");
            } else {
                objProxy.realmSet$f((boolean) json.getBoolean("f"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmRoom createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmRoom obj = new chat.rocket.persistence.realm.models.ddp.RealmRoom();
        final RealmRoomRealmProxyInterface objProxy = (RealmRoomRealmProxyInterface) obj;
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
            } else if (name.equals("rid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rid(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("t")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$t((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$t(null);
                }
            } else if (name.equals("open")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$open((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'open' to null.");
                }
            } else if (name.equals("alert")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$alert((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'alert' to null.");
                }
            } else if (name.equals("unread")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unread((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unread' to null.");
                }
            } else if (name.equals("_updatedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$_updatedAt((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field '_updatedAt' to null.");
                }
            } else if (name.equals("ls")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ls((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ls' to null.");
                }
            } else if (name.equals("f")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$f((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'f' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'rid'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmRoom copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoom object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmRoom) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmRoom realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
            RealmRoomColumnInfo columnInfo = (RealmRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
            long pkColumnIndex = columnInfo.ridIndex;
            String value = ((RealmRoomRealmProxyInterface) object).realmGet$rid();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmRoomRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmRoom copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoom newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmRoom) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmRoom realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmRoom.class, ((RealmRoomRealmProxyInterface) newObject).realmGet$rid(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmRoomRealmProxyInterface realmObjectSource = (RealmRoomRealmProxyInterface) newObject;
        RealmRoomRealmProxyInterface realmObjectCopy = (RealmRoomRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$_id(realmObjectSource.realmGet$_id());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$t(realmObjectSource.realmGet$t());
        realmObjectCopy.realmSet$open(realmObjectSource.realmGet$open());
        realmObjectCopy.realmSet$alert(realmObjectSource.realmGet$alert());
        realmObjectCopy.realmSet$unread(realmObjectSource.realmGet$unread());
        realmObjectCopy.realmSet$_updatedAt(realmObjectSource.realmGet$_updatedAt());
        realmObjectCopy.realmSet$ls(realmObjectSource.realmGet$ls());
        realmObjectCopy.realmSet$f(realmObjectSource.realmGet$f());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoom object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomColumnInfo columnInfo = (RealmRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long pkColumnIndex = columnInfo.ridIndex;
        String primaryKeyValue = ((RealmRoomRealmProxyInterface) object).realmGet$rid();
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
        String realmGet$_id = ((RealmRoomRealmProxyInterface) object).realmGet$_id();
        if (realmGet$_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id, false);
        }
        String realmGet$name = ((RealmRoomRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$t = ((RealmRoomRealmProxyInterface) object).realmGet$t();
        if (realmGet$t != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$open(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.alertIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$alert(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.unreadIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$unread(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$_updatedAt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.lsIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$ls(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.fIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$f(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomColumnInfo columnInfo = (RealmRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long pkColumnIndex = columnInfo.ridIndex;
        chat.rocket.persistence.realm.models.ddp.RealmRoom object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmRoom) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmRoomRealmProxyInterface) object).realmGet$rid();
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
            String realmGet$_id = ((RealmRoomRealmProxyInterface) object).realmGet$_id();
            if (realmGet$_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id, false);
            }
            String realmGet$name = ((RealmRoomRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$t = ((RealmRoomRealmProxyInterface) object).realmGet$t();
            if (realmGet$t != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$open(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.alertIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$alert(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.unreadIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$unread(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$_updatedAt(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.lsIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$ls(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.fIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$f(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoom object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomColumnInfo columnInfo = (RealmRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long pkColumnIndex = columnInfo.ridIndex;
        String primaryKeyValue = ((RealmRoomRealmProxyInterface) object).realmGet$rid();
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
        String realmGet$_id = ((RealmRoomRealmProxyInterface) object).realmGet$_id();
        if (realmGet$_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo._idIndex, rowIndex, false);
        }
        String realmGet$name = ((RealmRoomRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$t = ((RealmRoomRealmProxyInterface) object).realmGet$t();
        if (realmGet$t != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$open(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.alertIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$alert(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.unreadIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$unread(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$_updatedAt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.lsIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$ls(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.fIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$f(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomColumnInfo columnInfo = (RealmRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        long pkColumnIndex = columnInfo.ridIndex;
        chat.rocket.persistence.realm.models.ddp.RealmRoom object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmRoom) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmRoomRealmProxyInterface) object).realmGet$rid();
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
            String realmGet$_id = ((RealmRoomRealmProxyInterface) object).realmGet$_id();
            if (realmGet$_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo._idIndex, rowIndex, false);
            }
            String realmGet$name = ((RealmRoomRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$t = ((RealmRoomRealmProxyInterface) object).realmGet$t();
            if (realmGet$t != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$open(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.alertIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$alert(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.unreadIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$unread(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$_updatedAt(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.lsIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$ls(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.fIndex, rowIndex, ((RealmRoomRealmProxyInterface) object).realmGet$f(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmRoom createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmRoom realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmRoom unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmRoom();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmRoom) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmRoom) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmRoomRealmProxyInterface unmanagedCopy = (RealmRoomRealmProxyInterface) unmanagedObject;
        RealmRoomRealmProxyInterface realmSource = (RealmRoomRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$rid(realmSource.realmGet$rid());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$t(realmSource.realmGet$t());
        unmanagedCopy.realmSet$open(realmSource.realmGet$open());
        unmanagedCopy.realmSet$alert(realmSource.realmGet$alert());
        unmanagedCopy.realmSet$unread(realmSource.realmGet$unread());
        unmanagedCopy.realmSet$_updatedAt(realmSource.realmGet$_updatedAt());
        unmanagedCopy.realmSet$ls(realmSource.realmGet$ls());
        unmanagedCopy.realmSet$f(realmSource.realmGet$f());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmRoom update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoom realmObject, chat.rocket.persistence.realm.models.ddp.RealmRoom newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmRoomRealmProxyInterface realmObjectTarget = (RealmRoomRealmProxyInterface) realmObject;
        RealmRoomRealmProxyInterface realmObjectSource = (RealmRoomRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$_id(realmObjectSource.realmGet$_id());
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$t(realmObjectSource.realmGet$t());
        realmObjectTarget.realmSet$open(realmObjectSource.realmGet$open());
        realmObjectTarget.realmSet$alert(realmObjectSource.realmGet$alert());
        realmObjectTarget.realmSet$unread(realmObjectSource.realmGet$unread());
        realmObjectTarget.realmSet$_updatedAt(realmObjectSource.realmGet$_updatedAt());
        realmObjectTarget.realmSet$ls(realmObjectSource.realmGet$ls());
        realmObjectTarget.realmSet$f(realmObjectSource.realmGet$f());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmRoom = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rid:");
        stringBuilder.append(realmGet$rid() != null ? realmGet$rid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{t:");
        stringBuilder.append(realmGet$t() != null ? realmGet$t() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{open:");
        stringBuilder.append(realmGet$open());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{alert:");
        stringBuilder.append(realmGet$alert());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unread:");
        stringBuilder.append(realmGet$unread());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{_updatedAt:");
        stringBuilder.append(realmGet$_updatedAt());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ls:");
        stringBuilder.append(realmGet$ls());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{f:");
        stringBuilder.append(realmGet$f());
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
        RealmRoomRealmProxy aRealmRoom = (RealmRoomRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmRoom.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmRoom.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmRoom.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
