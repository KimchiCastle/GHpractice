package MyMain;

import java.util.Scanner;

public class _Q2 {
	
	/*
		���� �������� �Է� �޾Ƽ�
		�� �ѷ���
		�� ������ ���ϴ� ���α׷��� �ۼ�
		����� �Ҽ������� 1�ڸ�����
	*/
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double pi = Math.PI; // ����
		double r; // ������
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�������� �Է��ϼ���. : ");
		r = scan.nextDouble();
		
		double circle_len = 2 * pi * r; // �ѷ�
		
		double circle_area = r * r * pi; // ����
		
		System.out.printf("�Է� �Ͻ� ������[%.1f]�� ���� �ѷ��� [%.1f] �Դϴ�.\n",
							r,circle_len
				);
		System.out.printf("�Է� �Ͻ� ������[%.1f]�� ���� ������ [%.1f] �Դϴ�.\n", 
							r,circle_area
				);
		
		scan.close();
	}

}
