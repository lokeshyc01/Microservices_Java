package com.aspect.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
Logger log = LoggerFactory.getLogger(getClass());
	
	@Before(value = "execution(* com.aspect.app.service.*.*(..))")
	public void before(JoinPoint point) {
		log.info("method executed {}",point.getSignature());
	}
	
	
	@After(value = "execution(* com.aspect.app.service.*.*(..))")
	public void after(JoinPoint point) {
		log.info("after aspect");
		log.info("method executed {}",point.getSignature());
	}
	
	
	@AfterReturning(value = "execution(* com.aspect.app.service.*.*(..))" , returning = "result")
	public void afterReturning(JoinPoint point,Object result) {
		log.info("after returning aspect");
		log.info("method executed {}",point.getSignature());
		log.info("result of method : {}",result);
	}
	
	@AfterThrowing(value = "execution(* com.aspect.app.service.*.*(..))", throwing = "exec")
	public void afterThrowing(JoinPoint point,Exception exec) {
		log.info("after returning aspect");
		log.info("method executed {}",point.getSignature());
		log.info("exception of method : {}",exec.getMessage());
	}
}
