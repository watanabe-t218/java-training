package clock22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class FontSizeChangeListener implements ItemListener {

	private JComboBox choice;
	
	
	public FontSizeChangeListener(JComboBox fontSizeJComboBox) {
		choice = fontSizeJComboBox;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		ClockProperties props = ClockProperties.getInstance();
		props.setFontSize(Integer.valueOf((String) choice.getSelectedItem()));
	}

}
