package com.example.oauth.service;

import com.example.oauth.model.SimpleAuthority;
import com.example.oauth.model.SimpleUser;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (!"jamin".equals(username)) {
      return null;
    }

    Set<SimpleAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleAuthority("order"));
    return new SimpleUser(username, "password1", authorities);
  }
}
