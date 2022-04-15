package project2;


import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 영어 문장이 입력된다.
		 * 
		 * 그 문장에서 love가 몇 번 나오는지 출력하시오.
		 * 
		 * 입력 영어 한 문장이 입력된다.(공백 있음, 최대 글자수 100)
		 * 
		 * 출력 소문자 love가 몇 번 나오는지 출력한다.
		 * 
		 * 입력 예시 love lovely
		 * 
		 * 출력 예시 2
		 * 
		 * 
		 * 
		 * 
		 */
		Scanner scan = new Scanner(System.in);

		String a = scan.nextLine();

		// love 카운트 횟수
		int count = 0;

		// 문자열길이만큼 반복
		for (int i = 0; i < a.length(); i++) {

		
			if (a.charAt(i) == 'l'/* && a.charAt(i + 1) == 'o'*/) { // l 찾기

				if (a.charAt(i + 1) == 'o') { // 그다음문자가o인지

					if (a.charAt(i + 2) == 'v') { // 그다음문자가 v인지
						
						if (a.charAt(i + 3) == 'e') { // 그다음문자가 e인지
							count++;

						}

					}

				} 
			}
		}
		System.out.println(count);

	}

}
