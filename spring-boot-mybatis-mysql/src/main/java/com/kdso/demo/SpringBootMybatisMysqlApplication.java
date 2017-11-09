package com.kdso.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kdso.demo.dao")
public class SpringBootMybatisMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisMysqlApplication.class, args);
	}
}
