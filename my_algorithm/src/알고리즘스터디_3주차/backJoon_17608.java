package �˰����͵�_3����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class backJoon_17608 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

/*		
6
6
9
7
6
4
6
���� ��� 1 
3

5
5
4
3
2
1
���� ��� 2 
5

*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] stick = new int[N];
		
		for (int i = 0; i < stick.length; i++) {
			stick[i] = Integer.parseInt(br.readLine());
		}
		
		
		int count = 0;
		
		int res = 0;
		
		
		for (int i = N-1; i>=0; i--) {
				
			if(stick[i]>res) {
				res= stick[i];
				count++;
			}
		}
		//System.out.println(Arrays.toString(stick));
		System.out.println(count);
		
		
	}

}
