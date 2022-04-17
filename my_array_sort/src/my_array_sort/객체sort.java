package my_array_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class ��üsort {

	public static class Able{
		
		String �̸�;
		int age;
		int total;
		
		public Able(int total) {
			this.total = total;
		}
		
		
		public Able(String name, int age) {
			
			�̸� = name;
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
		
		//Able ��ü ���� �� Vector�� �߰�
		
		Able a1 = new Able("����", 20);
		Able a2 = new Able("����", 21);
		Able a3 = new Able("����", 19);
		Able a5 = new Able("����", 19);
		Able a4 = new Able("����", 15);
		
				//���⿡ N����
		
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
			System.out.println(n.�̸� + " " + n.getTotal());
		}
		
		
	
		
	}

}
