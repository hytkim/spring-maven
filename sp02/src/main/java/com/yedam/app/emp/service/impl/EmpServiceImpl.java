package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service // 비즈니스 로직(실제 수행되는 기능)에 해당하는 객체를 의미
         // Spiring 이 AOP를 적용하는 객체를 의미
public class EmpServiceImpl implements EmpService {
	
	private EmpMapper empMapper;
	
	// 이거 아니면 인스턴스 생성이 불가능하니까 컨테이너가 알잘딱깔 밀어넣는다.
	// @Autowired // 생성자가 하나일 경우 무조건 생성자 주입 이라 이 경우 생략하는게 맞음
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
//	public EmpServiceImpl () {};
	
	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectAll();
	}

}
