package hust.soict.dsai.aims.aims;
import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addDVD(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Princess Mononoke",
				"Animation", "Hayao Miyazaki", 18.99f);
		store.addDVD(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away",
				"Animation", "Hayao Miyazaki", 18.15f);
		store.addDVD(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Tenet",
				"Action", "Christopher Nolan", 22.45f);
		store.addDVD(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("2001: A Space Odyssey",
				"Science Fiction", "Stanley Kubrick", 15.99f);
		store.addDVD(dvd7);
		
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Taxi Driver",
				"Action", "Martin Scorsese", 14.59f);
		store.addDVD(dvd8);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Catch Me If You Can",
				"Action", "Steven Spielberg", 15.22f);
		store.addDVD(dvd9);
		
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Pulp Fiction",
				"Comedy & Action", "Quentin Tarantino", 20.99f);
		store.addDVD(dvd10);

		aimsProject(new Cart(), store);
		
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
	System.out.println("1. See a DVD’s details");
	System.out.println("2. Add a DVD to cart");
	System.out.println("3. See current cart");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");	
	}
	
	// The cart menu
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");	
	}
	
	// The update store menu
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a DVD to the cart");
		System.out.println("2. Remove a DVD to the cart");
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
	public static void seeCurrentCart(Cart cart) {
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
					cart.removeDigitalVideoDisc(title);
					System.out.println("The current cart:");
					cart.print();
					
					break;
				}
				case(4): {
					System.out.println("An order has been created");
					cart = null;
					break;
				}
			}
		}
	}
	
	// addDVD menu
	public static void addDVD(Cart cart, ArrayList<DigitalVideoDisc> dvdFound) {
		for (DigitalVideoDisc dvd: dvdFound) {
			System.out.println(dvd);
			System.out.println("Do you want to add this DVD?");
			yesNo();
			int dvdAddOption = chooseOption(3);
			switch (dvdAddOption) {
				case(0): {
					break;
				}
				case(1): {
					cart.addDigitalVideoDisc(dvd);
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
						int storeOption = chooseOption(4);
						switch (storeOption) {
							case(0): {
								doneWithViewStore = true;
								break;
							}
							case(1): {
								System.out.println("Please enter the title of that DVD");
								Scanner dvdScanner = new Scanner(System.in);
								String dvdTitle = dvdScanner.nextLine();
								ArrayList<DigitalVideoDisc> dvdFound = store.titleSearch(dvdTitle);

								if (dvdFound.size() > 0) {
									System.out.println("Do you want to add these DVDs to the cart?");
									yesNoOption();
									int dvdsAddOption = chooseOption(3);
									switch (dvdsAddOption) {
										case(0): {
											exit = true;
											break;
										}
										case(1) : {
											addDVD(cart, dvdFound);
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
								System.out.println("Please enter the title of the DVD you want to add");
								Scanner dvdScanner = new Scanner(System.in);
								String dvdTitle = dvdScanner.nextLine();
								ArrayList<DigitalVideoDisc> dvdFound = store.titleSearch(dvdTitle);
								addDVD(cart, dvdFound);
								System.out.println("The cart has been updated. There are currently " + cart.qtyOrdered + " DVDs in the cart.");

								break;
							}
							case(3): {
								seeCurrentCart(cart);
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
								System.out.println("Please enter the title of the DVD you want to add");
								Scanner dvdScanner = new Scanner(System.in);
								String dvdTitle = dvdScanner.nextLine();
								DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle);
								store.addDVD(dvd);
								System.out.println("The store has been updated. There are currently " + store.itemsInStore.size() + " DVDs in the store.");
							
								break;
							}
							case(2): {
								System.out.println("Please enter the id of the DVD you want to remove");
								Scanner dvdScanner = new Scanner(System.in);
								int dvdID = dvdScanner.nextInt();
								DigitalVideoDisc dvdFound = store.idSearch(dvdID);
								store.removeDVD(dvdFound);
								System.out.println("The store has been updated. There are currently " + store.itemsInStore.size() + " DVDs in the store.");
								
								break;
							}
						
						}
					}	
					break;
				}
				case(3): {
					seeCurrentCart(cart);
					break;
				}
			}
		}
	}
}



