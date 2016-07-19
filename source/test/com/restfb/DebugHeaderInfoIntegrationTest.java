package com.restfb;

import junit.framework.TestCase;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by allareri on 7/19/16.
 */

/**
 * This is an integration test to test extracting the HTTP response headers from a facebook request.
 *
 * It is currently commented out because I could not get it to use JUnit Assume assumptions properly and conditionally skip this test if the information
 * needed is not provided.
 *
 * To run this test, rename the integration-test.sample.properties file to integration-test.properties and fill in the necessary information. Then uncomment the
 * code below and run the test case.
 */
public class DebugHeaderInfoIntegrationTest extends TestCase {
    /*
    private String accessToken;

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
    */

}
