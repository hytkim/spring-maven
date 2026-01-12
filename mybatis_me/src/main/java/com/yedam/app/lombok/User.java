package com.yedam.app.lombok;

import java.util.Date;

import lombok.Data;

@Data
// Getter/Setter/ToString/EqualsAndHashCode 그리고 FinalFeild 유무에따라 NoArgC 혹은 ReqArgC 를 사용한다.
public class User {
	// Field
	private String id;
	private String name;
	private Date birthday;
	// Constructor
	// Method
}
