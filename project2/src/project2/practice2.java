package project2;


import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���� ������ �Էµȴ�.
		 * 
		 * �� ���忡�� love�� �� �� �������� ����Ͻÿ�.
		 * 
		 * �Է� ���� �� ������ �Էµȴ�.(���� ����, �ִ� ���ڼ� 100)
		 * 
		 * ��� �ҹ��� love�� �� �� �������� ����Ѵ�.
		 * 
		 * �Է� ���� love lovely
		 * 
		 * ��� ���� 2
		 * 
		 * 
		 * 
		 * 
		 */
		Scanner scan = new Scanner(System.in);

		String a = scan.nextLine();

		// love ī��Ʈ Ƚ��
		int count = 0;

		// ���ڿ����̸�ŭ �ݺ�
		for (int i = 0; i < a.length(); i++) {

		
			if (a.charAt(i) == 'l' && a.charAt(i + 1) == 'o' && a.charAt(i + 2) == 'v' && a.charAt(i + 3) == 'e') { // l ã��

				 
							count++;

				}

		
		}
		System.out.println(count);

	}

}
