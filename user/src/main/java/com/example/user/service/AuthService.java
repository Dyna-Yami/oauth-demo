package com.example.user.service;

import com.example.user.interceptor.TokenFeignClientInterceptor;
import java.security.Principal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "oauth", configuration = {TokenFeignClientInterceptor.class})
public interface AuthService {

  @GetMapping("/user/me")
  String me();
}
