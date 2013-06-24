package com.restfb;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.restfb.types.Comment;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Post.Comments;

public class ConnectionTest extends AbstractJsonMapperTests {

  private static class MyPost extends Post {
    private MyPost() {}
  }

  @Test
  public void summaryField() {
    FacebookClient facebookClient = new DefaultFacebookClient();
    String jsonString = jsonFromClasspath("connection-with-summary");
    Connection<Comment> connection = new Connection<Comment>(facebookClient, jsonString, Comment.class);
    assertNotNull(connection.getSummary());
    assertTrue(connection.getSummary().getTotalCount() == 3);
  }

  public static void main(String[] args) throws Exception {
    FacebookClient facebookClient =
        new DefaultFacebookClient(
          "CAACZAzRXNmV8BADZBrK7wwU0dGnOdbY9z6aZCikGQWT2nWlLhaqtdUpJiW77ouYg7SUkFYdSj8ZBQ6fA97oe0BpZBSwyVRkQDvIbbHfZCq9eg7lwmcUv1HmK4pxhU3ZCBZAxbwCPxZA5z5x5ZB8k6TBEVE8gG82mX1dZBBFIb95WSlG9GfzX7e5zmax");

    Page page = facebookClient.fetchObject("8532248414", Page.class);
    System.out.format("Page: %s, %s%n", page.getId(), page.getDescription());

    MyPost post =
        facebookClient.fetchObject("8532248414_10151662413923415", MyPost.class,
          Parameter.with("fields", "comments.summary(true).filter(stream)"));
    System.out.format("Post (%s): %s, %s%n", post.getClass().getName(), post.getId(), post.getType());

    Comments comments = post.getComments();
    System.out.format("Comments: %d%n", comments.getCount());
    System.out.format("Comment.summary: %s, %s%n", comments.getSummary(), comments.getSummary().getTotalCount());
    System.out.format("Comment.paging: %s, %s%n", comments.getPaging().getPrevious(), comments.getPaging().getNext());

    Connection<Comment> connection = comments.asConnection(facebookClient, Comment.class);
    for (Iterator<List<Comment>> it = connection.iterator(); it.hasNext();) {
      for (Comment comment : it.next()) {
        System.out.format("*** Comment: %s, %s%n", comment.getId(), comment.getMessage());
      }
    }

    for (Comment comment : comments.getData()) {
      System.out.format("Comment: %s, %s%n", comment.getId(), comment.getMessage());
    }

    // Connection<Comment> connection =
    // facebookClient.fetchConnection("8532248414_10151662413923415/comments", Comment.class,
    // Parameter.with("limit", 25), Parameter.with("filter", "stream"), Parameter.with("summary", true));
    //
    // System.out.format("Summary: %s, %d%n", connection.getSummary().getOrder(),
    // connection.getSummary().getTotalCount());

    // for (Comment comment : connection.getData()) {
    // System.out.format("Comment: %s, %s%n", comment.getId(),
    // comment.getMessage());
    // }
    //
    // for (Iterator<List<Comment>> it = connection.iterator();
    // it.hasNext();) {
    // for (Comment comment : it.next()) {
    // System.out.format("*** Comment: %s, %s%n", comment.getId(),
    // comment.getMessage());
    // }
    // }

  }

}
