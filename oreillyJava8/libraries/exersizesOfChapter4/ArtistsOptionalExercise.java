package libraries.exersizesOfChapter4;

import java.util.List;
import java.util.Optional;

import streams.utilityClasses.Artist;


/*
 *	  Take a look at the Artists domain class in Example 4-26, which represents a group
 *	of artists. Your assignment is to refactor the getArtist method in order to return
 *	an Optional<Artist>. It contains an element if the index is within range and is an
 *	empty Optional otherwise. Remember that you also need to refactor the getArtistName
 *  method, and it should retain the same behavior.
 */

public class ArtistsOptionalExercise {
	private List<Artist> artists;

	public ArtistsOptionalExercise(List<Artist> artists) {
		this.artists = artists;
	 }

	public Optional<Artist> getArtist(int index) {				
		if (index < 0 || index >= artists.size()) {
			return Optional.empty();
		}
		return Optional.of(artists.get(index));
	}

	public String getArtistName(int index) {
			Optional<Artist> artist = getArtist(index);
			return artist.map(art -> art.getName())
					.orElse("unknown");
	}
	
}
