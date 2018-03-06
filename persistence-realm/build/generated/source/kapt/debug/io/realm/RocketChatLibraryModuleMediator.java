package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class RocketChatLibraryModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(21);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmMessage.class);
        modelClasses.add(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class);
        modelClasses.add(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class);
        modelClasses.add(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class);
        modelClasses.add(chat.rocket.persistence.realm.models.internal.FileUploading.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmRoom.class);
        modelClasses.add(chat.rocket.persistence.realm.models.internal.RealmSession.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmUser.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmPermission.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmSettings.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmEmail.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmRole.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class);
        modelClasses.add(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class);
        modelClasses.add(chat.rocket.persistence.realm.models.internal.MethodCall.class);
        modelClasses.add(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(21);
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmMessage.class, io.realm.RealmMessageRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class, io.realm.GetUsersOfRoomsProcedureRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class, io.realm.RealmPublicSettingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class, io.realm.RealmPreferencesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class, io.realm.RealmBasedServerInfoRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class, io.realm.LoadMessageProcedureRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.internal.FileUploading.class, io.realm.FileUploadingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmRoom.class, io.realm.RealmRoomRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.internal.RealmSession.class, io.realm.RealmSessionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class, io.realm.RealmSpotlightRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class, io.realm.RealmSpotlightUserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmUser.class, io.realm.RealmUserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmPermission.class, io.realm.RealmPermissionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmSettings.class, io.realm.RealmSettingsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmEmail.class, io.realm.RealmEmailRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class, io.realm.RealmSpotlightRoomRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmRole.class, io.realm.RealmRoleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class, io.realm.RealmRoomRoleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class, io.realm.GcmPushRegistrationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.internal.MethodCall.class, io.realm.MethodCallRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class, io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return io.realm.RealmMessageRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return io.realm.GetUsersOfRoomsProcedureRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return io.realm.RealmPublicSettingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return io.realm.RealmPreferencesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return io.realm.RealmBasedServerInfoRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return io.realm.LoadMessageProcedureRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return io.realm.FileUploadingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return io.realm.RealmRoomRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return io.realm.RealmSessionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return io.realm.RealmSpotlightRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return io.realm.RealmSpotlightUserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return io.realm.RealmUserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return io.realm.RealmPermissionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return io.realm.RealmSettingsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return io.realm.RealmEmailRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return io.realm.RealmSpotlightRoomRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return io.realm.RealmRoleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return io.realm.RealmRoomRoleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return io.realm.GcmPushRegistrationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return io.realm.MethodCallRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return io.realm.RealmMessageRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return io.realm.GetUsersOfRoomsProcedureRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return io.realm.RealmPublicSettingRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return io.realm.RealmPreferencesRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return io.realm.RealmBasedServerInfoRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return io.realm.LoadMessageProcedureRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return io.realm.FileUploadingRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return io.realm.RealmRoomRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return io.realm.RealmSessionRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return io.realm.RealmSpotlightRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return io.realm.RealmSpotlightUserRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return io.realm.RealmUserRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return io.realm.RealmPermissionRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return io.realm.RealmSettingsRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return io.realm.RealmEmailRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return io.realm.RealmSpotlightRoomRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return io.realm.RealmRoleRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return io.realm.RealmRoomRoleRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return io.realm.GcmPushRegistrationRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return io.realm.MethodCallRealmProxy.getFieldNames();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return io.realm.RealmMessageRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return io.realm.GetUsersOfRoomsProcedureRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return io.realm.RealmPublicSettingRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return io.realm.RealmPreferencesRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return io.realm.RealmBasedServerInfoRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return io.realm.LoadMessageProcedureRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return io.realm.FileUploadingRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return io.realm.RealmRoomRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return io.realm.RealmSessionRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return io.realm.RealmSpotlightRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return io.realm.RealmSpotlightUserRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return io.realm.RealmUserRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return io.realm.RealmPermissionRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return io.realm.RealmSettingsRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return io.realm.RealmEmailRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return io.realm.RealmSpotlightRoomRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return io.realm.RealmRoleRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return io.realm.RealmRoomRoleRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return io.realm.GcmPushRegistrationRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return io.realm.MethodCallRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
                return clazz.cast(new io.realm.RealmMessageRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
                return clazz.cast(new io.realm.GetUsersOfRoomsProcedureRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
                return clazz.cast(new io.realm.RealmPublicSettingRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
                return clazz.cast(new io.realm.RealmPreferencesRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
                return clazz.cast(new io.realm.RealmBasedServerInfoRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
                return clazz.cast(new io.realm.LoadMessageProcedureRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
                return clazz.cast(new io.realm.FileUploadingRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
                return clazz.cast(new io.realm.RealmRoomRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
                return clazz.cast(new io.realm.RealmSessionRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
                return clazz.cast(new io.realm.RealmSpotlightRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
                return clazz.cast(new io.realm.RealmSpotlightUserRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
                return clazz.cast(new io.realm.RealmUserRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
                return clazz.cast(new io.realm.RealmPermissionRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
                return clazz.cast(new io.realm.RealmSettingsRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
                return clazz.cast(new io.realm.RealmEmailRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
                return clazz.cast(new io.realm.RealmSpotlightRoomRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
                return clazz.cast(new io.realm.RealmRoleRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
                return clazz.cast(new io.realm.RealmRoomRoleRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
                return clazz.cast(new io.realm.GcmPushRegistrationRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
                return clazz.cast(new io.realm.MethodCallRealmProxy());
            }
            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
                return clazz.cast(new io.realm.RealmMeteorLoginServiceConfigurationRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return clazz.cast(io.realm.RealmMessageRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmMessage) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return clazz.cast(io.realm.GetUsersOfRoomsProcedureRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return clazz.cast(io.realm.RealmPublicSettingRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return clazz.cast(io.realm.RealmPreferencesRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPreferences) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return clazz.cast(io.realm.RealmBasedServerInfoRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.RealmBasedServerInfo) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return clazz.cast(io.realm.LoadMessageProcedureRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return clazz.cast(io.realm.FileUploadingRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.FileUploading) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return clazz.cast(io.realm.RealmRoomRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoom) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return clazz.cast(io.realm.RealmSessionRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.RealmSession) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return clazz.cast(io.realm.RealmSpotlightRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlight) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return clazz.cast(io.realm.RealmSpotlightUserRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return clazz.cast(io.realm.RealmUserRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmUser) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return clazz.cast(io.realm.RealmPermissionRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPermission) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return clazz.cast(io.realm.RealmSettingsRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSettings) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return clazz.cast(io.realm.RealmEmailRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmEmail) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return clazz.cast(io.realm.RealmSpotlightRoomRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return clazz.cast(io.realm.RealmRoleRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRole) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return clazz.cast(io.realm.RealmRoomRoleRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return clazz.cast(io.realm.GcmPushRegistrationRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return clazz.cast(io.realm.MethodCallRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.MethodCall) obj, update, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return clazz.cast(io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.copyOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            io.realm.RealmMessageRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmMessage) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            io.realm.GetUsersOfRoomsProcedureRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            io.realm.RealmPublicSettingRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            io.realm.RealmPreferencesRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmPreferences) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            io.realm.RealmBasedServerInfoRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.RealmBasedServerInfo) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            io.realm.LoadMessageProcedureRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            io.realm.FileUploadingRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.FileUploading) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            io.realm.RealmRoomRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoom) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            io.realm.RealmSessionRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.RealmSession) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            io.realm.RealmSpotlightRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlight) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            io.realm.RealmSpotlightUserRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            io.realm.RealmUserRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmUser) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            io.realm.RealmPermissionRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmPermission) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            io.realm.RealmSettingsRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSettings) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            io.realm.RealmEmailRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmEmail) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            io.realm.RealmSpotlightRoomRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            io.realm.RealmRoleRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmRole) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            io.realm.RealmRoomRoleRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            io.realm.GcmPushRegistrationRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            io.realm.MethodCallRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.MethodCall) object, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
                io.realm.RealmMessageRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmMessage) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
                io.realm.GetUsersOfRoomsProcedureRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
                io.realm.RealmPublicSettingRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
                io.realm.RealmPreferencesRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmPreferences) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
                io.realm.RealmBasedServerInfoRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.RealmBasedServerInfo) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
                io.realm.LoadMessageProcedureRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
                io.realm.FileUploadingRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.FileUploading) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
                io.realm.RealmRoomRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoom) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
                io.realm.RealmSessionRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.RealmSession) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
                io.realm.RealmSpotlightRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlight) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
                io.realm.RealmSpotlightUserRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
                io.realm.RealmUserRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmUser) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
                io.realm.RealmPermissionRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmPermission) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
                io.realm.RealmSettingsRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSettings) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
                io.realm.RealmEmailRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmEmail) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
                io.realm.RealmSpotlightRoomRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
                io.realm.RealmRoleRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmRole) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
                io.realm.RealmRoomRoleRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
                io.realm.GcmPushRegistrationRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
                io.realm.MethodCallRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.internal.MethodCall) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
                io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.insert(realm, (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
                    io.realm.RealmMessageRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
                    io.realm.GetUsersOfRoomsProcedureRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
                    io.realm.RealmPublicSettingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
                    io.realm.RealmPreferencesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
                    io.realm.RealmBasedServerInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
                    io.realm.LoadMessageProcedureRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
                    io.realm.FileUploadingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
                    io.realm.RealmRoomRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
                    io.realm.RealmSessionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
                    io.realm.RealmSpotlightRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
                    io.realm.RealmSpotlightUserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
                    io.realm.RealmUserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
                    io.realm.RealmPermissionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
                    io.realm.RealmSettingsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
                    io.realm.RealmEmailRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
                    io.realm.RealmSpotlightRoomRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
                    io.realm.RealmRoleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
                    io.realm.RealmRoomRoleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
                    io.realm.GcmPushRegistrationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
                    io.realm.MethodCallRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
                    io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            io.realm.RealmMessageRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmMessage) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            io.realm.GetUsersOfRoomsProcedureRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            io.realm.RealmPublicSettingRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            io.realm.RealmPreferencesRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPreferences) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            io.realm.RealmBasedServerInfoRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.RealmBasedServerInfo) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            io.realm.LoadMessageProcedureRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            io.realm.FileUploadingRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.FileUploading) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            io.realm.RealmRoomRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoom) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            io.realm.RealmSessionRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.RealmSession) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            io.realm.RealmSpotlightRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlight) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            io.realm.RealmSpotlightUserRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            io.realm.RealmUserRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmUser) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            io.realm.RealmPermissionRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPermission) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            io.realm.RealmSettingsRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSettings) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            io.realm.RealmEmailRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmEmail) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            io.realm.RealmSpotlightRoomRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            io.realm.RealmRoleRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRole) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            io.realm.RealmRoomRoleRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            io.realm.GcmPushRegistrationRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            io.realm.MethodCallRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.MethodCall) obj, cache);
        } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
                io.realm.RealmMessageRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmMessage) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
                io.realm.GetUsersOfRoomsProcedureRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
                io.realm.RealmPublicSettingRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
                io.realm.RealmPreferencesRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPreferences) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
                io.realm.RealmBasedServerInfoRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.RealmBasedServerInfo) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
                io.realm.LoadMessageProcedureRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
                io.realm.FileUploadingRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.FileUploading) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
                io.realm.RealmRoomRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoom) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
                io.realm.RealmSessionRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.RealmSession) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
                io.realm.RealmSpotlightRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlight) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
                io.realm.RealmSpotlightUserRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
                io.realm.RealmUserRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmUser) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
                io.realm.RealmPermissionRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmPermission) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
                io.realm.RealmSettingsRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSettings) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
                io.realm.RealmEmailRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmEmail) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
                io.realm.RealmSpotlightRoomRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
                io.realm.RealmRoleRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRole) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
                io.realm.RealmRoomRoleRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmRoomRole) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
                io.realm.GcmPushRegistrationRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.GcmPushRegistration) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
                io.realm.MethodCallRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.internal.MethodCall) object, cache);
            } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
                io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.insertOrUpdate(realm, (chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
                    io.realm.RealmMessageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
                    io.realm.GetUsersOfRoomsProcedureRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
                    io.realm.RealmPublicSettingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
                    io.realm.RealmPreferencesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
                    io.realm.RealmBasedServerInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
                    io.realm.LoadMessageProcedureRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
                    io.realm.FileUploadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
                    io.realm.RealmRoomRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
                    io.realm.RealmSessionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
                    io.realm.RealmSpotlightRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
                    io.realm.RealmSpotlightUserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
                    io.realm.RealmUserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
                    io.realm.RealmPermissionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
                    io.realm.RealmSettingsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
                    io.realm.RealmEmailRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
                    io.realm.RealmSpotlightRoomRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
                    io.realm.RealmRoleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
                    io.realm.RealmRoomRoleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
                    io.realm.GcmPushRegistrationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
                    io.realm.MethodCallRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
                    io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return clazz.cast(io.realm.RealmMessageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return clazz.cast(io.realm.GetUsersOfRoomsProcedureRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return clazz.cast(io.realm.RealmPublicSettingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return clazz.cast(io.realm.RealmPreferencesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return clazz.cast(io.realm.RealmBasedServerInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return clazz.cast(io.realm.LoadMessageProcedureRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return clazz.cast(io.realm.FileUploadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return clazz.cast(io.realm.RealmRoomRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return clazz.cast(io.realm.RealmSessionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return clazz.cast(io.realm.RealmSpotlightRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return clazz.cast(io.realm.RealmSpotlightUserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return clazz.cast(io.realm.RealmUserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return clazz.cast(io.realm.RealmPermissionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return clazz.cast(io.realm.RealmSettingsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return clazz.cast(io.realm.RealmEmailRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return clazz.cast(io.realm.RealmSpotlightRoomRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return clazz.cast(io.realm.RealmRoleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return clazz.cast(io.realm.RealmRoomRoleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return clazz.cast(io.realm.GcmPushRegistrationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return clazz.cast(io.realm.MethodCallRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return clazz.cast(io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return clazz.cast(io.realm.RealmMessageRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return clazz.cast(io.realm.GetUsersOfRoomsProcedureRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return clazz.cast(io.realm.RealmPublicSettingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return clazz.cast(io.realm.RealmPreferencesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return clazz.cast(io.realm.RealmBasedServerInfoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return clazz.cast(io.realm.LoadMessageProcedureRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return clazz.cast(io.realm.FileUploadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return clazz.cast(io.realm.RealmRoomRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return clazz.cast(io.realm.RealmSessionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return clazz.cast(io.realm.RealmSpotlightRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return clazz.cast(io.realm.RealmSpotlightUserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return clazz.cast(io.realm.RealmUserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return clazz.cast(io.realm.RealmPermissionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return clazz.cast(io.realm.RealmSettingsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return clazz.cast(io.realm.RealmEmailRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return clazz.cast(io.realm.RealmSpotlightRoomRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return clazz.cast(io.realm.RealmRoleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return clazz.cast(io.realm.RealmRoomRoleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return clazz.cast(io.realm.GcmPushRegistrationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return clazz.cast(io.realm.MethodCallRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return clazz.cast(io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMessage.class)) {
            return clazz.cast(io.realm.RealmMessageRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmMessage) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure.class)) {
            return clazz.cast(io.realm.GetUsersOfRoomsProcedureRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.internal.GetUsersOfRoomsProcedure) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPublicSetting.class)) {
            return clazz.cast(io.realm.RealmPublicSettingRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmPublicSetting) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPreferences.class)) {
            return clazz.cast(io.realm.RealmPreferencesRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmPreferences) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.RealmBasedServerInfo.class)) {
            return clazz.cast(io.realm.RealmBasedServerInfoRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.RealmBasedServerInfo) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.LoadMessageProcedure.class)) {
            return clazz.cast(io.realm.LoadMessageProcedureRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.internal.LoadMessageProcedure) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.FileUploading.class)) {
            return clazz.cast(io.realm.FileUploadingRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.internal.FileUploading) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoom.class)) {
            return clazz.cast(io.realm.RealmRoomRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmRoom) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.RealmSession.class)) {
            return clazz.cast(io.realm.RealmSessionRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.internal.RealmSession) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlight.class)) {
            return clazz.cast(io.realm.RealmSpotlightRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmSpotlight) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser.class)) {
            return clazz.cast(io.realm.RealmSpotlightUserRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmSpotlightUser) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmUser.class)) {
            return clazz.cast(io.realm.RealmUserRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmUser) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmPermission.class)) {
            return clazz.cast(io.realm.RealmPermissionRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmPermission) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSettings.class)) {
            return clazz.cast(io.realm.RealmSettingsRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmSettings) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmEmail.class)) {
            return clazz.cast(io.realm.RealmEmailRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmEmail) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom.class)) {
            return clazz.cast(io.realm.RealmSpotlightRoomRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmSpotlightRoom) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRole.class)) {
            return clazz.cast(io.realm.RealmRoleRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmRole) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmRoomRole.class)) {
            return clazz.cast(io.realm.RealmRoomRoleRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmRoomRole) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.GcmPushRegistration.class)) {
            return clazz.cast(io.realm.GcmPushRegistrationRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.internal.GcmPushRegistration) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.internal.MethodCall.class)) {
            return clazz.cast(io.realm.MethodCallRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.internal.MethodCall) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration.class)) {
            return clazz.cast(io.realm.RealmMeteorLoginServiceConfigurationRealmProxy.createDetachedCopy((chat.rocket.persistence.realm.models.ddp.RealmMeteorLoginServiceConfiguration) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
