import java.util.Scanner;

public class Zinsrechnung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String eingabe;
		System.out.println("Bitte Kapital eingeben");
		Scanner sc = new Scanner(System.in);
		eingabe = sc.next();
		double kapital = Double.parseDouble(eingabe);
		double zinssatz = 0.05;
		double zeit = 90;
		
		double zinsen = zinssatz * kapital*(zeit/360);
		System.out.println(zinsen + "Bei: " + zeit + " Tagen");
	}

}
