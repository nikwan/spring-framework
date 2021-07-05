package niks.poc.spring.scope.demo.beans;

public class Student {
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}
	
	public Student() {
		
	}

}
