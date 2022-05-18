package 알고리즘스터디_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class backjoon_2217 {

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

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {

			list.add(Integer.parseInt(br.readLine()));

		}

		Collections.sort(list, Collections.reverseOrder());

		int res = list.get(0);

		if (list.size() == 1) {
			System.out.println(res);
		} else {

			res += (list.get(0) - list.get(1));

			System.out.println(res);
		}

	}

}
