package com.example.user.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Slf4j
public class TokenFeignClientInterceptor implements RequestInterceptor {

  private static final String AUTHORIZATION = "Authorization";
  private static final String BEARER = "bearer";
  private static final String ACCESS_TOKEN = "access_token";

  @Override
  public void apply(RequestTemplate requestTemplate) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
      OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
      log.info("token = {}", details.getTokenValue());
//      requestTemplate.header(AUTHORIZATION, "%s %s", BEARER, details.getTokenValue());
      requestTemplate.query(ACCESS_TOKEN, details.getTokenValue());
    }
  }
}
