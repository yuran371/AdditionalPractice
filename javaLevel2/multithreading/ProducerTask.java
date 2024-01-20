package multithreading;

import java.util.LinkedList;
import java.util.Random;

public class ProducerTask implements Runnable {

	LinkedList<Integer> linkedList;
	TaskBroker taskBroker;

	public ProducerTask(LinkedList<Integer> linkedList) {
		this.linkedList = linkedList;
		this.taskBroker = new TaskBroker(linkedList);
	}

	@Override
	public void run() {
		synchronized (linkedList) {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					long random = new Random().nextLong(10);
					int prod = taskBroker.produce();
					System.out.println(prod + " added");
					System.out.println("prod wait: " + random);
					linkedList.notifyAll();
					linkedList.wait(random);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
