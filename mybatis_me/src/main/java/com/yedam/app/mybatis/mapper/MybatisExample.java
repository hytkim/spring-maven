package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.EmpVO;

public class MybatisExample {
	private static EmpMapper empMap = new EmpMapperImpl();
	public static void main(String[] args) {
		selectAll();

	}
	public static void selectAll() {
		List<EmpVO> list = empMap.selectAll();
		for (EmpVO empVO : list) {
			System.out.println(empVO);
		}
	}
}
