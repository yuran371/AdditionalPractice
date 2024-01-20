package reflectionAndAnnotationTasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 	Написать программу, принимающую
 *	объект класс  Car c проинициализированными полями и
 *	составляющую запрос "INSERT" в виде строки на основании
 *	данных объекта.
 *	    Пример: дан объект Car car = new Car("Toyota", "Corolla");
 *	    Программа, принимающая этот объект, должна вывести в консоль строку:
 *		"INSERT INTO garage.car (model, brand) VALUES ('Toyota', 'Corolla');" 
 */
public class Runner {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Constructor<Car> constructor = Car.class.getConstructor(String.class, String.class);
		Car car = constructor.newInstance("Mersedes", "Benz");
		insert(car);

	}

	public static void insert(Car car) throws NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException {
		String table = Car.class.getAnnotation(Table.class).table();

		Field[] column = Car.class.getDeclaredFields();
		String collectOfColumns = Stream.of(column).map(x -> x.getAnnotation(Column.class).name())
				.collect(Collectors.joining(", "));

		String collectOfValues = Stream.of(column).peek(field -> field.setAccessible(true)).map(field -> {
			try {
				return field.get(car).toString();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return collectOfColumns;
		}).map(field -> "'" + field + "'").collect(Collectors.joining(", "));

		System.out.println("INSERT INTO %s (%s) VALUES (%s);".formatted(table, collectOfColumns, collectOfValues));
	}
}
