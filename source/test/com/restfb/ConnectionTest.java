package com.restfb;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

import com.restfb.types.Comment;

public class ConnectionTest extends AbstractJsonMapperTests {

  @Test
  public void summaryField() {
    FacebookClient facebookClient = new DefaultFacebookClient();
    String jsonString = jsonFromClasspath("connection-with-summary");
    Connection<Comment> connection = new Connection<Comment>(facebookClient, jsonString, Comment.class);
    assertNotNull(connection.getSummary());
    assertTrue(connection.getSummary().getTotalCount() == 3);
  }

}
