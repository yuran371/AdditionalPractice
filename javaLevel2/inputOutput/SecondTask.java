package inputOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondTask {
	public static void main(String[] args) throws IOException {
		Path path = Path.of("C:\\Users\\Oleg\\git\\AdditionalPractice\\javaLevel2\\inputOutput\\", "poem.txt");
		Stream<String> file = Files.lines(path);
		
		String str = file
//		.map(str -> String.join("\\n", str))
//		.map(x -> x.split("\\s"))
//		.map(arr -> Arrays.toString(arr))
//		.map(Object::toString)
		.map(stri -> stri.replaceAll("[-+.—^;:,!]+",""))
//		.filter(strr -> strr.matches("(^(?ui:[аеёиоуыэюя]).*)"))
//		.filter(str -> str.startsWith("У"))
//		.collect(Collectors.toCollection(ArrayList::new))
//		.collect(Collectors.toList())
		.collect( Collectors.joining(" "))
//		.forEach(System.out::println)
		;
		ArrayList<?> sssss = Stream.of(str)
				.filter(strr -> strr.matches("(^(?ui:[аеёиоуыэюя]).*)"))
				.map(Collectors::joining)
//		.collect( Collectors.joining())
				.collect(Collectors.toCollection(ArrayList::new))
//				.forEach(System.out::println)
		;
		System.out.println(sssss);
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}
		
		
//		file.stream(x -> x.split("\\s")).filter(null);
//		file.
//		List<Object> of = List.of(file.toArray());
//		file.filter(str -> str.);
//		file.forEach(System.out::println);
//		if ()
		
	}
}
