package interpret;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class JTextAreaStream extends OutputStream {
	private JTextArea area;
	private ByteArrayOutputStream buf;

	public JTextAreaStream(JTextArea area) {
		this.area = area;
		buf = new ByteArrayOutputStream();
	}

	@Override
	public void write(int b) throws IOException {
		buf.write(b);
	}

	@Override
	public void flush() throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				area.append(buf.toString());
				buf.reset();
			}
		});

	}

}