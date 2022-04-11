package MyMain;

public class _05_문자열자료형 {

	/*
	
		문자열자료형 : String
		 문자열 : 1개 이상의 문자의 나열된 값
		 		  "ABC" -> 'A''B''C'
		
		상수     : "ABC" <- 쌍따옴표
		출력서식 : %s 
				   %.ms <- 문자수를 m개만 출력
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "홍길동";
		String addr = "서울시 마포구 서교동 123"; // char로 저장하면 안됨
				
		System.out.printf("이름 : %s\n", name);
		System.out.printf("주소 : %s\n", addr);
		
		System.out.printf("시 : %.3s\n", addr);
		System.out.printf("시구 : %.7s\n", addr);
		
		
	}

}
