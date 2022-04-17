package my_array_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class 객체sort {

	public static class Able{
		
		String 이름;
		int age;
		int total;
		
		public Able(int total) {
			this.total = total;
		}
		
		
		public Able(String name, int age) {
			
			이름 = name;
			this.age = age;
		
			total = age;
		}
		
		public int getTotal() {
			return total;
		}
		
		
	}
	
	public static class AbleComp implements Comparator<Able>{

		@Override
		public int compare(Able o1, Able o2) {
			// TODO Auto-generated method stub
			int var = 0;
			
			if( o1.getTotal() > o2.getTotal() ) {
				var = 1;
			}else if ( o1.getTotal() < o2.getTotal() ) {
				var = -1;
			}
			
			return var;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector<Able> v = new Vector<Able>(2,5);
		
		//Able 객체 생성 및 Vector에 추가
		
		Able a1 = new Able("나은", 20);
		Able a2 = new Able("은지", 21);
		Able a3 = new Able("다현", 19);
		Able a5 = new Able("애진", 19);
		Able a4 = new Able("지은", 15);
		
				//여기에 N삽입
		
		v.addElement(a1);
		v.addElement(a2);
		v.addElement(a3);
		v.addElement(a4);
		v.addElement(a5);
		
		Able[] array = new Able[v.size()];
		
		v.copyInto(array);
		
		AbleComp comp = new AbleComp();
		
		Arrays.sort(array,comp);
		
		for (Able n : array) {
			System.out.println(n.이름 + " " + n.getTotal());
		}
		
		
	
		
	}

}
