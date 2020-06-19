package clock22;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class FontFamilyChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public FontFamilyChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ClockProperties props = ClockProperties.getInstance();
		props.setFontFamily(Font.decode((String) choice.getSelectedItem()));
	}

}
