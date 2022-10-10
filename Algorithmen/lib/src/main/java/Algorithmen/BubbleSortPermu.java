package Algorithmen;

public class BubbleSortPermu {
	
	public static int[] bubblesort(int[] input) {
		 if(input==null || input.length==0)
			 return null;
		 
		 boolean swapped;
		 int size = input.length;
		 for(int i = 0; i < size-1; i++) {
			 swapped = false;
			 for(int j = 0; j < size-i-1; j++) {
				 if(input[j]>input[j+1]){
					 int temp = input[j];
					 input[j] = input[j+1];
					 input[j+1] = temp;
					 swapped = true;
					 }
			 }
			 if(swapped == false)
				 break;
		 }
		 return input;
		
	}

	public static void main(String[] args) {
       ArrayCreator.printArray(bubblesort(ArrayCreator.createArray(8)));
	}

}
