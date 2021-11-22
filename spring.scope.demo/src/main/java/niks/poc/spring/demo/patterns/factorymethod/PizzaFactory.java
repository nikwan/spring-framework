package niks.poc.spring.demo.patterns.factorymethod;

public class PizzaFactory extends BasePizzaFactory{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		switch (type) {
		case "cheese":
			pizza = new ChessePizza();
			break;
		case "veggie":
			pizza = new VeggiePizza();
			break;

		default:
			throw new RuntimeException("type of pizza not found");
		}
		pizza.addIngredients();
		pizza.bakePizza();
		return pizza;
	}

}
