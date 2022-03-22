package sorty;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

    /** generated serial version uid */
    private static final long serialVersionUID = -4130231758083182686L;

    public MainWindow(Data data) {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new SortCanvas(data));
    }
}
