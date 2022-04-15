package project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code_1425 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
	A중학교에 첫 발령을 받은 B교사는 1학년 1반 담임을 맡게 되었다.

기대를 안고 첫 출근한 B교사는 너무 설렌 나머지 학생들이 등교하기도 전에 교실에 가서 학생들이 오기만을 기다리고 있었다.

그리고 제일 먼저 무슨 일을 해야 될지 생각하던 중 학생들 자리 배치를 우선적으로 해야겠다고 생각했다.

여러 가지 자리 배치 방법을 고려하다가 학생들의 키가 작은 순서대로 앞에서부터 앉히는 것이 제일 좋은 방법이라고 결정하게 되었다.

예를 들어, 160, 165, 164, 165, 150, 165, 168, 145, 170의 학생들 키가 주어지고 한 줄에 6명씩 앉는다면 다음과 같이 앉으면 될 것이다.

145	150	160	164	165	165
165	168	170			
왼쪽 위부터 차례대로 키 순서대로 앉으며 한 줄이 다 찼을 경우 다음 줄로 넘어간다. 다음 줄도 마찬가지로 왼쪽부터 채운다.

이와 같이 학생의 키순서대로 자리를 배치하는 프로그램을 작성하시오.

입력
1. 첫 번째 줄에 학생 수(N)와 한줄에 앉을 수 있는 자리수(C)가 자연수로 주어진다. 단, (1≤N≤99), (1≤C≤10)

2. 둘째 줄에는 N명의 학생 키들이 공백으로 구분되어 입력된다.

출력
학생들의 자리 배치 결과를 공백으로 분리하여 출력한다.

(표현오류 조심 : 각 행의 마지막에 공백을 한 칸 넣어야 됨.)

입력 예시   
9 6
160 165 164 165 150 165 168 145 170 

출력 예시
145 150 160 164 165 165 
165 168 170 	
*/		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String in_put = br.readLine();
		
		String stu_ki = br.readLine();
		
		
		String [] info = in_put.split(" ");
		String [] stu_info = stu_ki.split(" ");
		
		int a = Integer.parseInt(info[0]);
		int b = Integer.parseInt(info[1]);
		
	
		
		List<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 0; i<a; i++) {
			ar.add(Integer.parseInt(stu_info[i]));
		}
		
		Collections.sort(ar);
		
		
		//System.out.printf("%d %d\n",a, b);
		/*
		for(int i = 0; i<a; i++) {
			System.out.printf("%d ",ar.get(i));
			if( i%b==0 && i!=0 ) {
				System.out.println();
			}
			
			
		}
		*/
		
		//상황에 따라 조건문 출력문 순서 확인 잘하기!!
		for(int i = 0; i<a; i++) {
			System.out.printf("%d ",ar.get(i));
			if( i%b==0 && i!=0) {
				System.out.println();
			}
			
			
		}
		
		
		//System.out.println(Arrays.toString(stu_info));
		
	}

}
