package 알고리즘스터디_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_1448삼각형 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
3
1
2
3
---
-1

3
1
2
2
5

*/		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		//Integer [] tri = new Integer[N];
		int [] tri = new int[N];
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		//배열에 값 넣어주기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			tri[i] = Integer.parseInt(st.nextToken());

		}
		
		
		select(tri);
		
		//Arrays는 래퍼클래스만 정렬기준을 잡아줄 수 있다.
		//Arrays.sort(tri, Collections.reverseOrder());
		

		/*
		3 = 1
		4 = 2
		5 = 3
		6 = 4
		7 = 5
		...
		N = N-2;
		 */
		
		//삼각형 만들기
		for(int i=0; i<N-2; i++) {
			int res=0;
			
			//만약 삼각형을 못만들 경우...
			if(tri[i]>=tri[i+1]+tri[i+2]) {
				res = -1; 
				list.add(res);
				continue;
			}
			
			//3번 반복해서 삼각형 합 구하기
			for(int k = i; k<3+i; k++) {
				res += tri[k];	
			}	
			//구한 합을 ArrayList에 넣기
			list.add(res);
			
			//여기서 생각해보면... 최대값을 구한것아닌가?? 반복문 나가도 되지않나??
			//최대값 찾았으면 break;
			break;
		}
		
		/*
		for(int a : list) {
			System.out.println(a);
		}
		*/
		
		
		
		//컬랙션 메소드에 있는 내림차순 메소드
		Collections.sort(list, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		

		sb.append(list.get(0));
		
		System.out.println(sb);

	}

	
	
	
	//직접 구현한 내림차순 선택정렬
	public static void select(int[] tri) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<tri.length-1; i++) {
			for(int k=i+1; k<tri.length; k++) {
				
				if(tri[i]<tri[k]) {
					swap(tri,i,k);
				}
				
				
			}
		}
		
	}

	public static void swap(int[] tri, int i, int k) {
		// TODO Auto-generated method stub
		
		int save = tri[i];
		tri[i] = tri[k];
		tri[k] = save;
	}

}
