package niks.poc.spring.demo.patterns.prototype;

public class AuthSignatory implements Cloneable{
	
	String name;
	String desg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "AuthSignatory [getName()=" + getName() + ", getDesg()=" + getDesg() + "]";
	}

	
}
