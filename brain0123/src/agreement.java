import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class agreement
 */
@WebServlet("/agreement")
public class agreement extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public agreement()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub

	}

	////////////
	// �ʱ�ȭ�ϸ鼭 ���� ���� ������ ���� ���� ������ �������ұ�

	public void init()
	{
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//������ �����
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><titie>agreement</title></head>");
		out.println("<body>");
		out.println("<h2>���</h2>");
		// ���� �б�
		BufferedReader reader = null;
		try
		{
			String filePath = getServletContext().getRealPath("/WEB-INF/agreement.txt");
			reader = new BufferedReader(new FileReader(filePath));
			while (true)
			{
				String str = reader.readLine();
				if (str == null)
				{
					break;
				}
				out.println(str+ "<br>");
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}

		out.println("</body>");
		out.println("</html>");
	}

}
