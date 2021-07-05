package niks.poc.spring.scope.demo.messageresource;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageResourceTest {
	
	@Autowired
	MessageSource messageSource;
	
	@PostConstruct
	void init() {
		System.out.println("################message from message source:" + 
	messageSource.getMessage("101", null, "default message!!", null));
		
		System.out.println("################message from message source:" + 
				messageSource.getMessage("102", new Object[] {"TXNO1234", "CODEB2344"}, "default message for transaction!!", null));

		System.out.println("################message from message source:" + 
				messageSource.getMessage("102", new Object[] {"TXNO1234", "CODEB2344"}, "default message for transaction!!", Locale.UK));

	}

}
