package sorty;

public class Rng {

	public static void main(String[] args) {
		int i=0;
		while(i<10) {
			int rand = (int)(Math.random() * 50 + 1);
			System.out.println(rand);
			i++;
		}
	}

}
