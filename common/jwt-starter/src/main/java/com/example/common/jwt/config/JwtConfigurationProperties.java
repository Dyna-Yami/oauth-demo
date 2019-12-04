package com.example.common.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("example.jwt")
public class JwtConfigurationProperties {

  private String publicKeyPath = "public.cert";
}
