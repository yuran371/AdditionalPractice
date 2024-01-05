package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadRunner {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> linkedList = new LinkedList<>();
		Thread producerThread = new Thread(new ProducerThread(linkedList));
		ConsumerThread consumerThread = new ConsumerThread(linkedList);
		producerThread.start();
		consumerThread.start();
//		producerThread.join();
//		consumerThread.join();
	}
}
