package niks.poc.spring.scope.demo.entities;

public class UserDetail implements Comparable<UserDetail>{
	
	
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	public UserDetail(int id, String firstName, String lastName, String email, String dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + "]";
	}
	@Override
	public int compareTo(UserDetail o) {
		
		if(o.getId() == this.getId()) {
			return 0;
		}
		return -1;
		 
	}
	
	

}
