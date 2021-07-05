package niks.poc.spring.scope.demo.beans;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

//on condition bean instance creation will be decided -nikhilw
public class TestBeanCondition implements Condition{

	@Override
	public boolean matches(ConditionContext ctx, AnnotatedTypeMetadata arg1) {
		
		boolean r = ctx.getEnvironment().containsProperty("test");
		
		if(r) {
			System.out.println(ctx.getEnvironment().getProperty("test"));
		}
		
		return r;
	}

}
