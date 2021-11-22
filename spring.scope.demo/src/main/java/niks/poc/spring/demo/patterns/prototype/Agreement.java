package niks.poc.spring.demo.patterns.prototype;

public class Agreement extends PrototypeDocument{
	AuthSignatory authSignatory;

	@Override
	PrototypeDocument cloneDocument() throws CloneNotSupportedException {
		Agreement agree;
		PrototypeDocument p = (PrototypeDocument) super.clone(); //shallow copy agreement
		agree = (Agreement) p; //shallow copy agreement
		AuthSignatory auth = (AuthSignatory) agree.getAuthSignatory().clone(); //deep copy of authsignatory
		agree.setAuthSignatory(auth);
		
		return agree;
	}

	public AuthSignatory getAuthSignatory() {
		return authSignatory;
	}

	public void setAuthSignatory(AuthSignatory authSignatory) {
		this.authSignatory = authSignatory;
	}

	@Override
	public String toString() {
		return "Agreement [authSignatory=" + authSignatory + ", getAuthSignatory()=" + getAuthSignatory()
				+ ", getContent()=" + getContent() + ", getVendor()=" + getVendor() + "]";
	}
	
	

}
