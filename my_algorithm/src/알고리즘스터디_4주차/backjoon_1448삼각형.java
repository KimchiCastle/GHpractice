package �˰����͵�_4����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_1448�ﰢ�� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
3
1
2
3
---
-1

3
1
2
2
5

*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		//Integer [] tri = new Integer[N];
		int [] tri = new int[N];
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		//�迭�� �� �־��ֱ�
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			tri[i] = Integer.parseInt(st.nextToken());

		}
		
		
		select(tri);
		
		//Arrays�� ����Ŭ������ ���ı����� ����� �� �ִ�.
		//Arrays.sort(tri, Collections.reverseOrder());
		

		/*
		3 = 1
		4 = 2
		5 = 3
		6 = 4
		7 = 5
		...
		N = N-2;
		 */
		
		//�ﰢ�� �����
		for(int i=0; i<N-2; i++) {
			int res=0;
			
			//���� �ﰢ���� ������ ���...
			if(tri[i]>=tri[i+1]+tri[i+2]) {
				res = -1; 
				list.add(res);
				continue;
			}
			
			//3�� �ݺ��ؼ� �ﰢ�� �� ���ϱ�
			for(int k = i; k<3+i; k++) {
				res += tri[k];	
			}	
			//���� ���� ArrayList�� �ֱ�
			list.add(res);
			
			//���⼭ �����غ���... �ִ밪�� ���Ѱ;ƴѰ�?? �ݺ��� ������ �����ʳ�??
			//�ִ밪 ã������ break;
			break;
		}
		
		/*
		for(int a : list) {
			System.out.println(a);
		}
		*/
		
		
		
		//�÷��� �޼ҵ忡 �ִ� �������� �޼ҵ�
		Collections.sort(list, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		

		sb.append(list.get(0));
		
		System.out.println(sb);

	}

	
	
	
	//���� ������ �������� ��������
	public static void select(int[] tri) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<tri.length-1; i++) {
			for(int k=i+1; k<tri.length; k++) {
				
				if(tri[i]<tri[k]) {
					swap(tri,i,k);
				}
				
				
			}
		}
		
	}

	public static void swap(int[] tri, int i, int k) {
		// TODO Auto-generated method stub
		
		int save = tri[i];
		tri[i] = tri[k];
		tri[k] = save;
	}

}
