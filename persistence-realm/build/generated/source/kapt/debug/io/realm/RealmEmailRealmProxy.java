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
public class RealmEmailRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmEmail
    implements RealmObjectProxy, RealmEmailRealmProxyInterface {

    static final class RealmEmailColumnInfo extends ColumnInfo {
        long addressIndex;
        long verifiedIndex;

        RealmEmailColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmEmail");
            this.addressIndex = addColumnDetails("address", objectSchemaInfo);
            this.verifiedIndex = addColumnDetails("verified", objectSchemaInfo);
        }

        RealmEmailColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmEmailColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmEmailColumnInfo src = (RealmEmailColumnInfo) rawSrc;
            final RealmEmailColumnInfo dst = (RealmEmailColumnInfo) rawDst;
            dst.addressIndex = src.addressIndex;
            dst.verifiedIndex = src.verifiedIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("address");
        fieldNames.add("verified");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmEmailColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmEmail> proxyState;

    RealmEmailRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmEmailColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmEmail>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressIndex);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'address' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$verified() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.verifiedIndex);
    }

    @Override
    public void realmSet$verified(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.verifiedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.verifiedIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmEmail", 2, 0);
        builder.addPersistedProperty("address", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("verified", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmEmailColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmEmailColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmEmail";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmEmail createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.ddp.RealmEmail obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
            RealmEmailColumnInfo columnInfo = (RealmEmailColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
            long pkColumnIndex = columnInfo.addressIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("address")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("address"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmEmailRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("address")) {
                if (json.isNull("address")) {
                    obj = (io.realm.RealmEmailRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmEmail.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmEmailRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmEmail.class, json.getString("address"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'address'.");
            }
        }

        final RealmEmailRealmProxyInterface objProxy = (RealmEmailRealmProxyInterface) obj;
        if (json.has("verified")) {
            if (json.isNull("verified")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'verified' to null.");
            } else {
                objProxy.realmSet$verified((boolean) json.getBoolean("verified"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmEmail createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmEmail obj = new chat.rocket.persistence.realm.models.ddp.RealmEmail();
        final RealmEmailRealmProxyInterface objProxy = (RealmEmailRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("address")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$address((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("verified")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$verified((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'verified' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'address'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmEmail copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmEmail object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmEmail) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmEmail realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
            RealmEmailColumnInfo columnInfo = (RealmEmailColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
            long pkColumnIndex = columnInfo.addressIndex;
            String value = ((RealmEmailRealmProxyInterface) object).realmGet$address();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmEmailRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmEmail copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmEmail newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmEmail) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmEmail realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmEmail.class, ((RealmEmailRealmProxyInterface) newObject).realmGet$address(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmEmailRealmProxyInterface realmObjectSource = (RealmEmailRealmProxyInterface) newObject;
        RealmEmailRealmProxyInterface realmObjectCopy = (RealmEmailRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$verified(realmObjectSource.realmGet$verified());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmEmail object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long tableNativePtr = table.getNativePtr();
        RealmEmailColumnInfo columnInfo = (RealmEmailColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long pkColumnIndex = columnInfo.addressIndex;
        String primaryKeyValue = ((RealmEmailRealmProxyInterface) object).realmGet$address();
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
        Table.nativeSetBoolean(tableNativePtr, columnInfo.verifiedIndex, rowIndex, ((RealmEmailRealmProxyInterface) object).realmGet$verified(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long tableNativePtr = table.getNativePtr();
        RealmEmailColumnInfo columnInfo = (RealmEmailColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long pkColumnIndex = columnInfo.addressIndex;
        chat.rocket.persistence.realm.models.ddp.RealmEmail object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmEmail) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmEmailRealmProxyInterface) object).realmGet$address();
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
            Table.nativeSetBoolean(tableNativePtr, columnInfo.verifiedIndex, rowIndex, ((RealmEmailRealmProxyInterface) object).realmGet$verified(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmEmail object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long tableNativePtr = table.getNativePtr();
        RealmEmailColumnInfo columnInfo = (RealmEmailColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long pkColumnIndex = columnInfo.addressIndex;
        String primaryKeyValue = ((RealmEmailRealmProxyInterface) object).realmGet$address();
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
        Table.nativeSetBoolean(tableNativePtr, columnInfo.verifiedIndex, rowIndex, ((RealmEmailRealmProxyInterface) object).realmGet$verified(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long tableNativePtr = table.getNativePtr();
        RealmEmailColumnInfo columnInfo = (RealmEmailColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        long pkColumnIndex = columnInfo.addressIndex;
        chat.rocket.persistence.realm.models.ddp.RealmEmail object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmEmail) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmEmailRealmProxyInterface) object).realmGet$address();
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
            Table.nativeSetBoolean(tableNativePtr, columnInfo.verifiedIndex, rowIndex, ((RealmEmailRealmProxyInterface) object).realmGet$verified(), false);
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmEmail createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmEmail realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmEmail unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmEmail();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmEmail) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmEmail) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmEmailRealmProxyInterface unmanagedCopy = (RealmEmailRealmProxyInterface) unmanagedObject;
        RealmEmailRealmProxyInterface realmSource = (RealmEmailRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());
        unmanagedCopy.realmSet$verified(realmSource.realmGet$verified());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmEmail update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmEmail realmObject, chat.rocket.persistence.realm.models.ddp.RealmEmail newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmEmailRealmProxyInterface realmObjectTarget = (RealmEmailRealmProxyInterface) realmObject;
        RealmEmailRealmProxyInterface realmObjectSource = (RealmEmailRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$verified(realmObjectSource.realmGet$verified());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmEmail = proxy[");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{verified:");
        stringBuilder.append(realmGet$verified());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
