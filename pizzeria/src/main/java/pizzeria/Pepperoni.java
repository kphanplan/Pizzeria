package pizzeria;

import java.math.BigDecimal;

public class Pepperoni implements Topping {
	String name = "Pepperoni";
	BigDecimal price = new BigDecimal(3.50);
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
}
