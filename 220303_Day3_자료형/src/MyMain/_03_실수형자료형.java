package MyMain;

public class _03_�Ǽ����ڷ��� {

	/*
	 �Ǽ����ڷ��� : float double(�⺻��) <=�Ҽ����� �ִ� ��
	 ��� : 1.0, 0.x   <- double (�⺻��)
			1.0F	  <- float
			1.0e + 2  <- ��������
	��¼��� : %f	  <- �Ҽ��� ���� 6�ڸ� ���� ǥ��
			   %e	  <- �Ҽ��� ���� 6�ڸ�
			   %E     <- �빮��
			   %g	  <- �ڸ����� ���������� ��� ������ �� ������ �ʴ´�.
	
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1.0); // <- double��(�⺻��)
		System.out.println(1.0F); // <- float��(F)
		System.out.println(1.0e+2); // <- ��������
		
		double d = 12.345678901;
		System.out.printf("%f\n",d); // 12.345679 6�ڸ� �ʰ� �ڸ��� �ݿø� �Ǿ 6�ڸ��� ��µ�
		System.out.printf("%e\n",d); // 1.234568e+01
		System.out.printf("%E\n",d); // 
		System.out.printf("%g\n",d); // ������ ��� �� ���� ����
		
		double pi = Math.PI; //Math Ŭ���Ŀ��� PI�޼ҵ�?��ü?��������
		
		// %m.nf	: m(��ü�ڸ���) . n(�Ҽ��������ڸ���)
		// %0m.nf	: 0(���� ������� 0���� ä����)
		// %-m.nf	: -(Left ����)
		
	
		System.out.println(pi);			  // 3.141592653589793
		
		System.out.printf("%f\n", pi);	  // 3.141593
		
		System.out.printf("[%30f]\n",pi); //  [                      3.141593]
		
		System.out.printf("[%30.20f]\n",pi);/*[        3.14159265358979300000]
												��ü�ڸ����� 30�ڸ�, �Ҽ����ڸ����� 20�ڸ� */
		System.out.printf("[%30.2f]\n",pi); //[                          3.14]
		
		System.out.printf("[%030.2f]\n",pi);//[000000000000000000000000003.14] ������� 0����
		
		System.out.printf("[%-30.2f]\n",pi);//[3.14                          ] ��������
		
		// ����ڸ��� > ��������ü�ڸ��� : ��ü�ڸ����� ����(��κ� ����)
		System.out.printf("[%5.7f]\n",pi); // [3.1415927]
		System.out.printf("[%.7f]\n",pi); //��ü�ڸ��� ����
		
	}

}
