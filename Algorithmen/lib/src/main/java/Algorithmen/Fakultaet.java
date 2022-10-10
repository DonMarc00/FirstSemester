package Algorithmen;

public class Fakultaet {
	
	public static long fakultaet(int i) {
		long res = i;
		for(int k = i-1; k > 0; k--) {
			res *= k;
		}
		return res;
	}

	public static void main(String[] args) {
		long i = fakultaet(5);
		System.out.println(i);

	}

}
