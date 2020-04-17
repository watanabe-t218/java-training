package interpret;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

public class FrameJTextAreaStream extends JFrame {

	private JPanel contentPane;
	private JTextArea consoleTextArea;

	/**
	 * Launch the application.
	 */
	public void Create() {
		try {
			FrameJTextAreaStream frame = new FrameJTextAreaStream();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public FrameJTextAreaStream() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {530, 5};
		gbl_contentPane.rowHeights = new int[]{327, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		consoleTextArea = new JTextArea();
		consoleTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		consoleTextArea.setEditable(false);
		JTextAreaStream stream = new JTextAreaStream(consoleTextArea);
		System.setOut(new PrintStream(stream, true));

		consoleTextArea.setForeground(Color.WHITE);
		consoleTextArea.setBackground(Color.BLACK);
		GridBagConstraints gbc_consoleTextArea = new GridBagConstraints();
		gbc_consoleTextArea.gridwidth = 2;
		gbc_consoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_consoleTextArea.gridx = 0;
		gbc_consoleTextArea.gridy = 4;
		contentPane.add(consoleTextArea, gbc_consoleTextArea);
		
		JScrollPane consoleTextAreaScrollpane = new JScrollPane(consoleTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scroll_consoleTextArea = new GridBagConstraints();
		gbc_scroll_consoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_scroll_consoleTextArea.gridx = 0;
		gbc_scroll_consoleTextArea.gridy = 0;
		contentPane.add(consoleTextAreaScrollpane, gbc_scroll_consoleTextArea);
	}

}
