package sorty;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
  
	public static final Color DEFAULT_COLOR = Color.BLUE;

    private final int marginTop;
    private final int marginBottom;
    private final int marginLeft;
    private final int marginRight;
    private final int maxBarHeight;
    private final int maxBarWidth;
    private final int barHeight;
    private final int barWidth;
    private final Integer percent;
    private Color displayColor = DEFAULT_COLOR;

    public Bar(Integer percent, int marginTop, int marginLeft, int marginRight, int marginBottom, int maxBarWidth,
                    int maxBarHeight) {
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.maxBarHeight = maxBarHeight;
        this.maxBarWidth = maxBarWidth;
        this.barHeight = maxBarHeight - marginTop - marginBottom;
        this.barWidth = (maxBarWidth - marginLeft - marginRight) * percent / 100;
        this.percent = percent;
    }

    
	public Color getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor( Color displayColor) {
        this.displayColor = displayColor;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public Integer getPercent() {
        return percent;
    }

    public void paint( Graphics g, int deltaX, int deltaY) {
        g.clearRect(deltaX, deltaY, maxBarWidth, maxBarHeight);
        g.setColor(displayColor);
        g.fillRect(deltaX + marginLeft, deltaY + marginTop, barWidth, barHeight);
    }
}
