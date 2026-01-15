package com.yedam.app.emp.mapper;
//      com.yedam.app.**.mapper

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 조건없는 전체조회
	public List<EmpVO> selectEmpAll();
	// 결과가 하나인 단건조회
	public EmpVO selectEmp(EmpVO empVO);
	// 등록
	public int insertEmp(EmpVO empVO);
	// 수정
	public int updateEmp(@Param("eid") int employeeId,
						@Param("emp") EmpVO empVO);
	// 삭제
	public int deleteEmp(int employeeId);
}
