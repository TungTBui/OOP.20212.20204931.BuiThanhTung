package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	private static int nbMedias = 0;

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
		return title + " (Category: " + getCategory() + ", id = " + id; 
	}

}
