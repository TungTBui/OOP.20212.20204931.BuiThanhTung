package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category, cost);
		this.artist = artist;
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
	public void play() {
		System.out.println(String.format("Compact Disc [%s], [%s], [%s]", this.getTitle(), this.getCategory(), this.getArtist()));
		System.out.println("Playing Compact disc.......... ");
		for (Track track: tracks) {
			track.play();
		}
	}

}
