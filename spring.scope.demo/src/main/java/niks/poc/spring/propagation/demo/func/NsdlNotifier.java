package niks.poc.spring.propagation.demo.func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class NsdlNotifier {
	
	private static List<State> list;

	public static void withMail(Consumer<MailBuilder> mail) {
		MailBuilder.send(mail);
		
	}
	
	public static  void withSms(Consumer<SmsBuilder> sms) {
		SmsBuilder.send(sms);
	}
	
	public static void main(String[] args) {
		NsdlNotifier.withMail(mail -> mail.to("nikhil@gmail.com").body("email body!"));
		NsdlNotifier.withSms(sms -> sms.mobile("9372512233").msg("Hi Nikhil!"));
		
		
	}

}

class State {
	int code;
	String state;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public State(int code, String state) {
		super();
		this.code = code;
		this.state = state;
	}
	
	
}
