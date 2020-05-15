package interpret;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class JTableButtonMouseListener extends MouseAdapter {
	private final JTable table;
	private String typeName = "type";
	List<Object> inputParams = new ArrayList<Object>();
	private int index = 0;
	private boolean isExistTypeNames = false;
	private List<String> instanceFieldTypes = new ArrayList<String>();
	private boolean isArray = false;

	public JTableButtonMouseListener(JTable table) {
		this.table = table;
	}

	public JTableButtonMouseListener(JTable table, List<Object> inputParams) {
		this.table = table;
		this.inputParams = inputParams;
	}

	public JTableButtonMouseListener(JTable table, List<Object> inputParams, int index) {
		this.table = table;
		this.inputParams = inputParams;
		this.index = index;
	}

	public JTableButtonMouseListener(JTable table, List<String> instanceFieldTypes, List<Object> inputParams) {
		this.isExistTypeNames = true;
		this.table = table;
		this.instanceFieldTypes = instanceFieldTypes;
		this.inputParams = inputParams;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int column = table.getColumnModel().getColumnIndexAtX(e.getX());
		int row = e.getY() / table.getRowHeight();

		if (column == 1) {

			if (!isExistTypeNames) {
				Object typeName = table.getValueAt(row, 0);
				this.typeName = typeName.toString();
				if(this.typeName.contains("[")) {
					this.isArray = true;
					try {
						ParamInput frame = new ParamInput(this.typeName, this.inputParams, row, true);
						frame.setVisible(true);
					} catch (Exception makeInputFrameException) {
						makeInputFrameException.printStackTrace();
					}	
					
				} else {
					this.isArray = false;
					try {
						ParamInput frame = new ParamInput(this.typeName, this.inputParams, row, this.isArray);
						frame.setVisible(true);
					} catch (Exception makeInputFrameException) {
						makeInputFrameException.printStackTrace();
					}					
				}
			} else {
				Object typeName = this.instanceFieldTypes.get(row);
				this.typeName = typeName.toString();
				if(this.typeName.contains("[")) {
					try {
						this.isArray = true;
						ParamInput frame = new ParamInput("array num", this.inputParams, row, true);
						frame.setVisible(true);
					} catch (Exception makeInputFrameException) {
						makeInputFrameException.printStackTrace();
					}	
					
				} else {
					this.isArray = false;
					try {
						ParamInput frame = new ParamInput(this.typeName, this.inputParams, row, this.isArray);
						frame.setVisible(true);
					} catch (Exception makeInputFrameException) {
						makeInputFrameException.printStackTrace();
					}
				}
			}
		}
	}
}
