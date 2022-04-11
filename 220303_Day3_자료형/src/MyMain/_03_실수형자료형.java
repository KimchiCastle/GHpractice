package MyMain;

public class _03_실수형자료형 {

	/*
	 실수형자료형 : float double(기본형) <=소숫점이 있는 수
	 상수 : 1.0, 0.x   <- double (기본형)
			1.0F	  <- float
			1.0e + 2  <- 지수형태
	출력서식 : %f	  <- 소숫점 이하 6자리 까지 표기
			   %e	  <- 소숫점 이하 6자리
			   %E     <- 대문자
			   %g	  <- 자릿수가 적은쪽으로 출력 하지만 잘 쓰이질 않는다.
	
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1.0); // <- double형(기본형)
		System.out.println(1.0F); // <- float형(F)
		System.out.println(1.0e+2); // <- 지수형태
		
		double d = 12.345678901;
		System.out.printf("%f\n",d); // 12.345679 6자리 초과 자리는 반올림 되어서 6자리에 출력됨
		System.out.printf("%e\n",d); // 1.234568e+01
		System.out.printf("%E\n",d); // 
		System.out.printf("%g\n",d); // 기준이 없어서 잘 쓰지 않음
		
		double pi = Math.PI; //Math 클래식에서 PI메소드?객체?를가져옴
		
		// %m.nf	: m(전체자릿수) . n(소숫점이하자릿수)
		// %0m.nf	: 0(앞의 빈공간은 0으로 채워라)
		// %-m.nf	: -(Left 정렬)
		
	
		System.out.println(pi);			  // 3.141592653589793
		
		System.out.printf("%f\n", pi);	  // 3.141593
		
		System.out.printf("[%30f]\n",pi); //  [                      3.141593]
		
		System.out.printf("[%30.20f]\n",pi);/*[        3.14159265358979300000]
												전체자릿수는 30자리, 소숫점자릿수는 20자리 */
		System.out.printf("[%30.2f]\n",pi); //[                          3.14]
		
		System.out.printf("[%030.2f]\n",pi);//[000000000000000000000000003.14] 빈공간을 0으로
		
		System.out.printf("[%-30.2f]\n",pi);//[3.14                          ] 왼쪽정렬
		
		// 출력자릿수 > 지정한전체자릿수 : 전체자릿수가 무시(대부분 생략)
		System.out.printf("[%5.7f]\n",pi); // [3.1415927]
		System.out.printf("[%.7f]\n",pi); //전체자릿수 생략
		
	}

}
