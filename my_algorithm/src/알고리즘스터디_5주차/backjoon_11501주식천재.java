package 알고리즘스터디_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11501주식천재 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

/*		


입력
입력의 첫 줄에는 테스트케이스 수를 나타내는 자연수 T가 주어진다. 
각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 
자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고, 
둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 날 별 주가는 10,000이하다.

출력
각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력한다. 답은 부호있는 64bit 정수형으로 표현 가능하다.

예제 입력 1 
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
예제 출력 1 
0
10
5	
*/	
		
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken()); 
			
			money(m);
			
		}
		
		System.out.println(sb);
	}

	private static void money(int m) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] m2 = new int [m];
		//배열안에 주식 값 넣기
		for(int i=0; i<m; i++) {
			m2[i] = Integer.parseInt(st.nextToken());
		}
		
		
		long mymoney = 0;
		int max = 0;
		for(int i=m2.length-1; i>-1; i--) {
			
			//만약 맥스값이 작으면
			if(m2[i]>max) {
				//팔지않고 맥스값을 변경
				max = m2[i];
			}else
				//맥스값이 더 크면 주식 팔기
				mymoney += max - m2[i];
			
		}
		
		sb.append(mymoney).append("\n");
		
	}

}
