package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class backjoon_10871 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//버그투성이 코드
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		//sc.nextLine();
		
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		String array = br.readLine();
		
		String [] A = array.split(" ");
		
		
		for (int i = 0; i < n; i++) {			
			if (x == 1) {
				System.out.println(0);
				break;
			}else if(Integer.parseInt(A[i]) < x){
				System.out.printf("%d ",Integer.parseInt(A[i]));
			}
			
			
			
		}
		
		
		
	}

}
