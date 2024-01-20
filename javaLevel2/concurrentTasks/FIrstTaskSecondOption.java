package concurrentTasks;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Второе решение - несколько потоков в пуле. Посчитать кол-во обработанных
 * задач каждым потоком
 */
public class FIrstTaskSecondOption {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int time = sc.nextInt();
			if (time < 0) {
				fixedThreadPool.shutdownNow();
			}
			Thread.sleep(time * 1000);
			fixedThreadPool.submit(() -> {
				Integer count = threadLocal.get();
				threadLocal.set(count == null ? 1 : ++count);
				System.out.println(time);
				System.out.println("Поток %s спал %d, количество на поток: %d"
						.formatted(Thread.currentThread().getName(), time, threadLocal.get()));
			});
		}
		fixedThreadPool.shutdown();
		fixedThreadPool.awaitTermination(30, TimeUnit.SECONDS);
	}
}
