package com.example.mnm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.mnm.interceptor.AuthCheckInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthCheckInterceptor authCheckInterceptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor)
				.addPathPatterns("/edit/**")
				.excludePathPatterns("/edit/help/**");
	}

}
