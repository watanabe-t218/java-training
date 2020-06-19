package clock22;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ClockCanvas extends JPanel implements Runnable {


	private static final int REFRESH_INTERVAL = 100;
    private ClockText hour1, hour2, minute1, minute2, second1, second2;
    private int originTextWidth;
    private int originTextHeight;
    private int offsetX = 12;
    private int offsetY = 20;
    private ClockProperties props = ClockProperties.getInstance();
    private Dimension dimension = new Dimension(props.getWidth(), props.getHeight());
    ClockFrame frame;
	private int originX;
	private int originY;

	public ClockCanvas() {
		setForeground(new Color(0, 255, 0));
        setBackground(new Color(50, 50, 50));
 
        this.frame = new ClockFrame(this);
        originTextWidth = 70;
        originTextHeight = 70;
        hour1 = new ClockText(offsetX + originTextWidth / 2, dimension.height / 2, originTextWidth, originTextHeight);
        hour2 = new ClockText((2*offsetX + originTextWidth /2 * 3), dimension.height / 2, originTextWidth, originTextHeight);
        minute1 = new ClockText((int)(3*offsetX + 2.5 * originTextWidth), dimension.height / 2, originTextWidth, originTextHeight);
        minute2 = new ClockText((int)(4*offsetX + 3.5 * originTextWidth), dimension.height / 2, originTextWidth, originTextHeight);
        second1 = new ClockText((int)(5*offsetX + 4.5 * originTextWidth), dimension.height / 2, originTextWidth, originTextHeight);
        second2 = new ClockText((int)(6*offsetX + 5.5 * originTextWidth), dimension.height / 2, originTextWidth, originTextHeight);
        JLabel hColon = new JLabel(":");
        hColon.setLocation((2*offsetX + originTextWidth /2 * 3) + (offsetX + originTextWidth) / 2, dimension.height);
        JLabel mColon = new JLabel(":");
        mColon.setLocation((int)(4*offsetX + 3.5 * originTextWidth) + (offsetX + originTextWidth) / 2, dimension.height);
        new Thread(this).start();
	}

	private void resize() {
		int width = originTextWidth * 6 + offsetX * 7;
		int height = originTextWidth * 2 + offsetY * 2;

		dimension.setSize(width, height);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
	// private void draw() {
        // Graphics graphics = getGraphics();
        		// bufferStrategy.getDrawGraphics();
        int w = getMaxWidth((Graphics2D)graphics);
		originTextWidth = (int) (w);
        resize();
		frame.setSize(dimension);
        // if (!bufferStrategy.contentsLost()) {
        graphics.clearRect(0, 0, dimension.width, dimension.height);
        ((Graphics2D) graphics).setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setColor(props.getBgColor());
        graphics.fillRect(0, 0, dimension.width, dimension.height);
        graphics = updateFlip(graphics);
   //      bufferStrategy.show();
        graphics.dispose();
    // }
        // frame.setBackground(props.getBgColor());
    }

	private Graphics updateFlip(Graphics g) {
		// ((Graphics2D) g).setBackground(props.getBgColor());
		Calendar next = Calendar.getInstance();
		originX = offsetX + originTextWidth / 2;
		originY = dimension.height / 2 - 20;
		hour1.resize(originX, originY, (int)(originTextWidth), (int)(originTextWidth));
		hour2.resize((2*offsetX + originTextWidth /2 * 3), originY, originTextWidth, originTextWidth);
        minute1.resize((int)(3*offsetX + 2.5 * originTextWidth), originY, originTextWidth, originTextWidth);
        minute2.resize((int)(4*offsetX + 3.5 * originTextWidth), originY, originTextWidth, originTextWidth);
        second1.resize((int)(5*offsetX + 4.5 * originTextWidth), originY, originTextWidth, originTextWidth);
        second2.resize((int)(6*offsetX + 5.5 * originTextWidth), originY, originTextWidth, originTextWidth);
		g = hour1.updateFlip(g, next.get(Calendar.HOUR_OF_DAY)/10);
		g = hour2.updateFlip(g, next.get(Calendar.HOUR_OF_DAY)%10);
		g = minute1.updateFlip(g, next.get(Calendar.MINUTE)/10);
		g = minute2.updateFlip(g, next.get(Calendar.MINUTE)%10);
		g = second1.updateFlip(g, next.get(Calendar.SECOND)/10);
		g = second2.updateFlip(g, next.get(Calendar.SECOND)%10);	
		return g;
	}

	private int getMaxWidth(Graphics2D g2) {
		Font f = props.getFontFamily().deriveFont((float)props.getFontSize());
		FontRenderContext frc = g2.getFontRenderContext();
		int w = 0;
		Rectangle2D r;
		for (int i = 0; i < 10; i++) {
			r = f.getStringBounds(Integer.toString(i), frc);
			if (r.getWidth() > w)
				w = (int) r.getWidth();
		}
		return w;
	}


	@Override
	public Dimension getPreferredSize() {
	        return dimension;
	}

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
 

	@Override
	public void run() {
		while (true) {
            repaint();
            // draw();
            try {
                Thread.sleep(REFRESH_INTERVAL); // Update in 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}


}
