package com.example.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "oauth")
public interface AuthService {

  @GetMapping("/user/me")
  String me();
}
