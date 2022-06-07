package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	
	public static void main (String[] args) {
	//Test section 10
		
		Store store = new Store();
		
		System.out.println("---------Test Add and Remove media in a store--------");
		DigitalVideoDisc media1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media1);
		
		DigitalVideoDisc media2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media2);
		
		DigitalVideoDisc media3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addMedia(media3);
		
		DigitalVideoDisc media4 = new DigitalVideoDisc("Princess Mononoke",
				"Animation", "Hayao Miyazaki", 18.99f);
		store.addMedia(media4);
		
		DigitalVideoDisc media5 = new DigitalVideoDisc("Spirited Away",
				"Animation", "Hayao Miyazaki", 18.15f);
		store.addMedia(media5);
		
		DigitalVideoDisc media6 = new DigitalVideoDisc("Tenet",
				"Action", "Christopher Nolan", 22.45f);
		store.addMedia(media6);
		
		System.out.println();
		System.out.println("The store after adding 6 media");
		store.print();
		
		System.out.println();
		System.out.println("The store after deleting the fifth media");
		store.removeMedia(media5);
		store.print();
	}
}
