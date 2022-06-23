package hust.soict.dsai.aims.screen.manager;

import javax.swing.JLabel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStore extends AddItemToStore{

	private StoreManagerScreen sms;
	
	public AddBookToStore(Store store, StoreManagerScreen sms) {
		super(store, sms);
		addMediaContent(new JLabel("ADD BOOK"),new JLabel[]{new JLabel("Title: "), new JLabel("Category: "), new JLabel("Cost: ")});
	}
	
}
