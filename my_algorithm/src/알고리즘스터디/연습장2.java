package �˰����͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ������2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		String [] �Ѻ� = new String[64];
		
		for (int i = 0; i < �Ѻ�.length; i++) {
			�Ѻ�[i] = br.readLine();
			sb.append(�Ѻ�[i]).append('\n');
		}
		
		System.out.println(sb);
				
				
		//sb.append(�Ѻ�);
		
		//System.out.println(sb);
	
	}

}
