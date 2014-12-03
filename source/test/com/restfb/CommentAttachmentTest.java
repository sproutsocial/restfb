package com.restfb;

import com.restfb.types.Comment;
import com.restfb.types.Post;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommentAttachmentTest extends AbstractJsonMapperTests {

    @Test
    public void testCommentAttachmentPresentWhenFetchingPosts() throws Exception {
        final FacebookClient client = getTestClient(jsonFromClasspath("feed/feed-of-posts-with-comments-with-attachments"));

        final Connection<Post> postConnection = client.fetchConnection("1000/feed", Post.class);
        final List<Post> posts = postConnection.getData();
        List<Comment> comments = posts.get(0).getComments().getData();

        Comment share = comments.get(0);
        assertEquals("Buy and sell electronics, cars, fashion apparel, collectibles, sporting goods, digital cameras, baby items, coupons, and everything else on eBay, the world's online marketplace", share.getAttachment().getDescription());
        assertEquals("share", share.getAttachment().getType());
        assertEquals("https://fbexternal-a.akamaihd.net/safe_image.php?d=AQClRO9t1aWcNreU&w=720&h=720&url=http%3A%2F%2Frtm.ebaystatic.com%2F0%2FRTMS%2FImage%2FGR68160-10_Dec02_HALO_656x402_ipad.jpg&cfs=1", share.getAttachment().getMedia().getImage().getSrc());
        assertEquals(402, share.getAttachment().getMedia().getImage().getHeight());

        Comment video_share_youtube = comments.get(1);
        assertEquals("Jeśli chcesz zacząć, to od tego: http://bit.ly/wowBattlechest Warlords of Draenor: http://bit.ly/rockDraenor Obecna seria: http://bit.ly/OpowiesciWoW Stare c...", video_share_youtube.getAttachment().getDescription());
        assertEquals("video_share_youtube", video_share_youtube.getAttachment().getType());
        assertEquals("https://fbexternal-a.akamaihd.net/safe_image.php?d=AQAGo8-5i1mHQ3t_&w=720&h=720&url=http%3A%2F%2Fi.ytimg.com%2Fvi%2FjmDLFk8qOBk%2Fmaxresdefault.jpg&cfs=1", video_share_youtube.getAttachment().getMedia().getImage().getSrc());
        assertEquals(720, video_share_youtube.getAttachment().getMedia().getImage().getHeight());

        Comment photo = comments.get(2);
        assertEquals(null, photo.getAttachment().getDescription());
        assertEquals("photo", photo.getAttachment().getType());
        assertEquals("https://fbcdn-sphotos-b-a.akamaihd.net/hphotos-ak-xfp1/v/t1.0-9/10419546_10104391099957300_5446995118162514521_n.jpg?oh=4ddf005b2d983247d9cedeabcfc0ceed&oe=55048A4D&__gda__=1426952232_c03cc429c8dad962f50025ae061d275e", photo.getAttachment().getMedia().getImage().getSrc());
        assertEquals(633, photo.getAttachment().getMedia().getImage().getHeight());
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
