package hust.soict.dsai.aims.screen.manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class PlayDialog extends JDialog{
	
	private Media media;
	
	public PlayDialog(Media media) {
		this.media = media;
		setTitle("Playing media");
		addContent();
		setSize(600, 400);
		setLocationRelativeTo(null);
	}
	
	public Media getMedia() {
		return media;
	}
	
	public void addContent() {
		JPanel playingPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		String[] lines = ((Playable) media).play().split("\n");
	
		for (int i = 0; i < lines.length; i++) {	
		    JLabel label = new JLabel(lines[i]);
		    c.gridx = 0;
		    c.gridy = i*lines.length;
		    playingPanel.add(label, c);
		};
		
		add(playingPanel);
		this.setContentPane(playingPanel);
	}

}
