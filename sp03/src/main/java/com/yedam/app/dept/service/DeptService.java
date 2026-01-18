package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	// 전체
	public abstract List<DeptVO> findAll();
	// 단건
	public DeptVO findByDepartmentId(DeptVO deptVO);
	// 등록
	public int addDeptInfo(DeptVO deptVO);
	// 수정
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO);
	// 삭제
	public Map<String, Object> removeDeptInfo(int deptId);
}
