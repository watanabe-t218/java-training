package ex14;

/**
 * @author takahiro watanabe
 *
 */
public class Walkman {
	static int serial;
	static final int terminal = 1; 		// electric audio terminal
	protected Tape tape = new Tape();	// music tape
	
	public Walkman (int serial){
		Walkman.serial = serial;
	}
	
	// play music
	public void play() {
		System.out.printf("[%d]: %s%n", terminal, tape.getMusic());
	}
}
