package �˰����͵�_5����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11501�ֽ�õ�� {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

/*		


�Է�
�Է��� ù �ٿ��� �׽�Ʈ���̽� ���� ��Ÿ���� �ڿ��� T�� �־�����. 
�� �׽�Ʈ���̽� ���� ù �ٿ��� ���� ���� ��Ÿ���� 
�ڿ��� N(2 �� N �� 1,000,000)�� �־�����, 
��° �ٿ��� �� �� �ְ��� ��Ÿ���� N���� �ڿ������� �������� ���еǾ� ������� �־�����. �� �� �ְ��� 10,000���ϴ�.

���
�� �׽�Ʈ���̽� ���� �ִ� ������ ��Ÿ���� ���� �ϳ��� ����Ѵ�. ���� ��ȣ�ִ� 64bit ���������� ǥ�� �����ϴ�.

���� �Է� 1 
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
���� ��� 1 
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
		//�迭�ȿ� �ֽ� �� �ֱ�
		for(int i=0; i<m; i++) {
			m2[i] = Integer.parseInt(st.nextToken());
		}
		
		
		long mymoney = 0;
		int max = 0;
		for(int i=m2.length-1; i>-1; i--) {
			
			//���� �ƽ����� ������
			if(m2[i]>max) {
				//�����ʰ� �ƽ����� ����
				max = m2[i];
			}else
				//�ƽ����� �� ũ�� �ֽ� �ȱ�
				mymoney += max - m2[i];
			
		}
		
		sb.append(mymoney).append("\n");
		
	}

}
