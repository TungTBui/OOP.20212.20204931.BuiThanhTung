package hust.soict.dsai.aims.utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.ObservableList;

public class MediaUtils {
	
	public static String compareByCost(Media media1, Media media2) {
		
		if (media1.getCost() > media2.getCost()) {
			return (media1.getTitle()+ " cost more than " + media2.getTitle());
		}
		
		else if (media1.getCost() < media2.getCost()) {
			return (media1.getTitle()+ " cost less than " + media2.getTitle());
		}
		
		else {
			return (media1.getTitle()+ " has the same price as " + media2.getTitle());
		}
	}
	
	public static String compareByTitle(Media media1, Media media2) {
		if (media1.getTitle().equals(media2.getTitle())) {
			return ("Two discs have the same title");
		}
		
		else {
			return ("Two discs have different title");
		}
	}
	
	public static ObservableList<Media> sortByCost(ObservableList<Media> itemsOrdered) {
		Collections.sort(itemsOrdered, new sortByCostComparator());
		return itemsOrdered;
	}
	
	public static ObservableList<Media> sortByTitle(ObservableList<Media> media) {
		Collections.sort(media, new sortByTitleComparator());
		return media;
	}


	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] dvd) {
		Arrays.sort(dvd, new sortByLengthComparator());
		return dvd;
	}
}

class sortByCostComparator implements Comparator<Media> {
	public int compare(Media media1, Media media2) {
		
		return media1.getCost() > media2.getCost() ?1:-1;
	}
}
class sortByTitleComparator implements Comparator<Media> {
	public int compare(Media media1, Media media2) {
			
			return media1.getTitle().compareTo(media2.getTitle());
	}
}

class sortByLengthComparator implements Comparator<DigitalVideoDisc> {
	public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			
			return dvd1.getLength() < dvd2.getLength() ?1:-1;
	}
}