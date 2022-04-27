package �˰����͵�_2����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_1931 {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
	ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. 
	��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� 
	�̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. 
	���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

	���
	ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
*/	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Time mytime;
		
		List<Time> list = new ArrayList<Time>();
		
		//�迭�� ���� ����
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start_time = Integer.parseInt(st.nextToken());
			int end_time = Integer.parseInt(st.nextToken());
			
			mytime = new Time(start_time , end_time);
			
			list.add(mytime);
			
		}
		
		Collections.sort(list);


		
	}

	static class Time implements Comparable {

		int start_time;
		int end_time;
		
		public Time(int s_time, int e_time) {
			// TODO Auto-generated constructor stub
			this.start_time = s_time;
			this.end_time   = e_time;
		}
		
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return this.end_time - ((Time)o).end_time;
		}
		
		public String toString(){
			return String.format("%s %s",start_time, end_time);
		}

		public int getEnd_time() {
			return end_time;
		}
				
		
	}
	
	
}
