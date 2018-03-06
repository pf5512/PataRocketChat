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
public class RealmPublicSettingRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmPublicSetting
    implements RealmObjectProxy, RealmPublicSettingRealmProxyInterface {

    static final class RealmPublicSettingColumnInfo extends ColumnInfo {
        long _idIndex;
        long groupIndex;
        long typeIndex;
        long valueIndex;
        long _updatedAtIndex;
        long metaIndex;

        RealmPublicSettingColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmPublicSetting");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.groupIndex = addColumnDetails("group", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", objectSchemaInfo);
            this.valueIndex = addColumnDetails("value", objectSchemaInfo);
            this._updatedAtIndex = addColumnDetails("_updatedAt", objectSchemaInfo);
            this.metaIndex = addColumnDetails("meta", objectSchemaInfo);
        }

        RealmPublicSettingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmPublicSettingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmPublicSettingColumnInfo src = (RealmPublicSettingColumnInfo) rawSrc;
            final RealmPublicSettingColumnInfo dst = (RealmPublicSettingColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.groupIndex = src.groupIndex;
            dst.typeIndex = src.typeIndex;
            dst.valueIndex = src.valueIndex;
            dst._updatedAtIndex = src._updatedAtIndex;
            dst.metaIndex = src.metaIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("_id");
        fieldNames.add("group");
        fieldNames.add("type");
        fieldNames.add("value");
        fieldNames.add("_updatedAt");
        fieldNames.add("meta");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmPublicSettingColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmPublicSetting> proxyState;

    RealmPublicSettingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmPublicSettingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmPublicSetting>(this);
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
    public String realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.groupIndex);
    }

    @Override
    public void realmSet$group(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.groupIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.groupIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.groupIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.groupIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$value() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.valueIndex);
    }

    @Override
    public void realmSet$value(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.valueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.valueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valueIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.valueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$_updatedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo._updatedAtIndex);
    }

    @Override
    public void realmSet$_updatedAt(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo._updatedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo._updatedAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$meta() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metaIndex);
    }

    @Override
    public void realmSet$meta(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metaIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmPublicSetting", 6, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("group", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("value", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("_updatedAt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("meta", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmPublicSettingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmPublicSettingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmPublicSetting";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmPublicSetting createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.ddp.RealmPublicSetting obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
            RealmPublicSettingColumnInfo columnInfo = (RealmPublicSettingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmPublicSettingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.RealmPublicSettingRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmPublicSettingRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class, json.getString("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final RealmPublicSettingRealmProxyInterface objProxy = (RealmPublicSettingRealmProxyInterface) obj;
        if (json.has("group")) {
            if (json.isNull("group")) {
                objProxy.realmSet$group(null);
            } else {
                objProxy.realmSet$group((String) json.getString("group"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("value")) {
            if (json.isNull("value")) {
                objProxy.realmSet$value(null);
            } else {
                objProxy.realmSet$value((String) json.getString("value"));
            }
        }
        if (json.has("_updatedAt")) {
            if (json.isNull("_updatedAt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field '_updatedAt' to null.");
            } else {
                objProxy.realmSet$_updatedAt((long) json.getLong("_updatedAt"));
            }
        }
        if (json.has("meta")) {
            if (json.isNull("meta")) {
                objProxy.realmSet$meta(null);
            } else {
                objProxy.realmSet$meta((String) json.getString("meta"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmPublicSetting createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmPublicSetting obj = new chat.rocket.persistence.realm.models.ddp.RealmPublicSetting();
        final RealmPublicSettingRealmProxyInterface objProxy = (RealmPublicSettingRealmProxyInterface) obj;
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
            } else if (name.equals("group")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$group((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$group(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("value")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$value((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$value(null);
                }
            } else if (name.equals("_updatedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$_updatedAt((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field '_updatedAt' to null.");
                }
            } else if (name.equals("meta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$meta((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$meta(null);
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

    public static chat.rocket.persistence.realm.models.ddp.RealmPublicSetting copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPublicSetting object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmPublicSetting realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
            RealmPublicSettingColumnInfo columnInfo = (RealmPublicSettingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
            long pkColumnIndex = columnInfo._idIndex;
            String value = ((RealmPublicSettingRealmProxyInterface) object).realmGet$_id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmPublicSettingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmPublicSetting copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPublicSetting newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmPublicSetting realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class, ((RealmPublicSettingRealmProxyInterface) newObject).realmGet$_id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmPublicSettingRealmProxyInterface realmObjectSource = (RealmPublicSettingRealmProxyInterface) newObject;
        RealmPublicSettingRealmProxyInterface realmObjectCopy = (RealmPublicSettingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$group(realmObjectSource.realmGet$group());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$value(realmObjectSource.realmGet$value());
        realmObjectCopy.realmSet$_updatedAt(realmObjectSource.realmGet$_updatedAt());
        realmObjectCopy.realmSet$meta(realmObjectSource.realmGet$meta());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPublicSetting object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long tableNativePtr = table.getNativePtr();
        RealmPublicSettingColumnInfo columnInfo = (RealmPublicSettingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmPublicSettingRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$group = ((RealmPublicSettingRealmProxyInterface) object).realmGet$group();
        if (realmGet$group != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.groupIndex, rowIndex, realmGet$group, false);
        }
        String realmGet$type = ((RealmPublicSettingRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        String realmGet$value = ((RealmPublicSettingRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmPublicSettingRealmProxyInterface) object).realmGet$_updatedAt(), false);
        String realmGet$meta = ((RealmPublicSettingRealmProxyInterface) object).realmGet$meta();
        if (realmGet$meta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metaIndex, rowIndex, realmGet$meta, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long tableNativePtr = table.getNativePtr();
        RealmPublicSettingColumnInfo columnInfo = (RealmPublicSettingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmPublicSetting object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmPublicSettingRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$group = ((RealmPublicSettingRealmProxyInterface) object).realmGet$group();
            if (realmGet$group != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.groupIndex, rowIndex, realmGet$group, false);
            }
            String realmGet$type = ((RealmPublicSettingRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            String realmGet$value = ((RealmPublicSettingRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmPublicSettingRealmProxyInterface) object).realmGet$_updatedAt(), false);
            String realmGet$meta = ((RealmPublicSettingRealmProxyInterface) object).realmGet$meta();
            if (realmGet$meta != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metaIndex, rowIndex, realmGet$meta, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPublicSetting object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long tableNativePtr = table.getNativePtr();
        RealmPublicSettingColumnInfo columnInfo = (RealmPublicSettingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmPublicSettingRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$group = ((RealmPublicSettingRealmProxyInterface) object).realmGet$group();
        if (realmGet$group != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.groupIndex, rowIndex, realmGet$group, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.groupIndex, rowIndex, false);
        }
        String realmGet$type = ((RealmPublicSettingRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        String realmGet$value = ((RealmPublicSettingRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmPublicSettingRealmProxyInterface) object).realmGet$_updatedAt(), false);
        String realmGet$meta = ((RealmPublicSettingRealmProxyInterface) object).realmGet$meta();
        if (realmGet$meta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metaIndex, rowIndex, realmGet$meta, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metaIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long tableNativePtr = table.getNativePtr();
        RealmPublicSettingColumnInfo columnInfo = (RealmPublicSettingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmPublicSetting object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmPublicSettingRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$group = ((RealmPublicSettingRealmProxyInterface) object).realmGet$group();
            if (realmGet$group != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.groupIndex, rowIndex, realmGet$group, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.groupIndex, rowIndex, false);
            }
            String realmGet$type = ((RealmPublicSettingRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            String realmGet$value = ((RealmPublicSettingRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo._updatedAtIndex, rowIndex, ((RealmPublicSettingRealmProxyInterface) object).realmGet$_updatedAt(), false);
            String realmGet$meta = ((RealmPublicSettingRealmProxyInterface) object).realmGet$meta();
            if (realmGet$meta != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metaIndex, rowIndex, realmGet$meta, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metaIndex, rowIndex, false);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmPublicSetting createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmPublicSetting unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmPublicSetting();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmPublicSettingRealmProxyInterface unmanagedCopy = (RealmPublicSettingRealmProxyInterface) unmanagedObject;
        RealmPublicSettingRealmProxyInterface realmSource = (RealmPublicSettingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$group(realmSource.realmGet$group());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$value(realmSource.realmGet$value());
        unmanagedCopy.realmSet$_updatedAt(realmSource.realmGet$_updatedAt());
        unmanagedCopy.realmSet$meta(realmSource.realmGet$meta());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmPublicSetting update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmPublicSetting realmObject, chat.rocket.persistence.realm.models.ddp.RealmPublicSetting newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmPublicSettingRealmProxyInterface realmObjectTarget = (RealmPublicSettingRealmProxyInterface) realmObject;
        RealmPublicSettingRealmProxyInterface realmObjectSource = (RealmPublicSettingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$group(realmObjectSource.realmGet$group());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$value(realmObjectSource.realmGet$value());
        realmObjectTarget.realmSet$_updatedAt(realmObjectSource.realmGet$_updatedAt());
        realmObjectTarget.realmSet$meta(realmObjectSource.realmGet$meta());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmPublicSetting = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group:");
        stringBuilder.append(realmGet$group() != null ? realmGet$group() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value() != null ? realmGet$value() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{_updatedAt:");
        stringBuilder.append(realmGet$_updatedAt());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{meta:");
        stringBuilder.append(realmGet$meta() != null ? realmGet$meta() : "null");
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
        RealmPublicSettingRealmProxy aRealmPublicSetting = (RealmPublicSettingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmPublicSetting.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmPublicSetting.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmPublicSetting.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
