package sorty;

public class Starter {

    public static void main(String[] args) {

        Data data = new Data(100);

        MainWindow m = new MainWindow(data);
        m.pack();
        m.setLocationByPlatform(true);
        m.setVisible(true);

//        SortAlgorithm bubbleSort = new BubbleSort();
//        bubbleSort.sort(data);
        SortAlgorithm mergeSort = new MergeSortV2();
        mergeSort.sort(data);
    }

}
