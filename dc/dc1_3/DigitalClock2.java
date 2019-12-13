package dc1_3;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

/**
 * @author takahiro watanabe
 *
 */
public class DigitalClock2 extends Window implements Runnable, ActionListener, MouseListener,MouseMotionListener{
	final static int WINDOW_WIDTH = 300;
	final static int WINDOW_HIGHT = 200;

	static int windowPositionX = 20;
	static int windowPositionY = 20;

	final static int CLOCK_WIDTH = 200;
	final static int CLOCK_HIGHT = 200;
	final static int CLOCK_CHAR_NUM = 8;

	static int previousWidth = WINDOW_WIDTH;
	static int previousHight = WINDOW_HIGHT;

	Image buff;
	Graphics buff_g;

	static int hour;
	static int minute;
	static int second;
	Property property;
	PropertyDialog dialog;

	// make Instances
	static DigitalClock2 clock = new DigitalClock2();
	static Thread th = new Thread(clock);
	Calendar now = Calendar.getInstance();

	// for Popup
	PopupMenu popupMenu = new PopupMenu("root");
	PopupMenu fontType = new PopupMenu("Font Type");
	PopupMenu fontSize = new PopupMenu("Font Size");
	PopupMenu fontColor = new PopupMenu("Font Color");
	PopupMenu backgroundColor = new PopupMenu("BackGround Color");
	MenuItem exit = new MenuItem("Exit");

	// for Mouse drag
	private static int mouseStartXOnScreen;
	private static int mouseStartYOnScreen;
	private static int mouseStartX;
	private static int mouseStartY;
	private static int windowStartX;
	private static int windowStartY;


	public DigitalClock2() {
		super(null, null);
//		setTitle("Clock");

		// Menu bar Settings
		property = new Property();
		MenuBar mb=new MenuBar();
		Menu m=new Menu("Setting");
		m.addActionListener(this);
		mb.add(m);
		m.add(new MenuItem("Property"));
//		setMenuBar(mb);

		// for popup
		fontType.addActionListener(this);
		fontSize.addActionListener(this);
		fontColor.addActionListener(this);
		backgroundColor.addActionListener(this);
		exit.addActionListener(this);

		FontSelector fontSelector = new FontSelector(fontType);
		FontSizeSelector fontSizeSelector = new FontSizeSelector(fontSize);
		FontColorSelector fontColorSelector = new FontColorSelector(fontColor);
		BackColorSelector backColorSelector = new BackColorSelector(backgroundColor);

		popupMenu.add(fontType);
		popupMenu.add(fontSize);
		popupMenu.add(fontColor);
		popupMenu.add(backgroundColor);
		popupMenu.add(exit);
		add(popupMenu);
		addMouseMotionListener(this);
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);

		// mouse event
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

//		clock.setLocation(windowPositionX, windowPositionY);
		g.drawImage(clock.buff, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);

		if (e.getActionCommand().equals("Property")) {
			dialog = new PropertyDialog(new Frame());
		} else if (command.equals("Font Type")) {
			// perform cut operation
			System.out.println(command);
		} else if (command.equals("Font Size")) {
			// perform copy operation
			System.out.println(command);
		} else if (command.equals("Font Color")) {
			// perform paste operation
			System.out.println(command);
		} else if (command.equals("BackGround Color")) {
			System.out.println(command);
		} else if (command.equals("Exit")) {
			System.exit(0);
		}

	}

	public static void main(String args[]) {

		// Initialize window
		clock.setSize(WINDOW_WIDTH, WINDOW_HIGHT);
		clock.setVisible(true);

		clock.buff = clock.createImage(WINDOW_WIDTH,WINDOW_HIGHT);
		clock.buff_g = clock.buff.getGraphics();
		clock.addMouseListener(clock);

		th.start();
	}

	public void processMouseEvent(MouseEvent e) {

		if (e.isPopupTrigger()) {
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
		super.processMouseEvent(e);
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		this.windowStartX = clock.getX();
		this.windowStartY = clock.getY();

		this.mouseStartXOnScreen = mouseEvent.getXOnScreen();
		this.mouseStartYOnScreen = mouseEvent.getYOnScreen();
		this.mouseStartX = mouseEvent.getX();
		this.mouseStartY = mouseEvent.getY();
//		clock.setLocation(mouseStartXOnScreen-mouseStartX, mouseStartYOnScreen- mouseStartY );
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseDragged(MouseEvent event)
	{
		int mouseXOnScreen = event.getXOnScreen();
		int mouseYOnScreen = event.getYOnScreen();

		int X = mouseXOnScreen - this.mouseStartX;
		int Y = mouseYOnScreen - this.mouseStartY;

		clock.setLocation(X, Y);
		System.out.println(X +" : "+ Y);
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {

	}
}