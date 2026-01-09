package com.yedam.app.common;

public class RestaurantExample {
	public static void main(String[] args) {
		System.out.println("일반적인 방식 : DI");
		Chef chef = new Chef();
		// 생성자
		Restaurant res = new Restaurant(chef); // 이걸 담당하는 DI(디펜던시 인젝션 : 의존성 주입)
		res.run();
		
		// 세터
		Restaurant sec = new Restaurant();
		sec.setChef(chef);
		sec.run();
		
	}
}
