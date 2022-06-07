package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//insert.do?m_id=hong&content=123&pwd=123
		
		//1.Encoding ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter �޾ƿ���
		String m_id		= request.getParameter("m_id");
		String content  = request.getParameter("content").replaceAll("\r\n", "<br>");
		String pwd		= request.getParameter("pwd");
		
		//3. request�κ��� ip�޾ƿ���
		String ip = request.getRemoteAddr();
		
		//4. vo ��ü ����, �����ڸ� ���� ��ü�� �� �ֱ�.
		VisitVo vo = new VisitVo(m_id, pwd, content, ip);
		
		//5.Dao�� ���� DB�� �� �ֱ�
		int res = VisitDao.getInstance().insert(vo);		
		
		
		//6. �߰�, ����, ������ �����̷�Ʈ��
		response.sendRedirect("list_login.do");
	}
}