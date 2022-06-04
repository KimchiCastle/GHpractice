package 알고리즘스터디_6주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_24445BFS너비우선탐색2 {
	
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

		//그래프 저장해줄 리스트 생성;
		for(int i=0; i<N+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			list.add(al);
		}
		
		//그래프 연결 저장, 간선만큼 !! 반복하기.
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		
		//문제가 내림차순정렬이기 때문에 내림차순 정렬하기.
		for(int i=1; i<=N; i++) {
			
			Collections.sort(list.get(i), Collections.reverseOrder());
			
		}
		
		bfs(S);
		
		System.out.println(sb);
		
	}


	private static void bfs(int s) {
		// TODO Auto-generated method stub
		
		//탐색을 위한 Queue생성
		Queue<Integer> q = new LinkedList<Integer>();
		
		//탐색완료 체크를 위한 Boolean 배열 생성
		boolean [] check = new boolean[N+1];
		
		//q에 시작값 넣기, 넣음과 동시에 방문처리.
		q.add(s);
		check[s] = true;
		
		
		int count = 0;
		int [] res = new int [N+1];
		
		//q가 빌때까지 반복
		while( !q.isEmpty() ) {
			
			//q 빼고, int a에 저장
			int a = q.poll();
			
			//a위치에 방문처리
			res[a] = ++count;
			
			//a와 연결된 노드값 가져올 개선된 for
			for(int i : list.get(a)) {
				
				//방문 안했으면? 방문처리하기.
				if(check[i] == false) {
					
					check[i] = true;
					
					//꺼내온 i를 Queue에 저장
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
