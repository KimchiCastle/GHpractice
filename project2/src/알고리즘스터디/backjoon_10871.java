package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class backjoon_10871 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//값을 받아올 버퍼드리더 선언
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 

		//st에 받아온 값을 " "를 기준으로 로 자른다
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//자른 값을 순서대로 N과 X에 넣는다.
		int n = Integer.parseInt(st.nextToken()); // 수열 크기
		int x = Integer.parseInt(st.nextToken()); // 비교할 숫자
		
		//값을 출력하기 위한 StringBuilder 선언
		StringBuilder sb = new StringBuilder();
		
		//st를 다시한번 선언해서 br의 2번째줄 자른다.
		//어떻게 다음줄 입력값을 자르지??하고 고민하다가 결국 구글링했다.
		st = new StringTokenizer(br.readLine()); // 이부분 굉장히 중요한부분!
		
		
		for (int i = 0; i < n; i++) { // 수열만큼 반복			
			int v = Integer.parseInt(st.nextToken()); // v변수에 토크나이저로 자른 값을 1개씩 넣는다.
				if(v < x){ // 자른 값을 앞서 선언한 x와 비교
				sb.append(v).append(' '); // x보다 작은값을 빌더에 어팬드한다. 공백도 함께 
			}
					
		}
		
		System.out.println(sb); // 빌더에 저장되있는 값을 출력
	}

}
