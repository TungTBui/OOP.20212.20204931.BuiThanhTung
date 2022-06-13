package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Function;

import hust.soict.dsai.aims.utils.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.utils.MediaComparatorByTitleCost;

public abstract class Media implements Comparable<Media>{

	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	private static int nbMedias = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
		
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public static int getNbMedias() {
		return nbMedias;
	}

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		dateAdded = LocalDate.now();
		nbMedias ++;
		this.id = nbMedias;
	}

	public Media(String title) {
		this.title = title;
		dateAdded = LocalDate.now();
		nbMedias ++;
		this.id = nbMedias;
	}

	public boolean isMatch(String title) {
		String[] tokens = title.split(" ");
		boolean found = false;
		for (String word: tokens) {
			if (this.title.toLowerCase().contains(word.toLowerCase())) {
				found = true;
			}
		}
		return found;
	}
	
	public String toString() {
		return title + " (Category: " + getCategory() + "), id = " + id; 
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Media)) {
			return false;
		}
		else {
			return this.getId() == ((Media) obj).getId();
		}
	}
	
	public int compareTo(Media media) {
		if (this.getTitle().compareTo(media.getTitle()) == 0) {
			return this.getCategory().compareTo(media.getCategory());
		}
		else {
			return this.getTitle().compareTo(media.getTitle());
		}
	}
}
