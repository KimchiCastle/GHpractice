package prac;

import java.util.Arrays;
import java.util.Scanner;

public class prac3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner scan = new Scanner(System.in);
		
		
		int dice[] = new int [3];
		
		for(int i = 0; i<dice.length; i++) {
			dice[i] = scan.nextInt();
		}
		
		
		Arrays.sort(dice);
		
		
		for(int i = 0; i<dice.length; i++);
		
		
		
		int save = 0;
		
		
		int count = 0;
		
		//ºñ±³ for¹®
		for(int i = 0; i<dice.length; i++) {
			for( int k = i+1; k<dice.length; k++){
				
				if(dice[i]==dice[k]) {
					save = dice[i];
					count++;
					
				}
				
			}
		}
		
		int won = 0;
		
		if(count == 0) {
			won = dice[2] * 100;
		}else if(count == 1) {
			won = save* 100 + 1000;
		}else if (count == 3) {
			won = save *1000 + 10000;
		}
		
		System.out.println(won);
		
	}

}
