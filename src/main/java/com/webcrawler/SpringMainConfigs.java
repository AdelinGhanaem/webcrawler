package com.webcrawler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.webcrawler")
public class SpringMainConfigs extends WebMvcConfigurerAdapter {

}
