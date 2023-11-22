package streams.lambdaExercisesChapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question6 {
	public static void main(String[] args) {
		System.out.println(Question6.AmountOflowercase("Sd7jjDj"));
	}
	
	// Question6: Count the number of lowercase letters in a String (hint: look at the chars method on String).
	public static int AmountOflowercase(String str) {
		return (int) str.chars()
				.filter(Character::isLowerCase)
				.count();
	}
}
