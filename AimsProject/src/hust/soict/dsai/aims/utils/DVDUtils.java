package hust.soict.dsai.aims.utils;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DVDUtils {
	
	public static String compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		
		if (dvd1.getCost() > dvd2.getCost()) {
			return (dvd1.getTitle()+ " cost more than " + dvd2.getTitle());
		}
		
		else if (dvd1.getCost() < dvd2.getCost()) {
			return (dvd1.getTitle()+ " cost less than " + dvd2.getTitle());
		}
		
		else {
			return (dvd1.getTitle()+ " has the same price as " + dvd2.getTitle());
		}
	}
	
	public static String compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getTitle().equals(dvd2.getTitle())) {
			return ("Two discs have the same title");
		}
		
		else {
			return ("Two discs have different title");
		}
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvd) {
		Arrays.sort(dvd, new sortByCostComparator());
		return dvd;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvd) {
		Arrays.sort(dvd, new sortByTitleComparator());
		return dvd;
	}


	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] dvd) {
		Arrays.sort(dvd, new sortByLengthComparator());
		return dvd;
	}
}

class sortByCostComparator implements Comparator<DigitalVideoDisc> {
	public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		
		return dvd1.getCost() < dvd2.getCost() ?1:-1;
	}
}
class sortByTitleComparator implements Comparator<DigitalVideoDisc> {
	public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			
			return dvd1.getTitle().compareTo(dvd2.getTitle());
	}
}

class sortByLengthComparator implements Comparator<DigitalVideoDisc> {
	public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			
			return dvd1.getLength() < dvd2.getLength() ?1:-1;
	}
}