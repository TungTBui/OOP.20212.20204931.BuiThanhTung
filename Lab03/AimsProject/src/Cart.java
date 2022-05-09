import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
	
	int qtyOrdered = 0; 
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	
	// Add a disc into the cart
	void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
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
	
	void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
				
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
	void addDigitalVideoDisc1(DigitalVideoDisc ... disc) {

		// Add the chosen discs
		for (DigitalVideoDisc discs : disc) {
			this.addDigitalVideoDisc(discs);				
		}  
	
	}
	

	// Remove the discs having the given title from the cart
	// Return the number of discs removed from the cart
	int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		// Count the number of the disc removed
		int discRemoved = 0;
		
			
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item != null) {
				if (disc.getTitle() == item.getTitle()) {
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
	float totalCost() {
		float cost = 0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
			}
		}
		return cost;
	}
	
}
