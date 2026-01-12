package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.DeptVO;

public interface DeptMapper {
	public abstract List<DeptVO> selectAll();
	public abstract DeptVO selectInfo(DeptVO deptVO);
	public abstract int    insertInfo(DeptVO deptVO);
	public abstract int    updateInfo(DeptVO deptVO);
	public abstract int    deleteInfo(int deptId);
}
