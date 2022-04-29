package mycodeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backJoon_2563 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
/* 
첫째 줄에 색종이의 수가 주어진다. 
이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 
색종이를 붙인 위치는 두 개의 자연수로 주어지는데 
첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 
두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 
색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다

출력
첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다. 
 
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] paper = new int[100][100];
		
		StringTokenizer st;
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int k=r; k<r+10; k++) {
				
				for(int j=c; j<c+10; j++) {
					
					paper[k][j] = 1;
					
				}
				
			}
		}
		
		for(int i=0; i<paper.length; i++) {
			for(int k=0; k<paper[i].length; k++) {
				
				if(paper[i][k] == 1) {
					count++;
				}
				
			}
		}
		
		System.out.println(count);
				
		}
		
		
		
	

	

}
