package project2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
�����̴� �������� �������� JH�� �����ֱ� ���� �������� ����ó�� ���α׷��� ������ �ߴ�.

JH �������� Ư�� ���񿡼� 1���� �л��� �ٸ� ���񿡼��� � ������ ������� ������ ����.

���� ������ �����ϴ� ���α׷��� �ۼ��� ����.

�Է�
ù° �ٿ� �������� ���� n (3<=n<=100)

��° �ٺ��� n+1�ٿ� �л� �̸��� 3���� �������� �������� ���еǾ� �Էµȴ�. (�Է� ���� ����)

�� �̸��� ���̴� �ִ� 10����Ʈ �̳��̴�

���
ù ��° ������ 1���� �л��� �̸��� �� ��°, �� ��° ������ ������ �������� �����Ͽ� ����Ѵ�.

�� ù ��° ������ 1���� 1���̶�� �����Ѵ�.

�Է� ����   
4
Jeon 95 80 100
Kim 59 85 75
Lee 90 100 75
Bae 100 82 80
		
��¿���
Bae 3 2		 
	
	*/		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		String [] name = new String[n];
		int	[] subject1 = new int[n];
		int [] subject2 = new int[n];
		int [] subject3 = new int[n];
		
		//�ε��������� ���� ��
		//int res_index = 0; //�ʿ����� �˰� �����߾��µ� �ʿ䰡 ������.
		int first_index = 0;
		//int second_index = 0; 
		//int third_index = 0;	
		
		//���� �ֱ�
		for(int i=0; i<n; i++) {
			
			name[i] = scan.next();
			
			subject1[i] = scan.nextInt();
			subject2[i] = scan.nextInt();
			subject3[i] = scan.nextInt();

		}
		
		
		//1��ϱ� ���⼭ ���۸��ߴ�.. 2��for���� ������� ���ϴ� ���� �ȳ��Դ�. for�� 1���� ������ �ƾ��µ�..
		int max = subject1[0]; // ������ �����ߴ� res_idex�� ��ü

		for (int i = 0; i < n; i++) {
			if (subject1[i] > max) {
				
				max = subject1[i];
				
				first_index = i;
			}
		}
		
		//���� �����ߴ� second_index, third_idex ��ü
		int count1 = 1; 
		int count2 = 1;
		
		//1���� �ε����� �̿��� ���������� ��� ���ϱ�
		//ī��Ʈ�� 1���϶��� �ö��� ����
		for (int i = 0; i < n; i++) {
			if (subject2[first_index] < subject2[i]) {
				count1++;
			}
			if (subject3[first_index] < subject3[i]) {
				count2++;
			}
		}

		
		
		
		//System.out.println(first_index);
		/*
		System.out.print(name[first_index]);
		System.out.print(" "+count1);
		System.out.print(" "+count2);
		*/
		
		System.out.printf("%s %d %d",name[first_index], count1, count2);
		
		/*
		//�迭�� ���� ����� ������ �� ����غ���
		for(int i= 0; i<n; i++) {
			System.out.print("[ ");
			System.out.print(name[i]+", ");
			System.out.print(subject1[i]+", ");
			System.out.print(subject2[i]+", ");
			System.out.print(subject3[i]+", ");
			System.out.print("]");
			
			System.out.println();//�ٹٲ�
			
		}
		*/
		
		
	}

}
