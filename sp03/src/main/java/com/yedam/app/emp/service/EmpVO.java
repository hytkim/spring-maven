package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId;   // PK
	private String firstName;
	private String lastName;      // Not Null
	private String email;         // Not Null, Uk
	private String phoneNumber;
	// java.util.Date : yy/MM/dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;        // Not Null 
	private String jobId;         // Not Null, FK
	private double salary;
	private double commissionPct;
	private String managerId;     // FK
	private String departmentId;  // FK
}
