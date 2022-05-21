import java.time.LocalDate;

public class DigitalVideoDisc {
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private int id;
	private static int nbDigitalVideoDiscs = 0;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
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
	
}