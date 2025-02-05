package com.demo.spring_security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello This is Vishnu";
    }

    /*
      To enable Role based access we need to add @PreAuthorize("hasRole('ROLE_USER')")
      and in controller we need to add @PreAuthorize("hasRole('ROLE_ADMIN')")
      and seurity config file we need to add .antMatchers("/admin").hasRole("ADMIN")
       and  @EnableMethodSecurity
     */

     @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String sayBye() {
        return "This is user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String sayHi() {
        return "This is admin";
    }
}
