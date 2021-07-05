package niks.poc.spring.propagation.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import niks.poc.spring.scope.demo.entities.UserDetail;

@Service
public class EmployeService {
	
	@Autowired
	EmployeDAO employeDAO;
	
	@Transactional(transactionManager = "txManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int insertBoth(boolean t) throws Exception {
		System.out.println("inside insertBoth");
		
		insertEmployeeTest1();
		
		try {
			insertEmployeeTest2(t);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return 1000;
		
		
	}
	
	@Transactional(transactionManager = "txManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int insertEmployeeTest1()  {
		System.out.println("inside insertEmployeeTest1");
		
		UserDetail userDetail = new UserDetail(100, "Rahul", "Dravid", "rahul@gmail.com", "2021-10-10");
		
		int i = employeDAO.addUserDetail1(userDetail);
		
		System.out.println("emp1:" + i);
		
		try {
			i = insertEmployeeTest2(true);
			System.out.println("emp2:" + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
		
	}
	
	@Transactional(transactionManager = "txManager", propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
	public int insertEmployeeTest2(boolean t) {
		System.out.println("inside insertEmployeeTest2");
		
		UserDetail userDetail = new UserDetail(200, "Mahendrasingh", "Dhoni", "msd@gmail.com", "1999-10-10");
		
		int addUserDetail = employeDAO.addUserDetail2(userDetail, t);
		
		return addUserDetail;
		
	}
	
	public List<UserDetail> getAllEmp() {
		return employeDAO.getAllUserDetail();
	}

}
