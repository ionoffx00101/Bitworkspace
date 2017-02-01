

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


    private PrintWriter logfile; //�����Ҷ� �ʱ�ȭ
	public void init(ServletConfig config) throws ServletException {
		try
		{
			logfile = new PrintWriter(new FileWriter("C:\\data\\log.txt",true));
		} catch (IOException e)
		{
			throw new ServletException(e);
		}
	}
// ������ �ϴ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	// ��Ĺ�� ����ɶ� ������ �ϴ� ��
	public void destroy() {
		if(logfile!=null){ //�α� ������ ���� �ƴҶ�
			logfile.close(); // printwriter �� �ݾ���
		}
	}

}
