package �˰����͵�_2����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1672 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*	
	�Է�
	ö���� �� ���� n�� �ڸ� ���� k�� �������� �и��Ǿ� �Էµȴ�.(1<=k<=n<=50,000)	
	
	���
	ö���� ���� ��ȣ�� �� �ٿ� �ϳ��� ����Ѵ�. ���� ���� ��ȣ�� F-9999�� �Ѵ� ��� ����ȣ �ʰ� �������� ����Ѵ�.
	
	�Է� ����
	19 6
	��� ����
	F-0001
	F-0002
	F-0003
*/
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	
	int res = n/k;
	
	for (int i = 1; i <= res; i++) {
		if(res>9999) {
			System.out.println("��ȣ �ʰ� ����");
			break;
		}
		
		System.out.printf("F-%04d\n",i);
	}
	
		
	}

}
