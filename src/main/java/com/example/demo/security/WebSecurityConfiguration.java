package com.example.demo.security;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(preAuthenticatedAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class);

        http.csrf().disable();
        http.requestCache().disable();
    }

    public MyAuthenticationFilter preAuthenticatedAuthenticationFilter() {
        MyAuthenticationFilter authenticationFilter = new MyAuthenticationFilter();
        return authenticationFilter;
    }
}

