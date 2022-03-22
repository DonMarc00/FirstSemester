package sorty;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Data {

    private final List<Integer> backend;
    private final Collection<DataListener> listeners;

    public Data(int size) {
        this.backend = new ArrayList<>(size);
        this.listeners = new ArrayList<>();
        initRandom(size);
    }

    public int size() {
        return backend.size();
    }

    private void initRandom(int size) {
        for (int i = 1; i <= size; i++) {
            backend.add(i);
        }
        shuffle();
    }

    private void shuffle() {
        Random r = new SecureRandom();
        for (int i = 0; i < backend.size(); i++) {
            int randomPosition = r.nextInt(backend.size());
            swap(i, randomPosition);
        }
    }

    public void swap(int position1, int position2) {
        fireListenersBefore(position1, position2);
        Integer temp = backend.get(position1);
        backend.set(position1, backend.get(position2));
        backend.set(position2, temp);
        fireListenersAfter(position1, position2);
    }

    public int get(int i) {
        fireListenersGet(i);
        return backend.get(i);
    }
    
    public void printAll(Data data) {
    	System.out.println("Data: " );
    	for(int i = 0; i< data.size(); i++) {
    		System.out.print(i + ": " + data.get(i) + "|");
    	}
    	System.out.println();
    }
    
    public Data split(Data data, int start, int end) {
    	
    	Data datasplit = new Data(end);
    	for(int i = start; i<=end; i++) {
    		datasplit.backend.add(i, data.get(i));
    	}
    	return datasplit;
    	
    }
    
 
    public void addListener(DataListener dl) {
        this.listeners.add(dl);
    }

    private void fireListenersAfter(int position1, int position2) {
        for (DataListener dl : listeners) {
            dl.afterSwapping(position1, position2);
        }
    }

    private void fireListenersBefore(int position1, int position2) {
        for (DataListener dl : listeners) {
            dl.beforeSwapping(position1, position2);
        }
    }

    private void fireListenersGet(int i) {
        for (DataListener dl : listeners) {
            dl.readAccess(i);
        }
    }
    
    public class DataSplit extends Data{
    	
    	List<Integer> storage;

		public DataSplit(int size) {
			super(size);
			
		}
    	
    }
}
