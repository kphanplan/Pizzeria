package pizzeria;

import java.math.BigDecimal;

public class CheeseTopping implements Topping{

	String name = "Cheese";
	BigDecimal price = new BigDecimal(1.50);
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

}
