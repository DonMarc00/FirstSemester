import java.util.Scanner;

public class Aufgabe15 {

	public static void main(String[] args) {
		double kh, zs, mr, t;
		System.out.println("Bitte die Kredithöhe eingeben" );
		Scanner sc = new Scanner(System.in);
		kh = sc.nextInt();
		System.out.println("Bitte den Zinssatz eingeben");
		zs = sc.nextInt();
		System.out.println("Bitte die Monatliche Rate eingeben" );
		mr = sc.nextInt();
		System.out.println("Bitte die Laufzeit eingeben" );
		t = sc.nextInt();
		sc.close();
		
		for(int i = 0; i <= t; i++) {
		   //for(int l = 0; l <= i; l++) {
		   //(zs/100);
		   //}
			kh = kh + (kh * (zs/100)) - (mr*12);
			System.out.println("Für das Jahr " + i + " beträgt die Darlehenssumme: " + kh + " Euro");
		   
		}
		
		

	}

}
