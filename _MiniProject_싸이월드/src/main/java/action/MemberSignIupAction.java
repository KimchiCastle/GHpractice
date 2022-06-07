package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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

		//1encoding 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter
		String m_id = request.getParameter("m_id");
		String m_name = request.getParameter("m_name");
		String m_pwd = request.getParameter("m_pwd");
		String m_email = request.getParameter("m_email");
		
		MemberVo vo = new MemberVo(m_id, m_pwd, m_name, m_email);
		
		int res = MemberDao.getInstance().insert(vo);
		
		boolean bResult = false;
		JSONObject json = new JSONObject();
		
		//회원가입 성공시
		if(res==1) {
			
			bResult = true;
			
			json.put("result", bResult);
			
			String json_str = json.toJSONString();
			response.setContentType("text/json; charset=utf-8;");
			
			response.getWriter().print(json_str);
		
		//회원가입 실패시	
		}else {
			
			json.put("result", bResult);
			
			String json_str = json.toJSONString();
			response.setContentType("text/json; charset=utf-8;");
			
			response.getWriter().print(json_str);
		}
		
		//forward
		//response.sendRedirect("../visit/list.do");
	}
}