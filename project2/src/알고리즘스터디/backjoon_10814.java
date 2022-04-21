package �˰����͵�;

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
	
	static int n_user; //ȸ����
	
	static BufferedReader br;
	
	static List<My_info> array;
	
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		br = new BufferedReader( new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));   
		
		
		String n = br.readLine();
		
		 n_user = Integer.parseInt(n); // ���ۿ��� �޾ƿ� n�� int����ȯ
		
		
		array = new ArrayList<My_info>(); //ArrayList ����
		
		Array_in(); // ArrayList �ȿ� ��ü �ֱ�
		
		Collections.sort(array);
		
		Array_wirte();
		
	}


	private static void Array_wirte() throws IOException {
		// TODO Auto-generated method stub
		for(My_info ar : array) {
			bw.write(ar.toString());
		}
		bw.flush();   //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close();   //��Ʈ���� ����
	}


	private static void Array_in() throws IOException {
		// TODO Auto-generated method stub
		
		//�ռ� �Էµ� n_uer ��ŭ �ݺ�
		for (int i = 0; i < n_user; i++) {

			String info = br.readLine(); // ���۷� ���� �Է�

			StringTokenizer st = new StringTokenizer(info); // �Է¹��� info�� ��������� split

			int age = Integer.parseInt(st.nextToken()); // Tokenizer�� �ڸ� String�� ��ü�� ���� age�� ��ȯ
			String name = st.nextToken(); // String �� �״�� ���ڿ� ���

			 // ArrayList�� ������� �迭 array�� add(�������� My_info��ü ������ ���� ����)
			array.add(new My_info(age, name)); 
		}
	}

	
	// ��������ǰ�ü				������ ���� Comparable �������
	static class  My_info implements Comparable {

		int age;
		String name;
		
		public My_info(int age, String name) { // ������ �޼ҵ�
			this.age = age;
			this.name = name;
		}
		//Comparable ���� �޼ҵ� ������ ������ ���� return��
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			//				ObjectŸ���̱⶧���� �ٿ�ĳ���� �ؾ���
			//this.age�� ��ũ�� ��� ������ 0 ����age�� ��ũ�� ����
					//�� ����	���� ��ü�� ����
			return this.age - ((My_info)o).age; 
		}
		
		//�迭 ��� �޼ҵ�
		public String toString() {
			return String.format("%d %s\n",age, name);
		}
		
		
	}
	
	
}
