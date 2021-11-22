package niks.poc.spring.demo.patterns.factorymethod;

public abstract class Pizza {
	
	public abstract void addIngredients();
	
	public void bakePizza() {
		System.out.println("pizza is baking it take 20-40 minites");
	}
	
	public void addExtraCheese(int qty) {
		
		System.out.println("added extra cheese of quantity [" + qty +"]");
		
	}

}
