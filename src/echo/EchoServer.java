package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//1.���������� �����.
		ServerSocket server = new ServerSocket(6000);
		
		while(true) {
			
			//2. ���Ӵ�� accept�޼ҵ尡 �ϴ� ����
			Socket child = server.accept();
			
			//2-1 ���� IP
			//ip�ּҸ� �����ϴ°�ü
			
			
			//3.���� ���� ��Ʈ��
			OutputStream os = child.getOutputStream();
			InputStream is = child.getInputStream();
			
			//4.������ ���� 100byte�� ���
			byte [] buff = new byte[100];
			
			int len = is.read(buff);
			
			
		}
		
		
	}

}
