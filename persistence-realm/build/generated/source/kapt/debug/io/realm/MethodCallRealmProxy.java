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
public class MethodCallRealmProxy extends chat.rocket.persistence.realm.models.internal.MethodCall
    implements RealmObjectProxy, MethodCallRealmProxyInterface {

    static final class MethodCallColumnInfo extends ColumnInfo {
        long methodCallIdIndex;
        long syncstateIndex;
        long nameIndex;
        long paramsJsonIndex;
        long resultJsonIndex;
        long timeoutIndex;

        MethodCallColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MethodCall");
            this.methodCallIdIndex = addColumnDetails("methodCallId", objectSchemaInfo);
            this.syncstateIndex = addColumnDetails("syncstate", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.paramsJsonIndex = addColumnDetails("paramsJson", objectSchemaInfo);
            this.resultJsonIndex = addColumnDetails("resultJson", objectSchemaInfo);
            this.timeoutIndex = addColumnDetails("timeout", objectSchemaInfo);
        }

        MethodCallColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MethodCallColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MethodCallColumnInfo src = (MethodCallColumnInfo) rawSrc;
            final MethodCallColumnInfo dst = (MethodCallColumnInfo) rawDst;
            dst.methodCallIdIndex = src.methodCallIdIndex;
            dst.syncstateIndex = src.syncstateIndex;
            dst.nameIndex = src.nameIndex;
            dst.paramsJsonIndex = src.paramsJsonIndex;
            dst.resultJsonIndex = src.resultJsonIndex;
            dst.timeoutIndex = src.timeoutIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("methodCallId");
        fieldNames.add("syncstate");
        fieldNames.add("name");
        fieldNames.add("paramsJson");
        fieldNames.add("resultJson");
        fieldNames.add("timeout");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private MethodCallColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.internal.MethodCall> proxyState;

    MethodCallRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MethodCallColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.internal.MethodCall>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$methodCallId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.methodCallIdIndex);
    }

    @Override
    public void realmSet$methodCallId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'methodCallId' cannot be changed after object was created.");
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
    public String realmGet$paramsJson() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paramsJsonIndex);
    }

    @Override
    public void realmSet$paramsJson(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.paramsJsonIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paramsJsonIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paramsJsonIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paramsJsonIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$resultJson() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.resultJsonIndex);
    }

    @Override
    public void realmSet$resultJson(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.resultJsonIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.resultJsonIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.resultJsonIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.resultJsonIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$timeout() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timeoutIndex);
    }

    @Override
    public void realmSet$timeout(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeoutIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeoutIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MethodCall", 6, 0);
        builder.addPersistedProperty("methodCallId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("syncstate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("paramsJson", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("resultJson", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timeout", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MethodCallColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MethodCallColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MethodCall";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.internal.MethodCall createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.internal.MethodCall obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.MethodCall.class);
            MethodCallColumnInfo columnInfo = (MethodCallColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class);
            long pkColumnIndex = columnInfo.methodCallIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("methodCallId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("methodCallId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MethodCallRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("methodCallId")) {
                if (json.isNull("methodCallId")) {
                    obj = (io.realm.MethodCallRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.MethodCall.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MethodCallRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.MethodCall.class, json.getString("methodCallId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'methodCallId'.");
            }
        }

        final MethodCallRealmProxyInterface objProxy = (MethodCallRealmProxyInterface) obj;
        if (json.has("syncstate")) {
            if (json.isNull("syncstate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
            } else {
                objProxy.realmSet$syncstate((int) json.getInt("syncstate"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("paramsJson")) {
            if (json.isNull("paramsJson")) {
                objProxy.realmSet$paramsJson(null);
            } else {
                objProxy.realmSet$paramsJson((String) json.getString("paramsJson"));
            }
        }
        if (json.has("resultJson")) {
            if (json.isNull("resultJson")) {
                objProxy.realmSet$resultJson(null);
            } else {
                objProxy.realmSet$resultJson((String) json.getString("resultJson"));
            }
        }
        if (json.has("timeout")) {
            if (json.isNull("timeout")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timeout' to null.");
            } else {
                objProxy.realmSet$timeout((long) json.getLong("timeout"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.internal.MethodCall createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.internal.MethodCall obj = new chat.rocket.persistence.realm.models.internal.MethodCall();
        final MethodCallRealmProxyInterface objProxy = (MethodCallRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("methodCallId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$methodCallId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$methodCallId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("syncstate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$syncstate((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("paramsJson")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$paramsJson((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$paramsJson(null);
                }
            } else if (name.equals("resultJson")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$resultJson((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$resultJson(null);
                }
            } else if (name.equals("timeout")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timeout((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timeout' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'methodCallId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.internal.MethodCall copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.MethodCall object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.internal.MethodCall) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.internal.MethodCall realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.MethodCall.class);
            MethodCallColumnInfo columnInfo = (MethodCallColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class);
            long pkColumnIndex = columnInfo.methodCallIdIndex;
            String value = ((MethodCallRealmProxyInterface) object).realmGet$methodCallId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.MethodCallRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.internal.MethodCall copy(Realm realm, chat.rocket.persistence.realm.models.internal.MethodCall newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.internal.MethodCall) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.internal.MethodCall realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.MethodCall.class, ((MethodCallRealmProxyInterface) newObject).realmGet$methodCallId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        MethodCallRealmProxyInterface realmObjectSource = (MethodCallRealmProxyInterface) newObject;
        MethodCallRealmProxyInterface realmObjectCopy = (MethodCallRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$paramsJson(realmObjectSource.realmGet$paramsJson());
        realmObjectCopy.realmSet$resultJson(realmObjectSource.realmGet$resultJson());
        realmObjectCopy.realmSet$timeout(realmObjectSource.realmGet$timeout());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.internal.MethodCall object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long tableNativePtr = table.getNativePtr();
        MethodCallColumnInfo columnInfo = (MethodCallColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long pkColumnIndex = columnInfo.methodCallIdIndex;
        String primaryKeyValue = ((MethodCallRealmProxyInterface) object).realmGet$methodCallId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$syncstate(), false);
        String realmGet$name = ((MethodCallRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$paramsJson = ((MethodCallRealmProxyInterface) object).realmGet$paramsJson();
        if (realmGet$paramsJson != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramsJsonIndex, rowIndex, realmGet$paramsJson, false);
        }
        String realmGet$resultJson = ((MethodCallRealmProxyInterface) object).realmGet$resultJson();
        if (realmGet$resultJson != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.resultJsonIndex, rowIndex, realmGet$resultJson, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeoutIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$timeout(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long tableNativePtr = table.getNativePtr();
        MethodCallColumnInfo columnInfo = (MethodCallColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long pkColumnIndex = columnInfo.methodCallIdIndex;
        chat.rocket.persistence.realm.models.internal.MethodCall object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.MethodCall) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((MethodCallRealmProxyInterface) object).realmGet$methodCallId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$syncstate(), false);
            String realmGet$name = ((MethodCallRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$paramsJson = ((MethodCallRealmProxyInterface) object).realmGet$paramsJson();
            if (realmGet$paramsJson != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.paramsJsonIndex, rowIndex, realmGet$paramsJson, false);
            }
            String realmGet$resultJson = ((MethodCallRealmProxyInterface) object).realmGet$resultJson();
            if (realmGet$resultJson != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.resultJsonIndex, rowIndex, realmGet$resultJson, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timeoutIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$timeout(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.MethodCall object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long tableNativePtr = table.getNativePtr();
        MethodCallColumnInfo columnInfo = (MethodCallColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long pkColumnIndex = columnInfo.methodCallIdIndex;
        String primaryKeyValue = ((MethodCallRealmProxyInterface) object).realmGet$methodCallId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$syncstate(), false);
        String realmGet$name = ((MethodCallRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$paramsJson = ((MethodCallRealmProxyInterface) object).realmGet$paramsJson();
        if (realmGet$paramsJson != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paramsJsonIndex, rowIndex, realmGet$paramsJson, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paramsJsonIndex, rowIndex, false);
        }
        String realmGet$resultJson = ((MethodCallRealmProxyInterface) object).realmGet$resultJson();
        if (realmGet$resultJson != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.resultJsonIndex, rowIndex, realmGet$resultJson, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.resultJsonIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeoutIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$timeout(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long tableNativePtr = table.getNativePtr();
        MethodCallColumnInfo columnInfo = (MethodCallColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        long pkColumnIndex = columnInfo.methodCallIdIndex;
        chat.rocket.persistence.realm.models.internal.MethodCall object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.MethodCall) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((MethodCallRealmProxyInterface) object).realmGet$methodCallId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$syncstate(), false);
            String realmGet$name = ((MethodCallRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$paramsJson = ((MethodCallRealmProxyInterface) object).realmGet$paramsJson();
            if (realmGet$paramsJson != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.paramsJsonIndex, rowIndex, realmGet$paramsJson, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.paramsJsonIndex, rowIndex, false);
            }
            String realmGet$resultJson = ((MethodCallRealmProxyInterface) object).realmGet$resultJson();
            if (realmGet$resultJson != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.resultJsonIndex, rowIndex, realmGet$resultJson, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.resultJsonIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timeoutIndex, rowIndex, ((MethodCallRealmProxyInterface) object).realmGet$timeout(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.internal.MethodCall createDetachedCopy(chat.rocket.persistence.realm.models.internal.MethodCall realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.internal.MethodCall unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.internal.MethodCall();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.internal.MethodCall) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.internal.MethodCall) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        MethodCallRealmProxyInterface unmanagedCopy = (MethodCallRealmProxyInterface) unmanagedObject;
        MethodCallRealmProxyInterface realmSource = (MethodCallRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$methodCallId(realmSource.realmGet$methodCallId());
        unmanagedCopy.realmSet$syncstate(realmSource.realmGet$syncstate());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$paramsJson(realmSource.realmGet$paramsJson());
        unmanagedCopy.realmSet$resultJson(realmSource.realmGet$resultJson());
        unmanagedCopy.realmSet$timeout(realmSource.realmGet$timeout());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.internal.MethodCall update(Realm realm, chat.rocket.persistence.realm.models.internal.MethodCall realmObject, chat.rocket.persistence.realm.models.internal.MethodCall newObject, Map<RealmModel, RealmObjectProxy> cache) {
        MethodCallRealmProxyInterface realmObjectTarget = (MethodCallRealmProxyInterface) realmObject;
        MethodCallRealmProxyInterface realmObjectSource = (MethodCallRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$paramsJson(realmObjectSource.realmGet$paramsJson());
        realmObjectTarget.realmSet$resultJson(realmObjectSource.realmGet$resultJson());
        realmObjectTarget.realmSet$timeout(realmObjectSource.realmGet$timeout());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MethodCall = proxy[");
        stringBuilder.append("{methodCallId:");
        stringBuilder.append(realmGet$methodCallId() != null ? realmGet$methodCallId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{syncstate:");
        stringBuilder.append(realmGet$syncstate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paramsJson:");
        stringBuilder.append(realmGet$paramsJson() != null ? realmGet$paramsJson() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{resultJson:");
        stringBuilder.append(realmGet$resultJson() != null ? realmGet$resultJson() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timeout:");
        stringBuilder.append(realmGet$timeout());
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
        MethodCallRealmProxy aMethodCall = (MethodCallRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMethodCall.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMethodCall.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMethodCall.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
