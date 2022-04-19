package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1415_ {

	static List<Integer> array;
	static int n;
	static BufferedReader br; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
/*
	������ ������ ���α׷��� ������ Ǫ�µ� ���� ���ȴ�.

N���� �����Ͱ� �ԷµǸ�, ���������� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù°�ٿ� N�� �Էµȴ�. (1<=N<=10,000)
���� �ٺ��� N���� �����Ͱ� �� �ٿ� �� ���� �Էµȴ�.

���
�������� ������ ����� �� �ٿ� �ϳ��� ������� ����Ѵ�.

�Է� ����   
5
7
3
10
2
1

��� ����
1
2
3
7
10		
*/		
		br = new BufferedReader( new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		array = new ArrayList<Integer>();
		
		
		mysort();
		
		display();
		
		
	}

	private static void display() {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

	private static void mysort() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());			
			array.add(a);
		}
		
		Collections.sort(array);
	}

}
