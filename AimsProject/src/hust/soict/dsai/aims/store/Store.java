package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	
	//Section 10
	
	ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	void addDVD(DigitalVideoDisc dvd) {
		itemsInStore.add(dvd);
		System.out.println("The disk " + dvd.getTitle() + " has been added to the cart.");
	}
	
	int removeDVD(DigitalVideoDisc dvd) {
		int discRemoved = 0;

		for(DigitalVideoDisc disk: itemsInStore) {
			if (disk.getTitle().equals(dvd.getTitle())) {
				itemsInStore.remove(dvd);
				// Update the number of discs with that title removed
				discRemoved ++;
			}
			
		}
		System.out.println(discRemoved + " " + dvd.getTitle() +  "  has been removed from the cart");
		return discRemoved;
	}

}
