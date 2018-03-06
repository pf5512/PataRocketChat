package io.realm;


public interface FileUploadingRealmProxyInterface {
    public String realmGet$uplId();
    public void realmSet$uplId(String value);
    public int realmGet$syncstate();
    public void realmSet$syncstate(int value);
    public String realmGet$storageType();
    public void realmSet$storageType(String value);
    public String realmGet$uri();
    public void realmSet$uri(String value);
    public String realmGet$filename();
    public void realmSet$filename(String value);
    public long realmGet$filesize();
    public void realmSet$filesize(long value);
    public String realmGet$mimeType();
    public void realmSet$mimeType(String value);
    public String realmGet$roomId();
    public void realmSet$roomId(String value);
    public long realmGet$uploadedSize();
    public void realmSet$uploadedSize(long value);
    public String realmGet$error();
    public void realmSet$error(String value);
}
