package hust.soict.dsai.test.book;

import hust.soict.dsai.aims.exception.NegativeValueException;
import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) throws NullPointerException, NegativeValueException {
		
		Book book = new Book("Why we sleep", "Self-help", 15.45f);
		
		book.addAuthor("Matthew Walker");
		book.addAuthor("James Walker");
		book.setContent("Do you think you got enough sleep this past week? Can you recall the last time you woke up feeling refreshed?");
		System.out.println(book.toString());
	}

}
