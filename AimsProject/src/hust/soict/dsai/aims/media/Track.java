package hust.soict.dsai.aims.media;

import java.time.LocalDate;

import hust.soict.dsai.aims.exception.NegativeValueException;
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
	
	public Track(String title, int length) throws NegativeValueException, NullPointerException {
		if (title == null || title == "") {
			throw new NullPointerException("Title cannot be empty");
		}
		else if (length < 0) {
			throw new NegativeValueException("Length cannot be negative");
		}
		else {
			this.title = title;
			try {
				this.length = length;
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Length must be a number");
			}
		}

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
