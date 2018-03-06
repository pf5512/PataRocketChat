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
public class RealmRoomRoleRealmProxy extends chat.rocket.persistence.realm.models.ddp.RealmRoomRole
    implements RealmObjectProxy, RealmRoomRoleRealmProxyInterface {

    static final class RealmRoomRoleColumnInfo extends ColumnInfo {
        long _idIndex;
        long ridIndex;
        long uIndex;
        long rolesIndex;

        RealmRoomRoleColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmRoomRole");
            this._idIndex = addColumnDetails("_id", objectSchemaInfo);
            this.ridIndex = addColumnDetails("rid", objectSchemaInfo);
            this.uIndex = addColumnDetails("u", objectSchemaInfo);
            this.rolesIndex = addColumnDetails("roles", objectSchemaInfo);
        }

        RealmRoomRoleColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmRoomRoleColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmRoomRoleColumnInfo src = (RealmRoomRoleColumnInfo) rawSrc;
            final RealmRoomRoleColumnInfo dst = (RealmRoomRoleColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.ridIndex = src.ridIndex;
            dst.uIndex = src.uIndex;
            dst.rolesIndex = src.rolesIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(4);
        fieldNames.add("_id");
        fieldNames.add("rid");
        fieldNames.add("u");
        fieldNames.add("roles");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmRoomRoleColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.ddp.RealmRoomRole> proxyState;
    private RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesRealmList;

    RealmRoomRoleRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmRoomRoleColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.ddp.RealmRoomRole>(this);
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
    public String realmGet$rid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ridIndex);
    }

    @Override
    public void realmSet$rid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ridIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ridIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ridIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ridIndex, value);
    }

    @Override
    public chat.rocket.persistence.realm.models.ddp.RealmUser realmGet$u() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.uIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(chat.rocket.persistence.realm.models.ddp.RealmUser.class, proxyState.getRow$realm().getLink(columnInfo.uIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$u(chat.rocket.persistence.realm.models.ddp.RealmUser value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("u")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.uIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.uIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.uIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.uIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> realmGet$roles() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (rolesRealmList != null) {
            return rolesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.rolesIndex);
            rolesRealmList = new RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole>(chat.rocket.persistence.realm.models.ddp.RealmRole.class, osList, proxyState.getRealm$realm());
            return rolesRealmList;
        }
    }

    @Override
    public void realmSet$roles(RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("roles")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> original = value;
                value = new RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole>();
                for (chat.rocket.persistence.realm.models.ddp.RealmRole item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.rolesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmRole linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmRole linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmRoomRole", 4, 0);
        builder.addPersistedProperty("_id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("u", RealmFieldType.OBJECT, "RealmUser");
        builder.addPersistedLinkProperty("roles", RealmFieldType.LIST, "RealmRole");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmRoomRoleColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmRoomRoleColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmRoomRole";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.ddp.RealmRoomRole createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        chat.rocket.persistence.realm.models.ddp.RealmRoomRole obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
            RealmRoomRoleColumnInfo columnInfo = (RealmRoomRoleColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmRoomRoleRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("u")) {
                excludeFields.add("u");
            }
            if (json.has("roles")) {
                excludeFields.add("roles");
            }
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (io.realm.RealmRoomRoleRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmRoomRoleRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class, json.getString("_id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '_id'.");
            }
        }

        final RealmRoomRoleRealmProxyInterface objProxy = (RealmRoomRoleRealmProxyInterface) obj;
        if (json.has("rid")) {
            if (json.isNull("rid")) {
                objProxy.realmSet$rid(null);
            } else {
                objProxy.realmSet$rid((String) json.getString("rid"));
            }
        }
        if (json.has("u")) {
            if (json.isNull("u")) {
                objProxy.realmSet$u(null);
            } else {
                chat.rocket.persistence.realm.models.ddp.RealmUser uObj = RealmUserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("u"), update);
                objProxy.realmSet$u(uObj);
            }
        }
        if (json.has("roles")) {
            if (json.isNull("roles")) {
                objProxy.realmSet$roles(null);
            } else {
                objProxy.realmGet$roles().clear();
                JSONArray array = json.getJSONArray("roles");
                for (int i = 0; i < array.length(); i++) {
                    chat.rocket.persistence.realm.models.ddp.RealmRole item = RealmRoleRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$roles().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static chat.rocket.persistence.realm.models.ddp.RealmRoomRole createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.ddp.RealmRoomRole obj = new chat.rocket.persistence.realm.models.ddp.RealmRoomRole();
        final RealmRoomRoleRealmProxyInterface objProxy = (RealmRoomRoleRealmProxyInterface) obj;
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
            } else if (name.equals("rid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rid(null);
                }
            } else if (name.equals("u")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$u(null);
                } else {
                    chat.rocket.persistence.realm.models.ddp.RealmUser uObj = RealmUserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$u(uObj);
                }
            } else if (name.equals("roles")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$roles(null);
                } else {
                    objProxy.realmSet$roles(new RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        chat.rocket.persistence.realm.models.ddp.RealmRole item = RealmRoleRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$roles().add(item);
                    }
                    reader.endArray();
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

    public static chat.rocket.persistence.realm.models.ddp.RealmRoomRole copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoomRole object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.ddp.RealmRoomRole realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
            RealmRoomRoleColumnInfo columnInfo = (RealmRoomRoleColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
            long pkColumnIndex = columnInfo._idIndex;
            String value = ((RealmRoomRoleRealmProxyInterface) object).realmGet$_id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmRoomRoleRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmRoomRole copy(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoomRole newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.ddp.RealmRoomRole realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class, ((RealmRoomRoleRealmProxyInterface) newObject).realmGet$_id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmRoomRoleRealmProxyInterface realmObjectSource = (RealmRoomRoleRealmProxyInterface) newObject;
        RealmRoomRoleRealmProxyInterface realmObjectCopy = (RealmRoomRoleRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$rid(realmObjectSource.realmGet$rid());

        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = realmObjectSource.realmGet$u();
        if (uObj == null) {
            realmObjectCopy.realmSet$u(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmUser cacheu = (chat.rocket.persistence.realm.models.ddp.RealmUser) cache.get(uObj);
            if (cacheu != null) {
                realmObjectCopy.realmSet$u(cacheu);
            } else {
                realmObjectCopy.realmSet$u(RealmUserRealmProxy.copyOrUpdate(realm, uObj, update, cache));
            }
        }

        RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesList = realmObjectSource.realmGet$roles();
        if (rolesList != null) {
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesRealmList = realmObjectCopy.realmGet$roles();
            rolesRealmList.clear();
            for (int i = 0; i < rolesList.size(); i++) {
                chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem = rolesList.get(i);
                chat.rocket.persistence.realm.models.ddp.RealmRole cacheroles = (chat.rocket.persistence.realm.models.ddp.RealmRole) cache.get(rolesItem);
                if (cacheroles != null) {
                    rolesRealmList.add(cacheroles);
                } else {
                    rolesRealmList.add(RealmRoleRealmProxy.copyOrUpdate(realm, rolesItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoomRole object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomRoleColumnInfo columnInfo = (RealmRoomRoleColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmRoomRoleRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$rid = ((RealmRoomRoleRealmProxyInterface) object).realmGet$rid();
        if (realmGet$rid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
        }

        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmRoomRoleRealmProxyInterface) object).realmGet$u();
        if (uObj != null) {
            Long cacheu = cache.get(uObj);
            if (cacheu == null) {
                cacheu = RealmUserRealmProxy.insert(realm, uObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.uIndex, rowIndex, cacheu, false);
        }

        RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesList = ((RealmRoomRoleRealmProxyInterface) object).realmGet$roles();
        if (rolesList != null) {
            OsList rolesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.rolesIndex);
            for (chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem : rolesList) {
                Long cacheItemIndexroles = cache.get(rolesItem);
                if (cacheItemIndexroles == null) {
                    cacheItemIndexroles = RealmRoleRealmProxy.insert(realm, rolesItem, cache);
                }
                rolesOsList.addRow(cacheItemIndexroles);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomRoleColumnInfo columnInfo = (RealmRoomRoleColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmRoomRole object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmRoomRoleRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$rid = ((RealmRoomRoleRealmProxyInterface) object).realmGet$rid();
            if (realmGet$rid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
            }

            chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmRoomRoleRealmProxyInterface) object).realmGet$u();
            if (uObj != null) {
                Long cacheu = cache.get(uObj);
                if (cacheu == null) {
                    cacheu = RealmUserRealmProxy.insert(realm, uObj, cache);
                }
                table.setLink(columnInfo.uIndex, rowIndex, cacheu, false);
            }

            RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesList = ((RealmRoomRoleRealmProxyInterface) object).realmGet$roles();
            if (rolesList != null) {
                OsList rolesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.rolesIndex);
                for (chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem : rolesList) {
                    Long cacheItemIndexroles = cache.get(rolesItem);
                    if (cacheItemIndexroles == null) {
                        cacheItemIndexroles = RealmRoleRealmProxy.insert(realm, rolesItem, cache);
                    }
                    rolesOsList.addRow(cacheItemIndexroles);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoomRole object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomRoleColumnInfo columnInfo = (RealmRoomRoleColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long pkColumnIndex = columnInfo._idIndex;
        String primaryKeyValue = ((RealmRoomRoleRealmProxyInterface) object).realmGet$_id();
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
        String realmGet$rid = ((RealmRoomRoleRealmProxyInterface) object).realmGet$rid();
        if (realmGet$rid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ridIndex, rowIndex, false);
        }

        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmRoomRoleRealmProxyInterface) object).realmGet$u();
        if (uObj != null) {
            Long cacheu = cache.get(uObj);
            if (cacheu == null) {
                cacheu = RealmUserRealmProxy.insertOrUpdate(realm, uObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.uIndex, rowIndex, cacheu, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.uIndex, rowIndex);
        }

        OsList rolesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.rolesIndex);
        RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesList = ((RealmRoomRoleRealmProxyInterface) object).realmGet$roles();
        if (rolesList != null && rolesList.size() == rolesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = rolesList.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem = rolesList.get(i);
                Long cacheItemIndexroles = cache.get(rolesItem);
                if (cacheItemIndexroles == null) {
                    cacheItemIndexroles = RealmRoleRealmProxy.insertOrUpdate(realm, rolesItem, cache);
                }
                rolesOsList.setRow(i, cacheItemIndexroles);
            }
        } else {
            rolesOsList.removeAll();
            if (rolesList != null) {
                for (chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem : rolesList) {
                    Long cacheItemIndexroles = cache.get(rolesItem);
                    if (cacheItemIndexroles == null) {
                        cacheItemIndexroles = RealmRoleRealmProxy.insertOrUpdate(realm, rolesItem, cache);
                    }
                    rolesOsList.addRow(cacheItemIndexroles);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long tableNativePtr = table.getNativePtr();
        RealmRoomRoleColumnInfo columnInfo = (RealmRoomRoleColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        long pkColumnIndex = columnInfo._idIndex;
        chat.rocket.persistence.realm.models.ddp.RealmRoomRole object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((RealmRoomRoleRealmProxyInterface) object).realmGet$_id();
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
            String realmGet$rid = ((RealmRoomRoleRealmProxyInterface) object).realmGet$rid();
            if (realmGet$rid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ridIndex, rowIndex, realmGet$rid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ridIndex, rowIndex, false);
            }

            chat.rocket.persistence.realm.models.ddp.RealmUser uObj = ((RealmRoomRoleRealmProxyInterface) object).realmGet$u();
            if (uObj != null) {
                Long cacheu = cache.get(uObj);
                if (cacheu == null) {
                    cacheu = RealmUserRealmProxy.insertOrUpdate(realm, uObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.uIndex, rowIndex, cacheu, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.uIndex, rowIndex);
            }

            OsList rolesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.rolesIndex);
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesList = ((RealmRoomRoleRealmProxyInterface) object).realmGet$roles();
            if (rolesList != null && rolesList.size() == rolesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = rolesList.size();
                for (int i = 0; i < objectCount; i++) {
                    chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem = rolesList.get(i);
                    Long cacheItemIndexroles = cache.get(rolesItem);
                    if (cacheItemIndexroles == null) {
                        cacheItemIndexroles = RealmRoleRealmProxy.insertOrUpdate(realm, rolesItem, cache);
                    }
                    rolesOsList.setRow(i, cacheItemIndexroles);
                }
            } else {
                rolesOsList.removeAll();
                if (rolesList != null) {
                    for (chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem : rolesList) {
                        Long cacheItemIndexroles = cache.get(rolesItem);
                        if (cacheItemIndexroles == null) {
                            cacheItemIndexroles = RealmRoleRealmProxy.insertOrUpdate(realm, rolesItem, cache);
                        }
                        rolesOsList.addRow(cacheItemIndexroles);
                    }
                }
            }

        }
    }

    public static chat.rocket.persistence.realm.models.ddp.RealmRoomRole createDetachedCopy(chat.rocket.persistence.realm.models.ddp.RealmRoomRole realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.ddp.RealmRoomRole unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.ddp.RealmRoomRole();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmRoomRoleRealmProxyInterface unmanagedCopy = (RealmRoomRoleRealmProxyInterface) unmanagedObject;
        RealmRoomRoleRealmProxyInterface realmSource = (RealmRoomRoleRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$rid(realmSource.realmGet$rid());

        // Deep copy of u
        unmanagedCopy.realmSet$u(RealmUserRealmProxy.createDetachedCopy(realmSource.realmGet$u(), currentDepth + 1, maxDepth, cache));

        // Deep copy of roles
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$roles(null);
        } else {
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> managedrolesList = realmSource.realmGet$roles();
            RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> unmanagedrolesList = new RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole>();
            unmanagedCopy.realmSet$roles(unmanagedrolesList);
            int nextDepth = currentDepth + 1;
            int size = managedrolesList.size();
            for (int i = 0; i < size; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmRole item = RealmRoleRealmProxy.createDetachedCopy(managedrolesList.get(i), nextDepth, maxDepth, cache);
                unmanagedrolesList.add(item);
            }
        }

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.ddp.RealmRoomRole update(Realm realm, chat.rocket.persistence.realm.models.ddp.RealmRoomRole realmObject, chat.rocket.persistence.realm.models.ddp.RealmRoomRole newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmRoomRoleRealmProxyInterface realmObjectTarget = (RealmRoomRoleRealmProxyInterface) realmObject;
        RealmRoomRoleRealmProxyInterface realmObjectSource = (RealmRoomRoleRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$rid(realmObjectSource.realmGet$rid());
        chat.rocket.persistence.realm.models.ddp.RealmUser uObj = realmObjectSource.realmGet$u();
        if (uObj == null) {
            realmObjectTarget.realmSet$u(null);
        } else {
            chat.rocket.persistence.realm.models.ddp.RealmUser cacheu = (chat.rocket.persistence.realm.models.ddp.RealmUser) cache.get(uObj);
            if (cacheu != null) {
                realmObjectTarget.realmSet$u(cacheu);
            } else {
                realmObjectTarget.realmSet$u(RealmUserRealmProxy.copyOrUpdate(realm, uObj, true, cache));
            }
        }
        RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesList = realmObjectSource.realmGet$roles();
        RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> rolesRealmList = realmObjectTarget.realmGet$roles();
        if (rolesList != null && rolesList.size() == rolesRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = rolesList.size();
            for (int i = 0; i < objects; i++) {
                chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem = rolesList.get(i);
                chat.rocket.persistence.realm.models.ddp.RealmRole cacheroles = (chat.rocket.persistence.realm.models.ddp.RealmRole) cache.get(rolesItem);
                if (cacheroles != null) {
                    rolesRealmList.set(i, cacheroles);
                } else {
                    rolesRealmList.set(i, RealmRoleRealmProxy.copyOrUpdate(realm, rolesItem, true, cache));
                }
            }
        } else {
            rolesRealmList.clear();
            if (rolesList != null) {
                for (int i = 0; i < rolesList.size(); i++) {
                    chat.rocket.persistence.realm.models.ddp.RealmRole rolesItem = rolesList.get(i);
                    chat.rocket.persistence.realm.models.ddp.RealmRole cacheroles = (chat.rocket.persistence.realm.models.ddp.RealmRole) cache.get(rolesItem);
                    if (cacheroles != null) {
                        rolesRealmList.add(cacheroles);
                    } else {
                        rolesRealmList.add(RealmRoleRealmProxy.copyOrUpdate(realm, rolesItem, true, cache));
                    }
                }
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
        StringBuilder stringBuilder = new StringBuilder("RealmRoomRole = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rid:");
        stringBuilder.append(realmGet$rid() != null ? realmGet$rid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{u:");
        stringBuilder.append(realmGet$u() != null ? "RealmUser" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{roles:");
        stringBuilder.append("RealmList<RealmRole>[").append(realmGet$roles().size()).append("]");
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
        RealmRoomRoleRealmProxy aRealmRoomRole = (RealmRoomRoleRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmRoomRole.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmRoomRole.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmRoomRole.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
