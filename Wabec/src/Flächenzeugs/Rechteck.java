package Flächenzeugs;

public class Rechteck extends Form{
    double a;
    double b;
    
    public Rechteck(double a, double b) {
    	this.a = a;
    	this.b = b;
    	umfang = 2*this.a +2*this.b;
    	flaeche = a*b;
    }
    

}
