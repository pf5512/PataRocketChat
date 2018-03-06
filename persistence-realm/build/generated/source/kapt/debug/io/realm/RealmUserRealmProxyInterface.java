package io.realm;


public interface RealmUserRealmProxyInterface {
    public String realmGet$_id();
    public void realmSet$_id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$username();
    public void realmSet$username(String value);
    public String realmGet$status();
    public void realmSet$status(String value);
    public double realmGet$utcOffset();
    public void realmSet$utcOffset(double value);
    public RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> realmGet$emails();
    public void realmSet$emails(RealmList<chat.rocket.persistence.realm.models.ddp.RealmEmail> value);
    public chat.rocket.persistence.realm.models.ddp.RealmSettings realmGet$settings();
    public void realmSet$settings(chat.rocket.persistence.realm.models.ddp.RealmSettings value);
}
