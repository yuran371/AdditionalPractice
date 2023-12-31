package dateAndTime;

import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/*
 * Дана строка вида "26-03-1968T09:24". Получить LocalDateTime,
 * представляющий собой дату, полученную из этой строки
 */
public class ThirdTask {

	public static void main(String[] args) {
		String str = "26-03-1968T09:24";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
		LocalDateTime parsedDate = LocalDateTime.parse(str, formatter);
//		LocalDateTime localDateTime = LocalDateTime.parse(str);
//		String formated = localDateTime.format(formatter);
		System.out.println(parsedDate);
	}
}
