package MyMain;

public class _02_�������ڷ��� {

	/*	
	�������ڷ��� : byte short int long -> �⺻�� int��
	��� :   1 0 <= �Ҽ����� ���� ��
			 1L  <= long�� ���
			 
			 10���� : 100
			 16���� : 0x64	<=�տ� 0x
			 		  0~9���� 10 11 12 13 14 15
			 		  		   a  b  c  d  e  f
			 		  0xf	<= 15  (4bit�� ������)
			 		  0xff	<= 255 (8bit�� ������) #ffffff (#=16����, R,G,B) HTML���� ǥ���
			 		  
			  8���� : 0144	<=�տ� 0(���� zero)
	��¼���: %d (decimal)	: 10���� �� ����϶�
			  %x (hexa)		: 16���� �� ����϶�
			  %o (octal)	:  8���� �� ����϶�
		
	*/	
	public static void main(String[] args) {
		System.out.println(1);	//4byte int�� �⺻���̶�
		System.out.println(1L); //8byte long������ ���(L)

		//100�� ���� ������ ���
		System.out.printf("10����: %d\n",100); // "10���� : %d"%d ,����<�� ǥ���϶� [10����: 100]
		System.out.printf("16����: 0x%x\n",100); //[16����: 0x64]
		System.out.printf(" 8����: 0%o\n",100); // [ 8����: 0144]
		
		//�� ������ ��->10������ ���
		System.out.printf("%d\n", 0x64); //100
		System.out.printf("%d\n", 0144); //100
		System.out.printf("%d\n", 0xff); //255
		
		//�ڸ��� �����ؼ� ��°���
		int n = 123;
		
		// %md  : m <-�����ڸ���
		System.out.printf("[%10d]\n", n); //[       123]
		
		// %0md  : 0<-�� ������ 0���� ä���� m <-�����ڸ��� 
		System.out.printf("[%010d]\n", n);//[0000000123]
		
		// %-md  : -m ������ȣ�� ������ Left  m<-�����ڸ��� 
		System.out.printf("[%-10d]\n", n);//[123       ]			
		//System.out.printf("[%-010d]", n);	Error		
		
		// ����ڸ��� > �����ڸ��� : �����ڸ����� ���õ�
		System.out.printf("[%2d]\n", n);//[123]
		
		
		//------------------
		
		int a = 3698;
		
		System.out.printf("[0x%x]\n", a);
				
	}
	
}
