package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class main {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Princess Mononoke",
				"Animation", "Hayao Miyazaki", 18.99f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away",
				"Animation", "Hayao Miyazaki", 18.15f);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Tenet",
				"Action", "Christopher Nolan", 22.45f);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("2001: A Space Odyssey",
				"Science Fiction", "Stanley Kubrick", 15.99f);
		
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Taxi Driver",
				"Action", "Martin Scorsese", 14.59f);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Catch Me If You Can",
				"Action", "Steven Spielberg", 15.22f);
		
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Pulp Fiction",
				"Comedy & Action", "Quentin Tarantino", 20.99f);
		
		CompactDisc cd = new CompactDisc("Twin Fantasy", "Rock", 11.95f, "Car Seat Headrest");
		
		Track track1 = new Track("My Boy (Twin Fantasy)", 3);
		Track track2 = new Track("Beach Life-In-Death", 12);
		Track track3 = new Track("Stop Smoking", 1);
		Track track4 = new Track("Sober To Death", 5);
		Track track5 = new Track("Nervous Young Inhumans", 4);
		Track track6 = new Track("Bodys", 6);
		Track track7 = new Track("Cute Thing", 5);
		Track track8 = new Track("High to Death", 6);
		Track track9 = new Track("Famous Prophets (Minds)", 10);
		Track track10 = new Track("Twin Fantasy (Those Boys)", 6);
		
		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3);
		cd.addTrack(track4);
		cd.addTrack(track5);
		cd.addTrack(track6);
		cd.addTrack(track7);
		cd.addTrack(track8);
		cd.addTrack(track9);
		cd.addTrack(track10);

		Book book = new Book("Why we sleep", "Self-help", 15.45f);	
		book.addAuthor("Matthew Walker");
		book.addAuthor("James Walker");
		book.setContent("Do you think you got enough sleep this past week? Can you recall the last time you woke up feeling refreshed?");

		
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(dvd6);
		store.addMedia(dvd7);
		store.addMedia(dvd8);
		store.addMedia(dvd9);
		store.addMedia(dvd10);
		store.addMedia(cd);
		store.addMedia(book);
		
		new StoreManagerScreen(store);
	}

}
