package project2;

import java.util.Scanner;

public class FstGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력
		Scanner sc = new Scanner(System.in);
		
		//학생수
		int data = sc.nextInt();
		String[][] student = new String[data][4];
		// [E] 삭제
		sc.nextLine();

		// 데이터를 2차원 배열로 set
		for (int i = 0; i < data; i++) {
			String rowIndex = sc.nextLine();
			String[] colIndex = rowIndex.split(" ");
			for (int k = 0; k < 4; k++) {
				student[i][k] = colIndex[k];
			}
		}

		// 1등한 학생의 이름 찾기 (최댓값 찾기)
		int row = findMax(student);
		String first = student[row][0];
		
		// 2과목의 등수 구하기
		int col=2;
		int secondScore = setRank(student, row, col);
		
		// 3과목의 등수 구하기
		col=3;
		int thirdScore = setRank(student, row, col);
		
		//출력
		System.out.print(first + " ");
		System.out.print(secondScore + " ");
		System.out.print(thirdScore  + " ");
	}

	private static int setRank(String[][] student, int row, int col) {
		// TODO Auto-generated method stub
		int [] score = new int[student.length];
		int [] rank = new int[student.length];
		
		for(int i=0; i<rank.length; i++) {
			rank[i] = 1;
		}
		
		for(int i=0; i<score.length;i++) {
			score[i] = Integer.parseInt(student[i][col]);
		}
		
		for(int i=0; i<score.length; i++) {
			for(int k=0; k<score.length; k++) {
				if(score[i] < score[k]) {
					rank[i] += 1;
				}
			}
		}
		return rank[row];
	}

	private static int findMax(String[][] student) {
		// TODO Auto-generated method stub
		int max=0;
		int row=0;

		for(int i=0; i< student.length;i++) {
			if (Integer.parseInt(student[i][1]) > max) {
				max = Integer.parseInt(student[i][1]);
				row = i;
			}
		}
		return row;
	}

}
