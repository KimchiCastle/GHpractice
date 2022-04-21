package 꼭_숙지할_알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class back_10814_retry {


	static Scanner sc;
	
	static My_Info [] info_array; //헐!!!!!!!!!!!!!!!!!
	
	static List<My_Info> array;
	
	static int user;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc = new Scanner(System.in);
		
		user = sc.nextInt();
		
		//array = new ArrayList<My_Info>();
		
		info_array = new My_Info[user];
		
		//Array_in();
		Array_in2();
		
		//입력받은 정보 array를 소팅해주는 명령어
		//Collections.sort(array);
		Arrays.sort(info_array);
		//Arrays.sort(info_array, new Decending()); // 역순정렬
		
		
		//Array_write();
		Array_write2();
		
		
	}
	

	//decending 정렬기준
	private static class Decending implements Comparator{
		
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			if(o1 instanceof Comparable && o2 instanceof Comparable) {
				Comparable c1 = (Comparable)o1;
				Comparable c2 = (Comparable)o2;
				
				return c1.compareTo(c2) * -1;
			}
			
			return -1;
		}
		
	}


	//Array
	private static void Array_write2() {
		// TODO Auto-generated method stub
		
		for(My_Info ar : info_array) {
			System.out.println(ar.toString());
		}
		
	}
	//ArrayList 
	private static void Array_write() {
		// TODO Auto-generated method stub
		
		for(My_Info ar : array) {
			System.out.println(ar.toString());
		}
		
	}
	
	//Array
	private static void Array_in2() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<user; i++) {
			
			int age = sc.nextInt();
			String name = sc.next();
			
			info_array[i] = new My_Info(age, name);
			
		}
		
	}

	//ArrayList
	//실제 정보 입력메소드
	private static void Array_in() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<user; i++) {
			
			int age = sc.nextInt();
			String name = sc.next();
			
			array.add( new My_Info(age, name)); //컬랙션에 차곡차곡 정보 입력
			
		}
		
		
	}

	public static class My_Info implements Comparable{
		
		int age; // 비교 대상자
		String name;
		
		//class의 생성자
		public My_Info(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		//나이를 기준으로 소팅하기
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return this.age - ((My_Info)o).age;
		}
		
		public String toString() {
			return String.format("%d %s",age, name);
		}
		
	}

}
