package SENG401.PerfCakeGUI.gui;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class ConsoleBoxController extends OutputStream {
	private static JTextArea box;
	private static ConsoleBoxController instance = new ConsoleBoxController();
	public static void setBox(JTextArea pbox) { box = pbox; System.setOut(new PrintStream(instance));}
	public static JTextArea getBox() { return box; }
	
	private ConsoleBoxController() {
	}
	
	@Override
	public void write(int b) {
		box.append(String.valueOf((char) b));
		box.setCaretPosition(box.getDocument().getLength());
	}
	
	
}
