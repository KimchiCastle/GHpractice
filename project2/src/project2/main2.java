package project2;

import java.util.Scanner;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		String[] name = new String[n];
		int[] subject1 = new int[n];
		int[] subject2 = new int[n];
		int[] subject3 = new int[n];

		int res_index = 0;
		int first_index = 0;
		int second_index = 0;
		int third_index = 0;

		for (int i = 0; i < n; i++) {

			name[i] = scan.next();

			subject1[i] = scan.nextInt();
			subject2[i] = scan.nextInt();
			subject3[i] = scan.nextInt();

		}

		int max = subject1[0];

		// 1등구하기
		for (int i = 0; i < n; i++) {
			if (subject1[i] > max) {

				max = subject1[i];

				first_index = i;
			}
		}

		int count1 = 1;
		int count2 = 1;

		// 1등의 인덱스를 이용해 나머지과목 등수 구하기
		for (int i = 0; i < n; i++) {
			if (subject2[first_index] < subject2[i]) {
				count1++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (subject3[first_index] < subject3[i]) {
				count2++;
			}
		}

		
		System.out.printf("%s %d %d",name[first_index], count1, count2);
	}

}
