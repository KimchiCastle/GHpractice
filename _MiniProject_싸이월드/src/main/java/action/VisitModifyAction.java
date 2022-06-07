package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitUpdateAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//m_id=dada&idx=5&content=�۽�����%3F&pwd=1234
		
		
		//1.���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter �޾ƿ���
		int idx  		= Integer.parseInt(request.getParameter("idx"));
		String m_id 	= request.getParameter("m_id");
		String content	= request.getParameter("content").replaceAll("\r\n", "<br>");
		String pwd		= request.getParameter("pwd");
		String ip 		= request.getRemoteAddr();
		
		//Vo�� ����, �����ڸ� �̿��ؼ�
		VisitVo vo = new VisitVo(idx, m_id, pwd, content, ip);
		
		int res = VisitDao.getInstance().update(vo);
		
		
		//forward
		response.sendRedirect("list_my.do?m_id="+m_id);
		
	}
}