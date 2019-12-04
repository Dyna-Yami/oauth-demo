package com.example.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order")
public interface OrderService {

  @PostMapping("/demo/sample")
  String getSampleString(@RequestParam("name") String name);
}
