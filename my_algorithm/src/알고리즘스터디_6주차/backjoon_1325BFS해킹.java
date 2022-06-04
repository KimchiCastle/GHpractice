package 알고리즘스터디_6주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_1325BFS해킹 {

	static StringTokenizer st;
	
	static int N, E;
	
	static List<ArrayList<Integer>> list;
	
	static int [] result;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*		
5 4
3 1
3 2
4 3
5 3

제일 많이 해킹할 수 있는 컴퓨터가 여러대 일 수 있다. 
오름차순 정렬해서 출력
배열을 미리 만들어 놓고, 그배열에 해킹수를 넣어서..
1 2
*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		//노드, 간선 받기
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<ArrayList<Integer>>(N+1);
	
		result = new int[N+1];
		
		// 그래프 저장용 리스트 생성
		// 정답배열 값 넣어주기.
		for(int i=0; i<N+1; i++) {
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			list.add(al);
			
			result[i] = i;
			
		}
		
		//리스트에 그래프 연결, 간선만큼 반복하기
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(v).add(u);
			
			
		}
		
		
	}

}
