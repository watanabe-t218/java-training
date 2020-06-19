/**
 *
 */
package clock23;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import clock23.ColorUtil;
import clock23.WindowClockPreferences;
import clock23.Properties;

public class Properties {
	private Color color;
	private Color backGroundColor;
	private int fontSize;
	private String fontFamily;
	private int fontStyle;
	private Font font;
	private int width, height, x, y;

	private static Properties instance;
	private WindowClockPreferences prefs = new WindowClockPreferences();

	private Properties() {
		init();
	}

	public static Properties getInstance() {
		if (instance == null) {
			instance = new Properties();
		}
		return instance;
	}

	public Color getBgColor() {
		return backGroundColor;
	}

	public void setBgColor(Color bgColor) {
		this.backGroundColor = bgColor;
	}

	public void init() {
		color = ColorUtil.toColor("orange");
		backGroundColor = ColorUtil.toColor("dark gray");
		font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		fontSize = 50;
		width = 504;
		height = 200;
		x = 100;
		y = 100;
		fontFamily = Font.MONOSPACED;
		fontStyle = Font.PLAIN;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Font getFontFamily() {
		return font;
	}

	public void setFontFamily(Font font) {
		this.font = font;
	}
	
	public int getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setLocation(Point location) {
		this.x = location.x;
		this.y = location.y;
	}
	
	public void setDimension(Dimension dimension) {
		this.width = dimension.width;
		this.height = dimension.height;
	}
	
	public void update() {
		prefs.setWindowConfig(new Point(x, y), width, height);
		prefs.setWatchConfig(font, fontSize, color, backGroundColor);
	}


}
