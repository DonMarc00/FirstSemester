package Algorithmen;

import java.util.Random;

public class InsertSort {

	public static int[] sort(int[] input) {
		printArray(input);
		int temp = 0;
		int j = 0;
		for (int i = 0; i < input.length; i++) {
			printArray(input);
			j = i;
			while((j>0)&&(input[j-1]>input[j])) {
				temp = input[j-1];
				input[j-1] = input[j];
				input[j] = temp;
				j--;
			}
		}
		return input;
	}
	
	public static int[] createArray() {
		int[] rarr = new int[8];
		Random r = new Random();
		for (int i = 0; i < rarr.length; i++) {
			rarr[i] = (int)r.nextInt(20);
		}
		return rarr;
	}
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.print("]");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		printArray(sort(createArray()));

	}

}
