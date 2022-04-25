package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 연습장2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		String [] 한별 = new String[64];
		
		for (int i = 0; i < 한별.length; i++) {
			한별[i] = br.readLine();
			sb.append(한별[i]).append('\n');
		}
		
		System.out.println(sb);
				
				
		//sb.append(한별);
		
		//System.out.println(sb);
	
	}

}
