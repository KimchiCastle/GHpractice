package �˰����͵�;

import java.util.Scanner;

public class code_1413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String ���� = scan.nextLine();
		
		int len = ����.length()-1; // ���⼭ -1�� ��������� OutOfBoundException �߻�
		
		for(int i=0; i<����.length(); i++) {
			
			System.out.print(����.charAt(i+len));
			len = len - 2;
			
		}
		
		scan.close();
	}

}
