package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTask {

	public static void main(String[] args) {
		List<String> ls = Stream.of("a", "b", "c")
				.map(str -> str.toUpperCase())  // Allows apply an action to each object 
				.collect(Collectors.toList());  // Example 3-9. Converting strings to uppercase using map
		System.out.println(ls);
		
		Stream.map(condition).anyMatch(); // Same result as with Stream.anyMatch(null);
		

	}
}
