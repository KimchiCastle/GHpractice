package �˰����͵�_6����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_24445BFS�ʺ�켱Ž��2 {
	
	static StringTokenizer st;
	
	static int N, E, S;
	
	static List<ArrayList<Integer>> list;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*		
5 5 1
1 4
1 2
2 3
2 4
3 4		

1
3
4
2
0		
		
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<ArrayList<Integer>>(N+1);

		//�׷��� �������� ����Ʈ ����;
		for(int i=0; i<N+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			list.add(al);
		}
		
		//�׷��� ���� ����, ������ŭ !! �ݺ��ϱ�.
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		
		//������ �������������̱� ������ �������� �����ϱ�.
		for(int i=1; i<=N; i++) {
			
			Collections.sort(list.get(i), Collections.reverseOrder());
			
		}
		
		bfs(S);
		
		System.out.println(sb);
		
	}


	private static void bfs(int s) {
		// TODO Auto-generated method stub
		
		//Ž���� ���� Queue����
		Queue<Integer> q = new LinkedList<Integer>();
		
		//Ž���Ϸ� üũ�� ���� Boolean �迭 ����
		boolean [] check = new boolean[N+1];
		
		//q�� ���۰� �ֱ�, ������ ���ÿ� �湮ó��.
		q.add(s);
		check[s] = true;
		
		
		int count = 0;
		int [] res = new int [N+1];
		
		//q�� �������� �ݺ�
		while( !q.isEmpty() ) {
			
			//q ����, int a�� ����
			int a = q.poll();
			
			//a��ġ�� �湮ó��
			res[a] = ++count;
			
			//a�� ����� ��尪 ������ ������ for
			for(int i : list.get(a)) {
				
				//�湮 ��������? �湮ó���ϱ�.
				if(check[i] == false) {
					
					check[i] = true;
					
					//������ i�� Queue�� ����
					q.add(i);
					
				}
				
				
			}
			
			
			
		}
		sb = new StringBuilder();
		for(int i=1; i<res.length;i++) {
			sb.append(res[i]).append("\n");
		}
		
		
	}

}
