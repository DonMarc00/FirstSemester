package Algorithmen;

import java.util.Arrays;

public class MergeSort {

	  public static int[] testArr = { 14, 24, 12, 6, 11, 35, 6, 1, 10, 9, 2, 17, 3, 19 };

	    public static void sort(int[] arr, int l, int r) {
	        
	        if (l < r) {
	            int mid = (l + r) / 2;
	            
	            sort(arr, l, mid);
	            sort(arr, mid + 1, r);
	            merge(arr, l, mid, r);
	        }
	        
	    }

	    private static void merge(int[] arr, int l, int m, int r) {
	        int[] iarr = new int[arr.length];
	        int i, j;
	        for (i = l; i <= m; i++) {
	            iarr[i] = arr[i];
	        }
	        for (j = m + 1; j <= r; j++) {
	            iarr[r + m + 1 - j] = arr[j];
	        }
	        i = l;
	        j = r;
	        for (int k = l; k <= r; k++) {
	            if (iarr[i] <= iarr[j]) {
	                arr[k] = iarr[i];
	                i++;
	            } else {
	                arr[k] = iarr[j];
	                j--;
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	int[] arr = testArr;
	    	sort(arr, 0, testArr.length - 1);
	        System.out.println(Arrays.toString(arr));
	    } 
}
