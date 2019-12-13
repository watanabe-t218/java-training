/**
 * 
 */
package dc1_3;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author takahiro watanabe
 *
 */
public class PropertyDialog extends Dialog implements ActionListener{

	public PropertyDialog(Frame frame) {
		super(frame, "Property");
		setTitle("Property");
        setSize(150, 380);
		
        // Settings
        Panel settingPanels = new Panel();
        settingPanels.setLayout(new GridLayout(5, 1));        
        
        // fontColor
        FontColorSelector fontColorSelector = new FontColorSelector("Font Color");
		settingPanels.add(fontColorSelector);        
        // background color
		BackColorSelector backGroundColorSelector = new BackColorSelector("Background Color");
		settingPanels.add(backGroundColorSelector);
		// font 
		FontSelector fontSelector = new FontSelector("Font");
		settingPanels.add(fontSelector);
		
		// font size
		FontSizeSelector fontSizeSelector = new FontSizeSelector();
		settingPanels.add(fontSizeSelector);
		
		add(settingPanels);
        
		// OK button
		setLayout(new FlowLayout());  
		Button okButton = new Button("OK");
		okButton.addActionListener(this);
        add(okButton);
		
        setResizable(false);
        setVisible(true);
        
        // Exit button action
        addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			setVisible(false);
    		}
    	});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
}