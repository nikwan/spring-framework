package niks.poc.spring.demo.patterns.prototype;

public class TandC extends PrototypeDocument{

	@Override
	PrototypeDocument cloneDocument() throws CloneNotSupportedException {
		// clone with shallow copy
		TandC tc = null;
		try {
			tc = (TandC)super.clone();
		}catch(CloneNotSupportedException e) {
			
		}
		return tc;
	}

	@Override
	public String toString() {
		return "TandC [getContent()=" + getContent() + ", getVendor()=" + getVendor() + "]";
	}
	
	

}
