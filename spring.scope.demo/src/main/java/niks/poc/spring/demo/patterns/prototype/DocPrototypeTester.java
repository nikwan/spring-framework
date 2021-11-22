package niks.poc.spring.demo.patterns.prototype;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class DocPrototypeTester {
	
	@Test
	void testClonedDocument() {
		PrototypeDocument clonnedTc = DocPrototypeManager.getClone("tc");
		System.out.println(clonnedTc);
		System.out.println("tc hashcode:" + clonnedTc.hashCode());
		
		PrototypeDocument agree = DocPrototypeManager.getClone("agree");
		agree.setVendor("Changed Vendor");
		System.out.println(agree);
		System.out.println("agree hashcode1:" + agree.hashCode());
		
		agree = DocPrototypeManager.getClone("agree");
		agree.setVendor("Changed Vendor123");
		System.out.println("agree hashcode2:" + agree.hashCode());
		
		assertNotNull(clonnedTc);
	}

}
