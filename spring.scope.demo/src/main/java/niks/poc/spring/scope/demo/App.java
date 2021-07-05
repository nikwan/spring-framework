package niks.poc.spring.scope.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import niks.poc.spring.scope.demo.beans.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	ApplicationContext ctx = null;
        try {
        	System.out.println( "Hello World!" );
            ctx = new ClassPathXmlApplicationContext("scope.xml");
            Person b1 = (Person) ctx.getBean("person");
            
            Person b2 = (Person) ctx.getBean("person");
            
            System.out.println("b1:" + b1.hashCode());
            System.out.println("b2:" + b2.hashCode());
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
