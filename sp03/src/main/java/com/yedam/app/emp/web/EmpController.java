package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.impl.EmpServiceImpl;

@Controller // Front-Controller인 DispacherServlet(은 Controller 어노테이션만 인식함)과 관련있음
			// 생성자가 하나면 자동으로 DI의 의존성주입이 일어난다
public class EmpController {

	private final EmpService empService; // = new EmpServiceImpl();
	
	@Autowired
	public EmpController(EmpService empService, EmpServiceImpl empServiceImpl) {
		this.empService = empService;
	}

	// GET  : 빈 페이지, 조회 - 단순 조회는 권한 없어도 됨
	// POST : 데이터 조작(등록, 수정, 삭제) - 그나마 GET보다는 Data를 숨겨서 보내기때문에 낫다, 보안 안되는건 똑같음

	// 전체조회
	@GetMapping("empList")// Model = Request + Response
	public String empList(Model model) {
		// 1) 제공할 서비스 수행
		List<EmpVO> list = empService.findAll();
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("emps", list);
		// 3) 데이터를 출력할 페이지 선택
		return "emp/list"; // 페이지이름은 '/'로 시작하면 안됨.
		// prefix => classpath:/templates/    | 프리픽스가 / 로 끝나서 /로시작하면 틀어짐
		// suffix => .html 
	}
	
	
	// 단건조회
	@GetMapping("empInfo") // Get QueryString => 커맨드 객체 || @RequestParam
	// 서비스가 요청하는게 객체니까
	public String empInfo(EmpVO empVO, Model model) {
		// 1) 제공할 서비스 수행
		EmpVO findVO = empService.findByEmployeeId(empVO);
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("emp", findVO);
		// 3) 데이터를 출력할 페이지 선택
		return "emp/info";
		// prefix => classpath:/templates/    | 프리픽스가 / 로 끝나서 /로시작하면 틀어짐
		// suffix => .html 
	}
	// 등록 - 페이지
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	// 등록 - 처리
	@PostMapping("empInsert") // <form /> => QueryString
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);
		return "redirect:empInfo?employeeId=" + eid;
	}
	// 수정 - 페이지 -> 단건조회
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	// 수정 - 처리   -> 등록 처리
	@PostMapping("empUpdate")
	@ResponseBody // AJAX용 Controller - 순수하게 데이터만 반환
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO){
		return empService.modifyEmpInfo(empVO);
	}
	// 삭제 - 단건 Get, 다중건 Post
	@GetMapping("empDelete") // 단건삭제는 RequestParam 잘 안 쓴다. 
	public String empDelete(Integer empId) { // empDelete?empId=1000
		empService.removeEmpInfo(empId);
		return "redirect:empList";
		
	}
}
