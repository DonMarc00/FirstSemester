package task1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CLabel extends JLabel {

	public CLabel(String input) {
		super(input);
		this.setFont(new Font("Arial", Font.ITALIC, 24));
		this.setForeground(Color.red);
		this.addKeyListener(new CKListener(this));
	}

}

class CKListener extends KeyAdapter{

	CLabel edit;
	
public CKListener(CLabel label) {
	edit = label;
}
	
public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_R) {
			edit.setForeground(Color.red);
		} else if (e.getKeyCode() == KeyEvent.VK_G) {
			edit.setForeground(Color.green);
		} else if (e.getKeyCode() == KeyEvent.VK_B) {
			edit.setForeground(Color.blue);
		}
	}
}