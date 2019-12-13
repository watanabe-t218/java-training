package dc1_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BackColorSelector extends Panel implements ItemListener, ActionListener {
	private Choice choice;
	private Color color;
	private Property property = new Property();

	public MenuItem black = new MenuItem("BLACK");
	public MenuItem white = new MenuItem("WHITE");
	public MenuItem blue = new MenuItem("BLUE");
	public MenuItem green = new MenuItem("GREEN");
	public MenuItem cyan = new MenuItem("CYAN");
	public MenuItem magenta = new MenuItem("MAGENTA");
	public MenuItem orange = new MenuItem("ORANGE");
	public MenuItem pink = new MenuItem("PINK");
	public MenuItem red = new MenuItem("RED");
	public MenuItem yellow = new MenuItem("YELLOW");
	public MenuItem gray = new MenuItem("GRAY");
	public MenuItem darkGray = new MenuItem("DARK_GRAY");
	public MenuItem lightGray = new MenuItem("LIGHT_GRAY");


	public BackColorSelector(PopupMenu parent) {
		black.addActionListener(this::actionPerformed);
		white.addActionListener(this::actionPerformed);
		blue.addActionListener(this::actionPerformed);
		green.addActionListener(this::actionPerformed);
		cyan.addActionListener(this::actionPerformed);
		magenta.addActionListener(this::actionPerformed);
		orange.addActionListener(this::actionPerformed);
		pink.addActionListener(this::actionPerformed);
		red.addActionListener(this::actionPerformed);
		yellow.addActionListener(this::actionPerformed);
		gray.addActionListener(this::actionPerformed);
		darkGray.addActionListener(this::actionPerformed);
		lightGray.addActionListener(this::actionPerformed);

		parent.add(black);
		parent.add(white);
		parent.add(blue);
		parent.add(green);
		parent.add(cyan);
		parent.add(magenta);
		parent.add(orange);
		parent.add(pink);
		parent.add(red);
		parent.add(yellow);
		parent.add(gray);
		parent.add(darkGray);
		parent.add(lightGray);
	}

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

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String command = actionEvent.getActionCommand();
		switch(command) {
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
		System.out.println("set color" + this.color);
		property.setBackColor(this.color);

	}
}
