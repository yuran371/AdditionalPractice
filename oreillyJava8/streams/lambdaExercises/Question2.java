package streams.lambdaExercises;

import java.util.List;

import streams.example3_19.Artist;

/*
 *  Iteration. Convert this code sample from using external iteration to internal iteration:
 *	int totalMembers = 0;
 *	for (Artist artist : artists) {
 *		Stream<Artist> members = artist.getMembers();
 *	totalMembers += members.count();
 *	}
 */

public class Question2 {
	public static void main(String[] args) {
		
	}
	public int iterateOverLitsArtists (List<Artist> artists) {
		return artists.stream()
				.map(x -> x.getMembers().count())
				.reduce((long) 0, (x, y) -> x+y)	// or: .reduce((long) 0, Long::sum)
				.intValue();
	}
}
