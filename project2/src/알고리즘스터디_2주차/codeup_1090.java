package �˰����͵�_2����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1090 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//����� ���������� int���� �ִ�
		long a = Integer.parseInt(st.nextToken());
		
		int r = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(st.nextToken());
	
		
		
		
		for (int i = 0; i < n-1; i++) {
			
			a = a * r;
			
		}
		
		System.out.println(a);
		
		
	}

}
