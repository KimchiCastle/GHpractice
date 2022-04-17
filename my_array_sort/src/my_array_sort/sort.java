package my_array_sort;

import java.util.Arrays;

public class sort {
	
	static int global_count = 0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("배열 정렬 알고리즘 프로그램");

		int[] array = { 66, 43, 47, 1, 9, 11, 23, 87, 22, 24 };

		// System.out.println("기본정렬 프로그램");
		//my_Array(array, array.length);
		System.out.println("퀵정렬 시작");
		
		
		quickSort(array);
		
		// 퀵정렬 내부 알고리즘
		//array = my_Array2(array, array.length);
		System.out.printf("퀵정렬 사용시 반복문 회수 : %d",global_count);
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
		sort(array,0,array.length-1); //배열을 주고, 왼쪽인덱스, 오른쪽인덱스 설정
	}
	
	private static void sort(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		 
		//왼쪽인덱스 값이 크거나 같을경우 리턴
		if(left>=right) return; 
		
		
		
		int pivot2 = sort2(array, left, right); // 소트2로 정렬하고 나오는 가운데pivot인덱스 sort2의left
		
		
		
		System.out.printf("%d 회 호출된 메소드, 현재 배열 현황\n",global_count);
		System.out.println(Arrays.toString(array));
		
		System.out.println("다시 소팅 드가자");
		// 재귀함수 자기 자신의 메소드를 호출
		
		
		// 한번 정렬후 배열 정렬안된 왼쪽 배열정렬 
		//		   left : 0 right : pivot인덱스-1
		sort(array,left, pivot2-1);
		// 한번 정렬후 배열 정렬안된 오른쪽 배열정렬
		//	left : 기준점인덱스 right : array.length-1
		sort(array,pivot2,right); 
	}

	//실제 배열이 바뀌는 메소드
	private static int sort2(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		
		int pivot = array[( left+right ) / 2 ]; // 기준점 배열의가운데 값으로 지정
		
		while(left<=right) { // 엇갈리때까지 반복하고 left가 right 크거나 같아지면 반복문종료
			System.out.println(Arrays.toString(array));
			
			global_count++;
			while(array[left] < pivot) left++; // 왼쪽배열값이 기준점값보다 작을경우 왼쪽인덱스증가 
			while(array[right] > pivot ) right--; // 오른쪽 배열이 기준값보다 클경우 오른쪽인덱스감소
		
			if(left<=right) { // 왼쪽인덱스가 오른쪽 인덱스보다 작거나 같을경우 스왑
				swap(array,left,right);
				left++;
				right--;
			}
			
		}	
		
		System.out.println("탈출");
		return left; // 배열 자리 바꾸는 반복문 종료 후, 가운데값을 리턴
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
