
public class Cart {
	
	int qtyOrdered; 

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		qtyOrdered ++;
	}
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		qtyOrdered --;
	}
	
}
