package �˰����͵�_4����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_2559 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
10 2
3 -2 -4 -9 0 3 7 13 8 -3
21

10 5
3 -2 -4 -9 0 3 7 13 8 -3
31
 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//���⼭ �ݺ��� N���ع����� �翬�� �ͼ��ǹ߻�
	
		for(int i=0; i<(N-K)+1; i++){
			
			int a = 0;
			//i �ε����� �ϳ��� �þ���ϴµ� �ݺ�Ƚ���� �þ�� �Ѵ�
			for(int k=i; k<i+K; k++) {
				a += arr[k];
			}
		
			list.add(a);
		}
		//�÷��� �������� ����
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list.get(0));

	}

}
