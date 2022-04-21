package 꼭_숙지할_알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10798_세로읽기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
	}
}
