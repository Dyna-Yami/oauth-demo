package com.example.user.service;

import com.example.user.interceptor.TokenFeignClientInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order", configuration = {TokenFeignClientInterceptor.class})
public interface OrderService {

  @PostMapping("/demo/sample")
  String getSampleString(@RequestParam("name") String name);
}
