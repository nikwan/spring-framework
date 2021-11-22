package niks.poc.spring.demo.patterns.abstractfactory;

public class GoatCheese implements Cheese{
	
	public GoatCheese() {
		prepareCheese();
	}

	@Override
	public void prepareCheese() {
		System.out.println("preparing goat cheese...");
		
	}

}
