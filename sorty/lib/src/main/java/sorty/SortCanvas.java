package sorty;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SortCanvas extends JPanel {

    /** generated serial version uid */
    private static final long serialVersionUID = -4193607098008850970L;
    @SuppressWarnings("exports")
	public static final Color BAR_COLOR = Color.BLUE;

    private final Data data;
    private final BarModel barModel;
    private final int barWidth = 1000;
    private final int barHeight = 8;
    private final int marginVertical = 1;
    private final int marginHorizontal = 5;

    public SortCanvas(Data data) {
        super();
        this.data = data;
        this.barModel = new BarModel(data, marginVertical, marginHorizontal, marginHorizontal, marginVertical, barWidth,
                        barHeight);
        this.setPreferredSize(new Dimension(barWidth, data.size() * barHeight));
        data.addListener(new AccessRenderer(this, barModel));
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < data.size(); i++) {
            barModel.getBar(i).paint(g, 0, i * barHeight);
        }
    }

}
