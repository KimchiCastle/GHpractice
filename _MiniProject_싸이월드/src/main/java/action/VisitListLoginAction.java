package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list_login.do")
public class VisitListLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String m_id = request.getParameter("m_id");
		  
		HttpSession session = request.getSession();
		  
		session.setAttribute("m_id", m_id);
		 
		
		List<VisitVo> list = VisitDao.getInstance().selectList();
		
		//바인딩
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "../member/싸이월드_after_login.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}
}