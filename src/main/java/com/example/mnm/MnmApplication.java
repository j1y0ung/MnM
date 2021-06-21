package com.example.mnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Spring 설정(Java Config)클래스이자 어플리케이션 시작 클래스(main() 포함)
@SpringBootApplication
public class MnmApplication extends SpringBootServletInitializer {
    @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
  return application.sources(MnmApplication.class);
  }
    public static void main(String[] args) {
		SpringApplication.run(MnmApplication.class, args);
	}

}
