package MyMain;

//해당클래스의 위치를 알려준다
import java.util.Scanner;

public class _Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int width = 20;
		int height= 30;
		
		//값을 입력 받아서 처리해야함
		//1.키보드로부터 입력받는 객체 생성
		//System.in  : 입력객체
		//System.out : 출력객체
		Scanner scan = new Scanner(System.in);
		//식별자 
		
		System.out.print("가로(폭):");
		width = scan.nextInt();// 키보드로부터 입력받은 값을 int형으로 전달해줘
		
		
		System.out.print("세로(폭):");
		height = scan.nextInt();
		
		
		//면적계산
		int area = width * height;
		
		System.out.printf("가로:%d[㎝] 세로:%d[㎝]인 사각형의 면적은 : %d[㎠]\n",
							width, 		height, 				area
				);
	
		scan.close();

	}

}
