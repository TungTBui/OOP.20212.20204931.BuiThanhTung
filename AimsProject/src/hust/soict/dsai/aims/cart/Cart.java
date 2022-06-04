package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	
	public int qtyOrdered = 0; 
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
	}
	
	// Calculate the total cost of the current cart
	public float totalCost() {
		float cost = 0;
		for (Media media: itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
	public DigitalVideoDisc[] sortByCost() {
		DigitalVideoDisc[] newCart = Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		DVDUtils.sortByTitle(newCart);
		DVDUtils.sortByCost(newCart);
		System.out.println("Sort by cost: ");
		for (int i = 0; i < qtyOrdered; i ++) {
			itemsOrdered[i] = newCart[i];
			System.out.print(newCart[i].getTitle() + " (id = " + newCart[i].getId() + ", cost " + newCart[i].getCost() + ")"  + " - ");
		}
		System.out.print("\n");
		return itemsOrdered;
	}
	
	public DigitalVideoDisc[] sortByTitle() {
		DigitalVideoDisc[] newCart = Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		DVDUtils.sortByCost(newCart);
		DVDUtils.sortByTitle(newCart);
		System.out.println("Sort by title: ");
		for (int i = 0; i < qtyOrdered; i ++) {
			itemsOrdered[i] = newCart[i];
			System.out.print(newCart[i].getTitle() + " (id = " + newCart[i].getId() + ")"  + " - ");
		}
		System.out.print("\n");
		return itemsOrdered;
	}
	
	
	public DigitalVideoDisc idSearch(int id) {
		System.out.println("***************Searching***************");
		DigitalVideoDisc foundDVD = null;
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].getId() == (id)) {
				foundDVD = itemsOrdered[i];
				break;
			}
		}
		if (foundDVD == null) {
			System.out.println("The disc with the given ID is not in the cart");
			
		}
		else {
			System.out.println("The disc with the ID " + id + " is found. Here is the information for that disc:\n" + foundDVD);
		 
		}
		return foundDVD; 
	}
	
	public ArrayList<DigitalVideoDisc> titleSearch(String title) {
		System.out.println("***************Searching***************");
		ArrayList<DigitalVideoDisc> foundDVDs = new ArrayList<DigitalVideoDisc>();
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].isMatch(title)) {
				foundDVDs.add(itemsOrdered[i]);
			}
		}
		if (foundDVDs.size() == 0) {
			System.out.println("The disc with the given title is not in the cart");
			
		}
		else {
			System.out.println("The disc with the title " + title + " is found. Here is the information for that disc:");
			for (DigitalVideoDisc i: foundDVDs) {
				System.out.println(i);
			} 
		}
		return foundDVDs;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		
		
		DigitalVideoDisc[] newCart = Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		
		
		DVDUtils.sortByLength(newCart);
		DVDUtils.sortByCost(newCart);
		DVDUtils.sortByTitle(newCart);
		
		for (int i = 0; i < qtyOrdered; i ++) {
			itemsOrdered[i] = newCart[i];
		}
		
		for (int i = 0; i < qtyOrdered; i ++) {
			System.out.println(itemsOrdered[i]);
		}
		System.out.println("Total cost: " + String.format("%.2f", totalCost()));
	}
}