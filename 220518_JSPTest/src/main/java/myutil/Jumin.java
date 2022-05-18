package myutil;

import java.util.Calendar;

public class Jumin {
	
	private String jumin_no;

	
	
	
	public String getJumin_no() {
		return jumin_no;
	}

	
	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
		
	}
	//			  01234567890123 <- index
	//jumin_no = "801212-1234560"
	
	//����⵵
	public int getYear() {
		
		//2�ڸ� �⵵ ����
		String str_year = jumin_no.substring(0,2);
		int year = Integer.parseInt(str_year);
		
		//�������� ����
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			year += 1900;
		else if (gender=='3' || gender=='4' || gender=='7' || gender=='8')
			year+=2000;
		else
			year+=1800; 
	
		return year;
	}
	
	//����
	public int getAge() {
		
		Calendar c = Calendar.getInstance();
		
		int current_year = c.get(Calendar.YEAR);
		
		//���� = ����⵵ - ����⵵
		//Ŭ������ �ڱⰡ �ڱ� �޼ҵ带 ȣ���� �� �� �ִ�.
		int age = current_year - this.getYear()+1;
	
		return age;
	}
	
	//��
	public String getTti() {
		
		int my_Tti = this.getYear()%12;
		
		switch (my_Tti) {
		case  0 : return "������";
		case  1 : return "��";
		case  2 : return "��";
		case  3 : return "����";
		case  4 : return "��";
		case  5 : return "��";
		case  6 : return "ȣ����";
		case  7 : return "�䳢";
		case  8 : return "��";
		case  9 : return "��";
		case 10 : return "��";
		}	
		return "��";
		
	}
	/*
					 ����				 ����
				������	�ܱ���		������	�ܱ���
		1900	  1			5		  2			6
		2000	  3			7		  4			8
		1800	  9					  0
	
	*/
	
	
	
	//����
	public String getGender() {
		
		String res = "����";
		
		char gender = jumin_no.charAt(7);
		if((gender-'0')%2!=0) {
			return res = "����";
		}
		return res;
	}
	
	//����
	public String getLocal() {
		
		String str_local = jumin_no.substring(8,10);
		int local = Integer.parseInt(str_local);
		
		if(local>=0 &&local<=8)			return "����Ư����";
		else if(local>=9 && local<=12)	return "�λ걤����";
		else if(local>=13 && local<=15)	return "��õ������";
		else if(local>=16 && local<=25)	return "��⵵";
		else if(local>=26 && local<=34) return "������";
		else if(local>=35 && local<=39) return "��û�ϵ�";
		else if(local==40)				return "����������";
		else if(local==44 || local==49) return "����Ư����";
		else if(local>=41 && local<=43 || 
				local>=45 && local<=47) return "��û����";
		else if(local>=48 && local<=54) return "����ϵ�";
		else if(local>=55 && local<=56) return "���ֱ�����";
		else if(local>=57 && local<=66) return "���󳲵�";
		else if(local>=67 && local<=70) return "�뱸������";
		else if(local>=71 && local<=81) return "���ϵ�";
		else if(local==85 || local==90) return "��걤����";
		else if(local>=82 && local<=92) return "��󳲵�";
		else if(local>=93 && local<=95) return "����Ư����";
		
		
		return "";
				
	}
	
	//����
	public String getSeason() {
		
		
		String str_month =this.jumin_no.substring(2,4);
		int month = Integer.parseInt(str_month);

		//�� 3 4 5  ���� 6 7 8 ���� 9 10 11 
		switch(month/3) {
		case 1 : return "��"; 
		case 2 : return "����"; 
		case 3 : return "����";
		}
		
		return "�ܿ�";
	}
	
	//����
	public String getGanji() {
		
		int my_year = this.getYear();
		
		int a = my_year%10;
		int b = my_year%12;
		String gan; // ����⵵%10
		String ji; // ����⵵%12
		
		switch (a) { // 10��
		case  0 : gan = "��"; break;
		case  1 : gan = "��"; break;
		case  2 : gan = "��"; break;
		case  3 : gan = "��"; break;
		case  4 : gan = "��"; break;
		case  5 : gan = "��"; break;
		case  6 : gan = "��"; break;
		case  7 : gan = "��"; break;
		case  8 : gan = "��"; break;
		case  9 : gan = "��"; break;
		default : gan = "";
		}
		switch (b) { // 12��
		case  0 : ji = "��"; break;
		case  1 : ji = "��"; break;
		case  2 : ji = "��"; break;
		case  3 : ji = "��"; break;
		case  4 : ji = "��"; break;
		case  5 : ji = "��"; break; 
		case  6 : ji = "��"; break;
		case  7 : ji = "��"; break;
		case  8 : ji = "��"; break;
		case  9 : ji = "��"; break;
		case 10 : ji = "��"; break;
		case 11 : ji = "��"; break;
		default : ji = "";
		}	
		// ���ϱ⿬�� �ϸ� �޸𸮳��� ���ϴ� String.format�̿�
		//String ganji=String.format("%s%s��",gan, ji);
		return String.format("%s%s��",gan, ji);
		
	}
	
	
	//			  01234567890123 <- index
	//jumin_no = "801212-1234560"
	//			  234567 892345
	
	//��ȿ��
	public boolean isvalid() {
		
		
		int sum = 0; //������
		/*
		//			  		  		'8'-'0' => 8
		sum = sum + (jumin_no.charAt(0)-'0') * 2;
		//sum = sum + ( Interger.parseInt(jumin_no.subString(0, 1) ) )*2
		sum = sum + (jumin_no.charAt(1)-'0') * 3;
		sum = sum + (jumin_no.charAt(2)-'0') * 4;
		sum = sum + (jumin_no.charAt(3)-'0') * 5; )
		sum = sum + (jumin_no.charAt(4)-'0') * 6;
		sum = sum + (jumin_no.charAt(5)-'0') * 7;
		*/
		// - �ǳʶٰ�
		for(int i=0; i<=5; i++) {
			sum = sum +(jumin_no.charAt(i)-'0')*(i+2);
		}
		
		/*
		sum = sum + (jumin_no.charAt(7)-'0') * 8;
		sum = sum + (jumin_no.charAt(8)-'0') * 9;
		sum = sum + (jumin_no.charAt(9)-'0') * 2;
		sum = sum + (jumin_no.charAt(10)-'0')* 3;
		sum = sum + (jumin_no.charAt(11)-'0')* 4;
		sum = sum + (jumin_no.charAt(12)-'0')* 5;
		*/
		for(int i=7; i<=8;i++) {
			sum = sum +(jumin_no.charAt(i)-'0')*(i+1);
		}
		for(int i=9; i<=12;i++) {
			sum = sum +(jumin_no.charAt(i)-'0')*(i-7);
		}
		
		
		//System.out.println(sum);
		
		/*
		sum %= 11;
		sum = 11-sum;
		sum %= 10; // 0~9
		*/
		sum = (11-sum%11)%10;
		
		System.out.println(sum);
		//				�ֹι�ȣ �������ڸ� ����
		int last_no = ( jumin_no.charAt(13)-'0');
		
		return (sum==last_no);
	}
	/*
	public boolean isvalid2() {
		
		
		int sum = 0; //������
		int check = 2;
		
		for(int i = 0; i<=12; i++) {
			
			if(i==6) continue; // i=6�϶� ��Ƽ�� �ǳʶ�
				
			sum = sum + (jumin_no.charAt(i)-'0') * check;
			check++;
			if(check>9) check=2;
		}
	
		sum = (11-sum%11)%10;
		
		System.out.println(sum);
		//				�ֹι�ȣ �������ڸ� ����
		int last_no = ( jumin_no.charAt(13)-'0');
		
		return (sum==last_no);
	}
	*/
	
	
	
	public boolean isvalid2() {
		
		int sum = 0;
		int count =2;
		
		for(int i=0; i<=12; i++) {
			
			if(i==6) continue;
			
			sum = sum +(jumin_no.charAt(i)-'0')*count;
			count++;
			
			if(count>9) count = 2;
			
		}
		
		sum = (11-sum%11)%10;
		
		int last_num = (jumin_no.charAt(13)-'0');
		
		return (sum==last_num);
	}
	
	
}




