package task1;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CPanel extends JPanel {

	public CPanel(Color color, int h, int w) {
		super();
		setBackground(color);
		setPreferredSize(new Dimension(h, w));
	}

}
