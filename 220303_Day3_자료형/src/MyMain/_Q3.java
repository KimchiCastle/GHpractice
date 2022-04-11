package MyMain;

import java.util.Scanner;

public class _Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//이름 주소저장할 변수
		String name;
		String addr;

		System.out.print("이름 : ");
		//name = scan.next(); // 문자열 입력받기 (next는 입력받을때 공백전까지만 입력)
		name = scan.nextLine(); // 공백 포함해서 입력받음
		
		
		System.out.print("주소 : ");
		addr = scan.nextLine();
		
		
		System.out.println("---[입력받은 정보]---");
		System.out.printf("이름 : %s\n", name);
		System.out.printf("주소 : %s\n", addr);
		
		
		
		scan.close();
	}

}
