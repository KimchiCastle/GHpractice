package 알고리즘스터디_6주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon2178_BFS미로 {

	
	static int [][] maze;
	
	//				   우 하  좌  상
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	
	static int N, M;
	
	static boolean [][] visit;
	

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
4 6
101111
101010
101011
111011
------
15
*/		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N][M];
		maze = new int[N][M];
		
		//메이즈 만들고, 방문처리 미리하기
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int k=0; k<M; k++) {
				//			문자를 정수로 변환해줌
				maze[i][k] = line.charAt(k) - '0';
				
				if(maze[i][k] == 0) {
					visit[i][k] = true;
				}
				
			}
		}
		
		
		// DFS는 이런식으로 탐색 하나??
//		for(int i=0; i<maze.length; i++) {
//			
//			for(int k=0; k<maze[i].length; k++) {
//				
//				if(maze[i][k]==1 && !visit[i][k]) {
//					bfs(i,k);
//				}
//				
//			}
//		}
		
		
		bfs(0,0);
		

		
		for(int i=0; i<maze.length; i++) {
			for(int k=0; k<maze[i].length; k++) {
				
				System.out.printf("%3d " ,maze[i][k]);
				
			}
			System.out.println();
		}
		
		
		
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		
		//Queue 선언
		Queue<int[]> q = new LinkedList<int[]>();
		
		int count = 0;
		
		//q에 값 넣기
		q.add(new int [] {x,y});
		
		//q에 값이 빌때까지 반복하라
		while( !q.isEmpty() ) {
			
			int [] arr = q.poll();
			//방문처리
			visit[x][y] = true;
			
			for(int i=0; i<4; i++) {
				
				int a = arr[0] + dx[i];
				int b = arr[1] + dy[i];
				
				//좌표를 벗어나지 않는다면..
				if(a >= 0 && b>=0 && a<N && b<M) {
					
					if(maze[a][b]==1 && !visit[a][b]) {
						
						//현재 탐색위치로 돌아가서 +1
						maze[a][b] = maze[arr[0]][arr[1]] +1;
						//현재 탐색위치가 자꾸 변해서 원하는 값이 안나온다.
//						maze[a][b] = ++count;
						
						
						q.add(new int [] {a,b} );
						
					}
					
				}
				
			}
			
			
			
		}
		
		
	}

}
