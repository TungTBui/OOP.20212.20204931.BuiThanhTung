package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Store {
	
	//Section 10
	
	public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore.add(dvd);
		System.out.println("The disk " + dvd.getTitle() + " has been added to the store.");
	}
	
	public int removeDVD(DigitalVideoDisc dvd) {
		int discRemoved = 0;

		for(DigitalVideoDisc disk: itemsInStore) {
			if (disk.getTitle().equals(dvd.getTitle())) {
				itemsInStore.remove(dvd);
				// Update the number of discs with that title removed
				discRemoved ++;
			}
		}
		if (discRemoved == 0) {
			System.out.println("The disc " + dvd.getTitle() + " is not in the cart");
		}
		else
			System.out.println(discRemoved + " " + dvd.getTitle() +  "  has been removed from the store");
		return discRemoved;
	}
	
	public ArrayList<DigitalVideoDisc> titleSearch(String title) {
		System.out.println("***************Searching***************");
		ArrayList<DigitalVideoDisc> foundDVDs = new ArrayList<DigitalVideoDisc>();
		
		for (DigitalVideoDisc dvd: itemsInStore) {
			if (dvd.isMatch(title)) {
				foundDVDs.add(dvd);
			}
		}
		if (foundDVDs.size() == 0) {
			System.out.println("The disc with the given title is not in the store");
			
		}
		else {
			System.out.println("The disc with the title " + title + " is found. Here is the information for that disc:");
			for (DigitalVideoDisc i: foundDVDs) {
				System.out.println(i);
			} 
		}
		return foundDVDs;
	}
	
	public DigitalVideoDisc idSearch(int id) {
		System.out.println("***************Searching***************");
		DigitalVideoDisc foundDVD = null;
		for (DigitalVideoDisc dvd: itemsInStore) {
			if (dvd.getId() == (id)) {
				foundDVD = dvd;
				break;
			}
		}
		if (foundDVD == null) {
			System.out.println("The disc with the given ID is not in the store");
			
		}
		else {
			System.out.println("The disc with the ID " + id + " is found");
		 
		}
		return foundDVD; 
	}
	
	
	public void print() {
		System.out.println("***********************Store***********************");
		System.out.println("Store items:");
		
		DigitalVideoDisc[] store = itemsInStore.toArray(new DigitalVideoDisc[itemsInStore.size()]);
		
		
		for (int i = 0; i < store.length; i ++) {
			System.out.println(store[i]);
		}

	}

}
