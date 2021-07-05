package niks.poc.spring.propagation.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import niks.poc.spring.scope.demo.entities.UserDetail;
import niks.poc.spring.scope.demo.entities.UserDetailRowMapper;

@Component
public class EmployeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	void getUserDetails(){
		
		
	}
	
	
	public List<UserDetail> getAllUserDetail() {
		List<UserDetail> userDetail = (List<UserDetail>) jdbcTemplate.query("select * from user_detail",
				new UserDetailRowMapper());
		return userDetail;
	}
	
	@Transactional(transactionManager = "txManager", propagation = Propagation.REQUIRED)
	public int addUserDetail1(UserDetail userDetail) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("user_detail").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("first_name", userDetail.getFirstName());
		parameters.put("last_name", userDetail.getLastName());
		parameters.put("email", userDetail.getEmail());
		parameters.put("dob", userDetail.getDob());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		int i = insertedId.intValue();
		System.out.println("query_timeout:" + jdbcTemplate.getQueryTimeout());
		
		return i;
	}
	
	@Transactional(transactionManager = "txManager", propagation = Propagation.REQUIRES_NEW)
	public int addUserDetail2(UserDetail userDetail, boolean t) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("user_detail").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("first_name", userDetail.getFirstName());
		parameters.put("last_name", userDetail.getLastName());
		parameters.put("email", userDetail.getEmail());
		parameters.put("dob", userDetail.getDob());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		int j = insertedId.intValue();
		
		if(t) throw new RuntimeException("exception while inserting 2222!!");
		
		
		return j;
	}
	@Transactional
	public int updateUserDetail(UserDetail userDetail) {
		String sql = "update user_detail set first_name = ?, last_name = ?, email = ?, dob = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { userDetail.getFirstName(), userDetail.getLastName(),
				userDetail.getEmail(), userDetail.getDob(), userDetail.getId() });
		return resp;
	}
	
	@Transactional
	public UserDetail getUserDetail(int id) {
		UserDetail userDetail = (UserDetail) jdbcTemplate.queryForObject("select * from user_detail where id = ?",
				new Object[] { id }, new UserDetailRowMapper());
		return userDetail;
	}

}
