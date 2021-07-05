package niks.poc.spring.scope.demo.beans;

import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Person implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware{
	
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("inside destroy of person...");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("inside init of person...");
		
	}
	
	void init() {
		System.out.println("######################init person");
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		Person b2 = ctx.getBean("person", Person.class);
        
        System.out.println("b2 Application Context Aware Bean:" + b2.hashCode());
		
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("person bean using bean name:" + name);
		
	}

}
