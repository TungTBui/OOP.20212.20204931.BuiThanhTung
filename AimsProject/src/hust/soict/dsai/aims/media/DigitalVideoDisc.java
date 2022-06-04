package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media{

	private String director;
	private int length;
	private LocalDate dateAdded;
	private static int nbDigitalVideoDiscs = 0;

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		dateAdded = LocalDate.now();
		nbDigitalVideoDiscs ++;
		id = nbDigitalVideoDiscs;
	}


	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		dateAdded = LocalDate.now();
		nbDigitalVideoDiscs ++;
		id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		dateAdded = LocalDate.now();
		nbDigitalVideoDiscs ++;
		id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		dateAdded = LocalDate.now();
		nbDigitalVideoDiscs ++;
		id = nbDigitalVideoDiscs;
	}
	public String toString() {
		return title + " (Category: " + getCategory() + ") directed by " + director+ ", id = " + id; 
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
	
} 
