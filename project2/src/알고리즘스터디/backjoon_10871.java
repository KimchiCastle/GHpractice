package �˰����͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class backjoon_10871 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//���� �޾ƿ� ���۵帮�� ����
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 

		//st�� �޾ƿ� ���� " "�� �������� �� �ڸ���
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//�ڸ� ���� ������� N�� X�� �ִ´�.
		int n = Integer.parseInt(st.nextToken()); // ���� ũ��
		int x = Integer.parseInt(st.nextToken()); // ���� ����
		
		//���� ����ϱ� ���� StringBuilder ����
		StringBuilder sb = new StringBuilder();
		
		//st�� �ٽ��ѹ� �����ؼ� br�� 2��°�� �ڸ���.
		//��� ������ �Է°��� �ڸ���??�ϰ� ����ϴٰ� �ᱹ ���۸��ߴ�.
		st = new StringTokenizer(br.readLine()); // �̺κ� ������ �߿��Ѻκ�!
		
		
		for (int i = 0; i < n; i++) { // ������ŭ �ݺ�			
			int v = Integer.parseInt(st.nextToken()); // v������ ��ũ�������� �ڸ� ���� 1���� �ִ´�.
				if(v < x){ // �ڸ� ���� �ռ� ������ x�� ��
				sb.append(v).append(' '); // x���� �������� ������ ���ҵ��Ѵ�. ���鵵 �Բ� 
			}
					
		}
		
		System.out.println(sb); // ������ ������ִ� ���� ���
	}

}
