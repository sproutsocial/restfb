package com.restfb;

import com.restfb.types.Comment;
import com.restfb.types.Post;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CanCommentTest extends AbstractJsonMapperTests {

    @Test
    public void testCanCommentPresentWhenFetchingPosts() throws Exception {
        final FacebookClient client = getTestClient(jsonFromClasspath("feed/posts-with-comment-having-can-comment-field"));
        final Connection<Post> postConnection = client.fetchConnection("1000/feed", Post.class);
        final List<Post> posts = postConnection.getData();
        List<Comment> comments = posts.get(1).getComments().getData();

        assertTrue(comments.get(0).getCanComment());
    }

    private static FacebookClient getTestClient(final String jsonResponse) {
        return new DefaultFacebookClient("faketoken", new DefaultWebRequestor() {
            @Override
            public Response executeGet(String url) throws IOException {
                return new Response(200, jsonResponse);
            }
        }, new DefaultJsonMapper());
    }
}
