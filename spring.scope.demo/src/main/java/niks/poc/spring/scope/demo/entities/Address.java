package niks.poc.spring.scope.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "address")
public class Address {
	
	@Id
	private int id;
	
	@Column(name="address")
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Address(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}
	
	public Address(){}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}

	
}
