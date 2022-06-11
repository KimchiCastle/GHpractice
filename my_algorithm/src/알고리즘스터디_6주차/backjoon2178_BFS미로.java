package �˰����͵�_6����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon2178_BFS�̷� {

	
	static int [][] maze;
	
	//				   �� ��  ��  ��
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
		
		//������ �����, �湮ó�� �̸��ϱ�
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int k=0; k<M; k++) {
				//			���ڸ� ������ ��ȯ����
				maze[i][k] = line.charAt(k) - '0';
				
				if(maze[i][k] == 0) {
					visit[i][k] = true;
				}
				
			}
		}
		
		
		// DFS�� �̷������� Ž�� �ϳ�??
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
		
		//Queue ����
		Queue<int[]> q = new LinkedList<int[]>();
		
		int count = 0;
		
		//q�� �� �ֱ�
		q.add(new int [] {x,y});
		
		//q�� ���� �������� �ݺ��϶�
		while( !q.isEmpty() ) {
			
			int [] arr = q.poll();
			//�湮ó��
			visit[x][y] = true;
			
			for(int i=0; i<4; i++) {
				
				int a = arr[0] + dx[i];
				int b = arr[1] + dy[i];
				
				//��ǥ�� ����� �ʴ´ٸ�..
				if(a >= 0 && b>=0 && a<N && b<M) {
					
					if(maze[a][b]==1 && !visit[a][b]) {
						
						//���� Ž����ġ�� ���ư��� +1
						maze[a][b] = maze[arr[0]][arr[1]] +1;
						//���� Ž����ġ�� �ڲ� ���ؼ� ���ϴ� ���� �ȳ��´�.
//						maze[a][b] = ++count;
						
						
						q.add(new int [] {a,b} );
						
					}
					
				}
				
			}
			
			
			
		}
		
		
	}

}
