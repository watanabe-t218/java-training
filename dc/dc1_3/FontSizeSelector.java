package dc1_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeSelector extends Panel implements ActionListener{
	Property property = new Property();
	TextField textField;
	Button up;
	Button down;
	static int fontSize;

	public MenuItem size20 = new MenuItem("20");
	public MenuItem size30 = new MenuItem("30");
	public MenuItem size40 = new MenuItem("40");
	public MenuItem size50 = new MenuItem("50");
	public MenuItem size60 = new MenuItem("60");

	public FontSizeSelector(PopupMenu parent) {
		size20.addActionListener(this);
		size30.addActionListener(this);
		size40.addActionListener(this);
		size50.addActionListener(this);
		size60.addActionListener(this);


		parent.add(size20);
		parent.add(size30);
		parent.add(size40);
		parent.add(size50);
		parent.add(size60);
	}

	public FontSizeSelector() {
		this.fontSize = property.getFontSize();
		Panel mainPanel = new Panel();
		mainPanel.setLayout(new GridLayout(1, 2));
		textField = new TextField();
		textField.setText(String.valueOf(this.fontSize));
		mainPanel.add(textField);
		textField.addActionListener(new textInputAction());
		
		
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		this.up = new Button("up");
		this.down = new Button("down");
		
		buttonPanel.add(this.up);
		buttonPanel.add(this.down);
		mainPanel.add(buttonPanel);
		
		up.addActionListener(new upButtonAction());
		down.addActionListener(new downButtonAction());
		add(mainPanel);
		
	}
	
	public class upButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fontSize++;
			property.setFontSize(fontSize);
			textField.setText(String.valueOf(fontSize));
		}	
	}
	
	public class downButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fontSize > 15) {
				fontSize--;
				property.setFontSize(fontSize);
				textField.setText(String.valueOf(fontSize));
			}
		}	
	}
	
	public class textInputAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int inputSize = Integer.parseInt(textField.getText());
			if(inputSize > 14) {
				fontSize = inputSize;
				property.setFontSize(fontSize);
			}
			else if(inputSize <= 14) {
				fontSize = 15;
				property.setFontSize(fontSize);
				textField.setText(String.valueOf(fontSize));
			}
		}	
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String command = actionEvent.getActionCommand();
		fontSize = Integer.valueOf(command);
		property.setFontSize(fontSize);

		System.out.println("set size" + fontSize);

	}
}


