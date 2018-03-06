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
public class RealmSettingsRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmSettings
    implements RealmObjectProxy, RealmSettingsRealmProxyInterface {

    static final class RealmSettingsColumnInfo extends ColumnInfo {
        long idIndex;
        long preferencesIndex;

        RealmSettingsColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmSettings");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.preferencesIndex = addColumnDetails("preferences", objectSchemaInfo);
        }

        RealmSettingsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmSettingsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmSettingsColumnInfo src = (RealmSettingsColumnInfo) rawSrc;
            final RealmSettingsColumnInfo dst = (RealmSettingsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.preferencesIndex = src.preferencesIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("id");
        fieldNames.add("preferences");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmSettingsColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmSettings> proxyState;

    RealmSettingsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmSettingsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmSettings>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    public chat.rocket.persistence.realm.models.ddp.RealmPreferences realmGet$preferences() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.preferencesIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class, proxyState.getRow$realm().getLink(columnInfo.preferencesIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$preferences(chat.rocket.persistence.realm.models.ddp.RealmPreferences value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("preferences")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.preferencesIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.preferencesIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.preferencesIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.preferencesIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmSettings", 2, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("preferences", RealmFieldType.OBJECT, "RealmPreferences");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmSettingsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmSettingsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmSettings";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmSettings createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        chat.rocket.persistence.realm.models.ddp.RealmSettings obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
            RealmSettingsColumnInfo columnInfo = (RealmSettingsColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmSettingsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("preferences")) {
                excludeFields.add("preferences");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.RealmSettingsRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmSettings.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmSettingsRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmSettings.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final RealmSettingsRealmProxyInterface objProxy = (RealmSettingsRealmProxyInterface) obj;
        if (json.has("preferences")) {
            if (json.isNull("preferences")) {
                objProxy.realmSet$preferences(null);
            } else {
                chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = RealmPreferencesRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("preferences"), update);
                objProxy.realmSet$preferences(preferencesObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmSettings createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmSettings obj = new chat.rocket.persistence.realm.models.ddp.RealmSettings();
        final RealmSettingsRealmProxyInterface objProxy = (RealmSettingsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("preferences")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$preferences(null);
                } else {
                    chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = RealmPreferencesRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$preferences(preferencesObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmSettings copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSettings object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmSettings) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmSettings realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
            RealmSettingsColumnInfo columnInfo = (RealmSettingsColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((RealmSettingsRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmSettingsRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmSettings copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSettings newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmSettings) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmSettings realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmSettings.class, ((RealmSettingsRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmSettingsRealmProxyInterface realmObjectSource = (RealmSettingsRealmProxyInterface) newObject;
        RealmSettingsRealmProxyInterface realmObjectCopy = (RealmSettingsRealmProxyInterface) realmObject;


        chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = realmObjectSource.realmGet$preferences();
        if (preferencesObj == null) {
            realmObjectCopy.realmSet$preferences(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmPreferences cachepreferences = (chat.rocket.persistence.realm.models.ddp.RealmPreferences) cache.get(preferencesObj);
            if (cachepreferences != null) {
                realmObjectCopy.realmSet$preferences(cachepreferences);
            } else {
                realmObjectCopy.realmSet$preferences(RealmPreferencesRealmProxy.copyOrUpdate(realm, preferencesObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSettings object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long tableNativePtr = table.getNativePtr();
        RealmSettingsColumnInfo columnInfo = (RealmSettingsColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((RealmSettingsRealmProxyInterface) object).realmGet$id();
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

        chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = ((RealmSettingsRealmProxyInterface) object).realmGet$preferences();
        if (preferencesObj != null) {
            Long cachepreferences = cache.get(preferencesObj);
            if (cachepreferences == null) {
                cachepreferences = RealmPreferencesRealmProxy.insert(realm, preferencesObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.preferencesIndex, rowIndex, cachepreferences, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long tableNativePtr = table.getNativePtr();
        RealmSettingsColumnInfo columnInfo = (RealmSettingsColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long pkColumnIndex = columnInfo.idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmSettings object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmSettings) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmSettingsRealmProxyInterface) object).realmGet$id();
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

            chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = ((RealmSettingsRealmProxyInterface) object).realmGet$preferences();
            if (preferencesObj != null) {
                Long cachepreferences = cache.get(preferencesObj);
                if (cachepreferences == null) {
                    cachepreferences = RealmPreferencesRealmProxy.insert(realm, preferencesObj, cache);
                }
                table.setLink(columnInfo.preferencesIndex, rowIndex, cachepreferences, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSettings object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long tableNativePtr = table.getNativePtr();
        RealmSettingsColumnInfo columnInfo = (RealmSettingsColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((RealmSettingsRealmProxyInterface) object).realmGet$id();
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

        chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = ((RealmSettingsRealmProxyInterface) object).realmGet$preferences();
        if (preferencesObj != null) {
            Long cachepreferences = cache.get(preferencesObj);
            if (cachepreferences == null) {
                cachepreferences = RealmPreferencesRealmProxy.insertOrUpdate(realm, preferencesObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.preferencesIndex, rowIndex, cachepreferences, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.preferencesIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long tableNativePtr = table.getNativePtr();
        RealmSettingsColumnInfo columnInfo = (RealmSettingsColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        long pkColumnIndex = columnInfo.idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmSettings object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmSettings) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmSettingsRealmProxyInterface) object).realmGet$id();
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

            chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = ((RealmSettingsRealmProxyInterface) object).realmGet$preferences();
            if (preferencesObj != null) {
                Long cachepreferences = cache.get(preferencesObj);
                if (cachepreferences == null) {
                    cachepreferences = RealmPreferencesRealmProxy.insertOrUpdate(realm, preferencesObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.preferencesIndex, rowIndex, cachepreferences, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.preferencesIndex, rowIndex);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmSettings createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmSettings realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmSettings unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmSettings();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmSettings) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmSettings) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmSettingsRealmProxyInterface unmanagedCopy = (RealmSettingsRealmProxyInterface) unmanagedObject;
        RealmSettingsRealmProxyInterface realmSource = (RealmSettingsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of preferences
        unmanagedCopy.realmSet$preferences(RealmPreferencesRealmProxy.createDetachedCopy(realmSource.realmGet$preferences(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmSettings update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmSettings realmObject, chat.rocket.persistence.realm.models.ddp.RealmSettings newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmSettingsRealmProxyInterface realmObjectTarget = (RealmSettingsRealmProxyInterface) realmObject;
        RealmSettingsRealmProxyInterface realmObjectSource = (RealmSettingsRealmProxyInterface) newObject;
        chat.rocket.persistence.realm.models.ddp.RealmPreferences preferencesObj = realmObjectSource.realmGet$preferences();
        if (preferencesObj == null) {
            realmObjectTarget.realmSet$preferences(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmPreferences cachepreferences = (chat.rocket.persistence.realm.models.ddp.RealmPreferences) cache.get(preferencesObj);
            if (cachepreferences != null) {
                realmObjectTarget.realmSet$preferences(cachepreferences);
            } else {
                realmObjectTarget.realmSet$preferences(RealmPreferencesRealmProxy.copyOrUpdate(realm, preferencesObj, true, cache));
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmSettings = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preferences:");
        stringBuilder.append(realmGet$preferences() != null ? "RealmPreferences" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
