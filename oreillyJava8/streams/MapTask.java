package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Car {
	private String number;
	private int year;
	
	Car (String number, int year) {
		this.number = number;
		this.year = year;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}

public class MapTask {

	public static void main(String[] args) {
		List<String> ls = Stream.of("a", "b", "c")
				.map(str -> str.toUpperCase())  // Allows apply an action to each object 
				.collect(Collectors.toList());  // Example 3-9. Converting strings to uppercase using map
		System.out.println(ls);
		
//		Stream.map(condition).anyMatch(); // Same result as with Stream.anyMatch(null);
		

		
		
		// Classic version of solution
		List<Car> lc = Arrays.asList(new Car("AA1111BX", 2007),
	            new Car("AK5555IT", 2010),
	            new Car(null, 2012),
	            new Car("", 2015),
	            new Car("AI3838PP", 2017));
		for (Car car : lc) {
			if (car.getYear()>2010) {
				if (car.getNumber()!=null && !car.getNumber().isEmpty()) {
					System.out.println(car.getNumber());
				}
			}
		}
		// Stream filter + map() bellow
		lc.stream()
			.filter(c -> c.getYear()>2010)
			.map(c -> c.getNumber())
			.filter(s -> s != null && !s.isEmpty())
			.forEach(System.out::println);
		
		
	}
}
