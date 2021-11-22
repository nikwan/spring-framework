package niks.poc.spring.propagation.demo.func;

import java.util.function.Consumer;

public class MailBuilderTest {
	
	public static void main(String[] args) {
		
		Consumer<MailBuilder> m = mail -> mail.from("ZZZZZZZZZZZZ@gmail.com")
				.to("XXXXXXXXX@gmail.com")
				.body("Hi Allllllll!");
		
		MailBuilder.send(mail -> mail.from("nikhil@gmail.com")
				.to("kablu@gmail.com")
				.body("Hi All!"));
		
		MailBuilder.send(m);
		
	}
	

}
