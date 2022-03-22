package Flächenzeugs;

public class Dreieck extends Form {
      double g;
      double h;
      
      public Dreieck(double g, double h) {
    	  this.g = g;
    	  this.h = h;
    	  flaeche = (g*h)/2;
    	  umfang = 0;
      }
      
      
}
