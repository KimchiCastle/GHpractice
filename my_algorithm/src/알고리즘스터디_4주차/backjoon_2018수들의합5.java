package �˰����͵�_4����;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon_2018��������5 {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
�Է�
ù �ٿ� ���� N�� �־�����.

���
�Էµ� �ڿ��� N�� �� ���� ���ӵ� �ڿ����� ������ ��Ÿ���� �������� ����Ͻÿ�
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
