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
		
		
		//�迭 �Է�
		for (int i = 0; i < sudoku.length; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int k = 0; k < sudoku.length; k++) {
				sudoku[i][k] = Integer.parseInt(st.nextToken());
			}
			

		}
		
		
		//������ ä���
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
		
		
		//row�迭 1�ٴ����� 0�� ���� ã�� �� ��ġ�� �����Ѵ�
		//row�迭 1���� ��� ���� �˻��� 0�� ���� 1 ~ 9 �� ���� �� ���� �ִ´�.
		//col�迭�� ���� Ȯ���Ѵ�. �ߺ����� �����Ѵ�
		//col �ߺ��� ������ ���� ���� �ִ´�.
		
		
		
		//���
		for (int i = 0; i < sudoku.length; i++) {
			for (int k = 0; k < sudoku[i].length; k++) {
				
				System.out.printf("%d ",sudoku[i][k]);
				
			}
			System.out.println();
		}
		
		
	}

}
