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
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		char [][] st1 = new char [5][15];
		
		
		for(int i = 0 ; i<5; i++) {
			String info = br.readLine();
			
			for(int k = 0; k<info.length(); k++) {
				st1[i][k] = info.charAt(k);
			}
			
			
		}
		
		for(int i = 0; i<15; i++) {
			for(int k = 0; k<st1.length; k++) {
				if(st1[k][i]=='\0') continue;
				 sb.append(st1[k][i]);
			}
		}
		System.out.println(sb);
	}

}
