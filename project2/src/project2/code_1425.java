package project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code_1425 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
	A���б��� ù �߷��� ���� B����� 1�г� 1�� ������ �ð� �Ǿ���.

��븦 �Ȱ� ù ����� B����� �ʹ� ���� ������ �л����� ��ϱ⵵ ���� ���ǿ� ���� �л����� ���⸸�� ��ٸ��� �־���.

�׸��� ���� ���� ���� ���� �ؾ� ���� �����ϴ� �� �л��� �ڸ� ��ġ�� �켱������ �ؾ߰ڴٰ� �����ߴ�.

���� ���� �ڸ� ��ġ ����� ����ϴٰ� �л����� Ű�� ���� ������� �տ������� ������ ���� ���� ���� ����̶�� �����ϰ� �Ǿ���.

���� ���, 160, 165, 164, 165, 150, 165, 168, 145, 170�� �л��� Ű�� �־����� �� �ٿ� 6�� �ɴ´ٸ� ������ ���� ������ �� ���̴�.

145	150	160	164	165	165
165	168	170			
���� ������ ���ʴ�� Ű ������� ������ �� ���� �� á�� ��� ���� �ٷ� �Ѿ��. ���� �ٵ� ���������� ���ʺ��� ä���.

�̿� ���� �л��� Ű������� �ڸ��� ��ġ�ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
1. ù ��° �ٿ� �л� ��(N)�� ���ٿ� ���� �� �ִ� �ڸ���(C)�� �ڿ����� �־�����. ��, (1��N��99), (1��C��10)

2. ��° �ٿ��� N���� �л� Ű���� �������� ���еǾ� �Էµȴ�.

���
�л����� �ڸ� ��ġ ����� �������� �и��Ͽ� ����Ѵ�.

(ǥ������ ���� : �� ���� �������� ������ �� ĭ �־�� ��.)

�Է� ����   
9 6
160 165 164 165 150 165 168 145 170 

��� ����
145 150 160 164 165 165 
165 168 170 	
*/		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String in_put = br.readLine();
		
		String stu_ki = br.readLine();
		
		
		String [] info = in_put.split(" ");
		String [] stu_info = stu_ki.split(" ");
		
		int a = Integer.parseInt(info[0]);
		int b = Integer.parseInt(info[1]);
		
	
		
		List<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 0; i<a; i++) {
			ar.add(Integer.parseInt(stu_info[i]));
		}
		
		Collections.sort(ar);
		
		
		//System.out.printf("%d %d\n",a, b);
		/*
		for(int i = 0; i<a; i++) {
			System.out.printf("%d ",ar.get(i));
			if( i%b==0 && i!=0 ) {
				System.out.println();
			}
			
			
		}
		*/
		
		//��Ȳ�� ���� ���ǹ� ��¹� ���� Ȯ�� ���ϱ�!!
		for(int i = 0; i<a; i++) {
			System.out.printf("%d ",ar.get(i));
			if( i%b==0 && i!=0) {
				System.out.println();
			}
			
			
		}
		
		
		//System.out.println(Arrays.toString(stu_info));
		
	}

}
