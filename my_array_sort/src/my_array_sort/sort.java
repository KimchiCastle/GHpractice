package my_array_sort;

import java.util.Arrays;

public class sort {
	
	static int global_count = 0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("�迭 ���� �˰��� ���α׷�");

		int[] array = { 66, 43, 47, 1, 9, 11, 23, 87, 22, 24 };

		// System.out.println("�⺻���� ���α׷�");
		//my_Array(array, array.length);
		System.out.println("������ ����");
		
		
		quickSort(array);
		
		// ������ ���� �˰���
		//array = my_Array2(array, array.length);
		System.out.printf("������ ���� �ݺ��� ȸ�� : %d",global_count);
		System.out.println();
		for (int a : array) {
			System.out.printf("%d ", a);
		}

		/*
		 * for(int i = 0; i<array.length; i++) { System.out.printf("%d ",array[i]); }
		 */

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
		
		
		
		System.out.printf("%d ȸ ȣ��� �޼ҵ�, ���� �迭 ��Ȳ\n",global_count);
		System.out.println(Arrays.toString(array));
		
		System.out.println("�ٽ� ���� �尡��");
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
			System.out.println(Arrays.toString(array));
			
			global_count++;
			while(array[left] < pivot) left++; // ���ʹ迭���� ������������ ������� �����ε������� 
			while(array[right] > pivot ) right--; // ������ �迭�� ���ذ����� Ŭ��� �������ε�������
		
			if(left<=right) { // �����ε����� ������ �ε������� �۰ų� ������� ����
				swap(array,left,right);
				left++;
				right--;
			}
			
		}	
		
		System.out.println("Ż��");
		return left; // �迭 �ڸ� �ٲٴ� �ݺ��� ���� ��, ������� ����
	}

	private static void swap(int[] array, int i, int k) {
		int temp = array[i];
		array[i] = array[k];
		array[k] = temp;
	}
	
	
	private static int[] my_Array2(int[] array, int length) {
		// TODO Auto-generated method stub
		int pivot = array.length;

		int[] array2 = new int[pivot];

		int left = 0;
		int right = pivot;
		int count=0;
		
		for (int i = 0; i < array.length; i++) {
			count++;
			if (array[pivot - 1] < array[i]) {
				array2[right - 1] = array[i];
				right--;
			} else {
				array2[left] = array[i];
				left++;
			}
		}
		System.out.println(left);
		return array2;

	}

	private static void my_Array(int[] array, int array_length) {
		// TODO Auto-generated method stub
		
		int count=0;
		
		for (int i = 0; i < array_length - 1; i++) {
			count++;
			for (int k = i + 1; k < array.length; k++) {
				count++;
				if (array[i] > array[k]) {
					swap(array, i, k);
					
				}
				
			}

		}
		
		System.out.println(count);

	}



	
	
}
