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
public class RealmMeteorLoginServiceConfigurationRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration
    implements RealmObjectProxy, RealmMeteorLoginServiceConfigurationRealmProxyInterface {

    static final class RealmMeteorLoginServiceConfigurationColumnInfo extends ColumnInfo {
        long _idIndex;
        long serviceIndex;
        long consumerKeyIndex;
        long appIdIndex;
        long clientIdIndex;

        RealmMeteorLoginServiceConfigurationColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmMeteorLoginServiceConfiguration");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.serviceIndex = addColumnDetails("service", objectSchemaInfo);
            this.consumerKeyIndex = addColumnDetails("consumerKey", objectSchemaInfo);
            this.appIdIndex = addColumnDetails("appId", objectSchemaInfo);
            this.clientIdIndex = addColumnDetails("clientId", objectSchemaInfo);
        }

        RealmMeteorLoginServiceConfigurationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmMeteorLoginServiceConfigurationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmMeteorLoginServiceConfigurationColumnInfo src = (RealmMeteorLoginServiceConfigurationColumnInfo) rawSrc;
            final RealmMeteorLoginServiceConfigurationColumnInfo dst = (RealmMeteorLoginServiceConfigurationColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.serviceIndex = src.serviceIndex;
            dst.consumerKeyIndex = src.consumerKeyIndex;
            dst.appIdIndex = src.appIdIndex;
            dst.clientIdIndex = src.clientIdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(5);
        fieldNames.add("_id");
        fieldNames.add("service");
        fieldNames.add("consumerKey");
        fieldNames.add("appId");
        fieldNames.add("clientId");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmMeteorLoginServiceConfigurationColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration> proxyState;

    RealmMeteorLoginServiceConfigurationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration>(this);
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
    public String realmGet$service() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.serviceIndex);
    }

    @Override
    public void realmSet$service(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.serviceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.serviceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.serviceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.serviceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$consumerKey() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.consumerKeyIndex);
    }

    @Override
    public void realmSet$consumerKey(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.consumerKeyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.consumerKeyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.consumerKeyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.consumerKeyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$appId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.appIdIndex);
    }

    @Override
    public void realmSet$appId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.appIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.appIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.appIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.appIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$clientId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.clientIdIndex);
    }

    @Override
    public void realmSet$clientId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.clientIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.clientIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.clientIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.clientIdIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmMeteorLoginServiceConfiguration", 5, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("service", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("consumerKey", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("appId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("clientId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmMeteorLoginServiceConfigurationColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmMeteorLoginServiceConfigurationColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmMeteorLoginServiceConfiguration";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
            RealmMeteorLoginServiceConfigurationColumnInfo columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmMeteorLoginServiceConfigurationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.RealmMeteorLoginServiceConfigurationRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmMeteorLoginServiceConfigurationRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class, json.getString("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final RealmMeteorLoginServiceConfigurationRealmProxyInterface objProxy = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) obj;
        if (json.has("service")) {
            if (json.isNull("service")) {
                objProxy.realmSet$service(null);
            } else {
                objProxy.realmSet$service((String) json.getString("service"));
            }
        }
        if (json.has("consumerKey")) {
            if (json.isNull("consumerKey")) {
                objProxy.realmSet$consumerKey(null);
            } else {
                objProxy.realmSet$consumerKey((String) json.getString("consumerKey"));
            }
        }
        if (json.has("appId")) {
            if (json.isNull("appId")) {
                objProxy.realmSet$appId(null);
            } else {
                objProxy.realmSet$appId((String) json.getString("appId"));
            }
        }
        if (json.has("clientId")) {
            if (json.isNull("clientId")) {
                objProxy.realmSet$clientId(null);
            } else {
                objProxy.realmSet$clientId((String) json.getString("clientId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration obj = new chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration();
        final RealmMeteorLoginServiceConfigurationRealmProxyInterface objProxy = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) obj;
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
            } else if (name.equals("service")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$service((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$service(null);
                }
            } else if (name.equals("consumerKey")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$consumerKey((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$consumerKey(null);
                }
            } else if (name.equals("appId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$appId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$appId(null);
                }
            } else if (name.equals("clientId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clientId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$clientId(null);
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

    public static chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
            RealmMeteorLoginServiceConfigurationColumnInfo columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
            long pkColumnIndex = columnInfo._idIndex;
            String value = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$_id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmMeteorLoginServiceConfigurationRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class, ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) newObject).realmGet$_id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmMeteorLoginServiceConfigurationRealmProxyInterface realmObjectSource = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) newObject;
        RealmMeteorLoginServiceConfigurationRealmProxyInterface realmObjectCopy = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$service(realmObjectSource.realmGet$service());
        realmObjectCopy.realmSet$consumerKey(realmObjectSource.realmGet$consumerKey());
        realmObjectCopy.realmSet$appId(realmObjectSource.realmGet$appId());
        realmObjectCopy.realmSet$clientId(realmObjectSource.realmGet$clientId());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long tableNativePtr = table.getNativePtr();
        RealmMeteorLoginServiceConfigurationColumnInfo columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$service = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$service();
        if (realmGet$service != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceIndex, rowIndex, realmGet$service, false);
        }
        String realmGet$consumerKey = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$consumerKey();
        if (realmGet$consumerKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.consumerKeyIndex, rowIndex, realmGet$consumerKey, false);
        }
        String realmGet$appId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$appId();
        if (realmGet$appId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.appIdIndex, rowIndex, realmGet$appId, false);
        }
        String realmGet$clientId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$clientId();
        if (realmGet$clientId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clientIdIndex, rowIndex, realmGet$clientId, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long tableNativePtr = table.getNativePtr();
        RealmMeteorLoginServiceConfigurationColumnInfo columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$service = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$service();
            if (realmGet$service != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.serviceIndex, rowIndex, realmGet$service, false);
            }
            String realmGet$consumerKey = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$consumerKey();
            if (realmGet$consumerKey != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.consumerKeyIndex, rowIndex, realmGet$consumerKey, false);
            }
            String realmGet$appId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$appId();
            if (realmGet$appId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.appIdIndex, rowIndex, realmGet$appId, false);
            }
            String realmGet$clientId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$clientId();
            if (realmGet$clientId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.clientIdIndex, rowIndex, realmGet$clientId, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long tableNativePtr = table.getNativePtr();
        RealmMeteorLoginServiceConfigurationColumnInfo columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$service = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$service();
        if (realmGet$service != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serviceIndex, rowIndex, realmGet$service, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serviceIndex, rowIndex, false);
        }
        String realmGet$consumerKey = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$consumerKey();
        if (realmGet$consumerKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.consumerKeyIndex, rowIndex, realmGet$consumerKey, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.consumerKeyIndex, rowIndex, false);
        }
        String realmGet$appId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$appId();
        if (realmGet$appId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.appIdIndex, rowIndex, realmGet$appId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.appIdIndex, rowIndex, false);
        }
        String realmGet$clientId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$clientId();
        if (realmGet$clientId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clientIdIndex, rowIndex, realmGet$clientId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.clientIdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long tableNativePtr = table.getNativePtr();
        RealmMeteorLoginServiceConfigurationColumnInfo columnInfo = (RealmMeteorLoginServiceConfigurationColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$service = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$service();
            if (realmGet$service != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.serviceIndex, rowIndex, realmGet$service, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.serviceIndex, rowIndex, false);
            }
            String realmGet$consumerKey = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$consumerKey();
            if (realmGet$consumerKey != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.consumerKeyIndex, rowIndex, realmGet$consumerKey, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.consumerKeyIndex, rowIndex, false);
            }
            String realmGet$appId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$appId();
            if (realmGet$appId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.appIdIndex, rowIndex, realmGet$appId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.appIdIndex, rowIndex, false);
            }
            String realmGet$clientId = ((RealmMeteorLoginServiceConfigurationRealmProxyInterface) object).realmGet$clientId();
            if (realmGet$clientId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.clientIdIndex, rowIndex, realmGet$clientId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.clientIdIndex, rowIndex, false);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmMeteorLoginServiceConfigurationRealmProxyInterface unmanagedCopy = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) unmanagedObject;
        RealmMeteorLoginServiceConfigurationRealmProxyInterface realmSource = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$service(realmSource.realmGet$service());
        unmanagedCopy.realmSet$consumerKey(realmSource.realmGet$consumerKey());
        unmanagedCopy.realmSet$appId(realmSource.realmGet$appId());
        unmanagedCopy.realmSet$clientId(realmSource.realmGet$clientId());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration realmObject, chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmMeteorLoginServiceConfigurationRealmProxyInterface realmObjectTarget = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) realmObject;
        RealmMeteorLoginServiceConfigurationRealmProxyInterface realmObjectSource = (RealmMeteorLoginServiceConfigurationRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$service(realmObjectSource.realmGet$service());
        realmObjectTarget.realmSet$consumerKey(realmObjectSource.realmGet$consumerKey());
        realmObjectTarget.realmSet$appId(realmObjectSource.realmGet$appId());
        realmObjectTarget.realmSet$clientId(realmObjectSource.realmGet$clientId());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmMeteorLoginServiceConfiguration = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{service:");
        stringBuilder.append(realmGet$service() != null ? realmGet$service() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{consumerKey:");
        stringBuilder.append(realmGet$consumerKey() != null ? realmGet$consumerKey() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{appId:");
        stringBuilder.append(realmGet$appId() != null ? realmGet$appId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clientId:");
        stringBuilder.append(realmGet$clientId() != null ? realmGet$clientId() : "null");
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
        RealmMeteorLoginServiceConfigurationRealmProxy aRealmMeteorLoginServiceConfiguration = (RealmMeteorLoginServiceConfigurationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmMeteorLoginServiceConfiguration.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmMeteorLoginServiceConfiguration.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmMeteorLoginServiceConfiguration.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
