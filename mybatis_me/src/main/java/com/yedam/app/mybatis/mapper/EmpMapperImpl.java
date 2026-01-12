package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.lombok.MybatisSqlSessionFactory;
import com.yedam.app.mybatis.service.EmpVO;

public class EmpMapperImpl implements EmpMapper{
	private SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<EmpVO> selectAll() {
		SqlSession session = factory.openSession(true);
		List<EmpVO> list = session.selectList("EmpMapper.selectAll", EmpVO.class);
		return list;
	}

	@Override
	public EmpVO selectInfo(EmpVO emp) {
		return null;
	}

	@Override
	public int insertInfo(EmpVO emp) {
		return 0;
	}

	@Override
	public int updateInfo(EmpVO emp) {
		return 0;
	}

	@Override
	public int deleteInfo(int empId) {
		return 0;
	}

}
