package hust.soict.dsai.aims.screen.manager;

import javax.swing.JLabel;

import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStore extends AddItemToStore{
	
	private StoreManagerScreen sms;
	
	public AddDigitalVideoDiscToStore(Store store, StoreManagerScreen sms) {
		super(store, sms);
		addMediaContent(new JLabel("ADD DVD"),new JLabel[]{new JLabel("Title: "), new JLabel("Category: "), new JLabel("Director: "), new JLabel("Length: "), new JLabel("Cost: ")});
	}

}
