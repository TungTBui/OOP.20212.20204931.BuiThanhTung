package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class Store {
	
	//Section 10
	
	public ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public int numItemsInStore;
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("The media is already in the store.");
		}
		else {
			itemsInStore.add(media);
			System.out.println(media.getTitle() + " has been added to the store.");
			numItemsInStore ++;
		}

	}
	
	public int removeMedia(Media media) {
		int discRemoved = 0;

		for(Media mediaInStore: itemsInStore) {
			if (mediaInStore.getTitle().equals(media.getTitle())) {
				itemsInStore.remove(mediaInStore);
				// Update the number of discs with that title removed
				discRemoved ++;
			}
		}
		if (discRemoved == 0) {
			System.out.println(media.getTitle() + " is not in the cart");
		}
		else
			System.out.println(discRemoved + " " + media.getTitle() +  "  has been removed from the store");
		return discRemoved;
	}
	
	public ArrayList<Media> titleSearch(String title) {
		System.out.println("***************Searching***************");
		ArrayList<Media> foundMedia = new ArrayList<Media>();
		
		for (Media medium: itemsInStore) {
			if (medium.isMatch(title)) {
				foundMedia.add(medium);
			}
		}
		if (foundMedia.size() == 0) {
			System.out.println("The media with the given title is not in the store");
			
		}
		else {
			System.out.println("The media with the title " + title + " is found. Here is the information for that media:");
			for (Media i: foundMedia) {
				System.out.println(i);
			} 
		}
		return foundMedia;
	}
	
	public Media idSearch(int id) {
		System.out.println("***************Searching***************");
		Media foundMedia = null;
		for (Media medium: itemsInStore) {
			if (medium.getId() == (id)) {
				foundMedia = medium;
				break;
			}
		}
		if (foundMedia == null) {
			System.out.println("The media with the given ID is not in the store");
			
		}
		else {
			System.out.println("The media with the ID " + id + " is found");
		 
		}
		return foundMedia; 
	}
	
	
	public void print() {
		System.out.println("***********************Store***********************");
		System.out.println("Store items:");		
		
		for (Media medium: itemsInStore) {
			System.out.println(medium);
		}

	}

}
