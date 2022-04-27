package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Queue1<T>{
	//������ Ȯ�� ����
	private int count = 0;
	class Node<T>{
		
		private T data;
		private Node<T> next;
		
		
		public Node(T data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
	}
	
	//ó���� ���� Ȯ���ϱ� ���� ������� ����
	
	private Node<T> first;
	private Node<T> last;
	
	public void push(T item) {
		
		count++;
		
		Node<T> t = new Node<T>(item);
		
		//�ϳ��� �����Ͱ� ��������
		if(last != null) {
			//������������ ������ ����
			last.next = t;
		}
		
		last = t;
		
		//�����Ͱ� ���������
		if(first == null) {
			first = last;
		}
		
	}
	
	public void pop() {
		
		if(first==null) {
			System.out.println(-1);
			return;
		}
		//�����͸� ����
		if(count<0) {
			count = 0;
		}else count--;
		
		
		//������ ����
		T data = first.data;
		first = first.next;
		
		if(first == null){
			last = null;
		}
		//first data �� ����
		System.out.println(data);
		
	}
	
	public void size() {
		System.out.println(count);
	}

	
	public void empty() {
		System.out.println(first == null ? 1 : 0);
	}

	public void front() {
		if (first == null) {
			//ó���� ��������� �ͼ���
			System.out.println(-1);
			return;
		}
		// ó���� ����Ű�� �ִ� �����͸� ��ȯ
		System.out.println(first.data); 
	}
	
	public void back() {
		if (last == null) {
			//ó���� ��������� �ͼ���
			System.out.println(-1);
			return;
		}
		// ó���� ����Ű�� �ִ� �����͸� ��ȯ
		System.out.println(last.data);
	}

}// Queue end	
	
public class backjoon_18258 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Queue1<Integer> q = new Queue1<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			/*
			if(st.nextToken().equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				q.push(n);	
			}else if(st.nextToken().equals("front")) {
				q.front();
			}else if(st.nextToken().equals("back")) {
				q.back();
			}else if(st.nextToken().equals("size")) {
				q.size();
			}else if(st.nextToken().equals("empty")) {
				q.empty();
			}else if(st.nextToken().equals("pop")) {
				q.pop();
			}
			*/
			
			switch (st.nextToken()) {
			case "push":
				int n = Integer.parseInt(st.nextToken());
				q.push(n);
				break;
			case "front" :
				q.front();
				break;
			case "back" :
				q.back();
				break;
			case "size" :
				q.size();
				break;
			case "empty" :
				q.empty();
				break;		
			default:
				q.pop();
				break;
			} // switch end
			
			
		} // for end
		
		
	}

}