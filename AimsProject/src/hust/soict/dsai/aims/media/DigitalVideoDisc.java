package hust.soict.dsai.aims.media;
import java.time.LocalDate;

import hust.soict.dsai.aims.exception.NegativeValueException;
import hust.soict.dsai.aims.exception.PlayerException;

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

	public DigitalVideoDisc(String title, String category, float cost) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
//		dateAdded = LocalDate.now();
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
		if (director == null || director == "") {
			throw new NullPointerException("Director cannot be empty");
		}
		else {
			this.director = director;
		}
//		dateAdded = LocalDate.now();
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
		if (director == null || director == "") {
			throw new NullPointerException("Director cannot be empty");
		}
		else {
			this.director = director;
		}
		this.length = length;
//		dateAdded = LocalDate.now();

	}
	public String toString() {
		return String.format("DVD: [%s] - [%s] - [%s] - [Length: %d] - [%.2f$] - [ID: %d]", this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost(), this.getId());
	}
	
	@Override
	public String play() throws PlayerException {
		
		if (this.getLength() > 0 ) {
			return "Playing DVD: " + this.getTitle() + " " + "\nDVD's length: " + this.getLength();
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
		
} 
