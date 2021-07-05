package niks.poc.spring.scope.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {
	
	@Before("execution(public String niks.poc.spring.scope.demo.beans.Student.getName(..))")
	public void studentAware() {
		System.out.println("########################before student get name##############");
	}

}
