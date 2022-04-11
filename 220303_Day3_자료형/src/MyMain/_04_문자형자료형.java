package MyMain;

public class _04_문자형자료형 {

	/*
		문자형자료형 : char형 (2byte)
		상수 : 'A'   '한'   '韓'   <= 홑따옴표 ''
	 	출력서식 : %c
	 	
	 	####  ASCII(통신문자코드) : 0~126   ####
	 	0~31 : 통신 및 제어문자 ex) \n
	 	
	 			'\r' : carrige return(Home) 13번
	 			'\n' : new line (Enter) 10번
	 			'\t' : tab key
	 			'\b' : caret (입력위치)를 이전으로 
	 			
	 			'\a' : alert(경고음)
	 			'\f' : 다음장으로 이동
	 			
	
	 	32~126 : 키보드상 문자코드값
	 			 
	 			 ' ' : 32번 (공백문자)
	 			 'A' : 65번
	 			 'a' : 97번 (대 ~ 소 간격 : 32)
	 			 '0' : 48번
	 			 '1' : 49번
	 	
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("%c\n", 'A'); // A
		System.out.printf("%c\n", 65);	// A
		System.out.printf("%c\n", 66);	// B
		
		//'한'의 코드값 
		System.out.printf("%d\n",(int)'한'); // 54620
		System.out.printf("0x%x\n",(int)'한'); //d55c 2byte
		//2진수로 변경가능
		System.out.println(Integer.toBinaryString(54620)); // 1101010101011100
		
		System.out.printf("%c\n", 54620);
		
		//제어문자
		System.out.printf("%d\n",(int)'\n'); // 아스키코드로 10번 문자형을 (int)' '<<정수형으로 변환
		
		System.out.println("A\nB\n");
		
		System.out.println("A\tB\tC\n");
		

		
	}

}
