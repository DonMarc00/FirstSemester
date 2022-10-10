package Algorithmen;

import java.util.Random;

public class ArrayCreator {
	
	public static int[] createArray(int n) {
		int[] rarr = new int[n];
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
}
