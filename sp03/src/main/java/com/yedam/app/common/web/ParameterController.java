package com.yedam.app.common.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.Sp03Application;
import com.yedam.app.common.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 스프링내부에 로그를남기는 빈 호출 - 로그를남기는 객체 = 로거
@Controller
public class ParameterController {

    private final Sp03Application sp03Application;

    ParameterController(Sp03Application sp03Application) {
        this.sp03Application = sp03Application;
    }

	// QueryString(질의문자열)
	// format : key=value&key=value&...
	// Content-type : application/x-www-form(from 태그의 값을 전달 한다는 뜻)-urlencoded(Get방식 통신이라는 뜻)
	// HttpMethod   : 전부 가능
	
	// => 1) Commend Object(커맨드 객체) : @Annotation 없음. 객체타입
	@RequestMapping("comobj") // 모든 httmlMethod 적용가능해서 RequestMapping 씀
	@ResponseBody
	public String commandObject(UserVO user) {
		log.info("path : /comobj");
		log.info("= name : "+user.getName());
		log.info("= age : "+user.getAge());
		log.info(user.toString());
		return "home";
	}
	
	// => 2) @RequestParam : @존재(default)하는 기본 데이터형(Wrapper Class - Integer, String, Char = 단일값을 처리하는 클래스) 
	@RequestMapping("reqparam")
	@ResponseBody
	public String reqparma(@RequestParam String name // @RequestParam 파라메터 앞에 어노테이션이 붙으면 필수값으로 처리
						, Integer age
						, @RequestParam(defaultValue = "No message", name = "msg") String message
	) {
		log.info("path : /reqparam");
		log.info("= name : "+ name);
		log.info("= age : "+ age);
		log.info("= message : "+ message);
		return "home";
	}
	
	// URI에 값을 포함 : PathValriable
	// Content-type : 모든 경우 가능
	// HttpMethod   : 모두 가능
	// @PathValriable : @ 반드시 사용, 기본 데이터형만 가능(단일 값)
	@RequestMapping("pathVal/{name}")
	@ResponseBody
	public String pathVariable(@PathVariable String name) {
		log.info("path : /path/{name}");
		log.info("= name : "+name);
		return "home";
	}
	
	// JSON
	// format : { " k : v" & "key: value"}
	//or [{}, {}]
//	content*tpe : application/x-www-json
	// http method : post, put
	//@RequestBody : @반드시 사용 , 객체 or 배열(list) 포함
	@RequestMapping("requestbody")
	@ResponseBody
	public Map<String, Object> requestBody(@RequestBody UserVO user){
		Map <String, Object> map = new HashMap<>();
		map.put("path", "requestbody");
		map.put("data", user);
		return map;
	}
	
}
