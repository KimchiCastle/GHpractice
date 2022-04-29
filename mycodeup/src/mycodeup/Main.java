package mycodeup;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] a = new int[11][11];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
	    //System.out.println();

		int c = 1; // ¿­
		int r = 1; // Çà
		
		
		
		
	
		
		   while(true){ // 1,1ºÎÅÍ
			
				
			  
				if (a[r][c] == 2 ) {//Á¦ÀÏ Ã¹Ä­¿¡ ¸ÔÀÌ°¡ ÀÖÀ¸¸é ¸ØÃç¶ó					
					a[r][c] = 9;
					break;
				}
				
				a[r][c]=9;
				
				if (a[r][c+1] == 1) {
					r++;
				}else c++;
				
				if (a[r][c] == 2 ) {			
					a[r][c] = 9;
					break;
				}
				
				if(a[r+1][c]==1) {
					a[r][c] = 9;
					if(a[r][c+1]==1) {
						break;
					}
				}
				
			
			}//end while
		

	for (int j = 0; j < 10; j++) {
		for (int i = 0; i < 10; i++) {

				System.out.printf("%d ", a[j][i]);
			}
			System.out.println();
		}

	}

}
