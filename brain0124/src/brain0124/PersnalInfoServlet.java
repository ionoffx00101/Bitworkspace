package brain0124;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersnalInfoServlet
 */
@WebServlet("/PersnalInfoServlet")
public class PersnalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersnalInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalInfo obj = new PersonalInfo();
		obj.setName("hao");
		obj.setGender('F');
		obj.setAge(29);
		request.setAttribute("pinfo", obj);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerInfoView.jsp");
		dispatcher.forward(request, response);
	}

}
