package niks.poc.spring.demo.patterns.factorymethod;

public class VeggiePizza extends Pizza {

	@Override
	public void addIngredients() {
		System.out.println("prepareing ingridents for veggie pizza...");

	}

}
