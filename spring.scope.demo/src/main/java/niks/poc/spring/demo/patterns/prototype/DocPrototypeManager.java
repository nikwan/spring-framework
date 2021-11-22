package niks.poc.spring.demo.patterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class DocPrototypeManager {
	
	private static Map<String, PrototypeDocument> prototypes = new HashMap<String, PrototypeDocument>();
	
	static {
		TandC tc = new TandC();
		tc.setVendor("Oracel Corp.");
		tc.setContent("Please read terms and conditions");
		prototypes.put("tc", tc);
		AuthSignatory as = new AuthSignatory();
		as.setDesg("Manager");
		as.setName("Sachin T");
		
		Agreement ag = new Agreement();
		ag.setAuthSignatory(as);
		ag.setContent("Please read and accept Agreement");
		ag.setVendor("Pivotal Inc.");
		
		prototypes.put("agree", ag);
	}
	
	public static PrototypeDocument getClone(final String type) {
		PrototypeDocument clonedDoc = null;
		try {
			PrototypeDocument doc = prototypes.get(type);
			clonedDoc = doc.cloneDocument();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clonedDoc;
	}

}
