package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListMyAction
 */
@WebServlet("/visit/list_my.do")
public class VisitListMyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//list_my.do?m_id=wow
		
		//1.encoding ����
		request.setCharacterEncoding("utf-8");
		
		//2. ���޹��� Parameter ����
		String m_id = request.getParameter("m_id");
		
		
		//3.List ��ü ����
		List<VisitVo> list = VisitDao.getInstance().selectListOne(m_id);
		
		//4.binding
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "���̿���_list_my.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
