package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;

/**
 * Servlet implementation class VisitDeleteAction
 */
@WebServlet("/visit/delete.do")
public class VisitDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. encoding설정 
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받아오기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String m_id = request.getParameter("m_id");
		
		int res = VisitDao.getInstance().delete(idx);
		
		//forward
		response.sendRedirect("list_my.do?m_id="+m_id);
		
	}
}