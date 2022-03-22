
public class Aufgabe9 {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i ++) {
           for(int l = 0; l < 10; l++) {
        	   System.out.println();
        	   for(int k = 0; k < 10; k++) {
        		   if(i != l && i != k && l !=k) {
        			   System.out.print(i);
        			   System.out.print(l);
        			   System.out.print(k);
        			   System.out.print(" ");
        			   //System.out.print(Integer.toString(i) + Integer.toString(l) + Integer.toString(k) + " ");
        		 }
        		   }
        		   
           }
			
			
		}

	}

}
