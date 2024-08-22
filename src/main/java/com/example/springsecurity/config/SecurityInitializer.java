package com.example.springsecurity.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
// Этот класс регистрирует цепочку фильтров безопасности Spring Security
public abstract class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {


  // @Override
  // public void onStartup(ServletContext servletContext) throws ServletException {
  //    // super.onStartup(servletContext); i can do this or make this class- abstract
  //     //here can add extra setting
    }
