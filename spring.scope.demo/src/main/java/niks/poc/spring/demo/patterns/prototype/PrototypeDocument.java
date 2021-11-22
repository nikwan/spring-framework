package niks.poc.spring.demo.patterns.prototype;

public abstract class PrototypeDocument implements Cloneable{
	String content;
	String vendor;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	abstract PrototypeDocument cloneDocument() throws CloneNotSupportedException;

}
