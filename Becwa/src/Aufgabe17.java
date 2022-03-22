
public class Aufgabe17 {

	
	
	public static void main(String[] args) {
		//Feld wird mit allen möglichen Kombinationen erstellt und Befüllt
		int[] nums = new int[25];
		for(int c=0; c<= 24; c++) {
			nums[c]= 0;
		}
		
		
		int sum;
		//Die 4 Schleifen stehen für die Würfel
		//Sie werden "Ein nach dem anderen" um eins nach vorne Verschoben, 
		//Und es wird die entstandene Kombination erfasst. Diese wird in dem Array gefunden und es wird 
		//eins zu der Menge addiert
		for(int i=1; i <= 6; i++) {
			for(int l=1; l <= 6; l++) {
				for(int k=1; k <= 6; k++) {
					for(int j=1; j<=6;j++) {
						sum = i + l + k + j;
						nums[sum]+= 1;
					}
				}
			}
		}
	  //Ausgabe
	  for(int a=4; a<=24; a++) {
		  System.out.println(a + ": " + nums[a]);
	  }

	}

}
