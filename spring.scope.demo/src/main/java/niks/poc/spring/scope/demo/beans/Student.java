package niks.poc.spring.scope.demo.beans;

import niks.poc.spring.scope.demo.aspect.Logged;
import niks.poc.spring.scope.demo.aspect.LoggingType;

public class Student {
	
	String name;
	String address;
	
	

	@Logged(type = LoggingType.Method)
	public String getName() {
		System.out.println("@@@@@@@@inside getName");
		return name;
	}
	
	@Logged(type = LoggingType.Method)
	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}
	
	public Student() {
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
