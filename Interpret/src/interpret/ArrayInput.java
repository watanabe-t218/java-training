package interpret;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;

public class ArrayInput extends JFrame {

	private List<Object> arrayInputParams = new ArrayList<Object>(); 
	
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void Create(String typeName, List<Object> inputParams, int index, int arrayNums) {
		try {
			ArrayInput frame = new ArrayInput(typeName, inputParams, index, arrayNums);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ArrayInput(String typeName, List<Object> inputParams, int index, int arrayNums) {
		String typeNameRemoved = typeName.replace("[", "");
		typeNameRemoved = typeNameRemoved.replace("]", "");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{420, 0};
		gbl_contentPane.rowHeights = new int[]{247, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Index", "Value" });
				
				// Class Constructor Param
				table = new JTable();
				table.addMouseListener(new JTableButtonMouseListener(table, arrayInputParams));
				table.setBorder(UIManager.getBorder("TitledBorder.border"));
				
				String[][] data = new String[arrayNums][2];
				for (int i = 0; i < arrayNums; i++) {
					data[i][0] = typeNameRemoved;
					data[i][1] = null;
					arrayInputParams.add(null);
				}
				
				table.setModel(new DefaultTableModel(
					data,
					new String[] {
						"Type", "Value"
					}
				));
				GridBagConstraints gbc_table = new GridBagConstraints();
				gbc_table.insets = new Insets(0, 0, 5, 0);
				gbc_table.gridheight = 4;
				gbc_table.fill = GridBagConstraints.BOTH;
				gbc_table.gridx = 2;
				gbc_table.gridy = 0;
				contentPane.add(table, gbc_table);
				
						JScrollPane tableScrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						GridBagConstraints gbc_scroll_table = new GridBagConstraints();
						gbc_scroll_table.insets = new Insets(0, 0, 5, 0);
						gbc_scroll_table.fill = GridBagConstraints.BOTH;
						gbc_scroll_table.gridx = 0;
						gbc_scroll_table.gridy = 0;
						contentPane.add(tableScrollpane, gbc_scroll_table);
						
						btnNewButton = new JButton("set");
						GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
						gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
						gbc_btnNewButton.gridx = 0;
						gbc_btnNewButton.gridy = 1;
						contentPane.add(btnNewButton, gbc_btnNewButton);
						String typeNameRemoved1 = typeNameRemoved;
						btnNewButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								try {
									switch (typeNameRemoved1) {

										case "byte":
											Object byteArray = Array.newInstance(byte.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(byteArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, byteArray);
											break;

										case "int":
											Object intArray = Array.newInstance(int.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(intArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, intArray);
											break;

										case "short":
											Object shortArray = Array.newInstance(short.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(shortArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, shortArray);
											break;

										case "long":
											Object longArray = Array.newInstance(long.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(longArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, longArray);
											break;

										case "float":
											Object floatArray = Array.newInstance(float.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(floatArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, floatArray);
											break;

										case "double":
											Object doubleArray = Array.newInstance(double.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(doubleArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, doubleArray);
											break;

										case "boolean":
											Object booleanArray = Array.newInstance(boolean.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(booleanArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, booleanArray);
											break;

										case "char":
											Object charArray = Array.newInstance(char.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(charArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, charArray);
											break;

										case "java.lang.String":
										case "class java.lang.String":
											Object stringArray = Array.newInstance(String.class, arrayInputParams.size());
											for(int i = 0; i < arrayInputParams.size(); i++) {
												Array.set(stringArray, i, arrayInputParams.get(i));
											}
											inputParams.set(index, stringArray);
											break;

										default:
											break;
									}
								} catch (Exception arrayConvertError) {
									System.out.println(arrayConvertError);
								}
								close();
							}
						});
	}
	
	private void close() {
		this.dispose();
	}

}
