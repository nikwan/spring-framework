package niks.poc.spring.demo.patterns.abstractfactory;

public class MozzarellaCheese implements Cheese{
	
	public MozzarellaCheese() {
		prepareCheese();
	}

	@Override
	public void prepareCheese() {
		System.out.println("preparing mozzarella cheese...");
		
	}

}
