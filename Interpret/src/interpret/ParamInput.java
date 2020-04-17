package interpret;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;

public class ParamInput extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String typeName;
	private JButton btnSet;
	private List<Object> inputParams = new ArrayList<Object>();
	private int index = 0;
	private boolean visibleForm = false;
	
	/**
	 * Create the frame.
	 */
	public ParamInput(String typeName, List<Object> inputParams, int index) {
		
		this.typeName = typeName;
		this.inputParams = inputParams;
		this.index = index;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// layout
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		// typeName
		JLabel lblType = new JLabel(this.typeName);
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 0;
		contentPane.add(lblType, gbc_lblType);
		
		
		// input value 
		textField = new JTextField();
		textField.setVisible(this.isPremitive(typeName));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		// set value
		btnSet = new JButton("set");
		GridBagConstraints gbc_btnSet = new GridBagConstraints();
		gbc_btnSet.insets = new Insets(0, 0, 0, 5);
		gbc_btnSet.gridx = 1;
		gbc_btnSet.gridy = 2;
		contentPane.add(btnSet, gbc_btnSet);
		btnSet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (typeName) {
					
				case "int":
					inputParams.set(index, Integer.parseInt(textField.getText())) ;
					break;
					
				case "short":
					inputParams.set(index, Short.parseShort(textField.getText()));
					break;
				
				case "long":
					inputParams.set(index, Long.parseLong(textField.getText()));
					break;
					
				case "float":
					inputParams.set(index, Float.parseFloat(textField.getText()));
					break;
				
				case "double":
					inputParams.set(index, Double.parseDouble(textField.getText()));
					break;
				
				case "boolean":
					inputParams.set(index, new Boolean(textField.getText()));
					break;
				
				case "char":
					inputParams.set(index, textField.getText());
					break;

				case "java.lang.String":
					inputParams.set(index, textField.getText());
					break;
					
				case "class java.lang.String":
					inputParams.set(index, textField.getText());
					break;	
				
				default:
					try {
						MainForm frame = new MainForm(inputParams, index);
						frame.setVisible(true);
					} catch (Exception CreateNewWindowException) {
						CreateNewWindowException.printStackTrace();
					}
					break;
				}
			}			
		});
	}
	
	private boolean isPremitive(String typeName) {
		boolean isPremitive = false;
		switch (typeName) {
		
		case "int":	
		case "short":
		case "long":
		case "float":	
		case "double":
		case "boolean":
		case "char":
		case "java.lang.String":
		case "class java.lang.String":
			isPremitive = true;
			break;
		
		default:
			isPremitive = false;
			break;
		}
		
		return isPremitive;
	}

}
