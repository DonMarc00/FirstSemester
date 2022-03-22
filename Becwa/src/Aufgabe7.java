
public class Aufgabe7 {

	public static void main(String[] args) {
		//Variablendeklaration
		String one, two, three, four, five, six;
		int o = 0, tw = 0, th = 0, fo = 0, fi = 0, si = 0;
		one = "";
		two = "";
		three = "";
		four = "";
		five = ""; 
		six = "";
		for (int i = 0; i < 1000; i++) {
		//Zufallsgeneration der Zahl
		//Sozusagen der Wurf
		double r = Math.random();
		r = r * 6;
		r++;
		int wurf = (int)r;
		//Es wird geschaut was gewürfelt wurde und entsprechend für alle 10 Treffer ein "X" hinzuaddiert
		switch(wurf) {
		case 1:
			o++;
			if(o % 10 == 0)
				one += "X";
			break;
		case 2:
			tw++;
			if(tw % 10 == 0)
				two += "X";
			break;
		case 3:
			th++;
			if(th % 10 == 0)
				three += "X";
			break;
		case 4:
			fo++;
			if(fo % 10 == 0)
				four += "X";
			break;
		case 5:
			fi++;
			if(fi % 10 == 0)
				five += "X";
			break;
		case 6:
			si++;
			if(si % 10 == 0)
				six += "X";
			break;
		}
		}
		//Zeichnen des Histogramms
		System.out.println("1: | " + one);
		System.out.println("2: | " + two);
		System.out.println("3: | " + three);
		System.out.println("4: | " + four);
		System.out.println("5: | " + five);
		System.out.println("6: | " + six);
		

	}

}
