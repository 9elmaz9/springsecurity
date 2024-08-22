package com.example.springsecurity.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Конфигурация DispatcherServlet

public class WebAppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //todo auto -generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
       //Class[] configFiles={MyAppConfig.class};
       //return configFiles;
        return new Class[]{MyAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // String[] mappings = {"/"};
        //return mappings;
        return new String[]{"/"};
    }
}
