package io.realm;


public interface MethodCallRealmProxyInterface {
    public String realmGet$methodCallId();
    public void realmSet$methodCallId(String value);
    public int realmGet$syncstate();
    public void realmSet$syncstate(int value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$paramsJson();
    public void realmSet$paramsJson(String value);
    public String realmGet$resultJson();
    public void realmSet$resultJson(String value);
    public long realmGet$timeout();
    public void realmSet$timeout(long value);
}
