package mycodeup;

import java.util.List;
import java.util.Scanner;

public class Main_1099_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for���� �̲���� ������ ���α׷��ֿ� ���� ���ϰ� �θ� xx
		// ����°͵� �����ϱ�(else)
		// ���������� ���� �ִ°� ������� �ʾȤ���....
		Scanner sc = new Scanner(System.in);

		int[][] a = new int[11][11];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();

		int c = 1; // ��
		int r = 1; // ��
		// �ؿ� 1�� �������� ����� //�������迭�̶� length�ָ�xx �ȵ�
		
		a[r][c]=9;
		
	
		
		   while(true){ // 1,1����
			
				// ���̽�: �ֺ��� �̸� ���캸��, �� �ڸ��� 9�ְ�, �̵�
				// ||���������� ����
			   //c++;
				if (a[r][c] == 2 ) {//���� ùĭ�� ���̰� ������ �����					
				   break;
				} else if (a[r][c+1] != 1 ) {// ������1�̾ƴϸ� ������ ���� 9. 
					//a[r][c] = 9;
					c++;	
				} else if(a[r][c+1]==1) {
					r++;	
				}
				if (a[r+1][c]==1) {
					break;
				
				}else if (a[r][c] == 2 ) {
					a[r][c] = 9; 
					break;
				}
				a[r][c]=9;
				
//���� : �� ������ 
			}//end while
		

	for (int j = 0; j < 10; j++) {
		for (int i = 0; i < 10; i++) {

				System.out.printf("%d ", a[j][i]);
			}
			System.out.println();
		}

	}

}
