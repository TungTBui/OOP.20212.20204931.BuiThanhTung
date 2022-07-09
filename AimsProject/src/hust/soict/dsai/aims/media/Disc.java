package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.NegativeValueException;

public class Disc extends Media {

	private int length;
	private String director;
	
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title, String category, int length, float cost) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
		try {
			this.length = length;
			if (this.length < 0) {
				throw new NegativeValueException("Cost must be > 0");
			}
		}
		catch (NumberFormatException e) {
			throw new NumberFormatException("Length must be a number");
		}
	}
	
	public Disc(String title, String category, String director, int length, float cost) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public Disc(String title, String category, float cost) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
	}
	

}
