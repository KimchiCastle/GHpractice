package 알고리즘스터디_3주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11660 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
27
6
64
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		
		// int [][] arr = new int[N][N];
		
		int	[][] ah = new int[N+1][N+1];
		
		int M = Integer.parseInt(st.nextToken());
		
		/*
		//기본배열 만들기
		for(int i=0; i<arr.length;i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int k = 0; k < arr[i].length; k++) {
				
				arr[i][k] = Integer.parseInt(st.nextToken());
				
			}
		}
		*/
		
		//합배열 만들기
		for(int i=1; i<ah.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int k=1; k<ah[i].length; k++) {
				
				ah[i][k] = ah[i-1][k] + ah[i][k-1] + Integer.parseInt(st.nextToken()) - ah[i-1][k-1];
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		//값구하기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			int res = ah[x][y] - ah[a-1][y] - ah[x][b-1] + ah[a-1][b-1];
			
			sb.append(res).append("\n");
		}
		System.out.println(sb);
		
		
	
		/*
		for (int i = 0; i < ah.length; i++) {
			
			for (int k = 0; k < ah[i].length; k++) {
				
				System.out.printf("%d ",ah[i][k]);
				
			}
			System.out.println();
		}
		*/
		
		
	}

}
