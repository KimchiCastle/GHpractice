package 알고리즘스터디_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1672 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*	
	입력
	철근의 총 길이 n과 자를 길이 k가 공백으로 분리되어 입력된다.(1<=k<=n<=50,000)	
	
	출력
	철근의 자재 번호를 한 줄에 하나씩 출력한다. 만약 자재 번호가 F-9999를 넘는 경우 “번호 초과 오류”를 출력한다.
	
	입력 예시
	19 6
	출력 예시
	F-0001
	F-0002
	F-0003
*/
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	
	int res = n/k;
	
	for (int i = 1; i <= res; i++) {
		if(res>9999) {
			System.out.println("번호 초과 오류");
			break;
		}
		
		System.out.printf("F-%04d\n",i);
	}
	
		
	}

}
