package niks.poc.spring.demo.patterns.abstractfactory;

import niks.poc.spring.demo.patterns.factorymethod.BasePizzaFactory;
import niks.poc.spring.demo.patterns.factorymethod.ChessePizza;
import niks.poc.spring.demo.patterns.factorymethod.Pizza;

public class SicillianPizzaFactory extends BasePizzaFactory{

	Pizza pizza;
	
	@Override
	public Pizza createPizza(String type) {
		
		BaseToppingFactory toppingFactory = new SicillianToppingFactory();
		switch(type) {
		case "cheese":
			pizza = new ChessePizza(toppingFactory);
		default:
			
		}
		pizza.addIngredients();
		pizza.bakePizza();
		return pizza;
	}

}
