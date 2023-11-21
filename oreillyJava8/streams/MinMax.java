package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

class Track {
	private String name;
	private int duration;
	
	Track (String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Track [name=" + name + ", duration=" + duration + "]";
	}
	
	
}

public class MinMax {
	public static void main(String[] args) {
		List<Track> listOfTracks = Arrays.asList(
				new Track("Bakai", 524),
				new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451)
				);
		Optional<Integer> shortestTrack = listOfTracks.stream()
				.map(x -> x.getDuration())
				.min(Comparator.comparing(x -> x));
		System.out.println(shortestTrack);
		System.out.println("Other solution bellow");
		Track shortestTrack2 = listOfTracks.stream()
				.min(Comparator.comparing(Track::getDuration))		// or use: .min(Comparator.comparing(x -> x.getDuration()))
				.get();
		System.out.println(shortestTrack2.toString());
		
		System.out.println("--------Primitive example bellow-----------");
	    List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
	    Integer expectedResult = 89;
	    // then
	    Integer max = listOfIntegers
	      .stream()
	      .mapToInt(v -> v)
	      .max().orElseThrow(NoSuchElementException::new);
	    System.out.println(max);
	}
}
