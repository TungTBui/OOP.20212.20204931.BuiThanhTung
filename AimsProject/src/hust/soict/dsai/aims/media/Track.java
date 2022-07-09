package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track>{

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	@Override
	public String play() throws PlayerException{
		if (this.getLength() > 0) {
			String returnPlay = "Playing track: " + this.getTitle() + "\nTrack length: " + this.getLength();
			return returnPlay;
		}
		else {
			throw new PlayerException("ERROR: Track's length is non-positive");
		}	
	}

	public String toString() {
		return String.format("Track: [%s] - [Length: %s]", this.getTitle(), this.getLength());
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Track)) {
			return false;
		}
		else {
			return ((this.getLength() == ((Track) obj).getLength()) & (this.getTitle() == ((Track) obj).getTitle()));
		}
	}

	@Override
	public int compareTo(Track track) {
		return this.getTitle().compareTo(track.getTitle());
	}
}
