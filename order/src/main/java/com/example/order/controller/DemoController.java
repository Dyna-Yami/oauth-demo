package com.example.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

  @PreAuthorize("hasAuthority('order')")
  @PostMapping("/sample")
  public String getSampleString(@RequestParam("name") String name) {
    return "Hello " + name;
  }
}
