package data_structure;

import java.util.NoSuchElementException;

//Queue는 먼저 들어간 데이터가 먼저 나온다.
//FIFO(First In First Out)

class Queue<T> {
	
	//데이터타입을 저장하기 위한 클래스인가??
	class Node<T> {
		private T data;
		private Node<T> next;
		
		//노드생성자
		public Node(T data) {
			this.data = data;
		}
	}
	//처음과 끝을 확인 하기 위한 멤버변수
	private Node<T> first;
	private Node<T> last;
	
	//큐에 맨 끝에 데이터 더하기
	public void add(T item) {
		//아이템을 매게로 노드 생성
		Node<T> t = new Node<T>(item);
		
		//마지막에 노드가 있다면
		//즉 하나라도 Queue에 데이터가 있다면
		if(last != null) {
			//그 뒤에 새로 생성한 데이터를 붙임
			//그냥 라스트에 넣으면 원래있던 데이터랑 교체되서
			//그런듯?
			last.next = t;
		}
		//새로 붙인애를 마지막으로 변경
		last = t;
		
		//데이터가 없을때는?
		if(first == null) {
			//단 하나의 데이터가 처음이자 마지막
			//즉 마지막과 처음 속성을 같이 가지고 있음
			first = last;
		}
		
	}
	
	//맨 앞 데이터를 꺼내기
	public T remove() {
		
		if(first == null) {
			//큐가 비어있으면 익셉션 throw
			throw new NoSuchElementException();
		}
		// 맨앞 데이터를 꺼내기 전에
		// 처음 주소에 있는애를 저장(백업)하고
		T data = first.data;
		
		// 그 다음애를 처음으로 밀기
		first = first.next;
		
		//데이터 다 꺼냈을때, 마지막도 반드시 널주기
		if(first == null){
			last = null;
		}
		
		return data;
	}
	
	//맨 앞 데이터 값 보기
	public T peek() {
		if (first == null) {
			//처음이 비어있으면 익셉션
			throw new NoSuchElementException();
		}
		// 처음을 가르키고 있는 데이터를 반환
		return first.data;
		
	}
	//값이 비어있냐?? true or false로만 표현
	public boolean isEmpty() {
		
		return first == null;
	}
	
}
public class queue_test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new Queue<Integer>();
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	}

}
