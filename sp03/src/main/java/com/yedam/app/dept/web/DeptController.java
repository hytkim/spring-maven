package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.dept.service.impl.DeptServiceImpl;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // @Autowired public DeptController(DeptService deptservice) { this.deptService = deptservice;	}
public class DeptController {

	private final DeptService deptService;

	// 전체 조회
	@GetMapping("deptList")
	public String deptList(Model model) { 
		List<DeptVO> list = deptService.findAll(); 
		model.addAttribute("depts", list); 
		return "dept/list"; 
	}
	// 단건 조회 
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findByDepartmentId(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}
	
	// 등록 - 페이지호출
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	// 등록 - 기능 처리
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.addDeptInfo(deptVO);
		return "redirect:deptInfo?departmentId=" + did;
	}
	
	// 수정 - 페이지호출 - 단건조회 재활용
	@GetMapping("deptUpdate")
	public String deptUpdate(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findByDepartmentId(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/update";
	}
	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdateProcess(@RequestBody DeptVO deptVO){
		return deptService.modifyDeptInfo(deptVO);
	}
	
	@GetMapping("deptDelete")
	public String deptDelete(Integer deptId){
		deptService.removeDeptInfo(deptId);
		return "redirect:deptList";
	}
	
}
