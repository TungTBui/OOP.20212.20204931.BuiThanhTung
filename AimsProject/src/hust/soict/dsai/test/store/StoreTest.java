package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	
	public static void main (String[] args) {
	//Test section 10
		
		Store store = new Store();
		
		System.out.println("---------Test Add and Remove DVD in a store--------");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addDVD(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Princess Mononoke",
				"Animation", "Hayao Miyazaki", 18.99f);
		store.addDVD(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away",
				"Animation", "Hayao Miyazaki", 18.15f);
		store.addDVD(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Tenet",
				"Action", "Christopher Nolan", 22.45f);
		store.addDVD(dvd6);
		
		System.out.println();
		System.out.println("The store after adding 6 dvds");
		store.print();
		
		System.out.println();
		System.out.println("The store after deleting the fifth dvd");
		store.removeDVD(dvd5);
		store.print();
	}
}
