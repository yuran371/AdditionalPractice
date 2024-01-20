package inputOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Задан файл с текстом, найти и вывести в консоль все слова, 
 * для которых последняя буква одного слова совпадает с первой 
 * буквой следующего
 */
public class SecondTask {
	public static void main(String[] args) throws IOException {
		Path path = Path.of("C:\\Users\\Oleg\\git\\AdditionalPractice\\javaLevel2\\inputOutput\\", "poem.txt");
		Stream<String> file = Files.lines(path);

		String str = file
//		.map(str -> String.join("\\n", str))
//		.map(x -> x.split("\\s"))
//		.map(arr -> Arrays.toString(arr))
//		.map(Object::toString)
				.map(stri -> stri.replaceAll("[-+.—^;:,!]+", ""))
//		.filter(strr -> strr.matches("(^(?ui:[аеёиоуыэюя]).*)"))
//		.filter(str -> str.startsWith("У"))
//		.collect(Collectors.toCollection(ArrayList::new))
//		.collect(Collectors.toList())
				.collect(Collectors.joining(" "))
//		.forEach(System.out::println)
		;
		List<String> myList = new ArrayList<String>(Arrays.asList(str.split("\\s+")));
//		myList.stream().forEach(System.out::println);
		myList.stream().reduce((s1, s2) -> {
			if(s1.charAt(s1.length()-1)==s2.charAt(0)) {
				System.out.println(s1 + " -> " + s2);
		}
			return s2;
		})
//			.forEach(System.out::println)
//		.collect(Collectors.toList())
//		.collect( Collectors.joining())
//				.collect(Collectors.toCollection(ArrayList::new))
//				.forEach(System.out::println)
		;

//		System.out.println(str);

	}
}
