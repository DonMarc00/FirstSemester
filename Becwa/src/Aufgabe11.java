import java.util.Scanner;

public class Aufgabe11 {

	public static void main(String[] args) {
	
			String input;
			System.out.println("Bitte die Zahl eingeben" );
			Scanner sc = new Scanner(System.in);
			input = sc.next();
			sc.close();
			int zahl = Integer.parseInt(input);
			
		
	    int hz = (zahl/100)%10;
	    int zz = (zahl/10)%10;
	    int ez = zahl%10;

	    System.out.println("Ihre Zahl lautet: " + zahl);
	    
	    
	    if(zahl % hz == 0)
	    	System.out.println("Die Zahl ist durch die Huderterziffer teilbar");
	    else if(zahl % zz == 0)
	    	System.out.println("Die Zahl ist durch die Zehnerziffer teilbar");
	    else if(zahl % ez == 0)
	    	System.out.println("Die Zahl ist durch die Einerziffer teilbar");
	    else 
	    	System.out.println("Nain!");

	}

}
