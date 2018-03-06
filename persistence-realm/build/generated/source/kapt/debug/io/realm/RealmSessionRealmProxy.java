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
public class RealmSessionRealmProxy extends chat.rocket.persistence.realm.models.internal.RealmSession
    implements RealmObjectProxy, RealmSessionRealmProxyInterface {

    static final class RealmSessionColumnInfo extends ColumnInfo {
        long sessionIdIndex;
        long tokenIndex;
        long tokenVerifiedIndex;
        long errorIndex;

        RealmSessionColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmSession");
            this.sessionIdIndex = addColumnDetails("sessionId", objectSchemaInfo);
            this.tokenIndex = addColumnDetails("token", objectSchemaInfo);
            this.tokenVerifiedIndex = addColumnDetails("tokenVerified", objectSchemaInfo);
            this.errorIndex = addColumnDetails("error", objectSchemaInfo);
        }

        RealmSessionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmSessionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmSessionColumnInfo src = (RealmSessionColumnInfo) rawSrc;
            final RealmSessionColumnInfo dst = (RealmSessionColumnInfo) rawDst;
            dst.sessionIdIndex = src.sessionIdIndex;
            dst.tokenIndex = src.tokenIndex;
            dst.tokenVerifiedIndex = src.tokenVerifiedIndex;
            dst.errorIndex = src.errorIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(4);
        fieldNames.add("sessionId");
        fieldNames.add("token");
        fieldNames.add("tokenVerified");
        fieldNames.add("error");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmSessionColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.internal.RealmSession> proxyState;

    RealmSessionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmSessionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.internal.RealmSession>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sessionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sessionIdIndex);
    }

    @Override
    public void realmSet$sessionId(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'sessionId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$token() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tokenIndex);
    }

    @Override
    public void realmSet$token(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tokenIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tokenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tokenIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tokenIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$tokenVerified() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.tokenVerifiedIndex);
    }

    @Override
    public void realmSet$tokenVerified(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.tokenVerifiedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.tokenVerifiedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$error() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.errorIndex);
    }

    @Override
    public void realmSet$error(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.errorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.errorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.errorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.errorIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmSession", 4, 0);
        builder.addPersistedProperty("sessionId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("token", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("tokenVerified", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("error", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmSessionColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmSessionColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmSession";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.internal.RealmSession createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.internal.RealmSession obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.RealmSession.class);
            RealmSessionColumnInfo columnInfo = (RealmSessionColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class);
            long pkColumnIndex = columnInfo.sessionIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("sessionId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("sessionId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmSessionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("sessionId")) {
                if (json.isNull("sessionId")) {
                    obj = (io.realm.RealmSessionRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.RealmSession.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmSessionRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.RealmSession.class, json.getInt("sessionId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'sessionId'.");
            }
        }

        final RealmSessionRealmProxyInterface objProxy = (RealmSessionRealmProxyInterface) obj;
        if (json.has("token")) {
            if (json.isNull("token")) {
                objProxy.realmSet$token(null);
            } else {
                objProxy.realmSet$token((String) json.getString("token"));
            }
        }
        if (json.has("tokenVerified")) {
            if (json.isNull("tokenVerified")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'tokenVerified' to null.");
            } else {
                objProxy.realmSet$tokenVerified((boolean) json.getBoolean("tokenVerified"));
            }
        }
        if (json.has("error")) {
            if (json.isNull("error")) {
                objProxy.realmSet$error(null);
            } else {
                objProxy.realmSet$error((String) json.getString("error"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.internal.RealmSession createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.internal.RealmSession obj = new chat.rocket.persistence.realm.models.internal.RealmSession();
        final RealmSessionRealmProxyInterface objProxy = (RealmSessionRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("sessionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sessionId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sessionId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("token")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$token((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$token(null);
                }
            } else if (name.equals("tokenVerified")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tokenVerified((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'tokenVerified' to null.");
                }
            } else if (name.equals("error")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$error((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$error(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'sessionId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.internal.RealmSession copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.RealmSession object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.internal.RealmSession) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.internal.RealmSession realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.RealmSession.class);
            RealmSessionColumnInfo columnInfo = (RealmSessionColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class);
            long pkColumnIndex = columnInfo.sessionIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmSessionRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.internal.RealmSession copy(Realm realm, chat.rocket.persistence.realm.models.internal.RealmSession newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.internal.RealmSession) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.internal.RealmSession realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.RealmSession.class, ((RealmSessionRealmProxyInterface) newObject).realmGet$sessionId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmSessionRealmProxyInterface realmObjectSource = (RealmSessionRealmProxyInterface) newObject;
        RealmSessionRealmProxyInterface realmObjectCopy = (RealmSessionRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$token(realmObjectSource.realmGet$token());
        realmObjectCopy.realmSet$tokenVerified(realmObjectSource.realmGet$tokenVerified());
        realmObjectCopy.realmSet$error(realmObjectSource.realmGet$error());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.internal.RealmSession object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long tableNativePtr = table.getNativePtr();
        RealmSessionColumnInfo columnInfo = (RealmSessionColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long pkColumnIndex = columnInfo.sessionIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmSessionRealmProxyInterface) object).realmGet$sessionId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$token = ((RealmSessionRealmProxyInterface) object).realmGet$token();
        if (realmGet$token != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.tokenVerifiedIndex, rowIndex, ((RealmSessionRealmProxyInterface) object).realmGet$tokenVerified(), false);
        String realmGet$error = ((RealmSessionRealmProxyInterface) object).realmGet$error();
        if (realmGet$error != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long tableNativePtr = table.getNativePtr();
        RealmSessionColumnInfo columnInfo = (RealmSessionColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long pkColumnIndex = columnInfo.sessionIdIndex;
        chat.rocket.persistence.realm.models.internal.RealmSession object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.RealmSession) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmSessionRealmProxyInterface) object).realmGet$sessionId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$token = ((RealmSessionRealmProxyInterface) object).realmGet$token();
            if (realmGet$token != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.tokenVerifiedIndex, rowIndex, ((RealmSessionRealmProxyInterface) object).realmGet$tokenVerified(), false);
            String realmGet$error = ((RealmSessionRealmProxyInterface) object).realmGet$error();
            if (realmGet$error != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.RealmSession object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long tableNativePtr = table.getNativePtr();
        RealmSessionColumnInfo columnInfo = (RealmSessionColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long pkColumnIndex = columnInfo.sessionIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmSessionRealmProxyInterface) object).realmGet$sessionId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
        }
        cache.put(object, rowIndex);
        String realmGet$token = ((RealmSessionRealmProxyInterface) object).realmGet$token();
        if (realmGet$token != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tokenIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.tokenVerifiedIndex, rowIndex, ((RealmSessionRealmProxyInterface) object).realmGet$tokenVerified(), false);
        String realmGet$error = ((RealmSessionRealmProxyInterface) object).realmGet$error();
        if (realmGet$error != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.errorIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long tableNativePtr = table.getNativePtr();
        RealmSessionColumnInfo columnInfo = (RealmSessionColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        long pkColumnIndex = columnInfo.sessionIdIndex;
        chat.rocket.persistence.realm.models.internal.RealmSession object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.RealmSession) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmSessionRealmProxyInterface) object).realmGet$sessionId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((RealmSessionRealmProxyInterface) object).realmGet$sessionId());
            }
            cache.put(object, rowIndex);
            String realmGet$token = ((RealmSessionRealmProxyInterface) object).realmGet$token();
            if (realmGet$token != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tokenIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.tokenVerifiedIndex, rowIndex, ((RealmSessionRealmProxyInterface) object).realmGet$tokenVerified(), false);
            String realmGet$error = ((RealmSessionRealmProxyInterface) object).realmGet$error();
            if (realmGet$error != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.errorIndex, rowIndex, false);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.internal.RealmSession createDetachedCopy(chat.rocket.persistence.realm.models.internal.RealmSession realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.internal.RealmSession unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.internal.RealmSession();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.internal.RealmSession) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.internal.RealmSession) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmSessionRealmProxyInterface unmanagedCopy = (RealmSessionRealmProxyInterface) unmanagedObject;
        RealmSessionRealmProxyInterface realmSource = (RealmSessionRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$sessionId(realmSource.realmGet$sessionId());
        unmanagedCopy.realmSet$token(realmSource.realmGet$token());
        unmanagedCopy.realmSet$tokenVerified(realmSource.realmGet$tokenVerified());
        unmanagedCopy.realmSet$error(realmSource.realmGet$error());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.internal.RealmSession update(Realm realm, chat.rocket.persistence.realm.models.internal.RealmSession realmObject, chat.rocket.persistence.realm.models.internal.RealmSession newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmSessionRealmProxyInterface realmObjectTarget = (RealmSessionRealmProxyInterface) realmObject;
        RealmSessionRealmProxyInterface realmObjectSource = (RealmSessionRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$token(realmObjectSource.realmGet$token());
        realmObjectTarget.realmSet$tokenVerified(realmObjectSource.realmGet$tokenVerified());
        realmObjectTarget.realmSet$error(realmObjectSource.realmGet$error());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmSession = proxy[");
        stringBuilder.append("{sessionId:");
        stringBuilder.append(realmGet$sessionId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{token:");
        stringBuilder.append(realmGet$token() != null ? realmGet$token() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tokenVerified:");
        stringBuilder.append(realmGet$tokenVerified());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{error:");
        stringBuilder.append(realmGet$error() != null ? realmGet$error() : "null");
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
        RealmSessionRealmProxy aRealmSession = (RealmSessionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmSession.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmSession.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmSession.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
