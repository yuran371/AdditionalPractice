package dateAndTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
 * Создать объект instant. Вывести его на консоль.
 * Затем создать объект ZonedDateTime на основании
 * предыдущего объекта с таймзоной "Africa/Cairo"
 */
public class SeventhTask {
	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println(instant);
		ZonedDateTime zoneId = instant.atZone(ZoneId.of("Africa/Cairo"));
		System.out.println(zoneId);
	}
}
