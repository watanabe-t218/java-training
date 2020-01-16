package ex06;

import java.util.ArrayList;
import java.util.Iterator;

public class DisplayTime extends Thread {
	private long seconds = 0;
	private ArrayList<DisplayMessage> displayMessage = new ArrayList<DisplayMessage>();

	public void addMsgDisplay(DisplayMessage msgDisplay) {
		displayMessage.add(msgDisplay);
	}

	public void notifyMsgDisplays() {
		Iterator<DisplayMessage> it = displayMessage.iterator();
		while (it.hasNext()) {
			DisplayMessage m = it.next();
			m.countUp();
		}
	}

	@Override
	public void run() {
		for (;;) {
			try {
				Thread.sleep(1000);
				seconds++;
				System.out.println(seconds + "[sec]");
				notifyMsgDisplays();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}