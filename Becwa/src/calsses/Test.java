package calsses;

public class Test {

	public static void main(String[] args) {
		Person Frederick = new Person(69420, "Freiherr von Furchensumpf", 8000.50);
		Person Gustav = new Person(885512, "Sresemann", 123.49);
		Person Kevin = new Person(341629, "Wabec", 950000.99);
		Frederick.getAll();
		System.out.println();
		Kevin.getAll();
		System.out.println();
		Gustav.getAll();
		System.out.println("---------------------------------------------");
		Frederick.gehaltHoch(500.);
		Kevin.setGehalt(0.);
		Frederick.getAll();
		System.out.println();
		Kevin.getAll();
		System.out.println();
		Gustav.getAll();
	}

}
