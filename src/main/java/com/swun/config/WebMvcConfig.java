package com.swun.config;

import com.swun.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.List;

@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {
    private LoginInterceptor loginInterceptor;
//

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> list= Arrays.asList("/login","/regist");
//        registry.addInterceptor(loginInterceptor).excludePathPatterns(list);
//
//    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        /**
         * 所有请求都允许跨域，使用这种配置就不需要
         * 在interceptor中配置header了
         */
        corsRegistry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/login");
    }
}
