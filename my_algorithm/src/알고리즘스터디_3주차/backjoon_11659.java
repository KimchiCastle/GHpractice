package �˰����͵�_3����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11659 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub	
/*		
ù° �ٿ� ���� ���� N�� ���� ���ؾ� �ϴ� Ƚ�� M�� �־�����. 
��° �ٿ��� N���� ���� �־�����. ���� 1,000���� �۰ų� ���� �ڿ����̴�. 
��° �ٺ��� M���� �ٿ��� ���� ���ؾ� �ϴ� ���� i�� j�� �־�����.

���
�� M���� �ٿ� �Է����� �־��� i��° ������ j��° ������ ���� ����Ѵ�.

���� �չ迭�� �̸� ���س��´�.

*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [N];
		
		//�ε����� �ϱ⶧���� �չ迭�� ��ĭ ū �迭 ����
		int [] arr_hap = new int [N+1];
		
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//�չ迭�� �� �־��ֱ� 1���� ����
		for(int i=1; i<=N; i++) {
			//							���迭�� 0��°����
			 arr_hap[i] = arr_hap[i-1] + arr[i-1];
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		//�ռ� �޾Ƴ��� M�� �ݺ�
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ÷�� �ޱ�
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			//������ ������ ���� �ٷ� ����� ����
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
