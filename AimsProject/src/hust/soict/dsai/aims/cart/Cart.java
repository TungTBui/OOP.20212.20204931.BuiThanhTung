package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.utils.MediaUtils;

public class Cart {
	
	public int qtyOrdered = 0; 
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
		qtyOrdered++;
		System.out.println(media.getTitle() + " has been added to the cart");
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " has been removed from the cart");
			qtyOrdered--;
		}
		else {
			System.out.println(media.getTitle() + " is not in the cart");
		}
	}
	
	// Calculate the total cost of the current cart
	public float totalCost() {
		float cost = 0;
		for (Media media: itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
	public ArrayList<Media> sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		Iterator iterator = itemsOrdered.iterator();
			System.out.println("-----------------------");
			System.out.println("The DVDs in sorted order (cost -> title) are: ");
			while (iterator.hasNext()) {
				System.out.println(((DigitalVideoDisc) iterator.next()));
			}
			System.out.println("-----------------------");
			return itemsOrdered;
		}
	
	public ArrayList<Media> sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		
		Iterator iterator = itemsOrdered.iterator();
		System.out.println("-----------------------");
		System.out.println("The DVDs in sorted order (titlte -> cost) are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()));
		}
		System.out.println("-----------------------");
		return itemsOrdered;
	}
	
	
	public Media idSearch(int id) {
		System.out.println("***************Searching***************");
		Media foundDVD = null;
		for (Media media: itemsOrdered) {
			if (media.getId() == (id)) {
				foundDVD = media;
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
	
	public ArrayList<Media> titleSearch(String title) {
		System.out.println("***************Searching***************");
		ArrayList<Media> foundMedias = new ArrayList<Media>();
		for (Media media: itemsOrdered) {
			if (media.isMatch(title)) {
				foundMedias.add(media);
			}
		}
		if (foundMedias.size() == 0) {
			System.out.println("The disc with the given title is not in the cart");
			
		}
		else {
			System.out.println("The disc with the title " + title + " is found. Here is the information for that disc:");
			for (Media media: foundMedias) {
				System.out.println(media);
			} 
		}
		return foundMedias;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
				
		
//		DVDUtils.sortByLength(itemsOrdered);
		MediaUtils.sortByCost(itemsOrdered);
		MediaUtils.sortByTitle(itemsOrdered);
		
		for (Media media: itemsOrdered) {
			System.out.println(media);
		}
		System.out.println("Total cost: " + String.format("%.2f", totalCost()));
	}
	
	public Media getALuckyItem(Store store) {
		System.out.println("YAYYYY! You have received a lucky item!!!");
		int numItemsInStore = store.itemsInStore.size();
		int rand = (int)(Math.random() * numItemsInStore);
		Media luckyItem = store.itemsInStore.get(rand);
		return luckyItem;
	}
}