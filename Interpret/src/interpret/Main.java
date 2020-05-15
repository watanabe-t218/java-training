package interpret;

import javax.swing.*;
import java.awt.*;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
					frame.setMaximumSize(new Dimension(10000, 10000));
					FrameJTextAreaStream frameJTextAreaStream = new FrameJTextAreaStream();
					frameJTextAreaStream.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

