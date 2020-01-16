package ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		DisplayTime timeCount = new DisplayTime();
		DisplayMessage msgDisplay1 = new DisplayMessage(15, "message15");
		DisplayMessage msgDisplay2 = new DisplayMessage(7, "message7");

		timeCount.addMsgDisplay(msgDisplay1);
		timeCount.addMsgDisplay(msgDisplay2);

		new Thread(msgDisplay1).start();
		new Thread(msgDisplay2).start();
		new Thread(timeCount).start();
	}
}
