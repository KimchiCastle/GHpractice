package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_10798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
	총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 
	최대 15개의 글자들이 빈칸 없이 연속으로 주어진다. 
	주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 
	각 줄의 시작과 마지막에 빈칸은 없다.
출력
영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다. 
	예제 입력 1 
ABCDE
abcde
01234
FGHIJ
fghij
	
	예제 출력 1 
	Aa0FfBb1GgCc2HhDd3IiEe4Jj
	
	예제 입력 2 
AABCDD
afzz
09121
a8EWg6
P5h3kx
	
	예제 출력 2 
	Aa0aPAf985Bz1EhCz2W3D1gkD6x
		
*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder [] sb = new StringBuilder[15];
		String s = new String();

		for(int i=0; i<15; i++) {
			sb[i] = new StringBuilder();
		}
		
		for(int i=0; i<5; i++) {
				s= br.readLine();
				for(int k=0; k<s.length(); k++) {
					sb[k].append(s.charAt(k));
				}
		}
		
		for(int k=0; k<15; k++) {
			System.out.print(sb[k]);
		}
		
		*/
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		//입력값을 넣어줄 배열생성
		char [][] st1 = new char [5][15];
		
		
		//입력값 생성된 배열 삽입
		for(int i = 0 ; i<5; i++) {	// 행만큼 반복
			String info = br.readLine();
			
			for(int k = 0; k<info.length(); k++) { // 스트링 문자열 길이만큼 반복
			
				st1[i][k] = info.charAt(k); // 문자열을 1글자씩캐릭터형으로 잘라낸다.
			}
		
		}
		
		
		for(int i = 0; i<15; i++) { //15번 반복을 해야한다 그렇지 않으면 에러 발생
			
			for(int k = 0; k<st1.length; k++) { //배열의 행만큼 반복
			
				if(st1[k][i]=='\0') continue; //배열 값이 비어있으면 반복문 넘기기
				
				sb.append(st1[k][i]);
			}
		}
		System.out.println(sb);
		
	}

}
