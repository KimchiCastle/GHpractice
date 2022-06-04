package �˰����͵�_6����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2606BFS���̷��� {

	static StringTokenizer st;
	
	static List<ArrayList<Integer>> list;
	
	static int N, E, S = 1;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7

4
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new ArrayList<ArrayList<Integer>>(N+1);
		
		//�׷��� �������� ��ü ����
		for(int i=0; i<N+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			list.add(al);
			
		}
		
		//����Ʈ�� �׷��� ������ �ֱ� ������ŭ �ݺ�!!
		for(int i=1; i<=E; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//������ �׷����� �ݴ��ʵ� �̾�����Ѵ�.
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		//bfs �޼ҵ� ȣ��
		bfs(S);
		
	}

	private static void bfs(int s) {
		// TODO Auto-generated method stub
		
		//Ž���� ���� Queue ��ü ����
		Queue<Integer> q = new LinkedList<Integer>();
		
		//Ž�� ���� Ȯ�ο� Boolean �迭 ���� ���ũ�⸸ŭ
		boolean [] check = new boolean[N+1];
		
		
		q.add(s);
		
		//q�� ������ ���ÿ� Ž�� true
		check[s] = true;
		
		//���� ����� ����
		int count = 0;
		
		//q�� �������� �ݺ��ϱ�
		while( !q.isEmpty() ) {
			
			//������ �湮
			int a = q.poll();
			//a�� ����� �׷��� ���� �ݺ���
			for(int i : list.get(a)) {
			
				if (check[i] == false) {
					
					//�湮ó���ϱ�
					check[i] = true;
					count++;
					
					q.add(i);
					
				}
			}
			
		}
		
		System.out.println(count);
		
		
	}

}
