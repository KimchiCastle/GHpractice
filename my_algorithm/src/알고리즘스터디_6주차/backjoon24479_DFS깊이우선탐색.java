package 알고리즘스터디_6주차;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon24479_DFS깊이우선탐색 {
	
	static StringTokenizer st;
	
	static List<ArrayList<Integer>> list;
	
	static int N, E, S;
	
	static StringBuilder sb;
	
	static boolean [] visit;
	
	static int [] res;
	
	static int count;
	
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
		 
		//문제는 오름차순으로 출력하기 때문에, 리스트를 정렬한다.
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
		
		for(int i=1; i<res.length; i++) {
			sb.append(res[i]).append("\n");
		}
		
		
		System.out.println(sb); 
		
	}

	private static void dfs(int s) {
		// TODO Auto-generated method stub

		visit[s] = true;	
		
		res[s] = ++count;
		
		for (int a : list.get(s)) {
			
			if (visit[a] == false) {
				
				dfs(a);

			}

		}

	}
	
	

}
