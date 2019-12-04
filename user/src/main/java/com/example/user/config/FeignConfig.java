package com.example.user.config;

import com.example.user.interceptor.TokenFeignClientInterceptor;
import feign.RequestInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FeignConfig {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public RequestInterceptor tokenFeignClientInterceptor() {
    return new TokenFeignClientInterceptor();
  }
}
