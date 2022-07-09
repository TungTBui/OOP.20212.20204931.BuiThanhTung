package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.exception.NegativeValueException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class TestToString {
	public static void main (String[] args) throws NullPointerException, NegativeValueException {
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
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

		System.out.println("-----------------------");

		List<Media> mediae = new ArrayList<Media>();
		mediae.add(dvd);
		mediae.add(cd);
		mediae.add(book);
		
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}

}
