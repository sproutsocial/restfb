package com.restfb;

/**
 * Created by allareri on 7/19/16.
 *
 * < x-page-usage: {"call_count":1,"total_cputime":1,"total_time":1}
 < x-fb-rev: 2451911
 < x-fb-trace-id: AVlqOzyWl5H
 < Expires: Sat, 01 Jan 2000 00:00:00 GMT
 < Content-Type: application/json; charset=UTF-8
 < facebook-api-version: v2.4
 < Cache-Control: private, no-cache, no-store, must-revalidate
 < Pragma: no-cache
 < ETag: "cb44475b6f54e9aa87496d3c94a78f44a3bab3d4"
 < Access-Control-Allow-Origin: *
 < Vary: Accept-Encoding
 < X-FB-Debug: Vwawh/Pj7chDNUbWjJxVR77XSstZxzPwKL8+Xv574CAuBWIoumM8TfYHGzmow6Rg6Woorp1MM+NuBQhOeCcQpw==
 < Date: Tue, 19 Jul 2016 16:31:58 GMT
 < Connection: keep-alive
 < Content-Length: 42
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
