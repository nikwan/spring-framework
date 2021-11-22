package niks.poc.spring.demo.patterns.factorymethod;

import org.junit.Test;

public class PizzaFactoryTest {
	
	@Test
	public void testAndMakePizza() {
		BasePizzaFactory pizzaFactory = new PizzaFactory();
		
		Pizza cheesePizza = pizzaFactory.createPizza("cheese");
		cheesePizza.addExtraCheese(100);
		Pizza veggiePizza = pizzaFactory.createPizza("veggie");
	}

}
