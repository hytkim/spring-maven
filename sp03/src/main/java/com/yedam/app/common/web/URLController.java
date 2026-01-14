package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Web과 관련된 Bean 등록
public class URLController {
//	@RequestMapping(path="get", method=RequestMethod.GET)
	
	@GetMapping("keyword")
	@ResponseBody // AJAX
	public String getMapping(String keyword) {
		return "Get Method : keyword " + keyword;
	}
	
	@RequestMapping(path="keyword", method=RequestMethod.POST)
	@ResponseBody
	public String postMapping(String keyword) {
		return "Post Method : keyword " + keyword;
	}
}
