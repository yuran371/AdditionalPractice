package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadRunner {
	public static void main(String[] args) throws InterruptedException {
		LinkedList<Integer> linkedList = new LinkedList<>();
		Thread producerThread = new Thread(new ProducerTask(linkedList));
		ConsumerTask consumerThread = new ConsumerTask(linkedList);
		producerThread.start();
		consumerThread.start();
	}
}
