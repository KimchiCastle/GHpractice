package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_email.do")
public class MemberCheckEmailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 인코딩설정
		request.setCharacterEncoding("UTF-8");
		
		//2.parameter 받기
		String m_email = request.getParameter("m_email");
		
		//3.m_id에 해당되는 회원정보 1건 가져오기
		MemberVo vo = MemberDao.getInstance().selectListOne(m_email);
		
		//클라이언트측에 m_id의 사용유무;
		boolean bResult = (vo == null); 
//		if(vo==null) {
//			bResult = true;
//		}else {
//			bResult = false;
//		}
		
		//5.결과 전송 데이터 생성(JSON)
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		
		String json_str = json.toJSONString(); // {"result" : true} or {"result" : false}
		
		
		//6. 전송. json이기 때문에 json타입인걸 알려야 한다.
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json_str);
		
	}
}