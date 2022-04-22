package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _backjoon_2908 {

	public static void main(String[] args) throws IOException {
		/*
		 * ������� ���� ����� ������ ���� ���Ѵ�. 
		 * 
		 * ����� ���ڸ� �дµ� ������ �ִ�. 
		 * 
		 * �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. 
		 * 
		 * ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
		 * 
		 * ����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�.
		 * 
		 * ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.
		 * 
		 * �� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * 
		 * �Է� ù° �ٿ� ����̰� ĥ�ǿ� ���� �� �� A�� B�� �־�����. �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.
		 * 
		 * ��� ù° �ٿ� ����� ����� ����Ѵ�.
		 * 
		 * ���� �Է� 1 734 893 ���� ��� 1 437
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine(); //�Է� �� ����
		
		//�Է°� �ڸ���
		StringTokenizer st = new StringTokenizer(input);
		
		//�ڸ� ���� ���� ������ a b�� �־���
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		//������ a b �� �ְ�
		sb.append(a).append(" ").append(b);
		//���� �޼ҵ��� �ϳ��� �������� ����� ��������
		//toString�޼ҵ带 �̿��� String������ ����
		String a1 = sb.reverse().toString();
		
		//�װ��� �ٽ� ���ø�
		st = new StringTokenizer(a1);
		
		//���ø� �� ���� ���� ����
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		//���׿����� ��� a2 < b2   true false
		System.out.println(a2 < b2 ? b2 : a2);
		
	}

}
