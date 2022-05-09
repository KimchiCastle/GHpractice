package 알고리즘스터디_4주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_2309난쟁이 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 
아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
	
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] nan = new int[9];

		int nan_hap = 0;

		for(int i=0; i<nan.length; i++) {
			nan[i] = Integer.parseInt(br.readLine());
			nan_hap += nan[i];
		}
		//가짜를 찾기 위한 변수
		int nan_liar = nan_hap - 100;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<nan.length; i++) {
			//못찾았으면 한칸씩 늘려서
			for(int k=i+1; k<nan.length; k++) {
				
				if(nan[i] + nan[k] == nan_liar) {
					//합쳐서 뺀값을 찾았으면 그둘 0으로 바꾸고
					nan[i] = 0;
					nan[k] = 0;
					//소팅
					Arrays.sort(nan);
					//소팅후 0,1 제외후 append
					for(int x=2; x<nan.length; x++) {
						sb.append(nan[x]).append("\n");
					}// 3번째 for end;
					// 조건을 다 찾았을 경우 리턴해서 메인메소드를 끝내버려야함.
					// 리턴 전에 답 출력하고 리턴!!
					System.out.println(sb);
					//메인메소드 자체를 종료
					return;
				}// 비교문 end;
				
				
			}// 두번째 for-end
		} // 첫번째 for-end
		
		
		
		
		
		
	}

}
