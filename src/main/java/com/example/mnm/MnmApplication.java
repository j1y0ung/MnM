package com.example.mnm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring 설정(Java Config)클래스이자 어플리케이션 시작 클래스(main() 포함)
@SpringBootApplication(scanBasePackages={"com.example.mnm.*"})
@MapperScan(basePackages = "com.example.mnm.dao.mybatis.mapper")
public class MnmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MnmApplication.class, args);
	}

}
