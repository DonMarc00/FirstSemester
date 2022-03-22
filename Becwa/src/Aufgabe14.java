import java.util.Scanner;

public class Aufgabe14 {

	public static void main(String[] args) {
		int input;
		System.out.println("Bitte die Jahreszahl eingeben eingeben" );
		Scanner sc = new Scanner(System.in);
		try {
		input = sc.nextInt();
		if(((input % 4 == 0) && (input % 100 != 0)) || ((input % 4 == 0) && (input % 400 ==0))) {
			System.out.println("Es handelt sich beim Jahr: " + input + " um ein Schaltjahr");
		}
		else
			System.out.print("Nain");
	
		}
		catch (Exception e) {
			System.out.print("Das ist keine gültige Jahreszahl");
		}
		sc.close();
		
		
	}

}
