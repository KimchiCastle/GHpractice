package 알고리즘스터디_6주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2606BFS바이러스 {

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
		
		//그래프 저장해줄 객체 생성
		for(int i=0; i<N+1; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			list.add(al);
			
		}
		
		//리스트에 그래프 데이터 넣기 간선만큼 반복!!
		for(int i=1; i<=E; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//무방향 그래프라 반대쪽도 이어줘야한다.
			list.get(u).add(v);
			list.get(v).add(u);
			
		}
		//bfs 메소드 호출
		bfs(S);
		
	}

	private static void bfs(int s) {
		// TODO Auto-generated method stub
		
		//탐색을 위한 Queue 객체 생성
		Queue<Integer> q = new LinkedList<Integer>();
		
		//탐색 유무 확인용 Boolean 배열 생성 노드크기만큼
		boolean [] check = new boolean[N+1];
		
		
		q.add(s);
		
		//q에 넣음과 동시에 탐색 true
		check[s] = true;
		
		//정답 제출용 변수
		int count = 0;
		
		//q가 빌때까지 반복하기
		while( !q.isEmpty() ) {
			
			//실질적 방문
			int a = q.poll();
			//a와 연결된 그래프 꺼낼 반복문
			for(int i : list.get(a)) {
			
				if (check[i] == false) {
					
					//방문처리하기
					check[i] = true;
					count++;
					
					q.add(i);
					
				}
			}
			
		}
		
		System.out.println(count);
		
		
	}

}
