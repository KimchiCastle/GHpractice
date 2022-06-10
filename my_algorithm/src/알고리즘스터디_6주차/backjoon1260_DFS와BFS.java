package 알고리즘스터디_6주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon1260_DFS와BFS {
	
	static StringTokenizer st;
	
	static List<ArrayList<Integer>> list;
	
	static int N, E, S;
	
	
	
	static boolean [] visit;
	static boolean [] visit2;
	
	static int [] res;
	static int [] res2;
	
	static int count;
	
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
---
1
2
3
4
0		
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		visit2 = new boolean[N+1];
		
		res = new int[N+1];
		
		
		list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<N+1; i++) {
		
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			list.add(al);
		}
		
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
		
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		 
		// 리스트를 정렬한다.
		for(int i=1; i<=N; i++) {
			Collections.sort(list.get(i));	
		}
		
//		for(int i=1; i<list.size();i++) {
//			for(int k=0; k<list.get(i).size(); k++) {
//				
//				System.out.printf("%d ",list.get(i).get(k));
//				
//			}
//			System.out.println();
//		}
		
		
		sb = new StringBuilder();
		
		
		
		dfs(S);
		
		sb.append("\n");
		
		bfs(list,S);
		

		
		
		System.out.println(sb); 
		
	}

	private static void dfs(int s) {
		// TODO Auto-generated method stub

		visit[s] = true;	
		
//		res[s] = ++count;
		
		sb.append(s).append(" ");
		
		
		for (int a : list.get(s)) {
			
			if (visit[a] == false) {
				
				dfs(a);

			}

		}

	}
	
	
	private static void bfs(List<ArrayList<Integer>> list, int r) {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		
		visit2[r] = true;
		q.add(r);
		
//		int count = 0;
//		res2 = new int[N+1];
		
		// q가 비어있지 않으면 반복해라.
		while( !q.isEmpty() ) {
			
			//q에 첫부분 노드를 꺼낸다. 이시점이 방문시점이다.
			int a = q.poll();
//			res2[a] = ++count;
			
			sb.append(a).append(" ");
			
			//꺼낸 a의 인접노드들을 꺼내 확인
			for(int i : list.get(a)) {
				
				if( visit2[i] == false ) {
					//방문처리
					visit2[i] = true;
					q.add(i);
				}
			
			}
			
		}
		

	}
	

}
