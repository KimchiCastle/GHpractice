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
		
		//1. ���ڵ�����
		request.setCharacterEncoding("UTF-8");
		
		//2.parameter �ޱ�
		String m_email = request.getParameter("m_email");
		
		//3.m_id�� �ش�Ǵ� ȸ������ 1�� ��������
		MemberVo vo = MemberDao.getInstance().selectListOne(m_email);
		
		//Ŭ���̾�Ʈ���� m_id�� �������;
		boolean bResult = (vo == null); 
//		if(vo==null) {
//			bResult = true;
//		}else {
//			bResult = false;
//		}
		
		//5.��� ���� ������ ����(JSON)
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		
		String json_str = json.toJSONString(); // {"result" : true} or {"result" : false}
		
		
		//6. ����. json�̱� ������ jsonŸ���ΰ� �˷��� �Ѵ�.
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json_str);
		
	}
}