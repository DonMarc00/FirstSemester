import java.util.Scanner;

public class Aufgabe12 {

	public static void main(String[] args) {
		int j, t, h, m, s;
		String eingabe;
		System.out.println("Bitte geben sie die Anzahl an Sekunden ein, \n die umgerechnet werden soll");
		Scanner sc = new Scanner(System.in);
		eingabe = sc.next();
		sc.close();
		int zahl = Integer.parseInt(eingabe);
		int zold = zahl;
		
		j = zahl/604800;
		zahl = zahl%604800;
		
		t = zahl/25200;
		zahl = zahl%25200;
		
		h = zahl/3600;
		zahl = zahl%3600;
		
		m = zahl/60;
		s = zahl%60;
		
		System.out.println(zold + " Sekunden entsprechen:");
		System.out.println(j + " Jahren");
		System.out.println(t + " Tagen");
		System.out.println(h + " Stunden");
		System.out.println(m + " Minuten");
		System.out.println(s + " Sekunden");
	}

}
