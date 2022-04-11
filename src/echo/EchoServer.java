package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//1.서버소켓을 만든다.
		ServerSocket server = new ServerSocket(6000);
		
		while(true) {
			
			//2. 접속대기 accept메소드가 하는 역할
			Socket child = server.accept();
			
			//2-1 상대방 IP
			//ip주소를 관리하는객체
			
			
			//3.전송 수신 스트림
			OutputStream os = child.getOutputStream();
			InputStream is = child.getInputStream();
			
			//4.데이터 수신 100byte만 사용
			byte [] buff = new byte[100];
			
			int len = is.read(buff);
			
			
		}
		
		
	}

}
