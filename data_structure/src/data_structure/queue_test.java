package data_structure;

import java.util.NoSuchElementException;

//Queue�� ���� �� �����Ͱ� ���� ���´�.
//FIFO(First In First Out)

class Queue<T> {
	
	//������Ÿ���� �����ϱ� ���� Ŭ�����ΰ�??
	class Node<T> {
		private T data;
		private Node<T> next;
		
		//��������
		public Node(T data) {
			this.data = data;
		}
	}
	//ó���� ���� Ȯ�� �ϱ� ���� �������
	private Node<T> first;
	private Node<T> last;
	
	//ť�� �� ���� ������ ���ϱ�
	public void add(T item) {
		//�������� �ŰԷ� ��� ����
		Node<T> t = new Node<T>(item);
		
		//�������� ��尡 �ִٸ�
		//�� �ϳ��� Queue�� �����Ͱ� �ִٸ�
		if(last != null) {
			//�� �ڿ� ���� ������ �����͸� ����
			//�׳� ��Ʈ�� ������ �����ִ� �����Ͷ� ��ü�Ǽ�
			//�׷���?
			last.next = t;
		}
		//���� ���ξָ� ���������� ����
		last = t;
		
		//�����Ͱ� ��������?
		if(first == null) {
			//�� �ϳ��� �����Ͱ� ó������ ������
			//�� �������� ó�� �Ӽ��� ���� ������ ����
			first = last;
		}
		
	}
	
	//�� �� �����͸� ������
	public T remove() {
		
		if(first == null) {
			//ť�� ��������� �ͼ��� throw
			throw new NoSuchElementException();
		}
		// �Ǿ� �����͸� ������ ����
		// ó�� �ּҿ� �ִ¾ָ� ����(���)�ϰ�
		T data = first.data;
		
		// �� �����ָ� ó������ �б�
		first = first.next;
		
		//������ �� ��������, �������� �ݵ�� ���ֱ�
		if(first == null){
			last = null;
		}
		
		return data;
	}
	
	//�� �� ������ �� ����
	public T peek() {
		if (first == null) {
			//ó���� ��������� �ͼ���
			throw new NoSuchElementException();
		}
		// ó���� ����Ű�� �ִ� �����͸� ��ȯ
		return first.data;
		
	}
	//���� ����ֳ�?? true or false�θ� ǥ��
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
