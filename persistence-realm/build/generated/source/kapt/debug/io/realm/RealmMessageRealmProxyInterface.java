package io.realm;


public interface RealmMessageRealmProxyInterface {
    public String realmGet$_id();
    public void realmSet$_id(String value);
    public String realmGet$t();
    public void realmSet$t(String value);
    public String realmGet$rid();
    public void realmSet$rid(String value);
    public int realmGet$syncstate();
    public void realmSet$syncstate(int value);
    public long realmGet$ts();
    public void realmSet$ts(long value);
    public String realmGet$msg();
    public void realmSet$msg(String value);
    public chat.rocket.persistence.realm.models.ddp.RealmUser realmGet$u();
    public void realmSet$u(chat.rocket.persistence.realm.models.ddp.RealmUser value);
    public boolean realmGet$groupable();
    public void realmSet$groupable(boolean value);
    public String realmGet$alias();
    public void realmSet$alias(String value);
    public String realmGet$avatar();
    public void realmSet$avatar(String value);
    public String realmGet$attachments();
    public void realmSet$attachments(String value);
    public String realmGet$urls();
    public void realmSet$urls(String value);
    public long realmGet$editedAt();
    public void realmSet$editedAt(long value);
}
