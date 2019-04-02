package com.thanglv.sprnonblocking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/bootstrap/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/3.3.7/");
    registry.addResourceHandler("/resources/jquery/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.1.0/");
    registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
    registry.addResourceHandler("/resources/sockjs-client/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/sockjs-client/1.0.2/");
    registry.addResourceHandler("/resources/stomp-websocket/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/stomp-websocket/2.3.3/");
    registry.addResourceHandler("/resources/js/**").addResourceLocations("classpath:/static/js/");
    registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
  }
}
