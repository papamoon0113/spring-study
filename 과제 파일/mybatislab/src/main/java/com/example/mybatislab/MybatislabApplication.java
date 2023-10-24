package com.example.mybatislab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.mybatislab.dao")
public class MybatislabApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatislabApplication.class, args);
	}

}
