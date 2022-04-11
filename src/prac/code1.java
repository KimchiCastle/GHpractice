package prac;



import java.util.Scanner;

public class code1 {

	public static void main(String[] args) {
		

	    Scanner scan = new Scanner(System.in);
	     
	    String cal=""; 
	   
	    cal = scan.next();
	    
	    String [] can2 = cal.split("\\.");
	    

	    System.out.printf("%04d.%02d.%02d",Integer.parseInt(can2[0]),Integer.parseInt(can2[1]),Integer.parseInt(can2[2]));
	  
	}

}

