package ex02;

public class Client {
	public static void main(String[] args) {
		PrintServer printServer = new PrintServer();
		for (int i = 0; i < 10; i++) {
			PrintJob job = new PrintJob("job-" + i);
			System.out.println("add: " + job.jobName);
			printServer.print(job);
		}
		printServer.run();
	}
}
