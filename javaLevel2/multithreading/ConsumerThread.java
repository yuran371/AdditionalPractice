package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ConsumerThread extends Thread {
	List<Integer> linkedList;

	public ConsumerThread(List<Integer> linkedList) {
		this.linkedList = linkedList;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!linkedList.isEmpty()) {
			Integer remove = 0;
			synchronized (linkedList) {
				remove = linkedList.remove(0);
			}
//			linkedList.notifyAll();
			System.out.println("consumer забрал из списка: " + remove);
			Random r = new Random();
			int random = r.nextInt(10);
			try {
//			Thread.sleep(random);
				linkedList.wait(random);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("список пуст");

	}

}
