import java.util.Scanner;

public class Aufgabe5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] eingabe = new int[3];
       
		for(int i = 0; i < 3; i++ ) {
			String input;
			System.out.println("Bitte Zahl eingeben");
			Scanner sc = new Scanner(System.in);
			input = sc.next();
			int zahl = Integer.parseInt(input);
			eingabe[i] = zahl;
			sc.close();
		}
		if((eingabe[0] > eingabe[1] && eingabe[0] < eingabe[2]) || (eingabe[0] < eingabe[1] && eingabe[0] > eingabe[2]))
		System.out.println("Media ist: " + eingabe [0]);
		else if((eingabe[1] > eingabe[0] && eingabe[1] < eingabe[2]) || (eingabe[1] < eingabe[0] && eingabe[1] > eingabe[2]))
			System.out.println("Media ist: " + eingabe [1]);
		else
			System.out.println("Media ist: " + eingabe[2]);
		
	}
   
}
