package niks.poc.spring.scope.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import niks.poc.spring.propagation.demo.EmployeDAO;
import niks.poc.spring.propagation.demo.EmployeService;
import niks.poc.spring.scope.demo.beans.Person;
import niks.poc.spring.scope.demo.beans.Student;
import niks.poc.spring.scope.demo.beans.jsr250.JavaSpeciReqAnnotationTest;
import niks.poc.spring.scope.demo.config.AppConfig;
import niks.poc.spring.scope.demo.entities.UserDetail;

public class AppAnnotationConfig {
	
	public static void main(String[] args) throws Exception {
		//AnnotationConfigApplicationContext ctx;
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);){
			//AbstractApplicationContext ctx;
			System.out.println("app name:" + ctx.getApplicationName());
			
			
			//AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext(AppConfig.class);
			//ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("");
			//FileSystemXmlApplicationContext ctx1 = new FileSystemXmlApplicationContext("spring-demo.xml");
			//GenericGroovyApplicationContext
			ctx.registerShutdownHook(); 
			//require to registershutdonhook if application gracefully shutdown
			//it work in web application context because it ApplicationContext already had this 
			// implementations in place - nikhilW
					
			Person b1 = (Person) ctx.getBean("person");
	        
	        Person b2 = (Person) ctx.getBean("person");
	        
	        System.out.println("b1:" + b1.hashCode());
	        System.out.println("b2:" + b2.hashCode());
	        
	        JavaSpeciReqAnnotationTest jsr =  ctx.getBean("javaSpeciReqAnnotationTest", JavaSpeciReqAnnotationTest.class);
	        
	        Student student = ctx.getBean("student", Student.class);
	        
	        System.out.println("*******student name:" + student.getName());
	        
	        //System.out.println("&&&&&&&&" + ctx.getBean("&person"));
	        
	        //EmployeDAO emp = ctx.getBean("employeDAO", EmployeDAO.class);
	        
	        //UserDetail userDetail = emp.getUserDetail(1);
	        //System.out.println(userDetail);
	        
			/*
			 * EmployeService es = ctx.getBean("employeService", EmployeService.class);
			 * 
			 * //System.out.println("addemp1:" + es.insertEmployeeTest1());
			 * //System.out.println("addemp2:" + es.insertEmployeeTest2(true));
			 * 
			 * 
			 * try { es.insertEmployeeTest1(); } catch (Exception e) { e.printStackTrace();
			 * }
			 * 
			 * // System.out.println("allemps:" + es.getAllEmp());
			 * 
			 * es.getAllEmp().stream() .sorted() .forEach( o -> System.out.println("Record:"
			 * + o));
			 */
	        
	        //Runtime.getRuntime().addShutdownHook(hook);
	        
	        ctx.close();
	                
	        //ctx.refresh();
	        
	        //ctx.close();
	        
		}
	}

}
