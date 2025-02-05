package com.db_app.spring_db_security_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    public String login() {
        return "login";
    }
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
    @GetMapping("about")
    public String about() {
        return "about";
    }
}
