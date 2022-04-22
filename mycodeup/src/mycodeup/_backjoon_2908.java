package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _backjoon_2908 {

	public static void main(String[] args) throws IOException {
		/*
		 * 상근이의 동생 상수는 수학을 정말 못한다. 
		 * 
		 * 상수는 숫자를 읽는데 문제가 있다. 
		 * 
		 * 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 
		 * 
		 * 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
		 * 
		 * 상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
		 * 
		 * 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
		 * 
		 * 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
		 * 
		 * 출력 첫째 줄에 상수의 대답을 출력한다.
		 * 
		 * 예제 입력 1 734 893 예제 출력 1 437
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine(); //입력 값 저장
		
		//입력값 자르기
		StringTokenizer st = new StringTokenizer(input);
		
		//자른 값을 각각 정수형 a b에 넣어줌
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		//빌더에 a b 로 넣고
		sb.append(a).append(" ").append(b);
		//빌더 메소드중 하나인 리버스를 사용해 뒤집어줌
		//toString메소드를 이용해 String형으로 저장
		String a1 = sb.reverse().toString();
		
		//그값을 다시 스플릿
		st = new StringTokenizer(a1);
		
		//스플릿 한 값을 각각 저장
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		//삼항연산자 사용 a2 < b2   true false
		System.out.println(a2 < b2 ? b2 : a2);
		
	}

}
