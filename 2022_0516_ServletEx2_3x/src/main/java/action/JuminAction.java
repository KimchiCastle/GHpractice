package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Jumin2;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jumin = request.getParameter("jumin");
		
		Jumin2 check = new Jumin2();
		
		check.setJumin_no(jumin);
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>주민</title></head>");
		out.print("<body>");
		out.print("<table border= '1'><tr>");
		out.printf("<th>주민번호</th><td>%s</td></tr>",jumin);
		out.printf("<tr><th>출생년도</th><td>%s %s</td></tr>",check.getYear(), check.getGanji());
		out.printf("<tr><th>나이</th><td>%s</td></tr>",check.getAge());
		out.printf("<tr><th>성별</th><td>%s</td></tr>",check.getGender());
		out.printf("<tr><th>띠</th><td>%s</td></tr>",check.getTti());
		out.printf("<tr><th>출생계절</th><td>%s</td></tr>",check.getSeason());
		out.printf("<tr><th>출생지역</th><td>%s</td></tr>",check.getLocal());
		out.printf("<tr><th colspan='2'><a href='jumin.html'>다시하기</a></tr>",check.getLocal());
		
		
		
		out.print("</body>");
		out.print("</html>");
		
		
		
	}

}
