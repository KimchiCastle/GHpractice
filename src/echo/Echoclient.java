package echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Echoclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//1.���ӿ�û
		
		//���� �߻��� ���ο��� ���� ����
		Socket client = new Socket("localhost", 7000);
		
		System.out.println("Ŭ���̾�Ʈ : ���Ἲ��!!");
		
		
		
		//2. ����/���� ��Ʈ���� ���´�.
		OutputStream os = client.getOutputStream();
		InputStream  is = client.getInputStream();
		
		//3.�޼��� ����
		String msg = "���̿�?";
		
		//��Ʈ���� byte[]���·� ��ȯ���Ѽ� ������.
		os.write(msg.getBytes());
		
		//4.�����κ��� ���۵� ������ ����
		
		
	}

}
