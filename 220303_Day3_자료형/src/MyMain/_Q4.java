package MyMain;

import java.util.Scanner;

public class _Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� ������ �Է��ؼ� ����ϴ� ���α׷��� �ۼ� �ϼ���
		//�Է� = �̸�/����/�ּ�/Ű/������
		
		String name;
		int age;
		String addr;
		double len;
		double wgt;
		
		Scanner scan = new Scanner(System.in);

		System.out.print("�̸� : ");
		name = scan.nextLine(); 	// ȫ�浿(E) �Է±����� ���� �� ������
		System.out.print("���� : ");
		age = scan.nextInt();		// ����
		
		//Ű������۳��� ���͸� �����ؾ���
		scan.nextLine(); //�׷��� scan(��ü)�� �ִ� nextLine(�޼ҵ�)�� �ٽ��ѹ� �����
		
		System.out.print("�ּ� : ");
		addr = scan.nextLine(); 
		System.out.print("Ű : ");
		len = scan.nextDouble();
		System.out.print("������ : ");
		wgt = scan.nextDouble(); // ���ۿ� �Է� �Ǿ��ִ�(E)�� ��ŵ
		
		System.out.println("---[�Է��� ����]---");
		System.out.printf("�̸� : %s\n ���� : %d ��\n �ּ� : %s\n Ű : %.1f cm\n ������ : %.1f kg\n"
								,name,		 age,			 addr,			len,			wgt);
	
		scan.close();
	}
	
}
