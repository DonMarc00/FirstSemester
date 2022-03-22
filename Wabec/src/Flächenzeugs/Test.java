package Flächenzeugs;

public class Test {

	public static void main(String[] args) {
		Kreis a = new Kreis(3.5);
		Kreis b = new Kreis(4.5);
		
		Quadrat c = new Quadrat(7.2);
		Quadrat d = new Quadrat(8.4);
		
		System.out.println("Fläche: " + a.getFlaeche() + "Umfang: " + a.getUmfang());
		System.out.println("Fläche: " + b.getFlaeche() + "Umfang: " + b.getUmfang());
		System.out.println("Fläche: " + c.getFlaeche() + "Umfang: " + c.getUmfang());
		System.out.println("Fläche: " + d.getFlaeche() + "Umfang: " + d.getUmfang());

	}

}
