package com.yedam.app.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	// Field
	private Chef chef;
	
	// Constructor
	@Autowired
	public Restaurant(Chef chef) {
		System.out.println("생성자 인젝션");
		this.chef = chef;
	}
	
	public Restaurant() {
		
	}
	// Method
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void run() {
		chef.cooking();
	}
}
