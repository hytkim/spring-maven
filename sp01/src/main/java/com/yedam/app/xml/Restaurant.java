package com.yedam.app.xml;

public class Restaurant {
	// Field
	private Chef chef;
	
	// Constructor
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	public Restaurant() {
		
	}
	// Method
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void run() {
		chef.cooking();
	}
}
