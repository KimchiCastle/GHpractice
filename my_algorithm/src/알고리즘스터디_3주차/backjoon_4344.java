package �˰����͵�_3����;

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
			//�л���
			int a = Integer.parseInt(st.nextToken());
		
			
			//�������� 2�����迭 ����
			score[i] = new int[a];
			
			for(int k=0; k<a; k++) {
				//�������̸�ŭ �ݺ��Ͽ� �迭�ȿ� �� �ֱ�
				score[i][k] = Integer.parseInt(st.nextToken()); 
				//��չ迭�� ������ �ٳֱ�
				avg[i] += score[i][k];
				
			}
			//��ո����
			avg[i] /= a;
			
			double count = 0;
			
			for(int j=0; j<score[i].length; j++) {
				
				if(avg[i]<score[i][j]) {
					count++;
				}	
			}
			
			//��� �ۼ�Ʈ �ϱ�
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
