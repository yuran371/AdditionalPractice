package multithreading;

import java.util.LinkedList;
import java.util.Random;

public class TaskBroker {
	LinkedList<Integer> linkedList;

	public TaskBroker(LinkedList<Integer> linkedList) {
		this.linkedList = linkedList;
	}

	public int produce() {
		while(linkedList.size()<10) {
			int random = new Random().nextInt(10);
			linkedList.add(random);
			return random;
		}
		return 0;
	}
	public int consume() {
		while(!linkedList.isEmpty()) {
			return linkedList.remove();
		}
		return 0;
	}
}
