package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dataart {
	public static void main1(String[] agrs) {
		final Object ref = new Object();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (ref) {
						System.out.println("A");
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (ref) {
						System.out.println("B");
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (ref) {
						System.out.println("C");
					}
				}
			}
		}).start();
	}

	public static void main(String[] agrs) {
        final Lock ref = new ReentrantLock(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    ref.lock();
                    System.out.println("a");
                    ref.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    ref.lock();
                    System.out.println("b");
                    ref.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    ref.lock();
                    System.out.println("c");
                    ref.unlock();
                }
            }
        }).start();
    }
}
