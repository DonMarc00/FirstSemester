package sorty;

public class HeapSort implements SortAlgorithm{

	@Override
	public void sort(Data data) {
			
			int n = data.size();
			
			for(int i = n/2 -1 ; i >= 0; i--) {
				heapify(data, n, i);
			}
			
			for (int i = n - 1; i > 0; i--) {
	            data.swap(i, 0);
	          
	            heapify(data, i, 0);
	        }
			
		

		
		

		
	}



	private void heapify(Data data, int n, int i) {
		int max = i;
		int l = 2*i +1;
		int r = 2*i+2;
		
		if(l < n && data.get(l) > data.get(max)) {
			max = l;
		}
		if(r < n && data.get(r)>data.get(max)) {
			max = r;
		}
		
		if(max != i) {
			data.swap(i, max);
            heapify(data, n, max);
 
		
		
	}
	}


	
}
