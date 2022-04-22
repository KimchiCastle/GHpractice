package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_10798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
	�� �ټ����� �Է��� �־�����. �� �ٿ��� �ּ� 1��, 
	�ִ� 15���� ���ڵ��� ��ĭ ���� �������� �־�����. 
	�־����� ���ڴ� ���� �빮�� ��A������ ��Z��, ���� �ҹ��� ��a������ ��z��, ���� ��0������ ��9�� �� �ϳ��̴�. 
	�� ���� ���۰� �������� ��ĭ�� ����.
���
�����̰� ���η� ���� ������� ���ڵ��� ����Ѵ�. �̶�, ���ڵ��� ���� ���� �����ؼ� ����Ѵ�. 
	���� �Է� 1 
ABCDE
abcde
01234
FGHIJ
fghij
	
	���� ��� 1 
	Aa0FfBb1GgCc2HhDd3IiEe4Jj
	
	���� �Է� 2 
AABCDD
afzz
09121
a8EWg6
P5h3kx
	
	���� ��� 2 
	Aa0aPAf985Bz1EhCz2W3D1gkD6x
		
*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder [] sb = new StringBuilder[15];
		String s = new String();

		for(int i=0; i<15; i++) {
			sb[i] = new StringBuilder();
		}
		
		for(int i=0; i<5; i++) {
				s= br.readLine();
				for(int k=0; k<s.length(); k++) {
					sb[k].append(s.charAt(k));
				}
		}
		
		for(int k=0; k<15; k++) {
			System.out.print(sb[k]);
		}
		
		*/
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		//�Է°��� �־��� �迭����
		char [][] st1 = new char [5][15];
		
		
		//�Է°� ������ �迭 ����
		for(int i = 0 ; i<5; i++) {	// �ุŭ �ݺ�
			String info = br.readLine();
			
			for(int k = 0; k<info.length(); k++) { // ��Ʈ�� ���ڿ� ���̸�ŭ �ݺ�
			
				st1[i][k] = info.charAt(k); // ���ڿ��� 1���ھ�ĳ���������� �߶󳽴�.
			}
		
		}
		
		
		for(int i = 0; i<15; i++) { //15�� �ݺ��� �ؾ��Ѵ� �׷��� ������ ���� �߻�
			
			for(int k = 0; k<st1.length; k++) { //�迭�� �ุŭ �ݺ�
			
				if(st1[k][i]=='\0') continue; //�迭 ���� ��������� �ݺ��� �ѱ��
				
				sb.append(st1[k][i]);
			}
		}
		System.out.println(sb);
		
	}

}
