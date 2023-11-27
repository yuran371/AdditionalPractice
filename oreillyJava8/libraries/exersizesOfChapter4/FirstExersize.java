package libraries.exersizesOfChapter4;

import java.util.stream.Stream;

import streams.utilityClasses.Artist;

import static java.util.stream.Stream.concat;

/*
 * 1. Given the Performance interface in Example 4-25, add a method called getAllMu-
 * sicians that returns a Stream of the artists performing and, in the case of groups,
 * any musicians who are members of those groups. For example, if getMusicians
 * returns The Beatles, then you should return The Beatles along with Lennon,
 * McCartney, and so on.
 */

interface Performance {
	 public String getName();
	 public Stream<Artist> getMusicians();
	 
	 public default Stream<Artist> getAllMusicians () {
		return getMusicians().flatMap(artist -> {
            return concat(Stream.of(artist), artist.getMembers());
        });
	}
}

public class FirstExersize {
	public static void main(String[] args) {
		
	}
}
