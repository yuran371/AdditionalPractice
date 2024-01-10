package concurrentTasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

//import java.lang.Math.*;
/**
 * 2. Задан массив случайных целых чисел (от 1 до 3000) случайной длины (до 100
 * элементов). Найти максимальный элемент в массиве двумя способами: в одном
 * потоке и используя 10 потоков. Сравнить затраченное в обоих случаях время.
 */
public class SecondTask {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * используя один поток
		 */
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		int random1million = new Random().nextInt(1000);
		int arr[] = new int[random1million];
		for (int i = 0; i < random1million; i++) {
			int random1to300 = new Random().nextInt(1, 3000);
			arr[i] = random1to300;
		}
		singleThreadExecutor.submit(() -> {
			System.out.println(Thread.currentThread().getName());
			Arrays.stream(arr).max().stream().forEach(System.out::println);
				return 1;
		}).get();
		fixedThreadPool.submit(() -> {
			System.out.println(Thread.currentThread().getName());
			Stream.of(arr).parallel().flatMapToInt(Arrays::stream).max().stream().forEach(System.out::println);
			});
		singleThreadExecutor.shutdown();
		singleThreadExecutor.awaitTermination(50, TimeUnit.SECONDS);

		/*
		 * используя 10 потоков
		 */

	}
}
