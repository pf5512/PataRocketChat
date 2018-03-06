package io.realm;


public interface RealmPermissionRealmProxyInterface {
    public String realmGet$_id();
    public void realmSet$_id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> realmGet$roles();
    public void realmSet$roles(RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> value);
}
