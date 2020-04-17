package interpret;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class MainForm extends JFrame {

	public int step = 0;
	public int instanceMethodStep = 0;
	CreateObject createObjectInstance;
	java.lang.reflect.Type[] constructorParams;
	ArrayList<CreateObject> CreateObjectList = new ArrayList<CreateObject>();
	List<Object> inputParams = new ArrayList<Object>(); // constructor input params
	List<Object> parentsInputParams;
	List<Object> instanceParams = new ArrayList<Object>(); // constructor input params
	Object createdObject;
	int parentIndex = 0;
	List<Object> instanceMethodParams = new ArrayList<Object>();
	List<String> instanceFieldTypes = new ArrayList<String>();


	private JPanel contentPane;
	private JTextField objectClassTextField;
	private JTextField objectNameTextField;
	private JLabel lblObjectName;
	private JLabel lblObjectClass;
	private JTextArea consoleTextArea;
	private JComboBox<?> comboBox;
	private JComboBox<String> constructorComboBox;
	private JLabel constructorLabel;
	private JTable table;
	private JTable table_1;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblField;
	private JTextField instanceFieldTextField;
	private JLabel lblMethod;
	private JButton instanceContinueButton;
	private JTable instanceParamTable;
	private JTable instanceFieldTable;
	private JTable table_4;
	private JComboBox instanceMethodComboBox;
	private JButton btnChangeFields;
	private JLabel lblCurrentinStance;
	private JButton btnSetToParam;

	/**
	 * Create the frame.
	 */
	public MainForm() {

		Create();
	}

	public MainForm(List<Object> inputParams, int parentIndex) {
		Create();
		this.parentsInputParams = inputParams;
		this.parentIndex = parentIndex;
	}
	
	public void Create() {

		// layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 135, 300, 350, 0, 350 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 10, 0, 10, 10, 10, 10, 28, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
				
						lblObjectClass = new JLabel("Object Class");
						GridBagConstraints gbc_lblObjectClass = new GridBagConstraints();
						gbc_lblObjectClass.insets = new Insets(0, 0, 5, 5);
						gbc_lblObjectClass.anchor = GridBagConstraints.WEST;
						gbc_lblObjectClass.gridx = 0;
						gbc_lblObjectClass.gridy = 0;
						contentPane.add(lblObjectClass, gbc_lblObjectClass);
		
				objectClassTextField = new JTextField();
				GridBagConstraints gbc_objectClassTextField = new GridBagConstraints();
				gbc_objectClassTextField.gridwidth = 4;
				gbc_objectClassTextField.insets = new Insets(0, 0, 5, 0);
				gbc_objectClassTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_objectClassTextField.gridx = 1;
				gbc_objectClassTextField.gridy = 0;
				contentPane.add(objectClassTextField, gbc_objectClassTextField);
				objectClassTextField.setColumns(10);
		
				lblObjectName = new JLabel("Object Name");
				GridBagConstraints gbc_lblObjectName = new GridBagConstraints();
				gbc_lblObjectName.insets = new Insets(0, 0, 5, 5);
				gbc_lblObjectName.anchor = GridBagConstraints.WEST;
				gbc_lblObjectName.gridx = 0;
				gbc_lblObjectName.gridy = 1;
				lblObjectName.setVisible(false);
				contentPane.add(lblObjectName, gbc_lblObjectName);
		
				objectNameTextField = new JTextField();
				GridBagConstraints gbc_objectNameTextField = new GridBagConstraints();
				gbc_objectNameTextField.gridwidth = 4;
				gbc_objectNameTextField.insets = new Insets(0, 0, 5, 0);
				gbc_objectNameTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_objectNameTextField.gridx = 1;
				gbc_objectNameTextField.gridy = 1;
				contentPane.add(objectNameTextField, gbc_objectNameTextField);
				objectNameTextField.setVisible(false);
				objectNameTextField.setColumns(10);
		
				constructorLabel = new JLabel("Constructor");
				GridBagConstraints gbc_constructorLabel = new GridBagConstraints();
				gbc_constructorLabel.insets = new Insets(0, 0, 5, 5);
				gbc_constructorLabel.anchor = GridBagConstraints.WEST;
				gbc_constructorLabel.gridx = 0;
				gbc_constructorLabel.gridy = 2;
				constructorLabel.setVisible(false);
				contentPane.add(constructorLabel, gbc_constructorLabel);

		consoleTextArea = new JTextArea();
		consoleTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		consoleTextArea.setEditable(false);
		JTextAreaStream stream = new JTextAreaStream(consoleTextArea);
		System.setOut(new PrintStream(stream, true));

		
		// Class object create Button
		JButton objectCreateButton = new JButton("Continue");
		objectCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (step) {
				case 0:// class name
					String objectName = objectNameTextField.getText();
					String className = objectClassTextField.getText();

					if (!className.equals("")) {
						createObjectInstance = new CreateObject(objectName, className);
						Constructor<?>[] constructors = createObjectInstance.getConstructors();

						if (constructors != null) {
							constructorComboBox.setVisible(true);
							constructorLabel.setVisible(true);
							constructorComboBox.removeAllItems();
							for (Constructor<?> constructor : constructors) {
								constructorComboBox.addItem(constructor.toString());
							}

							step++;
							objectNameTextField.setEditable(false);
							objectClassTextField.setEditable(false);
						}
					}
					break;
				case 1:// constructor
					java.lang.reflect.Type[] params = createObjectInstance
							.getConstructorParams(constructorComboBox.getSelectedIndex());
					constructorParams = params;
					String[][] data = new String[constructorParams.length][2];
					for (int i = 0; i < constructorParams.length; i++) {
						data[i][0] = constructorParams[i].getTypeName();
						data[i][1] = null;
						inputParams.add(null);
					}
					DefaultTableModel paramModel = new DefaultTableModel(data, new String[] { "Param", "Value" });
					table.setModel(paramModel);

					constructorComboBox.removeAllItems();
					constructorComboBox.addItem(createObjectInstance.getConstructor().toString());
					objectCreateButton.setText("Create");
					step++;
					break;
				case 2:
					table.repaint();

					createdObject = createObjectInstance.createObject(inputParams.toArray());

					if (createdObject == null) {
						System.out.println("Could not Create Object");
						break;
					}

					objectCreateButton.setText("Continue");
					objectNameTextField.setText("");
					objectNameTextField.setEditable(true);
					objectClassTextField.setText("");
					objectClassTextField.setEditable(true);
					constructorComboBox.removeAllItems();
					constructorComboBox.setVisible(false);
					constructorLabel.setVisible(false);

					DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
							new String[] { "Param", "Value" });
					table.setModel(defaultTableModel);

					DefaultTableModel defaultTableModel1 = (DefaultTableModel) table_1.getModel();
					defaultTableModel1.addRow(new Object[] { createdObject.getClass(), createdObject.toString() });
					table_1.setModel(defaultTableModel1);
					
					//////////////////////////
					// For instance control //
					//////////////////////////
					lblCurrentinStance.setText(createObjectInstance.instance.toString());
					instanceMethodComboBox.removeAllItems();
					for (Method method : createObjectInstance.instance.getClass().getMethods()) {
						instanceMethodComboBox.addItem(method.toString());
					}
					
					Field[] instanceFields = createObjectInstance.getFields();
					if(instanceFields != null) {
						
						try {
							String[][] instanceFieldsString = new String[instanceFields.length][2];
							instanceFieldTypes.clear();
							for (int i = 0; i < instanceFields.length; i++) {
								instanceFieldsString[i][0] = instanceFields[i].getName();
								instanceFieldTypes.add(instanceFields[i].getType().toString());
								try {
									if(instanceFields[i].get(createObjectInstance.instance) != null) {
										instanceFieldsString[i][1] = instanceFields[i].get(createObjectInstance.instance).toString();
										instanceParams.add(instanceFields[i].get(createObjectInstance.instance));
									} else
									{
										instanceParams.add(null);
									}
								} catch (IllegalArgumentException | IllegalAccessException e1) {
									System.out.println(e1);
									step = 0;
								}
							}
							DefaultTableModel instanceFieldsModel = new DefaultTableModel(instanceFieldsString, new String[] { "Field", "Value" });
							instanceFieldTable.setModel(instanceFieldsModel);
						} catch (NullPointerException e2) {
							System.out.println(e2);
						}
					} else {
						DefaultTableModel modelInstanceField = new DefaultTableModel(
								new Object[][] {},
								new String[] { "Field", "Value" });
						instanceFieldTable.setModel(modelInstanceField);
					}
					
					step = 0;
					break;
				}

			}
		});

		// Class Constructor Param
		table = new JTable();
		table.addMouseListener(new JTableButtonMouseListener(table, inputParams));
		table.setBorder(UIManager.getBorder("TitledBorder.border"));
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Param", "Value" });
		
				constructorComboBox = new JComboBox();
				GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
				gbc_comboBox_1.gridwidth = 4;
				gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
				gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_1.gridx = 1;
				gbc_comboBox_1.gridy = 2;
				constructorComboBox.setVisible(false);
				contentPane.add(constructorComboBox, gbc_comboBox_1);
		table.setModel(defaultTableModel);
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
		gbc_scroll_table.insets = new Insets(0, 0, 5, 5);
		gbc_scroll_table.gridheight = 5;
		gbc_scroll_table.gridwidth = 2;
		gbc_scroll_table.fill = GridBagConstraints.BOTH;
		gbc_scroll_table.gridx = 2;
		gbc_scroll_table.gridy = 5;
		contentPane.add(tableScrollpane, gbc_scroll_table);

		table_1 = new JTable();
		table_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		DefaultTableModel defaultTableModel1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Class", "Name" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table_1.setModel(defaultTableModel1);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridheight = 2;
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 2;
		gbc_table_1.gridy = 6;
		contentPane.add(table_1, gbc_table_1);

		JScrollPane table1Scrollpane = new JScrollPane(table_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scroll_table1 = new GridBagConstraints();
		gbc_scroll_table1.fill = GridBagConstraints.BOTH;
		gbc_scroll_table1.insets = new Insets(0, 0, 5, 5);
		gbc_scroll_table1.gridwidth = 2;
		gbc_scroll_table1.gridx = 2;
		gbc_scroll_table1.gridy = 12;
		contentPane.add(table1Scrollpane, gbc_scroll_table1);
		
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
		gbc_scroll_consoleTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_scroll_consoleTextArea.gridheight = 8;
		gbc_scroll_consoleTextArea.gridwidth = 2;
		gbc_scroll_consoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_scroll_consoleTextArea.gridx = 0;
		gbc_scroll_consoleTextArea.gridy = 5;
		contentPane.add(consoleTextAreaScrollpane, gbc_scroll_consoleTextArea);

		


		GridBagConstraints gbc_objectCreateButton = new GridBagConstraints();
		gbc_objectCreateButton.gridwidth = 4;
		gbc_objectCreateButton.insets = new Insets(0, 0, 5, 0);
		gbc_objectCreateButton.gridx = 1;
		gbc_objectCreateButton.gridy = 3;
		contentPane.add(objectCreateButton, gbc_objectCreateButton);

//		panel
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setToolTipText("");
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridheight = 8;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 4;
		gbc_tabbedPane.gridy = 5;
		contentPane.add(tabbedPane, gbc_tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("Current Instance", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 200, 400, 0 };
		gbl_panel.rowHeights = new int[] { 31, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		lblCurrentinStance = new JLabel("Current Instance");
		lblCurrentinStance.setFont(new Font("MS UI Gothic", Font.BOLD, 12));
		GridBagConstraints gbc_lblCurrentinStance = new GridBagConstraints();
		gbc_lblCurrentinStance.gridwidth = 2;
		gbc_lblCurrentinStance.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentinStance.gridx = 0;
		gbc_lblCurrentinStance.gridy = 0;
		panel.add(lblCurrentinStance, gbc_lblCurrentinStance);


		lblMethod = new JLabel("Method");
		GridBagConstraints gbc_lblMethod = new GridBagConstraints();
		gbc_lblMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblMethod.gridx = 0;
		gbc_lblMethod.gridy = 1;
		panel.add(lblMethod, gbc_lblMethod);

		instanceContinueButton = new JButton("Continue");
		instanceContinueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(instanceMethodStep) {
				case 0:
					if(createObjectInstance == null || createObjectInstance.instance == null) {
						break;
					}
					java.lang.reflect.Type[] methodParams = createObjectInstance.getMethodParams(instanceMethodComboBox.getSelectedIndex());
					String[][] data = new String[methodParams.length][2];
					instanceMethodParams.clear();
					for (int i = 0; i < methodParams.length; i++) {
						data[i][0] = methodParams[i].getTypeName();
						data[i][1] = null;
						System.out.println(1);
						instanceMethodParams.add(null);
					}

					DefaultTableModel paramModel = new DefaultTableModel(data, new String[] { "Param", "Value" });
					instanceParamTable.setModel(paramModel);
					
					instanceMethodComboBox.removeAllItems();
					instanceMethodComboBox.addItem(createObjectInstance.getMethod().toString());
					
					instanceMethodStep++;
					instanceContinueButton.setText("Run Method");
					break;
				default:				
					instanceParamTable.repaint();
					createObjectInstance.runMethod(instanceMethodParams.toArray());
					
					
					instanceMethodComboBox.removeAllItems();
					for (Method method : createObjectInstance.methods) {
						instanceMethodComboBox.addItem(method.toString());
					}
					instanceMethodStep = 0;
					instanceContinueButton.setText("Continue");
					
					Field[] instanceFields = createObjectInstance.getFields();
					if(instanceFields != null) {			
						try {
							String[][] instanceFieldsString = new String[instanceFields.length][2];
							instanceFieldTypes.clear();
							for (int i = 0; i < instanceFields.length; i++) {
								instanceFieldsString[i][0] = instanceFields[i].getName();
								instanceFieldTypes.add(instanceFields[i].getType().toString());
								try {
									if(instanceFields[i].get(createObjectInstance.instance) != null) {
										instanceFieldsString[i][1] = instanceFields[i].get(createObjectInstance.instance).toString();
										instanceParams.add(instanceFields[i].get(createObjectInstance.instance));
									} else {
										instanceParams.add(null);
									}
								} catch (IllegalArgumentException | IllegalAccessException e1) {
									System.out.println(e1);
									step = 0;
								}
							}
							DefaultTableModel instanceFieldsModel = new DefaultTableModel(instanceFieldsString, new String[] { "Field", "Value" });
							instanceFieldTable.setModel(instanceFieldsModel);
						} catch (NullPointerException e2) {
							System.out.println(e2);
						}
					} else {
						DefaultTableModel modelInstanceField = new DefaultTableModel(
								new Object[][] {},
								new String[] { "Field", "Value" });
						instanceFieldTable.setModel(modelInstanceField);
					}
					
					break;
					
				}
				
			}
		});
		
		instanceMethodComboBox = new JComboBox();
		GridBagConstraints gbc_instanceMethodComboBox = new GridBagConstraints();
		gbc_instanceMethodComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_instanceMethodComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_instanceMethodComboBox.gridx = 1;
		gbc_instanceMethodComboBox.gridy = 1;
		panel.add(instanceMethodComboBox, gbc_instanceMethodComboBox);
		GridBagConstraints gbc_instanceContinueButton = new GridBagConstraints();
		gbc_instanceContinueButton.anchor = GridBagConstraints.EAST;
		gbc_instanceContinueButton.insets = new Insets(0, 0, 5, 0);
		gbc_instanceContinueButton.gridx = 1;
		gbc_instanceContinueButton.gridy = 3;
		panel.add(instanceContinueButton, gbc_instanceContinueButton);
		
		
		instanceParamTable = new JTable();
		instanceParamTable.addMouseListener(new JTableButtonMouseListener(instanceParamTable, instanceMethodParams));
		instanceParamTable.setBorder(UIManager.getBorder("TitledBorder.border"));
		DefaultTableModel modelInstanceMethodParam = new DefaultTableModel(
				new Object[][] {},
				new String[] { "Param", "Value" });
		instanceParamTable.setModel(modelInstanceMethodParam);
		GridBagConstraints gbc_instanceParamTable = new GridBagConstraints();
		gbc_instanceParamTable.gridwidth = 2;
		gbc_instanceParamTable.insets = new Insets(0, 0, 5, 0);
		gbc_instanceParamTable.fill = GridBagConstraints.BOTH;
		gbc_instanceParamTable.gridx = 0;
		gbc_instanceParamTable.gridy = 2;
		panel.add(instanceParamTable, gbc_instanceParamTable);
		
		JScrollPane instanceParamTableScrollpane = new JScrollPane(instanceParamTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scroll_instanceParamTable = new GridBagConstraints();
		gbc_scroll_instanceParamTable.insets = new Insets(0, 0, 5, 0);
		gbc_scroll_instanceParamTable.gridwidth = 2;
		gbc_scroll_instanceParamTable.fill = GridBagConstraints.BOTH;
		gbc_scroll_instanceParamTable.gridx = 0;
		gbc_scroll_instanceParamTable.gridy = 2;
		panel.add(instanceParamTableScrollpane, gbc_scroll_instanceParamTable);

		instanceFieldTable = new JTable();
		instanceFieldTable.addMouseListener(new JTableButtonMouseListener(instanceFieldTable, instanceFieldTypes, instanceParams));
		instanceFieldTable.setBorder(UIManager.getBorder("TitledBorder.border"));
		DefaultTableModel modelInstanceField = new DefaultTableModel(
				new Object[][] {},
				new String[] { "Field", "Value" });
		instanceFieldTable.setModel(modelInstanceField);
		GridBagConstraints gbc_instanceFieldTable = new GridBagConstraints();
		gbc_instanceFieldTable.gridheight = 2;
		gbc_instanceFieldTable.gridwidth = 2;
		gbc_instanceFieldTable.insets = new Insets(0, 0, 5, 0);
		gbc_instanceFieldTable.fill = GridBagConstraints.BOTH;
		gbc_instanceFieldTable.gridx = 0;
		gbc_instanceFieldTable.gridy = 4;
		panel.add(instanceFieldTable, gbc_instanceFieldTable);
		
		JScrollPane instanceFieldTableScrollpane = new JScrollPane(instanceFieldTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scroll_instanceFieldTable = new GridBagConstraints();
		gbc_scroll_instanceFieldTable.insets = new Insets(0, 0, 5, 0);
		gbc_scroll_instanceFieldTable.gridheight = 2;
		gbc_scroll_instanceFieldTable.gridwidth = 2;
		gbc_scroll_instanceFieldTable.fill = GridBagConstraints.BOTH;
		gbc_scroll_instanceFieldTable.gridx = 0;
		gbc_scroll_instanceFieldTable.gridy = 4;
		panel.add(instanceFieldTableScrollpane, gbc_scroll_instanceFieldTable);	
		
		btnChangeFields = new JButton("Change Fields");
		btnChangeFields.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				instanceFieldTable.repaint();
				createObjectInstance.changeFields(instanceParams.toArray());
				
				Field[] instanceFields = createObjectInstance.getFields();
				if(instanceFields != null) {			
					try {
						String[][] instanceFieldsString = new String[instanceFields.length][2];	
						instanceFieldTypes.clear();
						for (int i = 0; i < instanceFields.length; i++) {
							instanceFieldsString[i][0] = instanceFields[i].getName();
							instanceFieldTypes.add(instanceFields[i].getType().toString());
							try {
								if(instanceFields[i].get(createObjectInstance.instance) != null) {
									instanceFieldsString[i][1] = instanceFields[i].get(createObjectInstance.instance).toString();									
								}
							} catch (IllegalArgumentException | IllegalAccessException e1) {
								System.out.println(e1);
								step = 0;
							}
						}
						DefaultTableModel instanceFieldsModel = new DefaultTableModel(instanceFieldsString, new String[] { "Field", "Value" });
						instanceFieldTable.setModel(instanceFieldsModel);
					} catch (NullPointerException e2) {
						System.out.println(e2);
					}
				} else {
					DefaultTableModel modelInstanceField = new DefaultTableModel(
							new Object[][] {},
							new String[] { "Field", "Value" });
					instanceFieldTable.setModel(modelInstanceField);
				}
			}
		});
		GridBagConstraints gbc_btnChangeFields = new GridBagConstraints();
		gbc_btnChangeFields.anchor = GridBagConstraints.EAST;
		gbc_btnChangeFields.gridx = 1;
		gbc_btnChangeFields.gridy = 6;
		panel.add(btnChangeFields, gbc_btnChangeFields);
		
		
		// Set To Param
		btnSetToParam = new JButton("set to param");
		GridBagConstraints gbc_btnSetToParam = new GridBagConstraints();
		gbc_btnSetToParam.insets = new Insets(0, 0, 0, 5);
		gbc_btnSetToParam.gridx = 3;
		gbc_btnSetToParam.gridy = 13;
		contentPane.add(btnSetToParam, gbc_btnSetToParam);
		btnSetToParam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parentsInputParams.set(parentIndex, createdObject);
			}
		});
	}
}
