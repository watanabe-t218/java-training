package clock22;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import clock22.PropertiesDialog;
import clock22.ClockProperties;

@SuppressWarnings("serial")
public class ClockFrame extends JFrame implements ActionListener {
	ClockCanvas canvas;
	private JMenuItem exitMenu;
	private int pressedX;
	private int pressedY;
	private PropertiesDialog dialog;
	private JMenuBar menubar;
	private JMenuItem menuitem;
	ClockProperties props = ClockProperties.getInstance();

	public ClockFrame(ClockCanvas canvas) {
		super(null, null);
		this.canvas = canvas;
		
		// MenuBar
		menubar = new JMenuBar();
   	JMenu menu = new JMenu("Setting");
   	JMenuItem menuitem = new JMenuItem("Properties");
   	menuitem.addActionListener(e -> {
 			dialog = new PropertiesDialog(this);
 			dialog.setVisible(true);
   	});
   	menu.add(menuitem);
   	menubar.add(menu);
   	setJMenuBar(menubar);

       setLayout(new BorderLayout());
       addWindowListener(new JAppCloseAdapter());
       add(canvas, BorderLayout.CENTER);
       setAlwaysOnTop(true);
       pack();
       canvas.addMouseMotionListener(new JAppMouseMotionAdapter());
       setLocationRelativeTo(null);
       setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
       if (source.equals(exitMenu)) {
       	props.setDimension(getSize());
   		props.setLocation(getLocation());
   		props.update();
       	System.exit(0);
       }
	}

	void resize() {
       pack();
   }

	class JAppMouseAdapter extends MouseAdapter {

       JPopupMenu popupMenu;

       public JAppMouseAdapter(JPopupMenu popupMenu) {
           this.popupMenu = popupMenu;
       }

       @Override
       public void mousePressed(MouseEvent e) {
           pressedX = e.getX();
           pressedY = e.getY();
           if (e.isPopupTrigger())
               popupMenu.show(canvas, e.getX(), e.getY());
       }

       @Override
       public void mouseReleased(MouseEvent e) {
           mousePressed(e);
       }
   }

	class JAppMouseMotionAdapter extends MouseMotionAdapter {
	    @Override
	    public void mouseDragged(MouseEvent e) {
	    	setLocation(getX() + e.getX() - pressedX, getY() + e.getY()
           - pressedY);
	    }
	}
}

class JAppCloseAdapter extends WindowAdapter {
	@Override
   public void windowClosing(WindowEvent e) {
		ClockProperties props = ClockProperties.getInstance();
		props.setDimension(e.getWindow().getSize());
		props.setLocation(e.getWindow().getLocation());
		props.update();
       System.exit(0);
   }
}
