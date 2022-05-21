
public class Aims {

	public static void main(String[] args) {
		
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total cost is: " + anOrder.totalCost());
		
		// Test the removeDigitalVideoDisc(DigitalVideoDisc) method
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("Total cost is: " + anOrder.totalCost());
		anOrder.removeDigitalVideoDisc(dvd2);
		
		// Test the addDigitalVideoDisc(DigitalVideoDisc[]) method
		Cart anOrder1 = new Cart();
		DigitalVideoDisc[] dvdList = {dvd1,dvd2,dvd3};
		anOrder1.addDigitalVideoDisc(dvdList);
		
		// Test the addDigitalVideoDisc1(DigitalVideoDisc...) method
		Cart anOrder2 = new Cart();
		anOrder2.addDigitalVideoDisc1(dvd1, dvd2, dvd3);
		
		
		
		
		
	}

}
