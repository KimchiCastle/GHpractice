package MyMain;

public class _04_�������ڷ��� {

	/*
		�������ڷ��� : char�� (2byte)
		��� : 'A'   '��'   '��'   <= Ȭ����ǥ ''
	 	��¼��� : %c
	 	
	 	####  ASCII(��Ź����ڵ�) : 0~126   ####
	 	0~31 : ��� �� ����� ex) \n
	 	
	 			'\r' : carrige return(Home) 13��
	 			'\n' : new line (Enter) 10��
	 			'\t' : tab key
	 			'\b' : caret (�Է���ġ)�� �������� 
	 			
	 			'\a' : alert(�����)
	 			'\f' : ���������� �̵�
	 			
	
	 	32~126 : Ű����� �����ڵ尪
	 			 
	 			 ' ' : 32�� (���鹮��)
	 			 'A' : 65��
	 			 'a' : 97�� (�� ~ �� ���� : 32)
	 			 '0' : 48��
	 			 '1' : 49��
	 	
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("%c\n", 'A'); // A
		System.out.printf("%c\n", 65);	// A
		System.out.printf("%c\n", 66);	// B
		
		//'��'�� �ڵ尪 
		System.out.printf("%d\n",(int)'��'); // 54620
		System.out.printf("0x%x\n",(int)'��'); //d55c 2byte
		//2������ ���氡��
		System.out.println(Integer.toBinaryString(54620)); // 1101010101011100
		
		System.out.printf("%c\n", 54620);
		
		//�����
		System.out.printf("%d\n",(int)'\n'); // �ƽ�Ű�ڵ�� 10�� �������� (int)' '<<���������� ��ȯ
		
		System.out.println("A\nB\n");
		
		System.out.println("A\tB\tC\n");
		

		
	}

}
