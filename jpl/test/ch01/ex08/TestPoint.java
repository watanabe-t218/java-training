package ex08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * @author Watari-Home
 *
 */
public class TestPoint {

	@Test
	public void testClear() {
		Point p1 = new Point();
		p1.x = 1.0;
		p1.y = 2.0;		
		assertEquals(1.0, p1.x);
		assertEquals(2.0, p1.y);
		
		p1.clear();
		assertEquals(0.0, p1.x);
		assertEquals(0.0, p1.y);
	}
	
	@Test
	public void testSet() {
		Point p1 = new Point();
		Point p2 = new Point();
		
		p2.x = 1.0;
		p2.y = 2.0;
		
		p1.moveTo(p2);
		assertEquals(1.0, p1.x);
		assertEquals(2.0, p1.y);
	}
	
	@Test
	public void testDistance() {
		Point p1 = new Point();
		p1.x = 1.0;
		p1.y = 2.0;

		Point p2 = new Point();
		p2.x = 3.0;
		p2.y = 4.0;
		
		double distance = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
		assertEquals(distance, p1.distance(p2));
	}

}
