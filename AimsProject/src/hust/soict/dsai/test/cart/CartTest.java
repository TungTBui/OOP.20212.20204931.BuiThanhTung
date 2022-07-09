package hust.soict.dsai.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.NegativeValueException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) throws NullPointerException, NegativeValueException, LimitExceededException {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King",
				"Action", 15.99f);
		cart.addMedia(dvd4);
		
//		// Test the print method
//		System.out.println();
//		System.out.println("----------Test the print() method----------");
//		cart.print();
//		
//		// Test the search ID method
//		System.out.println();
//		System.out.println("----------Test the search ID method----------");
//		cart.idSearch(5);
//		
//		// Test the search title method
//		System.out.println();
//		System.out.println("----------Test the search title method----------");
//		cart.titleSearch("The Lion King");
//		
//		//Test the sort by cost method
//		System.out.println();
//		System.out.println("----------Test the sort by cost method----------");
//		cart.sortByCost();
//		
//		//Test the sort by title method
//		System.out.println();
//		System.out.println("----------Test the sort by title method----------");
//		cart.sortByTitle();
		
		
	}

}
