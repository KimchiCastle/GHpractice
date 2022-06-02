package 알고리즘스터디_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_2217_로프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 2 10 15
		 * 
		 * 출력 20
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int [] arr = new int[N];
		
		StringTokenizer st;
		
		for(int i=0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int max =0;
       
		for(int i= arr.length-1; i>=0; i--) {
			
			arr[i] = arr[i] * (N-i);
			if(max<arr[i]) max = arr[i];
			
		}
		List<Integer> list = new ArrayList<Integer>();
		
		
		Collections.sort(null);
		
		
		
        System.out.println(max);
	}


}
