package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_10989����3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt( br.readLine() );
		}
		
		quickSort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}

	
	private static void quickSort(int[] array) {
		// TODO Auto-generated method stub
		sort(array,0,array.length-1); //�迭�� �ְ�, �����ε���, �������ε��� ����
	}
	
	private static void sort(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		 
		//�����ε��� ���� ũ�ų� ������� ����
		if(left>=right) return; 
		
		
		
		int pivot2 = sort2(array, left, right); // ��Ʈ2�� �����ϰ� ������ ���pivot�ε��� sort2��left

		// ����Լ� �ڱ� �ڽ��� �޼ҵ带 ȣ��
		// �ѹ� ������ �迭 ���ľȵ� ���� �迭���� 
		//		   left : 0 right : pivot�ε���-1
		sort(array,left, pivot2-1);
		// �ѹ� ������ �迭 ���ľȵ� ������ �迭����
		//	left : �������ε��� right : array.length-1
		sort(array,pivot2,right); 
	}

	//���� �迭�� �ٲ�� �޼ҵ�
	private static int sort2(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		
		int pivot = array[( left+right ) / 2 ]; // ������ �迭�ǰ�� ������ ����
		
		while(left<=right) { // ������������ �ݺ��ϰ� left�� right ũ�ų� �������� �ݺ�������
			
	
			while(array[left] < pivot) left++; // ���ʹ迭���� ������������ ������� �����ε������� 
			while(array[right] > pivot ) right--; // ������ �迭�� ���ذ����� Ŭ��� �������ε�������
		
			if(left<=right) { // �����ε����� ������ �ε������� �۰ų� ������� ����
				swap(array,left,right);
				left++;
				right--;
			}
			
		}	
		return left; // �迭 �ڸ� �ٲٴ� �ݺ��� ���� ��, ������� ����
	}

	private static void swap(int[] array, int i, int k) {
		int temp = array[i];
		array[i] = array[k];
		array[k] = temp;
	}
	
}
