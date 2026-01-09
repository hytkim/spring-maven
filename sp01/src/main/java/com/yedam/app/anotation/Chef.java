package com.yedam.app.anotation;

import org.springframework.stereotype.Component;

@Component // Bean으로 등록할 클래스임을 명시
public class Chef {
	public void cooking() {
		System.out.println("어노테이션 Based Cook");
	}
}
