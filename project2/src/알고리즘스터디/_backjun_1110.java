package �˰����͵�;

import java.util.Scanner;

public class _backjun_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�. ���� �־��� ���� 10���� �۴ٸ� �տ� 0��
		 * �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�. �� ����, �־��� ���� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ�
		 * ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�. ���� ���� ����.
		 * 
		 * 26���� �����Ѵ�. 2+6 = 8�̴�. ���ο� ���� 68�̴�. 6+8 = 14�̴�. ���ο� ���� 84�̴�. 8+4 = 12�̴�. ���ο�
		 * ���� 42�̴�. 4+2 = 6�̴�. ���ο� ���� 26�̴�.
		 * 
		 * ���� ���� 4������ ���� ���� ���ƿ� �� �ִ�. ���� 26�� ����Ŭ�� ���̴� 4�̴�.
		 * 
		 * N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * 
		 * �Է� ù° �ٿ� N�� �־�����. N�� 0���� ũ�ų� ����, 99���� �۰ų� ���� �����̴�.
		 * 
		 * ��� ù° �ٿ� N�� ����Ŭ ���̸� ����Ѵ�.
		 * 
		 */
		Scanner sc = new Scanner(System.in);

		String n = sc.next();

		String x = n; //���� ����

		String plus = "111"; //����� ���ϱ�

		String res = ""; // �迭�������

		int dap; // ���� ���ϱ�

		int count = 0; // ����

		String[] num = new String[2];
		
		//�Է°��� 10�����϶�
		if (Integer.parseInt(n) < 10) {
			n =  "0" + n;
		}

		//�ݺ��� ���� �� ���ڿ� ���ø�
		for (int i = 0; i < num.length; i++) {
			num[i] = n.substring(i, i + 1);
			//System.out.print(num[i]);
		
		}

		while (Integer.parseInt(x) == (Integer.parseInt(plus))  != true ) { // �Է��� ����� �ٸ��� ����ض�
			
			count++;
		
			
			dap = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);

			res = String.valueOf(dap);

			if (/*Integer.parseInt(res)*/ dap >= 10) {
				res = res.substring(1, 2);
				num[0] = num[1];
				num[1] = res;

				plus = num[0] + num[1];

			} else {
				num[0] = num[1];
				num[1] = res;

				plus = num[0] + num[1];
			}
			
			//���ڿ� ���ø�
			for (int i = 0; i < num.length; i++) {
				num[i] = plus.substring(i, i + 1);
				//System.out.print(num[i]);
			}
			System.out.println(plus);
			
		}

		System.out.println(count);
	}

}
