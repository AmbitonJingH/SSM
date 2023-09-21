package com.example.web.config;
/*
 * @author  AmbitionJingH
 * @date  2023/9/18 20:47
 * @version 1.0
 */

import com.example.web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;
//@EnableWebMvc//禁用boot的默认配置
//@Configuration //这是一个配置类,给容器中放一个WebMvcConfigurer组件，就能自定义底层
//public class MyConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //保留以前的配置
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//        //自己添加
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/a/","classpath:/static/")
//                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//    }
//}

//自定义底层
@Configuration
public class MyConfig {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//       return new WebMvcConfigurer() {
//           @Override
//           public void addResourceHandlers(ResourceHandlerRegistry registry) {
//               WebMvcConfigurer.super.addResourceHandlers(registry);
//               registry.addResourceHandler("/static/**")
//                       .addResourceLocations("classpath:/a/","classpath:/static/")
//                       .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//           }
//
//           @Override //配置一个能把对象转为yaml的messageConvert
//           public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//               converters.add(new MyYamlHttpMessageConverter());
//           }
//       };
//    }
}
