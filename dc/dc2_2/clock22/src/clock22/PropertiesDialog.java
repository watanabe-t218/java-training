package clock22;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PropertiesDialog extends JDialog implements ActionListener {
	private String[] colors = {"black", "white", "red", "blue", "green", "yellow", "orange", "pink", "cyan", "gray", "light gray", "dark gray"};
	private String[] sizes;
	{
		sizes = new String[24];
		for (int i = 0; i < 24; i++) {
			sizes[i] = Integer.toString((i + 1) * 10);
		}
	}
	private JFrame frame;
	private ClockProperties props = ClockProperties.getInstance();
	private final Font f = props.getFontFamily();
	private final int sz = props.getFontSize();
	private final Color c = props.getColor();
	private final Color bg = props.getBgColor(); 
	private final Color flip = props.getFlipColor();
	
	
	public PropertiesDialog(JFrame owner) {
		super(owner, "Properties", true);
		frame = owner;
		this.setSize(new Dimension(400, 400));
		JPanel main = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		main.setLayout(layout);
		setResizable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.EAST;
		JLabel fontLabel = new JLabel("Font");
		layout.setConstraints(fontLabel, gbc);
		gbc.gridy = 1;
		JLabel fontSizeLabel = new JLabel("FontSize");
		layout.setConstraints(fontSizeLabel, gbc);
		gbc.gridy = 2;
		JLabel colorLabel = new JLabel("FontColor");
		layout.setConstraints(colorLabel, gbc);
		gbc.gridy = 3;
		JLabel bgColorLabel = new JLabel("BackgroundColor");
		layout.setConstraints(bgColorLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;

		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		List<String> fontNames = new ArrayList<>();
        for (Font f: g.getAllFonts()) {	
        	fontNames.add(f.getFontName());
        }
        JComboBox<String> fontChoice = new JComboBox<>(fontNames.toArray(new String[0]));
        fontChoice.addActionListener(new FontFamilyChangeListener(fontChoice));
        fontChoice.setSelectedItem(props.getFontFamily().getFontName());
		layout.setConstraints(fontChoice, gbc);
				
		gbc.gridy = 1;
		JComboBox<String> fontSizeChoice = new JComboBox<>(sizes);
		fontSizeChoice.addItemListener(new FontSizeChangeListener(fontSizeChoice));
		fontSizeChoice.setSelectedItem(props.getFontSize() + "");
		layout.setConstraints(fontSizeChoice, gbc);
		
        JMenu colorMenu = new JMenu("Color");
        JMenu backgroundColorMenu = new JMenu("Background Color");
        JMenu fontColorMenu = new JMenu("Font Color");
		for (String s: colors) {
        	Icon icon = new ColorIcon(ColorUtil.toColor(s));
        	JMenuItem m1 = new JMenuItem(s, icon);
        	JMenuItem m2 = new JMenuItem(s, icon);
        	JMenuItem m3 = new JMenuItem(s, icon);
        	m2.addActionListener(new BackgroundColorChangeListener());
        	m3.addActionListener(new FontColorChangeListener());
        }
		
		gbc.gridy = 2;
		JComboBox<String> colorChoice = new JComboBox<String>(colors);
		colorChoice.addActionListener(new FontColorChangeListener(colorChoice));
		layout.setConstraints(colorChoice, gbc);
		
		gbc.gridy = 3;
		JComboBox<String> bgColorChoice = new JComboBox<>(colors);
		layout.setConstraints(bgColorChoice, gbc);
		bgColorChoice.addActionListener(new BackgroundColorChangeListener(bgColorChoice));
		
		colorChoice.setSelectedItem(ColorUtil.toString(props.getColor()));
		bgColorChoice.setSelectedItem(ColorUtil.toString(props.getBgColor()));

		
		main.add(fontLabel);
		main.add(fontChoice);
		main.add(fontSizeLabel);
		main.add(fontSizeChoice);
		main.add(colorLabel);
		main.add(colorChoice);
		main.add(bgColorLabel);
		main.add(bgColorChoice);
		
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, main);
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e -> {
			props.setFontFamily(f);
			props.setFontSize(sz);
			props.setColor(c);
			props.setBgColor(bg);
			props.setFlipColor(flip);
			setVisible(false);
		});
		JButton ok = new JButton("OK");
		ok.addActionListener(e -> {
			setVisible(false);
		});
		bottom.add(BorderLayout.WEST, cancel);
		bottom.add(BorderLayout.EAST, ok);
		add(BorderLayout.SOUTH, bottom);
		addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			setVisible(false);
    		}
    	});
		System.out.println(this.getComponentCount());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
