import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] argv) throws Exception {
		JTextField textField = new JTextField();
		textField.addKeyListener(new Keychecker());

		JFrame jframe = new JFrame();
		jframe.add(textField);
		jframe.setSize(400, 350);
		jframe.setVisible(true);
	}


}
