package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Function;

import hust.soict.dsai.aims.exception.NegativeValueException;
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

	public Media(String title, String category, float cost) throws NullPointerException, NegativeValueException {
		if (title == null || title == "") {
			throw new NullPointerException("Title cannot be empty");
		}
		else if (category == null || category == "") {
			throw new NullPointerException("Category cannot be empty");
		}
		else if (cost <= 0) {
			throw new NegativeValueException("Cost must be > 0");
		}
		else {
			try {
				this.title = title;
				this.category = category;
				this.cost = cost;
				dateAdded = LocalDate.now();
				nbMedias ++;
				this.id = nbMedias;
			}
			catch (NumberFormatException e) {
				throw new NumberFormatException("Cost must be a number");
			}
		}
	}

	public Media(String title) {
		if (title == null || title == "") {
			throw new NullPointerException("Title cannot be empty");
		}
		else {
			this.title = title;
			dateAdded = LocalDate.now();
			nbMedias ++;
			this.id = nbMedias;
		}
		
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

	public boolean equals(Object obj) throws NullPointerException, ClassCastException{
		if (obj == null) {
			throw new NullPointerException("ERROR: NUll OBJECT");
		}
		else if (!(obj instanceof Media)) {
			throw new ClassCastException("ERROR: CANNOT CAST OBJECT");
		}
		else {
			return this.getTitle() == ((Media) obj).getTitle() & this.getCost() == ((Media) obj).getCost();
		}		
	}
	
	public int compareTo(Media media) throws NullPointerException{
		if (media == null) {
			throw new NullPointerException("ERROR: NUll MEDIA");
		}
		else {	
			if (this.getTitle().compareTo(media.getTitle()) == 0) {
				return this.getCategory().compareTo(media.getCategory());
			}
			else {
				return this.getTitle().compareTo(media.getTitle());
			}

		}
			
	}
}
