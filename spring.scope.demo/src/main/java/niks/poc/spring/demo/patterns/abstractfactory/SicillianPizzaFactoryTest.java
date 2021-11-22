package niks.poc.spring.demo.patterns.abstractfactory;

import org.junit.Test;

import niks.poc.spring.demo.patterns.factorymethod.BasePizzaFactory;
import niks.poc.spring.demo.patterns.factorymethod.Pizza;

public class SicillianPizzaFactoryTest {
	
	@Test
	public void testSicillianPizzaFactory() {
		BasePizzaFactory fact = new SicillianPizzaFactory();
		
		Pizza pizza = fact.createPizza("cheese");
		
		System.out.println(pizza);
	}

}
