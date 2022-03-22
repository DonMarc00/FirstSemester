package sorty;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class BarModel {

    private final Map<Integer, Bar> bars;

    public BarModel(Data data, int marginTop, int marginLeft, int marginRight, int marginBottom, int maxBarWidth,
                    int maxBarHeight) {
        this.bars = initBars(data, marginTop, marginLeft, marginRight, marginBottom, maxBarWidth, maxBarHeight);
    }

    private Map<Integer, Bar> initBars(Data data, int marginTop, int marginLeft, int marginRight, int marginBottom,
                    int maxBarWidth, int maxBarHeight) {
        Map<Integer, Bar> returnValue = new TreeMap<>((x, y) -> x.compareTo(y));
        for (int i = 0; i < data.size(); i++) {
            returnValue.put(i, new Bar(data.get(i), marginTop, marginLeft, marginRight, marginBottom, maxBarWidth,
                            maxBarHeight));
        }
        return returnValue;
    }

    public void swapBars(int position1, int position2) {
        Bar barAt1 = bars.put(position1, bars.get(position2));
        bars.put(position2, barAt1);
    }

    public Collection<Bar> getBarsOrdered() {
        return bars.values();
    }

    public Bar getBar(int position) {
        return bars.get(position);
    }
}
