package io.realm;


public interface RealmSettingsRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public chat.rocket.persistence.realm.models.ddp.RealmPreferences realmGet$preferences();
    public void realmSet$preferences(chat.rocket.persistence.realm.models.ddp.RealmPreferences value);
}
