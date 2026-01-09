package com.yedam.app.common;

public class SamsungTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("나는 키다 샘숭TV");
	}

	@Override
	public void volumeUp() {
		System.out.println("나는 올린다 샘숭TV Volume");
	}

	@Override
	public void powerOff() {
		System.out.println("나는 끄다 샘숭TV");
	}

}
