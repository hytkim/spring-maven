package com.yedam.app.common;

public class TVExample {

	public static void main(String[] args) {
		// TV 인터페이스타입 참조변수 tv 를 선언하고 new 연산자를 사용하여 구현객체 샘숭TV를 할당
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		System.out.println();
		
		// 샘숭TV를 할당 받은 tv 타입으로 캐스팅가능한 구현객체 LGTV 로 tv 객체를 생성하여 주소값을 변수에 새롭게 할당하여 교체 가능 - 다형성  
		tv = new LGTV();
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
	}
	
}
