package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	public abstract List<DeptVO> selectDeptAll();
	public abstract DeptVO selectDept(DeptVO deptVO);
	
	public abstract int insertDept(DeptVO deptVO);
	public abstract int updateDept(DeptVO deptVO);
	public abstract int deleteDept(int deptId);
	
}
