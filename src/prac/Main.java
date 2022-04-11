package prac;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int w = 0; // 배열 넓이
		int h = 0; // 배열 높이

		int n = 0; // 막대개수

		int x = 0; // x좌표
		int y = 0; // y좌표

		int l = 0; // 막대의 길이
		int d = 0; // 막대의 방향

		// System.out.print("배열설정 : ");
		w = scan.nextInt();
		h = scan.nextInt();

		// if ((w <= 0 && w > 100) || (h <= 0 && h > 100)) break;

		// System.out.println("w : "+ w);
		// System.out.println("h : "+ h);

		int[][] array = new int[w][h];

		/*
		 * // 생성된 배열 0으로 다 채우기 for (int i = 0; i < array.length; i++) {
		 * 
		 * for (int k = 0; k < array[i].length; k++) {
		 * 
		 * array[i][k] = 0;
		 * 
		 * }
		 * 
		 * }
		 */
		// System.out.print("막대개수 : ");

		n = scan.nextInt();

		// if (n <= 0 && n > 10)break;

		// System.out.println("정보 입력");
		for (int i = 0; i < n; i++) {

			// 막대길이
			l = scan.nextInt();
			// 방향
			d = scan.nextInt();
			// 좌표
			x = scan.nextInt();
			y = scan.nextInt();

			if ((d == 0 || d == 1) != true) {
				System.out.println("방향을 잘못 입력 하였습니다.");
				i--;
				continue;
			}

			// 막대 배열에 넣기
			for (int k = 0; k < l; k++) {

				// System.out.println("입력for문 들어갔습니다.");

				// 방향 가로일때
				if (d == 0) {

					array[x - 1][y - 1] = 1;
					y++; // y좌표 한칸 오른쪽으로

					// 방향 세로
				} else {

					array[x - 1][y - 1] = 1;
					x++;

				}

			} // 막대 for 종료

		} // for-end

		// 배열출력
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array[i].length; k++) {

				System.out.printf("%d ", array[i][k]);

			}
			System.out.println(); // 배열 줄바꿈
		}

	}

}
