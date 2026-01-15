package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Service // 비즈니스 로직을 가지는 Bean, AOP를 적용
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpMapper empMapper;
	
	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO findByEmployeeId(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int addEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO); 
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = empMapper.updateEmp(empVO.getEmployeeId(), empVO);
		if (result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
		{ "result" : true,
		  "target" : 
		  {
		    "employee_id" : 100,
		    "last_name" : "King",
		    ....
		  }
		}
		*/
		
		return map;
	}

	@Override
	public Map<String, Object> removeEmpInfo(int empId) {
		Map<String, Object> map = new HashMap<>();
		// let map = {};
		int result = empMapper.deleteEmp(empId);
		if (result == 1) {
			map.put("employeeId", empId); // { "employee_id" : 100 }
		}		
		return map;
	}

}
