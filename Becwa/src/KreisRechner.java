import java.util.Scanner;

public class KreisRechner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String eingabe;
		System.out.println("Bitte Radius eingeben");
		Scanner sc = new Scanner(System.in);
		eingabe = sc.next();
		double radius = Double.parseDouble(eingabe);
		double pi = 3.41;
		
		float area = (float) (radius * pi * pi); 
		float umfang = (float) (2 * pi * radius);
		
		System.out.println("Fläche: " + area + " Umfang: " + umfang);
	}

}
