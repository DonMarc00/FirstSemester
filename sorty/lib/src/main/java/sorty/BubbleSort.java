package sorty;

public class BubbleSort implements SortAlgorithm {

	@Override
	public void sort(Data data) {
		for(int i=0; i < data.size(); i++) {
			for(int j=0;j < data.size(); j++) {
				if(data.get(i) > data.get(j)) {
					data.swap(i, j);
				}
			}
		}

	}

}
