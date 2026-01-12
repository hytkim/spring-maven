package com.yedam.app.lombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Customer {
	private final Integer no; // mybatis or 통신 할때 공백으로넘어오는값에 대해서 Integer가 처리를못해서  
	private final String name;
	private String phone;
	private String address;
	
	// 경우에따라서는 아래의 setter 를 사용 하지 않는경우도 있다.
//	public void setPhone(String phone) {this.phone = phone;};
//	public void setAddress(String address) {this.address = address;};
}
