package com.restfb.types;

import com.restfb.Facebook;

public class Summary {

  @Facebook
  private String order;
  @Facebook("total_count")
  private Long totalCount;

  public String getOrder() {
    return order;
  }

  public Long getTotalCount() {
    return totalCount;
  }

}
