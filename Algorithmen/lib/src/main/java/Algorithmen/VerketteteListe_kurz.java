package Algorithmen;

@SuppressWarnings("hiding")
public class VerketteteListe_kurz<Integer>{
	private Knoten<Integer> anfang = null;
	private int anzahl = 0;
	
	public void add(Integer o) {
		anzahl++;
		Knoten<Integer> knoten = new Knoten<>(o);
		
		if(anfang == null) {
			anfang = knoten;
			return;
		}
		
		knoten.next = anfang;
		anfang = knoten;
	}
	
	public int size() {
		return anzahl;
	}
	
	public void drucken(int i) {
		for(int temp = 0; temp < this.size(); i++) {

		}
	}
	
}
