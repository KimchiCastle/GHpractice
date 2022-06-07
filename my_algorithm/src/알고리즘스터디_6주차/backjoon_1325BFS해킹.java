package �˰����͵�_6����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1325BFS��ŷ {

	static StringTokenizer st;
	
	static int N, E;
	
	static List<ArrayList<Integer>> list;
	
	static int [] result;
	
	static int resCount;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*		
5 4
3 1
3 2
4 3
5 3

���� ���� ��ŷ�� �� �ִ� ��ǻ�Ͱ� ������ �� �� �ִ�. 
�������� �����ؼ� ���
�迭�� �̸� ����� ����, �׹迭�� ��ŷ���� �־..
1 2
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		//���, ���� �ޱ�
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<ArrayList<Integer>>(N+1);
	
		result = new int[N+1];
		
		// �׷��� ����� ����Ʈ ����
		// ����迭 �� �־��ֱ�.
		for(int i=0; i<N+1; i++) {
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			list.add(al);
			
			
		}
		
		//����Ʈ�� �׷��� ����, ������ŭ �ݺ��ϱ�
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(v).add(u);
			
		}

//		for (int i = 0; i < list.size(); i++) {
//			for (int k = 0; k < list.get(i).size(); k++) {
//
//				System.out.print(list.get(i).get(k) + " ");
//			}
//			System.out.println();
//		}
		
		bfs();
		
		System.out.println(sb);
		
	}


	private static void bfs() {
		// TODO Auto-generated method stub
		
		//Ž���� Queue �����ϱ�
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		for(int i=1; i<=N; i++) {
			boolean [] visit = new boolean[N+1];
			
			q.add(i);
			
			int count = 0;
			
			visit[i] = true;
			
			while( !q.isEmpty() ) {
				
				int a = q.poll();
				
				for(int k : list.get(a))
				
				if(visit[k]==false) {
					count++;
					visit[k] = true;
					
					q.add(k);
					
				}
				
			}
			
			if(resCount<count) {
				resCount = count;
			}
			
			result[i] = count;
			
			
			
		}
		
		sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			
			if(result[i]==resCount) {
				sb.append(i).append(" ");
			}
			
		}
		
		
		
		
	}

}
