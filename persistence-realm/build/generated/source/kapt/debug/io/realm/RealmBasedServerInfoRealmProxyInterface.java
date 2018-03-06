package io.realm;


public interface RealmBasedServerInfoRealmProxyInterface {
    public String realmGet$hostname();
    public void realmSet$hostname(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$session();
    public void realmSet$session(String value);
    public boolean realmGet$insecure();
    public void realmSet$insecure(boolean value);
}
