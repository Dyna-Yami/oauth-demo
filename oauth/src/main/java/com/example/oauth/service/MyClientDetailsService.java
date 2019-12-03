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
    BaseClientDetails client = new BaseClientDetails(clientId,
        null,
        "server",
        null,
        null,
        "http://localhost:9903"
    );
    Set<String> scopes = new HashSet<>();
    scopes.add("server");
    client.setAutoApproveScopes(scopes);
    client.setClientSecret("secret");
    return client;
  }
}
