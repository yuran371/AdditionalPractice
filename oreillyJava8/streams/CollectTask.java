package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Just simple usage of collect method */

class CollectTask {
	public static void main(String[] args) {
		List<String> ls = Stream.of("One", "1One", "Two", "2Two")
				.collect(Collectors.toList());   // Without prior creation we placed some String there (using static method .of()) and collect to ls (List)
		List<String> sl = ls.stream().filter(s -> Character.isDigit(s.charAt(0)))
				.collect(Collectors.toList());  // Make the stream and filtering where the first char is digit, then collect within eager method  
		
		
		List<String> vowels = List.of("a", "e", "i", "o", "u");

		// sequential stream - nothing to combine
		StringBuilder result = vowels.stream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append(";").append(b));
		System.out.println(result.toString());

		// parallel stream - combiner is combining partial results
		StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append(";").append(b)); // collect(supplier, accumulator, combiner): 1. создает объект коллекции; 
													// 2. добавляет элемент в коллекцию; 3. бинарная функция, которая объединяет два объекта
		System.out.println(result1.toString()); 


		String result2 = vowels.parallelStream()
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		System.out.println(result2); // synt sugar 
	}

}

