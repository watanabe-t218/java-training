package dc;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

/**
 * @author takahiro watanabe
 *
 */
public class DigitalClock2 extends Frame implements Runnable, ActionListener{
	final static int WINDOW_WIDTH = 300;
	final static int WINDOW_HIGHT = 200;
	
	final static int CLOCK_WIDTH = 200;
	final static int CLOCK_HIGHT = 200;
	final static int CLOCK_CHAR_NUM = 8;
	
	static int previousWidth = WINDOW_WIDTH;
	static int previousHight = WINDOW_HIGHT;
	
	Image buff;		// ダブルバッファリング用のバッファ
	Graphics buff_g;	// ダブルバッファリング用のグラフィックス
	
	static int hour;
	static int minute;
	static int second;
	Property property;
	PropertyDialog dialog;
	
	// make Instances
	static DigitalClock2 clock = new DigitalClock2();
	static Thread th = new Thread(clock);
	Calendar now = Calendar.getInstance();
	
	public DigitalClock2() {
		
		setTitle("Clock");
		
		// Menu bar Settings
		property = new Property();
		MenuBar mb=new MenuBar();
		Menu m=new Menu("Setting");
		m.addActionListener(this);
		mb.add(m);
	 	m.add(new MenuItem("Property"));
	 	setMenuBar(mb);	

	}
	
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
    	// if window size changed
    	Dimension size = getSize(); 	
    	if(previousWidth != size.width || previousHight != size.height) {
    		clock.buff = clock.createImage(size.width, size.height);
        	clock.buff_g = clock.buff.getGraphics();
        	previousWidth = size.width;
        	previousHight = size.height;
    	}
    	
    	clock.buff_g.setColor(property.getBackColor());
    	clock.buff_g.fillRect(0, 0, size.width, size.height);
    	
        String time = String.format("%02d", hour) + ":"
					+ String.format("%02d", minute) + ":"
					+ String.format("%02d", second);
        
        int fontSize = property.getFontSize();
        Font font = new Font(property.getFont(), Font.BOLD, fontSize);
        
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (size.width - metrics.stringWidth(time)) / 2;
        int y = ((size.height - metrics.getHeight()) / 2) + metrics.getAscent();
        
        clock.buff_g.setFont(font);
        clock.buff_g.setColor(property.getFontColor());
        clock.buff_g.drawString(time, x, y + 20); // menubar +20
               
        clock.setSize(fontSize*8+10, fontSize*5);
        g.drawImage(clock.buff, 0, 0, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Property")) {
			dialog = new PropertyDialog(this);
		}
    }
    
    public void udpate(Graphics g) {
    	
    	paint(g);
    }
    
    public static void main(String args[]) {
    	
    	// Initialize window
    	clock.setSize(WINDOW_WIDTH, WINDOW_HIGHT);
    	clock.setVisible(true);
    	clock.setResizable(false);
    	clock.addWindowListener(new Ada());
    	
    	clock.buff = clock.createImage(WINDOW_WIDTH,WINDOW_HIGHT);
        clock.buff_g = clock.buff.getGraphics();

    	th.start();
    }

}

class Ada extends WindowAdapter {
	
	// Exit button Process
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}