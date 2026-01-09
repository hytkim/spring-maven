package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVExample {
	public static void main(String[] args) {
		System.out.println("Spring XML 방식");
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:xmlApplicationContext.xml"); // 가장 일반적으로 Xml파일을 읽어들일때 씀
		// 1) 클래스나 인터페이스 정보를 기반으로 Bean 요청
//		TV tv = ctx.getBean(TV.class); // class for name (문자열기반으로 외부서 들고온 라이브러리를 끌어 오는 식)과 같은방식, 
//		tv.powerOn();
//		tv.volumeUp();
//		tv.powerOff();
		
		// 2) Bean의 이름(id 속성값)을 기반으로 Bean 요청
		TV tv = (TV) ctx.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
	}
}
