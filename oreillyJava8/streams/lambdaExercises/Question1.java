package streams.lambdaExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streams.example3_19.Album;
import streams.example3_19.Artist;

public class Question1 {
	public static void main(String[] args) {
	}
	// a. A function that adds up numbers, i.e., int addUp(Stream<Integer> numbers)
	public int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (x, y) -> x+y);
	}
	// b. A function that takes in artists and returns a list of strings with their names and places of origin
	public List<String> nameAndOrigins (List<Artist> artists) {
		return artists.stream()
				.flatMap(x -> Stream.of(x.getName(), x.getNationality()))
				.collect(Collectors.toList());
	}
	// c. A function that takes in albums and returns a list of albums with at most three tracks
	public List<Album> albumsWithOnlyThreeTracksAlbums(List<Album> albums) {
		return albums.stream()
//				.flatMap(tracks -> tracks)
				.filter(x -> x.getTrackList().size()<=3)
				.collect(Collectors.toList());
	}
}
