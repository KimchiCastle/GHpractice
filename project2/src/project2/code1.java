package project2;



import java.util.Scanner;

public class code1 {

	public static void main(String[] args) {
		

	    Scanner scan = new Scanner(System.in);
	     
	    String cal=""; 
	   
	    cal = scan.next(); // nextLine();�� ������ ���ø��� ������� ����
	    
	    
	    // \\�������� 2���� ����ϸ� '�̽�������ó��' ��� �Ѵ�.
	    String [] can2 = cal.split("\\."); // ��Ÿ���ڿ� ���� �߿伺!!!
	  
	    
	    //���ø��� ���̴� ��Ÿ����
	    //^ : ���ڿ��� ó���� ��Ÿ����.
	    //$ : ���ڿ��� ���� ��Ÿ����.
	    //. : ������ �� ���ڸ� ��Ÿ����.
	    //+ : �ٷ� ���� ���ڰ� �ϳ� �̻��̴�.
	    //? : ���� ���ڰ� ���ų� �ϳ��̴�.
	    //[ ] : �� ���ڸ� ����Ű�� ���� ���� ������ ����Ű�� ������ ������ ��Ÿ����.
	    //{ } : �տ� �ִ� ������ ������ ��Ÿ���� ���� �ȿ��� ','�� ���� ������ ������ ��Ÿ�� �� ����.
	    //( ) : ��ȣ ���� ���ڿ��� �ϳ��� ���� ����Ѵ�.
	    //| : �Ǵ�(or)�� ������ ���ù��� ���δ�.
	    //\ : ��Ÿ ������ ������ ���� �� ���δ�. 

	    //�̷��� �տ� (Integer)�� ����ȯ �ص� �����ʴ´�.
	    //System.out.printf("%d", (Integer)can2[1]);

	    //��Ʈ���ڷ����� int������ ����ȯ int���� ����Ŭ���� Integer�� parseInt�޼ҵ� ���
	    System.out.printf("%04d.%02d.%02d",Integer.parseInt(can2[0]),Integer.parseInt(can2[1]),Integer.parseInt(can2[2]));
	  
	}

}

