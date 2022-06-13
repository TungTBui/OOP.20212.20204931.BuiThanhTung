package hust.soict.dsai.aims.aims;
import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.utils.MemoryDaemon;

public class Aims {
	
	public static void main(String[] args) {
		
//		Thread daemonThread = new Thread(new MemoryDaemon());
//		daemonThread.setDaemon(true);
//		daemonThread.start();
		
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
		
		
		Cart cart = new Cart();
		cart.addMedia(dvd10);
		cart.addMedia(dvd1);
		cart.addMedia(dvd5);
		cart.addMedia(dvd6);
		
		aimsProject(cart, store);
		
	
	}
	
	// The main menu
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// The store menu
	public static void storeMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. See a medium’s details");
	System.out.println("2. Add a medium to cart");
	System.out.println("3. See current cart");
	System.out.println("4. Play a medium in the store");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");	
	}
	
	// The cart menu
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Media in cart");
		System.out.println("2. Sort Media in cart");
		System.out.println("3. Remove medium from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");	
	}
	
	// The update store menu
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a medium to the store");
		System.out.println("2. Remove a medium to the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	// Yes or No option menu
	public static void yesNoOption() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Yes");
		System.out.println("2. No, go back");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	// Yes, No or go back menu
	public static void yesNo() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2");
	}
	
	// return the chosen option and check its validity
	public static int chooseOption(int numOfOptions) {
		boolean done = false;
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		while (!done) {
			try {
				option = scanner.nextInt();	
				if (0 <= option & option < numOfOptions) {
					done = true;
				}
			}
			catch (Exception ex) {
				System.out.println("Please enter a value between 0 and " + (numOfOptions-1));
			}
		}
		return option;
	}
	
	// The filter menu
	public static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By ID");
		System.out.println("2. By Title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	// The sort menu
	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title");
		System.out.println("2. By cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	// Handle the see current cart menu
	public static void seeCurrentCart(Cart cart, Store store) {
		cart.print();
		boolean doneWithCurrentCart = false; 
		while (doneWithCurrentCart != true) {
			cartMenu();
			int cartOption = chooseOption(5);
			switch(cartOption) {
				case(0): {
					doneWithCurrentCart = true;
					break;
				}
				case(1): {
					filterMenu();
					int filterOption = chooseOption(3);
					if (filterOption == 1) {
						System.out.println("Enter the ID of the DVD you want to filter.");
						Scanner filterScanner = new Scanner(System.in);
						int id = filterScanner.nextInt();
						cart.idSearch(id);
						
					}
					else if (filterOption == 2) {
						System.out.println("Enter the title of the DVD you want to filter.");
						Scanner filterScanner = new Scanner(System.in);
						String title = filterScanner.nextLine();
						cart.titleSearch(title);
						
					}

					break;
				}
				case(2): {
					sortMenu();
					int sortOption = chooseOption(3);
					if (sortOption == 1) {
						cart.sortByTitle();
						cart.print();
					}
					else if (sortOption == 2) {
						cart.sortByCost();
						cart.print();
					}
//					exit = true;
					break;
				}
				case(3): {
					System.out.println("Enter the title of the DVD you want to remove.");
					Scanner titleScanner = new Scanner(System.in);
					String title = titleScanner.nextLine();
					ArrayList<Media> mediaFound = cart.titleSearch(title);
					for (Media media: mediaFound) {
						cart.removeMedia(media);
					}
					
					System.out.println("The current cart:");
					cart.print();
					
					break;
				}
				case(4): {
					System.out.println("An order has been created");
					if (cart.qtyOrdered >= 5) {
						Media luckyItem = cart.getALuckyItem(store);
						cart.addMedia(luckyItem);
						cart.print();
					}
					
					cart = null;
					doneWithCurrentCart = true;
					break;
				}
			}
		}
	}
	
	// addDVD menu
	public static void addMedia(Cart cart, ArrayList<Media> mediaFound) {
		for (Media media: mediaFound) {
			System.out.println(media);
			System.out.println("Do you want to add this DVD?");
			yesNo();
			int dvdAddOption = chooseOption(3);
			switch (dvdAddOption) {
				case(0): {
					break;
				}
				case(1): {
					cart.addMedia(media);
					break;
				}
				case(2): {
					break;
				}
			}
		}	
	}
	

	public static void aimsProject(Cart cart, Store store) {
		
		boolean exit = false;

		while (exit != true) {
			showMenu();
			int menuOption = chooseOption(4);
			switch (menuOption) {
				case(0): {
					exit = true;
					break;
				}
				case(1): {
					store.print();
					boolean doneWithViewStore = false; 
					while (doneWithViewStore != true) {
						storeMenu();
						int storeOption = chooseOption(5);
						switch (storeOption) {
							case(0): {
								doneWithViewStore = true;
								break;
							}
							case(1): {
								System.out.println("Please enter the title of that medium");
								Scanner mediaScanner = new Scanner(System.in);
								String mediaTitle = mediaScanner.nextLine();
								ArrayList<Media> mediaFound = store.titleSearch(mediaTitle);

								if (mediaFound.size() > 0) {
									System.out.println("Do you want to add these media to the cart?");
									yesNoOption();
									int mediaAddOption = chooseOption(3);
									switch (mediaAddOption) {
										case(0): {
											exit = true;
											break;
										}
										case(1) : {
											addMedia(cart, mediaFound);
											System.out.println("Now you will go back to the View store menu");
											break;
										}
										case(2) : {
											break;
										}
									}

								}
								
								break;
							}
		
							case(2): {
								System.out.println("Please enter the title of the medium you want to add");
								Scanner mediaScanner = new Scanner(System.in);
								String mediaTitle = mediaScanner.nextLine();
								ArrayList<Media> mediaFound = store.titleSearch(mediaTitle);
								addMedia(cart, mediaFound);
								System.out.println("The cart has been updated. There are currently " + cart.qtyOrdered + " media in the cart.");

								break;
							}
							case(3): {
								seeCurrentCart(cart, store);
								break;
							}
							case (4): {
								System.out.println("Here's the list of media that you could play:");
								store.printPlayableMedia();
								System.out.println("Please select the ID of the media you want to play");
								Scanner idScanner = new Scanner(System.in);
								int playID = idScanner.nextInt();
								store.playID(playID);
								break;
							}
						}
					}
					
					break;
				}
				case(2): {
					boolean doneWithUpdateStore = false; 
					while (doneWithUpdateStore != true) {
						updateStore();
						int updateOption = chooseOption(3);
							switch (updateOption) {
							case(0): {
								doneWithUpdateStore = true;
								break;
							}
							case(1): {
								System.out.println("Please enter the title of the Medium you want to add");
								Scanner mediaScanner = new Scanner(System.in);
								String mediaTitle = mediaScanner.nextLine();
								DigitalVideoDisc media = new DigitalVideoDisc(mediaTitle);
								store.addMedia(media);
								System.out.println("The store has been updated. There are currently " + store.itemsInStore.size() + " media in the store.");		
								break;
							}
							case(2): {
								System.out.println("Please enter the id of the medium you want to remove");
								Scanner idScanner = new Scanner(System.in);
								int mediaID = idScanner.nextInt();
								Media mediaFound = store.idSearch(mediaID);
								store.removeMedia(mediaFound);
								System.out.println("The store has been updated. There are currently " + store.itemsInStore.size() + " media in the store.");							
								break;
							}
						
						}
					}	
					break;
				}
				case(3): {
					seeCurrentCart(cart, store);
					break;
				}
			}
		}
	}
}



