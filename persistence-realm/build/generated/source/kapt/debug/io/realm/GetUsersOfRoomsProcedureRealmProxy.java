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
public class GetUsersOfRoomsProcedureRealmProxy extends chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure
    implements RealmObjectProxy, GetUsersOfRoomsProcedureRealmProxyInterface {

    static final class GetUsersOfRoomsProcedureColumnInfo extends ColumnInfo {
        long roomIdIndex;
        long syncstateIndex;
        long showAllIndex;
        long totalIndex;
        long recordsIndex;

        GetUsersOfRoomsProcedureColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GetUsersOfRoomsProcedure");
            this.roomIdIndex = addColumnDetails("roomId", objectSchemaInfo);
            this.syncstateIndex = addColumnDetails("syncstate", objectSchemaInfo);
            this.showAllIndex = addColumnDetails("showAll", objectSchemaInfo);
            this.totalIndex = addColumnDetails("total", objectSchemaInfo);
            this.recordsIndex = addColumnDetails("records", objectSchemaInfo);
        }

        GetUsersOfRoomsProcedureColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GetUsersOfRoomsProcedureColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GetUsersOfRoomsProcedureColumnInfo src = (GetUsersOfRoomsProcedureColumnInfo) rawSrc;
            final GetUsersOfRoomsProcedureColumnInfo dst = (GetUsersOfRoomsProcedureColumnInfo) rawDst;
            dst.roomIdIndex = src.roomIdIndex;
            dst.syncstateIndex = src.syncstateIndex;
            dst.showAllIndex = src.showAllIndex;
            dst.totalIndex = src.totalIndex;
            dst.recordsIndex = src.recordsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(5);
        fieldNames.add("roomId");
        fieldNames.add("syncstate");
        fieldNames.add("showAll");
        fieldNames.add("total");
        fieldNames.add("records");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private GetUsersOfRoomsProcedureColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure> proxyState;

    GetUsersOfRoomsProcedureRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GetUsersOfRoomsProcedureColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$roomId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.roomIdIndex);
    }

    @Override
    public void realmSet$roomId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'roomId' cannot be changed after object was created.");
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
    public boolean realmGet$showAll() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.showAllIndex);
    }

    @Override
    public void realmSet$showAll(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.showAllIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.showAllIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$total() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.totalIndex);
    }

    @Override
    public void realmSet$total(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$records() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.recordsIndex);
    }

    @Override
    public void realmSet$records(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.recordsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.recordsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.recordsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.recordsIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GetUsersOfRoomsProcedure", 5, 0);
        builder.addPersistedProperty("roomId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("syncstate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("showAll", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("total", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("records", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GetUsersOfRoomsProcedureColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GetUsersOfRoomsProcedureColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GetUsersOfRoomsProcedure";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
            GetUsersOfRoomsProcedureColumnInfo columnInfo = (GetUsersOfRoomsProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
            long pkColumnIndex = columnInfo.roomIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("roomId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("roomId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GetUsersOfRoomsProcedureRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("roomId")) {
                if (json.isNull("roomId")) {
                    obj = (io.realm.GetUsersOfRoomsProcedureRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GetUsersOfRoomsProcedureRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class, json.getString("roomId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'roomId'.");
            }
        }

        final GetUsersOfRoomsProcedureRealmProxyInterface objProxy = (GetUsersOfRoomsProcedureRealmProxyInterface) obj;
        if (json.has("syncstate")) {
            if (json.isNull("syncstate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
            } else {
                objProxy.realmSet$syncstate((int) json.getInt("syncstate"));
            }
        }
        if (json.has("showAll")) {
            if (json.isNull("showAll")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showAll' to null.");
            } else {
                objProxy.realmSet$showAll((boolean) json.getBoolean("showAll"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
            } else {
                objProxy.realmSet$total((long) json.getLong("total"));
            }
        }
        if (json.has("records")) {
            if (json.isNull("records")) {
                objProxy.realmSet$records(null);
            } else {
                objProxy.realmSet$records((String) json.getString("records"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure obj = new chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure();
        final GetUsersOfRoomsProcedureRealmProxyInterface objProxy = (GetUsersOfRoomsProcedureRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("roomId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$roomId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$roomId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("syncstate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$syncstate((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
                }
            } else if (name.equals("showAll")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$showAll((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'showAll' to null.");
                }
            } else if (name.equals("total")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$total((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
                }
            } else if (name.equals("records")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$records((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$records(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'roomId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
            GetUsersOfRoomsProcedureColumnInfo columnInfo = (GetUsersOfRoomsProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
            long pkColumnIndex = columnInfo.roomIdIndex;
            String value = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$roomId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.GetUsersOfRoomsProcedureRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure copy(Realm realm, chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class, ((GetUsersOfRoomsProcedureRealmProxyInterface) newObject).realmGet$roomId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        GetUsersOfRoomsProcedureRealmProxyInterface realmObjectSource = (GetUsersOfRoomsProcedureRealmProxyInterface) newObject;
        GetUsersOfRoomsProcedureRealmProxyInterface realmObjectCopy = (GetUsersOfRoomsProcedureRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectCopy.realmSet$showAll(realmObjectSource.realmGet$showAll());
        realmObjectCopy.realmSet$total(realmObjectSource.realmGet$total());
        realmObjectCopy.realmSet$records(realmObjectSource.realmGet$records());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long tableNativePtr = table.getNativePtr();
        GetUsersOfRoomsProcedureColumnInfo columnInfo = (GetUsersOfRoomsProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        String primaryKeyValue = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$roomId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.showAllIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$showAll(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$total(), false);
        String realmGet$records = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$records();
        if (realmGet$records != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recordsIndex, rowIndex, realmGet$records, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long tableNativePtr = table.getNativePtr();
        GetUsersOfRoomsProcedureColumnInfo columnInfo = (GetUsersOfRoomsProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$roomId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.showAllIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$showAll(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.totalIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$total(), false);
            String realmGet$records = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$records();
            if (realmGet$records != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recordsIndex, rowIndex, realmGet$records, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long tableNativePtr = table.getNativePtr();
        GetUsersOfRoomsProcedureColumnInfo columnInfo = (GetUsersOfRoomsProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        String primaryKeyValue = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$roomId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.showAllIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$showAll(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$total(), false);
        String realmGet$records = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$records();
        if (realmGet$records != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recordsIndex, rowIndex, realmGet$records, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.recordsIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long tableNativePtr = table.getNativePtr();
        GetUsersOfRoomsProcedureColumnInfo columnInfo = (GetUsersOfRoomsProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$roomId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.showAllIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$showAll(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.totalIndex, rowIndex, ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$total(), false);
            String realmGet$records = ((GetUsersOfRoomsProcedureRealmProxyInterface) object).realmGet$records();
            if (realmGet$records != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recordsIndex, rowIndex, realmGet$records, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.recordsIndex, rowIndex, false);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure createDetachedCopy(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        GetUsersOfRoomsProcedureRealmProxyInterface unmanagedCopy = (GetUsersOfRoomsProcedureRealmProxyInterface) unmanagedObject;
        GetUsersOfRoomsProcedureRealmProxyInterface realmSource = (GetUsersOfRoomsProcedureRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$roomId(realmSource.realmGet$roomId());
        unmanagedCopy.realmSet$syncstate(realmSource.realmGet$syncstate());
        unmanagedCopy.realmSet$showAll(realmSource.realmGet$showAll());
        unmanagedCopy.realmSet$total(realmSource.realmGet$total());
        unmanagedCopy.realmSet$records(realmSource.realmGet$records());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure update(Realm realm, chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure realmObject, chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure newObject, Map<RealmModel, RealmObjectProxy> cache) {
        GetUsersOfRoomsProcedureRealmProxyInterface realmObjectTarget = (GetUsersOfRoomsProcedureRealmProxyInterface) realmObject;
        GetUsersOfRoomsProcedureRealmProxyInterface realmObjectSource = (GetUsersOfRoomsProcedureRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectTarget.realmSet$showAll(realmObjectSource.realmGet$showAll());
        realmObjectTarget.realmSet$total(realmObjectSource.realmGet$total());
        realmObjectTarget.realmSet$records(realmObjectSource.realmGet$records());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GetUsersOfRoomsProcedure = proxy[");
        stringBuilder.append("{roomId:");
        stringBuilder.append(realmGet$roomId() != null ? realmGet$roomId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{syncstate:");
        stringBuilder.append(realmGet$syncstate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{showAll:");
        stringBuilder.append(realmGet$showAll());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{records:");
        stringBuilder.append(realmGet$records() != null ? realmGet$records() : "null");
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
        GetUsersOfRoomsProcedureRealmProxy aGetUsersOfRoomsProcedure = (GetUsersOfRoomsProcedureRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGetUsersOfRoomsProcedure.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGetUsersOfRoomsProcedure.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGetUsersOfRoomsProcedure.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
