/**
 *
 */
package clock24;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import clock24.Properties;

public class FontFamilyChangeListener implements ActionListener {
	private JComboBox<String> choice;

	public FontFamilyChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}

	public FontFamilyChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Properties props = Properties.getInstance();
		if (choice == null)
			props.setFontFamily(Font.decode(e.getActionCommand()));
		else
			props.setFontFamily(Font.decode((String) choice.getSelectedItem()));
	}

}
