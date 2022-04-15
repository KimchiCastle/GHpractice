package project2;

import java.util.Scanner;

public class FstGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Է�
		Scanner sc = new Scanner(System.in);
		
		//�л���
		int data = sc.nextInt();
		String[][] student = new String[data][4];
		// [E] ����
		sc.nextLine();

		// �����͸� 2���� �迭�� set
		for (int i = 0; i < data; i++) {
			String rowIndex = sc.nextLine();
			String[] colIndex = rowIndex.split(" ");
			for (int k = 0; k < 4; k++) {
				student[i][k] = colIndex[k];
			}
		}

		// 1���� �л��� �̸� ã�� (�ִ� ã��)
		int row = findMax(student);
		String first = student[row][0];
		
		// 2������ ��� ���ϱ�
		int col=2;
		int secondScore = setRank(student, row, col);
		
		// 3������ ��� ���ϱ�
		col=3;
		int thirdScore = setRank(student, row, col);
		
		//���
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
