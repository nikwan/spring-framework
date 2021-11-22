package niks.poc.spring.propagation.demo.func;

import java.util.function.Consumer;

public class SmsBuilder {
	
	public SmsBuilder mobile(String mobile) {
		System.out.println("mobile " + mobile);
		
		return this;
	}
	
	public SmsBuilder msg(String msg) {
		System.out.println("msg " + msg);
		return this;
	}
	
	private SmsBuilder() {}
	
	public static void send(Consumer<SmsBuilder> sms) {
		SmsBuilder s = new SmsBuilder();
		sms.accept(s);
		
	}

}
