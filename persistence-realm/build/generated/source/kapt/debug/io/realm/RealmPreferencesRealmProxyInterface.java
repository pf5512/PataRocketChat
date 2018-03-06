package io.realm;


public interface RealmPreferencesRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$newRoomNotification();
    public void realmSet$newRoomNotification(String value);
    public String realmGet$newMessageNotification();
    public void realmSet$newMessageNotification(String value);
    public boolean realmGet$useEmojis();
    public void realmSet$useEmojis(boolean value);
    public boolean realmGet$convertAsciiEmoji();
    public void realmSet$convertAsciiEmoji(boolean value);
    public boolean realmGet$saveMobileBandwidth();
    public void realmSet$saveMobileBandwidth(boolean value);
    public boolean realmGet$collapseMediaByDefault();
    public void realmSet$collapseMediaByDefault(boolean value);
    public boolean realmGet$unreadRoomsMode();
    public void realmSet$unreadRoomsMode(boolean value);
    public boolean realmGet$autoImageLoad();
    public void realmSet$autoImageLoad(boolean value);
    public String realmGet$emailNotificationMode();
    public void realmSet$emailNotificationMode(String value);
    public boolean realmGet$unreadAlert();
    public void realmSet$unreadAlert(boolean value);
    public int realmGet$desktopNotificationDuration();
    public void realmSet$desktopNotificationDuration(int value);
    public int realmGet$viewMode();
    public void realmSet$viewMode(int value);
    public boolean realmGet$hideUsernames();
    public void realmSet$hideUsernames(boolean value);
    public boolean realmGet$hideAvatars();
    public void realmSet$hideAvatars(boolean value);
    public boolean realmGet$hideFlexTab();
    public void realmSet$hideFlexTab(boolean value);
}
