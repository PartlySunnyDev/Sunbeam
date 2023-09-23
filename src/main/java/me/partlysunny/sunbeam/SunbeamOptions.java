package me.partlysunny.sunbeam;

public class SunbeamOptions {

    private boolean loadMessagesConfig = false;
    private String customDataKey = "sunbeam";

    public SunbeamOptions() {
    }

    public SunbeamOptions loadMessagesConfig(boolean loadMessagesConfig) {
        this.loadMessagesConfig = loadMessagesConfig;
        return this;
    }

    public SunbeamOptions customDataKey(String customDataKey) {
        this.customDataKey = customDataKey;
        return this;
    }

    public boolean doLoadMessagesConfig() {
        return loadMessagesConfig;
    }

    public String getCustomDataKey() {
        return customDataKey;
    }

}
