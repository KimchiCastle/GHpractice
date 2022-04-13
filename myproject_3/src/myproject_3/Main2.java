package myproject_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// main 문제를 BufferedReder로 받아 풀어보기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in_put = br.readLine(); //

		StringTokenizer st = new StringTokenizer(in_put);

		int time = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		for (int i = time; i < 90; i += 5) {
			goal++;
		}

		System.out.print(goal);

	}

}
