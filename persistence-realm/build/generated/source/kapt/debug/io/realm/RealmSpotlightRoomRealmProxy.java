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
public class RealmSpotlightRoomRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom
    implements RealmObjectProxy, RealmSpotlightRoomRealmProxyInterface {

    static final class RealmSpotlightRoomColumnInfo extends ColumnInfo {
        long _idIndex;
        long nameIndex;
        long tIndex;

        RealmSpotlightRoomColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmSpotlightRoom");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.tIndex = addColumnDetails("t", objectSchemaInfo);
        }

        RealmSpotlightRoomColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmSpotlightRoomColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmSpotlightRoomColumnInfo src = (RealmSpotlightRoomColumnInfo) rawSrc;
            final RealmSpotlightRoomColumnInfo dst = (RealmSpotlightRoomColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.nameIndex = src.nameIndex;
            dst.tIndex = src.tIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(3);
        fieldNames.add("_id");
        fieldNames.add("name");
        fieldNames.add("t");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmSpotlightRoomColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom> proxyState;

    RealmSpotlightRoomRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmSpotlightRoomColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom>(this);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmSpotlightRoom", 3, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("t", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmSpotlightRoomColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmSpotlightRoomColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmSpotlightRoom";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
            RealmSpotlightRoomColumnInfo columnInfo = (RealmSpotlightRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmSpotlightRoomRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.RealmSpotlightRoomRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmSpotlightRoomRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class, json.getString("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final RealmSpotlightRoomRealmProxyInterface objProxy = (RealmSpotlightRoomRealmProxyInterface) obj;
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom obj = new chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom();
        final RealmSpotlightRoomRealmProxyInterface objProxy = (RealmSpotlightRoomRealmProxyInterface) obj;
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
            } else if (name.equals("t")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$t((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$t(null);
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

    public static chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
            RealmSpotlightRoomColumnInfo columnInfo = (RealmSpotlightRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
            long pkColumnIndex = columnInfo._idIndex;
            String value = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$_id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmSpotlightRoomRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class, ((RealmSpotlightRoomRealmProxyInterface) newObject).realmGet$_id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmSpotlightRoomRealmProxyInterface realmObjectSource = (RealmSpotlightRoomRealmProxyInterface) newObject;
        RealmSpotlightRoomRealmProxyInterface realmObjectCopy = (RealmSpotlightRoomRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$t(realmObjectSource.realmGet$t());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmSpotlightRoomColumnInfo columnInfo = (RealmSpotlightRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$name = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$t = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$t();
        if (realmGet$t != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmSpotlightRoomColumnInfo columnInfo = (RealmSpotlightRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$name = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$t = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$t();
            if (realmGet$t != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmSpotlightRoomColumnInfo columnInfo = (RealmSpotlightRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$name = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$t = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$t();
        if (realmGet$t != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long tableNativePtr = table.getNativePtr();
        RealmSpotlightRoomColumnInfo columnInfo = (RealmSpotlightRoomColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$name = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$t = ((RealmSpotlightRoomRealmProxyInterface) object).realmGet$t();
            if (realmGet$t != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tIndex, rowIndex, realmGet$t, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tIndex, rowIndex, false);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmSpotlightRoomRealmProxyInterface unmanagedCopy = (RealmSpotlightRoomRealmProxyInterface) unmanagedObject;
        RealmSpotlightRoomRealmProxyInterface realmSource = (RealmSpotlightRoomRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$t(realmSource.realmGet$t());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom realmObject, chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmSpotlightRoomRealmProxyInterface realmObjectTarget = (RealmSpotlightRoomRealmProxyInterface) realmObject;
        RealmSpotlightRoomRealmProxyInterface realmObjectSource = (RealmSpotlightRoomRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$t(realmObjectSource.realmGet$t());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmSpotlightRoom = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{t:");
        stringBuilder.append(realmGet$t() != null ? realmGet$t() : "null");
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
        RealmSpotlightRoomRealmProxy aRealmSpotlightRoom = (RealmSpotlightRoomRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmSpotlightRoom.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmSpotlightRoom.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmSpotlightRoom.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
