package com.yedam.app.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Java base Configuration file 선언 : 클래스의 형식이지만 일반적인 클래스가아니다.
public class JavaConfig {
	@Bean // Spring 이 관리할 Bean 등록 : 개발자가 호출 안 해도 알아서 실행함
	public Chef chef() {
		return new Chef();
	}
	
	@Bean
	public Restaurant restaurant(Chef chef) {
		Restaurant res = new Restaurant(chef);
		return res;
	}
	
}
