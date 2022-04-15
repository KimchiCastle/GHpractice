package project2;



import java.util.Scanner;

public class code1 {

	public static void main(String[] args) {
		

	    Scanner scan = new Scanner(System.in);
	     
	    String cal=""; 
	   
	    cal = scan.next(); // nextLine();로 받으면 스플릿시 띄워쓰기 가능
	    
	    
	    // \\역슬레쉬 2개를 사용하면 '이스케이프처리' 라고 한다.
	    String [] can2 = cal.split("\\."); // 메타문자에 대한 중요성!!!
	  
	    
	    //스플릿에 쓰이는 메타문자
	    //^ : 문자열의 처음을 나타낸다.
	    //$ : 문자열의 끝을 나타낸다.
	    //. : 임의의 한 문자를 나타낸다.
	    //+ : 바로 앞의 문자가 하나 이상이다.
	    //? : 앞의 문자가 없거나 하나이다.
	    //[ ] : 한 문자를 가리키고 묶음 안의 내용은 가리키는 문자의 범위를 나타낸다.
	    //{ } : 앞에 있는 문자의 개수를 나타내고 묶음 안에서 ','는 문자 개수의 범위를 나타낼 때 쓴다.
	    //( ) : 괄호 안의 문자열은 하나로 묶어 취급한다.
	    //| : 또는(or)의 뜻으로 선택문에 쓰인다.
	    //\ : 메타 문자의 성질을 없앨 때 붙인다. 

	    //이렇게 앞에 (Integer)로 형변환 해도 되지않는다.
	    //System.out.printf("%d", (Integer)can2[1]);

	    //스트링자료형을 int형으로 형변환 int형의 래퍼클래스 Integer내 parseInt메소드 사용
	    System.out.printf("%04d.%02d.%02d",Integer.parseInt(can2[0]),Integer.parseInt(can2[1]),Integer.parseInt(can2[2]));
	  
	}

}

