package com.webcrawler;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Order(1)
public class AppInitializer implements WebApplicationInitializer {
    private static final Class<?>[] CONFIG_CLASSES = new Class<?>[]{SpringMainConfigs.class};

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(CONFIG_CLASSES);

        servletContext.addListener(new ContextLoaderListener(appContext));
        DispatcherServlet servlet = new DispatcherServlet(appContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", servlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }


}
