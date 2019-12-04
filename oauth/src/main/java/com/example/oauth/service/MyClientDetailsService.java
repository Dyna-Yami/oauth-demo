package com.example.oauth.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
public class MyClientDetailsService implements ClientDetailsService {

  @Override
  public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
    if (!"client".equals(clientId)) {
      return null;
    }
    BaseClientDetails client = new BaseClientDetails("client",
        null,
        "server",
        "refresh_token,authorization_code,password",
        null,
        "http://localhost:9903/callback"
    );
    Set<String> scopes = new HashSet<>();
    scopes.add("auto");
    client.setAutoApproveScopes(scopes);
    client.setClientSecret("secret");
    client.setAccessTokenValiditySeconds(60 * 60);
    client.setRefreshTokenValiditySeconds(60 * 60 * 24);
    return client;
  }
}
