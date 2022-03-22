
public class Aufgabe8 {

	public static int wuerfeln() {
		double r = Math.random();
		r = r * 6;
		r++;
		int wurf = (int)r;
		return wurf;
		}
	public static void main(String[] args) {
		int z1 = wuerfeln();
		int z2 = wuerfeln();
		int groﬂ;
		int klein;
		if(z1 > z2) {
			groﬂ = z1;
			klein = z2;
			String erg = Integer.toString(groﬂ) + Integer.toString(klein);
			int r = Integer.parseInt(erg);
			System.out.println("Ihre Punkte: " + r);
		}
		else if(z1 < z2) {
			klein = z1;
			groﬂ = z2;
			String erg = Integer.toString(groﬂ) + Integer.toString(klein);
			int r = Integer.parseInt(erg);
			System.out.println("Ihre Punkte: " + r);
		}
		else if((z1 == 1 && z2 == 2) || (z1 == 1 && z2 == 2)) {
			System.out.println("!MƒXCHEN! Sie erhalten 1000 Punkte!");
		}
		else {
			z1 *= 100;
			System.out.println("Ihre Punkte: " + z1);
		}
			

	
	}
}
