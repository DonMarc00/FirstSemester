package sorty;

import java.util.ArrayList;

public class DataSplit extends Data{

	private ArrayList<Integer> storage;
	
	public DataSplit(Data data, int start, int end) {
		super(0);
		this.storage = new ArrayList<>((data.size()/2));
		for(int i= start; i<= end; i++) {
			storage.add(data.get(i));
		}
	}
	
	public void mergeWith(DataSplit partner) {
		this.storage.addAll(partner.storage);
		
	}
	
	public void crossSwap(Data data, DataSplit partner,int thisindex , int partnerindex) {
		int temp = this.storage.get(thisindex);
		this.storage.set(partnerindex, partner.storage.get(partnerindex));
		partner.storage.set(thisindex, temp);
		data.swap(thisindex, partnerindex);
		
	}
	

	public int get(int i) {
		return storage.get(i);
	}
	
	public int size() {
		return storage.size();
	}

}
