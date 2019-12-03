package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


  @GetMapping("/")
  @ResponseBody
  public String index() {
    return "Hello World";
  }
}
