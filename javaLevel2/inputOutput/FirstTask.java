package inputOutput;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTask {
	public static void main(String[] args) throws IOException {
		Path path = Path.of("C:\\Users\\Oleg\\git\\AdditionalPractice\\javaLevel2\\inputOutput\\", "poem.txt");
		File file = Path.of("C:\\Users\\Oleg\\git\\AdditionalPractice\\javaLevel2\\inputOutput\\", "poem.txt").toFile();
		FileInputStream in = new FileInputStream(file);

		List<String> allLines = Files.readAllLines(path);
		ArrayList<String> listOfWords = new ArrayList<>();
		for(String line : allLines) {
			for(String word : line.split("\\s")) {
				listOfWords.add(word);
			}
		}
		List<String> list = listOfWords.stream()
				.filter(str -> str.matches("(^(?ui:[аеёиоуыэюя]).*)"))
				.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
}
