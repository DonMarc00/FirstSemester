package Algorithmen;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
      
		int[] arr = ArrayCreator.createArray(8);
		int i = search(arr, 7);
		if(i == -1) {
			System.out.println("Nothing found");
		} else
			System.out.println(i);
	}

	// returns index in array
	public static int search(int[] arr, int i) {
		BubbleSortPermu.bubblesort(arr);
		System.out.println(Arrays.toString(arr));
		int l = 0;
		int r = arr.length-1;
		
		while(l <= r) {
		    int m =l+ (r-l)/2;
		    if(arr[m] == i) {
		    	return m;
		    } else if (arr[m] < i) {
		    	l = m+1;
		    } else
		    	r = m-1;
		}
		//If nothing found
		return -1;
	}

}
