package ex05;

public class AddSafe {
	int value = 0;
	static Object lock = new Object();
	
	public void add(int addValue) {
		synchronized(lock) {
			value += addValue;
			System.out.println("value: " + value);
		}
	}

	public static void main(String[] args) {

		AddSafe addSafe = new AddSafe();
		
		Runnable addThread = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					addSafe.add(i);
				}
			}
		};

		new Thread(addThread).start();
		new Thread(addThread).start();
		new Thread(addThread).start();
		new Thread(addThread).start();
		new Thread(addThread).start();
	}
}
