package task3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridLayoutTest extends JFrame {

	public GridLayoutTest() {
		super("GridLayout");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.white);
		c.setLayout(new GridLayout(3, 3, 10, 10));

		for (int i = 1; i <= 5; i++) {
			JButton button = new JButton(Integer.toString(i));
			button.setPreferredSize(new Dimension(50, 50));
			button.setMaximumSize(new Dimension(50, 50));
			c.add(button);
		}
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutTest();
	}

}
