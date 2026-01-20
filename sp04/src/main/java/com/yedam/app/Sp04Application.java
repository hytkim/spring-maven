package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 얘가 밑에 3개꺼한번에함
//	@SpringBootConfiguration
//	@EnableAutoConfiguration
//	@ComponentScan
@MapperScan("com.yedam.app.**.mapper") // 마이바티스에쓸 메퍼 이걸로찾아야됨
public class Sp04Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp04Application.class, args);
	}

}
