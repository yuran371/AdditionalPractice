package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ConsumerTask extends Thread {
	LinkedList<Integer> linkedList;

	TaskBroker taskBroker;

	public ConsumerTask(LinkedList<Integer> linkedList) {
		this.linkedList = linkedList;
		this.taskBroker = new TaskBroker(linkedList);
	}

	@Override
	public void run() {
		synchronized (linkedList) {

			try {
				while (!Thread.currentThread().isInterrupted()) {
					long random = new Random().nextLong(3000);
					int cons = taskBroker.consume();
					System.out.println(cons + " deleted");
					System.out.println("consumer wait: " + random);
					Thread.sleep(random);
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
