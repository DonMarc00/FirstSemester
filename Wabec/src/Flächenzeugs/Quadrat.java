package Flächenzeugs;

public class Quadrat extends Form {
      double kantenlaenge;
      
      public Quadrat(double kantenlaenge) {
    	  this.kantenlaenge = kantenlaenge;
    	  umfang = this.kantenlaenge*4;
    	  flaeche =  kantenlaenge * kantenlaenge;
      }
      
}
