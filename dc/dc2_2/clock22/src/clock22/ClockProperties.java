package clock22;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

public class ClockProperties {
	private Color color;
	private Color bgColor;
	private Color flipColor;
	private int fontSize;
	private String fontFamily;
	private int fontStyle;
	private Font font;
	private int width, height, x, y;

	private static ClockProperties instance;
	private ClockPreferences prefs = new ClockPreferences();

	private ClockProperties() {
		init();
	}

	public static ClockProperties getInstance() {
		if (instance == null) {
			instance = new ClockProperties();
		}
		return instance;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public void init() {
		color = ColorUtil.toColor(prefs.getWatchColor());
		bgColor = ColorUtil.toColor(prefs.getWatchBgColor());
		flipColor = ColorUtil.toColor(prefs.getWatchFlipColor());
		//font = new Font(Font.SANS_SERIF, Font.BOLD, 120);
		font = Font.decode(prefs.getWatchFont()).deriveFont(Font.BOLD, prefs.getWatchFontSize());
		fontSize = prefs.getWatchFontSize();
		width = prefs.getWindowWidth();
		height = prefs.getWindowHeight();
		x = prefs.getWindowX();
		y = prefs.getWindowY();
		fontFamily = Font.MONOSPACED;
		fontStyle = Font.PLAIN;
	}
	
//	public void initPref() {
//		color = ColorUtil.toColor("light gray"/* prefs.getWatchColor() */);
//		bgColor = ColorUtil.toColor("dark gray");
//		flipColor = ColorUtil.toColor("original");
//		//font = new Font(Font.SANS_SERIF, Font.BOLD, 120);
//		font = Font.decode(prefs.getWatchFont()).deriveFont(Font.BOLD, prefs.getWatchFontSize());
//		fontSize = prefs.getWatchFontSize();
//		width = prefs.getWindowWidth();
//		height = prefs.getWindowHeight();
//		x = prefs.getWindowX();
//		y = prefs.getWindowY();
//		fontFamily = Font.MONOSPACED;
//		fontStyle = Font.PLAIN;
//	}

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

	public Color getFlipColor() {
		return flipColor;
	}
	public void setFlipColor(Color color) {
		flipColor = color;
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
		prefs.setWatchConfig(font, fontSize, color, bgColor, flipColor);
	}


}
