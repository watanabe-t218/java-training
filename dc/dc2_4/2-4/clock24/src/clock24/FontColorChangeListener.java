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

import clock24.ColorUtil;
import clock24.Properties;


public class FontColorChangeListener implements ActionListener {
	private JComboBox<String> choice;

	public FontColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	public FontColorChangeListener() {
		this.choice = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Properties props = Properties.getInstance();
		if (choice == null)
			props.setColor(ColorUtil.toColor(e.getActionCommand()));
		else
			props.setColor(ColorUtil.toColor((String) choice.getSelectedItem()));
	}

}
