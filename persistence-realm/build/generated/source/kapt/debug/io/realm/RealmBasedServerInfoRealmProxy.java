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
public class RealmBasedServerInfoRealmProxy extends chat.rocket.persistence.realm.models.RealmBasedServerInfo
    implements RealmObjectProxy, RealmBasedServerInfoRealmProxyInterface {

    static final class RealmBasedServerInfoColumnInfo extends ColumnInfo {
        long hostnameIndex;
        long nameIndex;
        long sessionIndex;
        long insecureIndex;

        RealmBasedServerInfoColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmBasedServerInfo");
            this.hostnameIndex = addColumnDetails("hostname", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.sessionIndex = addColumnDetails("session", objectSchemaInfo);
            this.insecureIndex = addColumnDetails("insecure", objectSchemaInfo);
        }

        RealmBasedServerInfoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmBasedServerInfoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmBasedServerInfoColumnInfo src = (RealmBasedServerInfoColumnInfo) rawSrc;
            final RealmBasedServerInfoColumnInfo dst = (RealmBasedServerInfoColumnInfo) rawDst;
            dst.hostnameIndex = src.hostnameIndex;
            dst.nameIndex = src.nameIndex;
            dst.sessionIndex = src.sessionIndex;
            dst.insecureIndex = src.insecureIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(4);
        fieldNames.add("hostname");
        fieldNames.add("name");
        fieldNames.add("session");
        fieldNames.add("insecure");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmBasedServerInfoColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.RealmBasedServerInfo> proxyState;

    RealmBasedServerInfoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmBasedServerInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.RealmBasedServerInfo>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$hostname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.hostnameIndex);
    }

    @Override
    public void realmSet$hostname(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'hostname' cannot be changed after object was created.");
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
    public String realmGet$session() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sessionIndex);
    }

    @Override
    public void realmSet$session(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sessionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sessionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sessionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sessionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$insecure() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.insecureIndex);
    }

    @Override
    public void realmSet$insecure(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.insecureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.insecureIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmBasedServerInfo", 4, 0);
        builder.addPersistedProperty("hostname", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("session", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("insecure", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmBasedServerInfoColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmBasedServerInfoColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmBasedServerInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.RealmBasedServerInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.RealmBasedServerInfo obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
            RealmBasedServerInfoColumnInfo columnInfo = (RealmBasedServerInfoColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
            long pkColumnIndex = columnInfo.hostnameIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("hostname")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("hostname"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmBasedServerInfoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("hostname")) {
                if (json.isNull("hostname")) {
                    obj = (io.realm.RealmBasedServerInfoRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmBasedServerInfoRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class, json.getString("hostname"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'hostname'.");
            }
        }

        final RealmBasedServerInfoRealmProxyInterface objProxy = (RealmBasedServerInfoRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("session")) {
            if (json.isNull("session")) {
                objProxy.realmSet$session(null);
            } else {
                objProxy.realmSet$session((String) json.getString("session"));
            }
        }
        if (json.has("insecure")) {
            if (json.isNull("insecure")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'insecure' to null.");
            } else {
                objProxy.realmSet$insecure((boolean) json.getBoolean("insecure"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.RealmBasedServerInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.RealmBasedServerInfo obj = new chat.rocket.persistence.realm.models.RealmBasedServerInfo();
        final RealmBasedServerInfoRealmProxyInterface objProxy = (RealmBasedServerInfoRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("hostname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hostname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$hostname(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("session")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$session((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$session(null);
                }
            } else if (name.equals("insecure")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$insecure((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'insecure' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'hostname'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.RealmBasedServerInfo copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.RealmBasedServerInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.RealmBasedServerInfo) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.RealmBasedServerInfo realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
            RealmBasedServerInfoColumnInfo columnInfo = (RealmBasedServerInfoColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
            long pkColumnIndex = columnInfo.hostnameIndex;
            String value = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$hostname();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmBasedServerInfoRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.RealmBasedServerInfo copy(Realm realm, chat.rocket.persistence.realm.models.RealmBasedServerInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.RealmBasedServerInfo) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.RealmBasedServerInfo realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class, ((RealmBasedServerInfoRealmProxyInterface) newObject).realmGet$hostname(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmBasedServerInfoRealmProxyInterface realmObjectSource = (RealmBasedServerInfoRealmProxyInterface) newObject;
        RealmBasedServerInfoRealmProxyInterface realmObjectCopy = (RealmBasedServerInfoRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$session(realmObjectSource.realmGet$session());
        realmObjectCopy.realmSet$insecure(realmObjectSource.realmGet$insecure());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.RealmBasedServerInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasedServerInfoColumnInfo columnInfo = (RealmBasedServerInfoColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long pkColumnIndex = columnInfo.hostnameIndex;
        String primaryKeyValue = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$hostname();
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
        String realmGet$name = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$session = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$session();
        if (realmGet$session != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sessionIndex, rowIndex, realmGet$session, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.insecureIndex, rowIndex, ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$insecure(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasedServerInfoColumnInfo columnInfo = (RealmBasedServerInfoColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long pkColumnIndex = columnInfo.hostnameIndex;
        chat.rocket.persistence.realm.models.RealmBasedServerInfo object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.RealmBasedServerInfo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$hostname();
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
            String realmGet$name = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$session = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$session();
            if (realmGet$session != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sessionIndex, rowIndex, realmGet$session, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.insecureIndex, rowIndex, ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$insecure(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.RealmBasedServerInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasedServerInfoColumnInfo columnInfo = (RealmBasedServerInfoColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long pkColumnIndex = columnInfo.hostnameIndex;
        String primaryKeyValue = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$hostname();
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
        String realmGet$name = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$session = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$session();
        if (realmGet$session != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sessionIndex, rowIndex, realmGet$session, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sessionIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.insecureIndex, rowIndex, ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$insecure(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasedServerInfoColumnInfo columnInfo = (RealmBasedServerInfoColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        long pkColumnIndex = columnInfo.hostnameIndex;
        chat.rocket.persistence.realm.models.RealmBasedServerInfo object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.RealmBasedServerInfo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$hostname();
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
            String realmGet$name = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$session = ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$session();
            if (realmGet$session != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sessionIndex, rowIndex, realmGet$session, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sessionIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.insecureIndex, rowIndex, ((RealmBasedServerInfoRealmProxyInterface) object).realmGet$insecure(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.RealmBasedServerInfo createDetachedCopy(chat.rocket.persistence.realm.models.RealmBasedServerInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.RealmBasedServerInfo unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.RealmBasedServerInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.RealmBasedServerInfo) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.RealmBasedServerInfo) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmBasedServerInfoRealmProxyInterface unmanagedCopy = (RealmBasedServerInfoRealmProxyInterface) unmanagedObject;
        RealmBasedServerInfoRealmProxyInterface realmSource = (RealmBasedServerInfoRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$hostname(realmSource.realmGet$hostname());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$session(realmSource.realmGet$session());
        unmanagedCopy.realmSet$insecure(realmSource.realmGet$insecure());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.RealmBasedServerInfo update(Realm realm, chat.rocket.persistence.realm.models.RealmBasedServerInfo realmObject, chat.rocket.persistence.realm.models.RealmBasedServerInfo newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmBasedServerInfoRealmProxyInterface realmObjectTarget = (RealmBasedServerInfoRealmProxyInterface) realmObject;
        RealmBasedServerInfoRealmProxyInterface realmObjectSource = (RealmBasedServerInfoRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$session(realmObjectSource.realmGet$session());
        realmObjectTarget.realmSet$insecure(realmObjectSource.realmGet$insecure());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmBasedServerInfo = proxy[");
        stringBuilder.append("{hostname:");
        stringBuilder.append(realmGet$hostname() != null ? realmGet$hostname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{session:");
        stringBuilder.append(realmGet$session() != null ? realmGet$session() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{insecure:");
        stringBuilder.append(realmGet$insecure());
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
        RealmBasedServerInfoRealmProxy aRealmBasedServerInfo = (RealmBasedServerInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmBasedServerInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmBasedServerInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmBasedServerInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
