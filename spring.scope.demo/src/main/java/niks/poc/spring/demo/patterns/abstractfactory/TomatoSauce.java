package niks.poc.spring.demo.patterns.abstractfactory;

public class TomatoSauce implements Sauce{
	
	TomatoSauce(){
		prepareSauce();
	}

	@Override
	public void prepareSauce() {
		System.out.println("preparing tomato sacuce...");
		
	}

}
