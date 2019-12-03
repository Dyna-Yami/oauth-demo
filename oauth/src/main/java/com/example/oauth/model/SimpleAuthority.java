package com.example.oauth.model;

import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;

public class SimpleAuthority implements GrantedAuthority {

  private String authority;

  public SimpleAuthority(String authority) {
    this.authority = authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return authority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleAuthority that = (SimpleAuthority) o;
    return Objects.equals(authority, that.authority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authority);
  }
}
