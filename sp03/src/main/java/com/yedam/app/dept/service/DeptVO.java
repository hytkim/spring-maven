package com.yedam.app.dept.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeptVO {
	private Integer departmentId;  // PK, not  null
	private String  departmentName;//     not  null
	private Integer managerId;     // FK, null able
	private Integer locationId;    // FK, null able
}
