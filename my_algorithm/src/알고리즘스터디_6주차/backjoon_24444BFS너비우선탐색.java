package �˰����͵�_6����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class backjoon_24444BFS�ʺ�켱Ž�� {
	
	static StringTokenizer st;
	
	
	
	static int V, E, R;
	
	public static void main(String[] args) throws Exception {	
/*
����
5 5 1
1 4
1 2
2 3
2 4
3 4
����
1
2
4
3
0
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		//��� ��
		V = Integer.parseInt(st.nextToken());
		//���� ��
		E = Integer.parseInt(st.nextToken());
		//��������
		R = Integer.parseInt(st.nextToken());
		
		//�׷����� �����ϱ� ���� ����Ʈ ��ü ����
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(V+1);
		
		for(int i=0; i<V+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			list.add(al);
		}
	
		//���� �� ��ŭ �ݺ� ��������Ʈ, �׷��� ����
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//������ �׷����̶�����, ���ʴ� ���ֱ�
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		//������ ������������ ����ϱ� ������, ����Ʈ�� �����Ѵ�.
		for(int i=1; i<=V; i++) {
			Collections.sort(list.get(i));	
		}
		//�������� bfs �޼ҵ� ȣ��, ȣ��� ���������� �Ű������� �ش�.
		bfs(list,R);
	}

	private static void bfs(List<ArrayList<Integer>> list, int r) {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean [] visit = new boolean[V+1];
		
		visit[r] = true;
		q.add(r);
		
		int count = 0;
		int [] arr = new int[V+1];
		
		// q�� ������� ������ �ݺ��ض�.
		while( !q.isEmpty() ) {
			
			//q�� ù�κ� ��带 ������. �̽����� �湮�����̴�.
			int a = q.poll();
			arr[a] = ++count;
			
			
			//���� a�� ���������� ���� Ȯ��
			for(int i : list.get(a)) {
				
				if( visit[i] == false ) {
					//�湮ó��
					visit[i] = true;
					q.add(i);
				}
			
			}
			
		}
		
		for(int i=1; i<arr.length;i++ ) {
			System.out.println(arr[i]);
			
		}

	}
	
}
