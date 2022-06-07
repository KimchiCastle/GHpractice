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
		
		//1.���� Encoding ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter �ޱ�
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		System.out.println(m_id);
		
		//3. �޾ƿ� parameter�� DB��ȸ
		MemberVo member = MemberDao.getInstance().selectlogin(m_id);
		
		//4.����� json ��ü ����
		boolean bResult = false;
		JSONObject json = new JSONObject();
		
		//���� vo�� null�� ����.. �α��� ����
		if(member==null) {
			
			json.put("result", bResult);
			
			String json_str = json.toJSONString();
			
			response.setContentType("text/json; charset=utf-8;");
			response.getWriter().print(json_str);
			
		//���̵� �´ٸ� ��й�ȣ Ȯ��	
		}else {
			
			//��й�ȣ�� �´ٸ� �α��� ����!
			if(member.getM_pwd().equals(m_pwd)) {
				
				bResult = true;
				
				json.put("result", bResult);
				
				String json_str = json.toJSONString();
				
				//session���� �α��� ȸ�� �����ѱ��
				HttpSession session = request.getSession();
				
				session.setAttribute("member", member);
				
				response.setContentType("text/json; charset=utf-8;");
				response.getWriter().print(json_str);
				
				
			//��й�ȣ�� Ʋ���� �α��� ����
			}else {
				
				json.put("result", bResult);
				
				String json_str = json.toJSONString();
				
				response.setContentType("text/json; charset=utf-8;");
				response.getWriter().print(json_str);
				
			}
		}
	}
}