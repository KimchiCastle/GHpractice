package 알고리즘스터디_6주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class backjoon_24444BFS너비우선탐색 {
	
	static StringTokenizer st;
	
	static List<ArrayList<Integer>> list;
	
	static int V, E, R;
	
	public static void main(String[] args) throws Exception {
		
/*
map -> 탐색 대상이 존재하는 전체 맵 
visit -> 중복 방문 방지용 방문배열(boolean) 
 
BFS(R){ -> R은 출발 노드 혹은 출발 지점
 
Queue -> 방문할 노드를 저장할 큐를 생성. Enqueue하는 순간이 실제 방문이 아니라, 방문 해야할 노드의 리스트를 FIFO구조에 저장하는 것이다.
visit[R] = true -> 시작 노드에 대해 방문 처리를 해준다. 기본적으로 방문 처리를 먼저 하고 큐에 enqueue한다. 
Queue.add(R)    => 큐에 시작 노드를 인큐 한다. 
    
while(!Queue.isEmpty()){ 큐에 더 이상 방문해야할 노드가 없을 때까지 아래의 과정을 반복한다.
int a = q.poll()    -> 큐에서 가장 앞에 있는 노드를 꺼낸다. 이 시점이 실제로 노드를 방문하는 시점이라고 본다.
        
조건  -> 문제에 따른 조건으로 한 번 필터링을 해준다. 
        
if(!visit[a]){ 
//아직 방문하지 않았다면 방문 처리를 해주고 인큐해주는 과정을 반복한다. 
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
	
		//간선 수 만큼 반복

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
		
		// q가 비어있지 않으면 반복해라.
		while( !q.isEmpty() ) {
			
			//q에 첫부분 노드를 꺼낸다. 이시점이 방문시점이다.
			int a = q.poll();
			arr[a] = ++count;
			
			for(int i : list.get(a)) {
				if( visit[i] == false ) {
					//방문처리
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
