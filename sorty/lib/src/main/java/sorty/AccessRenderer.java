package sorty;

import java.awt.Color;

public class AccessRenderer implements DataListener {

    private final BarModel bars;
    private final SortCanvas canvas;

    private final Color highlightColorCompare = Color.GREEN;
    private final Color highlightColorPrimary = Color.RED;
    private final Color highlightColorReplace = Color.RED;
    private final int pauseMillis = 1;

    public AccessRenderer(SortCanvas canvas, BarModel bars) {
        this.canvas = canvas;
        this.bars = bars;
    }

    @Override public void beforeSwapping(int replacePosition, int withPosition) {
        bars.getBar(replacePosition).setDisplayColor(highlightColorPrimary);
        bars.getBar(withPosition).setDisplayColor(highlightColorReplace);
        canvas.repaint();
        delay(pauseMillis);
    }

    @Override public void afterSwapping(int replacePosition, int withPosition) {
        bars.swapBars(replacePosition, withPosition);
        canvas.repaint();
        delay(pauseMillis);
        bars.getBar(replacePosition).setDisplayColor(Bar.DEFAULT_COLOR);
        bars.getBar(withPosition).setDisplayColor(Bar.DEFAULT_COLOR);
        canvas.repaint();
    }

    private int lastPosition = -1;

    @Override public void readAccess(int position) {
        bars.getBar(position).setDisplayColor(highlightColorCompare);
        if (lastPosition >= 0) {
            canvas.repaint();
            delay(pauseMillis);
            bars.getBar(lastPosition).setDisplayColor(Bar.DEFAULT_COLOR);
            bars.getBar(position).setDisplayColor(Bar.DEFAULT_COLOR);
            canvas.repaint();
            lastPosition = -1;
        } else {
            lastPosition = position;
        }
    }

    private void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
