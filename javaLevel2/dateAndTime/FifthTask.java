package dateAndTime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Создать объект LocalDate с сегодняшней датой.
 * Создать LocalDate = "07.07.2018". Найти разницу
 * в днях между ними.
 */
public class FifthTask {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate localDate = LocalDate.of(2018, 07, 07);
	    long resultDays = ChronoUnit.DAYS.between(localDate, now);

		System.out.println(resultDays);
	}
}
