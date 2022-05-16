package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */

//@annotation
//1.프로그램 주석
//2.Tomcat 요청주소(URL Pattern)를 분석 -> 해당서블릿을 구동
//3.LifeCycleException이 발생되면 무조건 url-pattern부분에서 발생된 에러다.

@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
		
			HttpServletRequest request,   // 요청처리객체(client->server측으로 넘어오는 정보를 처리하는 객체)
			HttpServletResponse response  // 응답처리객체(server->client측으로 전달되는 정보를 처리하는 객체)
			
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ip = request.getRemoteAddr();
		
		System.out.printf("[%s]:---HelloAction Call---\n",ip);
		
		// 요청사항을 query를 통해서 전달한다
		// /2022_0516_ServletEx2_3x/hello.do
		// /2022_0516_ServletEx2_3x/hello.do?nation=kor
		// /2022_0516_ServletEx2_3x/hello.do?nation=eng
		// /2022_0516_ServletEx2_3x/hello.do?nation=jpn
		// /2022_0516_ServletEx2_3x/hello.do?nation=chn
		// /2022_0516_ServletEx2_3x/hello.do?nation=ger
		// /2022_0516_ServletEx2_3x/hello.do?nation=fra
		
		//Parameter받기
		String nation = request.getParameter("nation");
		
		if(nation == null) nation = "kor";
		
		
		String message = "";
		
		switch (nation) 
		{
		case "kor": message = "[한국어] : 안녕하세요?"; break;
		case "eng": message = "[영  어] : hello!!"; break;
		case "jpn": message = "[일본어] : こんにちは"; break;
		case "chn": message = "[중국어] : 니하오?"; break;
		case "ger": message = "[독일어] : 구텐탁"; break;
		case "fra": message = "[불  어] : 봉쥬르"; break;
		default : message = "[국적불명] : 몰라용"; break;
		}
		
		
		
		//응답처리(response 이
		//1. 전송문서정보  :		mime type + 인코딩
		//	 			   :		text/xml
		//				   :	 	text/json
		//				   :		image/jpg
		response.setContentType("text/html; charset=utf-8;");
		
		//2. 출력스트림 얻어오기
		PrintWriter out = response.getWriter(); 		//프린트스트림을 문자화 시킨게 프린트라이터
		
		//3.동적으로 HTML생성 전송
		out.println("<html>");
		out.println("<head><title>hello응답</title></head>");
		out.println("<body>");
		out.printf("[%s]님 (%s)<br>", ip, message);
		out.println("<a href='hello.html'>다시하기</a>");
		out.println("</body>");
		out.println("</html>");

		
		
	}
	
	
	
	

}
