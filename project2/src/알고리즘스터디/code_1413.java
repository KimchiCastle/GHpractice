package 알고리즘스터디;

import java.util.Scanner;

public class code_1413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String 문장 = scan.nextLine();
		
		int len = 문장.length()-1; // 여기서 -1을 안줘버리니 OutOfBoundException 발생
		
		for(int i=0; i<문장.length(); i++) {
			
			System.out.print(문장.charAt(i+len));
			len = len - 2;
			
		}
		
		scan.close();
	}

}
