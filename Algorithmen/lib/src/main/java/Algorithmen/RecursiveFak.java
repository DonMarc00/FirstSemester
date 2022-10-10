package Algorithmen;

public class RecursiveFak {
	
	public static int recfak(int ip) {
		if (ip > 1)
			return ip * recfak(ip -1);
		else 
			return 1;		
	}

	public static void main(String[] args) {
		int i = recfak(5);
		System.out.println(i);

	}

}
