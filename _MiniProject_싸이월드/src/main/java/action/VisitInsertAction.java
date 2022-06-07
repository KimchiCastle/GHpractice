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
		
		//1.Encoding 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받아오기
		String m_id		= request.getParameter("m_id");
		String content  = request.getParameter("content").replaceAll("\r\n", "<br>");
		String pwd		= request.getParameter("pwd");
		
		//3. request로부터 ip받아오기
		String ip = request.getRemoteAddr();
		
		//4. vo 객체 생성, 생성자를 통해 객체에 값 넣기.
		VisitVo vo = new VisitVo(m_id, pwd, content, ip);
		
		//5.Dao를 통해 DB에 값 넣기
		int res = VisitDao.getInstance().insert(vo);		
		
		
		//6. 추가, 수정, 삭제는 리다이렉트로
		response.sendRedirect("list_login.do");
	}
}