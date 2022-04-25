package 알고리즘스터디_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1090 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//제출시 마지막값이 int형의 최대
		long a = Integer.parseInt(st.nextToken());
		
		int r = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(st.nextToken());
	
		
		
		
		for (int i = 0; i < n-1; i++) {
			
			a = a * r;
			
		}
		
		System.out.println(a);
		
		
	}

}
