

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.log.ReliableLog.LogFile;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/GreetingServlet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    private PrintWriter logfile; //시작할때 초기화
	public void init(ServletConfig config) throws ServletException {
		try
		{
			logfile = new PrintWriter(new FileWriter("C:\\data\\log.txt",true));
		} catch (IOException e)
		{
			throw new ServletException(e);
		}
	}
// 서블릿이 하는짓
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	// 톰캣이 종료될때 서블릿이 하는 것
	public void destroy() {
		if(logfile!=null){ //로그 파일이 널이 아닐때
			logfile.close(); // printwriter 를 닫아줌
		}
	}

}
