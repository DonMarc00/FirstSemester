package task2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class TermWindow extends JFrame{
	
	JFrame frame = new JFrame();
	JLabel text;

	public TermWindow() {
       frame.setBounds(10, 10, 300,300);
       frame.addKeyListener(new CKeyListener());
       
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       
       text = new JLabel("Das Fenster ist offen");
       frame.add(text);
       frame.setVisible(true);
	}

}

class CKeyListener extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		int input = e.getKeyCode();

		switch (input) {
		case KeyEvent.VK_A:
			System.out.println("a");
			break;
		case KeyEvent.VK_E:
			System.out.println("E");
			break;
		case KeyEvent.VK_I:
			System.out.println("I");
			break;
		case KeyEvent.VK_O:
			System.out.println("o");
			break;
		case KeyEvent.VK_U:
			System.out.println("U");
			break;
		default:
			System.out.println("Something went wrong");
			break;
		}
	}
}
