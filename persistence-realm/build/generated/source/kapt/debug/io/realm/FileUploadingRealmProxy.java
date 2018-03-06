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
public class FileUploadingRealmProxy extends chat.rocket.persistence.realm.models.internal.FileUploading
    implements RealmObjectProxy, FileUploadingRealmProxyInterface {

    static final class FileUploadingColumnInfo extends ColumnInfo {
        long uplIdIndex;
        long syncstateIndex;
        long storageTypeIndex;
        long uriIndex;
        long filenameIndex;
        long filesizeIndex;
        long mimeTypeIndex;
        long roomIdIndex;
        long uploadedSizeIndex;
        long errorIndex;

        FileUploadingColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("FileUploading");
            this.uplIdIndex = addColumnDetails("uplId", objectSchemaInfo);
            this.syncstateIndex = addColumnDetails("syncstate", objectSchemaInfo);
            this.storageTypeIndex = addColumnDetails("storageType", objectSchemaInfo);
            this.uriIndex = addColumnDetails("uri", objectSchemaInfo);
            this.filenameIndex = addColumnDetails("filename", objectSchemaInfo);
            this.filesizeIndex = addColumnDetails("filesize", objectSchemaInfo);
            this.mimeTypeIndex = addColumnDetails("mimeType", objectSchemaInfo);
            this.roomIdIndex = addColumnDetails("roomId", objectSchemaInfo);
            this.uploadedSizeIndex = addColumnDetails("uploadedSize", objectSchemaInfo);
            this.errorIndex = addColumnDetails("error", objectSchemaInfo);
        }

        FileUploadingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FileUploadingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FileUploadingColumnInfo src = (FileUploadingColumnInfo) rawSrc;
            final FileUploadingColumnInfo dst = (FileUploadingColumnInfo) rawDst;
            dst.uplIdIndex = src.uplIdIndex;
            dst.syncstateIndex = src.syncstateIndex;
            dst.storageTypeIndex = src.storageTypeIndex;
            dst.uriIndex = src.uriIndex;
            dst.filenameIndex = src.filenameIndex;
            dst.filesizeIndex = src.filesizeIndex;
            dst.mimeTypeIndex = src.mimeTypeIndex;
            dst.roomIdIndex = src.roomIdIndex;
            dst.uploadedSizeIndex = src.uploadedSizeIndex;
            dst.errorIndex = src.errorIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(10);
        fieldNames.add("uplId");
        fieldNames.add("syncstate");
        fieldNames.add("storageType");
        fieldNames.add("uri");
        fieldNames.add("filename");
        fieldNames.add("filesize");
        fieldNames.add("mimeType");
        fieldNames.add("roomId");
        fieldNames.add("uploadedSize");
        fieldNames.add("error");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private FileUploadingColumnInfo columnInfo;
    private ProxyState<chat.rocket.persistence.realm.models.internal.FileUploading> proxyState;

    FileUploadingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FileUploadingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<chat.rocket.persistence.realm.models.internal.FileUploading>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uplId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uplIdIndex);
    }

    @Override
    public void realmSet$uplId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'uplId' cannot be changed after object was created.");
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
    public String realmGet$storageType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.storageTypeIndex);
    }

    @Override
    public void realmSet$storageType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.storageTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.storageTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.storageTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.storageTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uri() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uriIndex);
    }

    @Override
    public void realmSet$uri(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.uriIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.uriIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.uriIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.uriIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$filename() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.filenameIndex);
    }

    @Override
    public void realmSet$filename(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.filenameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.filenameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.filenameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.filenameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$filesize() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.filesizeIndex);
    }

    @Override
    public void realmSet$filesize(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.filesizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.filesizeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mimeType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mimeTypeIndex);
    }

    @Override
    public void realmSet$mimeType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mimeTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mimeTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mimeTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mimeTypeIndex, value);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.roomIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.roomIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.roomIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.roomIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$uploadedSize() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.uploadedSizeIndex);
    }

    @Override
    public void realmSet$uploadedSize(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.uploadedSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.uploadedSizeIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FileUploading", 10, 0);
        builder.addPersistedProperty("uplId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("syncstate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("storageType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("uri", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("filename", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("filesize", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("mimeType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("roomId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("uploadedSize", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("error", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FileUploadingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new FileUploadingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "FileUploading";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static chat.rocket.persistence.realm.models.internal.FileUploading createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        chat.rocket.persistence.realm.models.internal.FileUploading obj = null;
        if (update) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.FileUploading.class);
            FileUploadingColumnInfo columnInfo = (FileUploadingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class);
            long pkColumnIndex = columnInfo.uplIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("uplId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("uplId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class), false, Collections.<String> emptyList());
                    obj = new io.realm.FileUploadingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uplId")) {
                if (json.isNull("uplId")) {
                    obj = (io.realm.FileUploadingRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.FileUploading.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.FileUploadingRealmProxy) realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.FileUploading.class, json.getString("uplId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uplId'.");
            }
        }

        final FileUploadingRealmProxyInterface objProxy = (FileUploadingRealmProxyInterface) obj;
        if (json.has("syncstate")) {
            if (json.isNull("syncstate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
            } else {
                objProxy.realmSet$syncstate((int) json.getInt("syncstate"));
            }
        }
        if (json.has("storageType")) {
            if (json.isNull("storageType")) {
                objProxy.realmSet$storageType(null);
            } else {
                objProxy.realmSet$storageType((String) json.getString("storageType"));
            }
        }
        if (json.has("uri")) {
            if (json.isNull("uri")) {
                objProxy.realmSet$uri(null);
            } else {
                objProxy.realmSet$uri((String) json.getString("uri"));
            }
        }
        if (json.has("filename")) {
            if (json.isNull("filename")) {
                objProxy.realmSet$filename(null);
            } else {
                objProxy.realmSet$filename((String) json.getString("filename"));
            }
        }
        if (json.has("filesize")) {
            if (json.isNull("filesize")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'filesize' to null.");
            } else {
                objProxy.realmSet$filesize((long) json.getLong("filesize"));
            }
        }
        if (json.has("mimeType")) {
            if (json.isNull("mimeType")) {
                objProxy.realmSet$mimeType(null);
            } else {
                objProxy.realmSet$mimeType((String) json.getString("mimeType"));
            }
        }
        if (json.has("roomId")) {
            if (json.isNull("roomId")) {
                objProxy.realmSet$roomId(null);
            } else {
                objProxy.realmSet$roomId((String) json.getString("roomId"));
            }
        }
        if (json.has("uploadedSize")) {
            if (json.isNull("uploadedSize")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'uploadedSize' to null.");
            } else {
                objProxy.realmSet$uploadedSize((long) json.getLong("uploadedSize"));
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
    public static chat.rocket.persistence.realm.models.internal.FileUploading createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final chat.rocket.persistence.realm.models.internal.FileUploading obj = new chat.rocket.persistence.realm.models.internal.FileUploading();
        final FileUploadingRealmProxyInterface objProxy = (FileUploadingRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("uplId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uplId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uplId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("syncstate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$syncstate((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'syncstate' to null.");
                }
            } else if (name.equals("storageType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$storageType((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$storageType(null);
                }
            } else if (name.equals("uri")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uri((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uri(null);
                }
            } else if (name.equals("filename")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$filename((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$filename(null);
                }
            } else if (name.equals("filesize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$filesize((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'filesize' to null.");
                }
            } else if (name.equals("mimeType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mimeType((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mimeType(null);
                }
            } else if (name.equals("roomId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$roomId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$roomId(null);
                }
            } else if (name.equals("uploadedSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uploadedSize((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'uploadedSize' to null.");
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
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uplId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static chat.rocket.persistence.realm.models.internal.FileUploading copyOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.FileUploading object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (chat.rocket.persistence.realm.models.internal.FileUploading) cachedRealmObject;
        }

        chat.rocket.persistence.realm.models.internal.FileUploading realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.FileUploading.class);
            FileUploadingColumnInfo columnInfo = (FileUploadingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class);
            long pkColumnIndex = columnInfo.uplIdIndex;
            String value = ((FileUploadingRealmProxyInterface) object).realmGet$uplId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.FileUploadingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static chat.rocket.persistence.realm.models.internal.FileUploading copy(Realm realm, chat.rocket.persistence.realm.models.internal.FileUploading newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (chat.rocket.persistence.realm.models.internal.FileUploading) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        chat.rocket.persistence.realm.models.internal.FileUploading realmObject = realm.createObjectInternal(chat.rocket.persistence.realm.models.internal.FileUploading.class, ((FileUploadingRealmProxyInterface) newObject).realmGet$uplId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        FileUploadingRealmProxyInterface realmObjectSource = (FileUploadingRealmProxyInterface) newObject;
        FileUploadingRealmProxyInterface realmObjectCopy = (FileUploadingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectCopy.realmSet$storageType(realmObjectSource.realmGet$storageType());
        realmObjectCopy.realmSet$uri(realmObjectSource.realmGet$uri());
        realmObjectCopy.realmSet$filename(realmObjectSource.realmGet$filename());
        realmObjectCopy.realmSet$filesize(realmObjectSource.realmGet$filesize());
        realmObjectCopy.realmSet$mimeType(realmObjectSource.realmGet$mimeType());
        realmObjectCopy.realmSet$roomId(realmObjectSource.realmGet$roomId());
        realmObjectCopy.realmSet$uploadedSize(realmObjectSource.realmGet$uploadedSize());
        realmObjectCopy.realmSet$error(realmObjectSource.realmGet$error());
        return realmObject;
    }

    public static long insert(Realm realm, chat.rocket.persistence.realm.models.internal.FileUploading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long tableNativePtr = table.getNativePtr();
        FileUploadingColumnInfo columnInfo = (FileUploadingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long pkColumnIndex = columnInfo.uplIdIndex;
        String primaryKeyValue = ((FileUploadingRealmProxyInterface) object).realmGet$uplId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$syncstate(), false);
        String realmGet$storageType = ((FileUploadingRealmProxyInterface) object).realmGet$storageType();
        if (realmGet$storageType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.storageTypeIndex, rowIndex, realmGet$storageType, false);
        }
        String realmGet$uri = ((FileUploadingRealmProxyInterface) object).realmGet$uri();
        if (realmGet$uri != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uriIndex, rowIndex, realmGet$uri, false);
        }
        String realmGet$filename = ((FileUploadingRealmProxyInterface) object).realmGet$filename();
        if (realmGet$filename != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.filesizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$filesize(), false);
        String realmGet$mimeType = ((FileUploadingRealmProxyInterface) object).realmGet$mimeType();
        if (realmGet$mimeType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mimeTypeIndex, rowIndex, realmGet$mimeType, false);
        }
        String realmGet$roomId = ((FileUploadingRealmProxyInterface) object).realmGet$roomId();
        if (realmGet$roomId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.roomIdIndex, rowIndex, realmGet$roomId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.uploadedSizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$uploadedSize(), false);
        String realmGet$error = ((FileUploadingRealmProxyInterface) object).realmGet$error();
        if (realmGet$error != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long tableNativePtr = table.getNativePtr();
        FileUploadingColumnInfo columnInfo = (FileUploadingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long pkColumnIndex = columnInfo.uplIdIndex;
        chat.rocket.persistence.realm.models.internal.FileUploading object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.FileUploading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((FileUploadingRealmProxyInterface) object).realmGet$uplId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$syncstate(), false);
            String realmGet$storageType = ((FileUploadingRealmProxyInterface) object).realmGet$storageType();
            if (realmGet$storageType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.storageTypeIndex, rowIndex, realmGet$storageType, false);
            }
            String realmGet$uri = ((FileUploadingRealmProxyInterface) object).realmGet$uri();
            if (realmGet$uri != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uriIndex, rowIndex, realmGet$uri, false);
            }
            String realmGet$filename = ((FileUploadingRealmProxyInterface) object).realmGet$filename();
            if (realmGet$filename != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.filesizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$filesize(), false);
            String realmGet$mimeType = ((FileUploadingRealmProxyInterface) object).realmGet$mimeType();
            if (realmGet$mimeType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mimeTypeIndex, rowIndex, realmGet$mimeType, false);
            }
            String realmGet$roomId = ((FileUploadingRealmProxyInterface) object).realmGet$roomId();
            if (realmGet$roomId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.roomIdIndex, rowIndex, realmGet$roomId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.uploadedSizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$uploadedSize(), false);
            String realmGet$error = ((FileUploadingRealmProxyInterface) object).realmGet$error();
            if (realmGet$error != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, chat.rocket.persistence.realm.models.internal.FileUploading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long tableNativePtr = table.getNativePtr();
        FileUploadingColumnInfo columnInfo = (FileUploadingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long pkColumnIndex = columnInfo.uplIdIndex;
        String primaryKeyValue = ((FileUploadingRealmProxyInterface) object).realmGet$uplId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$syncstate(), false);
        String realmGet$storageType = ((FileUploadingRealmProxyInterface) object).realmGet$storageType();
        if (realmGet$storageType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.storageTypeIndex, rowIndex, realmGet$storageType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.storageTypeIndex, rowIndex, false);
        }
        String realmGet$uri = ((FileUploadingRealmProxyInterface) object).realmGet$uri();
        if (realmGet$uri != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uriIndex, rowIndex, realmGet$uri, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.uriIndex, rowIndex, false);
        }
        String realmGet$filename = ((FileUploadingRealmProxyInterface) object).realmGet$filename();
        if (realmGet$filename != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.filenameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.filesizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$filesize(), false);
        String realmGet$mimeType = ((FileUploadingRealmProxyInterface) object).realmGet$mimeType();
        if (realmGet$mimeType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mimeTypeIndex, rowIndex, realmGet$mimeType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mimeTypeIndex, rowIndex, false);
        }
        String realmGet$roomId = ((FileUploadingRealmProxyInterface) object).realmGet$roomId();
        if (realmGet$roomId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.roomIdIndex, rowIndex, realmGet$roomId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.roomIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.uploadedSizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$uploadedSize(), false);
        String realmGet$error = ((FileUploadingRealmProxyInterface) object).realmGet$error();
        if (realmGet$error != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.errorIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long tableNativePtr = table.getNativePtr();
        FileUploadingColumnInfo columnInfo = (FileUploadingColumnInfo) realm.getSchema().getColumnInfo(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        long pkColumnIndex = columnInfo.uplIdIndex;
        chat.rocket.persistence.realm.models.internal.FileUploading object = null;
        while (objects.hasNext()) {
            object = (chat.rocket.persistence.realm.models.internal.FileUploading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((FileUploadingRealmProxyInterface) object).realmGet$uplId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.syncstateIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$syncstate(), false);
            String realmGet$storageType = ((FileUploadingRealmProxyInterface) object).realmGet$storageType();
            if (realmGet$storageType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.storageTypeIndex, rowIndex, realmGet$storageType, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.storageTypeIndex, rowIndex, false);
            }
            String realmGet$uri = ((FileUploadingRealmProxyInterface) object).realmGet$uri();
            if (realmGet$uri != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uriIndex, rowIndex, realmGet$uri, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.uriIndex, rowIndex, false);
            }
            String realmGet$filename = ((FileUploadingRealmProxyInterface) object).realmGet$filename();
            if (realmGet$filename != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.filenameIndex, rowIndex, realmGet$filename, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.filenameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.filesizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$filesize(), false);
            String realmGet$mimeType = ((FileUploadingRealmProxyInterface) object).realmGet$mimeType();
            if (realmGet$mimeType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mimeTypeIndex, rowIndex, realmGet$mimeType, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mimeTypeIndex, rowIndex, false);
            }
            String realmGet$roomId = ((FileUploadingRealmProxyInterface) object).realmGet$roomId();
            if (realmGet$roomId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.roomIdIndex, rowIndex, realmGet$roomId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.roomIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.uploadedSizeIndex, rowIndex, ((FileUploadingRealmProxyInterface) object).realmGet$uploadedSize(), false);
            String realmGet$error = ((FileUploadingRealmProxyInterface) object).realmGet$error();
            if (realmGet$error != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.errorIndex, rowIndex, false);
            }
        }
    }

    public static chat.rocket.persistence.realm.models.internal.FileUploading createDetachedCopy(chat.rocket.persistence.realm.models.internal.FileUploading realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        chat.rocket.persistence.realm.models.internal.FileUploading unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new chat.rocket.persistence.realm.models.internal.FileUploading();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (chat.rocket.persistence.realm.models.internal.FileUploading) cachedObject.object;
            }
            unmanagedObject = (chat.rocket.persistence.realm.models.internal.FileUploading) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        FileUploadingRealmProxyInterface unmanagedCopy = (FileUploadingRealmProxyInterface) unmanagedObject;
        FileUploadingRealmProxyInterface realmSource = (FileUploadingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$uplId(realmSource.realmGet$uplId());
        unmanagedCopy.realmSet$syncstate(realmSource.realmGet$syncstate());
        unmanagedCopy.realmSet$storageType(realmSource.realmGet$storageType());
        unmanagedCopy.realmSet$uri(realmSource.realmGet$uri());
        unmanagedCopy.realmSet$filename(realmSource.realmGet$filename());
        unmanagedCopy.realmSet$filesize(realmSource.realmGet$filesize());
        unmanagedCopy.realmSet$mimeType(realmSource.realmGet$mimeType());
        unmanagedCopy.realmSet$roomId(realmSource.realmGet$roomId());
        unmanagedCopy.realmSet$uploadedSize(realmSource.realmGet$uploadedSize());
        unmanagedCopy.realmSet$error(realmSource.realmGet$error());

        return unmanagedObject;
    }

    static chat.rocket.persistence.realm.models.internal.FileUploading update(Realm realm, chat.rocket.persistence.realm.models.internal.FileUploading realmObject, chat.rocket.persistence.realm.models.internal.FileUploading newObject, Map<RealmModel, RealmObjectProxy> cache) {
        FileUploadingRealmProxyInterface realmObjectTarget = (FileUploadingRealmProxyInterface) realmObject;
        FileUploadingRealmProxyInterface realmObjectSource = (FileUploadingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$syncstate(realmObjectSource.realmGet$syncstate());
        realmObjectTarget.realmSet$storageType(realmObjectSource.realmGet$storageType());
        realmObjectTarget.realmSet$uri(realmObjectSource.realmGet$uri());
        realmObjectTarget.realmSet$filename(realmObjectSource.realmGet$filename());
        realmObjectTarget.realmSet$filesize(realmObjectSource.realmGet$filesize());
        realmObjectTarget.realmSet$mimeType(realmObjectSource.realmGet$mimeType());
        realmObjectTarget.realmSet$roomId(realmObjectSource.realmGet$roomId());
        realmObjectTarget.realmSet$uploadedSize(realmObjectSource.realmGet$uploadedSize());
        realmObjectTarget.realmSet$error(realmObjectSource.realmGet$error());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FileUploading = proxy[");
        stringBuilder.append("{uplId:");
        stringBuilder.append(realmGet$uplId() != null ? realmGet$uplId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{syncstate:");
        stringBuilder.append(realmGet$syncstate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{storageType:");
        stringBuilder.append(realmGet$storageType() != null ? realmGet$storageType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uri:");
        stringBuilder.append(realmGet$uri() != null ? realmGet$uri() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{filename:");
        stringBuilder.append(realmGet$filename() != null ? realmGet$filename() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{filesize:");
        stringBuilder.append(realmGet$filesize());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mimeType:");
        stringBuilder.append(realmGet$mimeType() != null ? realmGet$mimeType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{roomId:");
        stringBuilder.append(realmGet$roomId() != null ? realmGet$roomId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uploadedSize:");
        stringBuilder.append(realmGet$uploadedSize());
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
        FileUploadingRealmProxy aFileUploading = (FileUploadingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFileUploading.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFileUploading.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFileUploading.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
