package niks.poc.spring.scope.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {
	
	//@Before("execution(public String niks.poc.spring.scope.demo.beans.Student.getName(..))")
	//@Before("execution(* niks.poc.spring.scope.demo.beans.Student.getName(..))")
	@Before("execution(* *.getName(..))")
	public void studentBeforeAware() {
		System.out.println("####before student get name###");
	}
	
	@After("execution(* *.getName(..))")
	public void studentAfterAware() {
		System.out.println("###After student get name###");
	}
	
	@Before(value = "@annotation(Logged)")
	public void logged(JoinPoint joinPoint, Logged Logged) {
		System.out.println("###inside " + joinPoint.getSignature().getName() + "###" + Logged.type());
	}

}
