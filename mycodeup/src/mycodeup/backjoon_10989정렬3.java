package mycodeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_10989정렬3 {

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
		sort(array,0,array.length-1); //배열을 주고, 왼쪽인덱스, 오른쪽인덱스 설정
	}
	
	private static void sort(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		 
		//왼쪽인덱스 값이 크거나 같을경우 리턴
		if(left>=right) return; 
		
		
		
		int pivot2 = sort2(array, left, right); // 소트2로 정렬하고 나오는 가운데pivot인덱스 sort2의left

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
			
	
			while(array[left] < pivot) left++; // 왼쪽배열값이 기준점값보다 작을경우 왼쪽인덱스증가 
			while(array[right] > pivot ) right--; // 오른쪽 배열이 기준값보다 클경우 오른쪽인덱스감소
		
			if(left<=right) { // 왼쪽인덱스가 오른쪽 인덱스보다 작거나 같을경우 스왑
				swap(array,left,right);
				left++;
				right--;
			}
			
		}	
		return left; // 배열 자리 바꾸는 반복문 종료 후, 가운데값을 리턴
	}

	private static void swap(int[] array, int i, int k) {
		int temp = array[i];
		array[i] = array[k];
		array[k] = temp;
	}
	
}
