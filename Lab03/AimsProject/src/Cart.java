import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
	
	int qtyOrdered = 0; 
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		ArrayList<DigitalVideoDisc> dvdList = new ArrayList<DigitalVideoDisc>();
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item != null) {
				dvdList.add(item);
			}
	      
	      }
		
		dvdList.add(disc);
		
		qtyOrdered ++;
		System.out.println("The disc has been added");
		System.out.println(dvdList);
		
		dvdList.toArray(itemsOrdered);
		System.out.println(itemsOrdered[qtyOrdered-1].getTitle());
	}
	
//	void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//		for (int i = 0, i < dvdList.length)
//		if (tail == 20) {
//			System.out.println("The cart is already full");
//		}
//		
//		else {
//			itemsOrdered[tail] = disc;
//			qtyOrdered ++;
//			tail ++;
//			System.out.println("The disc has been added");		
//		}	
//	}
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		ArrayList<DigitalVideoDisc> dvdList = new ArrayList<DigitalVideoDisc>();
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item != null) {
				dvdList.add(item);
			}
	      
	      }
		
		dvdList.remove(disc);
		
		qtyOrdered --;
		System.out.println("The disc has been removed");
		System.out.println(dvdList);
		
		dvdList.toArray(itemsOrdered);
	
	}
	

	
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
