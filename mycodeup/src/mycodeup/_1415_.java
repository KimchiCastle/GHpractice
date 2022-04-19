package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1415_ {

	static List<Integer> array;
	static int n;
	static BufferedReader br; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
/*
	데이터 정렬은 프로그래밍 문제를 푸는데 많이 사용된다.

N개의 데이터가 입력되면, 오름차순된 결과를 출력하는 프로그램을 작성하시오.

입력
첫째줄에 N이 입력된다. (1<=N<=10,000)
다음 줄부터 N개의 데이터가 한 줄에 한 개씩 입력된다.

출력
오름차순 정렬한 결과를 한 줄에 하나씩 순서대로 출력한다.

입력 예시   
5
7
3
10
2
1

출력 예시
1
2
3
7
10		
*/		
		br = new BufferedReader( new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		array = new ArrayList<Integer>();
		
		
		mysort();
		
		display();
		
		
	}

	private static void display() {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

	private static void mysort() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());			
			array.add(a);
		}
		
		Collections.sort(array);
	}

}
