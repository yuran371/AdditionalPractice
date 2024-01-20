package concurrentTasks;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1. Написать программу, бесконечно считывающую пользовательские числа из
 * консоли. Эти числа представляют собой количество секунд. При каждом вводе
 * числа, должна создаваться задача, которая засыпает на введённое число секунд
 * и затем выводит "Я спал N секунд". Однако нужно сделать так, чтобы все задачи
 * выполнялись в одном и том же потоке в порядке ввода. Т.е. в программе есть 2
 * потока: главный и поток для выполнения всех задач по очереди. При вводе
 * отрицательного числа программа должна завершать свою работу. Второе решение -
 * несколько потоков в пуле. Посчитать кол-во обработанных задач каждым потоком
 */
public class FirstTask {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService singleThread = Executors.newSingleThreadExecutor();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int next = sc.nextInt();
			if (next<0) {
				singleThread.shutdownNow();
			}
			Thread.sleep(next * 1000);
			singleThread.submit(() -> System.out.println(String.format("Я спал %d секунд", next)));
			singleThread.awaitTermination(10, TimeUnit.SECONDS);
		}
	}
}
