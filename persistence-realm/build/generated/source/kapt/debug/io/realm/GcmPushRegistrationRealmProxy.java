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
public class GcmPushRegistrationRealmProxy extends chat.rocket.persistence.realm.models.internal.GcmPushRegistration
    implements RealmObjectProxy, GcmPushRegistrationRealmProxyInterface {

    static final class GcmPushRegistrationColumnInfo extends ColumnInfo {
        long dummyIdIndex;
        long syncStateIndex;
        long gcmPushEnabledIndex;

        GcmPushRegistrationColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GcmPushRegistration");
            this.dummyIdIndex = addColumnDetails("dummyId", objectSchemaInfo);
            this.syncStateIndex = addColumnDetails("syncState", objectSchemaInfo);
            this.gcmPushEnabledIndex = addColumnDetails("gcmPushEnabled", objectSchemaInfo);
        }

        GcmPushRegistrationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GcmPushRegistrationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GcmPushRegistrationColumnInfo src = (GcmPushRegistrationColumnInfo) rawSrc;
            final GcmPushRegistrationColumnInfo dst = (GcmPushRegistrationColumnInfo) rawDst;
            dst.dummyIdIndex = src.dummyIdIndex;
            dst.syncStateIndex = src.syncStateIndex;
            dst.gcmPushEnabledIndex = src.gcmPushEnabledIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(3);
        fieldNames.add("dummyId");
        fieldNames.add("syncState");
        fieldNames.add("gcmPushEnabled");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private GcmPushRegistrationColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.internal.GcmPushRegistration> proxyState;

    GcmPushRegistrationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GcmPushRegistrationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.internal.GcmPushRegistration>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$dummyId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.dummyIdIndex);
    }

    @Override
    public void realmSet$dummyId(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'dummyId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$syncState() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.syncStateIndex);
    }

    @Override
    public void realmSet$syncState(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.syncStateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.syncStateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$gcmPushEnabled() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.gcmPushEnabledIndex);
    }

    @Override
    public void realmSet$gcmPushEnabled(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.gcmPushEnabledIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.gcmPushEnabledIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GcmPushRegistration", 3, 0);
        builder.addPersistedProperty("dummyId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("syncState", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("gcmPushEnabled", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GcmPushRegistrationColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GcmPushRegistrationColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GcmPushRegistration";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.internal.GcmPushRegistration createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.internal.GcmPushRegistration obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
            GcmPushRegistrationColumnInfo columnInfo = (GcmPushRegistrationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
            long pkColumnIndex = columnInfo.dummyIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("dummyId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("dummyId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GcmPushRegistrationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("dummyId")) {
                if (json.isNull("dummyId")) {
                    obj = (io.realm.GcmPushRegistrationRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GcmPushRegistrationRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class, json.getInt("dummyId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'dummyId'.");
            }
        }

        final GcmPushRegistrationRealmProxyInterface objProxy = (GcmPushRegistrationRealmProxyInterface) obj;
        if (json.has("syncState")) {
            if (json.isNull("syncState")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'syncState' to null.");
            } else {
                objProxy.realmSet$syncState((int) json.getInt("syncState"));
            }
        }
        if (json.has("gcmPushEnabled")) {
            if (json.isNull("gcmPushEnabled")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'gcmPushEnabled' to null.");
            } else {
                objProxy.realmSet$gcmPushEnabled((boolean) json.getBoolean("gcmPushEnabled"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.internal.GcmPushRegistration createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.internal.GcmPushRegistration obj = new chat.rocket.persistence.realm.models.internal.GcmPushRegistration();
        final GcmPushRegistrationRealmProxyInterface objProxy = (GcmPushRegistrationRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("dummyId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dummyId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dummyId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("syncState")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$syncState((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'syncState' to null.");
                }
            } else if (name.equals("gcmPushEnabled")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$gcmPushEnabled((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'gcmPushEnabled' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'dummyId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.internal.GcmPushRegistration copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.GcmPushRegistration object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.internal.GcmPushRegistration realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
            GcmPushRegistrationColumnInfo columnInfo = (GcmPushRegistrationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
            long pkColumnIndex = columnInfo.dummyIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.GcmPushRegistrationRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.internal.GcmPushRegistration copy(Realm realm, chat.rocket.persistence.realm.models.internal.GcmPushRegistration newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.internal.GcmPushRegistration realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class, ((GcmPushRegistrationRealmProxyInterface) newObject).realmGet$dummyId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        GcmPushRegistrationRealmProxyInterface realmObjectSource = (GcmPushRegistrationRealmProxyInterface) newObject;
        GcmPushRegistrationRealmProxyInterface realmObjectCopy = (GcmPushRegistrationRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$syncState(realmObjectSource.realmGet$syncState());
        realmObjectCopy.realmSet$gcmPushEnabled(realmObjectSource.realmGet$gcmPushEnabled());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.internal.GcmPushRegistration object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long tableNativePtr = table.getNativePtr();
        GcmPushRegistrationColumnInfo columnInfo = (GcmPushRegistrationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long pkColumnIndex = columnInfo.dummyIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.syncStateIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$syncState(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.gcmPushEnabledIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$gcmPushEnabled(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long tableNativePtr = table.getNativePtr();
        GcmPushRegistrationColumnInfo columnInfo = (GcmPushRegistrationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long pkColumnIndex = columnInfo.dummyIdIndex;
        chat.rocket.persistence.realm.models.internal.GcmPushRegistration object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.syncStateIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$syncState(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.gcmPushEnabledIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$gcmPushEnabled(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.GcmPushRegistration object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long tableNativePtr = table.getNativePtr();
        GcmPushRegistrationColumnInfo columnInfo = (GcmPushRegistrationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long pkColumnIndex = columnInfo.dummyIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.syncStateIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$syncState(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.gcmPushEnabledIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$gcmPushEnabled(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long tableNativePtr = table.getNativePtr();
        GcmPushRegistrationColumnInfo columnInfo = (GcmPushRegistrationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        long pkColumnIndex = columnInfo.dummyIdIndex;
        chat.rocket.persistence.realm.models.internal.GcmPushRegistration object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$dummyId());
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.syncStateIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$syncState(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.gcmPushEnabledIndex, rowIndex, ((GcmPushRegistrationRealmProxyInterface) object).realmGet$gcmPushEnabled(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.internal.GcmPushRegistration createDetachedCopy(chat.rocket.persistence.realm.models.internal.GcmPushRegistration realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.internal.GcmPushRegistration unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.internal.GcmPushRegistration();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        GcmPushRegistrationRealmProxyInterface unmanagedCopy = (GcmPushRegistrationRealmProxyInterface) unmanagedObject;
        GcmPushRegistrationRealmProxyInterface realmSource = (GcmPushRegistrationRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$dummyId(realmSource.realmGet$dummyId());
        unmanagedCopy.realmSet$syncState(realmSource.realmGet$syncState());
        unmanagedCopy.realmSet$gcmPushEnabled(realmSource.realmGet$gcmPushEnabled());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.internal.GcmPushRegistration update(Realm realm, chat.rocket.persistence.realm.models.internal.GcmPushRegistration realmObject, chat.rocket.persistence.realm.models.internal.GcmPushRegistration newObject, Map<RealmModel, RealmObjectProxy> cache) {
        GcmPushRegistrationRealmProxyInterface realmObjectTarget = (GcmPushRegistrationRealmProxyInterface) realmObject;
        GcmPushRegistrationRealmProxyInterface realmObjectSource = (GcmPushRegistrationRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$syncState(realmObjectSource.realmGet$syncState());
        realmObjectTarget.realmSet$gcmPushEnabled(realmObjectSource.realmGet$gcmPushEnabled());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GcmPushRegistration = proxy[");
        stringBuilder.append("{dummyId:");
        stringBuilder.append(realmGet$dummyId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{syncState:");
        stringBuilder.append(realmGet$syncState());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gcmPushEnabled:");
        stringBuilder.append(realmGet$gcmPushEnabled());
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
        GcmPushRegistrationRealmProxy aGcmPushRegistration = (GcmPushRegistrationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGcmPushRegistration.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGcmPushRegistration.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGcmPushRegistration.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
