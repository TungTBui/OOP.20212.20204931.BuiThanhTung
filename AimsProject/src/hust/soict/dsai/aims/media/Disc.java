package hust.soict.dsai.aims.media;

public class Disc extends Media {

	private int length;
	private String director;
	
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title, String category, int length, float cost) {
		super(title, category, cost);
		this.length = length;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	

}
