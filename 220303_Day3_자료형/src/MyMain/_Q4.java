package MyMain;

import java.util.Scanner;

public class _Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다음 정보를 입력해서 출력하는 프로그램을 작성 하세요
		//입력 = 이름/나이/주소/키/몸무게
		
		String name;
		int age;
		String addr;
		double len;
		double wgt;
		
		Scanner scan = new Scanner(System.in);

		System.out.print("이름 : ");
		name = scan.nextLine(); 	// 홍길동(E) 입력구분자 까지 다 가져감
		System.out.print("나이 : ");
		age = scan.nextInt();		// 나이
		
		//키보드버퍼내의 엔터를 제거해야함
		scan.nextLine(); //그래서 scan(객체)에 있는 nextLine(메소드)를 다시한번 써야함
		
		System.out.print("주소 : ");
		addr = scan.nextLine(); 
		System.out.print("키 : ");
		len = scan.nextDouble();
		System.out.print("몸무게 : ");
		wgt = scan.nextDouble(); // 버퍼에 입력 되어있는(E)를 스킵
		
		System.out.println("---[입력한 정보]---");
		System.out.printf("이름 : %s\n 나이 : %d 살\n 주소 : %s\n 키 : %.1f cm\n 몸무게 : %.1f kg\n"
								,name,		 age,			 addr,			len,			wgt);
	
		scan.close();
	}
	
}
