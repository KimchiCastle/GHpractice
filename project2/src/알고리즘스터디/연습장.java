package 알고리즘스터디;

import java.util.Scanner;

public class 연습장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String res = "13";
		
		res = res.substring(1,2);
		
		System.out.println(res);
		
		String [] num = new String[2];
		
		num[0] = "1";
		num[1] = "2";
		
		String plus = "";
		
		plus = num[0] + num[1];
		
		System.out.println(plus);
		*/
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		
		if (Integer.parseInt(n) < 10) {
			n =  "0" + n;
		}
		
		System.out.println(n);
	}

}
