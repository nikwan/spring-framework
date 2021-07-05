package niks.poc.spring.scope.demo.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDetailRowMapper implements RowMapper<UserDetail>{

	@Override
	public UserDetail mapRow(ResultSet rs, int arg1) throws SQLException {
		UserDetail userDetail = new UserDetail();
		userDetail.setId(rs.getInt("id"));
		userDetail.setFirstName(rs.getString("first_name"));
		userDetail.setLastName(rs.getString("last_name"));
		userDetail.setEmail(rs.getString("email"));
		userDetail.setDob(rs.getString("dob"));
		return userDetail;
	}

}
