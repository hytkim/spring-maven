package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Lombok의 필수 매개변수 생성자(final field 기준으로) 자동생성 
@Controller // Router 역할을 하는 객체 
public class EmpController {
	private final EmpService empService;
	
	@GetMapping("/empList")
	public String empList(Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("emps", list);
		return "empList";
	}
}
