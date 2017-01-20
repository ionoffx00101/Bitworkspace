package kr.bit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAdderServlet
 */
@WebServlet("/NewAdderServlet")
public class NewAdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAdderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String str1 = request.getParameter("num1");
			String str2 = request.getParameter("num2");
			
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			
			int result = num1+num2;
			
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<Html>");
			out.println("<head>");
			out.println("<title>µ¡¼À ÇÁ·Î±×·¥</title>");
			out.println("</head>");
			out.println("<body>");
			out.printf("%d +%d = %d",num1,num2,result);
			out.println("</body>");
			out.println("</html>");
			
		}catch(NumberFormatException e){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DataErrorServlet");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
