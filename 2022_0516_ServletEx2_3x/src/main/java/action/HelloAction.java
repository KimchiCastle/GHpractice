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
//1.���α׷� �ּ�
//2.Tomcat ��û�ּ�(URL Pattern)�� �м� -> �ش缭���� ����
//3.LifeCycleException�� �߻��Ǹ� ������ url-pattern�κп��� �߻��� ������.

@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
		
			HttpServletRequest request,   // ��ûó����ü(client->server������ �Ѿ���� ������ ó���ϴ� ��ü)
			HttpServletResponse response  // ����ó����ü(server->client������ ���޵Ǵ� ������ ó���ϴ� ��ü)
			
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ip = request.getRemoteAddr();
		
		System.out.printf("[%s]:---HelloAction Call---\n",ip);
		
		// ��û������ query�� ���ؼ� �����Ѵ�
		// /2022_0516_ServletEx2_3x/hello.do
		// /2022_0516_ServletEx2_3x/hello.do?nation=kor
		// /2022_0516_ServletEx2_3x/hello.do?nation=eng
		// /2022_0516_ServletEx2_3x/hello.do?nation=jpn
		// /2022_0516_ServletEx2_3x/hello.do?nation=chn
		// /2022_0516_ServletEx2_3x/hello.do?nation=ger
		// /2022_0516_ServletEx2_3x/hello.do?nation=fra
		
		//Parameter�ޱ�
		String nation = request.getParameter("nation");
		
		if(nation == null) nation = "kor";
		
		
		String message = "";
		
		switch (nation) 
		{
		case "kor": message = "[�ѱ���] : �ȳ��ϼ���?"; break;
		case "eng": message = "[��  ��] : hello!!"; break;
		case "jpn": message = "[�Ϻ���] : ����˪���"; break;
		case "chn": message = "[�߱���] : ���Ͽ�?"; break;
		case "ger": message = "[���Ͼ�] : ����Ź"; break;
		case "fra": message = "[��  ��] : ���긣"; break;
		default : message = "[�����Ҹ�] : �����"; break;
		}
		
		
		
		//����ó��(response ��
		//1. ���۹�������  :		mime type + ���ڵ�
		//	 			   :		text/xml
		//				   :	 	text/json
		//				   :		image/jpg
		response.setContentType("text/html; charset=utf-8;");
		
		//2. ��½�Ʈ�� ������
		PrintWriter out = response.getWriter(); 		//����Ʈ��Ʈ���� ����ȭ ��Ų�� ����Ʈ������
		
		//3.�������� HTML���� ����
		out.println("<html>");
		out.println("<head><title>hello����</title></head>");
		out.println("<body>");
		out.printf("[%s]�� (%s)<br>", ip, message);
		out.println("<a href='hello.html'>�ٽ��ϱ�</a>");
		out.println("</body>");
		out.println("</html>");

		
		
	}
	
	
	
	

}
