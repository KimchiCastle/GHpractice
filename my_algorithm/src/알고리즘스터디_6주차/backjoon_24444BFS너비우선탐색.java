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
	
	
	
	static int V, E, R;
	
	public static void main(String[] args) throws Exception {	
/*
예제
5 5 1
1 4
1 2
2 3
2 4
3 4
정답
1
2
4
3
0
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		//노드 수
		V = Integer.parseInt(st.nextToken());
		//간선 수
		E = Integer.parseInt(st.nextToken());
		//시작지점
		R = Integer.parseInt(st.nextToken());
		
		//그래프를 구현하기 위한 리스트 객체 생성
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(V+1);
		
		for(int i=0; i<V+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			list.add(al);
		}
	
		//간선 수 만큼 반복 인접리스트, 그래프 구현
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//무방향 그래프이때문에, 양쪽다 값넣기
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		//문제는 오름차순으로 출력하기 때문에, 리스트를 정렬한다.
		for(int i=1; i<=V; i++) {
			Collections.sort(list.get(i));	
		}
		//직접만든 bfs 메소드 호출, 호출시 시작지점을 매개변수로 준다.
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
		
		// q가 비어있지 않으면 반복해라.
		while( !q.isEmpty() ) {
			
			//q에 첫부분 노드를 꺼낸다. 이시점이 방문시점이다.
			int a = q.poll();
			arr[a] = ++count;
			
			
			//꺼낸 a의 인접노드들을 꺼내 확인
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
