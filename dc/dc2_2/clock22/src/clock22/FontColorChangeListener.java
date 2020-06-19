package clock22;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JMenu;

public class FontColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	// private Choice choice;
	
	public FontColorChangeListener(JComboBox<String> colorChoice) {
		this.choice = colorChoice;
	}

	public FontColorChangeListener() {
		this.choice = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ClockProperties props = ClockProperties.getInstance();
		props.setColor(ColorUtil.toColor((String) choice.getSelectedItem()));	
	}

}
