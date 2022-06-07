package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신 Encoding 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		System.out.println(m_id);
		
		//3. 받아온 parameter로 DB조회
		MemberVo member = MemberDao.getInstance().selectlogin(m_id);
		
		//4.결과값 json 객체 생성
		boolean bResult = false;
		JSONObject json = new JSONObject();
		
		//만약 vo에 null이 들어가면.. 로그인 실패
		if(member==null) {
			
			json.put("result", bResult);
			
			String json_str = json.toJSONString();
			
			response.setContentType("text/json; charset=utf-8;");
			response.getWriter().print(json_str);
			
		//아이디가 맞다면 비밀번호 확인	
		}else {
			
			//비밀번호가 맞다면 로그인 성공!
			if(member.getM_pwd().equals(m_pwd)) {
				
				bResult = true;
				
				json.put("result", bResult);
				
				String json_str = json.toJSONString();
				
				//session으로 로그인 회원 정보넘기기
				HttpSession session = request.getSession();
				
				session.setAttribute("member", member);
				
				response.setContentType("text/json; charset=utf-8;");
				response.getWriter().print(json_str);
				
				
			//비밀번호가 틀리면 로그인 실패
			}else {
				
				json.put("result", bResult);
				
				String json_str = json.toJSONString();
				
				response.setContentType("text/json; charset=utf-8;");
				response.getWriter().print(json_str);
				
			}
		}
	}
}