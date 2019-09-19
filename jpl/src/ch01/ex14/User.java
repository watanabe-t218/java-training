package ex14;

/**
 * @author takahiro watanabe
 *
 */
public class User {

	public static void main(String[] args) {
		Walkman2 walkman2 = new Walkman2(1);
		
		walkman2.play();
		
		walkman2.sendMessage(1, "message from terminal1");
		walkman2.sendMessage(2, "message from terminal2");
	}

}
