package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data // 이새끼가있을때 AllArgsC 하면 NoArgsC 가안된다.
@NoArgsConstructor // MyBatis는 Builder 패턴을 사용하지않는다.
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
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
