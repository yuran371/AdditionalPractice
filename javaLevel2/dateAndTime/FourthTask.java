package dateAndTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/*
 * Использовать LocalDateTime из предыдущего задания,
 * преобразовать его в объект Instant, указав тайм зону 
 * America/Chicago. Вывести кол-во прошедших милисекунд
 */
public class FourthTask {
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse("26-03-1968T09:24", formatter);
		ZoneId zoneId = ZoneId.of("America/Chicago");
		Instant instant = localDateTime.toInstant(zoneId.getRules().getOffset(localDateTime));
		long epochMilli = instant.toEpochMilli();
		System.out.println(epochMilli);
	}
}
