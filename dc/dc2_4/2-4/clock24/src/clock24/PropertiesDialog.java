package clock24;

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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clock24.ColorUtil;
import clock24.ColorIcon;
import clock24.BackgroundColorChangeListener;
import clock24.FontColorChangeListener;
import clock24.FontFamilyChangeListener;
import clock24.FontSizeChangeListener;
import clock24.ComboBoxRenderer;



@SuppressWarnings("serial")
public class PropertiesDialog extends JDialog implements ActionListener {
	private String[] colors = {"black", "white", "red", "blue", "green", "yellow", "orange", "pink", "cyan", "gray", "light gray", "dark gray"};
	private Integer[] index = new Integer[colors.length];
	private ColorIcon[] icons = new ColorIcon[colors.length];
	{
		for (int i = 0; i < colors.length; i++) {
			index[i] = i;
			icons[i] = new ColorIcon(ColorUtil.toColor(colors[i]));
		}
	}
	private String[] sizes;
	{
		sizes = new String[24];
		for (int i = 0; i < 24; i++) {
			sizes[i] = Integer.toString((i + 1) * 10);
		}
	}
	private JFrame frame;
	private Properties props = Properties.getInstance();
	private final Font f = props.getFontFamily();
	private final int sz = props.getFontSize();
	private final Color c = props.getColor();
	private final Color bg = props.getBgColor();


	public PropertiesDialog(JFrame owner) {
		super(owner, "Properties", true);
		frame = owner;
		this.setSize(new Dimension(400, 200));
		JPanel main = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		main.setLayout(layout);

		JPanel button = new JPanel();
		GridBagLayout buttonLayout = new GridBagLayout();
		GridBagConstraints buttonGbc = new GridBagConstraints();

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
		JLabel bgColorLabel = new JLabel("BackGroundColor");
		layout.setConstraints(bgColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		// Choice fontChoice = new Choice();
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

		gbc.gridy = 2;
		JComboBox<String> colorChoice = new JComboBox<>(colors);
		ComboBoxRenderer renderer = new ComboBoxRenderer(icons, colors);
		// renderer.setPreferredSize(new Dimension(100, 30));
		colorChoice.setRenderer(renderer);
		// colorChoice.setMaximumRowCount(icons.length);
		colorChoice.addActionListener(new FontColorChangeListener(colorChoice));
		layout.setConstraints(colorChoice, gbc);

		gbc.gridy = 3;
		JComboBox<String> bgColorChoice = new JComboBox<>(colors);
		bgColorChoice.setRenderer(renderer);
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
		add(BorderLayout.SOUTH, main);
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e -> {
			props.setFontFamily(f);
			props.setFontSize(sz);
			props.setColor(c);
			props.setBgColor(bg);
			setVisible(false);
		});
		JButton ok = new JButton("OK");
		ok.addActionListener(e -> {
			setVisible(false);
		});

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(ok, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(cancel, gbc);

//		bottom.add(BorderLayout.CENTER, cancel);
//		bottom.add(BorderLayout.EAST, ok);
//		add(BorderLayout.SOUTH, bottom);
//		gbc.gridx = 2;
//		gbc.gridy = 5;
//		layout.setConstraints(bottom, gbc);
//		add(BorderLayout.SOUTH, bottom);
		main.add(ok);
		main.add(cancel);

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
