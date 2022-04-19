package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2580 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*		
	https://www.acmicpc.net/problem/2580
	
	
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0


1 3 5 4 6 9 2 7 8
7 8 2 1 3 5 6 4 9
4 6 9 2 7 8 1 3 5
3 2 1 5 4 6 8 9 7
8 7 4 9 1 3 5 2 6
5 9 6 8 2 7 4 1 3
9 1 7 6 5 2 3 8 4
6 4 3 7 8 1 9 5 2
2 5 8 3 9 4 7 6 1
		
*/		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		
		
		int [][] sudoku = new int [9][9];
		
		
		//배열 입력
		for (int i = 0; i < sudoku.length; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int k = 0; k < sudoku.length; k++) {
				sudoku[i][k] = Integer.parseInt(st.nextToken());
			}
			

		}
		
		
		//스도쿠 채우기
		//3x3
		int n = 1;
		for (int i = 0; i < 3; i++) {
			
			for (int k = 0; k < 3; k++) {
				
				if (sudoku[i][k] == 0) {
					sudoku[i][k] = n;
					
				}
				n++;
			}
			
			
			
		}
		
		
		//row배열 1줄단위에 0인 수를 찾고 그 위치를 저장한다
		//row배열 1줄의 모든 수를 검색해 0인 값에 1 ~ 9 를 제외 한 값을 넣는다.
		//col배열의 수를 확인한다. 중복수를 추출한다
		//col 중복수 제거후 없는 수를 넣는다.
		
		
		
		//출력
		for (int i = 0; i < sudoku.length; i++) {
			for (int k = 0; k < sudoku[i].length; k++) {
				
				System.out.printf("%d ",sudoku[i][k]);
				
			}
			System.out.println();
		}
		
		
	}

}
