package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_10814 {
	
	static int n_user; //회원수
	
	static BufferedReader br;
	
	static List<My_info> array;
	
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		br = new BufferedReader( new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));   
		
		
		String n = br.readLine();
		
		 n_user = Integer.parseInt(n); // 버퍼에서 받아온 n을 int형병환
		
		
		array = new ArrayList<My_info>(); //ArrayList 선언
		
		Array_in(); // ArrayList 안에 객체 넣기
		
		Collections.sort(array);
		
		Array_wirte();
		
	}


	private static void Array_wirte() throws IOException {
		// TODO Auto-generated method stub
		for(My_info ar : array) {
			bw.write(ar.toString());
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}


	private static void Array_in() throws IOException {
		// TODO Auto-generated method stub
		
		//앞서 입력된 n_uer 만큼 반복
		for (int i = 0; i < n_user; i++) {

			String info = br.readLine(); // 버퍼로 정보 입력

			StringTokenizer st = new StringTokenizer(info); // 입력받은 info를 공백단위로 split

			int age = Integer.parseInt(st.nextToken()); // Tokenizer로 자른 String을 객체에 넣을 age로 변환
			String name = st.nextToken(); // String 은 그대로 문자열 사용

			 // ArrayList로 만들어진 배열 array에 add(내가만든 My_info객체 생성후 정보 삽입)
			array.add(new My_info(age, name)); 
		}
	}

	
	// 사용자정의객체				정렬을 위해 Comparable 구현상속
	static class  My_info implements Comparable {

		int age;
		String name;
		
		public My_info(int age, String name) { // 생성자 메소드
			this.age = age;
			this.name = name;
		}
		//Comparable 내의 메소드 재정의 정렬을 위한 return값
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			//				Object타입이기때문에 다운캐스팅 해야함
			//this.age가 더크면 양수 같으면 0 비교할age가 더크면 음수
					//내 나이	비교할 객체의 나이
			return this.age - ((My_info)o).age; 
		}
		
		//배열 출력 메소드
		public String toString() {
			return String.format("%d %s\n",age, name);
		}
		
		
	}
	
	
}
