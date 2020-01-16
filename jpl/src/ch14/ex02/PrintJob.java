package ex02;

public class PrintJob {
	String jobName;
	public PrintJob(String jobName) {
		this.jobName = jobName;
	}
	
	@Override
	public String toString() {
		return this.jobName;
	}
}
