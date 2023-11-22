package streams.lambdaExercises;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question6and7 {

	public static void main(String[] args) {
		System.out.println(Question6and7.AmountOflowercase("Sd7jjDj"));
		System.out.println("------------");
        List<String> stringList = List.of("Hello", "World", "abc", "Java", "programming");
        
        Optional<String> result = largestAmountOfLowercase(stringList);
        
        result.ifPresent(s -> System.out.println("String with the largest number of lowercase letters: " + s));
	}
	
	
	// Question6: Count the number of lowercase letters in a String (hint: look at the chars method on String).
	public static int AmountOflowercase(String str) {
		return (int) str.chars()
				.filter(Character::isLowerCase)
				.count();
	}
	
	/*  Question7:  Find the String with the largest number of lowercase letters from a
	 *				List<String>. You can return an Optional<String> to account for the empty list
	 *				case.
	*/
	
	// via previously method
	public static Optional<String> largestAmountOfLowercase(List<String> list) {
		return list.stream()
				.max(Comparator.comparingInt(Question6and7::AmountOflowercase));
	}
	
	// via one method
    public static Optional<String> findStringWithLargestLowercase(List<String> stringList) {
        return stringList.stream()
                .max((s1, s2) -> {
                    long count1 = s1.chars().filter(Character::isLowerCase).count();
                    long count2 = s2.chars().filter(Character::isLowerCase).count();
                    return Long.compare(count1, count2);
                });
    }
}
