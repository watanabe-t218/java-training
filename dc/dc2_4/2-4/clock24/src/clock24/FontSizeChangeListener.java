/**
 *
 */
package clock24;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import clock24.Properties;

public class FontSizeChangeListener implements ItemListener, ActionListener {

	private JComboBox choice;


	public FontSizeChangeListener(JComboBox fontSizeJComboBox) {
		choice = fontSizeJComboBox;
	}
	public FontSizeChangeListener() {
		choice = null;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		Properties props = Properties.getInstance();
		props.setFontSize(Integer.valueOf((String) choice.getSelectedItem()));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Properties props = Properties.getInstance();
		props.setFontSize(Integer.valueOf(e.getActionCommand()));
	}

}
