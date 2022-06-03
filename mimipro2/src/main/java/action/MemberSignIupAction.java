package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberSignIupAction
 */
@WebServlet("/member/join_insert.do")
public class MemberSignIupAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1encoding ¼³Á¤
		request.setCharacterEncoding("utf-8");
		
		//2.parameter
		String m_id = request.getParameter("m_id");
		String m_name = request.getParameter("m_name");
		String m_pwd = request.getParameter("m_pwd");
		String m_email = request.getParameter("m_email");
		
		MemberVo vo = new MemberVo(m_id, m_pwd, m_name, m_email);
		
		int res = MemberDao.getInstance().insert(vo);
		
		
		//forward
		response.sendRedirect("../visit/list.do");

	}

}
