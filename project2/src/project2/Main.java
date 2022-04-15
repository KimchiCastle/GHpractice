package project2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
세종이는 정보과학 선생님인 JH를 도와주기 위해 정보과학 성적처리 프로그램을 만들기로 했다.

JH 선생님은 특정 과목에서 1등한 학생이 다른 과목에서는 어떤 성적을 얻었는지 관심이 많다.

다음 조건을 만족하는 프로그램을 작성해 보자.

입력
첫째 줄에 데이터의 개수 n (3<=n<=100)

둘째 줄부터 n+1줄에 학생 이름과 3과목 점수들이 공백으로 구분되어 입력된다. (입력 예시 참고)

단 이름의 길이는 최대 10바이트 이내이다

출력
첫 번째 과목을 1등한 학생의 이름과 두 번째, 세 번째 과목의 석차를 공백으로 구분하여 출력한다.

단 첫 번째 과목의 1등은 1명이라고 가정한다.

입력 예시   
4
Jeon 95 80 100
Kim 59 85 75
Lee 90 100 75
Bae 100 82 80
		
출력예시
Bae 3 2		 
	
	*/		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		String [] name = new String[n];
		int	[] subject1 = new int[n];
		int [] subject2 = new int[n];
		int [] subject3 = new int[n];
		
		//인덱스값으로 모든걸 비교
		//int res_index = 0; //필요할줄 알고 선언했었는데 필요가 없었다.
		int first_index = 0;
		//int second_index = 0; 
		//int third_index = 0;	
		
		//정보 넣기
		for(int i=0; i<n; i++) {
			
			name[i] = scan.next();
			
			subject1[i] = scan.nextInt();
			subject2[i] = scan.nextInt();
			subject3[i] = scan.nextInt();

		}
		
		
		//1등구하기 여기서 구글링했다.. 2중for문을 써버려서 원하는 값이 안나왔다. for문 1번만 돌리면 됐었는데..
		int max = subject1[0]; // 위에서 선언했던 res_idex의 대체

		for (int i = 0; i < n; i++) {
			if (subject1[i] > max) {
				
				max = subject1[i];
				
				first_index = i;
			}
		}
		
		//위에 선언했던 second_index, third_idex 대체
		int count1 = 1; 
		int count2 = 1;
		
		//1등의 인덱스를 이용해 나머지과목 등수 구하기
		//카운트가 1등일때는 올라가지 않음
		for (int i = 0; i < n; i++) {
			if (subject2[first_index] < subject2[i]) {
				count1++;
			}
			if (subject3[first_index] < subject3[i]) {
				count2++;
			}
		}

		
		
		
		//System.out.println(first_index);
		/*
		System.out.print(name[first_index]);
		System.out.print(" "+count1);
		System.out.print(" "+count2);
		*/
		
		System.out.printf("%s %d %d",name[first_index], count1, count2);
		
		/*
		//배열에 값이 제대로 들어갔는지 값 출력해보기
		for(int i= 0; i<n; i++) {
			System.out.print("[ ");
			System.out.print(name[i]+", ");
			System.out.print(subject1[i]+", ");
			System.out.print(subject2[i]+", ");
			System.out.print(subject3[i]+", ");
			System.out.print("]");
			
			System.out.println();//줄바꿈
			
		}
		*/
		
		
	}

}
