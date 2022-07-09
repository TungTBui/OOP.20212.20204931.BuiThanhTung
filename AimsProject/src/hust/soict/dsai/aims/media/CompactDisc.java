package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.NegativeValueException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String category, float cost, String artist) throws NullPointerException, NegativeValueException {
		super(title, category, cost);
	
		if (artist == null || artist == "") {
			throw new NullPointerException("Artist cannot be empty");
		}
		
		else {
			this.artist = artist;
		}
	}
	
	public int getLength() {
		int length = 0;
		for (Track track: tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track is already in the list of tracks.");
		}
		else {
			tracks.add(track);
			System.out.println("The track has been added to the list of tracks");
		}
	}
	
	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("The track does not exist in the list of tracks.");
		}
		else {
			tracks.remove(track);
			System.out.println("The track has been removed from the list of tracks");
		}
	}

	@Override
	public String play() throws PlayerException {
		if (this.getLength() > 0) {
			StringBuffer returnPlay = new StringBuffer();
			returnPlay.append(String.format("Compact Disc [%s] - [%s] - [%s]- [Length: %d] - [ID: %d]", this.getTitle(), this.getCategory(), this.getArtist(), this.getLength(), this.getId()));
			returnPlay.append("\nPlaying Compact disc.......... ");
			for (Track track: tracks) {
				try {
					returnPlay.append("\n" + track.play());
				} catch (PlayerException e) {
					throw e;
				}
			}
			return returnPlay.toString();
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	public String toString() {
		StringBuffer cdString = new StringBuffer();
		cdString.append(String.format("Compact Disc: [%s] - [%s] - [%s] - [Length: %d] - [%.2f$] - [ID: %d]", this.getTitle(), this.getCategory(), this.getArtist(), this.getLength(), this.getCost(), this.getId()));
		for (Track track: tracks) {
			cdString.append("\n" + track.toString());
		}
		return cdString.toString();
	}

}
