package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2980_신호등 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
	첫째 줄에 신호등의 개수 N과 도로의 길이 L이 주어진다. (1 ≤ N ≤ 100, 1 ≤ L ≤ 1000)

다음 N개 줄에는 각 신호등의 정보 D, R, G가 주어진다. (1 ≤ D < L, 1 ≤ R ≤ 100, 1 ≤ G ≤ 100) 

D는 신호등의 위치이며, R과 G는 빨간색, 초록색이 지속되는 시간이다.

신호등은 D가 증가하는 순서로 주어지며, 같은 위치에 있는 신호등이 두 개 이상 있는 경우는 없다.

출력
첫째 줄에 상근이가 도로의 끝까지 이동하는데 걸리는 시간을 출력한다.

예제 입력 1 
2 10
3 5 5
5 2 2
예제 출력 1 
12
예제 입력 2 
4 30
7 13 5
14 4 4
15 3 10
25 1 1
예제 출력 2 
36	
		
*/		
		
		/*
		 * 확인해야하는것. 
		 * 1. 빨간불인지 초록불인지 조건확인
		 * 2. 현재 내위치와 걸린 시간
		 * 3. 다음 신호등 위치
		 * 4. 마지막 신호등과 남은거리
		 */
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int mytime = 0;
		
		int myL = 0;
		
		int [][] sinho = new int [N][3];
		
		for (int i = 0; i < N; i++) {
		
			st = new StringTokenizer(br.readLine());
			
			for (int k = 0; k < sinho[i].length; k++) {
				
				sinho[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		for (int i = 0; i < N; i++) {

			//		현재시간 + 지금신호등 - 전신호등
			mytime = mytime + (sinho[i][0] - myL); // 걸린시간

			myL = sinho[i][0]; // 현재 내 거리
			
			//ex) 7%18 = 그대로 7
			int RG = mytime % (sinho[i][1] + sinho[i][2]); //빨간불인지 초록불인지 확인 수식
			
			if (RG <= sinho[i][1]) { // 빨간불일경우 기다리기
				//		7초 + (13 - 7 = 6)
				mytime = mytime +  (sinho[i][1] - RG);
				
			}

		} // for - end
		
		/*
		 너무 쉽게 생각해서 풀려고 했다.
		 조금더 접근방식을 새롭게 생각해서 풀기
		for (int i = 0; i < sinho.length; i++) {
			if (sinho[i][0] < sinho[i][1]) {
				L = sinho[i][1] - sinho[i][0] + L;
			}
		}
		
		
			if ((i + 1) == N) { // 맨마지막 신호등인경우에는?
				if (mytime % RG >= sinho[i][1]) { // 초록불일경우
					mytime = mytime + (L - sinho[i][0]);
				} // else 빨간불 신호 시간 대기후 mytime = mytime + (L-sinho[i][0]);
			}
		*/
		/*
		for (int i = 0; i < sinho.length; i++) {
			for (int k = 0; k < sinho[i].length; k++) {
				System.out.printf("%d ",sinho[i][k]);
			}
			System.out.println();
		}
		*/
		System.out.printf("%d",(mytime +(L - myL)));
		
		
	}

}
