package com.example.user.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class TokenFeignClientInterceptor implements RequestInterceptor {

  private static final String AUTHORIZATION = "Authorization";

  @Override
  public void apply(RequestTemplate requestTemplate) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
      OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
      requestTemplate.header(AUTHORIZATION, String.format("%s %s", details.getTokenType(), details.getTokenValue()));
    }
  }
}
