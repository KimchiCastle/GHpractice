package mycodeup;

public class _backjoon_15596 {

	
		// TODO Auto-generated method stub
		/*
		 * Java: long sum(int[] a); (Ŭ���� �̸�: Test) 
		 * a: ���� ���ؾ� �ϴ� ���� n���� ����Ǿ� �ִ� �迭 
		 * (0 �� a[i] �� 1,000,000, 1 �� n �� 3,000,000) 
		 * ���ϰ�: a�� ���ԵǾ� �ִ� ���� n���� ��
		 * 
		 */
	

	private static long sum(int[] a) {
		// TODO Auto-generated method stub
		long b = 0;
		for (int i = 0; i < a.length; i++) {
			b = b + a[i];
		}
		
		return b;
	}

}
