package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String value1 = request.getParameter("su1");
		String value2 = request.getParameter("su2");
	
		//클라이언트에서 넘어온 값 정수형으로 변환
		int su1 = Integer.parseInt(value1);
		int su2 = Integer.parseInt(value2);

		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>calc</title></head>");
		out.println("<body>");
		out.println(":::계산결과:::<br>");
		out.printf("%d + %d = %d <br>",su1, su2, su1+su2);
		out.printf("%d - %d = %d <br>",su1, su2, (su1-su2));
		out.printf("%d * %d = %d <br>",su1, su2, (su1*su2));
		out.printf("%d / %d = %d <br>",su1, su2, (su1/su2));
		out.printf("%d %% %d = %d <br>",su1, su2, (su1%su2));
		out.println("<a href='calc.html'>다시하기</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
