package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.EmpVO;

// Mapper => 실제 쿼리(SQL)문을 수행하는 객체
// 테이블 하나당 하나의 Mapper를 만든다 : 1-Table <-> 1-Mapper
// 관리 기본 기능 5개 : 전체조회 / 단건조회 / 등록 / 수정 / 삭제 만듦 : 1쿼리 = 1메서드: JDBC할때 EMP DAO와 비슷하다
public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectAll();
	// 단건조회
	public EmpVO selectInfo(EmpVO emp);
	// 등록
	public int insertInfo(EmpVO emp);
	// 수정
	public int updateInfo(EmpVO emp);
	// 삭제 
	public int deleteInfo(int empId);
}