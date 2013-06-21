package com.restfb.types;

import com.restfb.Facebook;

public class Paging {

  @Facebook
  private String previous;
  @Facebook
  private String next;

  public String getPrevious() {
    return previous;
  }

  public String getNext() {
    return next;
  }

}
