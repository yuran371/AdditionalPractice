package dateAndTime;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Создать объект LocalDate, представляющий собой сегодняшнюю
 * дату. Преобразовать дату в строку вида "31.12.2023". Вывести		// с наступающим)
 * эту строку на консоль
 */
public class SecondTask {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formatted = now.format(formatter);
		System.out.println(formatted);	
	}
}
