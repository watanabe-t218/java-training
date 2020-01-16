package ex04;

public class AddStatic {

	private static int value = 0;

	public static synchronized void add(int addValue) {
		value += addValue;
		System.out.println("value: " + value);
	}

	public static void main(String[] args) {

		Runnable addThread = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					AddStatic.add(i);
				}
			}
		};

		new Thread(addThread).start();
		new Thread(addThread).start();
	}
}
