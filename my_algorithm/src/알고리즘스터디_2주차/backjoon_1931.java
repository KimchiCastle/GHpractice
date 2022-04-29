package �˰����͵�_2����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
		
		Time [] mytime = new Time[N];
		
		StringTokenizer st;
		
		for (int i = 0; i < mytime.length; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
						
			mytime[i] = new Time( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
			
		
			
		}
		/*
		�����δ� ��ü���Ľ�, �͸�Ŭ������ ������ �ϴ� ���� �⸣��.
		Arrays.sort(mytime, new Comparator<Time>() {

			@Override
			public int compare(Time a1, Time a2) {
				// TODO Auto-generated method stub
				���Ľ� ���� ���ǵ��� �� ����ϰ� ���� �����ؾ� �Ѵ�.
				if(a1.end_time == a2.end_time) {
                    return a1.start_time - a2.start_time;
                }else {
                    return a1.end_time - a2.end_time;
                }
			}
		});
		
		*/
		
		Arrays.sort(mytime);
		
		//�̰� �� ��ü�� Ȯ���ϱ� ���ؼ� �ۼ��� �ڵ�
		for(Time t : mytime) {
			System.out.println(t.toString());
		}
		
		
		int count =0;
		
		//while�� �������� ������� ������
		//int i = 0;
		int k = 0;
		//int res = mytime[0].getEnd_time();
		
		
		
		
		int res = 0;
		
		
		//System.out.println(res);
		
		/* �ݺ�Ƚ���� �˰� �������� ������ �� for�� ������..
		while (true) {
			 
			k++
			
			if( res <= mytime[k].getstart_time() ) {
				
				res = mytime[k].getEnd_time();
				
				
				if(res == mytime[N-1].getEnd_time()) { // ������ �ð��̶� �񱳰��� ������..
					break;
				}
				
				count++;
				
			}
			k++;
			
			if(k == N-1) {
				break;
			}
		
			
		} // while end
		*/
		
		
		for (int i = 0; i < N; i++) {
			if( res <= mytime[i].getstart_time() ) {
				
				res = mytime[i].getEnd_time();
				
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}

	static class Time implements Comparable<Time>{ //���׸����� Ȱ������!!

		int start_time;
		int end_time;
		
		public Time(int s_time, int e_time) {
			// TODO Auto-generated constructor stub
			this.start_time = s_time;
			this.end_time   = e_time;
		}
		
		/* ���׸��� Ȱ�������� ����� �ٿ�ĳ���� ���ص� �ƴ�!!
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			//���⼭ ���۽ð��� ������쵵 ���� üũ ������Ѵ�!!!
			return this.end_time - ((Time)o).end_time;
        }  
		*/
		
		
		
		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			if(this.end_time == o.end_time) {
                    return this.start_time - o.start_time;
                }else {
                    return this.end_time - o.end_time;
                }	
		}
		
		
		
		public String toString(){
			return String.format("%s %s",start_time, end_time);
		}

		public int getEnd_time() {
			return end_time;
		}

		public int getstart_time() {
			return start_time;
		}

		
			
		
				
		
	}
	
	
}
