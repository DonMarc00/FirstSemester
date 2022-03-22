import java.util.Scanner;

public class Aufgabe18 {

	public static void main(String[] args) {

		// Erfassen der gew�nschten Baumgr��e
		int stammh, baumh;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte die Baumh�he eingeben : ");
		baumh = sc.nextInt();
		System.out.println("Bitte die Stammh�he eingeben : ");
		stammh = sc.nextInt();
		sc.close();

		// In dieser ersten Schleife wird durch die h�he des Baum iteriert
		for (int i = 1; i <= baumh; i++) {
			// Diese While-Schleife Iteriert durch die Baumkrone
			// --> Wenn ich vom ganzen Baum den Stamm abziehe, dann bleibt die Krone
			// Diese While Schleife dient dazu die ben�tigten Zeilen der Krone zu erzeugen
			while (i <= (baumh - stammh)) {
				System.out.println();
				//In dieser Schleife werden die ben�tigten Leerzeichen zwischen * und Zeile erzeugt
				for (int j = (baumh - stammh); j >= i; j--) {
					System.out.print(" ");
				}
				//Anschlie�end wird die Anzahl der Sterne erzeugt
				//Beachte, dass die Krone von Oben nach unten w�chst
				// Au�erdem besteht die Krone nur aus ungeraden Zahlen 1,3,5 etc.
				// Dies erkl�rt den Term (2 * i - 1). Es werden solange Sterne gedruck, wie c < (2 * i - 1) ist
				// i entspricht dabei der "Stufe in der Krone
				// --> Bsp. 1. Stufe: (2 * 1 - 1) = 1 => c <= 1, es wird 1 Stern ausgegeben
				// --> Bsp. 2. Stufe: (2 * 2 - 1) = 3 => c <= 3; es werden drei Sterne ausgegeben
				for (int c = 1; c <= (2 * i - 1); c++) {
					System.out.print("*");
				}
				// Inkrement f�r while Condition
				i++;
			}
		}
		//Schleife ist notwendig um den Stamm zu erzeuegn und diesen mittig zu platzieren
		for (int k = 1; k <= stammh; k++) {
			// Siehe Z. 20
			System.out.println();
			//Siehe Z. 23
			//Leerzeichen sind Konstant
			for (int a = 1; a <= ((baumh - stammh)); a++) {
				System.out.print(" ");
			}
			//Da der Stamm nur 1 dick ist muss nach den Leerzeichen immer nur ein Stern hinzugef�gt werden
			System.out.print("*");
		}
	}

}
