package ex02;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();
	private final String threadName;

	public PrintServer() {
		Thread thread = new Thread(this);
		threadName = thread.getName();
		System.out.println("Thread: " + threadName);
		thread.start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	@Override
	public void run() {
		if (!Thread.currentThread().getName().equals(threadName)) {
			System.out.println("Thread: " + Thread.currentThread().getName() + " is not allowed");
			return;
		}
		for (;;) {
			try {
				PrintJob job = requests.remove();
				if(job != null) {
					realPrint(job);					
				}
			} catch (InterruptedException e) {
				System.out.println("IntteruptedException");
			}
		}
	}

	private void realPrint(PrintJob job) {
		System.out.println("print: " + job);
	}
	
	private class PrintQueue {
		Queue<PrintJob> jobs = new ArrayDeque<PrintJob>();
		void add(PrintJob job) {
			jobs.add(job);
		}
		
		PrintJob remove() throws InterruptedException{
			if (jobs.size() == 0) {
				return null;
			}
			return jobs.remove();
		}
	}

}