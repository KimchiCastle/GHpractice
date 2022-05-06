package mycodeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1509 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[11][10];
		
		//현재 말의 상태변수
		final int FALL = 2;
		final int CRASH = 3;

		StringTokenizer st;
		//보드판 생성
		for (int i = 0; i < board.length; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int k = 0; k < board[i].length; k++) {

				board[i][k] = Integer.parseInt(st.nextToken());
			}

		}

		// 말움직임 
		for (int i = 0; i < 10; i++) {

			int point = 0;
			int life = 0;
			
			for (int k = 0; k < 10; k++) {

				// 말이 벽을 만났을 경우
				if (point < board[k][i]) {
					life = CRASH;
				}
				// 말이 떨어졌을 경우
				if (point > board[k][i]) {
					life = FALL;
				}

			
				//포인트가 말 앞까지 왔을경우
				if (k == 9) {
					//한칸 앞 들여다 봐서 말이 있는지 없는지 확인
					if (board[k + 1][i] == 1) {
						// 말이 떨어진 상태
						if (life == FALL) {
							System.out.printf("%d fall\n", i + 1);
							// 벽에 박았을 경우
						} else if (life == CRASH) {
							System.out.printf("%d crash\n", i + 1);
						} else if (life == 0) {
							System.out.printf("%d safe\n", i + 1);
						}
					}
				} //말 생존확인 if문 종료
				
			}// 말 확인 한줄 끝 k++


		} // 전체 for문 종료


	}

}
