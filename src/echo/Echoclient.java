package echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Echoclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//1.접속요청
		
		//예외 발생시 메인에게 전부 위임
		Socket client = new Socket("localhost", 7000);
		
		System.out.println("클라이언트 : 연결성공!!");
		
		
		
		//2. 전송/수신 스트림을 얻어온다.
		OutputStream os = client.getOutputStream();
		InputStream  is = client.getInputStream();
		
		//3.메세지 전송
		String msg = "하이용?";
		
		//스트링을 byte[]형태로 변환시켜서 보낸다.
		os.write(msg.getBytes());
		
		//4.서버로부터 전송된 데이터 수신
		
		
	}

}
