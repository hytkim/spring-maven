package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.mybatis.common.MybatisSqlSessionFactory;
import com.yedam.app.mybatis.service.DeptVO;

public class DeptMapperImpl implements DeptMapper {
	SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<DeptVO> selectAll() {
		try (SqlSession session = factory.openSession()) {
			List<DeptVO> list = session.selectList("com.yedam.app.mybatis.mapper.DeptMapper.selectAll");
			return list;
		}
	}

	@Override
	public DeptVO selectInfo(DeptVO deptVO) {
		try (SqlSession session = factory.openSession()) {
			DeptVO findDeptVO = session.selectOne("com.yedam.app.mybatis.mapper.DeptMapper.selectInfo", deptVO);
			return findDeptVO;
		}
	}

	@Override
	public int insertInfo(DeptVO deptVO) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.insert("com.yedam.app.mybatis.mapper.DeptMapper.insertInfo", deptVO);
			return result;
		}
	}

	@Override
	public int updateInfo(DeptVO deptVO) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.update("com.yedam.app.mybatis.mapper.DeptMapper.updateInfo", deptVO);
			return result;
		}
	}

	@Override
	public int deleteInfo(int deptId) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.delete("com.yedam.app.mybatis.mapper.DeptMapper.deleteInfo", deptId);
			return result;
		}
	}

}
