package streams.utilityClasses;

import java.util.List;

public class Album {
	private List<Track> trackList;

	public Album () {
		
	}
	public Album (List<Track> trackList) {
		this.trackList = trackList;
	}
	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

	@Override
	public String toString() {
		return "Album [TrackList=" + trackList + "]";
	}
}
