package Algorithmen;

public class LinkedListTest {

	public static void main(String[] args) {
		VerketteteListe_kurz<Integer> liste = new VerketteteListe_kurz<>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		liste.add(4);
		liste.add(5);
		System.out.println("Anzahl=" + liste.size());
		System.out.println(liste);
	}

}
