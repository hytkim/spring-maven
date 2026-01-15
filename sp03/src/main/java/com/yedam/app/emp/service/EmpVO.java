package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId;   // PK
	private String firstName;
	private String lastName;      // Not Null
	private String email;         // Not Null, Uk
	private String phoneNumber;
	private Date hireDate;        // Not Null 
	private String jobId;         // Not Null, FK
	private double salary;
	private double commissionPct;
	private String managerId;     // FK
	private String departmentId;  // FK
}
