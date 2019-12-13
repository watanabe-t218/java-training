package dc1_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontSelector extends Panel implements ItemListener, ActionListener {
	private Choice choice;
	private String font;
	private Property property = new Property();

	public PopupMenu parent;

	public MenuItem serif = new MenuItem("Serif");
	public MenuItem sansSerif = new MenuItem("SansSerif");
	public MenuItem monospaced = new MenuItem("Monospaced");
	public MenuItem dialog = new MenuItem("Dialog");
	public MenuItem dialogInput = new MenuItem("DialogInput");

	public FontSelector(PopupMenu parent) {
		serif.addActionListener(this);
		sansSerif.addActionListener(this);
		monospaced.addActionListener(this);
		dialog.addActionListener(this);
		dialogInput.addActionListener(this);

		parent.add(serif);
		parent.add(sansSerif);
		parent.add(monospaced);
		parent.add(dialog);
		parent.add(dialogInput);
	}


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

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String command = actionEvent.getActionCommand();
		this.font = command;
		property.setFont(this.font);
	}
}
