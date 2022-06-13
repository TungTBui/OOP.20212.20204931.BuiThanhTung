package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media implements Playable {

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
		return String.format("DVD: [%s] - [%s] - [%s] - [Length: %d] - [%.2f$] - [ID: %d]", this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost(), this.getId());
	}
	
	@Override
	public void play() {
		if (this.getLength() <= 0 ) {
			System.out.println("Can't play " + this.getTitle() + " since the length of this DVD is smaller or equal to 0");
		}
		else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	}
		
} 
