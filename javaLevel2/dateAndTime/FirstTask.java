package dateAndTime;

import java.time.LocalDateTime;

/*
 * Создать объект LocalDateTime = 25.06.2020 19:47.
 * Создать на основе его объект +3 месяца.
 * Вывести на консоль содержащиеся в нем объекты LocalDate & LocalTime
 */
public class FirstTask {
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.of(2020, 06, 25, 19, 47);
		LocalDateTime plusMonths = localDateTime.plusMonths(3);
		System.out.println(plusMonths.toLocalDate() +" " + plusMonths.toLocalTime());
	}
}
