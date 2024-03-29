package task1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CWindow extends JFrame {
	
	CLabel test = new CLabel("GUIs sind prima!");
	CPanel panel;
	JFrame frame = new JFrame();

	public CWindow() {
		
		super("Aufgabe 1");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		test.setVisible(true);
		
		

		
		panel = new CPanel(Color.black, 300,300);
		panel.setVisible(true);
		add(panel);
		panel.add(test);
		test.setBounds(200, 160, 200, 15);
	
	    addKeyListener(cKeyListener);
		pack();
		setVisible(true);
		
		
		
	}
	
	KeyListener cKeyListener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_R) {
				test.setForeground(Color.red);
			} else if (e.getKeyCode() == KeyEvent.VK_G) {
				test.setForeground(Color.green);
			} else if (e.getKeyCode() == KeyEvent.VK_B) {
				test.setForeground(Color.blue);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	
}

