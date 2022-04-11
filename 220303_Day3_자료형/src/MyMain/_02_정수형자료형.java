package MyMain;

public class _02_정수형자료형 {

	/*	
	정수형자료형 : byte short int long -> 기본형 int형
	상수 :   1 0 <= 소숫점이 없는 수
			 1L  <= long형 상수
			 
			 10진수 : 100
			 16진수 : 0x64	<=앞에 0x
			 		  0~9숫자 10 11 12 13 14 15
			 		  		   a  b  c  d  e  f
			 		  0xf	<= 15  (4bit가 꽉차서)
			 		  0xff	<= 255 (8bit가 꽉차서) #ffffff (#=16진수, R,G,B) HTML에서 표기법
			 		  
			  8진수 : 0144	<=앞에 0(숫자 zero)
	출력서식: %d (decimal)	: 10진수 로 출력하라
			  %x (hexa)		: 16진수 로 출력하라
			  %o (octal)	:  8진수 로 출력하라
		
	*/	
	public static void main(String[] args) {
		System.out.println(1);	//4byte int형 기본형이라서
		System.out.println(1L); //8byte long형으로 출력(L)

		//100에 대한 진수값 출력
		System.out.printf("10진수: %d\n",100); // "10진수 : %d"%d ,변수<를 표시하라 [10진수: 100]
		System.out.printf("16진수: 0x%x\n",100); //[16진수: 0x64]
		System.out.printf(" 8진수: 0%o\n",100); // [ 8진수: 0144]
		
		//각 진수의 값->10진수로 출력
		System.out.printf("%d\n", 0x64); //100
		System.out.printf("%d\n", 0144); //100
		System.out.printf("%d\n", 0xff); //255
		
		//자릿수 지정해서 출력가능
		int n = 123;
		
		// %md  : m <-지정자릿수
		System.out.printf("[%10d]\n", n); //[       123]
		
		// %0md  : 0<-빈 공간은 0으로 채워라 m <-지정자릿수 
		System.out.printf("[%010d]\n", n);//[0000000123]
		
		// %-md  : -m 음수부호는 정렬을 Left  m<-지정자릿수 
		System.out.printf("[%-10d]\n", n);//[123       ]			
		//System.out.printf("[%-010d]", n);	Error		
		
		// 출력자릿수 > 지정자릿수 : 지정자릿수는 무시됨
		System.out.printf("[%2d]\n", n);//[123]
		
		
		//------------------
		
		int a = 3698;
		
		System.out.printf("[0x%x]\n", a);
				
	}
	
}
