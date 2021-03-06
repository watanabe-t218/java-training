package clock22;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ClockText {

	private int originX;
	private int originY;
	private int width;
	private int height;

	private double[] xPoint = new double[4];
	private double[] yPoint = new double[4];
	private double[] zPoint = {0.0, 0.0, 0.0, 0.0};

	private int now = 0;
	private double theta = 0.0;

	public ClockText(int originX, int originY, int width, int height) {
		this.originX = originX;
		this.originY = originY;
		this.width = width;
		this.height = height;

		xPoint[0] = -width / 2;
		yPoint[0] = -height;

		xPoint[1] = -xPoint[0];
		yPoint[1] = yPoint[0];

		xPoint[2] = xPoint[1];
		yPoint[2] = 0.0;

		xPoint[3] = xPoint[0];
		yPoint[3] = yPoint[2];
	}
	public void resize(int originX, int originY, int width, int height) {
		this.originX = originX;
		this.originY = originY;
		this.width = width;
		this.height = height;

		xPoint[0] = -width / 2;
		yPoint[0] = -height;

		xPoint[1] = -xPoint[0];
		yPoint[1] = yPoint[0];

		xPoint[2] = xPoint[1];
		yPoint[2] = 0.0;

		xPoint[3] = xPoint[0];
		yPoint[3] = yPoint[2];
	}

	public Graphics updateFlip(Graphics g, int next) {
		ClockProperties props = ClockProperties.getInstance();
		Font f = props.getFontFamily().deriveFont((float)props.getFontSize());
		Graphics2D g2 = (Graphics2D)g;
		g.translate(originX, originY);


		g2.drawString(String.valueOf(next), (int)xPoint[0], 5 + height/2);


		g2.setClip((int)xPoint[3], (int)yPoint[3], width, height); 
		g2.setColor(props.getColor());
		g2.setFont(f);

		g2.drawString(String.valueOf(next), (int)xPoint[3], 5 + height / 2);


		g2.setClip((int)xPoint[0], (int)yPoint[0], width, height * 2);
		g2.setColor(props.getFlipColor());

		g2.setColor(props.getColor());

		g2.setFont(f);
		if (theta%180 < 54) {
			g2.setClip((int)xPoint[0], (int)yPoint[0], width, height); 
			g2.drawString(String.valueOf(next), (int)xPoint[0], 5 + height / 2);
		} else if (theta%180 > 115) {
			g2.setClip((int)xPoint[3], (int)yPoint[3], width, height);
			g2.drawString(String.valueOf(next), (int)xPoint[0], 5 + height / 2);
		}

		g2.setClip((int)xPoint[0], (int)yPoint[0], width, height * 2);
		if (theta == 0)
			this.now = next;

		g.translate(-originX, -originY);
		return g2;
	}
}
