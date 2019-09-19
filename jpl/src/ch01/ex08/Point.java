package ex08;

/**
 * @author takahiro watanabe
 *
 */
public class Point {
	public double x = 0.0;
	public double y = 0.0;
	
	public void clear() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public void moveTo(Point point) {
		this.x = point.x;
		this.y = point.y;
	}
	
	public double distance(Point point) {
		double xdiff = this.x - point.x;
		double ydiff = this.y - point.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
}
