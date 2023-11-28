package libraries.exersizesOfChapter4;

import java.util.stream.Stream;

import streams.utilityClasses.Artist;

import static java.util.stream.Stream.concat;

import java.util.List;

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


class PerformanceExercise implements Performance {
    private String name;
    private List<Artist> musicians;

    public PerformanceExercise(String name, List<Artist> musicians) {
        this.name = name;
        this.musicians = musicians;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    public static void main(String[] args) {
        // Create a Concert instance
    	PerformanceExercise concert = new PerformanceExercise("Symphony Orchestra", List.of(
                new Artist("John Doe", "Instrumentalist"),
                new Artist("Jane Doe", "Singer"),
                new Artist("Bob Smith", "Conductor")
        ));

        // Get the name of the concert
        String concertName = concert.getName();
        System.out.println("Concert Name: " + concertName);

        // Get all musicians involved in the concert
        Stream<Artist> allMusicians = concert.getAllMusicians();
        System.out.println("All Musicians:");

        // Print each musician's name and role
        allMusicians.forEach(artist ->
                System.out.println("Name: " + artist.getName() + ", Role: "));
    }
}

