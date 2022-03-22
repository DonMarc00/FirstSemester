package Flächenzeugs;

public class Kreis extends Form {
     double r;
     
     public Kreis(double r) {
    	 this.r = r;
    	 umfang = 3.14 * 2 * r;
    	 flaeche = 3.14 * r *r;
     }
}