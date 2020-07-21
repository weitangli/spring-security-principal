package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Secured("ROLE_ADMIN")
    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal String principal) {
        String authenticatedPrincipal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello " + principal + ", and authenticated principal is " + authenticatedPrincipal;
    }
}
