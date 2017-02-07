package com.bitacademy.good;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class AddGoodService
 */

public class AddGoodService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
	    // 1000Mbyte이상 되는 이미지는 업로드 못하도록 설정
	    int maxSize  = 1024*1024*1000;        
	 
	    //1.이미지 파일 저장 경로를 String 타입 변수 savePath에 저장 저장경로는 프로젝트의 경로/WebContent/photo 
	    // 윈도우 탐색기에서 확인 하고 본인에게 맞도록 수정, 경로에 공백이나 한글이 있으면 파일 업로드 불가 이럴때는 워크 스페이스 폴더를 바꾸고 다시 할것
	    //String savePath = c:/bit_java/workspace/exam_20160727/WebContent/photo";
	 
	    try{
	    	
	    	//2.클라이언트가 선택한 이미지 파일을 1의 폴더로 업로드
	        //MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	        //3.물건의 이름을 리턴받아서 String 변수에 저장
	    	//  multi.getParameter("name")
	    	//4.물건의 가격을 리턴받아서 String 변수에 저장
	    	// multi.getParameter("price");
	    	//5.물건의 설명을 리턴받아서 String 변수에 저장
	    	//multi.getParameter("detail");
	    	//6.업로드한 파일의 정보를 File 타입 변수에 저장
	    	// multi.getFile("file");
	    	// 7. Good 객체 생성
	    	// 8. 7객체의 속성에 3~5까지의 변수를 저장
	    	//9.2에서 이미지 업로드가 성공했다면 6의 변수가 null 이 아님
	    	// if(6의변수!=null){
	    	 // 9.1 업로드한 파일의 이름을 7객체의 img 속성에 저장
	    	// 업로드한 파일의 이름은 6객체.getName()
	    	//  9.2 톰캣에서 실제로 실행하는 이미지 파일의 경로는 c:\bit_java\workspace\프로젝트\WebContent\photo가 아님
	    	 // 톰캣에서 실제로 실행하는 이미지 파일의 경로를 String 변수에 저장
	    	//  request.getSession().getServletContext().getRealPath("/photo");
	    	//9.3 업로드한 이미지 파일을 9.2의 폴더로 복사
	    	// FileUtils.copyFile(6의변수, new File(9.2변수+"/"+7객체.img));
	    	//}
	    	//10.GoodDAO.insertGood(7객체) 호출해서 데이터베이스에 물건 정보 저장
	    	//11.전체 물건 조회 페이지로 이동
	    	//// RequestDispatcher rd=request.getRequestDispatcher("GoodService?method=viewGoodList");
	 	   //   rd.forward(request,response);
		
	    	
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	 
	}

}
