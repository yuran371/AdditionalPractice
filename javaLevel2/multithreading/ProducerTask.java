package multithreading;

import java.util.LinkedList;

public class ProducerTask implements Runnable {

	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	TaskBroker taskBroker;

	public ProducerTask(LinkedList<Integer> linkedList) {
		this.linkedList = linkedList;
		this.taskBroker = new TaskBroker(linkedList);
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1);
				int prod = taskBroker.produce();
				System.out.println(prod + " added");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
