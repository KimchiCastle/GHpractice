package mycodeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backJoon_2563 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
/* 
ù° �ٿ� �������� ���� �־�����. 
�̾� ��° �ٺ��� �� �ٿ� �ϳ��� �����̸� ���� ��ġ�� �־�����. 
�����̸� ���� ��ġ�� �� ���� �ڿ����� �־����µ� 
ù ��° �ڿ����� �������� ���� ���� ��ȭ���� ���� �� ������ �Ÿ��̰�, 
�� ��° �ڿ����� �������� �Ʒ��� ���� ��ȭ���� �Ʒ��� �� ������ �Ÿ��̴�. 
�������� ���� 100 �����̸�, �����̰� ��ȭ�� ������ ������ ���� ����

���
ù° �ٿ� �����̰� ���� ���� ������ ���̸� ����Ѵ�. 
 
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
