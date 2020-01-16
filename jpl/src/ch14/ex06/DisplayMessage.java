package ex06;

public class DisplayMessage extends Thread {
	private int waitCount;
	private int interval;
	private String msg;

	DisplayMessage(int interval, String msg) {
		waitCount = 0;
		this.interval = interval;
		this.msg = msg;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				msgDisplay();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void countUp() {
		waitCount++;
		notifyAll();
	}

	private synchronized void msgDisplay() throws InterruptedException {
		while (waitCount != interval)
			wait();

		System.out.println(msg);
		waitCount = 0;
	}
}