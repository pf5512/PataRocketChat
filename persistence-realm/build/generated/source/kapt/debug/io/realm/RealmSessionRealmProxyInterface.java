package io.realm;


public interface RealmSessionRealmProxyInterface {
    public int realmGet$sessionId();
    public void realmSet$sessionId(int value);
    public String realmGet$token();
    public void realmSet$token(String value);
    public boolean realmGet$tokenVerified();
    public void realmSet$tokenVerified(boolean value);
    public String realmGet$error();
    public void realmSet$error(String value);
}
