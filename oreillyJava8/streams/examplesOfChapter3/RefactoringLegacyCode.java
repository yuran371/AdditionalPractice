package streams.examplesOfChapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import streams.utilityClasses.Album;
import streams.utilityClasses.Track;

// example3_19

class LegacyCode {												// class which contains legacy code (without functions)
	public Set<String> findLongTracks(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		for (Album album : albums) {
			for (Track track : album.getTrackList()) {
				if (track.getDuration() > 1500) {
					String name = track.getName();
					trackNames.add(name);
				}
			}
		}
		return trackNames;
	}
}

public class RefactoringLegacyCode {
	public static void main(String[] args) {
		List<Track> listOfTracks1 = Arrays.asList(
				new Track("Bakai", 524),
				new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451)
				);
		List<Track> listOfTracks2 = Arrays.asList(
				new Track("Duhast", 123),
				new Track("Ich mil", 321),
				new Track("Duhchlend", 444)
				);
		List<Track> listOfTracks3 = Arrays.asList(
				new Track("Metamarphosis", 152),
				new Track("ZQC", 1590),
				new Track("ThreeSecToMars", 3)
				);
		List<Album> listOfAlbums = new ArrayList<Album>();
		Album album1 = new Album(listOfTracks1);
		Album album2 = new Album(listOfTracks2);
		Album album3 = new Album(listOfTracks3);
//		album1.setTrackList(listOfTracks1);
//		album2.setTrackList(listOfTracks2);
//		album3.setTrackList(listOfTracks3);
		listOfAlbums.add(album1);
		listOfAlbums.add(album2);
		listOfAlbums.add(album3);
		System.out.println("Just check: " + album1.toString());
		System.out.println("Just check: " + album2.toString());
		System.out.println("Just check: " + album3.toString());
		System.out.println("---------------");
		System.out.println("Just check: " + listOfAlbums.toString());
		System.out.println("---------------");
		List<String> ls = listOfAlbums.stream()
				.flatMap(album -> album.getTrackList().stream())
				.filter(track -> track.getDuration()<5)
				.map(trackName -> trackName.getName())
				.collect(Collectors.toList());
		System.out.println("Code with functions (without functions); tracks which duration less then 5 sec: " + ls);
		System.out.println("---------------");
		LegacyCode legacyCode = new LegacyCode();
		System.out.println("legacy code (without functions); tracks which duration more then 1500 sec: " 
									+ legacyCode.findLongTracks(listOfAlbums));
	}
}
