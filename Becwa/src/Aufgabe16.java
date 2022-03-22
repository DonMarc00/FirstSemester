import java.util.Scanner;

public class Aufgabe16 {

	public static void main(String[] args) {
		System.out.println("Bitte den Monat eingeben" );
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		System.out.println("Bitte den Tag eingeben" );
		int day = sc.nextInt();
		int dayofyear = 0;
		sc.close();
		for(int i = 1; i<=(month-1); i++) {
			/* if(i <= 7) {
				if(i == 2)
					dayofyear += 28;
				else if(i % 2 != 0)
					dayofyear += 31;
				else
					dayofyear += 30;
				
			}
			if(i > 7 && i <= 12) {
				if(i % 2 == 0)
					dayofyear += 31;
				else
					dayofyear += 30;
			} */
			switch(i){
				case 1, 3, 5, 7, 8, 10:
					dayofyear += 31;
				    break;
				case 2:
					dayofyear += 28;
					break;
				case 4, 6, 9, 11:
				    dayofyear+= 30;
				    break;
				default:
					
			}
		} 
		dayofyear += day;
		System.out.print("Der " + day+"."+(month) + " ist der Tag Nr. " + dayofyear + " Im Kalender" );
		

	}

}
