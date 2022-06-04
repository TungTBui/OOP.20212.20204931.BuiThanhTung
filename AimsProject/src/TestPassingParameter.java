import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		System.out.println("Before swap: ");
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		System.out.println();
		
		System.out.println("After original swap: ");
		swap1(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		System.out.println();
		
		System.out.println("After modified swap: ");
		swap2(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		System.out.println();

		System.out.println("After change: ");
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd tile: "+jungleDVD.getTitle() );

	}

	public static void swap1(Object o1, Object o2) {

		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	// Technically, we cannot write a swap method that swap the objects, we could only swap its members
	public static void swap2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String titleDVD1 = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(titleDVD1);
	}

}

class ClassWrapper {
	Object c;
 
    // Constructor
    ClassWrapper(Object c) { this.c = c; }
}
