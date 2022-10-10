package Algorithmen;


public class QuickSort {
	
	public static int[] arr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };

    public static void sort(int left, int right) {
        int q;
        if (left < right) {
            q = partition(left, right);
            sort(left, q);
            sort(q + 1, right);
        }
        
    }

    private static int partition(int left, int right) {
        int i, j, p = arr[(left + right) / 2];
        i = left - 1;
        j = right + 1;

        do {
            i++;
        } while (arr[i] < p);

        do {
            j--;
        } while (arr[j] > p);

        if (i < j) {
            int k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        } else {
            return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        sort(0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }
    }

}
