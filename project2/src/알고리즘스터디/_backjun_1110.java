package 알고리즘스터디;

import java.util.Scanner;

public class _backjun_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을
		 * 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리
		 * 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
		 * 
		 * 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운
		 * 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
		 * 
		 * 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
		 * 
		 * N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.
		 * 
		 * 출력 첫째 줄에 N의 사이클 길이를 출력한다.
		 * 
		 */
		Scanner sc = new Scanner(System.in);

		String n = sc.next();

		String x = n; //정답 저장

		String plus = "111"; //정답과 비교하기

		String res = ""; // 배열값저장용

		int dap; // 숫자 더하기

		int count = 0; // 정답

		String[] num = new String[2];
		
		//입력값이 10이하일때
		if (Integer.parseInt(n) < 10) {
			n =  "0" + n;
		}

		//반복문 들어가기 전 문자열 스플릿
		for (int i = 0; i < num.length; i++) {
			num[i] = n.substring(i, i + 1);
			//System.out.print(num[i]);
		
		}

		while (Integer.parseInt(x) == (Integer.parseInt(plus))  != true ) { // 입력이 결과랑 다르면 계속해라
			
			count++;
		
			
			dap = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);

			res = String.valueOf(dap);

			if (/*Integer.parseInt(res)*/ dap >= 10) {
				res = res.substring(1, 2);
				num[0] = num[1];
				num[1] = res;

				plus = num[0] + num[1];

			} else {
				num[0] = num[1];
				num[1] = res;

				plus = num[0] + num[1];
			}
			
			//문자열 스플릿
			for (int i = 0; i < num.length; i++) {
				num[i] = plus.substring(i, i + 1);
				//System.out.print(num[i]);
			}
			System.out.println(plus);
			
		}

		System.out.println(count);
	}

}
