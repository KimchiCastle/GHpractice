package MyMain;

import java.util.Scanner;

public class Practice {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 미리 스캐너 sc 객체선언, Scanner 템플릿 완성 한다.
		
		boolean bBln =  5 > 3; // 앞에 b는 변수의 성질을 나타내는 헝가리언표기법임
		
		System.out.printf("입력 되어있던 %b 값입니다.\n",bBln);
		
		//논리형자료형 boolean형 1bit크기 true or false 값 나타낸다. 출력서식은 %b or %B로 표기한다.
		
		System.out.println("123"); // 정수형의 기본형은 int형이다. 
		//System.out.println("123L"); 뒤에 L을 입력해줌으로서 long형으로 만들 수 있다.
		
		int a ; // 정수형 변수 a를 선언하고 그안에 486이라는 값을 넣은것
		a = 486;
		
		//정수형자료형 byte(1byte) short(2byte) int(4byte) long(8byte) 각각 메모리가 할당 되어있다.
		//값은 할당되어 있는 메모리 크기마다 다름, 출력서식은 다음과 같다.
		/*
			%d(decimal) = 10진수로 출력
			%x(hexa)    = 16진수로 출력
			%o(octal)	=  8진수로 출력
		*/
		
		
		
		
		
		sc.close();
		
	}
	
	
	
	
	
	
}

	



