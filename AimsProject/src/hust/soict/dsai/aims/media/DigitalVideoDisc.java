package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media implements Playable{

	private String director;
	private int length;
	private LocalDate dateAdded;

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
		super(title);
//		dateAdded = LocalDate.now();
	}


	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
//		dateAdded = LocalDate.now();
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
//		dateAdded = LocalDate.now();
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
//		dateAdded = LocalDate.now();

	}
	public String toString() {
		return this.getTitle() + " (Category: " + getCategory() + ") directed by " + director+ ", id = " + this.getId(); 
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		
	}
	
} 
