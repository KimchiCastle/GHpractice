package 알고리즘스터디_3주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_4344 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91	
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] score = new int[N][];
		
		double [] avg  = new double[N];
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			//학생수
			int a = Integer.parseInt(st.nextToken());
		
			
			//가변길이 2차원배열 생성
			score[i] = new int[a];
			
			for(int k=0; k<a; k++) {
				//가변길이만큼 반복하여 배열안에 값 넣기
				score[i][k] = Integer.parseInt(st.nextToken()); 
				//평균배열에 점수합 다넣기
				avg[i] += score[i][k];
				
			}
			//평균만들기
			avg[i] /= a;
			
			double count = 0;
			
			for(int j=0; j<score[i].length; j++) {
				
				if(avg[i]<score[i][j]) {
					count++;
				}	
			}
			
			//평균 퍼센트 하기
			avg[i] = (count/a)*100;	
		}
		
		for(double a : avg) {
			System.out.printf("%.3f%%\n",a);
		}
		
		/*
		System.out.println();
		
		
		for(int i=0; i<score.length; i++) {
			for(int k=0; k<score[i].length; k++) {
				
				System.out.printf("%d ",score[i][k]);
				
			}
			System.out.println();
		}
		*/
		
		
		
	}

}
