package com.example.user.controller;

import com.example.user.service.AuthService;
import com.example.user.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

  private final OrderService orderService;
  private final AuthService authService;

  public DemoController(OrderService orderService, AuthService authService) {
    this.orderService = orderService;
    this.authService = authService;
  }

  @PreAuthorize("hasAuthority('order')")
  @GetMapping("/hello")
  public String hello() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    log.info("Authentication = {}", authentication);
    log.info("Principal = {}", authentication.getPrincipal());
    log.info("Authorities = {}", authentication.getAuthorities());
    String principal = authService.me();
    log.info("Full Principal = {}", principal);
    return orderService.getSampleString("Jamin");
  }
}
