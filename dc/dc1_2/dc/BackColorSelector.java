package dc;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BackColorSelector extends Panel implements ItemListener{
	private Choice choice;
	private Color color;
	private Property property = new Property();
	
	public BackColorSelector(String label) {
		choice = new Choice();
		choice.add("BLACK");
		choice.add("WHITE");
		choice.add("BLUE");
		choice.add("CYAN");
		choice.add("GREEN");
		choice.add("MAGENTA");
		choice.add("ORANGE");
		choice.add("PINK");
		choice.add("RED");
		choice.add("YELLOW");
		choice.add("GRAY");
		choice.add("DARK_GRAY");
		choice.add("LIGHT_GRAY");
		
		choice.addItemListener(this);
		setLayout(new GridLayout(2,1));
	    add(new Label(label));
	    add(choice);
	}

	public Color getColor() {
		return this.color;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice choice = (Choice)e.getItemSelectable();
		switch(choice.getSelectedItem()) {
		case "BLACK":
			this.color = Color.BLACK;
			break;
		case "WHITE":
			this.color = Color.WHITE;
			break;
		case "BLUE":
			this.color = Color.BLUE;
			break;
		case "CYAN":
			this.color = Color.CYAN;
			break;
		case "GREEN":
			this.color = Color.GREEN;
			break;
		case "MAGENTA":
			this.color = Color.MAGENTA;
			break;
		case "ORANGE":
			this.color = Color.ORANGE;
			break;
		case "PINK":
			this.color = Color.PINK;
			break;
		case "RED":
			this.color = Color.RED;
			break;
		case "YELLOW":
			this.color = Color.YELLOW;
			break;
		case "GRAY":
			this.color = Color.GRAY;
			break;
		case "DARK_GRAY":
			this.color = Color.DARK_GRAY;
			break;
		case "LIGHT_GRAY":
			this.color = Color.LIGHT_GRAY;
			break;
		default:
			break;
		}
		
		property.setBackColor(this.color);
	}
}
