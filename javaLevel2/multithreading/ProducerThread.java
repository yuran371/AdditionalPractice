package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerThread implements Runnable {

	List<Integer> linkedList;

	public ProducerThread(List<Integer> linkedList) {
		this.linkedList = linkedList;
	}

	@Override
	public void run() {
		while (linkedList.size() < 10) {
			Random r = new Random();
			int random = r.nextInt(10);
			synchronized (linkedList) {
				linkedList.add(random);
			}
			System.out.println("Добавлено следующее число в список " + random);
//			linkedList.notifyAll();
				try {
					linkedList.wait(random);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
