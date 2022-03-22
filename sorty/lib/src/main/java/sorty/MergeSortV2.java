package sorty;

import java.util.HashMap;

public class MergeSortV2 implements SortAlgorithm {

	@Override
	public void sort(Data data) {

//		Map<Integer, Integer> initPos = new HashMap<>();

		sort(data, 0, data.size() / 2);
		sort(data, data.size() / 2 + 1, data.size() - 1);
		merge(data, 0, data.size() / 2, data.size() / 2 + 1, data.size() - 1);

	}

	public void sort(Data data, int begin, int end) {

		int mitte = (end - begin) / 2 + begin;

		if (end - begin >= 1 && (begin < end)) {
			sort(data, begin, mitte);
			sort(data, mitte + 1, end);
			merge(data, begin, mitte, mitte + 1, end);
		} 
	}

	public void merge(Data data, int beginLeft, int endLeft, int beginRight, int endRight) {

		Permu permu = new Permu();
		int bl = beginLeft;

		for (int i = beginLeft; i <= endRight; i++) {

			if (beginLeft > endLeft) {
				permu.add(i, beginRight);
				beginRight++;
			} else if (beginRight > endRight) {
				permu.add(i, beginLeft);
				beginLeft++;
			} else if (data.get(beginLeft) < data.get(beginRight)) {
				permu.add(i, beginLeft);
				beginLeft++;
			} else if (data.get(beginLeft) >= data.get(beginRight)) {
				permu.add(i, beginRight);
				beginRight++;
			} 

		}

		for (int iteration = bl; iteration <= endRight; iteration++) {
			int from = iteration;
			int to = permu.getTarPos(iteration);

			if (from != to) {
				data.swap(from, to);
				permu.swap(from, to);
			}
		}

	}

	private class Permu {
		HashMap<Integer, Integer> initialPos = new HashMap<>();
		HashMap<Integer, Integer> currentPos = new HashMap<>();
		HashMap<Integer, Integer> targetPos = new HashMap<>();

		public void add(int srcPos, int tarPos) {
			initialPos.put(srcPos, srcPos);
			currentPos.put(srcPos, srcPos);
			targetPos.put(srcPos, tarPos);
		}

		public void swap(int from, int to) {
			int initTo = initialPos.get(to);
			int initFrom = initialPos.get(from);

			initialPos.put(to, initFrom);
			initialPos.put(from, initTo);

			int currTo = currentPos.get(to);
			int currFrom = currentPos.get(from);
			currentPos.put(currTo, from);
			currentPos.put(currFrom, to);

			currentPos.put(initFrom, to);

		}

		int getTarPos(int srcPos) {
			return currentPos.get(targetPos.get(srcPos));
		}
	}

}
