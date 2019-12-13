package dc1_3;

import java.awt.Color;
import java.awt.Font;

public class Property {
	private static Color fontColor = Color.MAGENTA;
	private static Color backColor = Color.DARK_GRAY;
	private static int fontSize = 40;
	private static String font = Font.SERIF;
	
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		Property.fontColor = fontColor;
	}
	public Color getBackColor() {
		return backColor;
	}
	public void setBackColor(Color backColor) {
		Property.backColor = backColor;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		if(fontSize < 1) {
			fontSize = 1;
		}
		Property.fontSize = fontSize;
	}
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		Property.font = font;
	}
	
}
