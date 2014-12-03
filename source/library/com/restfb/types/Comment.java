/*
 * Copyright (c) 2010-2013 Mark Allen.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.restfb.types;

import static com.restfb.util.DateUtils.toDateFromLongFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.restfb.Facebook;

/**
 * Represents the <a href="http://developers.facebook.com/docs/reference/api/event">Comment Graph API type</a>.
 * 
 * @author <a href="http://restfb.com">Mark Allen</a>
 * @since 1.5
 */
public class Comment extends FacebookType {
  @Facebook
  private CategorizedFacebookType from;

  @Facebook
  private String message;

  @Facebook("created_time")
  private String createdTime;

  @Facebook
  private Long likes;

  @Facebook("like_count")
  private Long likeCount;

  @Facebook("can_remove")
  private Boolean canRemove;

  @Facebook("user_likes")
  private Boolean userLikes;

  @Facebook
  private Comment parent;

  @Facebook("can_comment")
  private Boolean canComment;

  @Facebook("attachment")
  private StoryAttachment attachment;

  private static final long serialVersionUID = 2L;

  /**
   * User who posted the comment.
   * 
   * @return User who posted the comment.
   */
  public CategorizedFacebookType getFrom() {
    return from;
  }

  /**
   * Text contents of the comment.
   * 
   * @return Text contents of the comment.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Date on which the comment was created.
   * 
   * @return Date on which the comment was created.
   */
  public Date getCreatedTime() {
    return toDateFromLongFormat(createdTime);
  }

  /**
   * The number of likes on this comment.
   * 
   * @return The number of likes on this comment.
   * @deprecated As of September 5, 2012, Facebook is changing over to {@code like_count}, so this method will be
   *             replaced by {@link #likeCount}.
   */
  @Deprecated
  public Long getLikes() {
    return likes;
  }

  /**
   * The number of likes on this comment.
   * 
   * @return The number of likes on this comment.
   * @since 1.6.10
   */
  public Long getLikeCount() {
    return likeCount;
  }

  /**
   * This field is returned only if the authenticated user can remove this comment.
   * 
   * @return This field is returned only if the authenticated user can remove this comment.
   * @since 1.6.10
   */
  public Boolean getCanRemove() {
    return canRemove;
  }

  /**
   * This field is returned only if the authenticated user likes this comment
   * 
   * @return This field is returned only if the authenticated user likes this comment.
   * @since 1.6.10
   */
  public Boolean getUserLikes() {
    return userLikes;
  }

  /**
   * @return The comment this replies to
   */
  public Comment getParent() {
    return parent;
  }

  public Boolean getCanComment() {
    return canComment;
  }

  public StoryAttachment getAttachment() {
    return attachment;
  }

  public static class StoryAttachment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Facebook("description")
    private String description;

    @Facebook("description_tags")
    private List<String> description_tags;

    @Facebook("media")
    private StoryAttachmentMedia media;

    @Facebook("target")
    private StoryAttachmentTarget target;

    @Facebook("title")
    private String title;

    @Facebook("type")
    private String type;

    @Facebook("url")
    private String url;

    public String getDescription() {
      return description;
    }

    public List<String> getDescriptionTags() {
      return description_tags;
    }

    public StoryAttachmentMedia getMedia() {
      return media;
    }

    public StoryAttachmentTarget getTarget() {
      return target;
    }

    public String getTitle() {
      return title;
    }

    public String getType() {
      return type;
    }

    public String getUrl() {
      return url;
    }

    public static class StoryAttachmentMedia implements Serializable{
      private static final long serialVersionUID = 1L;

      @Facebook("image")
      private ImageSource image;

      public ImageSource getImage() {
        return image;
      }

      public static class ImageSource implements Serializable {
        private static final long serialVersionUID = 1L;

        @Facebook("height")
        private int height;

        @Facebook("src")
        private String src;

        @Facebook("width")
        private int width;

        public int getHeight() {
          return height;
        }

        public String getSrc() {
          return src;
        }

        public int getWidth() {
          return width;
        }
      }
    }

    public static class StoryAttachmentTarget implements Serializable {
      private static final long serialVersionUID = 1L;

      @Facebook("id")
      private String id;

      @Facebook("url")
      private String url;

      public String getId() {
        return id;
      }

      public String getUrl() {
        return url;
      }
    }
  }
}
