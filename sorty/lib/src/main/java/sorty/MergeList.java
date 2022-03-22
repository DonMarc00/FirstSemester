package sorty;

import java.util.HashMap;

public class MergeList implements SortAlgorithm {

	HashMap<Integer, Integer> initPos = new HashMap<>();

	public void sort(Data data) {

		sort(data, 0, data.size() / 2);
		sort(data, data.size() / 2 + 1, data.size()-1);
		merge(data, 0, data.size() / 2, data.size() / 2 + 1, data.size()-1);

	}

	public void sort(Data data, int begin, int end) {
		
		int mitte = (end - begin) / 2 + begin;

		if (end - begin >= 1 && (begin < end)) {
			sort(data, begin, mitte);
			sort(data, mitte + 1, end);
			merge(data, begin, mitte, mitte + 1, end);
		} 
		else {

		}

	}

	public void merge(Data data, int beginLeft, int endLeft, int beginRight, int endRight) {

		System.out.println("-----------------------------------------------------------------");
		HashMap<Integer, Integer> currPos = new HashMap<>();
		createInitMap(initPos, data, beginLeft, endRight); 
		System.out.println("Initial Pos: " + initPos);
		
		data.printAll(data);
		System.out.println("Position Links: " + beginLeft + " Position Rechts: " + beginRight);

		while (beginLeft <= endLeft && beginRight <= endRight) {   
			if (data.get(beginLeft) <=  data.get(beginRight)) {
				beginLeft++;
				System.out.println("Linker Pointer ++");
			} else if (data.get(beginRight) < data.get(beginLeft)) {
				// Zahlentausch
				data.swap(beginRight, beginLeft);
				System.out.println("Tausche Werte auf Pos:" + beginLeft + " Mit Wert auf Pos:" + beginRight);
				int i = 1;
				//Aktualisiert die aktuellen Positionen der geswitchten Zahlen
				System.out.println("Current Position:" + currPos);
				currPos.put(beginRight, beginLeft);
				currPos.put(beginLeft, beginRight);
                System.out.println("Tauscht Current Position" + currPos);
				
				
                    // Soll Liste wieder der größe nach Sortieren
					while (((beginRight +i) <= endRight) && (initPos.get(beginLeft+i) > initPos.get(beginRight))) {
						data.swap(beginLeft + i, beginRight);
						data.printAll(data);
						i++;
						data.printAll(data);
						createInitMap(initPos, data, beginLeft, endRight);
					}
					
					sort(data, beginRight, endRight);
					merge(data, beginLeft, endLeft, beginRight, endRight);
					System.out.println("Updated Initial Position:" + initPos);
				
				
					
				
				beginRight++;
				System.out.println("Rechter Pointer ++");
				}

			} 

		

	}

	public void createInitMap(HashMap<Integer, Integer> initPos, Data data, int begin, int end) {
		initPos.clear();
		for (int j = begin; j <= end; j++) {
			initPos.put(j, data.get(j));
		}
	}

}
