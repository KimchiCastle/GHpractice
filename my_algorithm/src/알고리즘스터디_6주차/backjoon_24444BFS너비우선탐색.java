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
	
	static List<ArrayList<Integer>> list;
	
	static int V, E, R;
	
	public static void main(String[] args) throws Exception {
		
/*
map -> Ž�� ����� �����ϴ� ��ü �� 
visit -> �ߺ� �湮 ������ �湮�迭(boolean) 
 
BFS(R){ -> R�� ��� ��� Ȥ�� ��� ����
 
Queue -> �湮�� ��带 ������ ť�� ����. Enqueue�ϴ� ������ ���� �湮�� �ƴ϶�, �湮 �ؾ��� ����� ����Ʈ�� FIFO������ �����ϴ� ���̴�.
visit[R] = true -> ���� ��忡 ���� �湮 ó���� ���ش�. �⺻������ �湮 ó���� ���� �ϰ� ť�� enqueue�Ѵ�. 
Queue.add(R)    => ť�� ���� ��带 ��ť �Ѵ�. 
    
while(!Queue.isEmpty()){ ť�� �� �̻� �湮�ؾ��� ��尡 ���� ������ �Ʒ��� ������ �ݺ��Ѵ�.
int a = q.poll()    -> ť���� ���� �տ� �ִ� ��带 ������. �� ������ ������ ��带 �湮�ϴ� �����̶�� ����.
        
����  -> ������ ���� �������� �� �� ���͸��� ���ش�. 
        
if(!visit[a]){ 
//���� �湮���� �ʾҴٸ� �湮 ó���� ���ְ� ��ť���ִ� ������ �ݺ��Ѵ�. 
            visit[a] = true;
            Queue.add(a);
        }
    }
}
5 5 1
1 4
1 2
2 3
2 4
3 4

1
2
4
3
0

*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<ArrayList<Integer>>(V+1);
		
		for(int i=0; i<V+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			list.add(al);
		}
	
		//���� �� ��ŭ �ݺ�

		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
			
			
		}
		
		for(int i=1; i<=V; i++) {
			Collections.sort(list.get(i));
			
		}
		
		
//		for(int i=0; i<list.size(); i++) {
//			for(int k=0; k<list.get(i).size(); k++) {
//				
//				System.out.print(list.get(i).get(k) + " ");
//			}
//			System.out.println();
//		}
		
		bfs(R);
	
		
		
	}

	private static void bfs(int r) {
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
