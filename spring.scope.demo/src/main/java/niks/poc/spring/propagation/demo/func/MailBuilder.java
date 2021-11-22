package niks.poc.spring.propagation.demo.func;

import java.util.function.Consumer;

public class MailBuilder {
	
	private MailBuilder() {}
	
	MailBuilder to(String to) {
		System.out.println("to:" + to);
		return this;
	}
	
	MailBuilder body(String body) {
		System.out.println("body:" + body);
		return this;
	}
	
	MailBuilder from(String from) {
		System.out.println("from:" + from);
		return this;
	}

	public static void send(Consumer<MailBuilder> mail) {
		MailBuilder m = new MailBuilder();
		mail.accept(m);
	}
}
