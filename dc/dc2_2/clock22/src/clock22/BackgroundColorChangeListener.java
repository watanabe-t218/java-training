package clock22;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import clock22.ColorUtil;
import clock22.ClockProperties;

public class BackgroundColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public BackgroundColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	
	public BackgroundColorChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ClockProperties props = ClockProperties.getInstance();
		if (choice == null)
			props.setBgColor(ColorUtil.toColor(e.getActionCommand()));
		else
			props.setBgColor(ColorUtil.toColor((String) choice.getSelectedItem()));
	}

}

