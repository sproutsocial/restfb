package com.restfb;

/**
 * Created by allareri on 7/19/16.
 */
public class DebugHeaderInfo {
    /**
     * x-FB-Debug
     */
    private final String debug;

    /**
     * x-fb-rev
     */
    private final String rev;

    /**
     * x-fb-trace-id
     */
    private final String traceId;

    /**
     * facebook-api-version
     */
    private final String usedVersion;

    /**
     * x-app-usage
     */
    private final String appUsage;

    /**
     * x-page-usage
     */
    private final String pageUsage;

    public DebugHeaderInfo(String debug, String rev, String traceId, String usedVersion, String appUsage, String pageUsage) {
        this.debug = debug;
        this.rev = rev;
        this.traceId = traceId;
        this.usedVersion = usedVersion;
        this.appUsage = appUsage;
        this.pageUsage = pageUsage;
    }

    public String getDebug() {
        return debug;
    }

    public String getRev() {
        return rev;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getUsedVersion() {
        return usedVersion;
    }

    public String getAppUsage() {
        return appUsage;
    }

    public String getPageUsage() {
        return pageUsage;
    }

}
