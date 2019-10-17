package dc1_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

/**
 * @author takahiro watanabe
 *
 */
public class DegitalClock extends Frame implements Runnable{

    final static int WINDOW_WIDTH = 300;
	final static int WINDOW_HIGHT = 200;

	final static int CLOCK_WIDTH = 200;
	final static int CLOCK_HIGHT = 200;
	final static int CLOCK_CHAR_NUM = 8;


	static int hour;
	static int minute;
	static int second;

	// make Instances
	static DegitalClock clock = new DegitalClock();
	static Thread th = new Thread(clock);
	Calendar now = Calendar.getInstance();

    public void run(){
        while(true){
              hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
              minute = Calendar.getInstance().get(Calendar.MINUTE);
              second = Calendar.getInstance().get(Calendar.SECOND);
              repaint();

              try{
                  Thread.sleep(1000);
              }catch(InterruptedException e){
              }
        }
    }

    public void paint(Graphics g)
    {
    	Dimension size = getSize();

        String time = String.format("%02d", hour) + ":"
					+ String.format("%02d", minute) + ":"
					+ String.format("%02d", second);

        int fontSize = size.width / CLOCK_CHAR_NUM; // windowSize / charNum
        Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, fontSize);
        g.setFont(font);
        g.setColor(Color.DARK_GRAY);
        g.drawString(time, (size.width - (fontSize * CLOCK_CHAR_NUM / 2)) / 2, (size.height + fontSize) / 2);

    }

    public static void main(String args[]) {

    	// Initialize window
    	clock.setSize(WINDOW_WIDTH, WINDOW_HIGHT);
    	clock.setVisible(true);
    	clock.addWindowListener(new Ada());

    	th.start();
    }

}
class Ada extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}