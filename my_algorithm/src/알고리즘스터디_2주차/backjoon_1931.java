package 알고리즘스터디_2주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjoon_1931 {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
	첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
	둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 
	이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
	시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

	출력
	첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
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
		앞으로는 객체정렬시, 익명클래스로 재정의 하는 습관 기르자.
		Arrays.sort(mytime, new Comparator<Time>() {

			@Override
			public int compare(Time a1, Time a2) {
				// TODO Auto-generated method stub
				정렬시 여러 조건들을 다 고려하고 전부 구현해야 한다.
				if(a1.end_time == a2.end_time) {
                    return a1.start_time - a2.start_time;
                }else {
                    return a1.end_time - a2.end_time;
                }
			}
		});
		
		*/
		
		Arrays.sort(mytime);
		
		//이건 내 객체값 확인하기 위해서 작성한 코딩
		for(Time t : mytime) {
			System.out.println(t.toString());
		}
		
		
		int count =0;
		
		//while문 돌리려고 만들었던 변수들
		//int i = 0;
		int k = 0;
		//int res = mytime[0].getEnd_time();
		
		
		
		
		int res = 0;
		
		
		//System.out.println(res);
		
		/* 반복횟수를 알고 있을때는 무조건 걍 for문 돌리자..
		while (true) {
			 
			k++
			
			if( res <= mytime[k].getstart_time() ) {
				
				res = mytime[k].getEnd_time();
				
				
				if(res == mytime[N-1].getEnd_time()) { // 마지막 시간이랑 비교값이 같으면..
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

	static class Time implements Comparable<Time>{ //제네릭스를 활용하자!!

		int start_time;
		int end_time;
		
		public Time(int s_time, int e_time) {
			// TODO Auto-generated constructor stub
			this.start_time = s_time;
			this.end_time   = e_time;
		}
		
		/* 제네릭스 활용했으면 힘들게 다운캐스팅 안해도 됐다!!
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			//여기서 시작시간이 같을경우도 같이 체크 해줘야한다!!!
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
