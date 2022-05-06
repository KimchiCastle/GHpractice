package 알고리즘스터디_3주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11659 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub	
/*		
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

구간 합배열을 미리 구해놓는다.

*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [N];
		
		//인덱스로 하기때문에 합배열은 한칸 큰 배열 생성
		int [] arr_hap = new int [N+1];
		
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//합배열에 값 넣어주기 1부터 시작
		for(int i=1; i<=N; i++) {
			//							수배열은 0번째부터
			 arr_hap[i] = arr_hap[i-1] + arr[i-1];
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		//앞서 받아놨던 M번 반복
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 첨자 받기
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			//빌더에 연산한 값을 바로 어펜드 가능
			sb.append(arr_hap[e]-arr_hap[s-1]).append("\n");
			
		}
		
		System.out.println(sb);
		
		
		/*
		for(int a : arr_hap) {
			System.out.printf("%d ",a);
		}
		*/
		
	}

}
