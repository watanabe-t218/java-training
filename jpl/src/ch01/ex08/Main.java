package ex08;

/**
 * @author takahiro watanabe
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Point lowerLeft = new Point();
		Point upperRight = new Point();
		Point middlePoint = new Point();
		
		lowerLeft.x = 0.0;
		lowerLeft.y = 0.0;
		
		upperRight.x = 1280.0;
		upperRight.y = 1024.0;
		
		middlePoint.x = 640.0;
		middlePoint.y = 512.0;
		
		System.out.println("[lowerLeft]\n" + "x: " + lowerLeft.x + "\ny: " + lowerLeft.y);
		System.out.println("[upperRight]\n" + "x: " + upperRight.x + "\ny: " + upperRight.y);
		System.out.println("[middlePoint]\n" + "x: " + middlePoint.x + "\ny: " + middlePoint.y);
	}

}
