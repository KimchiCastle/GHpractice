package MyMain;

import java.util.Scanner;

public class _Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//�̸� �ּ������� ����
		String name;
		String addr;

		System.out.print("�̸� : ");
		//name = scan.next(); // ���ڿ� �Է¹ޱ� (next�� �Է¹����� ������������ �Է�)
		name = scan.nextLine(); // ���� �����ؼ� �Է¹���
		
		
		System.out.print("�ּ� : ");
		addr = scan.nextLine();
		
		
		System.out.println("---[�Է¹��� ����]---");
		System.out.printf("�̸� : %s\n", name);
		System.out.printf("�ּ� : %s\n", addr);
		
		
		
		scan.close();
	}

}
