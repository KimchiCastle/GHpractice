package MyMain;

public class _05_���ڿ��ڷ��� {

	/*
	
		���ڿ��ڷ��� : String
		 ���ڿ� : 1�� �̻��� ������ ������ ��
		 		  "ABC" -> 'A''B''C'
		
		���     : "ABC" <- �ֵ���ǥ
		��¼��� : %s 
				   %.ms <- ���ڼ��� m���� ���
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "ȫ�浿";
		String addr = "����� ������ ������ 123"; // char�� �����ϸ� �ȵ�
				
		System.out.printf("�̸� : %s\n", name);
		System.out.printf("�ּ� : %s\n", addr);
		
		System.out.printf("�� : %.3s\n", addr);
		System.out.printf("�ñ� : %.7s\n", addr);
		
		
	}

}
