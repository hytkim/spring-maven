package com.yedam.app.common;

public class LGTV implements TV{
	@Override
	public void powerOn() {
		System.out.println("나는 키다 엘쥐 TV");
	}

	@Override
	public void volumeUp() {
		System.out.println("나는 올린다 엘쥐 TV Volume");
	}

	@Override
	public void powerOff() {
		System.out.println("나는 끄다 엘쥐 TV");
	}

}
