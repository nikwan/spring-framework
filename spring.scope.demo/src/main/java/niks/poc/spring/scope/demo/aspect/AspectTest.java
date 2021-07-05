package niks.poc.spring.scope.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectTest {
	
	@Before("public void niks.poc.spring.scope.demo.beans.Student.getName()")
	public void studentAware() {
		System.out.println("########################before student get name##############");
	}

}
