package ��_������_�˰���;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class back_10814_retry {


	static Scanner sc;
	
	static My_Info [] info_array; //��!!!!!!!!!!!!!!!!!
	
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
		
		//�Է¹��� ���� array�� �������ִ� ��ɾ�
		//Collections.sort(array);
		Arrays.sort(info_array);
		//Arrays.sort(info_array, new Decending()); // ��������
		
		
		//Array_write();
		Array_write2();
		
		
	}
	

	//decending ���ı���
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
	//���� ���� �Է¸޼ҵ�
	private static void Array_in() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<user; i++) {
			
			int age = sc.nextInt();
			String name = sc.next();
			
			array.add( new My_Info(age, name)); //�÷��ǿ� �������� ���� �Է�
			
		}
		
		
	}

	public static class My_Info implements Comparable{
		
		int age; // �� �����
		String name;
		
		//class�� ������
		public My_Info(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		//���̸� �������� �����ϱ�
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
