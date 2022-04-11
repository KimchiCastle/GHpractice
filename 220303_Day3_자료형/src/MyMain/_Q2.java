package MyMain;

import java.util.Scanner;

public class _Q2 {
	
	/*
		원의 반지름을 입력 받아서
		원 둘레와
		원 면적을 구하는 프로그램을 작성
		출력은 소숫점이하 1자리까지
	*/
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double pi = Math.PI; // 파이
		double r; // 반지름
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("반지름을 입력하세요. : ");
		r = scan.nextDouble();
		
		double circle_len = 2 * pi * r; // 둘레
		
		double circle_area = r * r * pi; // 면적
		
		System.out.printf("입력 하신 반지름[%.1f]의 원의 둘레은 [%.1f] 입니다.\n",
							r,circle_len
				);
		System.out.printf("입력 하신 반지름[%.1f]의 원의 면적은 [%.1f] 입니다.\n", 
							r,circle_area
				);
		
		scan.close();
	}

}
