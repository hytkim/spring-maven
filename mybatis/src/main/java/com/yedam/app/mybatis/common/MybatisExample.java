package com.yedam.app.mybatis.common;

import java.util.List;

import com.yedam.app.mybatis.mapper.DeptMapper;
import com.yedam.app.mybatis.mapper.DeptMapperImpl;
import com.yedam.app.mybatis.mapper.EmpMapper;
import com.yedam.app.mybatis.mapper.EmpMapperImpl;
import com.yedam.app.mybatis.service.DeptVO;
import com.yedam.app.mybatis.service.EmpVO;

public class MybatisExample {
	private static EmpMapper empMap = new EmpMapperImpl();
	private static DeptMapper deptMap = new DeptMapperImpl();
	
	public static void main(String[] args) {
//		selectAll();
//		selectInfo();
//		insertInfo();
//		updateInfo();
//		deleteInfo();
		
//		seletDeptAll();
//		seletDeptInfo();
//		insertDeptInfo();
		updateDeptInfo();
		//deleteDeptInfo();
		
	}
	
	public static void selectAll() {
		List<EmpVO> list = empMap.selectAll();
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
	}
	
	public static void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(100);
		
		EmpVO findVO = empMap.selectInfo(emp);
		System.out.println(findVO);
	}
	
	public static void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("honghong@hoonggle.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMap.insertInfo(empVO);
		System.out.println(result);
	}
	
	public static void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(210);
		empVO.setFirstName("Kill-dong");
		empVO.setSalary(777);
		
		int result = empMap.updateInfo(empVO);
		System.out.println(result);
	}
	
	public static void deleteInfo() {
		int result = empMap.deleteInfo(210);
		System.out.println(result);
	}
	
	// Departments Table
	public static void seletDeptAll() {
		List<DeptVO> list = deptMap.selectAll();
		for (DeptVO deptVO : list) {
			System.out.println(deptVO);
		}
	}
	
	public static void seletDeptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(600);
		
		DeptVO findDeptVO = deptMap.selectInfo(deptVO);
		System.out.println(findDeptVO);
	}
	
	public static void insertDeptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentName("gohome");
		
		int result = deptMap.insertInfo(deptVO);
		System.out.println(result);
	}
	
	public static void updateDeptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(610);
		deptVO.setManagerId(200);
		deptVO.setLocationId(1700);
		
		int result = deptMap.updateInfo(deptVO);
		System.out.println(result);
	}
	
	public static void deleteDeptInfo() {
		int result = deptMap.deleteInfo(610);
		System.out.println(result);
	}
}
