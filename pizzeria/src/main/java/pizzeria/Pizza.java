package pizzeria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Pizza extends JFrame implements ActionListener {

	// SETTING UP ATTRIBUTES

	private List<Topping> toppings = new ArrayList<Topping>();

	private BigDecimal totalPrice = new BigDecimal(4.99);

	JLabel title, receipt, bill, order, cheese, pep, mush, orderCheese, orderPep, orderMush;
	JButton b1, cheesePlus, cheeseMinus, pepperoniPlus, pepMinus, mushroomPlus, mushMinus, clear, checkout;

	int cheeseCount = 0;
	int pepperoniCount = 0;
	int mushroomCount = 0;

	URL url0 = Pizza.class.getResource("/cheese.jpg");
	Icon ic0 = new ImageIcon(url0);
	URL url1 = Pizza.class.getResource("/pepperoni.jpg");
	Icon ic1 = new ImageIcon(url1);
	URL url2 = Pizza.class.getResource("/mushpep.png");
	Icon ic2 = new ImageIcon(url2);

	// SETTING UP THE GRAPHICS

	public Pizza() {

		JFrame f = new JFrame("ANDY'S PIZZERIA");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setSize(500, 500);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);

		title = new JLabel("WELCOME TO ANDY'S PIZZERIA");
		title.setBounds(50, 20, 200, 30);

		cheesePlus = new JButton("+");
		cheesePlus.setBounds(50, 100, 50, 30);
		cheesePlus.addActionListener(this);
		cheese = new JLabel("CHEESE");
		cheese.setBounds(125, 100, 100, 30);
		cheeseMinus = new JButton("-");
		cheeseMinus.setBounds(200, 100, 50, 30);
		cheeseMinus.addActionListener(this);

		pepperoniPlus = new JButton("+");
		pepperoniPlus.setBounds(50, 150, 50, 30);
		pepperoniPlus.addActionListener(this);
		pep = new JLabel("PEPPERONI");
		pep.setBounds(115, 150, 100, 30);
		pepMinus = new JButton("-");
		pepMinus.setBounds(200, 150, 50, 30);
		pepMinus.addActionListener(this);

		mushroomPlus = new JButton("+ ");
		mushroomPlus.setBounds(50, 200, 50, 30);
		mushroomPlus.addActionListener(this);
		mush = new JLabel("MUSHROOM");
		mush.setBounds(115, 200, 100, 30);
		mushMinus = new JButton("-");
		mushMinus.setBounds(200, 200, 50, 30);
		mushMinus.addActionListener(this);

		receipt = new JLabel("TOTAL PRICE: " + 4.99);
		receipt.setBounds(300, 225, 150, 30);

		bill = new JLabel("");
		bill.setBounds(50, 240, 200, 30);

		clear = new JButton("CLEAR");
		clear.setBounds(50, 275, 150, 30);
		clear.addActionListener(this);

		order = new JLabel("CURRENT ORDER");
		order.setBounds(300, 100, 200, 30);

		orderCheese = new JLabel("Cheese ... 1.50 x 0");
		orderCheese.setBounds(300, 125, 150, 30);

		orderPep = new JLabel("Pepperoni ... 3.50 x 0");
		orderPep.setBounds(300, 150, 150, 30);

		orderMush = new JLabel("Mushroom ... 3.50 x 0");
		orderMush.setBounds(300, 175, 150, 30);

		b1 = new JButton(ic0);
		b1.setBounds(275, 250, 200, 200);

		f.add(title);

		f.add(cheesePlus);
		f.add(cheese);
		f.add(cheeseMinus);

		f.add(pepperoniPlus);
		f.add(pep);
		f.add(pepMinus);

		f.add(mushroomPlus);
		f.add(mush);
		f.add(mushMinus);

		f.add(bill);
		f.add(receipt);
		f.add(clear);
		f.add(order);

		f.add(orderCheese);
		f.add(orderPep);
		f.add(orderMush);
		f.add(b1);
	}

	// MAIN
	public static void main(String[] args) {

		new Pizza();
	}

	public void addTopping(Topping topping) {
		this.toppings.add(topping);
		totalPrice = totalPrice.add(topping.getPrice());
	}

	public void removeTopping(Topping topping) {
		this.toppings.remove(topping);
		totalPrice = totalPrice.subtract(topping.getPrice());
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice.setScale(2, RoundingMode.HALF_UP);
	}

	public void actionPerformed(ActionEvent e) {

		Topping cheeseAdd = new CheeseTopping();
		Topping pepperoniAdd = new Pepperoni();
		Topping mushroomAdd = new MushroomTopping();

		if (e.getSource() == cheesePlus) {
			if (cheeseCount >= 2) {
				bill.setText("Easy on the cheese buddy...");
			}

			b1.setIcon(ic0);
			addTopping(cheeseAdd);
			cheeseCount++;

			orderCheese.setText("Cheese ... 1.50 x " + cheeseCount);
			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}

		if (e.getSource() == cheeseMinus && cheeseCount > 0) {
			if (cheeseCount <= 3) {
				bill.setText(" ");
			}

			removeTopping(cheeseAdd);
			cheeseCount--;

			orderCheese.setText("Cheese ... 1.50 x " + cheeseCount);
			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}

		if (e.getSource() == pepperoniPlus) {
			if (pepperoniCount >= 2) {
				bill.setText("That's a lot of sodium...");
			}
			b1.setIcon(ic1);
			addTopping(pepperoniAdd);
			pepperoniCount++;

			orderPep.setText("Pepperoni ... 3.50 x " + pepperoniCount);
			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}
		if (e.getSource() == pepMinus && pepperoniCount > 0) {
			if (pepperoniCount <= 3) {
				bill.setText(" ");
			}
			removeTopping(pepperoniAdd);
			pepperoniCount--;

			orderPep.setText("Pepperoni ... 3.50 x " + pepperoniCount);
			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}

		if (e.getSource() == mushroomPlus) {
			if (mushroomCount >= 2) {
				bill.setText("Don't trip, man...");
			}
			b1.setIcon(ic2);
			addTopping(mushroomAdd);
			mushroomCount++;

			orderMush.setText("Mushroom ... 3.50 x " + mushroomCount);
			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}
		if (e.getSource() == mushMinus && mushroomCount > 0) {
			if (mushroomCount <= 3) {
				bill.setText("");
			}
			removeTopping(mushroomAdd);
			mushroomCount--;

			orderMush.setText("Mushroom ... 3.50 x " + mushroomCount);
			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}

		if (e.getSource() == clear) {
			while (cheeseCount > 0) {
				removeTopping(cheeseAdd);
				cheeseCount--;
			}
			while (pepperoniCount > 0) {
				removeTopping(pepperoniAdd);
				pepperoniCount--;
			}
			while (mushroomCount > 0) {
				removeTopping(mushroomAdd);
				mushroomCount--;
			}

			b1.setIcon(ic0);

			orderCheese.setText("Cheese ... 1.50 x " + cheeseCount);
			orderPep.setText("Pepperoni ... 3.50 x " + pepperoniCount);
			orderMush.setText("Mushroom ... 3.50 x " + mushroomCount);
			bill.setText("ORDER RESET");

			receipt.setText("TOTAL PRICE: " + getTotalPrice());
		}
	}
}
