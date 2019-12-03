package com.example.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

  @PreAuthorize("hasAuthority('order')")
  @PostMapping("/sample")
  public String getSampleString(@RequestParam("name") String name) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    log.info("Principal = {}", authentication.getPrincipal());
    return "Hello " + name;
  }
}
