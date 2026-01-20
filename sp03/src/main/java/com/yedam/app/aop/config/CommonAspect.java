package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yedam.app.emp.service.EmpVO;

@Aspect
//@Component
public class CommonAspect {
	// 포인트컷 : 조인포인트 중에서 Advice(횡단관심)이 적용될 메소드 필트
	@Pointcut("execution(* com.yedam..*Impl.*(..))")
	public void allpointcut() {}

	// Weaving : Pointcut(포인트컷) + 타이밍(@Before, @After ... ) + Advice(횡단관심 : public void beforeLog(JoinPoint jp) {} 전체 )
	@Before("allpointcut()") // allpointcut() 메서드이름 그대로갖고옴
 	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().toString();//.getName();
		EmpVO emp = (EmpVO) jp.getArgs()[0];
		System.out.println("[사전처리] beforeLog" + methodName);
		System.out.println("[사전처리] beforeLog" + emp.toString());
	}
	
	@Around("allpointcut()")
	public Object exeuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// 공통기능
		String signaterStr = joinPoint.getSignature().toShortString();
		System.out.println("=== 시작 : "+signaterStr);
		
		System.out.println("=== 핵심기능 전 실행 : "+System.currentTimeMillis());
		try {
			// 비즈니스 로직에있는 메서드를 실행
			Object obj = joinPoint.proceed();
			return obj;
		} 
//		catch (Throwable e) {	return e; || e.printstactrace(); throw e; } 여기서 예외처리하면 일괄저리니까 부른놈한테 던져야됨
		finally {
			// 공통기능
			System.out.println("=== 핵심기능 후 실행 : "+System.currentTimeMillis());
			System.out.println("=== 끝 : "+signaterStr);
		}
	}
}
