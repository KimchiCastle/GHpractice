package MyMain;

//�ش�Ŭ������ ��ġ�� �˷��ش�
import java.util.Scanner;

public class _Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int width = 20;
		int height= 30;
		
		//���� �Է� �޾Ƽ� ó���ؾ���
		//1.Ű����κ��� �Է¹޴� ��ü ����
		//System.in  : �Է°�ü
		//System.out : ��°�ü
		Scanner scan = new Scanner(System.in);
		//�ĺ��� 
		
		System.out.print("����(��):");
		width = scan.nextInt();// Ű����κ��� �Է¹��� ���� int������ ��������
		
		
		System.out.print("����(��):");
		height = scan.nextInt();
		
		
		//�������
		int area = width * height;
		
		System.out.printf("����:%d[��] ����:%d[��]�� �簢���� ������ : %d[��]\n",
							width, 		height, 				area
				);
	
		scan.close();

	}

}
