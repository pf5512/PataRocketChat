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
public class LoadMessageProcedureRealmProxy extends chat.rocket.persistence.realm.models.internal.LoadMessageProcedure
    implements RealmObjectProxy, LoadMessageProcedureRealmProxyInterface {

    static final class LoadMessageProcedureColumnInfo extends ColumnInfo {
        long roomIdIndex;
        long syncstateIndex;
        long resetIndex;
        long timestampIndex;
        long countIndex;
        long hasNextIndex;

        LoadMessageProcedureColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LoadMessageProcedure");
            this.roomIdIndex = addColumnDetails("roomId", objectSchemaInfo);
            this.syncstateIndex = addColumnDetails("syncstate", objectSchemaInfo);
            this.resetIndex = addColumnDetails("reset", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", objectSchemaInfo);
            this.countIndex = addColumnDetails("count", objectSchemaInfo);
            this.hasNextIndex = addColumnDetails("hasNext", objectSchemaInfo);
        }

        LoadMessageProcedureColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LoadMessageProcedureColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LoadMessageProcedureColumnInfo src = (LoadMessageProcedureColumnInfo) rawSrc;
            final LoadMessageProcedureColumnInfo dst = (LoadMessageProcedureColumnInfo) rawDst;
            dst.roomIdIndex = src.roomIdIndex;
            dst.syncstateIndex = src.syncstateIndex;
            dst.resetIndex = src.resetIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.countIndex = src.countIndex;
            dst.hasNextIndex = src.hasNextIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("roomId");
        fieldNames.add("syncstate");
        fieldNames.add("reset");
        fieldNames.add("timestamp");
        fieldNames.add("count");
        fieldNames.add("hasNext");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private LoadMessageProcedureColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.internal.LoadMessageProcedure> proxyState;

    LoadMessageProcedureRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LoadMessageProcedureColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.internal.LoadMessageProcedure>(this);
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
    public boolean realmGet$reset() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.resetIndex);
    }

    @Override
    public void realmSet$reset(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.resetIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.resetIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$timestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timestampIndex);
    }

    @Override
    public void realmSet$timestamp(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timestampIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$count() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.countIndex);
    }

    @Override
    public void realmSet$count(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.countIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.countIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$hasNext() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.hasNextIndex);
    }

    @Override
    public void realmSet$hasNext(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.hasNextIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.hasNextIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("LoadMessageProcedure", 6, 0);
        builder.addPersistedProperty("roomId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("syncstate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("reset", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("count", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("hasNext", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LoadMessageProcedureColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LoadMessageProcedureColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "LoadMessageProcedure";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.internal.LoadMessageProcedure createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.internal.LoadMessageProcedure obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
            LoadMessageProcedureColumnInfo columnInfo = (LoadMessageProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class), false, Collections.<String> emptyList());
                    obj = new io.realm.LoadMessageProcedureRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("roomId")) {
                if (json.isNull("roomId")) {
                    obj = (io.realm.LoadMessageProcedureRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.LoadMessageProcedureRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class, json.getString("roomId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'roomId'.");
            }
        }

        final LoadMessageProcedureRealmProxyInterface objProxy = (LoadMessageProcedureRealmProxyInterface) obj;
        if (json.has("syncstate")) {
            if (json.isNull("syncstate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
            } else {
                objProxy.realmSet$syncstate((int) json.getInt("syncstate"));
            }
        }
        if (json.has("reset")) {
            if (json.isNull("reset")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'reset' to null.");
            } else {
                objProxy.realmSet$reset((boolean) json.getBoolean("reset"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
            } else {
                objProxy.realmSet$timestamp((long) json.getLong("timestamp"));
            }
        }
        if (json.has("count")) {
            if (json.isNull("count")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'count' to null.");
            } else {
                objProxy.realmSet$count((int) json.getInt("count"));
            }
        }
        if (json.has("hasNext")) {
            if (json.isNull("hasNext")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hasNext' to null.");
            } else {
                objProxy.realmSet$hasNext((boolean) json.getBoolean("hasNext"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.internal.LoadMessageProcedure createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.internal.LoadMessageProcedure obj = new chat.rocket.persistence.realm.models.internal.LoadMessageProcedure();
        final LoadMessageProcedureRealmProxyInterface objProxy = (LoadMessageProcedureRealmProxyInterface) obj;
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
            } else if (name.equals("reset")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$reset((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'reset' to null.");
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timestamp((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
                }
            } else if (name.equals("count")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$count((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'count' to null.");
                }
            } else if (name.equals("hasNext")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hasNext((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hasNext' to null.");
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

    public static chat.rocket.persistence.realm.models.internal.LoadMessageProcedure copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.LoadMessageProcedure object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.internal.LoadMessageProcedure realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
            LoadMessageProcedureColumnInfo columnInfo = (LoadMessageProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
            long pkColumnIndex = columnInfo.roomIdIndex;
            String value = ((LoadMessageProcedureRealmProxyInterface) object).realmGet$roomId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.LoadMessageProcedureRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.internal.LoadMessageProcedure copy(Realm realm, chat.rocket.persistence.realm.models.internal.LoadMessageProcedure newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.internal.LoadMessageProcedure realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class, ((LoadMessageProcedureRealmProxyInterface) newObject).realmGet$roomId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        LoadMessageProcedureRealmProxyInterface realmObjectSource = (LoadMessageProcedureRealmProxyInterface) newObject;
        LoadMessageProcedureRealmProxyInterface realmObjectCopy = (LoadMessageProcedureRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectCopy.realmSet$reset(realmObjectSource.realmGet$reset());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        realmObjectCopy.realmSet$count(realmObjectSource.realmGet$count());
        realmObjectCopy.realmSet$hasNext(realmObjectSource.realmGet$hasNext());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.internal.LoadMessageProcedure object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long tableNativePtr = table.getNativePtr();
        LoadMessageProcedureColumnInfo columnInfo = (LoadMessageProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        String primaryKeyValue = ((LoadMessageProcedureRealmProxyInterface) object).realmGet$roomId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.resetIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$reset(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$timestamp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$count(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hasNextIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$hasNext(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long tableNativePtr = table.getNativePtr();
        LoadMessageProcedureColumnInfo columnInfo = (LoadMessageProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        chat.rocket.persistence.realm.models.internal.LoadMessageProcedure object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((LoadMessageProcedureRealmProxyInterface) object).realmGet$roomId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.resetIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$reset(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$timestamp(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$count(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hasNextIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$hasNext(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.LoadMessageProcedure object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long tableNativePtr = table.getNativePtr();
        LoadMessageProcedureColumnInfo columnInfo = (LoadMessageProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        String primaryKeyValue = ((LoadMessageProcedureRealmProxyInterface) object).realmGet$roomId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.resetIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$reset(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$timestamp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$count(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.hasNextIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$hasNext(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long tableNativePtr = table.getNativePtr();
        LoadMessageProcedureColumnInfo columnInfo = (LoadMessageProcedureColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        long pkColumnIndex = columnInfo.roomIdIndex;
        chat.rocket.persistence.realm.models.internal.LoadMessageProcedure object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((LoadMessageProcedureRealmProxyInterface) object).realmGet$roomId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$syncstate(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.resetIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$reset(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$timestamp(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.countIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$count(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.hasNextIndex, rowIndex, ((LoadMessageProcedureRealmProxyInterface) object).realmGet$hasNext(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.internal.LoadMessageProcedure createDetachedCopy(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.internal.LoadMessageProcedure unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.internal.LoadMessageProcedure();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        LoadMessageProcedureRealmProxyInterface unmanagedCopy = (LoadMessageProcedureRealmProxyInterface) unmanagedObject;
        LoadMessageProcedureRealmProxyInterface realmSource = (LoadMessageProcedureRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$roomId(realmSource.realmGet$roomId());
        unmanagedCopy.realmSet$syncstate(realmSource.realmGet$syncstate());
        unmanagedCopy.realmSet$reset(realmSource.realmGet$reset());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());
        unmanagedCopy.realmSet$count(realmSource.realmGet$count());
        unmanagedCopy.realmSet$hasNext(realmSource.realmGet$hasNext());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.internal.LoadMessageProcedure update(Realm realm, chat.rocket.persistence.realm.models.internal.LoadMessageProcedure realmObject, chat.rocket.persistence.realm.models.internal.LoadMessageProcedure newObject, Map<RealmModel, RealmObjectProxy> cache) {
        LoadMessageProcedureRealmProxyInterface realmObjectTarget = (LoadMessageProcedureRealmProxyInterface) realmObject;
        LoadMessageProcedureRealmProxyInterface realmObjectSource = (LoadMessageProcedureRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectTarget.realmSet$reset(realmObjectSource.realmGet$reset());
        realmObjectTarget.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        realmObjectTarget.realmSet$count(realmObjectSource.realmGet$count());
        realmObjectTarget.realmSet$hasNext(realmObjectSource.realmGet$hasNext());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LoadMessageProcedure = proxy[");
        stringBuilder.append("{roomId:");
        stringBuilder.append(realmGet$roomId() != null ? realmGet$roomId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{syncstate:");
        stringBuilder.append(realmGet$syncstate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reset:");
        stringBuilder.append(realmGet$reset());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{count:");
        stringBuilder.append(realmGet$count());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hasNext:");
        stringBuilder.append(realmGet$hasNext());
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
        LoadMessageProcedureRealmProxy aLoadMessageProcedure = (LoadMessageProcedureRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLoadMessageProcedure.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLoadMessageProcedure.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLoadMessageProcedure.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
