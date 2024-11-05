import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Keychecker extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent event) {
		char ch = event.getKeyChar();
		System.out.println(event.getKeyChar());
	}
}
