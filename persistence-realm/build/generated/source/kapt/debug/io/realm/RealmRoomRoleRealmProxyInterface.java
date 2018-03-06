package io.realm;


public interface RealmRoomRoleRealmProxyInterface {
    public String realmGet$_id();
    public void realmSet$_id(String value);
    public String realmGet$rid();
    public void realmSet$rid(String value);
    public chat.rocket.persistence.realm.models.ddp.RealmUser realmGet$u();
    public void realmSet$u(chat.rocket.persistence.realm.models.ddp.RealmUser value);
    public RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> realmGet$roles();
    public void realmSet$roles(RealmList<chat.rocket.persistence.realm.models.ddp.RealmRole> value);
}
