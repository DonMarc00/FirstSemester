package calsses;

public class Auto {
     String brand;
     int velocity;
     int power;
     int seatnum;
     boolean isAvaiable;
     boolean isBorrowable;
     
     public Auto(String brand, int velocity, int power, int seatnum, boolean isAvaiable, boolean isBorrowable) {
    	 this.brand = brand;
    	 this.velocity = velocity;
    	 this.power = power;
    	 this.seatnum = seatnum;
    	 this.isAvaiable = isAvaiable;
    	 this.isBorrowable = isBorrowable;
     }
     
     public void ausleihen() {
    	 isBorrowable = false;
     }
     
     public void ausleihbar() {
    	 if(isBorrowable == false) {
    		 System.out.println("Das Auto kann nicht verliehen werden");}
    	 else {
    		 System.out.println("Das Auto kann verliehen werden"); }
     }
     
     
     
     public void anzeigen() {
    	 System.out.println("Folgend die Daten des Autos");
    	 System.out.println("Marke: "+ brand);
    	 System.out.println("Höchstgeschwindigkeit: " + velocity);
    	 System.out.println("Leistung in KW " + power);
    	 System.out.println("Anzahl der Sitze: " + seatnum);
    	 System.out.println("Verfügbar: " + isAvaiable);
     }
}
