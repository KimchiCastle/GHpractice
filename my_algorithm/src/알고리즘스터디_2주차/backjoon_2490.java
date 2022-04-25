package 알고리즘스터디_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2490 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
	
		 * 출력 첫째 줄부터 셋째 줄까지 한 줄에 하나씩 결과를 도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E로 출력한다.
		 * 
		 * 예제 입력
		 * 0 1 0 1
		 * 1 1 1 0
		 * 0 0 1 1
		 * 예제 출력 
		 * B
		 * A
		 * B
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] 윷 = new String[3];

		for (int i = 0; i < 윷.length; i++) {
			윷[i] = br.readLine();
		}

		// int count_zero = 0;
		

		for (int i = 0; i < 윷.length; i++) {
			int count_one = 0;
			for (int k = 0; k < 윷[i].length(); k++) {

				if (윷[i].charAt(k) == '1') {
					count_one++;
				}
			} // k for end
			
			switch (count_one) {
			case 0://윷 
				System.out.println("D");
				break;
			case 1://걸
				System.out.println("C");
				break;
			case 2://개 
				System.out.println("B"); 
				break;
			case 3://도
				System.out.println("A");
				break;
			default://모 
				System.out.println("E");
				break;

			}
		}
	}
}
