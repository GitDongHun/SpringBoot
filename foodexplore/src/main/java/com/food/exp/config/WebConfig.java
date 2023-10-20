package com.food.exp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.food.exp.interceptor.MyHandlerInterceptor;

@Configuration  
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	MyHandlerInterceptor interceptor;
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(interceptor)
//		        .addPathPatterns("/login","/mypage");
//	}



//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/mypage")
//		        .setViewName("main");
//		
//	}


	
	
	
}
