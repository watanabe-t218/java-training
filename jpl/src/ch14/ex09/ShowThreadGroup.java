package ex09;

public class ShowThreadGroup {

	public void showThreads(final ThreadGroup tg) {
		new Thread(() -> {
			
			for (;;) {
				
				showThread(tg, 0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}
		}).start();
	}
	
	public void showThread(final ThreadGroup tg, int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			System.out.println("________________");
			System.out.println(tg.getName());					
		}
		
		for (int i = 0; i < n; i++)
			sb.append("  ");
		int allThreads = tg.activeCount();
		Thread[] threads = new Thread[allThreads];
		int setThreads = tg.enumerate(threads, false);
		for (int i = 0; i < setThreads; i++) {
			System.out.println(sb.toString() + "L" + threads[i].getName());
		}
		
		int allSubGroup = tg.activeGroupCount();				
		ThreadGroup[] subGroups = new ThreadGroup[allSubGroup];
		int setSubGroup = tg.enumerate(subGroups, false);		
		for (int i = 0; i < setSubGroup; i++) {
			System.out.println(sb.toString() +"L" + subGroups[i].getName());
			showThread(subGroups[i], n+1);
		}
	}
	
	public static void main(String[] args) {
		
		ShowThreadGroup showThreadGroup = new ShowThreadGroup();
		
		ThreadGroup grp1 = new ThreadGroup("grp1");
		ThreadGroup grp2 = new ThreadGroup(grp1, "grp2");
		ThreadGroup grp3 = new ThreadGroup(grp2, "grp3");
		ThreadGroup grp4 = new ThreadGroup(grp3, "grp4");
		ThreadGroup grp5 = new ThreadGroup(grp1, "grp5");
		ThreadGroup grp6 = new ThreadGroup(grp5, "grp6");
		
		showThreadGroup.threadByTime(grp1, 10000);
		showThreadGroup.threadByTime(grp2, 9000);
		showThreadGroup.threadByTime(grp3, 8000);
		showThreadGroup.threadByTime(grp4, 7000);
		showThreadGroup.threadByTime(grp5, 6000);
		showThreadGroup.threadByTime(grp6, 5000);
		
		showThreadGroup.showThreads(grp1);
	}
	
	public void threadByTime(ThreadGroup grp, int time) {
		new Thread(grp, () -> {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}).start();
	}
}
