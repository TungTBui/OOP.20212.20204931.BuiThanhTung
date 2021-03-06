package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame implements ActionListener{
	private Store store;
	private JPanel viewStorePanel;
	private JPanel currentScreen;
	private JMenuItem addBook;
	private JMenuItem addCD;
	private JMenuItem addDVD;
	private JMenuItem viewStore;
	private JMenu smUpdateStore;
	private JMenu menu;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
//		Container cp = getContentPane();
		setLayout(new BorderLayout());
		add(createNorth(), BorderLayout.NORTH);
		
		viewStorePanel = createCenter();
		add(viewStorePanel, BorderLayout.CENTER);
		currentScreen = viewStorePanel;
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		menu = new JMenu("Options");
		
		viewStore = new JMenuItem("View store");
		viewStore.addActionListener(this);
		menu.add(viewStore);
		
		smUpdateStore = new JMenu("Update Store");
		
		addBook = new JMenuItem("Add Book");
		addCD = new JMenuItem("Add CD");
		addDVD = new JMenuItem("Add DVD");
		
		addBook.addActionListener(this);
		addCD.addActionListener(this);
		addDVD.addActionListener(this);
		
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout((int) store.numItemsInStore/4 + 1, 4, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	public class MediaStore extends JPanel {
		private Media media;
		public MediaStore(Media media) {
			this.media = media;
			this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			if (media instanceof Playable) {
				JButton playButton = new JButton("Play");
				playButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						try {
							if(media instanceof DigitalVideoDisc) {
								DigitalVideoDisc d = (DigitalVideoDisc) media;
								JOptionPane.showMessageDialog(null, d.play());
							}
							else if(media instanceof CompactDisc) {
								CompactDisc c = (CompactDisc) media;
								JOptionPane.showMessageDialog(null, c.play());
							}

						} catch (PlayerException e) {
							System.err.println(e.getMessage());
							JOptionPane.showMessageDialog(null, e.getMessage());
							e.printStackTrace();
						}
					}
					
				});
				container.add(playButton);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	public void switchScreen(JPanel panel1, JPanel panel2) {
		panel1.setVisible(false);
		remove(panel1);
		add(panel2);
		panel2.setVisible(true);
		setCurrentScreen(panel2);
	}
	
	public void setCurrentScreen(JPanel panel) {
		currentScreen = panel;
	}
	
	public JPanel getCurrentScreen() {
		return currentScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBook) {
			switchScreen(currentScreen, new AddBookToStore(store, this));
		}
		if (e.getSource() == addCD) {
			switchScreen(currentScreen, new AddCompactDiscToStore(store, this));
		}
		if (e.getSource() == addDVD) {
			switchScreen(currentScreen, new AddDigitalVideoDiscToStore(store, this));
		}
		if (e.getSource() == viewStore) {
			switchScreen(currentScreen, createCenter());	
		}
	}
}
