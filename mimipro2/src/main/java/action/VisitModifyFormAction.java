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
 * Servlet implementation class VisitModifyFormAction
 */
@WebServlet("/visit/modify_form.do")
public class VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.Encoding ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter�޾ƿ���
		int idx = Integer.parseInt(request.getParameter("idx")); 
		
		//3.�޾ƿ� �Ķ���ͷ� vo �޾ƿ���
		VisitVo vo = VisitDao.getInstance().selectListOne(idx);
		
		//4.DB�� ����Ǿ��ִ� <br>�±� \r\n���� ���� �� �� ����
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		vo.setContent(content);
		
		//5.ip ����
		vo.setIp(request.getRemoteAddr());
		
		
		//binding
		request.setAttribute("vo", vo);
		
		//forward
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
