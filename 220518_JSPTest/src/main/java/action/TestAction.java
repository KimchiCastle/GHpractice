package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAction
 */
@WebServlet("/test.do")
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//��� ���� ����
	int a = 10;
	
	//����޼ҵ�
	void sub() {
		
	}
	

	protected void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
