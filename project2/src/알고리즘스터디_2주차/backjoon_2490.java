package �˰����͵�_2����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2490 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
	
		 * ��� ù° �ٺ��� ��° �ٱ��� �� �ٿ� �ϳ��� ����� ���� A, ���� B, ���� C, ���� D, ��� E�� ����Ѵ�.
		 * 
		 * ���� �Է�
		 * 0 1 0 1
		 * 1 1 1 0
		 * 0 0 1 1
		 * ���� ��� 
		 * B
		 * A
		 * B
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] �� = new String[3];

		for (int i = 0; i < ��.length; i++) {
			��[i] = br.readLine();
		}

		// int count_zero = 0;
		

		for (int i = 0; i < ��.length; i++) {
			int count_one = 0;
			for (int k = 0; k < ��[i].length(); k++) {

				if (��[i].charAt(k) == '1') {
					count_one++;
				}
			} // k for end
			
			switch (count_one) {
			case 0://�� 
				System.out.println("D");
				break;
			case 1://��
				System.out.println("C");
				break;
			case 2://�� 
				System.out.println("B"); 
				break;
			case 3://��
				System.out.println("A");
				break;
			default://�� 
				System.out.println("E");
				break;

			}
		}
	}
}
