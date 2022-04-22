package mycodeup;

import java.util.List;
import java.util.Scanner;

public class Main_1099_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for문을 이끌어가는 변수를 프로그래밍에 따라 변하게 두면 xx
		// 벗어나는것도 생각하기(else)
		// 시작지점에 뭔가 있는걸 고려하지 않안ㅆ따....
		Scanner sc = new Scanner(System.in);

		int[][] a = new int[11][11];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();

		int c = 1; // 열
		int r = 1; // 행
		// 밑에 1이 있을때도 만들기 //이차원배열이라 length주면xx 안됨
		
		a[r][c]=9;
		
	
		
		   while(true){ // 1,1부터
			
				// 베이스: 주변을 미리 살펴보고, 내 자리에 9주고, 이동
				// ||경제적연산 조심
			   //c++;
				if (a[r][c] == 2 ) {//제일 첫칸에 먹이가 있으면 멈춰라					
				   break;
				} else if (a[r][c+1] != 1 ) {// 오른쪽1이아니면 오른쪽 가고 9. 
					//a[r][c] = 9;
					c++;	
				} else if(a[r][c+1]==1) {
					r++;	
				}
				if (a[r+1][c]==1) {
					break;
				
				}else if (a[r][c] == 2 ) {
					a[r][c] = 9; 
					break;
				}
				a[r][c]=9;
				
//숙제 : 더 줄이자 
			}//end while
		

	for (int j = 0; j < 10; j++) {
		for (int i = 0; i < 10; i++) {

				System.out.printf("%d ", a[j][i]);
			}
			System.out.println();
		}

	}

}
