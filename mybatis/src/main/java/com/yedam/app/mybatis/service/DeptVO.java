package com.yedam.app.mybatis.service;

import lombok.Data;

@Data
public class DeptVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
