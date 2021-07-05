package niks.poc.spring.scope.demo.beans.jsr250;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import niks.poc.spring.scope.demo.beans.Person;

@Component
public class JavaSpeciReqAnnotationTest {

	@Resource(type = Person.class)
	Person person;
	
	@PostConstruct
	void init(){
		System.out.println("###person from at resource annotation###" + person);
	}
}
