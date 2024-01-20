package dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/*
 * Даны два объекта из пятого задания.
 * Подсчитать кол-во секунд между полуночью первой датой 
 * и полуночью второй.
 */
public class SixthTask {
	public static void main(String[] args) {
		LocalDateTime now = LocalDate.now().atStartOfDay();
		LocalDateTime localDate = LocalDate.of(2018, 07, 07).atStartOfDay();
		long difference = ChronoUnit.SECONDS.between(now, localDate);
		System.out.println(difference);
	}
}
