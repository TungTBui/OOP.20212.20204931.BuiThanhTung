package hust.soict.dsai.aims.screen.manager;

import javax.swing.JLabel;

import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStore extends AddItemToStore{
	
	private StoreManagerScreen sms;
	
	public AddCompactDiscToStore(Store store, StoreManagerScreen sms) {
		super(store, sms);
		addMediaContent(new JLabel("ADD CD"),new JLabel[]{new JLabel("Title: "), new JLabel("Category: "), new JLabel("Cost: "), new JLabel("Artist: "), new JLabel("Number of tracks: ")});
	}
}
