package hust.soict.dsai.aims.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class DiskTest {
	
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Princess Mononoke",
				"Animation", "Hayao Miyazaki", 18.99f);
		cart.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away",
				"Animation", "Hayao Miyazaki", 18.15f);
		cart.addDigitalVideoDisc(dvd5);
		
		cart.print();
		
		System.out.println();
		System.out.println("--------Test isMatch()--------");
		System.out.println(dvd5.isMatch("Away"));
		System.out.println(dvd5.isMatch("awAy"));
		System.out.println(dvd5.isMatch("Random Word"));
		
		System.out.println();
		System.out.println("--------Test search DVD--------");
		cart.titleSearch("Spirited Away");
		cart.titleSearch("awAy");
		cart.titleSearch("Spider Man: Far From Home");
	}
	//Section 9

}
