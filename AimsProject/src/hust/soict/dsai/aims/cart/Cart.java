package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	
	int qtyOrdered = 0; 
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	
	// Add a disc into the cart
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		// Check if the cart is already full 
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("This disc can't be added into the cart since it's already full");
		}
		
		else {
			
			//Create an arrayList of the cart
			ArrayList<DigitalVideoDisc> cartList = new ArrayList<DigitalVideoDisc>();
			
			for(DigitalVideoDisc item : itemsOrdered) {
				if (item != null) {
					cartList.add(item);
				}
		      
		     }
			
			// Add the chosen disc
			cartList.add(disc);
			
			// Update the quantity of the discs in the cart
			qtyOrdered ++;
			
			// Inform the user
			System.out.println("The disc " + disc.getTitle() + " has been added");
			cartList.toArray(itemsOrdered);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
				
		// Add the discs in the list of DVDs chosen
		for (DigitalVideoDisc item : dvdList) {
			this.addDigitalVideoDisc(item);
		}
		
	}
	
	
	// Add an arbitrary number of Dvds
	/* We cannot overload the method addDigitalVideoDisc here because
	when we use variable argument the type of the parameter is array
	which is the same as the previous method. Therefore, we have to use 
	a different name for this method. */
	public void addDigitalVideoDisc1(DigitalVideoDisc ... disc) {

		// Add the chosen discs
		for (DigitalVideoDisc discs : disc) {
			this.addDigitalVideoDisc(discs);				
		}  
	
	}
	

	// Remove the discs having the given title from the cart
	// Return the number of discs removed from the cart
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		// Count the number of the disc removed
		int discRemoved = 0;
		
			
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item != null) {
				if (disc.getTitle().equals(item.getTitle())) {
					// Update the quantity of the discs in the cart
					qtyOrdered --;
					// Update the number of discs with that title removed
					discRemoved ++;
				}
			}
			
		}
		
		if (discRemoved == 0) {
			System.out.println("The disc " + disc.getTitle() + " is not in the cart");
		}
		
		else {
			
			// Create an arrayList of the cart
			ArrayList<DigitalVideoDisc> cartList = new ArrayList<DigitalVideoDisc>();
			
			for(DigitalVideoDisc item : itemsOrdered) {
				
				if (item != null) {
					
					if (disc.getTitle() != item.getTitle()) {
						cartList.add(item);
					}
															
				}
				
			}
	
			// Inform the user
			System.out.println(discRemoved + " " + disc.getTitle() +  "  has been removed from the cart");
			System.out.println("Your cart currently has a total of " + qtyOrdered +  " DVDs");
			
			cartList.toArray(itemsOrdered);
			
		}
		
		return discRemoved;
	}
	
	
	// Add two discs into the cart
	void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		
		// Add the first disc into the cart
		this.addDigitalVideoDisc(dvd1);
		// Add the second disc into the cart
		this.addDigitalVideoDisc(dvd1);
	}

	
	// Calculate the total cost of the current cart
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
			}
		}
		return cost;
	}
	
	DigitalVideoDisc[] sortByCost() {
		DigitalVideoDisc[] newCart = Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		DVDUtils.sortByCost(newCart);
		System.out.println("Sort by cost: ");
		for (int i = 0; i < qtyOrdered; i ++) {
			itemsOrdered[i] = newCart[i];
			System.out.print(newCart[i].getTitle() + " - ");
		}
		System.out.print("\n");
		return itemsOrdered;
	}
	
	DigitalVideoDisc[] sortByTitle() {
		DigitalVideoDisc[] newCart = Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		DVDUtils.sortByTitle(newCart);
		System.out.println("Sort by title: ");
		for (int i = 0; i < qtyOrdered; i ++) {
			itemsOrdered[i] = newCart[i];
			System.out.print(newCart[i].getTitle() + " - ");
		}
		System.out.print("\n");
		return itemsOrdered;
	}
	
//	DigitalVideoDisc[] sortByLength() {
//		DigitalVideoDisc[] newCart = Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
//		DVDUtils.sortByLength(newCart);
//		System.out.println("Sort by length: ");
//		for (int i = 0; i < qtyOrdered; i ++) {
//			itemsOrdered[i] = newCart[i];
//			System.out.print(newCart[i].getTitle() + " - ");
//		}
//		System.out.print("\n");
//		return itemsOrdered;
//	}
	
	public void idSearch(int id) {
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
	}
	
	public void titleSearch(String title) {
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