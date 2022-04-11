package MyMain;

public class _01_논리형자료형 {

	/*
	
	자료형(DataType)
	1.용도 : 메모리에 공간 할당시 사용(변수할당)
	2.크기와 성질을 나타냄
	3.변수선언
		자료형	변수명;
		byte 	age;
		
		변수: Variable(가변값)
		성수: COnstant(불변값)
	*/
	/*
	 논리형 자료형 : boolean
	 상    수 : true or false
	 출력서식 : %b or %B (b,B는 boolean의 약자,%B = 대문자로 출력)
	 */
	
	
	/*	
	  	클래스명.객채명.메소드명();
	  	클래스(System) : 변수, 객체, 메소드 포함한 형식 자료형
	  	객체명(out)    : Object(실체)
	  	메소드(method) : 함수function(기능)
	  	
		System.out.print(값);	//출력만 해라 줄은 안바뀜
		System.out.prinln();	//출력 + 줄 바꿔라  (ln : line next)
		System.out.prinf();		//형식(Format)대로 출력해라 (출력서식쓸 때)
	
		\n : 줄바꾸는 문자형
	*/	
	

	
	public static void main(String[] args)/*메인<=메소드명 */{
		
		System.out.printf("%b %B\n",true, true);
		
		boolean bOk = 3 > 2 ;

		System.out.printf("3 > 2 : %b\n", bOk);
		
		
		
	}
}
