package ex03;

public class AddSynchronized {
	private int value;

	public AddSynchronized() {
		value = 0;
	}

	public synchronized void add(int addValue) {
		value += addValue;
		System.out.println("value: " + value);
	}

	public static void main(String[] args) {
		AddSynchronized addSynchronized = new AddSynchronized();

		Runnable addThread = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					addSynchronized.add(i);
				}
			}
		};

		new Thread(addThread).start();
		new Thread(addThread).start();
	}
}
