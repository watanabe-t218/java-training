package ex14;

/**
 * @author takahiro watanabe
 *
 */
public class Walkman2 extends Walkman{
	private int terminal2 = 2;		// additional electric audio terminal
	
	public Walkman2(int serial) {
		super(serial);
	}

	@Override
	// play music at terminal 1&2
	public void play() {
		super.play();
		System.out.printf("[%d]: %s%n", terminal2, tape.getMusic());
	}
	
	// send message to another terminal
	public void sendMessage(int sendFrom, String message) {
		int sendTo = sendFrom % 2 + 1;
		System.out.printf("[%d]: %s%n", sendTo, message);
	}
}
