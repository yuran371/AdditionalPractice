package multithreading;

import java.util.LinkedList;
import java.util.Random;

public class TaskBroker {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();

	public TaskBroker(LinkedList<Integer> linkedList) {
		this.linkedList = linkedList;
	}

	public synchronized int produce() {
		while(linkedList.size()<10) {
			int random = new Random().nextInt(10);
			linkedList.add(random);
			return random;
		}
		return 0;
	}
	public synchronized int consume() {
		while(!linkedList.isEmpty()) {
			return linkedList.remove();
		}
		return 0;
	}
}
