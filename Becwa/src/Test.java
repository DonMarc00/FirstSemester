import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String eingabe;
		System.out.println("Bitte Zahl eingeben");
		Scanner sc = new Scanner(System.in);
		eingabe = sc.next();
		int zahl = Integer.parseInt(eingabe);
		int innum = zahl;
		int gros, schock, dutzend, stueck;
		
		gros = zahl/144;
		zahl = zahl%144;
		
		schock = zahl/60;
		zahl = zahl%60;
		
		dutzend = zahl/12;
		stueck = zahl%12;
		
		
		System.out.println("Die Ursprüngliche eingabe: " + innum);
		System.out.println("Umgerechnet: " );
		System.out.println("Gros: " + gros + " Schock: " + schock + " Dutzend: " + dutzend + " Stück: " + stueck);

		
		
	}

}
