package 알고리즘스터디_4주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon_2018수들의합5 {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
입력
첫 줄에 정수 N이 주어진다.

출력
입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오
15 = 4
10 = 2
		
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int count =1;
		
		for(int i=1; i<=N/2; i++) {
			int res = 0;		
			for(int k=i; k<=N;k++) {
				
				res += k; 
				
				if(res>N) {
					break;
				}else if(res == N) {
					count++;
					break;
				}
			
			
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(count);
		
		System.out.println(sb);
		
	}


	

}
