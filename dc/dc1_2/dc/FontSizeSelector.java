package dc;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeSelector extends Panel {
	Property property = new Property();
	TextField textField;
	Button up;
	Button down;
	static int fontSize;
	
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
		this.up = new Button("ª");
		this.down = new Button("«");
		
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
}


