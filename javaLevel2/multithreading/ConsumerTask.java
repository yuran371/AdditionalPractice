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
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(new Random().nextLong(10));
				int cons = taskBroker.consume();
				System.out.println(cons + " deleted");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
