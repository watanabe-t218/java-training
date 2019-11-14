package dc;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontSelector extends Panel implements ItemListener{
	private Choice choice;
	private String font;
	private Property property = new Property();
	
	public FontSelector(String label) {
		choice = new Choice();
		choice.add("Serif");
		choice.add("SansSerif");
		choice.add("Monospaced");
		choice.add("Dialog");
		choice.add("DialogInput");
		
		choice.addItemListener(this);
		setLayout(new GridLayout(2,1));
	    add(new Label(label));
	    add(choice);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice choice = (Choice)e.getItemSelectable();
		switch(choice.getSelectedItem()) {
		case "Serif":
			this.font = Font.SERIF;
			break;
		case "SansSerif":
			this.font = Font.SANS_SERIF;
			break;
		case "Monospaced":
			this.font = Font.MONOSPACED;
			break;
		case "Dialog":
			this.font = Font.DIALOG;
			break;
		case "DialogInput":
			this.font = Font.DIALOG_INPUT;
			break;
		
		default:
			break;
		}
		
		property.setFont(this.font);
	}
}
