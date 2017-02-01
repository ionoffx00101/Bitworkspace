

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibonacciServlet
 */
@WebServlet("/FibonacciServlet")
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FibonacciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	//
	private BigInteger arr[];
	
	public void init(){
		arr = new BigInteger[100];
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("1");
		for(int cnt=2;cnt<arr.length; cnt++){
			arr[cnt] = arr[cnt-2].add(arr[cnt-1]);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("num");
		int num= Integer.parseInt(str);
		
		if(num>100){
			num=100;
		}
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><titie>pibonacci</title></head>");
		out.println("<body>");
		for (int cnt = 0; cnt < num; cnt++)
		{
			out.println(arr[cnt]+" ");
		}
		out.println("</body>");
		out.println("</html>");
	}


}
