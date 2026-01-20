package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;


@RestController // @controller + @responseBody
@RequiredArgsConstructor
public class EmpRestController {
	// select all : GET    emps
	// select one : GET    emps/{eId}
	// insert     : POST   emps       +JSON
	// update     : PUT    emps/{eId} +JSON
	// delete     : DELETE emps/{eId}
	private final EmpService empService;

	// select all : GET emps
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.findAll();
	}
	// select one : GET    emps/{eId}
	@GetMapping("emps/{eid}")
	public EmpVO empInfo(@PathVariable Integer eid){
		EmpVO emp = EmpVO.builder()
						 .employeeId(eid)
						 .build();
		return empService.findByEmployeeId(emp);
	}
	// insert     : POST   emps       +JSON
	@PostMapping("emps") //   RequestBody = JSON
	public Integer empInsert(@RequestBody EmpVO empVO) {
		return empService.addEmpInfo(empVO);
	}
	
	// update     : PUT    emps/{eId} +JSON
	@PutMapping("emps/{eid}")
	public Map<String, Object> empUpdate(
							@PathVariable(name="eid") Integer employeeId,
							@RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		return empService.modifyEmpInfo(empVO);
	}
	// delete     : DELETE emps/{eId}
	@DeleteMapping("emps/{eid}")
	public Map<String, Object> empDelete(@PathVariable(name="eid") Integer eid){
		return empService.removeEmpInfo(eid);
	}
}