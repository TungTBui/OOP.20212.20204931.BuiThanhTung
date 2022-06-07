package hust.soict.dsai.test.utils;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class DVDTest {

	public static void main(String[] args) {
		
		Media media1 = new Disc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		Media media2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.6f);
		Media media3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5.6f);
		Media media4 = new Disc("DDDD", "dddd", "dddd", 4, 5.6f);
		Media media5 = new CompactDisc("EEEE", "eeee", 5.6f, "eeee");
		
		System.out.println(MediaUtils.compareByCost(media1, media2));
		System.out.println(MediaUtils.compareByTitle(media5, media3));
		
		ArrayList<Media> media = new ArrayList<Media>();
		media.add(media1);
		media.add(media2);
		media.add(media3);
		media.add(media4);
		media.add(media5);
		
		ArrayList<Media> sorted = MediaUtils.sortByCost(media);
		System.out.println("sort by cost: ");
		for (Media mediaInSorted: sorted) {
			System.out.println(mediaInSorted.toString());
		}

		sorted = MediaUtils.sortByTitle(media);
		System.out.println("sort by title: ");
		for (Media mediaInSorted: sorted) {
			System.out.println(mediaInSorted.toString());
		}

		
//		sorted = MediaUtils.sortByLength(new Media[] {Media1, Media2, Media3, Media4, Media5});
//		System.out.println("sort by length: ");
//		for (int i = 0; i < sorted.length; i++) {
//			System.out.println(sorted[i].toString());
//		}
	}

}
