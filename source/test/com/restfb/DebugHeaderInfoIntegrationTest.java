package com.restfb;

import junit.framework.TestCase;
import org.junit.Assume;
import org.junit.Before;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by allareri on 7/19/16.
 */
public class DebugHeaderInfoIntegrationTest extends TestCase {

    private String accessToken;
    private String apiVersion;

    @Before
    public void setUp() {
        InputStream propertyStream = getClass().getClassLoader().getResourceAsStream("resources/integration-test.properties");
        Assume.assumeNotNull(propertyStream);
        Properties properties = new Properties();
        try {
            properties.load(propertyStream);
            accessToken = properties.getProperty("user.accessToken");
        } catch (Throwable e) {
            Assume.assumeNoException(e);
        }

    }

    public void testDebugHeaderInfo() {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
        facebookClient.fetchObject("/me", String.class, Parameter.with("fields", "id,name"));

        WebRequestor webRequestor = facebookClient.getWebRequestor();

        DebugHeaderInfo headerInfo = webRequestor.getDebugHeaderInfo();

        assertNotNull(headerInfo);
        assertNotNull(headerInfo.getDebug());
        assertNotNull(headerInfo.getRev());
        assertNotNull(headerInfo.getTraceId());
        assertNotNull(headerInfo.getUsedVersion());

    }

}
