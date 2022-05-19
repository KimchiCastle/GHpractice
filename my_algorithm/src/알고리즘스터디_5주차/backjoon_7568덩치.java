package 알고리즘스터디_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjoon_7568덩치 {

	static class  Dungch {
		
		int height;
		int weight;
		int rank = 1;
		int idx = 0;
		
		
		public Dungch(int h, int w, int i) {
			// TODO Auto-generated constructor stub
			this.height = h;
			this.weight = w;
			this.idx = i;
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Dungch [] arr = new Dungch[N];
		
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
					
			Dungch dc = new Dungch(Integer.parseInt(st.nextToken() ), Integer.parseInt(st.nextToken()), i+1);
			
			
			arr[i] = dc;
			
		}
		
		Arrays.sort(arr, new Comparator<Dungch>() {
			
			@Override
			public int compare(Dungch o1, Dungch o2) {
				// TODO Auto-generated method stub
				
				if(o1.weight>o2.weight) {
					return 1;
				}else 
					return o1.height-o2.height;
				
			}
		});
		
		for(Dungch a : arr) {
			System.out.printf("%d kg %d cm %d \n",a.height , a.weight, a.idx);
		}
			
		
		
		//순위매기기
		for(int i=0; i<N ;i++) {
			int w = arr[i].weight;
			int h = arr[i].height;
			int count = 0;
			for(int k=i+1 ; k<N; k++) {
				if(w < arr[k].weight && h < arr[k].height) {
					count++;
				}
			}
			arr[i].rank += count;
		}
		
		
	
		Arrays.sort(arr, new Comparator<Dungch>() {
		
			@Override
			public int compare(Dungch o1, Dungch o2) {
				// TODO Auto-generated method stub
				return o1.idx-o2.idx;
			}
		
		});
	
		
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i].rank).append( i==arr.length-1 ? "" : " " );
		}
		
		
		System.out.println(sb);
		
		
	}

}
