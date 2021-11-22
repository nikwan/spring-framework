package niks.poc.spring.demo.patterns.factorymethod;

import niks.poc.spring.demo.patterns.abstractfactory.BaseToppingFactory;

public class ChessePizza extends Pizza{
	
	BaseToppingFactory toppingFactory;
	
	ChessePizza(){};
	
	public ChessePizza(BaseToppingFactory toppingFactory) {
		this.toppingFactory = toppingFactory;
	}

	@Override
	public void addIngredients() {
		System.out.println("prepareing ingridents for chesse pizza...");
		toppingFactory.createCheese();
		toppingFactory.createSauce();
	}

}
