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

	public Media() {
		
	}

}
