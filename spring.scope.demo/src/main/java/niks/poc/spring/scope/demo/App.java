package niks.poc.spring.scope.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import niks.poc.spring.propagation.demo.EmployeDAO;
import niks.poc.spring.scope.demo.beans.Person;
import niks.poc.spring.scope.demo.entities.Address;
import niks.poc.spring.scope.demo.entities.UserDetail;

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
            
            EmployeDAO emp = ctx.getBean("employeDAO", EmployeDAO.class);
	        
	        UserDetail userDetail = emp.getUserDetail(1);
	        
	        System.out.println(userDetail);
	        
	        UserDetail u = new UserDetail(11, "nikhil", "wank", "email", "dob");
	        u.setAddress(new Address(11, "Amravati"));
	        emp.insertUserDetail(u, new Address(1, "Amravati"));
	        
	        userDetail = emp.findUserDetailById(11);
	        
	        System.out.println(userDetail.getAddress());
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
